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
import com.meila.soa.product.api.DubboProductService;
import com.meila.soa.product.api.model.request.DubboSyncCategoryRequest;
import com.meila.soa.product.api.model.response.DubboSyncCategoryResponse;
import com.meila.soa.proxy.model.erp.ErpCategorySyncRequestData;
import com.meila.soa.proxy.model.erp.ErpCategorySyncRespData;
import com.meila.soa.proxy.model.erp.ErpResponseHead;
import com.meila.soa.proxy.utils.XMLUtils;

/**
 ************************************************************
 * @类名 : ErpCategorySyncServiceImpl.java
 *
 * @DESCRIPTION : Erp分类树同步服务实现
 * @AUTHOR :  abner
 * @DATE :  2016年1月21日
 ************************************************************
 */
@Service
public class ErpCategorySyncServiceImpl extends ErpRequestBaseServiceImpl {
	private final Logger logger = LoggerFactory.getLogger(getClass());
	@Autowired
	private DubboProductService productService;

	/**
	 * 
	 *
	 * 功能描述：分类树同步处理
	 * 
	 * @param xmlData
	 * @return String
	 *
	 */
	public String erpCategorySync(String xmlData){
		logger.info("erp分类树同步处理开始....请求报文：" + xmlData);
		ErpCategorySyncRequestData erpRequest = null;
		try{
			//解析xml报文
			erpRequest = XMLUtils.converyToJavaBean(xmlData, ErpCategorySyncRequestData.class);
			//dubbo分类树同步请求对象
			DubboSyncCategoryRequest dubboReq = BeanMapper.map(erpRequest.getBody(), DubboSyncCategoryRequest.class);
			
			//调用dubbo服务
			DubboSyncCategoryResponse dubboResp = productService.syncCategory(dubboReq);
			if (null == dubboResp) {
				logger.error("erp分类树同步,调用dubbo服务返回对象为空");
				return processByException("CATEGORY_SYNC", "服务调用失败",
						erpRequest.getHead().getBatch_no());
			}
			
			if(0 == dubboResp.getCode()){ //业务处理成功包括部分成功
				if(null == dubboResp.getResultList() || dubboResp.getResultList().isEmpty()){ //全部成功
					logger.info("erp分类树同步,调用dubbo服务返回成功");
					return processBySuccess("CATEGORY_SYNC",erpRequest.getHead().getBatch_no());
				}else{ //部分成功
					logger.info("erp分类树同步,dubbo服务返回部分成功");
					return processPartSuccess(dubboResp,erpRequest.getHead().getBatch_no());
				}
			}else{ //业务处理失败
				logger.info("erp分类树同步,调用dubbo服务返回业务处理失败");
				return processByException("CATEGORY_SYNC", "业务处理失败..", erpRequest.getHead().getBatch_no());
			}
		}catch(Exception e){
			logger.error("处理erp分类树同步出现异常:",e);
			return processByException("CATEGORY_SYNC", "报文处理失败",erpRequest == null?null:erpRequest.getHead().getBatch_no());
		}finally{
			String serverIP = RpcContext.getContext().getRemoteHost(); // 获取当前线程最后一次调用的提供方IP地址
			logger.info("本次erp分类树同步服务处理的服务中心地址是:{}",serverIP);
		}

	}
	
	/**
	 * 
	 *
	 * 功能描述：处理部分成功
	 * 
	 * @param response
	 * @return String
	 *
	 */
	private String processPartSuccess(DubboSyncCategoryResponse response,String batch_no){
		ErpCategorySyncRespData resp = new ErpCategorySyncRespData();
		ErpResponseHead head = new ErpResponseHead();
		head.setOp_type("CATEGORY_SYNC");
		head.setBatch_no(batch_no);
		head.setSend_time(new Date());
		head.setOp_result("PART");
		resp.setHead(head);
		
		ErpCategorySyncRespData.CategorySyncRespBody body = BeanMapper.map(response, ErpCategorySyncRespData.CategorySyncRespBody.class);
		resp.setBody(body);
		
		try{
			return XMLUtils.convertToXml(resp);
		}catch(Exception e){
			logger.error("处理返回部分成功xml转换失败",e);
            return null;
		}
	}
}
