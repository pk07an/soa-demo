package com.meila.soa.order.api.model.dto;

import java.math.BigDecimal;
import java.util.Date;

import com.meila.dubbo.base.model.BasicSeriModel;

/**
 * 
 ************************************************************
 * @类名 : DubboOrderInfo.java
 *
 * @DESCRIPTION : 订单信息对象
 * @AUTHOR : gogo
 * @DATE : 2016年5月10日
 ************************************************************
 */
@SuppressWarnings("serial")
public class DubboOrderInfo extends BasicSeriModel {
    private Long id;

    private String orderNo;

    private String payNo;

    private String type;

    private String payType;

    private Long buyerId;

    private Long shopId;

    private Long sellerId;

    private BigDecimal logisticsFee;

    private BigDecimal totalFee;

    private BigDecimal refundFee;

    private BigDecimal refundGoodsFee;

    private BigDecimal refundLogisticsFee;

    private BigDecimal refundPlatformFee;

    private BigDecimal paidFee;

    private BigDecimal discountFee;

    private BigDecimal goodsFee;

    private Date paidAt;

    private String paidStatus;

    private Date shippedAt;

    private Date refundAt;

    private String logisticsCompany;

    private String logisticsOrderNo;

    private String status;

    private String remark;

    private Boolean archive;

    private Date createdAt;

    private Date updatedAt;

    private Long unionId;

    private String refundType;

    private Boolean vip;

    private String promotionId;

    private String couponId;

    private String partnerType;

    private Date checkingAt;

    private Date cancelledAt;

    private Date succeedAt;

    private Date latestSignAt;

    private Date remindShipAt;

    private String remarkAdmin;

    private String cancelReason;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getOrderNo() {
        return orderNo;
    }

    public void setOrderNo(String orderNo) {
        this.orderNo = orderNo;
    }

    public String getPayNo() {
        return payNo;
    }

    public void setPayNo(String payNo) {
        this.payNo = payNo;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getPayType() {
        return payType;
    }

    public void setPayType(String payType) {
        this.payType = payType;
    }

    public Long getBuyerId() {
        return buyerId;
    }

    public void setBuyerId(Long buyerId) {
        this.buyerId = buyerId;
    }

    public Long getShopId() {
        return shopId;
    }

    public void setShopId(Long shopId) {
        this.shopId = shopId;
    }

    public Long getSellerId() {
        return sellerId;
    }

    public void setSellerId(Long sellerId) {
        this.sellerId = sellerId;
    }

    public BigDecimal getLogisticsFee() {
        return logisticsFee;
    }

    public void setLogisticsFee(BigDecimal logisticsFee) {
        this.logisticsFee = logisticsFee;
    }

    public BigDecimal getTotalFee() {
        return totalFee;
    }

    public void setTotalFee(BigDecimal totalFee) {
        this.totalFee = totalFee;
    }

    public BigDecimal getRefundFee() {
        return refundFee;
    }

    public void setRefundFee(BigDecimal refundFee) {
        this.refundFee = refundFee;
    }

    public BigDecimal getRefundGoodsFee() {
        return refundGoodsFee;
    }

    public void setRefundGoodsFee(BigDecimal refundGoodsFee) {
        this.refundGoodsFee = refundGoodsFee;
    }

    public BigDecimal getRefundLogisticsFee() {
        return refundLogisticsFee;
    }

    public void setRefundLogisticsFee(BigDecimal refundLogisticsFee) {
        this.refundLogisticsFee = refundLogisticsFee;
    }

    public BigDecimal getRefundPlatformFee() {
        return refundPlatformFee;
    }

    public void setRefundPlatformFee(BigDecimal refundPlatformFee) {
        this.refundPlatformFee = refundPlatformFee;
    }

    public BigDecimal getPaidFee() {
        return paidFee;
    }

    public void setPaidFee(BigDecimal paidFee) {
        this.paidFee = paidFee;
    }

    public BigDecimal getDiscountFee() {
        return discountFee;
    }

    public void setDiscountFee(BigDecimal discountFee) {
        this.discountFee = discountFee;
    }

    public BigDecimal getGoodsFee() {
        return goodsFee;
    }

    public void setGoodsFee(BigDecimal goodsFee) {
        this.goodsFee = goodsFee;
    }

    public Date getPaidAt() {
        return paidAt;
    }

    public void setPaidAt(Date paidAt) {
        this.paidAt = paidAt;
    }

    public String getPaidStatus() {
        return paidStatus;
    }

    public void setPaidStatus(String paidStatus) {
        this.paidStatus = paidStatus;
    }

    public Date getShippedAt() {
        return shippedAt;
    }

    public void setShippedAt(Date shippedAt) {
        this.shippedAt = shippedAt;
    }

    public Date getRefundAt() {
        return refundAt;
    }

    public void setRefundAt(Date refundAt) {
        this.refundAt = refundAt;
    }

    public String getLogisticsCompany() {
        return logisticsCompany;
    }

    public void setLogisticsCompany(String logisticsCompany) {
        this.logisticsCompany = logisticsCompany;
    }

    public String getLogisticsOrderNo() {
        return logisticsOrderNo;
    }

    public void setLogisticsOrderNo(String logisticsOrderNo) {
        this.logisticsOrderNo = logisticsOrderNo;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public Boolean getArchive() {
        return archive;
    }

    public void setArchive(Boolean archive) {
        this.archive = archive;
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

    public Long getUnionId() {
        return unionId;
    }

    public void setUnionId(Long unionId) {
        this.unionId = unionId;
    }

    public String getRefundType() {
        return refundType;
    }

    public void setRefundType(String refundType) {
        this.refundType = refundType;
    }

    public Boolean getVip() {
        return vip;
    }

    public void setVip(Boolean vip) {
        this.vip = vip;
    }

    public String getPromotionId() {
        return promotionId;
    }

    public void setPromotionId(String promotionId) {
        this.promotionId = promotionId;
    }

    public String getCouponId() {
        return couponId;
    }

    public void setCouponId(String couponId) {
        this.couponId = couponId;
    }

    public String getPartnerType() {
        return partnerType;
    }

    public void setPartnerType(String partnerType) {
        this.partnerType = partnerType;
    }

    public Date getCheckingAt() {
        return checkingAt;
    }

    public void setCheckingAt(Date checkingAt) {
        this.checkingAt = checkingAt;
    }

    public Date getCancelledAt() {
        return cancelledAt;
    }

    public void setCancelledAt(Date cancelledAt) {
        this.cancelledAt = cancelledAt;
    }

    public Date getSucceedAt() {
        return succeedAt;
    }

    public void setSucceedAt(Date succeedAt) {
        this.succeedAt = succeedAt;
    }

    public Date getLatestSignAt() {
        return latestSignAt;
    }

    public void setLatestSignAt(Date latestSignAt) {
        this.latestSignAt = latestSignAt;
    }

    public Date getRemindShipAt() {
        return remindShipAt;
    }

    public void setRemindShipAt(Date remindShipAt) {
        this.remindShipAt = remindShipAt;
    }

    public String getRemarkAdmin() {
        return remarkAdmin;
    }

    public void setRemarkAdmin(String remarkAdmin) {
        this.remarkAdmin = remarkAdmin;
    }

    public String getCancelReason() {
        return cancelReason;
    }

    public void setCancelReason(String cancelReason) {
        this.cancelReason = cancelReason;
    }

}
