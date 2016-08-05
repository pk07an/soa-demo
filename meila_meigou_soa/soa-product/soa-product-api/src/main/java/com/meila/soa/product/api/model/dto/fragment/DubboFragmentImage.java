package com.meila.soa.product.api.model.dto.fragment;

import java.util.Date;

import com.meila.common.bean.utils.annotaion.MappingField;
import com.meila.dubbo.base.model.BasicSeriModel;

public class DubboFragmentImage extends BasicSeriModel {
    private static final long serialVersionUID = 1L;

    @MappingField("id")
    private Long fragmentImageId;

    private Long fragmentId;

    private String img;

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

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
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
