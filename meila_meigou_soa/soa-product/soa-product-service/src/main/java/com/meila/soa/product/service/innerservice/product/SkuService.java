package com.meila.soa.product.service.innerservice.product;

import java.util.List;
import java.util.Map;

import com.meila.soa.product.dal.entity.product.Sku;
import com.meila.soa.product.dal.entity.product.SkuExt;

/**
 * 
 ************************************************************
 * @类名 : SkuService.java
 *
 * @DESCRIPTION :sku相关service层方法
 * @AUTHOR : hawk
 * @DATE : 2016年5月24日
 ************************************************************
 */
public interface SkuService {

    List<Sku> searchSkuByProductIdList(Map<String, Object> params, List<Long> productIdList, Map<String, Long> page);

    Long countSkuByProductIdLIst(Map<String, Object> params, List<Long> productIdList);

    /**
     * 
     * 功能描述：根据skuId列表获取skuExt信息
     * 
     * @param skuIdList
     * @return List<SkuExt>
     *
     */
    List<SkuExt> getSkuExtBySkuIdList(List<Long> skuIdList);

    /**
     * 
     * 功能描述：获取skuId与skuExt对应关系
     * 
     * @param skuIdList
     * @return Map<Long,SkuExt>
     *
     */
    Map<Long, SkuExt> getSkuExtMap(List<Long> skuIdList);
}
