/**
 * 
 */
package com.meila.soa.proxy.service.impl.erp;

import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.alibaba.dubbo.rpc.RpcContext;
import com.meila.common.bean.utils.BeanMapper;
import com.meila.oms.soa.api.ERPPurchaseNoteService;
import com.meila.oms.soa.api.model.request.InstorePurchaseNoteRequest;
import com.meila.oms.soa.api.model.response.InstorePurchaseNoteResponse;
import com.meila.soa.proxy.model.erp.BaseErpRequest;
import com.meila.soa.proxy.model.erp.ErpPurchaseNoteStoreSyncRespData;
import com.meila.soa.proxy.model.erp.ErpRequestHead;
import com.meila.soa.proxy.model.erp.ErpResponseHead;
import com.meila.soa.proxy.utils.XMLUtils;

/**
 ************************************************************
 * @类名 : ErpPurchaseNoteInstoreSync.java
 *
 * @DESCRIPTION : erp采购单入库同步
 * @AUTHOR :  abner
 * @DATE :  2016年1月20日
 ************************************************************
 */
@Service
public class ErpPurchaseNoteInstoreSyncServiceImpl extends ErpRequestBaseServiceImpl {
	private final Logger logger = LoggerFactory.getLogger(getClass());
	@Autowired
	private ERPPurchaseNoteService purchaseNoteSyncService;
	@Value("${erp.purchaseNote.instore.size}")
	private String size;
	/**
	 * 
	 *
	 * 功能描述：采购单入库同步通知处理
	 * 
	 * @param xmlData
	 * @return String
	 *
	 */
	public String erpPurchaseNoteInstorage(String xmlData){
		logger.info("erp采购单入库同步处理开始..请求参数:"+xmlData);
		BaseErpRequest baseReq = null;
		String retStr = "";
		try{
			baseReq = XMLUtils.converyToJavaBean(xmlData, BaseErpRequest.class);
			ErpRequestHead reqHead = baseReq.getHead();
			InstorePurchaseNoteRequest dubboReq = new InstorePurchaseNoteRequest();
			dubboReq.setSize(Integer.valueOf(size));
			//发送dubbo服务
			InstorePurchaseNoteResponse dubboResp = purchaseNoteSyncService.instore(dubboReq);
			
			if(dubboResp == null){
				logger.error("erp采购单入库同步,调用dubbo服务返回对象为空");
				retStr = processByException("PO_INSTORE", "服务调用失败",reqHead.getBatch_no());
			}else{
				if(0 == dubboResp.getCode()){//处理成功
					retStr = processBySuccess(dubboResp,reqHead.getBatch_no());
				}else{//业务处理失败
					logger.error("erp采购单入库同步,调用dubbo服务返回失败");
					retStr = processByException("PO_INSTORE", "业务处理失败.",reqHead.getBatch_no());
				}
			}
			
		}catch(Exception e){
			logger.error("处理erp采购单入库同步出现异常:",e);
			retStr = processByException("PO_INSTORE", "报文处理失败",baseReq == null?null:baseReq.getHead().getBatch_no());
		}finally{
			String serverIP = RpcContext.getContext().getRemoteHost(); // 获取当前线程最后一次调用的提供方IP地址
			logger.info("本次erp采购单入库同步服务处理的服务中心地址是:{}",serverIP);
		}
		return retStr;
	}

	/**
	 * 
	 *
	 * 功能描述：处理成功返回
	 * 
	 * @param op_type
	 * @param dubboResp
	 * @return String
	 *
	 */
	private String processBySuccess(InstorePurchaseNoteResponse dubboResp,String batch_no){
		ErpPurchaseNoteStoreSyncRespData respData = new ErpPurchaseNoteStoreSyncRespData();
		ErpPurchaseNoteStoreSyncRespData.PurchaseStoreBody body =  null;
		ErpResponseHead head = new ErpResponseHead();
		head.setBatch_no(batch_no);
		head.setOp_type("PO_INSTORE");
		head.setSend_time(new Date());
		respData.setHead(head);
		if(dubboResp.getDataList() == null || dubboResp.getDataList().isEmpty()||
				dubboResp.getDataList().size() < Integer.valueOf(size)){ //数据已经完成
			head.setIs_complete(1);
		}else{
			head.setIs_complete(0);
		}
		body =  BeanMapper.map(dubboResp, ErpPurchaseNoteStoreSyncRespData.PurchaseStoreBody.class);
		respData.setBody(body);
		try{
			return XMLUtils.convertToXml(respData);
		}catch(Exception e){
			logger.error("erp采购单入库同步成功xml转换失败",e);
            return null;
		}
	}
}
