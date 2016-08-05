package com.meila.soa.product.api.model.request;

import java.math.BigDecimal;
import java.util.Date;

import javax.validation.constraints.Digits;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import com.meila.common.bean.utils.annotaion.MappingField;
import com.meila.soa.product.api.model.dto.DubboThirdCommission;

public class DubboUpdateShopRequest {

    @MappingField("id")
    private Long shopId;

    // @NotBlank(message = "{valid.notBlank.message}")
    @Size(min = 2, max = 20, message = "店铺名称不合法")
    private String name;

    // @NotBlank(message = "{valid.shop.img.notBlank.message}")
    @Size(min = 4, max = 60, message = "图片信息不合法")
    private String img;

    @Size(min = 4, max = 200, message = "店铺描述不合法")
    private String description;// 店铺说明

    @Size(min = 0, max = 40, message = "微信号不合法")
    private String wechat; // 微信号

    @Size(min = 0, max = 200, message = "公告信息不合法")
    private String bulletin;

    // 公告日期
    private Date bulletinAt;

    // 店铺招牌
    private String banner;

    // 是否开能担保交易，默认为不开通
    private Boolean danbao;

    // 店铺状态
    @Pattern(regexp = "ACTIVE|FROZEN")
    private String shopStatus;

    // 佣金比例
    private BigDecimal commisionRate;

    // 第三方佣金设置
    private DubboThirdCommission thirdCommission;

    // 是否设置了邮费
    private Boolean postageStatus;

    // 免邮地区
    private String freeZone;

    // 邮费
    @Digits(integer = 10, fraction = 2, message = "{valid.postage.range}")
    private BigDecimal postage;

    private Long provinceId;

    private Long cityId;

    // 店铺拥有者
    private String ownerId;

    public Long getShopId() {
        return shopId;
    }

    public void setShopId(Long shopId) {
        this.shopId = shopId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
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

    public DubboThirdCommission getThirdCommission() {
        return thirdCommission;
    }

    public void setThirdCommission(DubboThirdCommission thirdCommission) {
        this.thirdCommission = thirdCommission;
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

    public BigDecimal getPostage() {
        return postage;
    }

    public void setPostage(BigDecimal postage) {
        this.postage = postage;
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

    public String getOwnerId() {
        return ownerId;
    }

    public void setOwnerId(String ownerId) {
        this.ownerId = ownerId;
    }
}
