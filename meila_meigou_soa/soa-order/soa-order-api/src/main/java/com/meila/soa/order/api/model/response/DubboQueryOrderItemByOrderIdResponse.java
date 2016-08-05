package com.meila.soa.order.api.model.response;

import java.util.List;

import com.meila.dubbo.base.model.DubboBasicResponse;
import com.meila.soa.order.api.model.dto.DubboOrderItem;

@SuppressWarnings("serial")
public class DubboQueryOrderItemByOrderIdResponse extends DubboBasicResponse {

    private List<DubboOrderItem> orderItems;

    public List<DubboOrderItem> getOrderItems() {
        return orderItems;
    }

    public void setOrderItems(List<DubboOrderItem> orderItems) {
        this.orderItems = orderItems;
    }

}
