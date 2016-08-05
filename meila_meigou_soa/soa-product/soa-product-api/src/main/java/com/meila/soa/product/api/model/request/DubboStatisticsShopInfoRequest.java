package com.meila.soa.product.api.model.request;

import java.util.Date;

import com.meila.dubbo.base.model.DubboBasicRequest;

/**
 * 
 ************************************************************
 * @类名 : DubboStatisticsShopInfoRequest.java
 *
 * @DESCRIPTION :统计店铺的销售情况
 * @AUTHOR : hawk
 * @DATE : 2016年3月16日
 ************************************************************
 */
public class DubboStatisticsShopInfoRequest extends DubboBasicRequest {
    private static final long serialVersionUID = 1L;

    private Long userId;

    /**
     * 需要统计的时间
     */
    private Date statistcsTime;

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Date getStatistcsTime() {
        return statistcsTime;
    }

    public void setStatistcsTime(Date statistcsTime) {
        this.statistcsTime = statistcsTime;
    }
}
