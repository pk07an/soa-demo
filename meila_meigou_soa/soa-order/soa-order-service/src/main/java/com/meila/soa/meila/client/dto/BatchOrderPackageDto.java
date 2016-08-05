package com.meila.soa.meila.client.dto;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

/**
 * 
 ************************************************************
 * @类名 : BatchOrderPackageDto.java
 *
 * @DESCRIPTION : 包裹DTO
 * @AUTHOR : gogo
 * @DATE : 2016年5月20日
 ************************************************************
 */
public class BatchOrderPackageDto implements Serializable {

    /**
     * 
     */
    private static final long serialVersionUID = 1L;

    private Long packageId;// 包裹ID

    private String orderNo;// 订单编号

    private Long sellerId; // 卖家ID

    private BigDecimal totalFee; // 订单售价，支付金额

    private BigDecimal discountFee; // 订单优惠金额

    private BigDecimal goodsFee; // 订单商品金额

    private BigDecimal logisticsFee; // 订单物流费用

    private String deliverType; // 卖家发货类型 'SELLER：卖家发货，MEILA：美啦发货',OVERSEAS_DIRECT_MAIL：海外直邮

    private String packageCode; // 包裹编码

    private String sourceStatus; // 货源匹配方式 CASH_SALE 已匹配到现货, PURCHASE_NOTE 已匹配到采购单, <Null> 此字段为null时，代表该包裹等待匹配货源（现货 or
                                 // 采购单）',

    private String logisticsOrderNo; // 快递单号

    private String logisticsCompany;// 快递公司

    private String logisticsComCode;// 快递公司编码

    private String logisticsStatus; // 物流最新状态

    private String packageStatus; // 包裹状态：SHIPPED 已发货 ， SINGED 已签收

    private Date shippedTime;// 发货时间

    private Date signTime; // 签收时间

    private String signType;// 签收方式： USER 用户签收， AUTO 过期自动签收(15天)

    private String packageRemark; // 备注

    private Date createTime; // 创建时间

    private Date updateTime;// 更新时间

    private String overLogisticsOrderNo; //海外快递单号
    private String overLogisticsCompany; //海外快递公司
    private String overLogisticsComCode; //海外快递公司编码

    private List<OrderPackageItemDto> orderPackageItemDtos;

    public String getOverLogisticsOrderNo() {
        return overLogisticsOrderNo;
    }

    public void setOverLogisticsOrderNo(String overLogisticsOrderNo) {
        this.overLogisticsOrderNo = overLogisticsOrderNo;
    }

    public String getOverLogisticsCompany() {
        return overLogisticsCompany;
    }

    public void setOverLogisticsCompany(String overLogisticsCompany) {
        this.overLogisticsCompany = overLogisticsCompany;
    }

    public String getOverLogisticsComCode() {
        return overLogisticsComCode;
    }

    public void setOverLogisticsComCode(String overLogisticsComCode) {
        this.overLogisticsComCode = overLogisticsComCode;
    }

    public static long getSerialversionuid() {
        return serialVersionUID;
    }

    public Long getPackageId() {
        return packageId;
    }

    public void setPackageId(Long packageId) {
        this.packageId = packageId;
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

    public String getDeliverType() {
        return deliverType;
    }

    public void setDeliverType(String deliverType) {
        this.deliverType = deliverType;
    }

    public String getPackageCode() {
        return packageCode;
    }

    public void setPackageCode(String packageCode) {
        this.packageCode = packageCode;
    }

    public String getSourceStatus() {
        return sourceStatus;
    }

    public void setSourceStatus(String sourceStatus) {
        this.sourceStatus = sourceStatus;
    }

    public String getLogisticsOrderNo() {
        return logisticsOrderNo;
    }

    public void setLogisticsOrderNo(String logisticsOrderNo) {
        this.logisticsOrderNo = logisticsOrderNo;
    }

    public String getLogisticsCompany() {
        return logisticsCompany;
    }

    public void setLogisticsCompany(String logisticsCompany) {
        this.logisticsCompany = logisticsCompany;
    }

    public String getLogisticsStatus() {
        return logisticsStatus;
    }

    public void setLogisticsStatus(String logisticsStatus) {
        this.logisticsStatus = logisticsStatus;
    }

    public String getPackageStatus() {
        return packageStatus;
    }

    public void setPackageStatus(String packageStatus) {
        this.packageStatus = packageStatus;
    }

    public Date getShippedTime() {
        return shippedTime;
    }

    public void setShippedTime(Date shippedTime) {
        this.shippedTime = shippedTime;
    }

    public Date getSignTime() {
        return signTime;
    }

    public void setSignTime(Date signTime) {
        this.signTime = signTime;
    }

    public String getSignType() {
        return signType;
    }

    public void setSignType(String signType) {
        this.signType = signType;
    }

    public String getPackageRemark() {
        return packageRemark;
    }

    public void setPackageRemark(String packageRemark) {
        this.packageRemark = packageRemark;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public List<OrderPackageItemDto> getOrderPackageItemDtos() {
        return orderPackageItemDtos;
    }

    public void setOrderPackageItemDtos(List<OrderPackageItemDto> orderPackageItemDtos) {
        this.orderPackageItemDtos = orderPackageItemDtos;
    }

    public BigDecimal getTotalFee() {
        return totalFee;
    }

    public void setTotalFee(BigDecimal totalFee) {
        this.totalFee = totalFee;
    }

    public BigDecimal getDiscountFee() {
        return discountFee;
    }

    public void setDiscountFee(BigDecimal discountFee) {
        this.discountFee = discountFee;
    }

    public BigDecimal getGoodsFee() {
        return goodsFee;
    }

    public void setGoodsFee(BigDecimal goodsFee) {
        this.goodsFee = goodsFee;
    }

    public BigDecimal getLogisticsFee() {
        return logisticsFee;
    }

    public void setLogisticsFee(BigDecimal logisticsFee) {
        this.logisticsFee = logisticsFee;
    }

    public String getLogisticsComCode() {
        return logisticsComCode;
    }

    public void setLogisticsComCode(String logisticsComCode) {
        this.logisticsComCode = logisticsComCode;
    }
}
