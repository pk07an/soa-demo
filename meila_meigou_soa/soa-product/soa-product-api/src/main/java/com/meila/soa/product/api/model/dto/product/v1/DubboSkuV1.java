package com.meila.soa.product.api.model.dto.product.v1;

import java.math.BigDecimal;
import java.util.Date;

import com.meila.dubbo.base.model.BasicSeriModel;

public class DubboSkuV1 extends BasicSeriModel {

    private static final long serialVersionUID = 1L;

    private Long skuId;

    private Long productId;

    private String productName;

    private BigDecimal marketPrice;

    private BigDecimal price;

    private Integer amount;

    private Integer skuOrder;

    private String spec;

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

    private String skuCode;

    private String skuType;

    /**
     * HIDE SHOW
     */
    private String isDisplay;

    // sku图片信息
    private String skuImg;

    private Integer imgWidth;

    private Integer imgHeight;

    /**
     * warehouse编码
     */
    private String warehouse;

    /**
     * 中文名称
     */
    private String warehouseName;

    /**
     * 外部编码
     */
    private String outsideSkuCode;

    private String deliveryType;

    public String getDeliveryType() {
        return deliveryType;
    }

    public void setDeliveryType(String deliveryType) {
        this.deliveryType = deliveryType;
    }

    public String getOutsideSkuCode() {
        return outsideSkuCode;
    }

    public void setOutsideSkuCode(String outsideSkuCode) {
        this.outsideSkuCode = outsideSkuCode;
    }

    public String getWarehouse() {
        return warehouse;
    }

    public void setWarehouse(String warehouse) {
        this.warehouse = warehouse;
    }

    public String getWarehouseName() {
        return warehouseName;
    }

    public void setWarehouseName(String warehouseName) {
        this.warehouseName = warehouseName;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
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

    public String getSkuImg() {
        return skuImg;
    }

    public void setSkuImg(String skuImg) {
        this.skuImg = skuImg;
    }

    public Long getSkuId() {
        return skuId;
    }

    public void setSkuId(Long skuId) {
        this.skuId = skuId;
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

    public String getSkuCode() {
        return skuCode;
    }

    public void setSkuCode(String skuCode) {
        this.skuCode = skuCode;
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
}
