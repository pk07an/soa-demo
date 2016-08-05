package com.meila.soa.product.api.model.request.product;

import javax.validation.constraints.Min;

import com.meila.dubbo.base.model.DubboBasicRequest;

public class DubboQueryBundleRequest extends DubboBasicRequest {
    private static final long serialVersionUID = 1L;

    @Min(value = 1, message = "productId不合法")
    private Long productId;

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }
}
