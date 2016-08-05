package com.meila.soa.product.api.model.response;

import java.math.BigDecimal;

import com.meila.dubbo.base.model.DubboBasicResponse;

public class DubboAddCartResponse extends DubboBasicResponse {

    private static final long serialVersionUID = 1L;

    private Long itemId;

    private Long productId;

    private Long skuId;

    private BigDecimal price;

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    public Long getSkuId() {
        return skuId;
    }

    public void setSkuId(Long skuId) {
        this.skuId = skuId;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public Long getItemId() {
        return itemId;
    }

    public void setItemId(Long itemId) {
        this.itemId = itemId;
    }
}
