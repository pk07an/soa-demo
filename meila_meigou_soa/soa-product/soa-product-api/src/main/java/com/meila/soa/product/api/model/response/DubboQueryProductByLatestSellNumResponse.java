package com.meila.soa.product.api.model.response;

import java.util.List;

import com.meila.dubbo.base.model.DubboBasicPageResponse;
import com.meila.soa.product.api.model.dto.DubboProduct;

public class DubboQueryProductByLatestSellNumResponse extends DubboBasicPageResponse {

    private static final long serialVersionUID = 1L;

    private List<DubboProduct> productList;

    public List<DubboProduct> getProductList() {
        return productList;
    }

    public void setProductList(List<DubboProduct> productList) {
        this.productList = productList;
    }
}
