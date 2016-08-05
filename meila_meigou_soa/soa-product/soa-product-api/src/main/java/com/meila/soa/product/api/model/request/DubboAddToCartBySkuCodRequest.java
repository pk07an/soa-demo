package com.meila.soa.product.api.model.request;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotEmpty;

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
public class DubboAddToCartBySkuCodRequest extends DubboBasicRequest {
    private static final long serialVersionUID = 1L;

    /**
     * 用户id
     */
    @Min(value = 1, message = "用户ID不合法")
    @NotNull(message = "用户ID不能为空")
    private Long userId;

    /**
     * 商品sku
     */
    // @Pattern(regexp = "[a-z0-9]{8,12}", message = "skuCode格式错误")
    @NotEmpty(message = "skuCode不能为空")
    private String skuCode;

    /**
     * 添加到购物车里面的商品数量
     */
    @Min(value = 1, message = "数量不合法")
    private Integer amount;

    /**
     * 购物车类型 分为三种类型 0:普通购买 1:秒杀 2:立即购买
     */
    @Min(value = 0, message = "购物车类型不合法")
    @Max(value = 2, message = "购物车类型不合法")
    @NotNull(message = "购物车类型不能为空")
    private Integer cartType;

    /**
     * 来源
     */
    private String fromSource;

    /**
     * @return the fromSource
     */
    public String getFromSource() {
        return fromSource;
    }

    /**
     * @param fromSource the fromSource to set
     */
    public void setFromSource(String fromSource) {
        this.fromSource = fromSource;
    }

    /**
     * @return the userId
     */
    public Long getUserId() {
        return userId;
    }

    /**
     * @param userId the userId to set
     */
    public void setUserId(Long userId) {
        this.userId = userId;
    }

    /**
     * @return the skuCode
     */
    public String getSkuCode() {
        return skuCode;
    }

    /**
     * @param skuCode the skuCode to set
     */
    public void setSkuCode(String skuCode) {
        this.skuCode = skuCode;
    }

    /**
     * @return the amount
     */
    public Integer getAmount() {
        return amount;
    }

    /**
     * @param amount the amount to set
     */
    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    /**
     * @return the cartType
     */
    public Integer getCartType() {
        return cartType;
    }

    /**
     * @param cartType the cartType to set
     */
    public void setCartType(Integer cartType) {
        this.cartType = cartType;
    }
}
