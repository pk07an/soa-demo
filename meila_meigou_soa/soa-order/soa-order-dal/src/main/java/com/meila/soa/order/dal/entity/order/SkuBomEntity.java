package com.meila.soa.order.dal.entity.order;

import java.math.BigDecimal;
import java.util.Date;

public class SkuBomEntity {
    private Long id;

    private Long spuId;

    private Long subSkuId;

    private Integer matchCount;

    private BigDecimal clearancePrice;

    private Boolean archive;

    private Date createdAt;

    private Date updatedAt;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getSpuId() {
        return spuId;
    }

    public void setSpuId(Long spuId) {
        this.spuId = spuId;
    }

    public Long getSubSkuId() {
        return subSkuId;
    }

    public void setSubSkuId(Long subSkuId) {
        this.subSkuId = subSkuId;
    }

    public Integer getMatchCount() {
        return matchCount;
    }

    public void setMatchCount(Integer matchCount) {
        this.matchCount = matchCount;
    }

    public BigDecimal getClearancePrice() {
        return clearancePrice;
    }

    public void setClearancePrice(BigDecimal clearancePrice) {
        this.clearancePrice = clearancePrice;
    }

    public Boolean getArchive() {
        return archive;
    }

    public void setArchive(Boolean archive) {
        this.archive = archive;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public Date getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
    }
}