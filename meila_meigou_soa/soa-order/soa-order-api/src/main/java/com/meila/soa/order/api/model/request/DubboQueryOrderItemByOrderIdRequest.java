package com.meila.soa.order.api.model.request;

import javax.validation.constraints.NotNull;

import com.meila.dubbo.base.model.DubboBasicRequest;

/**
 * 
 ************************************************************
 * @类名 : DubboQueryOrderItemByOrderIdRequest.java
 *
 * @DESCRIPTION : 获取订单ID获取订单明细
 * @AUTHOR : gogo
 * @DATE : 2016年5月10日
 ************************************************************
 */
@SuppressWarnings("serial")
public class DubboQueryOrderItemByOrderIdRequest extends DubboBasicRequest {

    @NotNull(message = "订单ID不能为空")
    private Long orderId;

    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

}
