package com.meila.soa.proxy.service.impl.erp;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alibaba.dubbo.rpc.RpcContext;
import com.meila.soa.product.api.DubboProductService;
import com.meila.soa.product.api.model.dto.DubboProductSku;
import com.meila.soa.product.api.model.request.DubboSyncProductRequest;
import com.meila.soa.product.api.model.response.DubboSyncProductResponse;
import com.meila.soa.product.api.model.response.DubboSyncProductResponse.DubboSyncProductResult;
import com.meila.soa.proxy.model.erp.ErpResponseHead;
import com.meila.soa.proxy.model.erp.ErpSkuSyncRequestData;
import com.meila.soa.proxy.model.erp.ErpSkuSyncResponseData;
import com.meila.soa.proxy.utils.XMLUtils;
/**
 * 
 ************************************************************
 * @类名 : ErpSkuDataSyncSerivce.java
 *
 * @DESCRIPTION : erp系统对接sku数据同步服务
 * @AUTHOR :  meila-x
 * @DATE :  2016年1月7日
 ************************************************************
 */
@Service
public class ErpSkuDataSyncSerivceImpl extends ErpRequestBaseServiceImpl{
	private final Logger logger = LoggerFactory.getLogger(getClass());
	@Autowired
	private DubboProductService productService;
	
	/**
	 * 
	 *
	 * 功能描述：处理erp的商品同步操作
	 * 
	 * @param xmlData
	 * @return
	 * @throws Exception String
	 *
	 */
    public String erpSkuDataSync(String xmlData) throws Exception{
        logger.info("ERP商品信息同步处理开始......请求参数:"+ xmlData);
        ErpSkuSyncRequestData skuSyncRequest = null;
        String retStr = "";
        try{
        	//解析xml报文
            skuSyncRequest = XMLUtils.converyToJavaBean(xmlData, ErpSkuSyncRequestData.class);
            if(null !=skuSyncRequest){//调用商品中心的dubbo服务
            	DubboSyncProductRequest request = generateDubboSyncProductRequest(skuSyncRequest); //generateData();//;
            	DubboSyncProductResponse resp = productService.syncErpSku(request);
            	if(resp == null){
            		logger.info("服务中心处理返回为空");
            		retStr = processByException("SKU_SYNC","服务调用失败",skuSyncRequest.getHead().getBatch_no());
            	}else{
            		if(0 == resp.getCode()){ //调用成功
                		if(resp.getResultList() == null || resp.getResultList().isEmpty()){ //全部成功
                			retStr = processBySuccess("SKU_SYNC",skuSyncRequest.getHead().getBatch_no());
                		}else{//部分成功
                			retStr = processByPartSuccess(resp.getResultList());
                		}
                		
                	}else{ //全部处理失败
                		retStr = processByException("SKU_SYNC","业务处理失败..",skuSyncRequest.getHead().getBatch_no());
                	}
            	}
            }
            retStr = processBySuccess("SKU_SYNC",skuSyncRequest.getHead().getBatch_no());
        }catch(Exception e){
        	logger.error("处理erp商品同步信息出现异常:",e);
        	retStr = processByException("SKU_SYNC",e.getMessage(),skuSyncRequest == null ? null : skuSyncRequest.getHead().getBatch_no());
        }finally{
        	String serverIP = RpcContext.getContext().getRemoteHost(); // 获取当前线程最后一次调用的提供方IP地址
        	logger.info("erp SKU 同步服务,服务中心地址{}" ,serverIP);
        }
        
        return retStr;
    }
    
    /**
     * 处理部分成功
     * @param resultList 错误明细
     * @return
     */
    private String processByPartSuccess(List<DubboSyncProductResult> resultList){
    	 ErpSkuSyncResponseData response = new ErpSkuSyncResponseData();
    	 ErpResponseHead responseHead = new ErpResponseHead();
         responseHead.setOp_type("SKU_SYNC");
         responseHead.setSend_time(new Date());
         responseHead.setOp_result("PART");
         response.setHead(responseHead);
         ErpSkuSyncResponseData.Body body = new ErpSkuSyncResponseData.Body();
         List<ErpSkuSyncResponseData.Data> errDataList = new ArrayList<ErpSkuSyncResponseData.Data>();
         for(DubboSyncProductResult result : resultList){
        	 ErpSkuSyncResponseData.Data data = new ErpSkuSyncResponseData.Data();
        	 data.setErp_sku_id(result.getErpSkuId());
        	 data.setError_code(result.getErrorCode());
        	 data.setError_msg(result.getErrorMsg());
        	 errDataList.add(data);
         }
         body.setData(errDataList);
         response.setBody(body);
         try {
             return XMLUtils.convertToXml(response);
         } catch (Exception e) {
         	logger.error("处理返回部分成功xml转换失败",e);
            return null;
         }
    }
    
    /**
     * 生成dubbo服务的请求对象
     * @param data
     * @return
     */
    private DubboSyncProductRequest generateDubboSyncProductRequest(ErpSkuSyncRequestData data) throws Exception{
    	DubboSyncProductRequest request = new DubboSyncProductRequest();
    	List<DubboProductSku> dubboSkuList = new ArrayList<>();
    	
    	ErpSkuSyncRequestData.Body body = data.getBody();
    	if(body.getDataList() == null || body.getDataList().isEmpty()){
    		throw new Exception("erp商品同步请求中的明细数据为空");
    	}
    	//数据转换
    	for(ErpSkuSyncRequestData.Data detailData : body.getDataList()){
    		DubboProductSku dubboSku = new DubboProductSku();
    		dubboSku.setErpSkuId(detailData.getErp_sku_id());
    		dubboSku.setErpSkuCode(detailData.getErp_sku_code());
    		dubboSku.setSkuNameCn(detailData.getSku_name_cn());
    		dubboSku.setSkuNameEn(detailData.getSku_name_en());
    		dubboSku.setBelongAccount(detailData.getBelong_account());
    		dubboSku.setSkuStr(detailData.getSku_str());
    		dubboSku.setErpSyncTime(detailData.getSync_time());
    		dubboSku.setSalePrice(detailData.getSale_price());
    		dubboSku.setSkuBarCode(detailData.getSku_bar_code());
    		dubboSku.setPurchasePlace(detailData.getPurchase_place());
    		dubboSku.setProductionPlace(detailData.getProduction_place());
    		dubboSku.setBrandNameCn(detailData.getBrand_name_cn());
    		dubboSku.setBrandNameEn(detailData.getBrand_name_en());
    		dubboSku.setSpec1Name(detailData.getSpec1_name());
    		dubboSku.setSpec1Value(detailData.getSpec1_value());
    		dubboSku.setSpec2Name(detailData.getSpec2_name());
    		dubboSku.setSpec2Value(detailData.getSpec2_value());
    		dubboSku.setSpec3Name(detailData.getSpec3_name());
    		dubboSku.setSpec3Value(detailData.getSpec3_value());
    		dubboSku.setSpec4Name(detailData.getSpec4_name());
    		dubboSku.setSpec4Value(detailData.getSpec4_value());
    		dubboSku.setSpec5Name(detailData.getSpec5_name());
    		dubboSku.setSpec5Value(detailData.getSpec5_value());
    		dubboSku.setCategoryCode(detailData.getCategory_code());
    		dubboSku.setWarehouseCode(detailData.getWarehouse_code());
    		dubboSku.setUnitName(detailData.getUnit_name());
    		dubboSku.setArchive(detailData.getArchive());
    		
    		dubboSkuList.add(dubboSku);
    	}
    	request.setProductSkuList(dubboSkuList);
    	return request;
    }
}
