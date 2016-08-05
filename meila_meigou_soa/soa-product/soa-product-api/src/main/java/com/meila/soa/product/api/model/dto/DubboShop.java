package com.meila.soa.product.api.model.dto;

import java.math.BigDecimal;
import java.util.Date;

import com.meila.common.bean.utils.annotaion.MappingField;
import com.meila.dubbo.base.model.BasicSeriModel;

public class DubboShop extends BasicSeriModel {
    private static final long serialVersionUID = 1L;

    /**
     * 店铺ID
     */
    private Long shopId;

    /**
     * 店铺拥有者
     */
    private Long ownerId;

    /**
     * 店铺主图
     */
    private String shopImg;

    /**
     * 店铺名称
     */
    @MappingField("name")
    private String shopName;

    /**
     * 店铺公告
     */
    private String bulletin;

    /**
     * 公告日期
     */
    private Date bulletinTime;

    /**
     * 店铺说明
     */
    private String description;

    /**
     * 微信号
     */
    private String wechat;

    /**
     * 店铺招牌
     */
    private String banner;

    /**
     * 是否开能担保交易，默认为不开通
     */
    private Boolean danbao;

    /**
     * 状态
     */
    @MappingField("status")
    private String shopStatus;

    /**
     * 佣金比例
     */
    private BigDecimal commisionRate;

    /**
     * 有效位
     */
    private Boolean archive;

    /**
     * 店铺所在省份
     */
    private Long provinceId;

    /**
     * 店铺所在城市
     */
    private Long cityId;

    /**
     * 是否设置了邮费
     */
    private Boolean postageStatus;

    /**
     * 免邮地区
     */
    private String freeZone;

    /**
     * 免邮地区ID
     */
    private Long freeZoneId;

    /**
     * 邮费
     */
    private BigDecimal postage;

    /**
     * 是否使用片段，true:使用、false:不使用，默认false
     */
    private Boolean fragmentStatus;

    private String shopCode;

    /**
     * 卖家来源, INSIDE:内部卖家 OUTSIDE:外部卖家
     */
    private String sellerSource;

    /**
     * 创建者ID
     */
    private String createUserId;

    private Date createdAt;

    private Date updatedAt;

    private DubboShopExt shopExt;

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

    public DubboShopExt getShopExt() {
        return shopExt;
    }

    public void setShopExt(DubboShopExt shopExt) {
        this.shopExt = shopExt;
    }

    public Long getShopId() {
        return shopId;
    }

    public void setShopId(Long shopId) {
        this.shopId = shopId;
    }

    public Long getOwnerId() {
        return ownerId;
    }

    public void setOwnerId(Long ownerId) {
        this.ownerId = ownerId;
    }

    public String getShopImg() {
        return shopImg;
    }

    public void setShopImg(String shopImg) {
        this.shopImg = shopImg;
    }

    public String getShopName() {
        return shopName;
    }

    public void setShopName(String shopName) {
        this.shopName = shopName;
    }

    public String getBulletin() {
        return bulletin;
    }

    public void setBulletin(String bulletin) {
        this.bulletin = bulletin;
    }

    public Date getBulletinTime() {
        return bulletinTime;
    }

    public void setBulletinTime(Date bulletinTime) {
        this.bulletinTime = bulletinTime;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
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

    public Boolean getDanbao() {
        return danbao;
    }

    public void setDanbao(Boolean danbao) {
        this.danbao = danbao;
    }

    public String getShopStatus() {
        return shopStatus;
    }

    public void setShopStatus(String shopStatus) {
        this.shopStatus = shopStatus;
    }

    public BigDecimal getCommisionRate() {
        return commisionRate;
    }

    public void setCommisionRate(BigDecimal commisionRate) {
        this.commisionRate = commisionRate;
    }

    public Boolean getArchive() {
        return archive;
    }

    public void setArchive(Boolean archive) {
        this.archive = archive;
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

    public String getFreeZone() {
        return freeZone;
    }

    public void setFreeZone(String freeZone) {
        this.freeZone = freeZone;
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

    public Boolean getFragmentStatus() {
        return fragmentStatus;
    }

    public void setFragmentStatus(Boolean fragmentStatus) {
        this.fragmentStatus = fragmentStatus;
    }

    public String getShopCode() {
        return shopCode;
    }

    public void setShopCode(String shopCode) {
        this.shopCode = shopCode;
    }

    public String getSellerSource() {
        return sellerSource;
    }

    public void setSellerSource(String sellerSource) {
        this.sellerSource = sellerSource;
    }

    public String getCreateUserId() {
        return createUserId;
    }

    public void setCreateUserId(String createUserId) {
        this.createUserId = createUserId;
    }
}
