package com.meila.soa.product.dal.entity.product;

import java.util.Date;

public class SkuWMSInv {
    private Long skuInvId;

    private String skuId;

    private Integer realInv;

    private Integer lockInv;

    private Boolean archive;

    private Date createTime;

    private Date updateTime;

    public Long getSkuInvId() {
        return skuInvId;
    }

    public void setSkuInvId(Long skuInvId) {
        this.skuInvId = skuInvId;
    }

    public String getSkuId() {
        return skuId;
    }

    public void setSkuId(String skuId) {
        this.skuId = skuId;
    }

    public Integer getRealInv() {
        return realInv;
    }

    public void setRealInv(Integer realInv) {
        this.realInv = realInv;
    }

    public Integer getLockInv() {
        return lockInv;
    }

    public void setLockInv(Integer lockInv) {
        this.lockInv = lockInv;
    }

    public Boolean getArchive() {
        return archive;
    }

    public void setArchive(Boolean archive) {
        this.archive = archive;
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
}
