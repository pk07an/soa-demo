package com.meila.soa.order.dal.entity.order;

import java.math.BigDecimal;

public class OrderItemPromotionEntity {
    private Long id;

    private Long orderItemId;

    private String activityIdstr;

    private BigDecimal discountFee;

    private String reductionType;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getOrderItemId() {
        return orderItemId;
    }

    public void setOrderItemId(Long orderItemId) {
        this.orderItemId = orderItemId;
    }

    public String getActivityIdstr() {
        return activityIdstr;
    }

    public void setActivityIdstr(String activityIdstr) {
        this.activityIdstr = activityIdstr;
    }

    public BigDecimal getDiscountFee() {
        return discountFee;
    }

    public void setDiscountFee(BigDecimal discountFee) {
        this.discountFee = discountFee;
    }

    public String getReductionType() {
        return reductionType;
    }

    public void setReductionType(String reductionType) {
        this.reductionType = reductionType;
    }
}