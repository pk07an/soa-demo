package com.meila.soa.product.api.model.dto.fragment.v1;

import java.util.Date;
import java.util.List;

import com.meila.dubbo.base.model.BasicSeriModel;

public class DubboFragmentV1 extends BasicSeriModel {
    private static final long serialVersionUID = 1L;

    private Long fragmentId;

    private Long shopId;

    private String fragmentName;

    private String description;

    // true,文字靠前，false图片靠前
    private Boolean showModel;

    private Integer idx;

    private String fragmentCode;

    private Date createdAt;

    private Date updatedAt;

    private List<DubboFragmentImageV1> fragmentImageList;

    public List<DubboFragmentImageV1> getFragmentImageList() {
        return fragmentImageList;
    }

    public void setFragmentImageList(List<DubboFragmentImageV1> fragmentImageList) {
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

    public String getFragmentName() {
        return fragmentName;
    }

    public void setFragmentName(String fragmentName) {
        this.fragmentName = fragmentName;
    }

    public String getFragmentCode() {
        return fragmentCode;
    }

    public void setFragmentCode(String fragmentCode) {
        this.fragmentCode = fragmentCode;
    }
}
