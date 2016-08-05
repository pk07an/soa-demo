package com.meila.soa.order.api.model.response;

import com.meila.dubbo.base.model.DubboBasicResponse;

/**
 * 
 ************************************************************ 
 * @类名 : DubboOrderStatusStatResponse.java
 * 
 * @DESCRIPTION : 订单统计返回结果
 * @AUTHOR : yongqi
 * @DATE : 2016-5-20
 ************************************************************ 
 */
public class DubboOrderStatusStatResponse extends DubboBasicResponse {

    private static final long serialVersionUID = -1848433383481357699L;

    private Integer cancelledCount;
    private Integer closedCount;
    private Integer paidCount;
    private Integer shippedCount;
    private Integer partShippedCount;
    private Integer refundingCount;
    private Integer submittedCount;
    private Integer successCount;
    private Integer waitPayConfirmCount;
    private Long sellerId;

    public Long getSellerId() {
        return sellerId;
    }

    public void setSellerId(Long sellerId) {
        this.sellerId = sellerId;
    }

    public Integer getCancelledCount() {
        return cancelledCount;
    }

    public void setCancelledCount(Integer cancelledCount) {
        this.cancelledCount = cancelledCount;
    }

    public Integer getClosedCount() {
        return closedCount;
    }

    public void setClosedCount(Integer closedCount) {
        this.closedCount = closedCount;
    }

    public Integer getPaidCount() {
        return paidCount;
    }

    public void setPaidCount(Integer paidCount) {
        this.paidCount = paidCount;
    }

    public Integer getShippedCount() {
        return shippedCount;
    }

    public void setShippedCount(Integer shippedCount) {
        this.shippedCount = shippedCount;
    }

    public Integer getPartShippedCount() {
        return partShippedCount;
    }

    public void setPartShippedCount(Integer partShippedCount) {
        this.partShippedCount = partShippedCount;
    }

    public Integer getRefundingCount() {
        return refundingCount;
    }

    public void setRefundingCount(Integer refundingCount) {
        this.refundingCount = refundingCount;
    }

    public Integer getSubmittedCount() {
        return submittedCount;
    }

    public void setSubmittedCount(Integer submittedCount) {
        this.submittedCount = submittedCount;
    }

    public Integer getSuccessCount() {
        return successCount;
    }

    public void setSuccessCount(Integer successCount) {
        this.successCount = successCount;
    }

    public Integer getWaitPayConfirmCount() {
        return waitPayConfirmCount;
    }

    public void setWaitPayConfirmCount(Integer waitPayConfirmCount) {
        this.waitPayConfirmCount = waitPayConfirmCount;
    }
}
