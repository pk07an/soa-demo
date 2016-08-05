package com.meila.soa.order.dal.vo.order;

import com.meila.soa.order.dal.entity.order.OrderEntity;

/**
 * 
 ************************************************************
 * @类名 : OrderVO.java
 *
 * @DESCRIPTION : 订单虚拟对象
 * @AUTHOR :  gogo
 * @DATE :  2016年5月10日
 ************************************************************
 */
public class OrderVO extends OrderEntity{
    //买家昵称
    private String buyerName;

    public String getBuyerName() {
        return buyerName;
    }

    public void setBuyerName(String buyerName) {
        this.buyerName = buyerName;
    }
}
