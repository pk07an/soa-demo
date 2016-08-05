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
import com.meila.oms.soa.api.ErpOrderService;
import com.meila.oms.soa.api.model.request.SyncReturnOrderRequest;
import com.meila.oms.soa.api.model.response.SyncReturnOrderResponse;
import com.meila.soa.proxy.model.erp.ErpOrderPackageDeliveryResultReqData;
import com.meila.soa.proxy.model.erp.ErpOrderPackageDeliveryResultRespData;
import com.meila.soa.proxy.model.erp.ErpResponseHead;
import com.meila.soa.proxy.utils.XMLUtils;

/**
 ************************************************************
 * @类名 : ErpOrderPackageSyncResultSerivceImpl.java
 *
 * @DESCRIPTION : 处理erp的销售订单结果回传请求
 * @AUTHOR : abner
 * @DATE : 2016年1月25日
 ************************************************************
 */
@Service
public class ErpOrderPackageSyncResultSerivceImpl extends
		ErpRequestBaseServiceImpl {
	private final Logger logger = LoggerFactory.getLogger(getClass());
	@Autowired
	private ErpOrderService erpOrderService;

	/**
	 * 
	 *
	 * 功能描述：销售出库单同步结果回传
	 * 
	 * @param xmlData
	 * @return String
	 *
	 */
	public String erpOrderPackageSyncReturn(String xmlData) {
		logger.info("erp销售订单出库结果回传处理开始..请求报文:" + xmlData);
		ErpOrderPackageDeliveryResultReqData requestData = null;
		try {
			requestData = XMLUtils.converyToJavaBean(xmlData,
					ErpOrderPackageDeliveryResultReqData.class);
			SyncReturnOrderRequest dubboReq = BeanMapper.map(
					requestData.getBody(), SyncReturnOrderRequest.class);
			SyncReturnOrderResponse dubboResp = erpOrderService
					.syncReturn(dubboReq);
			
			
			if (null == dubboResp) {
				logger.error("erp销售出库单同步回调,调用dubbo服务返回对象为空");
				return processByException("ORDER_SYNC_RETURN", "服务调用失败",
						requestData.getHead().getBatch_no());
			}
			if (0 == dubboResp.getCode()) {// 处理成功
				if (null == dubboResp.getDataList()
						|| dubboResp.getDataList().isEmpty()) {
					logger.info("erp销售出库单同步回传,调用dubbo服务返回成功");
					return processBySuccess("ORDER_SYNC_RETURN", requestData
							.getHead().getBatch_no());
				} else { // 部分成功
					logger.info("erp销售出库单同步回传 ,调用dubbo服务返回部分成功");
					return processByPartSuccess(dubboResp,requestData.getHead().getBatch_no());
				}
			} else {// 处理失败
				logger.error("erp销售出库单结果回传,调用dubbo服务返回失败");
				return processByException("ORDER_SYNC_RETURN", "报文处理失败",
						requestData.getHead().getBatch_no());
			}
		} catch (Exception e) {
			if (null == requestData) {
				logger.error("erp销售出库单同步结果回传报文处理,xml转换失败:", e);
				return processByException("ORDER_SYNC_RETURN", "报文处理失败", null);
			} else {
				logger.error("erp销售出库单同步结果回传请求处理失败:", e);
				return processByException("ORDER_SYNC_RETURN", "交易请求处理失败",
						requestData == null ? null : requestData.getHead()
								.getBatch_no());
			}
		}finally{
			String serverIP = RpcContext.getContext().getRemoteHost(); // 获取当前线程最后一次调用的提供方IP地址
			logger.info("本次erp销售出库单同步服务处理的服务中心地址是:{}",serverIP);
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
	private String processByPartSuccess(SyncReturnOrderResponse response,
			String batch_no) {
		ErpOrderPackageDeliveryResultRespData resp = new ErpOrderPackageDeliveryResultRespData();
		ErpResponseHead head = new ErpResponseHead();
		head.setOp_type("ORDER_SYNC_RETURN");
		head.setBatch_no(batch_no);
		head.setSend_time(new Date());
		head.setOp_result("PART");
		resp.setHead(head);
		ErpOrderPackageDeliveryResultRespData.OrderpackageDeliveryResultRespBody body = BeanMapper
				.map(response,
						ErpOrderPackageDeliveryResultRespData.OrderpackageDeliveryResultRespBody.class);
		
		resp.setBody(body);
		try{
			return XMLUtils.convertToXml(resp);
		}catch(Exception e){
			logger.error("处理返回部分成功xml转换失败",e);
            return null;
		}
	}
}
