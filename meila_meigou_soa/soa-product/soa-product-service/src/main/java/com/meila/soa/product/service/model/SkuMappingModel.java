package com.meila.soa.product.service.model;

import java.util.List;

import org.springframework.beans.BeanUtils;

import com.meila.soa.product.dal.entity.product.SkuMapping;

public class SkuMappingModel extends SkuMapping {

    List<String> mappingValues;

    // 供json转java使用
    public SkuMappingModel() {

    }

    public SkuMappingModel(SkuMapping skuMapping) {
        BeanUtils.copyProperties(skuMapping, this);
    }

    public List<String> getMappingValues() {
        return mappingValues;
    }

    public void setMappingValues(List<String> mappingValues) {
        this.mappingValues = mappingValues;
    }

}
