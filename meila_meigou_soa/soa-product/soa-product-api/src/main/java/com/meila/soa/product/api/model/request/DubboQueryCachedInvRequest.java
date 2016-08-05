package com.meila.soa.product.api.model.request;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import com.meila.dubbo.base.model.DubboBasicPageRequest2;

/**
 ************************************************************
 * @类名 : DubboAddToCartRequest.java
 *
 * @DESCRIPTION :添加购物车请求类
 * @AUTHOR : hawk
 * @DATE : 2016年1月26日
 ************************************************************
 */
public class DubboQueryCachedInvRequest extends DubboBasicPageRequest2 {
    private static final long serialVersionUID = 1L;

    /**
     * 卖家ID
     */
    @NotNull(message = "卖家ID不能为空")
    @Min(value = 1, message = "卖家ID不合法")
    private Long sellerId;

    /**
     * 商品名称
     */
    private String productName;

    /**
     * 储存类型标志
     */
    @Pattern(regexp = "SPOT|NON_SPOT")
    private String storageType;

    public String getStorageType() {
        return storageType;
    }

    public void setStorageType(String storageType) {
        this.storageType = storageType;
    }

    /**
     * @return the sellerId
     */
    public Long getSellerId() {
        return sellerId;
    }

    /**
     * @param sellerId the sellerId to set
     */
    public void setSellerId(Long sellerId) {
        this.sellerId = sellerId;
    }

    /**
     * @return the productName
     */
    public String getProductName() {
        return productName;
    }

    /**
     * @param productName the productName to set
     */
    public void setProductName(String productName) {
        this.productName = productName;
    }
}
