package com.meila.soa.product.api.model.request.product;

import javax.validation.constraints.Min;

import com.meila.dubbo.base.model.DubboBasicRequest;

/**
 * 
 ************************************************************
 * @类名 : DubboQueryProductBySkuIdRequest.java
 *
 * @DESCRIPTION :
 * @AUTHOR : hawk
 * @DATE : 2016年6月6日
 ************************************************************
 */
public class DubboQueryProductBySkuIdRequest extends DubboBasicRequest {
    private static final long serialVersionUID = 1L;

    @Min(value = 1, message = "skuId不合法")
    private Long skuId;

    public Long getSkuId() {
        return skuId;
    }

    public void setSkuId(Long skuId) {
        this.skuId = skuId;
    }
}
