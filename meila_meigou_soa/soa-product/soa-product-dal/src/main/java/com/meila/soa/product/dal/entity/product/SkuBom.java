package com.meila.soa.product.dal.entity.product;

import java.math.BigDecimal;
import java.util.Date;

import com.meila.common.bean.utils.annotaion.MappingField;

public class SkuBom {

    @MappingField({ "bundleInfoId", "skuBundleInfoId" })
    private Long id;

    /**
     * 套餐sku id
     */
    @MappingField({ "bundleId", "skuBundleId" })
    private Long spuId;

    /**
     * 套餐SKU所包含的子sku id
     */
    private Long subSkuId;

    /**
     * 套餐中的搭配数量
     */
    private Integer matchCount;

    /** 报关价格，单价 */
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
