package com.meila.soa.order.api.model.request;

import javax.validation.constraints.NotNull;

import com.meila.dubbo.base.model.DubboBasicRequest;

/**
 * 
 ************************************************************
 * @类名 : DubboQueryOrderInfoByIdRequest.java
 *
 * @DESCRIPTION : 根据Id获取订单信息
 * @AUTHOR : gogo
 * @DATE : 2016年5月16日
 ************************************************************
 */
@SuppressWarnings("serial")
public class DubboQueryOrderInfoByIdRequest extends DubboBasicRequest {

    @NotNull
    private Long orderId;

    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

}
