package com.meila.soa.product.api.model.dto.product.v1;

import java.util.Date;
import java.util.List;

import com.meila.dubbo.base.model.BasicSeriModel;

public class DubboSkuMappingV1 extends BasicSeriModel {
    private static final long serialVersionUID = 1L;

    private String skuMappingId;

    private String productId;

    private String specKey;

    private String specName;

    private Integer specOrder;

    private Boolean archive;

    private Date createTime;

    private Date updateTime;

    private List<String> mappingValues;

    public List<String> getMappingValues() {
        return mappingValues;
    }

    public void setMappingValues(List<String> mappingValues) {
        this.mappingValues = mappingValues;
    }

    public String getSkuMappingId() {
        return skuMappingId;
    }

    public void setSkuMappingId(String skuMappingId) {
        this.skuMappingId = skuMappingId;
    }

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public String getSpecKey() {
        return specKey;
    }

    public void setSpecKey(String specKey) {
        this.specKey = specKey;
    }

    public String getSpecName() {
        return specName;
    }

    public void setSpecName(String specName) {
        this.specName = specName;
    }

    public Integer getSpecOrder() {
        return specOrder;
    }

    public void setSpecOrder(Integer specOrder) {
        this.specOrder = specOrder;
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
