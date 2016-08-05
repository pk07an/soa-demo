package com.meila.soa.order.api.model.dto;

import java.util.ArrayList;
import java.util.List;

/**
 * 
 ************************************************************
 * @类名 : DubboOrderInfo.java
 *
 * @DESCRIPTION : 订单信息对象
 * @AUTHOR : gogo
 * @DATE : 2016年5月10日
 ************************************************************
 */
@SuppressWarnings("serial")
public class DubboOrder extends DubboOrderInfo {

    //买家昵称
    private String buyerName;
    //拼团编号
    private String tuanNo;
    //是否是拼团订单
    private Boolean tuanFlag;
    //拼团订单状态
    private String tuanStatus;
    //卖家回写备注
    private String sellerRemark;
    
    private List<DubboOrderItem> items;
    
    public String getTuanNo() {
        return tuanNo;
    }

    public void setTuanNo(String tuanNo) {
        this.tuanNo = tuanNo;
    }

    public DubboOrder()
    {
        items = new ArrayList<>(); 
    }

    public String getBuyerName() {
        return buyerName;
    }

    public void setBuyerName(String buyerName) {
        this.buyerName = buyerName;
    }

    public List<DubboOrderItem> getItems() {
        return items;
    }

    public void setItems(List<DubboOrderItem> items) {
        this.items = items;
    }

    public Boolean getTuanFlag() {
        return tuanFlag;
    }

    public void setTuanFlag(Boolean tuanFlag) {
        this.tuanFlag = tuanFlag;
    }

    public String getTuanStatus() {
        return tuanStatus;
    }

    public void setTuanStatus(String tuanStatus) {
        this.tuanStatus = tuanStatus;
    }

    public String getSellerRemark() {
        return sellerRemark;
    }

    public void setSellerRemark(String sellerRemark) {
        this.sellerRemark = sellerRemark;
    }

}
