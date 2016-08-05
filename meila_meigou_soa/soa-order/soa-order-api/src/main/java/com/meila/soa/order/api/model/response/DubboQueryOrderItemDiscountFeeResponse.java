package com.meila.soa.order.api.model.response;

import java.math.BigDecimal;
import java.util.Map;

import com.meila.dubbo.base.model.DubboBasicResponse;

/**
 * 
 ************************************************************
 * @类名 : DubboQueryOrderItemDiscountFeeResponse.java
 *
 * @DESCRIPTION : 获取订单明细的优惠金额
 * @AUTHOR : gogo
 * @DATE : 2016年5月12日
 ************************************************************
 */
@SuppressWarnings("serial")
public class DubboQueryOrderItemDiscountFeeResponse extends DubboBasicResponse {

    // key为itemId value为优惠金额
    private Map<Long, BigDecimal> discountFeeMap;

    public Map<Long, BigDecimal> getDiscountFeeMap() {
        return discountFeeMap;
    }

    public void setDiscountFeeMap(Map<Long, BigDecimal> discountFeeMap) {
        this.discountFeeMap = discountFeeMap;
    }

}
