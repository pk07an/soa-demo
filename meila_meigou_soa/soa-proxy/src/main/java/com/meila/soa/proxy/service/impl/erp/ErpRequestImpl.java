package com.meila.soa.proxy.service.impl.erp;

import java.lang.reflect.Method;
import java.util.Date;
import java.util.UUID;

import javax.jws.WebService;
import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang3.StringUtils;
import org.apache.cxf.message.Message;
import org.apache.cxf.phase.PhaseInterceptorChain;
import org.apache.cxf.transport.http.AbstractHTTPDestination;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;

import com.meila.dubbo.base.TidManager;
import com.meila.soa.proxy.dal.dao.ErpRequestLog.ErpRequestLogEntityMapper;
import com.meila.soa.proxy.dal.dao.ErpResponseLog.ErpResponseLogEntityMapper;
import com.meila.soa.proxy.dal.entity.ErpRequestLog.ErpRequestLogEntity;
import com.meila.soa.proxy.dal.entity.ErpResponseLog.ErpResponseLogEntity;
import com.meila.soa.proxy.dal.entity.OmsCustomSecretConfig.OmsCustomSecretConfigEntity;
import com.meila.soa.proxy.model.erp.BaseErpRequest;
import com.meila.soa.proxy.model.erp.BaseErpResponse;
import com.meila.soa.proxy.model.erp.ErpOpTypeEnum;
import com.meila.soa.proxy.model.erp.ErpResponseHead;
import com.meila.soa.proxy.service.erp.IerpRequest;
import com.meila.soa.proxy.service.secretconfig.OmsCustomerSecretConfigService;
import com.meila.soa.proxy.utils.AesUtils;
import com.meila.soa.proxy.utils.ApplicationContextUtil;
import com.meila.soa.proxy.utils.ServiceMapHolder;
import com.meila.soa.proxy.utils.XMLUtils;

/**
 * 
 ************************************************************
 * @类名 : ErpRequestImpl.java
 *
 * @DESCRIPTION : 处理erp请求的实现类
 * @AUTHOR : abner
 * @DATE : 2016年1月5日
 ************************************************************
 */
@WebService(targetNamespace="http://erp.service.proxy.soa.meila.com/",endpointInterface="com.meila.soa.proxy.service.erp.IerpRequest")
public class ErpRequestImpl implements IerpRequest {

	private final Logger logger = LoggerFactory.getLogger(getClass());
    private String charset="utf-8";
    private String customCode ="erp";
    @Autowired
    private OmsCustomerSecretConfigService omsKeyConfigService;
    @Autowired
    private ErpRequestLogEntityMapper erpRequestLogEntityMapper;
    @Autowired
    private ErpResponseLogEntityMapper erpResponseLogEntityMapper;
    
    @Value("${dubbo.serviceName}")
    private String dubboServiceName;

    @Override
    public String erpRequestDeal(String xmlData) {
    	TidManager.setTid(UUID.randomUUID().toString().replaceAll("-", ""));
/*    	TidManager.setSourceFrom(dubboServiceName);*/
        long insertResult = -1L;
        String clientIp = "";
        
        //获取clientip
        try{
	        Message message = PhaseInterceptorChain.getCurrentMessage();
	        HttpServletRequest wsRequest = (HttpServletRequest) message.get(AbstractHTTPDestination.HTTP_REQUEST);
	        clientIp = wsRequest.getRemoteAddr();
        }catch(Exception e){
        	logger.info("获取客户端ip失败:",e);
        }
        
        OmsCustomSecretConfigEntity omsCustomSecretConfig=omsKeyConfigService.queryKeyConfig(customCode);
        String password=omsCustomSecretConfig.getCustomSecret();
        String returnStr="";
        
        if (StringUtils.isBlank(xmlData)) { // 请求数据为空
            return createFailResponseStr(null, null, "请求数据为空",password,insertResult);
        }
        logger.info("{}发起webservice请求,请求dubbo的服务名{},请求的加密数据:{}",clientIp,dubboServiceName, xmlData);
        String decryptReqStr = "";
        BaseErpRequest request = new BaseErpRequest();
       

        try {
            decryptReqStr = AesUtils.aesBase64Decrypt(xmlData, password, charset);
        } catch (Exception e) {
            logger.error("对请求报文进行解密失败:", e);
            returnStr = createFailResponseStr(null, null, "解密失败",password,insertResult);
            TidManager.clear();
            return returnStr;
        }
        
        try {
            request = XMLUtils.converyToJavaBean(decryptReqStr, BaseErpRequest.class);
            String opType = request.getHead().getOp_type();
            ErpOpTypeEnum optEnum = ErpOpTypeEnum.getOpTypeEnumByCode(opType);
          //登记请求日志表
            insertResult = insertIntoErpRequestLog(opType, decryptReqStr, "erp请求");
            if(null == optEnum){
                logger.error("根据code:{}找不到对应的枚举值",opType);
                returnStr = createFailResponseStr(request.getHead().getOp_type(), request.getHead().getBatch_no(), "找对不到对应的服务来处理本次请求",password,insertResult);
                TidManager.clear();
                return returnStr;
            }
            
            String serviceName = ServiceMapHolder.getServiceProvider(optEnum.getMethod()); // 获取服务的名字
            if (StringUtils.isBlank(serviceName)) {
                returnStr = createFailResponseStr(request.getHead().getOp_type(), request.getHead().getBatch_no(), "找对不到对应的服务来处理本次请求",password,insertResult);
                TidManager.clear();
                return returnStr;
            }
            Object provider = ApplicationContextUtil.getBeanByName(serviceName);
            Method method = provider.getClass().getMethod(optEnum.getMethod(), String.class);
            String response = (String)method.invoke(provider, decryptReqStr);
            if(response == null){
                returnStr = createFailResponseStr(null, null, "报文处理失败",password,insertResult);
                TidManager.clear();
                return returnStr;
            }
            String encryptStr = AesUtils.aesEncryptAndBase64(response, password, charset);
            logger.info("业务处理成功,返回xml:" + response);
            logger.info("返回报文加密后:" + encryptStr);
            if(insertResult != -1){
            	insertIntoErpResponseLog(insertResult, opType, response, "响应erp");
            }
            TidManager.clear();
            return encryptStr;
        } catch (Exception e) {
            logger.error("报文处理失败:", e);
            returnStr = createFailResponseStr(null, null, "报文处理失败",password,insertResult);
            TidManager.clear();
            return returnStr;
        }
    }

