package com.meila.soa.product.dal.entity;

import java.util.Date;

public class PostAgeSet {
    private Long id;

    private Long shopId;

    private String postageSet;

    private Date createdAt;// 插入逻辑在mysql实现，只查询

    private Date updatedAt;// 更新逻辑在mysql实现，只查询

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
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

    public Long getShopId() {
        return shopId;
    }

    public void setShopId(Long shopId) {
        this.shopId = shopId;
    }

    public String getPostageSet() {
        return postageSet;
    }

    public void setPostageSet(String postageSet) {
        this.postageSet = postageSet;
    }
}
