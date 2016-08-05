package com.meila.soa.meila.client.dto;

import java.io.Serializable;

/**
 * 
 ************************************************************
 * @类名 : OrderSellerRemarkDto.java
 *
 * @DESCRIPTION : 调用OMS卖家备注回写DTO
 * @AUTHOR :  gogo
 * @DATE :  2016年5月16日
 ************************************************************
 */
@SuppressWarnings("serial")
public class OrderSellerRemarkDto implements Serializable{

    private String orderNo;
    private String sellerId;
    private String remark;
    private String operationTime;
    public String getOrderNo() {
        return orderNo;
    }
    public void setOrderNo(String orderNo) {
        this.orderNo = orderNo;
    }
    public String getSellerId() {
        return sellerId;
    }
    public void setSellerId(String sellerId) {
        this.sellerId = sellerId;
    }
    public String getRemark() {
        return remark;
    }
    public void setRemark(String remark) {
        this.remark = remark;
    }
    public String getOperationTime() {
        return operationTime;
    }
    public void setOperationTime(String operationTime) {
        this.operationTime = operationTime;
    }
    
}
