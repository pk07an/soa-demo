/**
 * 
 */
package com.meila.soa.order.api.model.request;

import java.util.Date;

import javax.validation.constraints.NotNull;

import com.meila.dubbo.base.model.DubboBasicRequest;

/**
 ************************************************************
 * @类名 : DubboQueryOrderSellNumRequest.java
 *
 * @DESCRIPTION : 查询某时间段内指定状态的spu对应订单销量
 * @AUTHOR : flong
 * @DATE : 2016年4月6日
 ************************************************************
 */
@SuppressWarnings("serial")
public class DubboQueryOrderCountRequest extends DubboBasicRequest {

    @NotNull
    private Long sellerId;
    private String status;
    @NotNull
    private Date startPaidDate;

    private Date endPaidDate;

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

    public Date getStartPaidDate() {
        return startPaidDate;
    }

    public void setStartPaidDate(Date startPaidDate) {
        this.startPaidDate = startPaidDate;
    }

    public Date getEndPaidDate() {
        return endPaidDate;
    }

    public void setEndPaidDate(Date endPaidDate) {
        this.endPaidDate = endPaidDate;
    }

}
