package com.meila.soa.product.api.model.request.inventory;

import java.util.List;

import com.meila.dubbo.base.model.DubboBasicRequest;
import com.meila.soa.product.api.model.dto.DubboSkuAmountInfo;

/**
 * 
 ************************************************************
 * @类名 : DubboLockInvRequest.java
 *
 * @DESCRIPTION :
 * @AUTHOR : hawk
 * @DATE : 2016年4月18日
 ************************************************************
 */
public class DubboLockInvRequest extends DubboBasicRequest {
    private static final long serialVersionUID = 1L;

    /**
     * 订单编号
     */
    private String orderNo;

    private List<DubboSkuAmountInfo> skuAmountInfoList;

    public String getOrderNo() {
        return orderNo;
    }

    public void setOrderNo(String orderNo) {
        this.orderNo = orderNo;
    }

    public List<DubboSkuAmountInfo> getSkuAmountInfoList() {
        return skuAmountInfoList;
    }

    public void setSkuAmountInfoList(List<DubboSkuAmountInfo> skuAmountInfoList) {
        this.skuAmountInfoList = skuAmountInfoList;
    }

}
