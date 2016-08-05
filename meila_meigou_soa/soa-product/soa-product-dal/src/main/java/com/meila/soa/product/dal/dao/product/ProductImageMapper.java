package com.meila.soa.product.dal.dao.product;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.meila.soa.product.dal.entity.product.ProductImage;

public interface ProductImageMapper {

    int updateForArchive(Long id);

    int updateForUnArchive(Long id);

    int insert(ProductImage record);

    /**
     * 根据商品ID获取所有的Image列表
     * 
     * @param productId
     * @return
     */
    List<ProductImage> selectByProductId(Long productId);

    int updateImgOrder(ProductImage img);

    List<ProductImage> getProductImgs(@Param("productId") Long productId, @Param("type") String type);

    ProductImage selectByImg(@Param("img") String img);

}
