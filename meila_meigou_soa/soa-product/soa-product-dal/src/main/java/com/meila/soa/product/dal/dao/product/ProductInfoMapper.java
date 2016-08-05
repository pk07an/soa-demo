package com.meila.soa.product.dal.dao.product;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.meila.soa.product.dal.entity.product.ProductInfo;
import com.meila.soa.product.dal.entity.product.ProductInfoExample;

public interface ProductInfoMapper {
    int countByExample(ProductInfoExample example);

    int deleteByExample(ProductInfoExample example);

    int deleteByPrimaryKey(Long id);

    int insert(ProductInfo record);

    int insertSelective(ProductInfo record);

    List<ProductInfo> selectByExample(ProductInfoExample example);

    ProductInfo selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(ProductInfo record);

    int updateByPrimaryKey(ProductInfo record);

    List<ProductInfo> selectByProductIdList(List<Long> productIdList);

    int updateShareImgByProductId(ProductInfo info);

    List<ProductInfo> selectProductInfoListBySkuIdList(List<Long> skuIdList);

    ProductInfo selectByProductId(Long id);

    void updateByProductId(ProductInfo oldInfo);

    int updateDeliveryType(@Param(value = "productIdList") List<Long> productIdList, @Param(value = "deliveryType") String deliveryType,
        @Param(value = "warehouse") String warehouse);

    ProductInfo selectProductInfoBySkuId(@Param("skuId") Long skuId);
}
