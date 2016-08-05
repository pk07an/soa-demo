package com.meila.soa.product.dal.entity.product;

import java.math.BigDecimal;
import java.util.Date;

import com.meila.common.bean.utils.annotaion.MappingField;
import com.meila.soa.product.dal.type.SkuDisplayType;
import com.meila.soa.product.dal.type.SkuType;

public class Sku {
    @MappingField({ "skuId", "bundleId", "skuBundleId" })
    private Long id;

    private Long productId;

    private String spec;

    private BigDecimal marketPrice;

    private BigDecimal price;

    private Integer amount;

    private Integer skuOrder;

    private Boolean archive;

    @MappingField({ "skuBundleName", "bundleName" })
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

    @MappingField({ "skuCode" })
    private String code;

    private SkuType skuType;

    private SkuDisplayType isDisplay;

    // sku图片信息
    @MappingField({ "skuImg", "skuMainImg" })
    private String img;

    private Integer imgWidth;

    private Integer imgHeight;

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

    // TODO 临时方案
    private SkuExt skuExt;

    // private String pro

    public SkuExt getSkuExt() {
        return skuExt;
    }

    public void setSkuExt(SkuExt skuExt) {
        this.skuExt = skuExt;
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

    public SkuType getSkuType() {
        return skuType;
    }

    public void setSkuType(SkuType skuType) {
        this.skuType = skuType;
    }

    public SkuDisplayType getIsDisplay() {
        return isDisplay;
    }

    public void setIsDisplay(SkuDisplayType isDisplay) {
        this.isDisplay = isDisplay;
    }
}
