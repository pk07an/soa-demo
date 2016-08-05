package com.meila.soa.product.api.model.dto;

import java.math.BigDecimal;
import java.util.Date;

import com.meila.dubbo.base.model.BasicSeriModel;

/**
 * 
 ************************************************************
 * @类名 : DubboSkuBasicInfo.java
 *
 * @DESCRIPTION :商品SKU基础信息
 * @AUTHOR : mike
 * @DATE : 2016年5月17日
 ************************************************************
 */
public class DubboSkuBasicInfo extends BasicSeriModel {

    private static final long serialVersionUID = -5305664046017769126L;

    private Long id;

    private Long productId;

    private String spec;

    private BigDecimal marketPrice;

    private BigDecimal price;

    private Integer amount;

    private Integer skuOrder;

    private Boolean archive;

    private String spec1;

    private String spec2;

    private String spec3;

    private String spec4;

    private String spec5;

    private Date createdAt;

    private Date updatedAt;

    private String erpSkuId;

    private Long partnerProductId;

    private Integer sales;

    private String code;

    private String skuType;

    private String isDisplay;

    // sku图片信息
    private String img;

    private Integer imgWidth;

    private Integer imgHeight;

    private String productName;

    private String ProductImg;

    private String productStatus;

    private Date productOnsaleAt;
    private Date productCreatedAt;

    // 排序字段
    private String orderField;
    // 排序方向
    private String orderDirection;

    private String deliveryType;

    public String getDeliveryType() {
        return deliveryType;
    }

    public void setDeliveryType(String deliveryType) {
        this.deliveryType = deliveryType;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    public String getSpec() {
        return spec;
    }

    public void setSpec(String spec) {
        this.spec = spec;
    }

    public BigDecimal getMarketPrice() {
        return marketPrice;
    }

    public void setMarketPrice(BigDecimal marketPrice) {
        this.marketPrice = marketPrice;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    public Integer getSkuOrder() {
        return skuOrder;
    }

    public void setSkuOrder(Integer skuOrder) {
        this.skuOrder = skuOrder;
    }

    public Boolean getArchive() {
        return archive;
    }

    public void setArchive(Boolean archive) {
        this.archive = archive;
    }

    public String getSpec1() {
        return spec1;
    }

    public void setSpec1(String spec1) {
        this.spec1 = spec1;
    }

    public String getSpec2() {
        return spec2;
    }

    public void setSpec2(String spec2) {
        this.spec2 = spec2;
    }

    public String getSpec3() {
        return spec3;
    }

    public void setSpec3(String spec3) {
        this.spec3 = spec3;
    }

    public String getSpec4() {
        return spec4;
    }

    public void setSpec4(String spec4) {
        this.spec4 = spec4;
    }

    public String getSpec5() {
        return spec5;
    }

    public void setSpec5(String spec5) {
        this.spec5 = spec5;
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

    public String getErpSkuId() {
        return erpSkuId;
    }

    public void setErpSkuId(String erpSkuId) {
        this.erpSkuId = erpSkuId;
    }

    public Long getPartnerProductId() {
        return partnerProductId;
    }

    public void setPartnerProductId(Long partnerProductId) {
        this.partnerProductId = partnerProductId;
    }

    public Integer getSales() {
        return sales;
    }

    public void setSales(Integer sales) {
        this.sales = sales;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getSkuType() {
        return skuType;
    }

    public void setSkuType(String skuType) {
        this.skuType = skuType;
    }

    public String getIsDisplay() {
        return isDisplay;
    }

    public void setIsDisplay(String isDisplay) {
        this.isDisplay = isDisplay;
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

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getProductImg() {
        return ProductImg;
    }

    public void setProductImg(String productImg) {
        ProductImg = productImg;
    }

    public String getProductStatus() {
        return productStatus;
    }

    public void setProductStatus(String productStatus) {
        this.productStatus = productStatus;
    }

    public Date getProductOnsaleAt() {
        return productOnsaleAt;
    }

    public void setProductOnsaleAt(Date productOnsaleAt) {
        this.productOnsaleAt = productOnsaleAt;
    }

    public Date getProductCreatedAt() {
        return productCreatedAt;
    }

    public void setProductCreatedAt(Date productCreatedAt) {
        this.productCreatedAt = productCreatedAt;
    }

    public String getOrderField() {
        return orderField;
    }

    public void setOrderField(String orderField) {
        this.orderField = orderField;
    }

    public String getOrderDirection() {
        return orderDirection;
    }

    public void setOrderDirection(String orderDirection) {
        this.orderDirection = orderDirection;
    }
}
