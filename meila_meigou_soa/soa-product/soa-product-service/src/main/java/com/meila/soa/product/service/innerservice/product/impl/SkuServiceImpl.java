package com.meila.soa.product.service.innerservice.product.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.meila.common.collection.utils.Collections3;
import com.meila.soa.product.dal.dao.product.SkuExtMapper;
import com.meila.soa.product.dal.dao.product.SkuMapper;
import com.meila.soa.product.dal.entity.product.Sku;
import com.meila.soa.product.dal.entity.product.SkuExt;
import com.meila.soa.product.service.innerservice.product.SkuService;

@Service
public class SkuServiceImpl implements SkuService {

    @Resource
    private SkuMapper skuMapper;

    @Resource
    private SkuExtMapper skuExtMapper;

    @Override
    public List<Sku> searchSkuByProductIdList(Map<String, Object> params, List<Long> productIdList, Map<String, Long> page) {
        return skuMapper.searchSkuByProductIdList(params, productIdList, page);
    }

    @Override
    public Long countSkuByProductIdLIst(Map<String, Object> params, List<Long> productIdList) {
        return skuMapper.countSkuByProductIdList(params, productIdList);
    }

    /**
     * 根据skuId列表获取skuExt
     */
    @Override
    public List<SkuExt> getSkuExtBySkuIdList(List<Long> skuIdList) {
        if (Collections3.isEmpty(skuIdList)) {
            return Lists.newArrayList();
        }

        List<SkuExt> skuExtList = skuExtMapper.selectBySkuIdList(skuIdList);
        if (Collections3.isEmpty(skuExtList)) {
            skuExtList = Lists.newArrayList();
        }
        return skuExtList;
    }

    /**
     * 获取skuExtMap信息
     */
    @Override
    public Map<Long, SkuExt> getSkuExtMap(List<Long> skuIdList) {
        Map<Long, SkuExt> skuExtMap = Maps.newHashMap();
        List<SkuExt> skuExtList = getSkuExtBySkuIdList(skuIdList);
        for (SkuExt temp : skuExtList) {
            skuExtMap.put(temp.getSkuId(), temp);
        }
        return skuExtMap;
    }
}
