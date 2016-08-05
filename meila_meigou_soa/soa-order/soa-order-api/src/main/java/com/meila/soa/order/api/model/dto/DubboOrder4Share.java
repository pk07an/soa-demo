/**
 * 
 */
package com.meila.soa.order.api.model.dto;

import java.util.Date;

import com.meila.dubbo.base.model.BasicSeriModel;

/**
 ************************************************************
 * @类名 : DubboOrder4Share.java
 *
 * @DESCRIPTION : 分享好友时用到的订单信息
 * @AUTHOR : flong
 * @DATE : 2016年3月14日
 ************************************************************
 */
public class DubboOrder4Share extends BasicSeriModel {
    private static final long serialVersionUID = 1L;

    private Long buyerId;// 买家id
    private String orderNo;// 订单编号
    private String status;// 订单状态：SUBMITTED 已提交； CANCELLED 取消； PAID 已付款； SHIPPED 已发货； SUCCESS 交易成功； REFUNDING 退款申请中；
                          // CLOSED 交易关闭
    private Date createdAt;// 创建时间
    private Date succeedAt;// 签收时间

    public Long getBuyerId() {
        return buyerId;
    }

    public void setBuyerId(Long buyerId) {
        this.buyerId = buyerId;
    }

    public String getOrderNo() {
        return orderNo;
    }

    public void setOrderNo(String orderNo) {
        this.orderNo = orderNo;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public Date getSucceedAt() {
        return succeedAt;
    }

    public void setSucceedAt(Date succeedAt) {
        this.succeedAt = succeedAt;
    }

}
