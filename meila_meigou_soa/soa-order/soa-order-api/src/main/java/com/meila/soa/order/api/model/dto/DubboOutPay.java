package com.meila.soa.order.api.model.dto;

import java.math.BigDecimal;
import java.util.Date;

import com.meila.dubbo.base.model.BasicSeriModel;

@SuppressWarnings("serial")
public class DubboOutPay extends BasicSeriModel {
    private Long id;

    private Long pOutpayId;

    private Long requestId;

    private Long forOutpayId;

    private Long userId;

    private String status;

    private String outpayType;

    private String outpayTypeEx;

    private BigDecimal amount;

    private String outId;

    private String outAccountId;

    private String outAccountName;

    private String outStatus;

    private String outStatusEx;

    private String billNo;

    private String tradeNo;

    private Date createdAt;

    private Date updatedAt;

    private String payDetailType;

    private String partner;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getpOutpayId() {
        return pOutpayId;
    }

    public void setpOutpayId(Long pOutpayId) {
        this.pOutpayId = pOutpayId;
    }

    public Long getRequestId() {
        return requestId;
    }

    public void setRequestId(Long requestId) {
        this.requestId = requestId;
    }

    public Long getForOutpayId() {
        return forOutpayId;
    }

    public void setForOutpayId(Long forOutpayId) {
        this.forOutpayId = forOutpayId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getOutpayType() {
        return outpayType;
    }

    public void setOutpayType(String outpayType) {
        this.outpayType = outpayType;
    }

    public String getOutpayTypeEx() {
        return outpayTypeEx;
    }

    public void setOutpayTypeEx(String outpayTypeEx) {
        this.outpayTypeEx = outpayTypeEx;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public String getOutId() {
        return outId;
    }

    public void setOutId(String outId) {
        this.outId = outId;
    }

    public String getOutAccountId() {
        return outAccountId;
    }

    public void setOutAccountId(String outAccountId) {
        this.outAccountId = outAccountId;
    }

    public String getOutAccountName() {
        return outAccountName;
    }

    public void setOutAccountName(String outAccountName) {
        this.outAccountName = outAccountName;
    }

    public String getOutStatus() {
        return outStatus;
    }

    public void setOutStatus(String outStatus) {
        this.outStatus = outStatus;
    }

    public String getOutStatusEx() {
        return outStatusEx;
    }

    public void setOutStatusEx(String outStatusEx) {
        this.outStatusEx = outStatusEx;
    }

    public String getBillNo() {
        return billNo;
    }

    public void setBillNo(String billNo) {
        this.billNo = billNo;
    }

    public String getTradeNo() {
        return tradeNo;
    }

    public void setTradeNo(String tradeNo) {
        this.tradeNo = tradeNo;
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

    public String getPayDetailType() {
        return payDetailType;
    }

    public void setPayDetailType(String payDetailType) {
        this.payDetailType = payDetailType;
    }

    public String getPartner() {
        return partner;
    }

    public void setPartner(String partner) {
        this.partner = partner;
    }

}
