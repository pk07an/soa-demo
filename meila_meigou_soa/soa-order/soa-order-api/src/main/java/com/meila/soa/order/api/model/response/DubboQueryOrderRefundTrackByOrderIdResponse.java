package com.meila.soa.order.api.model.response;

import java.util.List;

import com.meila.dubbo.base.model.DubboBasicResponse;
import com.meila.soa.order.api.model.dto.DubboOrderRefundTrack;

/**
 * 
 ************************************************************
 * @类名 : DubboQueryOrderRefundApplyByOrderIdResponse.java
 *
 * @DESCRIPTION : 根据orderId查询退款轨迹
 * @AUTHOR : gogo
 * @DATE : 2016年5月10日
 ************************************************************
 */
@SuppressWarnings("serial")
public class DubboQueryOrderRefundTrackByOrderIdResponse extends DubboBasicResponse {

    private List<DubboOrderRefundTrack> dubboOrderRefundTrack;

    public List<DubboOrderRefundTrack> getDubboOrderRefundTrack() {
        return dubboOrderRefundTrack;
    }

    public void setDubboOrderRefundTrack(List<DubboOrderRefundTrack> dubboOrderRefundTrack) {
        this.dubboOrderRefundTrack = dubboOrderRefundTrack;
    }

}
