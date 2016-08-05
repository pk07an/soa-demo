package com.meila.soa.order.api.model.response;

import com.meila.dubbo.base.model.DubboBasicResponse;
import com.meila.soa.order.api.model.dto.DubboOrderRefundApply;

/**
 * 
 ************************************************************
 * @类名 : DubboQueryOrderRefundApplyByOrderIdResponse.java
 *
 * @DESCRIPTION : 根据orderId查询申请退款订单信息
 * @AUTHOR : gogo
 * @DATE : 2016年5月10日
 ************************************************************
 */
@SuppressWarnings("serial")
public class DubboQueryOrderRefundApplyByOrderIdResponse extends DubboBasicResponse {

    private DubboOrderRefundApply dubboOrderRefundApply;

    public DubboOrderRefundApply getDubboOrderRefundApply() {
        return dubboOrderRefundApply;
    }

    public void setDubboOrderRefundApply(DubboOrderRefundApply dubboOrderRefundApply) {
        this.dubboOrderRefundApply = dubboOrderRefundApply;
    }

}
