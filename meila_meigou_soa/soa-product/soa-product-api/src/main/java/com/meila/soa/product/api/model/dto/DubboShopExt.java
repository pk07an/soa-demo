package com.meila.soa.product.api.model.dto;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import com.meila.common.bean.utils.annotaion.MappingField;

public class DubboShopExt implements Serializable {
    private static final long serialVersionUID = -2681160418157836957L;

    @MappingField("id")
    private Long shopExtId;

    private Long shopId;

    private Short payType;

    private String payAccount;

    private String shortIntro;

    private Short sellerType;

    private Boolean isRealSeller;

    private BigDecimal totalRevenue;

    private BigDecimal balance;

    private Integer shipmentCount;

    private Short distribType;

    private String verifyStatus;

    private Date submitCheckTime;

    private String videoUrl;

    private String videoImg;

    private String videoSlug;

    private Integer displayOrder;

    // 发货类型
    private String deliveryType;

    // 结算方式
    private String balanceType;

    private Integer balanceBankId;

    private String balanceAccount;

    private String phone;

    private String qq;

    // 收款人名称
    private String receiverName;

    // 开户支行
    private String openBank;

    // 卖家认证。|分隔
    private String sellerCertification;

    // 卖家个性称号
    private String selfhoodName;

    public Long getShopExtId() {
        return shopExtId;
    }

    public void setShopExtId(Long shopExtId) {
        this.shopExtId = shopExtId;
    }

    public Long getShopId() {
        return shopId;
    }

    public void setShopId(Long shopId) {
        this.shopId = shopId;
    }

    public Short getPayType() {
        return payType;
    }

    public void setPayType(Short payType) {
        this.payType = payType;
    }

    public String getPayAccount() {
        return payAccount;
    }

    public void setPayAccount(String payAccount) {
        this.payAccount = payAccount;
    }

    public String getShortIntro() {
        return shortIntro;
    }

    public void setShortIntro(String shortIntro) {
        this.shortIntro = shortIntro;
    }

    public Short getSellerType() {
        return sellerType;
    }

    public void setSellerType(Short sellerType) {
        this.sellerType = sellerType;
    }

    public Boolean getIsRealSeller() {
        return isRealSeller;
    }

    public void setIsRealSeller(Boolean isRealSeller) {
        this.isRealSeller = isRealSeller;
    }

    public BigDecimal getTotalRevenue() {
        return totalRevenue;
    }

    public void setTotalRevenue(BigDecimal totalRevenue) {
        this.totalRevenue = totalRevenue;
    }

    public BigDecimal getBalance() {
        return balance;
    }

    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }

    public Integer getShipmentCount() {
        return shipmentCount;
    }

    public void setShipmentCount(Integer shipmentCount) {
        this.shipmentCount = shipmentCount;
    }

    public Short getDistribType() {
        return distribType;
    }

    public void setDistribType(Short distribType) {
        this.distribType = distribType;
    }

    public String getVerifyStatus() {
        return verifyStatus;
    }

    public void setVerifyStatus(String verifyStatus) {
        this.verifyStatus = verifyStatus;
    }

    public Date getSubmitCheckTime() {
        return submitCheckTime;
    }

    public void setSubmitCheckTime(Date submitCheckTime) {
        this.submitCheckTime = submitCheckTime;
    }

    public String getVideoUrl() {
        return videoUrl;
    }

    public void setVideoUrl(String videoUrl) {
        this.videoUrl = videoUrl;
    }

    public String getVideoImg() {
        return videoImg;
    }

    public void setVideoImg(String videoImg) {
        this.videoImg = videoImg;
    }

    public String getVideoSlug() {
        return videoSlug;
    }

    public void setVideoSlug(String videoSlug) {
        this.videoSlug = videoSlug == null ? null : videoSlug.trim();
    }

    public Integer getDisplayOrder() {
        return displayOrder;
    }

    public void setDisplayOrder(Integer displayOrder) {
        this.displayOrder = displayOrder;
    }

    public String getDeliveryType() {
        return deliveryType;
    }

    public void setDeliveryType(String deliveryType) {
        this.deliveryType = deliveryType;
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
        this.balanceAccount = balanceAccount == null ? null : balanceAccount.trim();
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone == null ? null : phone.trim();
    }

    public String getQq() {
        return qq;
    }

    public void setQq(String qq) {
        this.qq = qq == null ? null : qq.trim();
    }

    public String getReceiverName() {
        return receiverName;
    }

    public void setReceiverName(String receiverName) {
        this.receiverName = receiverName;
    }

    public String getOpenBank() {
        return openBank;
    }

    public void setOpenBank(String openBank) {
        this.openBank = openBank;
    }

    public String getSellerCertification() {
        return sellerCertification;
    }

    public void setSellerCertification(String sellerCertification) {
        this.sellerCertification = sellerCertification;
    }

    public String getSelfhoodName() {
        return selfhoodName;
    }

    public void setSelfhoodName(String selfhoodName) {
        this.selfhoodName = selfhoodName;
    }
}
