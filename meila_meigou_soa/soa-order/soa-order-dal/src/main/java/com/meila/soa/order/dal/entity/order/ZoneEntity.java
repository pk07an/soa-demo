package com.meila.soa.order.dal.entity.order;

import java.util.Date;

public class ZoneEntity {
    private Long id;

    private String name;

    private String zipCode;

    private String path;

    private Long parentId;

    private Integer creatorId;

    private Byte archive;

    private Date createdAt;

    private Date updatedAt;

    private String zoneTag;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public Long getParentId() {
        return parentId;
    }

    public void setParentId(Long parentId) {
        this.parentId = parentId;
    }

    public Integer getCreatorId() {
        return creatorId;
    }

    public void setCreatorId(Integer creatorId) {
        this.creatorId = creatorId;
    }

    public Byte getArchive() {
        return archive;
    }

    public void setArchive(Byte archive) {
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

    public String getZoneTag() {
        return zoneTag;
    }

    public void setZoneTag(String zoneTag) {
        this.zoneTag = zoneTag;
    }
}