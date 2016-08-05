package com.meila.soa.product.dal.dao.product;

import java.util.List;

import com.meila.soa.product.dal.entity.product.SkuMapping;

public interface SkuMappingMapper {
    List<SkuMapping> selectByProductId(Long productId);

    void insert(SkuMapping skuMapping);

    void updateByPrimaryKeySelective(SkuMapping skuMapping);
}
