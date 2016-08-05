package com.meila.soa.meila.client.dto;

import java.io.Serializable;

/**
 * 
 ************************************************************
 * @类名 : OrderLogisticsDto.java
 *
 * @DESCRIPTION : 调用OMS同步订单物流信息DTO
 * @AUTHOR :  gogo
 * @DATE :  2016年5月16日
 ************************************************************
 */
@SuppressWarnings("serial")
public class OrderLogisticsDto implements Serializable{

    private String orderNo;
    private Long sellerId;
    private String logisticsCompany;
    private String logisticsNo;
    
    private String packageCode;
    // 国际物流标志0-国内,1-国际物流,2-国内国际共用物流单
    private Integer internalFlag;
    
    public Integer getInternalFlag() {
        return internalFlag;
    }
    public void setInternalFlag(Integer internalFlag) {
        this.internalFlag = internalFlag;
    }
    public String getPackageCode() {
        return packageCode;
    }
    public void setPackageCode(String packageCode) {
        this.packageCode = packageCode;
    }
    public String getOrderNo() {
        return orderNo;
    }
    public void setOrderNo(String orderNo) {
        this.orderNo = orderNo;
    }
    public Long getSellerId() {
        return sellerId;
    }
    public void setSellerId(Long sellerId) {
        this.sellerId = sellerId;
    }
    public String getLogisticsCompany() {
        return logisticsCompany;
    }
    public void setLogisticsCompany(String logisticsCompany) {
        this.logisticsCompany = logisticsCompany;
    }
    public String getLogisticsNo() {
        return logisticsNo;
    }
    public void setLogisticsNo(String logisticsNo) {
        this.logisticsNo = logisticsNo;
    }
    
}
