package com.meila.soa.product.dal.entity.shop;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;

import com.meila.common.bean.utils.annotaion.MappingField;
import com.meila.soa.product.dal.type.BalanceType;
import com.meila.soa.product.dal.type.DeliveryType;

public class ShopExt implements Serializable {
    private static final long serialVersionUID = -2681160418157836957L;

    @MappingField({ "shopExtId" })
    private Long id;

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
    private DeliveryType deliveryType;

    // 结算方式
    private BalanceType balanceType;

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

    // 卖家认证list，程序处理
    private Map<String, Boolean> sellerCertificationMap;

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

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public DeliveryType getDeliveryType() {
        return deliveryType;
    }

    public void setDeliveryType(DeliveryType deliveryType) {
        this.deliveryType = deliveryType;
    }

    public BalanceType getBalanceType() {
        return balanceType;
    }

    public void setBalanceType(BalanceType balanceType) {
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

    public Map<String, Boolean> getSellerCertificationMap() {
        sellerCertificationMap = new HashMap<String, Boolean>();
        try {
            if (StringUtils.isNotBlank(sellerCertification)) {
                String[] cerArray = StringUtils.split(sellerCertification, "|");
                List<String> resultList = Arrays.asList(cerArray);

                for (String result : resultList) {
                    sellerCertificationMap.put(result, true);
                }
                String[] cerEmus = { "MEILA", "O_IDENTITY", "O_DIRECT", "BRAND" };
                for (String cerEmu : Arrays.asList(cerEmus)) {
                    // 如果数据库里的数据不包含key的话，设置为false
                    if (!sellerCertificationMap.containsKey(cerEmu)) {
                        sellerCertificationMap.put(cerEmu, false);
                    } else {
                        sellerCertificationMap.put(cerEmu, true);
                    }
                }
            }
        } catch (Exception ex) {

        }
        return sellerCertificationMap;
    }

    public void setSellerCertificationMap(Map<String, Boolean> sellerCertificationMap) {
        this.sellerCertificationMap = sellerCertificationMap;
    }

    public String getSelfhoodName() {
        return selfhoodName;
    }

    public void setSelfhoodName(String selfhoodName) {
        this.selfhoodName = selfhoodName;
    }
}
