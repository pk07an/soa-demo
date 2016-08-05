package com.meila.soa.order.api.model.request;

import java.util.Date;

import com.meila.dubbo.base.model.DubboBasicPageRequest2;

/**
 * 
 ************************************************************
 * @类名 : DubboQueryRefundOrderListRequest.java
 *
 * @DESCRIPTION : 获取退款订单列表信息
 * @AUTHOR : gogo
 * @DATE : 2016年5月10日
 ************************************************************
 */
@SuppressWarnings("serial")
public class DubboQueryRefundOrderListRequest extends DubboBasicPageRequest2 {

    // 卖家ID
    private Long sellerId;

    // 订单退款状态
    private String refundStatus;
    // 起始申请退款时间
    private Date startRefundTime;
    // 结束申请退款时间
    private Date endRefundTime;
    // 订单号
    private String orderNo;
    // 收货人姓名
    private String consignee;
    // 买家昵称
    private String buyerName;

    public Long getSellerId() {
        return sellerId;
    }

    public void setSellerId(Long sellerId) {
        this.sellerId = sellerId;
    }

    public String getRefundStatus() {
        return refundStatus;
    }

    public void setRefundStatus(String refundStatus) {
        this.refundStatus = refundStatus;
    }

    public Date getStartRefundTime() {
        return startRefundTime;
    }

    public void setStartRefundTime(Date startRefundTime) {
        this.startRefundTime = startRefundTime;
    }

    public Date getEndRefundTime() {
        return endRefundTime;
    }

    public void setEndRefundTime(Date endRefundTime) {
        this.endRefundTime = endRefundTime;
    }

    public String getOrderNo() {
        return orderNo;
    }

    public void setOrderNo(String orderNo) {
        this.orderNo = orderNo;
    }

    public String getConsignee() {
        return consignee;
    }

    public void setConsignee(String consignee) {
        this.consignee = consignee;
    }

    public String getBuyerName() {
        return buyerName;
    }

    public void setBuyerName(String buyerName) {
        this.buyerName = buyerName;
    }

}
