package com.meila.soa.order.api.model.request;

import java.util.List;

import org.hibernate.validator.constraints.NotEmpty;

import com.meila.dubbo.base.model.DubboBasicRequest;

/**
 * 
 ************************************************************
 * @类名 : DubboQueryOrderRefundApplyByOrderIdsRequest.java
 *
 * @DESCRIPTION : 根据orderId列表查询申请退款订单信息
 * @AUTHOR :  gogo
 * @DATE :  2016年5月10日
 ************************************************************
 */
@SuppressWarnings("serial")
public class DubboQueryOrderRefundApplyByOrderIdsRequest extends DubboBasicRequest {

    @NotEmpty(message = "订单ID列表不能为空")
    private List<Long> orderids;

    public List<Long> getOrderids() {
        return orderids;
    }

    public void setOrderids(List<Long> orderids) {
        this.orderids = orderids;
    }

}
