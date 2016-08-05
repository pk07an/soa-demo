package com.meila.soa.product.api.model.request;

import com.meila.dubbo.base.model.DubboBasicRequest;

/**
 ************************************************************
 * @类名 : DubboAddToCartRequest.java
 *
 * @DESCRIPTION :添加购物车请求类
 * @AUTHOR : hawk
 * @DATE : 2016年1月26日
 ************************************************************
 */
public class DubboAddToCartRequest extends DubboBasicRequest {
    private static final long serialVersionUID = 1L;

    /**
     * 用户id
     */
    private Long userId;

    /**
     * 商品sku
     */
    private Long skuId;

    /**
     * 添加到购物车里面的商品数量
     */
    private Integer amount;

    /**
     * 购物车类型 分为三种类型 0:普通购买 1:秒杀 2:立即购买
     */
    private Integer cartType;

    /**
     * 来源
     */
    private String fromSource;

    /**
     * @return the amount
     */
    public Integer getAmount() {
        return amount;
    }

    /**
     * @return the cartType
     */
    public Integer getCartType() {
        return cartType;
    }

    /**
     * @return the fromSource
     */
    public String getFromSource() {
        return fromSource;
    }

    /**
     * @return the skuId
     */
    public Long getSkuId() {
        return skuId;
    }

    /**
     * @return the userId
     */
    public Long getUserId() {
        return userId;
    }

    /**
     * @param amount the amount to set
     */
    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    /**
     * @param cartType the cartType to set
     */
    public void setCartType(Integer cartType) {
        this.cartType = cartType;
    }

    /**
     * @param fromSource the fromSource to set
     */
    public void setFromSource(String fromSource) {
        this.fromSource = fromSource;
    }

    /**
     * @param skuId the skuId to set
     */
    public void setSkuId(Long skuId) {
        this.skuId = skuId;
    }

    /**
     * @param userId the userId to set
     */
    public void setUserId(Long userId) {
        this.userId = userId;
    }
}
