package com.meila.soa.meila.client;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.meila.soa.meila.client.dto.BatchOrderPackageDto;
import com.meila.soa.meila.client.dto.OrderAddressDto;
import com.meila.soa.meila.client.dto.OrderLogisticsDto;
import com.meila.soa.meila.client.dto.OrderPackageDto;
import com.meila.soa.meila.client.dto.OrderSellerRemarkDto;
import com.meila.soa.meila.client.dto.ResultObject;

/**
 ************************************************************ 
 * @类名 : MeiLaOmsClient.java
 * 
 * @DESCRIPTION : oms client utils
 * @AUTHOR : Toney
 * @DATE : 2015年11月2日
 ************************************************************ 
 */
@Service("omsClient")
public class OmsClient {

    private static final Logger LOGGER = LoggerFactory.getLogger(OmsClient.class);

    private static final String DEFAULT_CHARSET = "UTF-8";

    @Autowired
    private RestTemplate restTemplate;

    @Value("${meila.oms.host.name}")
    private String MEILA_OMS_HOST_NAME; // oms接口host
    @Value("${meila.oms.address.url}")
    private String MEILA_OMS_ADDRESS_URL; // oms同步订单地址
    @Value("${meila.oms.order.sellerRemark.url}")
    private String MEILA_OMS_ORDER_SELLER_REMARK_URL; // oms卖家备注信息同步
    @Value("${meila.oms.logistics.url}")
    private String MEILA_OMS_LOGISTICS_URL; // oms同步物流
    @Value("${meila.oms.logisticsList.url}")
    private String MEILA_OMS_LOGISTICSLIST_URL; // 获取订单包裹物流信息
    @Value("${meila.oms.packages.url}")
    private String MEILA_OMS_PACKAGES_URL; // 获取订单包裹列表

    /**
     * 根据订单号列表获取此订单的包裹列表
     * 
     * @param orderNos
     * @return
     */
    public List<BatchOrderPackageDto> getOrderPackages(List<String> orderNos) {
        String reqUrl = MEILA_OMS_HOST_NAME + MEILA_OMS_PACKAGES_URL;
        Map<String, Object> param = new HashMap<>();
        param.put("orderNos", orderNos);
        param.put("sysFrom", "order");

        ResultObject omsResult = postForOMS(reqUrl, param);

        if (omsResult.getRet() == ResultObject.RET_FAIL) {
            LOGGER.error("调用OMS返回失败,url:{}, request:{}, response:{}", reqUrl, JSON.toJSONString(param), JSON.toJSONString(omsResult));
            return null;
        }

        if(omsResult.getData() == null)
        {
            return Collections.emptyList();
        }
        
        String data = omsResult.getData().toString();

        if (StringUtils.isBlank(data)) {
            return Collections.emptyList();
        }

        List<BatchOrderPackageDto> orderPackageDtoList = JSON.parseArray(data, BatchOrderPackageDto.class);
        return orderPackageDtoList;
    }
    
    /**
     * 根据订单号和买家id获取此订单的包裹列表
     * 
     * @param orderNo
     * @param buyerId
     * @return
     */
    public List<OrderPackageDto> getOrderLogisticsList(String orderNo, Long buyerId) {
        String reqUrl = MEILA_OMS_HOST_NAME + MEILA_OMS_LOGISTICSLIST_URL;
        Map<String, String> param = new HashMap<String, String>();
        param.put("orderNo", orderNo);
        param.put("buyerId", String.valueOf(buyerId));

        ResultObject omsResult = postForOMS(reqUrl, param);

        if (omsResult.getRet() == ResultObject.RET_FAIL) {
            LOGGER.error("调用OMS返回失败,url:{}, request:{}, response:{}", reqUrl, JSON.toJSONString(param), JSON.toJSONString(omsResult));
            return null;
        }

        if(omsResult.getData() == null)
        {
            return Collections.emptyList();
        }
        
        String data = omsResult.getData().toString();

        if (StringUtils.isBlank(data)) {
            return Collections.emptyList();
        }

        List<OrderPackageDto> orderPackageDtoList = JSON.parseArray(data, OrderPackageDto.class);
        return orderPackageDtoList;
    }

