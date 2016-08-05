package com.meila.soa.order.api.model.request;

import javax.validation.constraints.NotNull;

import com.meila.dubbo.base.model.DubboBasicRequest;

/**
 * 
 ************************************************************
 * @类名 : DubboQueryOrderRefundApplyByOrderIdRequest.java
 *
 * @DESCRIPTION : 根据orderId查询申请退款订单信息
 * @AUTHOR : gogo
 * @DATE : 2016年5月10日
 ************************************************************
 */
@SuppressWarnings("serial")
public class DubboQueryOrderRefundTrackByOrderIdRequest extends DubboBasicRequest {

    @NotNull(message = "订单ID不能为空")
    private Long orderId;

    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

}
