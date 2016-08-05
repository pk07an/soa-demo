package com.meila.soa.order.api.model.response;

import java.util.List;

import com.meila.dubbo.base.model.DubboBasicResponse;
import com.meila.soa.order.api.model.dto.DubboOrderRefundApply;

/**
 * 
 ************************************************************
 * @类名 : DubboQueryOrderRefundApplyByOrderIdsResponse.java
 *
 * @DESCRIPTION : 根据orderId列表查询申请退款订单信息
 * @AUTHOR : gogo
 * @DATE : 2016年5月10日
 ************************************************************
 */
@SuppressWarnings("serial")
public class DubboQueryOrderRefundApplyByOrderIdsResponse extends DubboBasicResponse {

    private List<DubboOrderRefundApply> dubboOrderRefundApplyList;

    public List<DubboOrderRefundApply> getDubboOrderRefundApplyList() {
        return dubboOrderRefundApplyList;
    }

    public void setDubboOrderRefundApplyList(List<DubboOrderRefundApply> dubboOrderRefundApplyList) {
        this.dubboOrderRefundApplyList = dubboOrderRefundApplyList;
    }

}
