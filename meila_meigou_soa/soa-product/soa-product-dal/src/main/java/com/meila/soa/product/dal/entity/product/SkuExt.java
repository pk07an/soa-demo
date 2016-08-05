package com.meila.soa.product.dal.entity.product;

import java.util.Date;

public class SkuExt {
    private Long id;

    private Long skuId;

    private String hsCode;

    private String qtyUnit;

    private String hgRecordNo;

    private String ciqRecordNo;

    private Date createdAt;

    private Long createdId;

    private Date updatedAt;

    private Long updatedId;

    // 库中没有这两个字段
    private Integer realAmount; // 实库
    private Integer availableAmount; // 可用库存

    private String outsideSkuCode;

    public String getOutsideSkuCode() {
        return outsideSkuCode;
    }

    public void setOutsideSkuCode(String outsideSkuCode) {
        this.outsideSkuCode = outsideSkuCode;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getSkuId() {
        return skuId;
    }

    public void setSkuId(Long skuId) {
        this.skuId = skuId;
    }

    public String getHsCode() {
        return hsCode;
    }

    public void setHsCode(String hsCode) {
        this.hsCode = hsCode == null ? null : hsCode.trim();
    }

    public String getQtyUnit() {
        return qtyUnit;
    }

    public void setQtyUnit(String qtyUnit) {
        this.qtyUnit = qtyUnit == null ? null : qtyUnit.trim();
    }

    public String getHgRecordNo() {
        return hgRecordNo;
    }

    public void setHgRecordNo(String hgRecordNo) {
        this.hgRecordNo = hgRecordNo == null ? null : hgRecordNo.trim();
    }

    public String getCiqRecordNo() {
        return ciqRecordNo;
    }

    public void setCiqRecordNo(String ciqRecordNo) {
        this.ciqRecordNo = ciqRecordNo == null ? null : ciqRecordNo.trim();
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public Long getCreatedId() {
        return createdId;
    }

    public void setCreatedId(Long createdId) {
        this.createdId = createdId;
    }

    public Date getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
    }

    public Long getUpdatedId() {
        return updatedId;
    }

    public void setUpdatedId(Long updatedId) {
        this.updatedId = updatedId;
    }

    public Integer getRealAmount() {
        return realAmount;
    }

    public void setRealAmount(Integer realAmount) {
        this.realAmount = realAmount;
    }

    public Integer getAvailableAmount() {
        return availableAmount;
    }

    public void setAvailableAmount(Integer availableAmount) {
        this.availableAmount = availableAmount;
    }
}
