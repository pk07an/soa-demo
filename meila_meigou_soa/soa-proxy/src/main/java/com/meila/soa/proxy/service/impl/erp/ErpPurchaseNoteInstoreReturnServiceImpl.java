/**
 * 
 */
package com.meila.soa.proxy.service.impl.erp;

import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alibaba.dubbo.rpc.RpcContext;
import com.meila.common.bean.utils.BeanMapper;
import com.meila.oms.soa.api.ERPPurchaseNoteService;
import com.meila.oms.soa.api.model.request.InstoreReturnPurchaseNoteRequest;
import com.meila.oms.soa.api.model.response.InstoreReturnPurchaseNoteResponse;
import com.meila.soa.proxy.model.erp.ErpPurchaseNoteStoreSyncRespData;
import com.meila.soa.proxy.model.erp.ErpPurchaseStoreResultReqData;
import com.meila.soa.proxy.model.erp.ErpPurchaseStoreResultRespData;
import com.meila.soa.proxy.model.erp.ErpResponseHead;
import com.meila.soa.proxy.utils.XMLUtils;

/**
 ************************************************************
 * @类名 : ErpPurchaseNoteInstoreReturnServiceImpl.java
 *
 * @DESCRIPTION : 采购单入库结果回传,erp将处理成功的采购单回传给oms
 * @AUTHOR : abner
 * @DATE : 2016年1月20日
 ************************************************************
 */
@Service
public class ErpPurchaseNoteInstoreReturnServiceImpl extends
		ErpRequestBaseServiceImpl {
	@Autowired
	private ERPPurchaseNoteService purchaseNoteSyncService;
	private final Logger logger = LoggerFactory.getLogger(getClass());

	/**
	 * 
	 *
	 * 功能描述：采购单入库结果回传处理
	 * 
	 * @param xmlData
	 *            请求报文
	 * @return String 应答报文转换成String
	 *
	 */
	public String erpPurchaseNoteInstorageReturn(String xmlData) {
		logger.info("erp入库结果回传处理开始..请求报文:" + xmlData);
		ErpPurchaseStoreResultReqData requestData = null;
		try {
			requestData = XMLUtils.converyToJavaBean(xmlData,
					ErpPurchaseStoreResultReqData.class);
			InstoreReturnPurchaseNoteRequest dubboReq = BeanMapper.map(
					requestData.getBody(),
					InstoreReturnPurchaseNoteRequest.class);
			// 调用dubbo服务
			InstoreReturnPurchaseNoteResponse dubboResp = purchaseNoteSyncService
					.instoreReturn(dubboReq);
			
			if (null == dubboResp) {
				logger.error("erp采购单入库同步结果回传,调用dubbo服务返回对象为空");
				return processByException("PO_INSTORE_RETURN", "服务调用失败",
						requestData.getHead().getBatch_no());
			}
			if (0 == dubboResp.getCode()) { // 处理成功
				if(null == dubboResp.getDataList() || dubboResp.getDataList().isEmpty()){
					logger.info("erp采购单入库同步结果回传,调用dubbo服务返回成功");
					return processBySuccess("PO_INSTORE_RETURN",requestData.getHead().getBatch_no());
				}else{
					logger.info("erp采购单同步,调用dubbo服务返回部分成功");
					return processByPartSuccess(dubboResp,requestData.getHead().getBatch_no());
				}
			}else{
				logger.error("erp采购单入库同步结果回传,调用dubbo服务返回失败");
				 return processByException("PO_INSTORE_RETURN", "报文处理失败",requestData.getHead().getBatch_no());
			}
		} catch (Exception e) {
			if (null == requestData) {
				logger.error("erp采购单入库同步结果回传报文处理,xml转换失败:", e);
				return processByException("PO_INSTORE_RETURN", "报文处理失败", null);
			} else {
				logger.error("erp采购单入库同步结果回传请求处理失败:", e);
				return processByException("PO_INSTORE_RETURN", "交易请求处理失败",
						requestData == null ? null : requestData.getHead()
								.getBatch_no());
			}
		}finally{
			String serverIP = RpcContext.getContext().getRemoteHost(); // 获取当前线程最后一次调用的提供方IP地址
			logger.info("本次erp采购单入库同步服务处理的服务中心地址是:{}",serverIP);
		}
	}

	/**
	 * 
	 *
	 * 功能描述：处理部分成功
	 * 
	 * @param response
	 * @param batch_no
	 * @return String
	 *
	 */
	private String processByPartSuccess(
			InstoreReturnPurchaseNoteResponse response, String batch_no) {
		ErpPurchaseStoreResultRespData resp = new ErpPurchaseStoreResultRespData();
		ErpResponseHead head = new ErpResponseHead();
		head.setOp_type("PO_INSTORE_RETURN");
		head.setBatch_no(batch_no);
		head.setSend_time(new Date());
		head.setOp_result("PART");
		resp.setHead(head);
		ErpPurchaseStoreResultRespData.PurchaseStoreResultBody body = BeanMapper
				.map(response,
						ErpPurchaseStoreResultRespData.PurchaseStoreResultBody.class);
		resp.setBody(body);
		try{
			return XMLUtils.convertToXml(resp);
		}catch(Exception e){
			logger.error("处理返回部分成功xml转换失败",e);
            return null;
		}
	}
}
