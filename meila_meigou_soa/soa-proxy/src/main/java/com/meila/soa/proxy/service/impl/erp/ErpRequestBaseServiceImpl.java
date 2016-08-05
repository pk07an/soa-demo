/**
 * 
 */
package com.meila.soa.proxy.service.impl.erp;

import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.meila.soa.proxy.model.erp.BaseErpResponse;
import com.meila.soa.proxy.model.erp.ErpResponseHead;
import com.meila.soa.proxy.utils.XMLUtils;

/**
 ************************************************************
 * @类名 : ErpRequestBaseServiceImpl.java
 *
 * @DESCRIPTION : erp请求的基本服务
 * @AUTHOR :  meila-x
 * @DATE :  2016年1月19日
 ************************************************************
 */
public class ErpRequestBaseServiceImpl {
	private final Logger logger = LoggerFactory.getLogger(getClass());
    /**
     * 
     *
     * 功能描述：成功处理
     * 
     * @return String
     *
     */
    public String processBySuccess(String op_type,String batch_no){
    	BaseErpResponse response = new BaseErpResponse();
        ErpResponseHead responseHead = new ErpResponseHead();
        responseHead.setOp_type(op_type);
        responseHead.setSend_time(new Date());
        responseHead.setOp_result("SUCCESS");
        responseHead.setBatch_no(batch_no);
        response.setHead(responseHead);
        
		try {
            return XMLUtils.convertToXml(response);
        } catch (Exception e) {
           return null;
        }
    }
    
    /**
     * 异常处理
     * @param exceptionMesage 异常信息
     * @return
     */
    public String processByException(String opType,String exceptionMesage,String batch_no){
    	BaseErpResponse response = new BaseErpResponse();
        ErpResponseHead responseHead = new ErpResponseHead();
        responseHead.setOp_type(opType);
        responseHead.setSend_time(new Date());
        responseHead.setOp_result("FAIL");
        responseHead.setBatch_no(batch_no);
        responseHead.setError_code("S0001");
        responseHead.setError_msg(exceptionMesage);
        response.setHead(responseHead);
		try {
            return XMLUtils.convertToXml(response);
        } catch (Exception e) {
        	logger.error("处理返回异常消息:{"+exceptionMesage+"},xml转换失败",e);
           return null;
        }
    }
    
}
