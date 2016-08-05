package com.meila.soa.product.api.model.response;

import com.meila.dubbo.base.model.DubboBasicPageResponse;

/**
 * 
 ************************************************************
 * @类名 : DubboStatisticsShopInfoResponse.java
 *
 * @DESCRIPTION :查询店铺统计信息返回
 * @AUTHOR : hawk
 * @DATE : 2016年3月16日
 ************************************************************
 */
public class DubboStatisticsShopInfoResponse extends DubboBasicPageResponse {
    private static final long serialVersionUID = 1L;

    /**
     * 店铺ID
     */
    private Long shopId;

    /**
     * 订单数量
     */
    private Integer orderNum;

    /**
     * 用户类型
     */
    private String accountType;

    /**
     * 访客数
     */
    private Integer visitorNum;

    /**
     * 成交数
     */
    private Integer dealNum;

    public Long getShopId() {
        return shopId;
    }

    public void setShopId(Long shopId) {
        this.shopId = shopId;
    }

    public Integer getOrderNum() {
        return orderNum;
    }

    public void setOrderNum(Integer orderNum) {
        this.orderNum = orderNum;
    }

    public String getAccountType() {
        return accountType;
    }

    public void setAccountType(String accountType) {
        this.accountType = accountType;
    }

    public Integer getVisitorNum() {
        return visitorNum;
    }

    public void setVisitorNum(Integer visitorNum) {
        this.visitorNum = visitorNum;
    }

    public Integer getDealNum() {
        return dealNum;
    }

    public void setDealNum(Integer dealNum) {
        this.dealNum = dealNum;
    }
}
