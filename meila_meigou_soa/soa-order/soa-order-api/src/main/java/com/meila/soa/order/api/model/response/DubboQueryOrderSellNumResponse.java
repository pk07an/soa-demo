/**
 * 
 */
package com.meila.soa.order.api.model.response;

import java.util.Date;
import java.util.Map;

import com.meila.dubbo.base.model.DubboBasicResponse;
import com.meila.soa.order.api.model.dto.OrderStatusEnum;

/**
 ************************************************************
 * @类名 : DubboQueryOrderSellNumResponse.java
 *
 * @DESCRIPTION :
 * @AUTHOR : flong
 * @DATE : 2016年4月6日
 ************************************************************
 */
public class DubboQueryOrderSellNumResponse extends DubboBasicResponse {
    private static final long serialVersionUID = 1L;

    private Map<Long, Integer> resultMap;

    private OrderStatusEnum orderStatus;

    private Date beginTime;

    private Date endTime;

    public Map<Long, Integer> getResultMap() {
        return resultMap;
    }

    public void setResultMap(Map<Long, Integer> resultMap) {
        this.resultMap = resultMap;
    }

    public OrderStatusEnum getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(OrderStatusEnum orderStatus) {
        this.orderStatus = orderStatus;
    }

    public Date getBeginTime() {
        return beginTime;
    }

    public void setBeginTime(Date beginTime) {
        this.beginTime = beginTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

}
