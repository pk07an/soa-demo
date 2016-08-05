package com.meila.soa.product.api.model.request;

import java.math.BigDecimal;
import java.util.List;

import javax.validation.constraints.Pattern;

import com.meila.dubbo.base.model.DubboBasicRequest;

public class DubboUpdateShopExtRequest extends DubboBasicRequest {
    private static final long serialVersionUID = 1L;

    private Long userId;

    private Long shopId;

    private Long shopExtId;

    private Short sellerType;

    @Pattern(regexp = "MEILA|SELLER|BONDED_AREA|BONDED_AREA_ML", message = "发货类型不合法")
    private String deliveryType;

    private String description;

    @Pattern(regexp = "WEIXIN|ALIPAY|BANK", message = "支付类型不合法")
    private String balanceType;

    private Integer balanceBankId;

    private String balanceAccount;

    private String phone;

    private String wechat;

    private String qq;

    private String videoSlug;

    private String videoImg;

    private String videoUrl;

    private String shopName;

    // 开户支行
    private String openBank;

    // 收款人名称
    private String receiverName;

    // 收款人所在省
    private Long provinceId;

    // 收款人所在市
    private Long cityId;

    // 卖家认证
    private List<String> sellerCertification;

    // 卖家个性称号
    private String selfhoodName;

    private BigDecimal postageFee; // 邮费

    private BigDecimal minPaidFee; // 最少应买多少包邮

    public BigDecimal getPostageFee() {
        return postageFee;
    }

    public void setPostageFee(BigDecimal postageFee) {
        this.postageFee = postageFee;
    }

    public BigDecimal getMinPaidFee() {
        return minPaidFee;
    }

    public void setMinPaidFee(BigDecimal minPaidFee) {
        this.minPaidFee = minPaidFee;
    }

    /** 卖家来源 */
    @Pattern(regexp = "OUTSIDE|INSIDE", message = "卖家来源不合法")
    private String sellerSource;

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getShopId() {
        return shopId;
    }

    public void setShopId(Long shopId) {
        this.shopId = shopId;
    }

    public Long getShopExtId() {
        return shopExtId;
    }

    public void setShopExtId(Long shopExtId) {
        this.shopExtId = shopExtId;
    }

    public Short getSellerType() {
        return sellerType;
    }

    public void setSellerType(Short sellerType) {
        this.sellerType = sellerType;
    }

    public String getDeliveryType() {
        return deliveryType;
    }

    public void setDeliveryType(String deliveryType) {
        this.deliveryType = deliveryType;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getBalanceType() {
        return balanceType;
    }

    public void setBalanceType(String balanceType) {
        this.balanceType = balanceType;
    }

    public Integer getBalanceBankId() {
        return balanceBankId;
    }

    public void setBalanceBankId(Integer balanceBankId) {
        this.balanceBankId = balanceBankId;
    }

    public String getBalanceAccount() {
        return balanceAccount;
    }

    public void setBalanceAccount(String balanceAccount) {
        this.balanceAccount = balanceAccount;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getWechat() {
        return wechat;
    }

    public void setWechat(String wechat) {
        this.wechat = wechat;
    }

    public String getQq() {
        return qq;
    }

    public void setQq(String qq) {
        this.qq = qq;
    }

    public String getVideoSlug() {
        return videoSlug;
    }

    public void setVideoSlug(String videoSlug) {
        this.videoSlug = videoSlug;
    }

    public String getVideoImg() {
        return videoImg;
    }

    public void setVideoImg(String videoImg) {
        this.videoImg = videoImg;
    }

    public String getVideoUrl() {
        return videoUrl;
    }

    public void setVideoUrl(String videoUrl) {
        this.videoUrl = videoUrl;
    }

    public String getShopName() {
        return shopName;
    }

    public void setShopName(String shopName) {
        this.shopName = shopName;
    }

    public String getOpenBank() {
        return openBank;
    }

    public void setOpenBank(String openBank) {
        this.openBank = openBank;
    }

    public String getReceiverName() {
        return receiverName;
    }

    public void setReceiverName(String receiverName) {
        this.receiverName = receiverName;
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

    public List<String> getSellerCertification() {
        return sellerCertification;
    }

    public void setSellerCertification(List<String> sellerCertification) {
        this.sellerCertification = sellerCertification;
    }

    public String getSelfhoodName() {
        return selfhoodName;
    }

    public void setSelfhoodName(String selfhoodName) {
        this.selfhoodName = selfhoodName;
    }

    public String getSellerSource() {
        return sellerSource;
    }

    public void setSellerSource(String sellerSource) {
        this.sellerSource = sellerSource;
    }
}
