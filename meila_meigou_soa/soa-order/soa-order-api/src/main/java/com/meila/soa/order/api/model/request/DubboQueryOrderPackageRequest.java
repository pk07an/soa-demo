package com.meila.soa.order.api.model.request;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotBlank;

import com.meila.dubbo.base.model.DubboBasicRequest;

/**
 * 
 ************************************************************
 * @类名 : DubboQueryOrderPackageRequest.java
 *
 * @DESCRIPTION : 获取订单包裹信息
 * @AUTHOR : gogo
 * @DATE : 2016年5月10日
 ************************************************************
 */
@SuppressWarnings("serial")
public class DubboQueryOrderPackageRequest extends DubboBasicRequest {

    @NotBlank(message = "订单编号不能为空")
    private String orderNo;
    @NotNull(message = "买家ID不能为空")
    private Long buyerId;

    public String getOrderNo() {
        return orderNo;
    }

    public void setOrderNo(String orderNo) {
        this.orderNo = orderNo;
    }

    public Long getBuyerId() {
        return buyerId;
    }

    public void setBuyerId(Long buyerId) {
        this.buyerId = buyerId;
    }

}
