package com.meila.soa.product.api.model.request;

import java.util.List;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotBlank;

import com.meila.common.bean.utils.annotaion.MappingField;
import com.meila.dubbo.base.model.DubboBasicRequest;
import com.meila.soa.product.api.model.dto.fragment.DubboFragmentImage;

/**
 * 
 ************************************************************
 * @类名 : DubboAddFragmentRequest.java
 *
 * @DESCRIPTION :添加片段信息
 * @AUTHOR : hawk
 * @DATE : 2016年4月1日
 ************************************************************
 */
public class DubboAddFragmentRequest extends DubboBasicRequest {
    private static final long serialVersionUID = 1L;

    @NotNull(message = "店铺ID不能为空")
    @Min(value = 1, message = "店铺ID不合法")
    private Long shopId;

    @MappingField("id")
    private Long fragmentId;

    @NotBlank(message = "片段名称不能为空")
    private String name;

    private String description;

    @NotNull(message = "showModel不能为空")
    private Boolean showModel;

    @NotNull(message = "图片信息不能为空")
    private List<DubboFragmentImage> fragmentImageList;

    public Long getShopId() {
        return shopId;
    }

    public void setShopId(Long shopId) {
        this.shopId = shopId;
    }

    public Long getFragmentId() {
        return fragmentId;
    }

    public void setFragmentId(Long fragmentId) {
        this.fragmentId = fragmentId;
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

    public Boolean getShowModel() {
        return showModel;
    }

    public void setShowModel(Boolean showModel) {
        this.showModel = showModel;
    }

    public List<DubboFragmentImage> getFragmentImageList() {
        return fragmentImageList;
    }

    public void setFragmentImageList(List<DubboFragmentImage> fragmentImageList) {
        this.fragmentImageList = fragmentImageList;
    }
}
