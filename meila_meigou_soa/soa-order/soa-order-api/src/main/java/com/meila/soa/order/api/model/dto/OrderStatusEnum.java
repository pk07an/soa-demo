/**
 * 
 */
package com.meila.soa.order.api.model.dto;

/**
 ************************************************************
 * @类名 : OrderStatusEnum.java
 *
 * @DESCRIPTION : 订单状态
 * @AUTHOR : flong
 * @DATE : 2016年4月5日
 ************************************************************
 */
public enum OrderStatusEnum {
    /**
     * 已提交
     */
    SUBMITTED,
    /**
     * 取消
     */
    CANCELLED,
    /**
     * 已付款
     */
    PAID,
    /**
     * 已发货
     */
    SHIPPED,
    /**
     * 部分发货
     */
    PART_SHIPPED,
    /**
     * 交易成功
     */
    SUCCESS,
    /**
     * 退款申请中
     */
    REFUNDING,
    /**
     * 交易关闭
     */
    CLOSED,
    /**
     * 支付等待回执
     */
    WAITPAYCONFIRM;
}
