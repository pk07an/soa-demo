package com.meila.soa.product.api.model.dto;

import java.util.Date;

import com.meila.dubbo.base.model.BasicSeriModel;

public class DubboTag extends BasicSeriModel {

    private static final long serialVersionUID = 1L;

    private String tagId;

    private String tag;

    private String creatorId;

    private Date createdTime;

    private Date updatedTime;

    public String getTagId() {
        return tagId;
    }

    public void setTagId(String tagId) {
        this.tagId = tagId;
    }

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }

    public String getCreatorId() {
        return creatorId;
    }

    public void setCreatorId(String creatorId) {
        this.creatorId = creatorId;
    }

    public Date getCreatedTime() {
        return createdTime;
    }

    public void setCreatedTime(Date createdTime) {
        this.createdTime = createdTime;
    }

    public Date getUpdatedTime() {
        return updatedTime;
    }

    public void setUpdatedTime(Date updatedTime) {
        this.updatedTime = updatedTime;
    }
}
