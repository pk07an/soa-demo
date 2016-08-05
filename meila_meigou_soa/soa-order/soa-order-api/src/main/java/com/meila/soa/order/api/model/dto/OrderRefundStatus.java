package com.meila.soa.order.api.model.dto;

/**
 * 
 ************************************************************
 * @类名 : OrderRefundStatus.java
 *
 * @DESCRIPTION : 订单退款状态
 * @AUTHOR :  gogo
 * @DATE :  2016年5月12日
 ************************************************************
 */
public enum OrderRefundStatus {
    PROCESS("PROCESS","处理中"), // 处理中
    B_CANCEL("B_CANCEL","买家取消"), // 买家取消
    S_ACCPECT("S_ACCPECT","卖家同意"), // 卖家同意
    S_REJECT("S_REJECT","卖家拒绝"), // 卖家拒绝
    P_ACCPECT("P_ACCPECT","平台确认"), // 平台确认
    P_REJECT("P_REJECT","平台拒绝"), // 平台拒绝|
    SUCCESS("SUCCESS","退款成功");// 退款成功（实际打款）
    
    private OrderRefundStatus(String code, String desc)
    {
        this.code = code;
        this.desc = desc;
    }
    
    private String code;
    private String desc;
    
    public static OrderRefundStatus findOrderRefundStatus(String code){
        for(OrderRefundStatus refundStatus:OrderRefundStatus.values()){
            if(refundStatus.getCode().equals(code)){
                return refundStatus;
            }
        }
        return null;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }
    
    
}