    /**
     * 
     *
     * 功能描述：卖家同步订单物流信息
     * 
     * @param dto
     * @return ResultObject
     *
     */
    public boolean sendSyncOrderLogistics(OrderLogisticsDto dto) {
        return isSuccess(MEILA_OMS_HOST_NAME + MEILA_OMS_LOGISTICS_URL, dto);
    }

    /**
     * 
     *
     * 功能描述：同步订单地址信息
     * 
     * @param dto
     * @return ResultObject
     *
     */
    public boolean sendSyncOrderAddress(OrderAddressDto dto) {
        return isSuccess(MEILA_OMS_HOST_NAME + MEILA_OMS_ADDRESS_URL, dto);
    }

    /**
     * 
     *
     * 功能描述：同步卖家备注
     * 
     * @param dto
     * @return ResultObject
     *
     */
    public boolean sendSyncSellerRemark(OrderSellerRemarkDto dto) {
        return isSuccess(MEILA_OMS_HOST_NAME + MEILA_OMS_ORDER_SELLER_REMARK_URL, dto);
    }

    private boolean isSuccess(String reqUrl, Object reqObject) {
        boolean result = false;
        ResultObject omsResult = postForOMS(reqUrl, reqObject);
        if (omsResult.getRet() == ResultObject.RET_SUCCESS) {
            result = true;
            return result;
        } else {
            LOGGER.error("调用OMS返回失败,url:{}, request:{}, response:{}", reqUrl, JSON.toJSONString(reqObject), JSON.toJSONString(omsResult));
        }

        return result;
    }

    /**
     *
     * 功能描述：请求oms post
     * 
     * @param reqUrl 请求url
     * @param reqObject 请求对象
     *
     */
    public ResultObject postForOMS(String reqUrl, Object reqObject) {

        ResultObject resultObject = null;
        try {

            long startTime = System.currentTimeMillis();
            LOGGER.info("MeiLaOmsClient postForObject start .. reqUrl: {}", reqUrl);

            resultObject = restTemplate.postForObject(reqUrl, reqObject, ResultObject.class);
            long endTime = System.currentTimeMillis();

            LOGGER.info("MeiLaOmsClient postForObject end .. reqUrl: {}, object:{}, result {}, time: {} ms", reqUrl,
                JSONObject.toJSONString(reqObject), JSONObject.toJSONString(resultObject), (endTime - startTime));

        } catch (Exception e) {
            LOGGER.error("调用oms接口失败, reqUrl: {}, object: {}, result: {} .", reqUrl, JSONObject.toJSONString(reqObject), JSONObject.toJSONString(resultObject), e);
            if (resultObject == null) {
                resultObject = new ResultObject();
            }
            resultObject.setRet(ResultObject.RET_FAIL);
            resultObject.setErrorCode("500");
            resultObject.setErrorMsg("调用OMS接口失败");
        }
        return resultObject;
    }

