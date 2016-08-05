package com.meila.soa.order.api.model.request;

import javax.validation.constraints.NotNull;

import com.meila.dubbo.base.model.DubboBasicRequest;

/**
 * 
 ************************************************************
 * @类名 : DubboQueryOrderAddressInfoByOrderIdRequest.java
 *
 * @DESCRIPTION : 根据orderId获取订单地址信息
 * @AUTHOR : gogo
 * @DATE : 2016年5月16日
 ************************************************************
 */
@SuppressWarnings("serial")
public class DubboQueryOrderAddressInfoByOrderIdRequest extends DubboBasicRequest {

    @NotNull
    private Long orderId;

    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

}
