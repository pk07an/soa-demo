package com.meila.soa.proxy.service.impl.erp;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alibaba.dubbo.rpc.RpcContext;
import com.meila.common.bean.utils.BeanMapper;
import com.meila.oms.soa.api.ERPPurchaseNoteService;
import com.meila.oms.soa.api.model.request.SyncPurchaseNoteRequest;
import com.meila.oms.soa.api.model.response.SyncPurchaseNoteResponse;
import com.meila.soa.proxy.model.erp.ErpPurchaseNoteSyncRequestData;
import com.meila.soa.proxy.model.erp.ErpPurchaseNoteSyncResponseData;
import com.meila.soa.proxy.model.erp.ErpResponseHead;
import com.meila.soa.proxy.utils.XMLUtils;

/**
 * 
 ************************************************************
 * @类名 : ErpPurchaseNoteSyncServiceImpl.java
 *
 * @DESCRIPTION : erp采购单同步服务
 * @AUTHOR :  abner
 * @DATE :  2016年1月19日
 ************************************************************
 */
@Service
public class ErpPurchaseNoteSyncServiceImpl extends ErpRequestBaseServiceImpl{
	
	private final Logger logger = LoggerFactory.getLogger(getClass());
	@Autowired
	private ERPPurchaseNoteService purchaseNoteSyncService;
	/**
	 * 
	 *
	 * 功能描述：
	 * 
	 * @param xmlData
	 * @return String
	 *
	 */
	public String erpPucharseNoteSync(String xmlData){
		logger.info("ERP采购单信息同步处理开始..请求参数:"+xmlData);
		ErpPurchaseNoteSyncRequestData erpRequestData = null;
		String returnStr="";
		try{
			//解析xml报文
			erpRequestData = XMLUtils.converyToJavaBean(xmlData, ErpPurchaseNoteSyncRequestData.class);
			if( null != erpRequestData){
				//属性复制
				SyncPurchaseNoteRequest request = BeanMapper.map(erpRequestData.getBody(), SyncPurchaseNoteRequest.class);
				//调用dubbo服务
				SyncPurchaseNoteResponse dubboResp = purchaseNoteSyncService.sync(request);
				
				if(dubboResp == null){
					logger.error("erp采购单同步,调用dubbo服务返回对象为空");
					returnStr =  processByException("PO_SYNC", "服务调用失败",erpRequestData.getHead().getBatch_no());
				}else{
					if(0 == dubboResp.getCode()){ //业务处理成功
						if(null == dubboResp.getDataList() || dubboResp.getDataList().isEmpty()){
							logger.info("erp采购单同步,调用dubbo服务返回成功");
							returnStr = processBySuccess("PO_SYNC",erpRequestData.getHead().getBatch_no());
						}else{ //部分成功
							logger.info("erp采购单同步,调用dubbo服务返回部分成功");
							returnStr = processPartSuccess(dubboResp,erpRequestData.getHead().getBatch_no());
						}
					}else{ //业务处理失败
						logger.error("erp采购单同步,调用dubbo服务返回失败");
						returnStr = processByException("PO_SYNC", "业务处理失败.",erpRequestData.getHead().getBatch_no());
					}
				}
				
				
			}
		}catch(Exception e){
			logger.error("处理erp采购单同步出现异常:",e);
			returnStr = processByException("PO_SYNC", "报文处理失败",erpRequestData.getHead().getBatch_no());
		}finally{
			String serverIP = RpcContext.getContext().getRemoteHost(); // 获取当前线程最后一次调用的提供方IP地址
			logger.info("本次erp采购单同步服务处理的服务中心地址是:{}",serverIP);
		}

		return returnStr;
	}
	
	/**
	 * 
	 *
	 * 功能描述：
	 * 
	 * @return String
	 *
	 */
	private String processPartSuccess(SyncPurchaseNoteResponse dubboResp,String batch_no){
		ErpPurchaseNoteSyncResponseData respData = new ErpPurchaseNoteSyncResponseData();
		ErpResponseHead responseHead = new ErpResponseHead();
        responseHead.setOp_type("SKU_SYNC");
        responseHead.setSend_time(new Date());
        responseHead.setOp_result("PART");
        responseHead.setBatch_no(batch_no);
        respData.setHead(responseHead);
        ErpPurchaseNoteSyncResponseData.PurchaseRespBody body = BeanMapper.map(dubboResp, ErpPurchaseNoteSyncResponseData.PurchaseRespBody.class);
        if(body == null){ //如果属性复制失败,则使用for循环复制
        	body = new ErpPurchaseNoteSyncResponseData.PurchaseRespBody();
        	logger.error("使用beanMapper属性复制失败..");
        	List<ErpPurchaseNoteSyncResponseData.PurchaseNoteRespData> dataItem = new ArrayList<>();
        	for(SyncPurchaseNoteResponse.Data data : dubboResp.getDataList()){
        		ErpPurchaseNoteSyncResponseData.PurchaseNoteRespData itemData = new ErpPurchaseNoteSyncResponseData.PurchaseNoteRespData();
        		itemData.setPurchase_code(data.getErpPurchaseCode());
        		itemData.setError_code(data.getErrorCode());
        		itemData.setError_msg(data.getErrorMsg());
        		dataItem.add(itemData);
        	}
        	body.setDataList(dataItem);
        }
        respData.setBody(body);
        try{
        	return XMLUtils.convertToXml(respData);
        }catch(Exception e){
        	logger.error("处理返回部分成功xml转换失败",e);
            return null;
        }
	}
}
