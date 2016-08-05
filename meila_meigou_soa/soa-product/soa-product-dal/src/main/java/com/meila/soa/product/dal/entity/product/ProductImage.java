package com.meila.soa.product.dal.entity.product;

import java.util.Date;

import com.meila.common.bean.utils.annotaion.MappingField;

public class ProductImage {
    @MappingField({ "productImgId" })
    private Long id;

    /**
     * SPU ID
     */
    private Long productId;

    /**
     * 图片路径
     */
    @MappingField({ "productImg" })
    private String img;

    /**
     * 图片宽度
     */
    private Integer imgWidth;

    /**
     * 图片高度
     */
    private Integer imgHeight;

    /**
     * 逻辑删除
     */
    private Boolean archive;

    /**
     * 图片顺序
     */
    private Integer imgOrder;

    /**
     * 图片类型
     */
    @MappingField({ "imgType" })
    private Integer type;

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

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
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

    public Boolean getArchive() {
        return archive;
    }

    public void setArchive(Boolean archive) {
        this.archive = archive;
    }

    public int getImgOrder() {
        return imgOrder;
    }

    public void setImgOrder(int imgOrder) {
        this.imgOrder = imgOrder;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

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
}
