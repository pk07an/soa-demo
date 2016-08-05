package com.meila.soa.product.api.model.response;

import java.util.ArrayList;
import java.util.List;

import com.meila.dubbo.base.model.DubboBasicPageResponse;
import com.meila.soa.product.api.model.dto.DubboProduct;

public class DubboListProductOfShopResponse extends DubboBasicPageResponse {

    private static final long serialVersionUID = 1L;

    private List<DubboProduct> productList;

    public DubboListProductOfShopResponse() {
        productList = new ArrayList<DubboProduct>();
    }

    public List<DubboProduct> getProductList() {
        return productList;
    }

    public void setProductList(List<DubboProduct> productList) {
        this.productList = productList;
    }

}
