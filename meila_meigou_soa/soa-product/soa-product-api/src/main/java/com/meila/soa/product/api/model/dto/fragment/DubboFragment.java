package com.meila.soa.product.api.model.dto.fragment;

import java.util.Date;
import java.util.List;

import com.meila.common.bean.utils.annotaion.MappingField;
import com.meila.dubbo.base.model.BasicSeriModel;

public class DubboFragment extends BasicSeriModel {
    private static final long serialVersionUID = 1L;

    @MappingField("id")
    private Long fragmentId;

    private Long shopId;

    private String name;

    private String description;

    // true,文字靠前，false图片靠前
    private Boolean showModel;

    private Integer idx;

    private String code;

    private Date createdAt;

    private Date updatedAt;

    private List<DubboFragmentImage> fragmentImageList;

    public List<DubboFragmentImage> getFragmentImageList() {
        return fragmentImageList;
    }

    public void setFragmentImageList(List<DubboFragmentImage> fragmentImageList) {
        this.fragmentImageList = fragmentImageList;
    }

    public Long getFragmentId() {
        return fragmentId;
    }

    public void setFragmentId(Long fragmentId) {
        this.fragmentId = fragmentId;
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