    // /**
    // * 订单地址修改同步
    // *
    // * @param orderNo
    // * @param orderId
    // * @param orderAddressId
    // * @return
    // */
    // public OmsJsonResult syncOrderAddress(OrderAddressDto dto) {
    // log.debug("syncOrderAddress [orderId]{},[orderNo]{}", dto.getOrderId(), dto.getOrderNo());
    // String gateway = MEILA_OMS_HOST_NAME + MEILA_OMS_ADDRESS_URL;
    // JSONObject jsonObject = postForObject(gateway, dto);
    // return JSONObject.toJavaObject(jsonObject, OmsJsonResult.class);
    // }
    //
    // /**
    // * 商品修改同步
    // *
    // * @param productIds
    // * @return
    // */
    // public OmsJsonResult syncProduct(List<Long> productIds) {
    // log.debug("syncProduct [productIds]{}", productIds);
    // String gateway = MEILA_OMS_HOST_NAME + MEILA_OMS_SYNCPRODUCT_URL;
    // JSONObject jsonObject = postForObject(gateway, productIds);
    // return JSONObject.toJavaObject(jsonObject, OmsJsonResult.class);
    // }
    //
    // /**
    // * 卖家信息修改同步
    // *
    // * @param sellerIds
    // * @return
    // */
    // public OmsJsonResult syncSeller(UserDto userDto) {
    // String gateway = MEILA_OMS_HOST_NAME + MEILA_OMS_SYNCSELLER_URL;
    // JSONObject jsonObject = postForObject(gateway, userDto);
    // return JSONObject.toJavaObject(jsonObject, OmsJsonResult.class);
    // }
    //
    // /**
    // * 卖家发货物流同步
    // *
    // * @param orderNo
    // * @param sellerId
    // * @param logisticsCompany
    // * @param logisticsNo
    // * @return
    // */
    // public OmsJsonResult syncOrderLogistics(String orderNo, Long sellerId, String logisticsCompany, String
    // logisticsNo) {
    // String gateway = MEILA_OMS_HOST_NAME + MEILA_OMS_LOGISTICS_URL;
    // Map<String, String> param = new HashMap<String, String>();
    // param.put("orderNo", orderNo);
    // param.put("sellerId", String.valueOf(sellerId));
    // param.put("logisticsCompany", logisticsCompany);
    // param.put("logisticsNo", logisticsNo);
    // JSONObject jsonObject = postForObject(gateway, param);
    // return JSONObject.toJavaObject(jsonObject, OmsJsonResult.class);
    // }
    //
    // /**
    // * 卖家备注信息同步
    // *
    // * @param orderNo
    // * @param sellerId
    // * @param logisticsCompany
    // * @param logisticsNo
    // * @return
    // */
    // public OmsJsonResult sellerRemark(String orderNo, Long sellerId, String remark, Long operationTime) {
    // String gateway = MEILA_OMS_HOST_NAME + MEILA_OMS_ORDER_SELLER_REMARK_URL;
    // Map<String, String> param = new HashMap<String, String>();
    //
    // param.put("orderNo", orderNo);
    // param.put("sellerId", String.valueOf(sellerId));
    // param.put("remark", remark);
    // param.put("operationTime", String.valueOf(operationTime));
    //
    // JSONObject jsonObject = postForObject(gateway, param);
    // return JSONObject.toJavaObject(jsonObject, OmsJsonResult.class);
    // }

    // /**
    // * 根据订单号和买家id获取此订单的包裹列表
    // *
    // * @param orderNo
    // * @param buyerId
    // * @return
    // */
    // public List<OrderPackageDto> getLogisticsListAll(String orderNo, Long buyerId) throws Exception {
    // try {
    // String gateway = MEILA_OMS_HOST_NAME + MEILA_OMS_LOGISTICSLIST_URL;
    // Map<String, String> param = new HashMap<String, String>();
    // param.put("orderNo", orderNo);
    // param.put("buyerId", String.valueOf(buyerId));
    //
    // JSONObject jsonObject = postForObject(gateway, param);
    //
    // if (jsonObject.getInteger("ret") != 0) {
    // LOGGER.error("获取订单包裹列表异常: buyerId:{}, orderNo:{}", buyerId, orderNo);
    // throw new BizException(Constants.RETCODE_CALL_CLIENT_ERROR, jsonObject.getString("msg"));
    // }
    //
    // String data = jsonObject.getString("data");
    //
    // if (data == null || StringUtils.isBlank(data)) {
    // return Collections.emptyList();
    // }
    //
    // List<OrderPackageDto> orderPackageDtoList = JSONArray.parseArray(data, OrderPackageDto.class);
    // return orderPackageDtoList;
    // } catch (Exception e) {
    // LOGGER.error("获取订单包裹列表异常: buyerId:{}, orderNo:{}", buyerId, orderNo, e);
    // throw e;
    // }
    // }

