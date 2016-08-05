package com.meila.soa.product.dal.entity;

import java.util.Date;

public class Zone {
    private String id;
    private String name;

    private String zipCode;

    private String path;

    private String parentId;

    private String zoneTag;

    private Boolean archive;

    private Date createdAt;// 插入逻辑在mysql实现，只查询
    private Date updatedAt;// 更新逻辑在mysql实现，只查询

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public String getParentId() {
        return parentId;
    }

    public void setParentId(String parentId) {
        this.parentId = parentId;
    }

    public Boolean getArchive() {
        return archive;
    }

    public void setArchive(Boolean archive) {
        this.archive = archive;
    }

    public String getZoneTag() {
        return zoneTag;
    }

    public void setZoneTag(String zoneTag) {
        this.zoneTag = zoneTag;
    }
}
