package com.meila.soa.product.dal.entity.product;

import java.util.Date;

public class SkuWMSInvLog {
    private Long invLogId;

    private String transactionId;

    private String skuId;

    private String type;

    private Integer changeNum;

    private Date reqCreateTime;

    private Boolean archive;

    private Date createTime;

    public Long getInvLogId() {
        return invLogId;
    }

    public void setInvLogId(Long invLogId) {
        this.invLogId = invLogId;
    }

    public String getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(String transactionId) {
        this.transactionId = transactionId;
    }

    public String getSkuId() {
        return skuId;
    }

    public void setSkuId(String skuId) {
        this.skuId = skuId;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Integer getChangeNum() {
        return changeNum;
    }

    public void setChangeNum(Integer changeNum) {
        this.changeNum = changeNum;
    }

    public Date getReqCreateTime() {
        return reqCreateTime;
    }

    public void setReqCreateTime(Date reqCreateTime) {
        this.reqCreateTime = reqCreateTime;
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
}
