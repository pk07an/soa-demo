package com.meila.soa.product.api.model.dto;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import java.util.Map;

import com.meila.common.bean.utils.annotaion.MappingField;
import com.meila.dubbo.base.model.BasicSeriModel;

/**
 * 
 ************************************************************
 * @类名 : DubboProduct.java
 *
 * @DESCRIPTION :商品SPU,用作dubbo调用中
 * @AUTHOR : hawk
 * @DATE : 2016年1月15日
 ************************************************************
 */
public class DubboProduct extends BasicSeriModel {

    private static final long serialVersionUID = 1L;

    @MappingField("id")
    private Long productId;

    private Long userId;

    private Long shopId;

    private String shopName;

    private String sellerSource;

    private String name;

    private String img;

    private Integer imgWidth;

    private Integer imgHeight;

    private String descImg;

    private String status;

    private BigDecimal marketPrice;

    private BigDecimal price;

    private BigDecimal postage;

    private Long amount;

    private Long sales;

    private Boolean archive;

    private Byte recommend;

    private Date recommendAt;

    private BigDecimal discount;

    private Boolean isCommission;

    private BigDecimal commissionRate;

    private Date forsaleAt;

    private Date onsaleAt;

    private Date instockAt;

    private Date createdAt;

    private Date updatedAt;

    private Long fakeSales;

    private Byte isdelay;

    private Integer delaydays;

    private Boolean updateLock;

    private String synchronousflag;

    private String thirdItemId;

    private Long partnerProductId;

    private String code;

    private String description;

    private Integer deliveryDays;

    private Integer sendOutHours;

    private String deliveryType;

    private String storageType;

    private Map<String, List<String>> specInfo;

    private List<DubboSku> skuList;

    /**
     * 采购地
     */
    private String purchaseSource;

    public Integer getSendOutHours() {
        return sendOutHours;
    }

    public void setSendOutHours(Integer sendOutHours) {
        this.sendOutHours = sendOutHours;
    }

    public Long getAmount() {
        return amount;
    }

    public Boolean getArchive() {
        return archive;
    }

    public String getCode() {
        return code;
    }

