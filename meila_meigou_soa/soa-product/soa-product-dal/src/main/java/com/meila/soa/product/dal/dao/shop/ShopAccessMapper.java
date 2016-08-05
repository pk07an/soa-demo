package com.meila.soa.product.dal.dao.shop;

import java.util.Date;
import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.meila.soa.product.dal.entity.shop.ShopAccess;

public interface ShopAccessMapper {
    int insert(ShopAccess record);

    List<ShopAccess> selectShopAccessByShopId(@Param(value = "shopId") String shopId, @Param(value = "date") Date date);

    int updatePvByPrimaryKey(ShopAccess record);

    int countByShopId(@Param(value = "shopId") String shopId, @Param(value = "date") Date date);
}
