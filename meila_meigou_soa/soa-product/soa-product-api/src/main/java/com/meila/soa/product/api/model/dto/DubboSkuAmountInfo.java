package com.meila.soa.product.api.model.dto;

import com.meila.dubbo.base.model.BasicSeriModel;

public class DubboSkuAmountInfo extends BasicSeriModel {
    private static final long serialVersionUID = 1L;

    /**
     * skuId或者ERPSkulId
     */
    private String skuId;

    /**
     * 锁定库存数量或者回退的数量
     */
    private Integer amount;

    public String getSkuId() {
        return skuId;
    }

    public void setSkuId(String skuId) {
        this.skuId = skuId;
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    public static long getSerialversionuid() {
        return serialVersionUID;
    }
}