    public BigDecimal getCommissionRate() {
        return commissionRate;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public Integer getDelaydays() {
        return delaydays;
    }

    /**
     * @return the deliveryDays
     */
    public Integer getDeliveryDays() {
        return deliveryDays;
    }

    /**
     * @return the deliveryType
     */
    public String getDeliveryType() {
        return deliveryType;
    }

    public String getDescImg() {
        return descImg;
    }

    public String getDescription() {
        return description;
    }

    public BigDecimal getDiscount() {
        return discount;
    }

    public Long getFakeSales() {
        return fakeSales;
    }

    public Date getForsaleAt() {
        return forsaleAt;
    }

    public String getImg() {
        return img;
    }

    public Integer getImgHeight() {
        return imgHeight;
    }

    public Integer getImgWidth() {
        return imgWidth;
    }

    public Date getInstockAt() {
        return instockAt;
    }

    public Boolean getIsCommission() {
        return isCommission;
    }

    public Byte getIsdelay() {
        return isdelay;
    }

    public BigDecimal getMarketPrice() {
        return marketPrice;
    }

    public String getName() {
        return name;
    }

    public Date getOnsaleAt() {
        return onsaleAt;
    }

    public Long getPartnerProductId() {
        return partnerProductId;
    }

    public BigDecimal getPostage() {
        return postage;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public Long getProductId() {
        return productId;
    }

    /**
     * @return the purchaseSource
     */
    public String getPurchaseSource() {
        return purchaseSource;
    }

    public Byte getRecommend() {
        return recommend;
    }

    public Date getRecommendAt() {
        return recommendAt;
    }

    public Long getSales() {
        return sales;
    }

    /**
     * @return the sellerSource
     */
    public String getSellerSource() {
        return sellerSource;
    }

    public Long getShopId() {
        return shopId;
    }

    public String getShopName() {
        return shopName;
    }

    public List<DubboSku> getSkuList() {
        return skuList;
    }

    /**
     * @return the specInfo
     */
    public Map<String, List<String>> getSpecInfo() {
        return specInfo;
    }

    public String getStatus() {
        return status;
    }

    /**
     * @return the storageType
     */
    public String getStorageType() {
        return storageType;
    }

    public String getSynchronousflag() {
        return synchronousflag;
    }

    public String getThirdItemId() {
        return thirdItemId;
    }

    public Date getUpdatedAt() {
        return updatedAt;
    }

    public Boolean getUpdateLock() {
        return updateLock;
    }

    public Long getUserId() {
        return userId;
    }

    public void setAmount(Long amount) {
        this.amount = amount;
    }

    public void setArchive(Boolean archive) {
        this.archive = archive;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public void setCommissionRate(BigDecimal commissionRate) {
        this.commissionRate = commissionRate;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public void setDelaydays(Integer delaydays) {
        this.delaydays = delaydays;
    }

    /**
     * @param deliveryDays the deliveryDays to set
     */
    public void setDeliveryDays(Integer deliveryDays) {
        this.deliveryDays = deliveryDays;
    }

    /**
     * @param deliveryType the deliveryType to set
     */
    public void setDeliveryType(String deliveryType) {
        this.deliveryType = deliveryType;
    }

    public void setDescImg(String descImg) {
        this.descImg = descImg;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setDiscount(BigDecimal discount) {
        this.discount = discount;
    }

    public void setFakeSales(Long fakeSales) {
        this.fakeSales = fakeSales;
    }

    public void setForsaleAt(Date forsaleAt) {
        this.forsaleAt = forsaleAt;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public void setImgHeight(Integer imgHeight) {
        this.imgHeight = imgHeight;
    }

    public void setImgWidth(Integer imgWidth) {
        this.imgWidth = imgWidth;
    }

    public void setInstockAt(Date instockAt) {
        this.instockAt = instockAt;
    }

    public void setIsCommission(Boolean isCommission) {
        this.isCommission = isCommission;
    }

    public void setIsdelay(Byte isdelay) {
        this.isdelay = isdelay;
    }

    public void setMarketPrice(BigDecimal marketPrice) {
        this.marketPrice = marketPrice;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setOnsaleAt(Date onsaleAt) {
        this.onsaleAt = onsaleAt;
    }

    public void setPartnerProductId(Long partnerProductId) {
        this.partnerProductId = partnerProductId;
    }

    public void setPostage(BigDecimal postage) {
        this.postage = postage;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    /**
     * @param purchaseSource the purchaseSource to set
     */
    public void setPurchaseSource(String purchaseSource) {
        this.purchaseSource = purchaseSource;
    }

    public void setRecommend(Byte recommend) {
        this.recommend = recommend;
    }

    public void setRecommendAt(Date recommendAt) {
        this.recommendAt = recommendAt;
    }

    public void setSales(Long sales) {
        this.sales = sales;
    }

    /**
     * @param sellerSource the sellerSource to set
     */
    public void setSellerSource(String sellerSource) {
        this.sellerSource = sellerSource;
    }

    public void setShopId(Long shopId) {
        this.shopId = shopId;
    }

    public void setShopName(String shopName) {
        this.shopName = shopName;
    }

    public void setSkuList(List<DubboSku> skuList) {
        this.skuList = skuList;
    }

    /**
     * @param specInfo the specInfo to set
     */
    public void setSpecInfo(Map<String, List<String>> specInfo) {
        this.specInfo = specInfo;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    /**
     * @param storageType the storageType to set
     */
    public void setStorageType(String storageType) {
        this.storageType = storageType;
    }

    public void setSynchronousflag(String synchronousflag) {
        this.synchronousflag = synchronousflag;
    }

    public void setThirdItemId(String thirdItemId) {
        this.thirdItemId = thirdItemId;
    }

    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
    }

    public void setUpdateLock(Boolean updateLock) {
        this.updateLock = updateLock;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }
}
