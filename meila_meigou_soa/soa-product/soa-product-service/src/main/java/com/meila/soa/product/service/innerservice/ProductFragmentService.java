package com.meila.soa.product.service.innerservice;

import java.util.List;

import com.meila.soa.product.dal.entity.fragment.ProductFragment;

public interface ProductFragmentService {
    int insert(ProductFragment productFragment);

    int deleteById(Long id);

    int deleteByProductId(Long productId);

    List<ProductFragment> selectByProductId(Long productId);

    void moveBefore(Long srcId, Long desId);

    void moveAfter(Long srcId, Long desId);
}
