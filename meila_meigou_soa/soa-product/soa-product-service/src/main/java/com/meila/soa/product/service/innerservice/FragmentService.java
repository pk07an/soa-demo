package com.meila.soa.product.service.innerservice;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.meila.soa.product.dal.entity.fragment.Fragment;
import com.meila.soa.product.dal.entity.fragment.FragmentImage;

public interface FragmentService {

    int insert(Fragment fragment);

    int update(Fragment fragment);

    int delete(Long id);

    Fragment selectById(Long id);

    List<Fragment> selectByProductId(Long productId);

    List<Fragment> selectByShopId(@Param(value = "shopId") Long shopId);

    void moveBefore(Long srcId, Long desId);

    void moveAfter(Long srcId, Long desId);

    void insertFragmentToProduct(Fragment fragment, List<FragmentImage> fragmentImgs, Long productId);

    List<Fragment> selectBySelective(Fragment fragment);
}
