package com.meila.soa.order.api.model.request;

import java.util.Date;
import java.util.List;

import com.meila.dubbo.base.model.DubboBasicPageRequest2;

/**
 * 
 ************************************************************
 * @类名 : DubboQueryOrderListRequest.java
 *
 * @DESCRIPTION : 获取订单列表信息
 * @AUTHOR : gogo
 * @DATE : 2016年5月10日
 ************************************************************
 */
@SuppressWarnings("serial")
public class DubboQueryOrderListRequest extends DubboBasicPageRequest2 {

    // 卖家ID
    private Long sellerId;

    // 订单状态
    private String status;
    // 起始下单时间
    private Date startCreateAt;
    // 结束下单时间
    private Date endCreateAt;
    // 订单号
    private String orderNo;
    // 收货人姓名
    private String consignee;
    // 买家昵称
    private String buyerName;
    // 起始支付时间
    private Date startPaidAt;
    // 结束支付时间
    private Date endPaidAt;

    // 订单ID列表
    private List<Long> orderIds;

    public List<Long> getOrderIds() {
        return orderIds;
    }

    public Date getStartPaidAt() {
        return startPaidAt;
    }

    public void setStartPaidAt(Date startPaidAt) {
        this.startPaidAt = startPaidAt;
    }

    public Date getEndPaidAt() {
        return endPaidAt;
    }

    public void setEndPaidAt(Date endPaidAt) {
        this.endPaidAt = endPaidAt;
    }

    public void setOrderIds(List<Long> orderIds) {
        this.orderIds = orderIds;
    }

    public Long getSellerId() {
        return sellerId;
    }

    public void setSellerId(Long sellerId) {
        this.sellerId = sellerId;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Date getStartCreateAt() {
        return startCreateAt;
    }

    public void setStartCreateAt(Date startCreateAt) {
        this.startCreateAt = startCreateAt;
    }

    public Date getEndCreateAt() {
        return endCreateAt;
    }

    public void setEndCreateAt(Date endCreateAt) {
        this.endCreateAt = endCreateAt;
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
