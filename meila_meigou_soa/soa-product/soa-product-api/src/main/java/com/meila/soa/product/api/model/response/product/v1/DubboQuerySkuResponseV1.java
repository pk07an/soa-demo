package com.meila.soa.product.api.model.response.product.v1;

import java.util.List;

import com.meila.dubbo.base.model.DubboBasicPageResponse;
import com.meila.soa.product.api.model.dto.product.v1.DubboSkuMappingV1;
import com.meila.soa.product.api.model.dto.product.v1.DubboSkuV1;

public class DubboQuerySkuResponseV1 extends DubboBasicPageResponse {

    private static final long serialVersionUID = 1L;

    private List<DubboSkuV1> skuList;

    private List<DubboSkuMappingV1> skuMappingList;

    public List<DubboSkuMappingV1> getSkuMappingList() {
        return skuMappingList;
    }

    public void setSkuMappingList(List<DubboSkuMappingV1> skuMappingList) {
        this.skuMappingList = skuMappingList;
    }

    public List<DubboSkuV1> getSkuList() {
        return skuList;
    }

    public void setSkuList(List<DubboSkuV1> skuList) {
        this.skuList = skuList;
    }
}
