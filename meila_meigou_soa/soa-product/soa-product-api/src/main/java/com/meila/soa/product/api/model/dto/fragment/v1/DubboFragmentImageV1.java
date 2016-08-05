package com.meila.soa.product.api.model.dto.fragment.v1;

import java.util.Date;

import com.meila.dubbo.base.model.BasicSeriModel;

public class DubboFragmentImageV1 extends BasicSeriModel {
    private static final long serialVersionUID = 1L;

    private Long fragmentImageId;

    private Long fragmentId;

    private String fragmentImg;

    private Integer imgWidth;

    private Integer imgHeight;

    private Integer idx;

    private Date createdAt;

    private Date updateAt;

    public Date getUpdateAt() {
        return updateAt;
    }

    public void setUpdateAt(Date updateAt) {
        this.updateAt = updateAt;
    }

    public Long getFragmentImageId() {
        return fragmentImageId;
    }

    public void setFragmentImageId(Long fragmentImageId) {
        this.fragmentImageId = fragmentImageId;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public Long getFragmentId() {
        return fragmentId;
    }

    public void setFragmentId(Long fragmentId) {
        this.fragmentId = fragmentId;
    }

    public String getFragmentImg() {
        return fragmentImg;
    }

    public void setFragmentImg(String fragmentImg) {
        this.fragmentImg = fragmentImg;
    }

    public Integer getIdx() {
        return idx;
    }

    public void setIdx(Integer idx) {
        this.idx = idx;
    }

    public Integer getImgWidth() {
        return imgWidth;
    }

    public void setImgWidth(Integer imgWidth) {
        this.imgWidth = imgWidth;
    }

    public Integer getImgHeight() {
        return imgHeight;
    }

    public void setImgHeight(Integer imgHeight) {
        this.imgHeight = imgHeight;
    }
}
