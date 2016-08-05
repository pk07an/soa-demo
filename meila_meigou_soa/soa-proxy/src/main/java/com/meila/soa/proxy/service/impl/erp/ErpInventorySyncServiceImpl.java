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
import com.meila.soa.product.api.DubboProductService;
import com.meila.soa.product.api.model.request.DubboSyncInventoryRequest;
import com.meila.soa.product.api.model.response.DubboSyncInventoryResponse;
import com.meila.soa.proxy.model.erp.ErpInventorySyncReqData;
import com.meila.soa.proxy.model.erp.ErpInventorySyncRespData;
import com.meila.soa.proxy.model.erp.ErpResponseHead;
import com.meila.soa.proxy.utils.XMLUtils;

/**
 ************************************************************
 * @类名 : ErpInventorySyncServiceImpl.java
 *
 * @DESCRIPTION : erp库存同步处理类
 * @AUTHOR : abner
 * @DATE : 2016年1月21日
 ************************************************************
 */
@Service
public class ErpInventorySyncServiceImpl extends ErpRequestBaseServiceImpl {
	private final Logger logger = LoggerFactory.getLogger(getClass());
	@Autowired
	private DubboProductService productService;

	/**
	 * 
	 *
	 * 功能描述：库存同步业务处理
	 * 
	 * @param xmlData
	 * @return String
	 *
	 */
	public String erpInventorySync(String xmlData) {
		logger.info("erp库存同步请求处理开始..请求参数:" + xmlData);
		ErpInventorySyncReqData erpRequest = null;
		try {
			erpRequest = XMLUtils.converyToJavaBean(xmlData,
					ErpInventorySyncReqData.class);

			// 使用beanMapper构造请求对象
			DubboSyncInventoryRequest dubboReq = BeanMapper.map(
					erpRequest.getBody(), DubboSyncInventoryRequest.class);

			// 调用dubbo服务
			DubboSyncInventoryResponse dubboResp = productService
					.syncInventory(dubboReq);
		
			if (null == dubboResp) {
				logger.error("erp商品库存同步,调用dubbo服务返回对象为空");
				return processByException("INVENTORY_SYNC", "服务调用失败",
						erpRequest.getHead().getBatch_no());
			}

			if (0 == dubboResp.getCode()) { // dubbo服务处理成功包含部分成功
				if (null == dubboResp.getResultList()
						|| dubboResp.getResultList().isEmpty()) {// 全部成功
					logger.info("erp商品库存同步,调用dubbo服务返回成功");
					return processBySuccess("INVENTORY_SYNC", erpRequest
							.getHead().getBatch_no());
				} else { // 部分成功
					logger.info("erp分类树同步,dubbo服务返回部分成功");
					return processPartSuccess(dubboResp, erpRequest.getHead()
							.getBatch_no());
				}
			} else { // 业务处理失败
				logger.info("erp分类树同步,dubbo服务返回处理失败");
				return processByException("INVENTORY_SYNC", "业务处理失败..",
						erpRequest.getHead().getBatch_no());
			}
		} catch (Exception e) {
			logger.error("处理erp商品库存同步出现异常:", e);
			return processByException("INVENTORY_SYNC", "报文处理失败",
					erpRequest == null ? null : erpRequest.getHead()
							.getBatch_no());
		}finally{
			String serverIP = RpcContext.getContext().getRemoteHost(); // 获取当前线程最后一次调用的提供方IP地址
			logger.info("本次erp库存同步服务处理的服务中心地址是:{}",serverIP);
		}
	}

	/**
	 * 
	 *
	 * 功能描述：erp商品库存同步处理部分成功
	 * 
	 * @param response
	 * @param batch_no
	 * @return String
	 *
	 */
	private String processPartSuccess(DubboSyncInventoryResponse response,
			String batch_no) {
		ErpInventorySyncRespData resp = new ErpInventorySyncRespData();
		ErpResponseHead head = new ErpResponseHead();
		head.setOp_type("INVENTORY_SYNC");
		head.setBatch_no(batch_no);
		head.setSend_time(new Date());
		head.setOp_result("PART");
		resp.setHead(head);

		ErpInventorySyncRespData.InventorySyncRespBody body = BeanMapper.map(
				response, ErpInventorySyncRespData.InventorySyncRespBody.class);
		resp.setBody(body);

		try {
			return XMLUtils.convertToXml(resp);
		} catch (Exception e) {
			logger.error("处理返回部分成功xml转换失败", e);
			return null;
		}
	}
}
