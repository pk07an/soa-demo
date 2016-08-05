package com.meila.soa.order.dal.vo.order;

import java.util.Date;

/**
 * 
 ************************************************************
 * @类名 : RefundOrderVO.java
 *
 * @DESCRIPTION : 退款订单信息
 * @AUTHOR :  gogo
 * @DATE :  2016年5月19日
 ************************************************************
 */
public class RefundOrderVO extends OrderVO {
    private String refundStatus;
    private Date refundTime;

    public String getRefundStatus() {
        return refundStatus;
    }

    public void setRefundStatus(String refundStatus) {
        this.refundStatus = refundStatus;
    }

    public Date getRefundTime() {
        return refundTime;
    }

    public void setRefundTime(Date refundTime) {
        this.refundTime = refundTime;
    }
}
