package com.meila.soa.order.api.model.request;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotBlank;

import com.meila.dubbo.base.model.DubboBasicRequest;

/**
 * 
 ************************************************************
 * @类名 : DubboUpdateOrderAddressRequest.java
 *
 * @DESCRIPTION : 修改订单收货地址
 * @AUTHOR : gogo
 * @DATE : 2016年5月16日
 ************************************************************
 */
@SuppressWarnings("serial")
public class DubboUpdateAddressRequest extends DubboBasicRequest {

    @NotNull
    private Long orderId;
    @NotBlank
    private String orderNo;
    @NotNull
    private Long sellerId;
    @NotNull
    private Long addressId;
    @NotBlank
    private String country;
    @NotBlank
    private String province;
    private String city;
    private String zone;

    @NotNull
    private Long zoneId;
    @NotNull
    private String consignee;// 收货人
    @NotNull
    private String street;// 详细地址
    @NotNull
    private String phone;// 电话号码
    private String idCard; // 身份证号

    public String getZone() {
        return zone;
    }

    public void setZone(String zone) {
        this.zone = zone;
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

    public Long getAddressId() {
        return addressId;
    }

    public void setAddressId(Long addressId) {
        this.addressId = addressId;
    }

    public Long getSellerId() {
        return sellerId;
    }

    public void setSellerId(Long sellerId) {
        this.sellerId = sellerId;
    }

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

    public Long getZoneId() {
        return zoneId;
    }

    public void setZoneId(Long zoneId) {
        this.zoneId = zoneId;
    }

    public String getConsignee() {
        return consignee;
    }

    public void setConsignee(String consignee) {
        this.consignee = consignee;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getIdCard() {
        return idCard;
    }

    public void setIdCard(String idCard) {
        this.idCard = idCard;
    }

}
