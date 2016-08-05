package com.meila.soa.product.service.innerservice;

import java.util.List;
import java.util.Map;

import com.meila.soa.product.dal.entity.shop.Shop;
import com.meila.soa.product.dal.entity.shop.ShopAdmin;
import com.meila.soa.product.dal.entity.shop.ShopExt;
import com.meila.soa.product.service.model.ShopModel;

public interface ShopService {
    ShopModel loadShopAndExt(Long shopId);

    /**
     * 通过id查找店铺
     * 
     * @param id
     * @return
     */
    Shop load(Long id);

    /**
     * 管理员创建店铺
     * 
     * @param shop
     * @return
     */
    Shop createByAdmin(Shop shop);

    Shop findByName(String shopName);

    int updateShop(Shop shop);

    int updateShopExt(ShopExt shopExt);

    int insertShopExt(ShopExt shopExt);

    void updateShopAndExt(Shop shop, ShopExt shopExt);

    int update(Shop shop);

    List<ShopAdmin> listShopsByAdmin(Map<String, Object> params, Map<String, Long> pageable);

    Long countShopsByAdmin(Map<String, Object> params);

    List<Shop> selectShopByUserIdList(List<Long> ownerIdList);

    List<ShopExt> selectShopExtByUserIdList(List<Long> ownerIdList);
}
