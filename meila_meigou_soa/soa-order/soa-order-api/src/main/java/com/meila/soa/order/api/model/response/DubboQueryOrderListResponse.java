package com.meila.soa.order.api.model.response;

import java.util.List;

import com.meila.dubbo.base.model.DubboBasicPageResponse;
import com.meila.soa.order.api.model.dto.DubboOrder;

@SuppressWarnings("serial")
public class DubboQueryOrderListResponse extends DubboBasicPageResponse{

    private List<DubboOrder> orderInfos;

    public List<DubboOrder> getOrderInfos() {
        return orderInfos;
    }

    public void setOrderInfos(List<DubboOrder> orderInfos) {
        this.orderInfos = orderInfos;
    }
}
