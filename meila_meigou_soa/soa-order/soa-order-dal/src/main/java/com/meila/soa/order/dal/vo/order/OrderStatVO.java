/**
 * 
 */
package com.meila.soa.order.dal.vo.order;

/**
 ************************************************************
 * @类名 : OrderStatVO.java
 *
 * @DESCRIPTION : 订单统计vo
 * @AUTHOR :  yongqi
 * @DATE :  2016-5-20
 ************************************************************
 */
public class OrderStatVO {

    private String status;
    private Integer count;
    
    public String getStatus() {
        return status;
    }
    public void setStatus(String status) {
        this.status = status;
    }
    public Integer getCount() {
        return count;
    }
    public void setCount(Integer count) {
        this.count = count;
    }
    
    
}
