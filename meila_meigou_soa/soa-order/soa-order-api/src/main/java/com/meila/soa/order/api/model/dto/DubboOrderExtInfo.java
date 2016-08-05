package com.meila.soa.order.api.model.dto;

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
public class DubboOrderExtInfo extends BasicSeriModel {
    private Long id;

    private Long orderId;

    private Integer expressCompanyNo;

    private String mcode;

    private Integer coin;

    private Double coinPrice;

    private Short refundStatus;

    private String utmChannel;

    private Integer utmUserId;

    private Date statusUpdateTime;

    private Short settlementStatus;

    private String source;

    private String sellerRemark;

    private Boolean tuanFlag;

    private String tuanNo;

    private String utmActivity;

    private String inChannel;
    
    private String tuanStatus;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    public Integer getExpressCompanyNo() {
        return expressCompanyNo;
    }

    public void setExpressCompanyNo(Integer expressCompanyNo) {
        this.expressCompanyNo = expressCompanyNo;
    }

    public String getMcode() {
        return mcode;
    }

    public void setMcode(String mcode) {
        this.mcode = mcode;
    }

    public Integer getCoin() {
        return coin;
    }

    public void setCoin(Integer coin) {
        this.coin = coin;
    }

    public Double getCoinPrice() {
        return coinPrice;
    }

    public void setCoinPrice(Double coinPrice) {
        this.coinPrice = coinPrice;
    }

    public Short getRefundStatus() {
        return refundStatus;
    }

    public void setRefundStatus(Short refundStatus) {
        this.refundStatus = refundStatus;
    }

    public String getUtmChannel() {
        return utmChannel;
    }

    public void setUtmChannel(String utmChannel) {
        this.utmChannel = utmChannel;
    }

    public Integer getUtmUserId() {
        return utmUserId;
    }

    public void setUtmUserId(Integer utmUserId) {
        this.utmUserId = utmUserId;
    }

    public Date getStatusUpdateTime() {
        return statusUpdateTime;
    }

    public void setStatusUpdateTime(Date statusUpdateTime) {
        this.statusUpdateTime = statusUpdateTime;
    }

    public Short getSettlementStatus() {
        return settlementStatus;
    }

    public void setSettlementStatus(Short settlementStatus) {
        this.settlementStatus = settlementStatus;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public String getSellerRemark() {
        return sellerRemark;
    }

    public void setSellerRemark(String sellerRemark) {
        this.sellerRemark = sellerRemark;
    }

    public Boolean getTuanFlag() {
        return tuanFlag;
    }

    public void setTuanFlag(Boolean tuanFlag) {
        this.tuanFlag = tuanFlag;
    }

    public String getTuanNo() {
        return tuanNo;
    }

    public void setTuanNo(String tuanNo) {
        this.tuanNo = tuanNo;
    }

    public String getUtmActivity() {
        return utmActivity;
    }

    public void setUtmActivity(String utmActivity) {
        this.utmActivity = utmActivity;
    }

    public String getInChannel() {
        return inChannel;
    }

    public void setInChannel(String inChannel) {
        this.inChannel = inChannel;
    }

    public String getTuanStatus() {
        return tuanStatus;
    }

    public void setTuanStatus(String tuanStatus) {
        this.tuanStatus = tuanStatus;
    }

}
