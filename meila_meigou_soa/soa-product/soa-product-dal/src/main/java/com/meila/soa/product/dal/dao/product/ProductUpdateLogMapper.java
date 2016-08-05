package com.meila.soa.product.dal.dao.product;

import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.meila.soa.product.dal.entity.product.ProductUpdateLog;

/**
 * 商品更新记录 映射mapper类 by reese 2015/7/15
 */
public interface ProductUpdateLogMapper {

    int insert(ProductUpdateLog record);

    int insertSelective(ProductUpdateLog record);

    ProductUpdateLog selectByPrimaryKey(String id);

    int updateSelectiveInfo(@Param(value = "map") Map<String, Object> params);

    int insertInfo(@Param(value = "map") Map<String, Object> params);

    int updateImageById(@Param(value = "id") Long id, @Param(value = "key") String key);

}
