package com.meila.soa.product.api.model.dto;

import com.meila.dubbo.base.model.BasicSeriModel;

public class DubboInventory extends BasicSeriModel {
    private static final long serialVersionUID = 1L;

    private String erpSkuId;

    private String batchNo;

    public String getBatchNo() {
        return batchNo;
    }

    public void setBatchNo(String batchNo) {
        this.batchNo = batchNo;
    }

    private Integer realAmount;

    private String warehouse;

    private Boolean archive;

    public String getErpSkuId() {
        return erpSkuId;
    }

    public void setErpSkuId(String erpSkuId) {
        this.erpSkuId = erpSkuId;
    }

    public Integer getRealAmount() {
        return realAmount;
    }

    public void setRealAmount(Integer realAmount) {
        this.realAmount = realAmount;
    }

    public String getWarehouse() {
        return warehouse;
    }

    public void setWarehouse(String warehouse) {
        this.warehouse = warehouse;
    }

    public Boolean getArchive() {
        return archive;
    }

    public void setArchive(Boolean archive) {
        this.archive = archive;
    }
}
