package com.meila.soa.meila.client.model;

import java.io.Serializable;

/**
 ************************************************************
 * @类名 : ProductInventoryDto.java
 *
 * @DESCRIPTION :商品库存
 * @AUTHOR : Toney
 * @DATE : 2015年11月25日
 ************************************************************
 */
public class ProductInventoryDto implements Serializable {

    /**
     * 
     */
    private static final long serialVersionUID = 1L;

    private Long sellerId;
    private Long skuId;

    public Long getSellerId() {
        return sellerId;
    }

    public void setSellerId(Long sellerId) {
        this.sellerId = sellerId;
    }

    public Long getSkuId() {
        return skuId;
    }

    public void setSkuId(Long skuId) {
        this.skuId = skuId;
    }

}
