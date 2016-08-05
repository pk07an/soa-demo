package com.meila.soa.meila.client.service;

import java.util.Collections;
import java.util.List;
import java.util.Map;

import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.google.common.collect.Lists;
import com.meila.soa.meila.client.model.OmsJsonResult;
import com.meila.soa.meila.client.model.ProductInventoryDto;
import com.meila.soa.meila.client.model.UserDto;
import com.meila.soa.product.service.exceptions.BizException;
import com.meila.soa.product.service.exceptions.GlobalErrorCode;
import com.meila.soa.product.service.utils.MeiLaRestTemplate;

/**
 ************************************************************
 * @类名 : MeiLaOmsClient.java
 *
 * @DESCRIPTION : oms client utils
 * @AUTHOR : Toney
 * @DATE : 2015年11月2日
 ************************************************************
 */
@Service("meiLaOmsClient")
public class MeiLaOmsClient {

    private static final Logger logger = LoggerFactory.getLogger(MeiLaOmsClient.class);

    private static final String DEFAULT_CHARSET = "UTF-8";

    @Autowired
    private MeiLaRestTemplate meiLaRestTemplate;

    @Value("${meila.oms.host.name}")
    private String MEILA_OMS_HOST_NAME; // oms接口host

    @Value("${meila.oms.syncProduct.url}")
    private String MEILA_OMS_SYNCPRODUCT_URL; // oms同步商品

    @Value("${meila.oms.syncSeller.url}")
    private String MEILA_OMS_SYNCSELLER_URL; // oms同步卖家信息

    @Value("${meila.oms.product.inventory.url}")
    private String MEILA_OMS_PRODUCT_INVENTORY_URL; // oms商品sku真实库存查询

    /**
     *
     * 功能描述：rest api post
     * 
     * @param object
     * @return String
     * @Exception :
     */
    public JSONObject postForObject(String url, Object object) {
        String result = "";
        try {
            long startTime = System.currentTimeMillis();
            logger.info("MeiLaOmsClient postForObject");
            HttpHeaders headers = new HttpHeaders();
            MediaType type = MediaType.parseMediaType("application/json; charset=" + DEFAULT_CHARSET);
            headers.setContentType(type);
            headers.add("Accept", MediaType.APPLICATION_JSON.toString());
            HttpEntity<String> formEntity = new HttpEntity<String>(JSONObject.toJSONString(object), headers);
            result = meiLaRestTemplate.postForObject(url, formEntity, String.class);
            JSONObject jsonObject = JSONObject.parseObject(result);
            long endTime = System.currentTimeMillis();
            logger.info("MeiLaOmsClient postForObject result {}, time: {} ms", result, (endTime - startTime));
            return jsonObject;
        } catch (Exception e) {
            logger.error("调用oms接口失败, url: {}, object: {}, result: {} .", url, JSONObject.toJSONString(object), result, e);
            throw new BizException(GlobalErrorCode.INTERNAL_ERROR, "调用oms接口失败");
        }
    }

    /**
     * 商品修改同步
     * 
     * @param productIds
     * @return
     */
    public OmsJsonResult syncProduct(List<Long> productIds) {
        logger.debug("syncProduct [productIds]{}", productIds);
        String gateway = MEILA_OMS_HOST_NAME + MEILA_OMS_SYNCPRODUCT_URL;
        JSONObject jsonObject = postForObject(gateway, productIds);
        return JSONObject.toJavaObject(jsonObject, OmsJsonResult.class);
    }

    /**
     * 卖家信息修改同步
     * 
     * @param sellerIds
     * @return
     */
    public OmsJsonResult syncSeller(UserDto userDto) {
        String gateway = MEILA_OMS_HOST_NAME + MEILA_OMS_SYNCSELLER_URL;
        JSONObject jsonObject = postForObject(gateway, userDto);
        return JSONObject.toJavaObject(jsonObject, OmsJsonResult.class);
    }

    /**
     * 根据skuId和卖家ID获取Sku的真实库存
     * 
     * @param sellerId 卖家ID
     * @param skuIdList skuId集合
     * @return Map&lt;String, String&gt; sku库存键值对
     * @exception {说明在某情况下,将发生什么异常}
     */
    public Map<String, Integer> getSkuInventory(Long sellerId, List<Long> skuIdList) throws Exception {
        try {
            if (CollectionUtils.isEmpty(skuIdList) || null == sellerId) {
                return Collections.emptyMap();
            }

            String gateway = MEILA_OMS_HOST_NAME + MEILA_OMS_PRODUCT_INVENTORY_URL;

            List<ProductInventoryDto> productInventoryDtos = Lists.newArrayList();

            for (Long skuId : skuIdList) {
                ProductInventoryDto dto = new ProductInventoryDto();

                dto.setSellerId(sellerId);
                dto.setSkuId(skuId);

                productInventoryDtos.add(dto);
            }

            JSONObject jsonObject = postForObject(gateway, productInventoryDtos);

            if (jsonObject.getInteger("ret") != 0) {
                logger.error("根据skuId和卖家ID获取Sku的真实库存异常: sellerId:{}, skuIdList:{}", sellerId, skuIdList);
                throw new BizException(GlobalErrorCode.INTERNAL_ERROR, "根据skuId和卖家ID获取Sku的真实库存异常");
            }

            if (StringUtils.equals(jsonObject.getString("errorCode"), "NOT_IN_SELLER_WHITE")) {
                logger.error("卖家是非白名单卖家，无法获取真实库存: sellerId:{}, skuIdList:{}", sellerId, skuIdList);
                throw new BizException(GlobalErrorCode.INTERNAL_ERROR, "卖家是非白名单卖家，无法获取真实库存");
            }

            String data = jsonObject.getString("data");

            if (data == null || StringUtils.isBlank(data)) {
                return Collections.emptyMap();
            }

            Map<String, Integer> map = (Map<String, Integer>) JSON.parse(data);

            return map;
        } catch (Exception e) {
            logger.error("根据skuId和卖家ID获取Sku的真实库存异常: sellerId:{}, skuIdList:{}", sellerId, skuIdList);
            throw e;
        }
    }

}
