package com.meila.soa.order.api.model.request;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotBlank;

import com.meila.dubbo.base.model.DubboBasicRequest;

/**
 * 
 ************************************************************
 * @类名 : DubboExecuteSellerRejectRefundRequest.java
 *
 * @DESCRIPTION : 执行卖家拒绝退款
 * @AUTHOR :  gogo
 * @DATE :  2016年5月12日
 ************************************************************
 */
@SuppressWarnings("serial")
public class DubboExecuteSellerRejectRefundRequest extends DubboBasicRequest{

    @NotNull(message = "订单ID不能为空")
    private Long orderId;
    @NotBlank(message = "拒绝备注不能为空")
    private String rejectRemark;
    
    public Long getOrderId() {
        return orderId;
    }
    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }
    public String getRejectRemark() {
        return rejectRemark;
    }
    public void setRejectRemark(String rejectRemark) {
        this.rejectRemark = rejectRemark;
    }
    
}
