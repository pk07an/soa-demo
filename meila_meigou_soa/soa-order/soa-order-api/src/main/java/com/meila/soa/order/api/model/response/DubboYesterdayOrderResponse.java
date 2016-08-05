package com.meila.soa.order.api.model.response;

import com.meila.dubbo.base.model.DubboBasicResponse;

/**
 * 
 ************************************************************ 
 * @类名 : DubboOrderStatusStatResponse.java
 * 
 * @DESCRIPTION : 昨日订单统计返回结果
 * @AUTHOR : yongqi
 * @DATE : 2016-5-20
 ************************************************************ 
 */
public class DubboYesterdayOrderResponse extends DubboBasicResponse {

    private static final long serialVersionUID = -1207957708068637784L;

    private Integer yesterdayOrderCount;

    private Long sellerId;

    public Long getSellerId() {
        return sellerId;
    }

    public void setSellerId(Long sellerId) {
        this.sellerId = sellerId;
    }

    public Integer getYesterdayOrderCount() {
        return yesterdayOrderCount;
    }

    public void setYesterdayOrderCount(Integer yesterdayOrderCount) {
        this.yesterdayOrderCount = yesterdayOrderCount;
    }

}
