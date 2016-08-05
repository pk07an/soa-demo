package com.meila.soa.product.api.model.dto.product.v1;

import java.util.Date;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotBlank;

import com.meila.dubbo.base.model.BasicSeriModel;

public class DubboProductImg extends BasicSeriModel {

    /**
     * 
     */
    private static final long serialVersionUID = 1L;

    /**
     * 商品ID
     */
    private Long productId;

    /**
     * 图片宽度
     */
    @NotNull(message = "图片宽度信息不能为空")
    @Min(value = 1, message = "图片宽度信息不合法")
    private Integer imgWidth;

    /**
     * 图片高度
     */
    @NotNull(message = "图片高度信息不能为空")
    @Min(value = 1, message = "图片高度信息不合法")
    private Integer imgHeight;

    /**
     * 图片url
     */
    @NotBlank(message = "图片信息不能为空")
    private String productImg;

    /**
     * 图片顺序
     */
    private Integer imgOrder;

    /**
     * 图片类型
     */
    private Integer imgType;

    /**
     * 创建时间
     */
    private Date createdAt;

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
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

    public String getProductImg() {
        return productImg;
    }

    public void setProductImg(String productImg) {
        this.productImg = productImg;
    }

    public Integer getImgOrder() {
        return imgOrder;
    }

    public void setImgOrder(Integer imgOrder) {
        this.imgOrder = imgOrder;
    }

    public Integer getImgType() {
        return imgType;
    }

    public void setImgType(Integer imgType) {
        this.imgType = imgType;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }
}
