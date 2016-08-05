package com.meila.soa.product.api.model.request.product.v1;

import javax.validation.constraints.Pattern;

import com.meila.dubbo.base.model.DubboBasicPageRequest;

/**
 * 
 ************************************************************
 * @类名 : DubboQuerySpuListRequest.java
 *
 * @DESCRIPTION : 分页查询商品SPU列表
 * @AUTHOR : hawk
 * @DATE : 2016年3月9日
 ************************************************************
 */
public class DubboQuerySkuRequestV1 extends DubboBasicPageRequest {
    private static final long serialVersionUID = 1L;

    private Long userId;

    @Pattern(regexp = "NORMAL|SPU", message = "skuType不合法")
    private String skuType;

    private Long productId;

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getSkuType() {
        return skuType;
    }

    public void setSkuType(String skuType) {
        this.skuType = skuType;
    }

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

}
