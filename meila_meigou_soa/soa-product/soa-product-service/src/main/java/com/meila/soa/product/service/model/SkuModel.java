package com.meila.soa.product.service.model;

import com.meila.soa.product.dal.entity.product.Sku;
import com.meila.soa.product.dal.entity.product.SkuExt;

public class SkuModel {
    private Sku sku;
    private SkuExt skuExt;

    public Sku getSku() {
        return sku;
    }

    public void setSku(Sku sku) {
        this.sku = sku;
    }

    public SkuExt getSkuExt() {
        return skuExt;
    }

    public void setSkuExt(SkuExt skuExt) {
        this.skuExt = skuExt;
    }
}
