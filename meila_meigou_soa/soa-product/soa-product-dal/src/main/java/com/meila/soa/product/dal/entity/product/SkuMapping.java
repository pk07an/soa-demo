package com.meila.soa.product.dal.entity.product;

import java.util.Date;

import com.meila.common.bean.utils.annotaion.MappingField;

public class SkuMapping {
    private Long productId;

    private String specKey;

    private String specName;

    @MappingField({ "specOrder" })
    private Integer order;

    private Boolean archive;

    @MappingField({ "skuMappingId" })
    private Long id;

    private Date createdAt;

    private Date updatedAt;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Boolean getArchive() {
        return archive;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public Integer getOrder() {
        return order;
    }

    public Long getProductId() {
        return productId;
    }

    public String getSpecKey() {
        return specKey;
    }

    public String getSpecName() {
        return specName;
    }

    public Date getUpdatedAt() {
        return updatedAt;
    }

    public void setArchive(Boolean archive) {
        this.archive = archive;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public void setOrder(Integer order) {
        this.order = order;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    public void setSpecKey(String specKey) {
        this.specKey = specKey == null ? null : specKey.trim();
    }

    public void setSpecName(String specName) {
        this.specName = specName == null ? null : specName.trim();
    }

    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
    }
}
