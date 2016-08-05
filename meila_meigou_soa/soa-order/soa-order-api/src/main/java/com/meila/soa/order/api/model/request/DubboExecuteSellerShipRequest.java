package com.meila.soa.order.api.model.request;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotBlank;

import com.meila.dubbo.base.model.DubboBasicRequest;

/**
 * 
 ************************************************************
 * @类名 : DubboExecuteSellerShipRequest.java
 *
 * @DESCRIPTION : 执行卖家发货结果
 * @AUTHOR : gogo
 * @DATE : 2016年5月12日
 ************************************************************
 */
@SuppressWarnings("serial")
public class DubboExecuteSellerShipRequest extends DubboBasicRequest {

    @NotBlank(message = "快递公司不能为空")
    private String logisticsCompany;
    @NotBlank(message = "快递单号不能为空")
    private String logisticsOrderNo;
    @NotNull(message = "订单ID不能为空")
    private String orderNo;
    @NotNull(message = "卖家ID不能为空")
    private Long sellerId;
    @NotBlank(message = "包裹单号不能为空")
    private String packageCode;
    // 国际物流标志0-国内,1-国际物流,2-国内国际共用物流单
    @NotNull(message = "国际物流标志不能为空")
    private Integer internationalFlag;

    public String getPackageCode() {
        return packageCode;
    }

    public void setPackageCode(String packageCode) {
        this.packageCode = packageCode;
    }

    public Integer getInternationalFlag() {
        return internationalFlag;
    }

    public void setInternationalFlag(Integer internationalFlag) {
        this.internationalFlag = internationalFlag;
    }

    public String getLogisticsCompany() {
        return logisticsCompany;
    }

    public void setLogisticsCompany(String logisticsCompany) {
        this.logisticsCompany = logisticsCompany;
    }

    public String getLogisticsOrderNo() {
        return logisticsOrderNo;
    }

    public void setLogisticsOrderNo(String logisticsOrderNo) {
        this.logisticsOrderNo = logisticsOrderNo;
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

}
