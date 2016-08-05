/**
 * 
 */
package com.meila.soa.openapi.thrift.product.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import com.meila.soa.openapi.thrift.product.model.ThriftProductModel;
import com.meila.soa.openapi.thrift.product.model.ThriftShopModel;
import com.meila.soa.openapi.thrift.product.model.ThriftSkuModel;
import com.meila.soa.product.api.model.dto.DubboProduct;
import com.meila.soa.product.api.model.dto.DubboShopAdmin;
import com.meila.soa.product.api.model.dto.DubboSku;

/**
 ************************************************************
 * @类名 : ThriftProductConverter.java
 *
 * @DESCRIPTION :
 * @AUTHOR : flong
 * @DATE : 2016年1月28日
 ************************************************************
 */
public class ThriftProductConverter {
    public static ThriftProductModel spudubbo2thrift(DubboProduct dubboProduct) {
        if (dubboProduct == null) {
            return null;
        }
        ThriftProductModel model = new ThriftProductModel();
        model.setId(dubboProduct.getProductId());
        model.setCode(dubboProduct.getCode());
        model.setName(dubboProduct.getName());
        model.setImgUrl(dubboProduct.getImg());
        model.setImgWidth(dubboProduct.getImgWidth() == null ? 0 : dubboProduct.getImgWidth());
        model.setImgHeight(dubboProduct.getImgHeight() == null ? 0 : dubboProduct.getImgHeight());
        model.setDescription(dubboProduct.getDescription());
        model.setStatus(dubboProduct.getStatus());
        model.setMarketPrice(dubboProduct.getMarketPrice() == null ? 0 : dubboProduct.getMarketPrice().doubleValue());
        model.setPrice(dubboProduct.getPrice() == null ? 0 : dubboProduct.getPrice().doubleValue());
        model.setAmount(dubboProduct.getAmount() == null ? 0 : dubboProduct.getAmount());
        model.setSaleNum(dubboProduct.getSales() == null ? 0 : dubboProduct.getSales());
        model.setCreateTime(dubboProduct.getCreatedAt() == null ? 0L : dubboProduct.getCreatedAt().getTime());
        model.setUpdateTime(dubboProduct.getUpdatedAt() == null ? 0L : dubboProduct.getUpdatedAt().getTime());
        model.setShopId(dubboProduct.getShopId() == null ? 0 : dubboProduct.getShopId());
        model.setShopName(dubboProduct.getShopName());
        model.setPurchaseSource(dubboProduct.getPurchaseSource());
        model.setSellerSource(dubboProduct.getSellerSource());
        model.setSkus(skulistdubbo2thrift(dubboProduct.getSkuList()));
        model.setDeliveryType(dubboProduct.getDeliveryType());
        model.setStorageType(dubboProduct.getStorageType());
        model.setTotalDays(dubboProduct.getDeliveryDays() == null ? 0 : dubboProduct.getDeliveryDays());
        String deliverTime = dubboProduct.getSendOutHours() + "小时内发货";
        model.setDeliverTime(deliverTime);
        // 以sku的specMap组合成spu specMap
        Map<String, List<String>> specInfo = new LinkedHashMap<String, List<String>>();
        Map<String, String> skuSpecMap = null;
        if (model.getSkus() != null) {
            for (ThriftSkuModel skuModel : model.getSkus()) {
                skuSpecMap = skuModel.getSpecMap();
                if (skuSpecMap == null) {
                    continue;
                }
                for (String skuKey : skuSpecMap.keySet()) {
                    if (skuSpecMap.get(skuKey) == null) {
                        continue;
                    }
                    if (specInfo.containsKey(skuKey)) {
                        List<String> specValueList = specInfo.get(skuKey);
                        if (!specValueList.contains(skuSpecMap.get(skuKey))) {
                            specValueList.add(skuSpecMap.get(skuKey));
                        }
                    } else {
                        List<String> specValueList = new ArrayList<String>();
                        specValueList.add(skuSpecMap.get(skuKey));
                        specInfo.put(skuKey, specValueList);
                    }
                }

            }
        }
        model.setSpecMap(specInfo);
        // model.setSpecMap(dubboProduct.getSpecInfo());
        return model;
    }

    public static List<ThriftSkuModel> skulistdubbo2thrift(List<DubboSku> dubboSkus) {
        List<ThriftSkuModel> thriftSkuModels = new ArrayList<ThriftSkuModel>();
        if (dubboSkus == null || dubboSkus.size() == 0) {
            return thriftSkuModels;// 按社区要求，即使sku为空也要返回一个size为0的集合
        }
        for (DubboSku dubboSku : dubboSkus) {
            ThriftSkuModel thriftSkuModel = skudubbo2thrift(dubboSku);
            if (thriftSkuModel != null) {
                thriftSkuModels.add(thriftSkuModel);
            }
        }
        return thriftSkuModels;
    }

    public static ThriftSkuModel skudubbo2thrift(DubboSku dubboSku) {
        if (dubboSku == null) {
            return null;
        }
        // 隐藏状态的sku不返回
        if ("HIDE".equalsIgnoreCase(dubboSku.getIsDisplay())) {
            return null;
        }
        ThriftSkuModel model = new ThriftSkuModel();
        model.setId(dubboSku.getSkuId());
        model.setProductId(dubboSku.getProductId());
        model.setDescription(dubboSku.getSpec());
        model.setMarketPrice(dubboSku.getMarketPrice() == null ? 0 : dubboSku.getMarketPrice().doubleValue());
        model.setPrice(dubboSku.getPrice() == null ? 0 : dubboSku.getPrice().doubleValue());
        model.setAmount(dubboSku.getAmount() == null ? 0 : dubboSku.getAmount());
        model.setOrder(dubboSku.getSkuOrder() == null ? 0 : dubboSku.getSkuOrder());
        model.setSaledNum(dubboSku.getSales() == null ? 0 : dubboSku.getSales());
        model.setCode(dubboSku.getCode());
        model.setType(dubboSku.getSkuType());
        model.setDisplay(dubboSku.getIsDisplay());
        Map<String, String> specMap = new HashMap<String, String>();
        if (dubboSku.getSpecMap() != null) {
            for (String skuKey : dubboSku.getSpecMap().keySet()) {
                if (dubboSku.getSpecMap().get(skuKey) != null) {
                    specMap.put(skuKey, dubboSku.getSpecMap().get(skuKey));
                }
            }
        }
        model.setSpecMap(specMap);
        model.setImg(dubboSku.getImg());
        if (dubboSku.getImgWidth() != null) {
            model.setImgWidth(dubboSku.getImgWidth());
        }
        if (dubboSku.getImgHeight() != null) {
            model.setImgHeight(dubboSku.getImgHeight());
        }
        return model;
    }

    public static ThriftShopModel shopAdminDubbo2Thrift(DubboShopAdmin dubboShop) {
        if (dubboShop == null) {
            return null;
        }
        ThriftShopModel model = new ThriftShopModel();
        model.setShopId(dubboShop.getShopId());
        model.setSellId(dubboShop.getOwnerId());
        model.setName(dubboShop.getShopName());
        model.setDescription(dubboShop.getDescription());
        model.setImg(dubboShop.getShopImg());
        // model.setShortIntro(dubboShop.getShopExt().getShortIntro());
        // model.setSellerType(dubboShop.getShopExt().getSellerType() == null ? 1 :
        // dubboShop.getShopExt().getSellerType());
        // model.setSellerCertification(dubboShop.getShopExt().getSellerCertification());
        // model.setSelfhoodName(dubboShop.getShopExt().getSelfhoodName());
        return model;
    }
}
