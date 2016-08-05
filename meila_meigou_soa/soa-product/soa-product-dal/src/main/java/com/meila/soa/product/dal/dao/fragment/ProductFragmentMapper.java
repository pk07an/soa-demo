package com.meila.soa.product.dal.dao.fragment;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.meila.soa.product.dal.entity.fragment.ProductFragment;

public interface ProductFragmentMapper {
    int insert(ProductFragment productFragment);

    int deleteById(Long id);

    Integer selectMaxByProductId(Long productId);

    ProductFragment selectById(Long id);

    List<ProductFragment> selectByProductId(Long productId);

    int deleteByProductId(@Param(value = "productId") Long productId);

    void incAllBeforeDest(@Param(value = "productId") Long productId, @Param(value = "idx") int idx, @Param(value = "increment") int increment);

    void decAllAfterDest(@Param(value = "productId") Long productId, @Param(value = "idx") int idx, @Param(value = "increment") int increment);

    int updateSrcIdx(@Param(value = "id") Long id, @Param(value = "idx") int idx);
}
