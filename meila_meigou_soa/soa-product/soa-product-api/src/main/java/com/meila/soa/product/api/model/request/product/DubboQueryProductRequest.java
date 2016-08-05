package com.meila.soa.product.api.model.request.product;

import javax.validation.constraints.Min;

import com.meila.dubbo.base.model.DubboBasicRequest;

/**
 * 
 ************************************************************
 * @类名 : DubboQueryProductByIdListRequest.java
 *
 * @DESCRIPTION :根据ID列表查询商品基础信息
 * @AUTHOR : hawk
 * @DATE : 2016年5月20日
 ************************************************************
 */
public class DubboQueryProductRequest extends DubboBasicRequest {
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
