package com.meila.soa.order.api.model.response;

import java.util.List;

import com.meila.dubbo.base.model.DubboBasicPageResponse;
import com.meila.soa.order.api.model.dto.DubboRefundOrder;

@SuppressWarnings("serial")
public class DubboQueryRefundOrderListResponse extends DubboBasicPageResponse{

    private List<DubboRefundOrder> refundOrderInfos;

    public List<DubboRefundOrder> getRefundOrderInfos() {
        return refundOrderInfos;
    }

    public void setRefundOrderInfos(List<DubboRefundOrder> refundOrderInfos) {
        this.refundOrderInfos = refundOrderInfos;
    }


}
