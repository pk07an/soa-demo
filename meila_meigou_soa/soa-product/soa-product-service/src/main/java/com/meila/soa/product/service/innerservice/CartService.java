package com.meila.soa.product.service.innerservice;

import com.meila.soa.product.dal.entity.cart.CartItem;
import com.meila.soa.product.dal.entity.product.Sku;

/**
 * 
 ************************************************************
 * @类名 : CartService.java
 *
 * @DESCRIPTION :美啦购物车接口
 * @AUTHOR : hawk
 * @DATE : 2016年1月26日
 ************************************************************
 */
public interface CartService {

    /**
     * 
     * 功能描述： 添加到购物车接口
     * 
     * @param userId
     * @param amount
     * @param cartType void
     * @param fromSource TODO
     * @param skuId
     *
     */
    CartItem addToCart(Long userId, Sku sku, Integer amount, Integer cartType, String fromSource);

}
