package com.meila.soa.order.api.model.dto;

import java.math.BigDecimal;
import java.util.Date;

import com.meila.dubbo.base.model.BasicSeriModel;

/**
 * 
 ************************************************************
 * @类名 : DubboOrderRefundTrack.java
 *
 * @DESCRIPTION : 退款轨迹
 * @AUTHOR : gogo
 * @DATE : 2016年5月10日
 ************************************************************
 */
@SuppressWarnings("serial")
public class DubboOrderRefundTrack extends BasicSeriModel {

    private String sellerRejectReason;
    private String sellerRejectRemark;
    private Date sellerConfirmTime;

    private Date pConfirmTime;
    private Date transferTime;
    private Date cancelTime;

    private String refundReason;
    private String refundRemark;
    private BigDecimal refundFee;
    private String refundType;
    private Date refundTime;

    private String requestBy;

    public Date getCancelTime() {
        return cancelTime;
    }

    public void setCancelTime(Date cancelTime) {
        this.cancelTime = cancelTime;
    }

    public String getRequestBy() {
        return requestBy;
    }

    public void setRequestBy(String requestBy) {
        this.requestBy = requestBy;
    }

    public Date getpConfirmTime() {
        return pConfirmTime;
    }

    public void setpConfirmTime(Date pConfirmTime) {
        this.pConfirmTime = pConfirmTime;
    }

    public Date getTransferTime() {
        return transferTime;
    }

    public void setTransferTime(Date transferTime) {
        this.transferTime = transferTime;
    }

    public String getSellerRejectReason() {
        return sellerRejectReason;
    }

    public void setSellerRejectReason(String sellerRejectReason) {
        this.sellerRejectReason = sellerRejectReason;
    }

    public String getSellerRejectRemark() {
        return sellerRejectRemark;
    }

    public void setSellerRejectRemark(String sellerRejectRemark) {
        this.sellerRejectRemark = sellerRejectRemark;
    }

    public Date getSellerConfirmTime() {
        return sellerConfirmTime;
    }

    public void setSellerConfirmTime(Date sellerConfirmTime) {
        this.sellerConfirmTime = sellerConfirmTime;
    }

    public String getRefundReason() {
        return refundReason;
    }

    public void setRefundReason(String refundReason) {
        this.refundReason = refundReason;
    }

    public String getRefundRemark() {
        return refundRemark;
    }

    public void setRefundRemark(String refundRemark) {
        this.refundRemark = refundRemark;
    }

    public BigDecimal getRefundFee() {
        return refundFee;
    }

    public void setRefundFee(BigDecimal refundFee) {
        this.refundFee = refundFee;
    }

    public String getRefundType() {
        return refundType;
    }

    public void setRefundType(String refundType) {
        this.refundType = refundType;
    }

    public Date getRefundTime() {
        return refundTime;
    }

    public void setRefundTime(Date refundTime) {
        this.refundTime = refundTime;
    }

}
