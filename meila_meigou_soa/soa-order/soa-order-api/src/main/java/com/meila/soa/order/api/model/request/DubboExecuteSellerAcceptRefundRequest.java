package com.meila.soa.order.api.model.request;

import javax.validation.constraints.NotNull;

import com.meila.dubbo.base.model.DubboBasicRequest;

/**
 * 
 ************************************************************
 * @类名 : DubboExecuteSellerAcceptRefundRequest.java
 *
 * @DESCRIPTION : 执行卖家同意退款
 * @AUTHOR :  gogo
 * @DATE :  2016年5月12日
 ************************************************************
 */
@SuppressWarnings("serial")
public class DubboExecuteSellerAcceptRefundRequest extends DubboBasicRequest{

    @NotNull(message = "订单ID不能为空")
    private Long orderId;
    
    public Long getOrderId() {
        return orderId;
    }
    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }
    
}
