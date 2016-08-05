package com.meila.soa.product.api.model.request.fragment;

import com.meila.dubbo.base.model.DubboBasicRequest;

public class DubboQueryFragmentByProductIdRequest extends DubboBasicRequest {
    private static final long serialVersionUID = 1L;

    private Long productId;

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }
}
