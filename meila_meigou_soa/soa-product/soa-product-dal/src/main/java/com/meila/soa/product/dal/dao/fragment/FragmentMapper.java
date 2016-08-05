package com.meila.soa.product.dal.dao.fragment;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.meila.soa.product.dal.entity.fragment.Fragment;

public interface FragmentMapper {

    int insert(Fragment fragment);

    int update(Fragment fragment);

    int deleteById(@Param(value = "id") Long id);

    Integer selectMaxByShopId(@Param(value = "shopId") Long shopId);

    Fragment selectById(@Param(value = "id") Long id);

    List<Fragment> selectByShopId(@Param(value = "shopId") Long shopId);

    List<Fragment> selectByProductId(@Param(value = "productId") Long productId);

    void incAllBeforeDest(@Param(value = "shopId") Long shopId, @Param(value = "idx") int idx, @Param(value = "increment") int increment);

    void decAllAfterDest(@Param(value = "shopId") Long shopId, @Param(value = "idx") int idx, @Param(value = "increment") int increment);

    int updateSrcIdx(@Param(value = "id") Long id, @Param(value = "idx") int idx);

    int addCode(@Param("id") Long id);

    List<Fragment> selectBySelective(Fragment fragment);
}
