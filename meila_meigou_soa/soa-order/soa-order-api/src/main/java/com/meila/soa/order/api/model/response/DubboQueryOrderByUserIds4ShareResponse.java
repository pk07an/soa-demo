/**
 * 
 */
package com.meila.soa.order.api.model.response;

import java.util.List;

import com.meila.dubbo.base.model.DubboBasicResponse;
import com.meila.soa.order.api.model.dto.DubboOrder4Share;

/**
 ************************************************************
 * @类名 : DubboQueryOrderByUserIdsResponse.java
 *
 * @DESCRIPTION : 根据userid批量查询订单信息的返回
 * @AUTHOR : flong
 * @DATE : 2016年3月14日
 ************************************************************
 */
public class DubboQueryOrderByUserIds4ShareResponse extends DubboBasicResponse {
    private static final long serialVersionUID = 1L;
    private List<DubboOrder4Share> orderList;

    public List<DubboOrder4Share> getOrderList() {
        return orderList;
    }

    public void setOrderList(List<DubboOrder4Share> orderList) {
        this.orderList = orderList;
    }

}
