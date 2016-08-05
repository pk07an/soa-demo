package com.meila.soa.product.api.model.response.product;

import java.util.List;

import com.meila.dubbo.base.model.DubboBasicPageResponse;
import com.meila.soa.product.api.model.dto.product.v1.DubboBundleV1;

public class DubboQuerySkuBundleResponse extends DubboBasicPageResponse {

    private static final long serialVersionUID = 1L;

    List<DubboBundleV1> skuBundleList;

    public List<DubboBundleV1> getSkuBundleList() {
        return skuBundleList;
    }

    public void setSkuBundleList(List<DubboBundleV1> skuBundleList) {
        this.skuBundleList = skuBundleList;
    }
}
