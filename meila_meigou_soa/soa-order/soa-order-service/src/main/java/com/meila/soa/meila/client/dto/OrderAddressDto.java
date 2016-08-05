package com.meila.soa.meila.client.dto;

import java.io.Serializable;

/**
 ************************************************************
 * @类名 : OrderAddressDto.java
 *
 * @DESCRIPTION : 调用OMS订单地址修改DTO
 * @AUTHOR : gogo
 * @DATE : 2016年05月16日
 ************************************************************
 */
@SuppressWarnings("serial")
public class OrderAddressDto implements Serializable {

    private String orderNo;
    
    private Long orderId;
    
    private Long orderAddressId;
    
    private String phone;
    
    private String consignee;
    
    private String country;
    
    private String province;
    
    private String city;
    
    private String cardNo; // 身份证
    
    private long sellerId; // 卖家ID
    
    /**
     * 区
     */
    private String zone;
    
    /**
     * 明细地址
     */
    private String detailAddress;
    
    /**
     * 街道 预留
     */
    private String street;

    public String getOrderNo() {
        return orderNo;
    }

    public void setOrderNo(String orderNo) {
        this.orderNo = orderNo;
    }

    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    public Long getOrderAddressId() {
        return orderAddressId;
    }

    public void setOrderAddressId(Long orderAddressId) {
        this.orderAddressId = orderAddressId;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getConsignee() {
        return consignee;
    }

    public void setConsignee(String consignee) {
        this.consignee = consignee;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getZone() {
        return zone;
    }

    public void setZone(String zone) {
        this.zone = zone;
    }

    public String getDetailAddress() {
        return detailAddress;
    }

    public void setDetailAddress(String detailAddress) {
        this.detailAddress = detailAddress;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getCardNo() {
        return cardNo;
    }

    public void setCardNo(String cardNo) {
        this.cardNo = cardNo;
    }

    public long getSellerId() {
        return sellerId;
    }

    public void setSellerId(long sellerId) {
        this.sellerId = sellerId;
    }

}
