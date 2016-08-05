package com.meila.soa.product.dal.dao.shop;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.meila.soa.product.dal.entity.shop.ShopExt;
import com.meila.soa.product.dal.entity.shop.ShopExtExample;

public interface ShopExtMapper {

    List<ShopExt> selectByExample(ShopExtExample example);

    List<ShopExt> selectByShopIds(@Param("shopIds") List<Long> shopIds);

    int updateByPrimaryKeySelective(ShopExt shopExt);

    int insertAutoKey(ShopExt shopExt);
}
