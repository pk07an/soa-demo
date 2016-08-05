package com.meila.soa.order.dal.entity.order;

import java.math.BigDecimal;
import java.util.Date;

public class OrderItemEntity {
    private Long id;

    private Long orderId;

    private Long productId;

    private Long skuId;

    private String productName;

    private String skuStr;

    private String productImg;

    private BigDecimal price;

    private BigDecimal marketPrice;

    private Integer amount;

    private Boolean archive;

    private Date createdAt;

    private Date updatedAt;

    private Integer productImgWidth;

    private Integer productImgHeight;

    private Boolean refundFlag;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    public Long getSkuId() {
        return skuId;
    }

    public void setSkuId(Long skuId) {
        this.skuId = skuId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getSkuStr() {
        return skuStr;
    }

    public void setSkuStr(String skuStr) {
        this.skuStr = skuStr;
    }

    public String getProductImg() {
        return productImg;
    }

    public void setProductImg(String productImg) {
        this.productImg = productImg;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public BigDecimal getMarketPrice() {
        return marketPrice;
    }

    public void setMarketPrice(BigDecimal marketPrice) {
        this.marketPrice = marketPrice;
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    public Boolean getArchive() {
        return archive;
    }

    public void setArchive(Boolean archive) {
        this.archive = archive;
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

    public Integer getProductImgWidth() {
        return productImgWidth;
    }

    public void setProductImgWidth(Integer productImgWidth) {
        this.productImgWidth = productImgWidth;
    }

    public Integer getProductImgHeight() {
        return productImgHeight;
    }

    public void setProductImgHeight(Integer productImgHeight) {
        this.productImgHeight = productImgHeight;
    }

    public Boolean getRefundFlag() {
        return refundFlag;
    }

    public void setRefundFlag(Boolean refundFlag) {
        this.refundFlag = refundFlag;
    }
}