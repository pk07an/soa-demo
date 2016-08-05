package com.meila.soa.product.dal.entity.fragment;

import java.util.Date;

import com.meila.common.bean.utils.annotaion.MappingField;

public class Fragment {

    @MappingField({ "fragmentId" })
    private Long id;

    private Long shopId;

    @MappingField({ "fragmentName" })
    private String name;

    private String description;

    private Boolean showModel;// true,文字靠前，false图片靠前

    private Integer idx;

    @MappingField({ "fragmentCode" })
    private String code;

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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getIdx() {
        return idx;
    }

    public void setIdx(Integer idx) {
        this.idx = idx;
    }

    public Boolean getShowModel() {
        return showModel;
    }

    public void setShowModel(Boolean showModel) {
        this.showModel = showModel;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }
}