    /**
     * 创建失败的返回字符串
     * @param op_type
     * @param batch_no
     * @param msg
     * @param password
     * @param isWriteLong 是否写入日志。-1不写入,其他写入应答日志
     * @return
     */
    private String createFailResponseStr(String op_type, String batch_no, String msg,String password,Long isWriteLong) {
        String returnStr = "";
        BaseErpResponse response = new BaseErpResponse();
        ErpResponseHead head = new ErpResponseHead();
        head.setBatch_no(batch_no);
        head.setOp_type(op_type);
        head.setSend_time(new Date());
        head.setOp_result("FAIL");
        head.setError_code("E00001");
        head.setError_msg(msg);
        response.setHead(head);

        try {
            returnStr = XMLUtils.convertToXml(response);
        } catch (Exception e) {
            logger.error("构建返回的应答报文失败:{}", e);
            return null;
        }
        try {
            String encryptStr = AesUtils.aesEncryptAndBase64(returnStr, password, charset);
            logger.info("加密返回后的报文"+encryptStr);
            if(isWriteLong != -1L){
            	insertIntoErpResponseLog(isWriteLong, op_type, returnStr, "响应erp");
            }
            return encryptStr;
        } catch (Exception e) {
            logger.error("加密返回报文失败：", e);
            return null;
        }
    }
    
    /**
     * 登记到erp的请求日志表
     * @param reqType
     * @param reqDetail
     * @param remark
     * @return
     */
    private long insertIntoErpRequestLog(String reqType,String reqDetail,String remark){
    	long result = -1L;
    	ErpRequestLogEntity logEntity = new ErpRequestLogEntity();
    	logEntity.setErpReqType(reqType);
    	logEntity.setErpReqDetail(reqDetail);
    	logEntity.setErpReqRemark(remark);
    	logEntity.setCreateTime(new Date());
    	logEntity.setArchive(new Byte("0"));
    	try{
    		int i = erpRequestLogEntityMapper.insertSelective(logEntity);
    		Long l = logEntity.getErpReqId();
    		result = logEntity.getErpReqId();
    	}catch(Exception e){
    		logger.error("登记erp请求日志表异常:",e);
    	}
    	return result;
    } 
    
    /**
     * 登记erp响应日志表
     * @param reqId
     * @param reqType
     * @param responseStr
     * @param remark
     */
    private void insertIntoErpResponseLog(Long reqId,String reqType,String responseStr,String remark){
    	ErpResponseLogEntity respLog = new ErpResponseLogEntity();
    	respLog.setErpReqId(reqId);
    	respLog.setErpReqType(reqType);
    	respLog.setErpRespDetail(responseStr);
    	respLog.setErpRespRemark(remark);
    	respLog.setCreateTime(new Date());
    	respLog.setArchive(new Byte("0"));
    	try{
    		erpResponseLogEntityMapper.insertSelective(respLog);
    	}catch(Exception e){
    		logger.error("登记erp响应日志表失败,请求id:{},相应报文:{}",reqId,responseStr);
    		logger.error("异常信息如下:",e);
    	}
    }
}
