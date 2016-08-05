package com.meila.soa.product.service.model;

import com.meila.soa.product.dal.entity.shop.Shop;
import com.meila.soa.product.dal.entity.shop.ShopExt;

/**
 * 
 ************************************************************
 * @类名 : ShopModel.java
 *
 * @DESCRIPTION :shop信息与shop扩展信息封装类
 * @AUTHOR : hawk
 * @DATE : 2016年2月19日
 ************************************************************
 */
public class ShopModel {

    private Shop shop;
    private ShopExt shopExt;

    /**
     * @return the shop
     */
    public Shop getShopEntity() {
        return shop;
    }

    /**
     * @param shop the shop to set
     */
    public void setShopEntity(Shop shop) {
        this.shop = shop;
    }

    /**
     * @return the shopExt
     */
    public ShopExt getShopExtEntity() {
        return shopExt;
    }

    /**
     * @param shopExt the shopExt to set
     */
    public void setShopExtEntity(ShopExt shopExt) {
        this.shopExt = shopExt;
    }
}
