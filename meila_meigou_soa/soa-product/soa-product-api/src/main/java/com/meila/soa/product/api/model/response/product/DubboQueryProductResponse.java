package com.meila.soa.product.api.model.response.product;

import java.util.ArrayList;
import java.util.List;

import com.meila.dubbo.base.model.DubboBasicPageResponse;
import com.meila.soa.product.api.model.dto.product.v1.DubboProductV1;

public class DubboQueryProductResponse extends DubboBasicPageResponse {

    private static final long serialVersionUID = 1L;

    private List<DubboProductV1> productList;

    public DubboQueryProductResponse() {
        productList = new ArrayList<DubboProductV1>();
    }

    public List<DubboProductV1> getProductList() {
        return productList;
    }

    public void setProductList(List<DubboProductV1> productList) {
        this.productList = productList;
    }
}
