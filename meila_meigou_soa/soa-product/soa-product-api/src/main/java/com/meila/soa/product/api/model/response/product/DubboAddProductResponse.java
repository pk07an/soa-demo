package com.meila.soa.product.api.model.response.product;

import com.meila.dubbo.base.model.DubboBasicResponse;
import com.meila.soa.product.api.model.dto.product.v1.DubboProductV1;

/**
 * 
 ************************************************************
 * @类名 : DubboAddProductResponse.java
 *
 * @DESCRIPTION : 添加商品返回内容
 * @AUTHOR : hawk
 * @DATE : 2016年5月27日
 ************************************************************
 */
public class DubboAddProductResponse extends DubboBasicResponse {
    private static final long serialVersionUID = 1L;

    DubboProductV1 product;

    public DubboProductV1 getProduct() {
        return product;
    }

    public void setProduct(DubboProductV1 product) {
        this.product = product;
    }
}