    // /**
    // * 订单退款同意
    // *
    // * @param refundDto
    // * @return
    // */
    // public OmsJsonResult orderRefundApply(OrderRefundDto refundDto) {
    // String gateway = MEILA_OMS_HOST_NAME + MEILA_OMS_REFUND_APPLY_URL;
    // JSONObject jsonObject = postForObject(gateway, refundDto);
    // return JSONObject.toJavaObject(jsonObject, OmsJsonResult.class);
    // }

    // /**
    // * 订单退款审核同意 by reese
    // *
    // * @param refundDto
    // * @return
    // */
    // public OmsJsonResult orderRefundAgree(OrderRefundDto refundDto) {
    // String gateway = MEILA_OMS_HOST_NAME + MEILA_OMS_REFUND_AGREE_URL;// FIXME
    // JSONObject jsonObject = postForObject(gateway, refundDto);
    // return JSONObject.toJavaObject(jsonObject, OmsJsonResult.class);
    // }

    // /**
    // * 订单退款拒绝
    // *
    // * @param refundDto
    // * @return
    // */
    // public OmsJsonResult orderRefundRefuse(OrderRefundDto refundDto) {
    // String gateway = MEILA_OMS_HOST_NAME + MEILA_OMS_REFUND_REFUSE_URL;
    // JSONObject jsonObject = postForObject(gateway, refundDto);
    // return JSONObject.toJavaObject(jsonObject, OmsJsonResult.class);
    // }

    // /**
    // * 根据skuId和卖家ID获取Sku的真实库存
    // *
    // * @param sellerId 卖家ID
    // * @param skuIdList skuId集合
    // * @return Map&lt;String, String&gt; sku库存键值对
    // * @exception {说明在某情况下,将发生什么异常}
    // */
    // public Map<String, Integer> getSkuInventory(Long sellerId, List<Long> skuIdList) throws Exception {
    // try {
    // if (CollectionUtils.isEmpty(skuIdList) || null == sellerId) {
    // return Collections.emptyMap();
    // }
    //
    // String gateway = MEILA_OMS_HOST_NAME + MEILA_OMS_PRODUCT_INVENTORY_URL;
    //
    // List<ProductInventoryDto> productInventoryDtos = Lists.newArrayList();
    //
    // for (Long skuId : skuIdList) {
    // ProductInventoryDto dto = new ProductInventoryDto();
    //
    // dto.setSellerId(sellerId);
    // dto.setSkuId(skuId);
    //
    // productInventoryDtos.add(dto);
    // }
    //
    // JSONObject jsonObject = postForObject(gateway, productInventoryDtos);
    //
    // if (jsonObject.getInteger("ret") != 0) {
    // LOGGER.error("根据skuId和卖家ID获取Sku的真实库存异常: sellerId:{}, skuIdList:{}", sellerId, skuIdList);
    // throw new BizException(GlobalErrorCode.INTERNAL_ERROR, "根据skuId和卖家ID获取Sku的真实库存异常");
    // }
    //
    // if (StringUtils.equals(jsonObject.getString("errorCode"), "NOT_IN_SELLER_WHITE")) {
    // LOGGER.error("卖家是非白名单卖家，无法获取真实库存: sellerId:{}, skuIdList:{}", sellerId, skuIdList);
    // throw new BizException(GlobalErrorCode.INTERNAL_ERROR, "卖家是非白名单卖家，无法获取真实库存");
    // }
    //
    // String data = jsonObject.getString("data");
    //
    // if (data == null || StringUtils.isBlank(data)) {
    // return Collections.emptyMap();
    // }
    //
    // Map<String, Integer> map = (Map<String, Integer>) JSON.parse(data);
    //
    // return map;
    // } catch (Exception e) {
    // LOGGER.error("根据skuId和卖家ID获取Sku的真实库存异常: sellerId:{}, skuIdList:{}", sellerId, skuIdList);
    // throw e;
    // }
    // }

}
