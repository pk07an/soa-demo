/**
 * 
 */
package com.meila.soa.order.api.model.request;

import java.util.Date;
import java.util.List;

import javax.validation.constraints.Size;

import com.meila.dubbo.base.model.DubboBasicRequest;
import com.meila.soa.order.api.model.dto.OrderStatusEnum;

/**
 ************************************************************
 * @类名 : DubboQueryOrderSellNumRequest.java
 *
 * @DESCRIPTION : 查询某时间段内指定状态的spu对应订单销量
 * @AUTHOR : flong
 * @DATE : 2016年4月6日
 ************************************************************
 */
public class DubboQueryOrderSellNumRequest extends DubboBasicRequest {
    private static final long serialVersionUID = 1L;
    @Size(max = 500, message = "Please limit the batch number in 1-500")
    private List<Long> skuIds;

    private OrderStatusEnum orderStatus;

    private Date beginTime;

    private Date endTime;

    public List<Long> getSkuIds() {
        return skuIds;
    }

    public void setSkuIds(List<Long> skuIds) {
        this.skuIds = skuIds;
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
