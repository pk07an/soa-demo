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
import com.meila.oms.soa.api.ErpOrderService;
import com.meila.oms.soa.api.model.request.SyncOrderRequest;
import com.meila.oms.soa.api.model.response.SyncOrderResponse;
import com.meila.soa.proxy.model.erp.BaseErpRequest;
import com.meila.soa.proxy.model.erp.ErpOrderPackageDeliveryResultRespData;
import com.meila.soa.proxy.model.erp.ErpOrderPackageSyncRespData;
import com.meila.soa.proxy.model.erp.ErpResponseHead;
import com.meila.soa.proxy.utils.XMLUtils;

/**
 ************************************************************
 * @类名 : ErpOrderPackageSyncServiceImpl.java
 *
 * @DESCRIPTION : 销售订单同步服务
 * @AUTHOR : abner
 * @DATE : 2016年1月22日
 ************************************************************
 */
@Service
public class ErpOrderPackageSyncServiceImpl extends ErpRequestBaseServiceImpl {
	private final Logger logger = LoggerFactory.getLogger(getClass());
	@Autowired
	private ErpOrderService erpOrderService;
	@Value("${erp.orderpackage.size}")
	private String size;

	/**
	 * 
	 *
	 * 功能描述：处理erp抓取销售订单数据
	 * 
	 * @param xmlData
	 * @return String
	 *
	 */
	public String erpOrderPackageSync(String xmlData) {
		BaseErpRequest baseReq = null;
		try {
			baseReq = XMLUtils.converyToJavaBean(xmlData, BaseErpRequest.class);
			// 构造dubbo请求对象
			SyncOrderRequest dubboReq = new SyncOrderRequest();
			dubboReq.setSize(Integer.valueOf(size));
			// 调用dubbo服务
			SyncOrderResponse dubboResp = erpOrderService.sync(dubboReq);
			
			if (dubboResp == null) { // 返回为空
				logger.error("erp抓取销售订单,调用dubbo服务返回对象为空");
				return processByException("ORDER_SYNC", "服务调用失败", baseReq
						.getHead().getBatch_no());
			}

			if (0 == dubboResp.getCode()) { // 处理成功
				logger.error("erp销售订单同步,调用dubbo服务返回成功");
				return processBySuccess(dubboResp,baseReq.getHead().getBatch_no());
			}else{
				logger.error("erp销售订单同步,调用dubbo服务返回失败");
				return processByException("ORDER_SYNC", "业务处理失败.",baseReq.getHead().getBatch_no());
			}
		} catch (Exception e) {
			logger.error("处理erp抓取销售订单出现异常:", e);
			return processByException("ORDER_SYNC", "报文处理失败",
					baseReq == null ? null : baseReq.getHead().getBatch_no());
		}finally{
			String serverIP = RpcContext.getContext().getRemoteHost(); // 获取当前线程最后一次调用的提供方IP地址
			logger.info("本次erp抓取销售订单服务处理的服务中心地址是:{}",serverIP);
		}
	}

	/**
	 * 
	 *
	 * 功能描述：业务处理成功
	 * 
	 * @param resp
	 * @param batch_no
	 * @return String
	 *
	 */
	private String processBySuccess(SyncOrderResponse dubboResp, String batch_no) {
		ErpOrderPackageSyncRespData respData = new ErpOrderPackageSyncRespData();
		ErpOrderPackageSyncRespData.OrderPackageSyncBody body = null;
		ErpResponseHead head = new ErpResponseHead();
		
		head.setBatch_no(batch_no);
		head.setOp_type("ORDER_SYNC");
		head.setSend_time(new Date());
		//判断本次数据传输是否已经完成
		if (dubboResp.getDataList() == null
				|| dubboResp.getDataList().isEmpty()
				|| dubboResp.getDataList().size() < Integer.valueOf(size)) {
			head.setIs_complete(1);
		}else{
			head.setIs_complete(0);
		}
		respData.setHead(head);
		
		body = BeanMapper.map(dubboResp, ErpOrderPackageSyncRespData.OrderPackageSyncBody.class);
		respData.setBody(body);
		
		try{
			return XMLUtils.convertToXml(respData);
		}catch(Exception e){
			logger.error("erp采购单入库同步成功xml转换失败",e);
            return null;
		}
	}
}
