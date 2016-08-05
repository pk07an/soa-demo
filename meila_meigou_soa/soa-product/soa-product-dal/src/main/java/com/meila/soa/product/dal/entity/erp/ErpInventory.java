package com.meila.soa.product.dal.entity.erp;

import java.util.Date;

public class ErpInventory {
    private Long erpInveId;

    private String erpSkuId;

    private Integer realAmount;

    private String warehouse;

    private Date createTime;

    private Date updateTime;

    private Boolean archive;

    public Long getErpInveId() {
        return erpInveId;
    }

    public void setErpInveId(Long erpInveId) {
        this.erpInveId = erpInveId;
    }

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

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public Boolean getArchive() {
        return archive;
    }

    public void setArchive(Boolean archive) {
        this.archive = archive;
    }
}
