package com.meila.soa.order.api.model.request;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotBlank;

import com.meila.dubbo.base.model.DubboBasicRequest;

/**
 * 
 ************************************************************
 * @类名 : DubboExecuteSellerRemarkRequest.java
 *
 * @DESCRIPTION : 执行卖家回写订单备注
 * @AUTHOR : gogo
 * @DATE : 2016年5月12日
 ************************************************************
 */
@SuppressWarnings("serial")
public class DubboExecuteSellerRemarkRequest extends DubboBasicRequest {

    @NotNull(message = "订单ID不能为空")
    private Long orderId;
    @NotBlank(message = "订单编号列表不能为空")
    private String orderNo;
    @NotBlank(message = "卖家备注不能为空")
    private String remark;
    @NotNull(message = "卖家ID不能为空")
    private Long sellerId;
    @NotBlank(message = "订单状态不能为空")
    private String orderStatus;

    private Boolean tuanFlag;
    private String tuanStatus;

    public Boolean getTuanFlag() {
        return tuanFlag;
    }

    public void setTuanFlag(Boolean tuanFlag) {
        this.tuanFlag = tuanFlag;
    }

    public String getTuanStatus() {
        return tuanStatus;
    }

    public void setTuanStatus(String tuanStatus) {
        this.tuanStatus = tuanStatus;
    }

    public String getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(String orderStatus) {
        this.orderStatus = orderStatus;
    }

    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getOrderNo() {
        return orderNo;
    }

    public void setOrderNo(String orderNo) {
        this.orderNo = orderNo;
    }

    public Long getSellerId() {
        return sellerId;
    }

    public void setSellerId(Long sellerId) {
        this.sellerId = sellerId;
    }

}
