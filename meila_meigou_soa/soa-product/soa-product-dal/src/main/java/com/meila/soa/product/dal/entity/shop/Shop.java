package com.meila.soa.product.dal.entity.shop;

import java.math.BigDecimal;
import java.util.Date;

import com.meila.common.bean.utils.annotaion.MappingField;
import com.meila.soa.product.dal.type.ShopStatus;

public class Shop {
    @MappingField({ "shopId" })
    private Long id;

    private Long ownerId;

    @MappingField({ "shopName" })
    private String name;

    private String wechat;

    private String banner;

    private String description;

    private String img;

    private Boolean danbao;

    private String bulletin;

    private Date bulletinAt;

    @MappingField({ "shopStatus" })
    private ShopStatus status;

    private Boolean archive;

    private String opRemark;

    private Date createdAt;

    private Date updatedAt;

    private BigDecimal commisionRate;

    private Long provinceId;

    private Long cityId;

    private Boolean postageStatus;

    private Long freeZoneId;

    private BigDecimal postage;

    private String freeZone;

    private Boolean fragmentStatus;

    private Integer skuRemindAmount;

    private Byte openSkuRemind;

    private String code;

    private String sellerSource;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getOwnerId() {
        return ownerId;
    }

    public void setOwnerId(Long ownerId) {
        this.ownerId = ownerId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getWechat() {
        return wechat;
    }

    public void setWechat(String wechat) {
        this.wechat = wechat;
    }

    public String getBanner() {
        return banner;
    }

    public void setBanner(String banner) {
        this.banner = banner;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public Boolean getDanbao() {
        return danbao;
    }

    public void setDanbao(Boolean danbao) {
        this.danbao = danbao;
    }

    public String getBulletin() {
        return bulletin;
    }

    public void setBulletin(String bulletin) {
        this.bulletin = bulletin;
    }

    public Date getBulletinAt() {
        return bulletinAt;
    }

    public void setBulletinAt(Date bulletinAt) {
        this.bulletinAt = bulletinAt;
    }

    public ShopStatus getStatus() {
        return status;
    }

    public void setStatus(ShopStatus status) {
        this.status = status;
    }

    public Boolean getArchive() {
        return archive;
    }

    public void setArchive(Boolean archive) {
        this.archive = archive;
    }

    public String getOpRemark() {
        return opRemark;
    }

    public void setOpRemark(String opRemark) {
        this.opRemark = opRemark;
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

    public BigDecimal getCommisionRate() {
        return commisionRate;
    }

    public void setCommisionRate(BigDecimal commisionRate) {
        this.commisionRate = commisionRate;
    }

    public Long getProvinceId() {
        return provinceId;
    }

    public void setProvinceId(Long provinceId) {
        this.provinceId = provinceId;
    }

    public Long getCityId() {
        return cityId;
    }

    public void setCityId(Long cityId) {
        this.cityId = cityId;
    }

    public Boolean getPostageStatus() {
        return postageStatus;
    }

    public void setPostageStatus(Boolean postageStatus) {
        this.postageStatus = postageStatus;
    }

    public Long getFreeZoneId() {
        return freeZoneId;
    }

    public void setFreeZoneId(Long freeZoneId) {
        this.freeZoneId = freeZoneId;
    }

    public BigDecimal getPostage() {
        return postage;
    }

    public void setPostage(BigDecimal postage) {
        this.postage = postage;
    }

    public String getFreeZone() {
        return freeZone;
    }

    public void setFreeZone(String freeZone) {
        this.freeZone = freeZone;
    }

    public Boolean getFragmentStatus() {
        return fragmentStatus;
    }

    public void setFragmentStatus(Boolean fragmentStatus) {
        this.fragmentStatus = fragmentStatus;
    }

    public Integer getSkuRemindAmount() {
        return skuRemindAmount;
    }

    public void setSkuRemindAmount(Integer skuRemindAmount) {
        this.skuRemindAmount = skuRemindAmount;
    }

    public Byte getOpenSkuRemind() {
        return openSkuRemind;
    }

    public void setOpenSkuRemind(Byte openSkuRemind) {
        this.openSkuRemind = openSkuRemind;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getSellerSource() {
        return sellerSource;
    }

    public void setSellerSource(String sellerSource) {
        this.sellerSource = sellerSource;
    }
}
