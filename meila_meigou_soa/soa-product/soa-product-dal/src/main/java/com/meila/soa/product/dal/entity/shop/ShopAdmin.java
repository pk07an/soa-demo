package com.meila.soa.product.dal.entity.shop;

import com.meila.soa.product.dal.type.BalanceType;
import com.meila.soa.product.dal.type.DeliveryType;

public class ShopAdmin extends Shop {
    private String phone;

    private String opRemark;

    private DeliveryType deliveryType;

    private BalanceType balanceType;

    private Byte balanceBankId;

    private String balanceAccount;

    private String qq;

    private Short sellerType;

    // 收款人所在省
    private String province;

    // 收款人所在市
    private String city;

    // 开户支行
    private String openBank;
    // 收款人名称
    private String receiverName;

    // 卖家个性称号
    private String selfhoodName;

    /**
     * 卖家昵称
     */
    private String userName;

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getOpRemark() {
        return opRemark;
    }

    public void setOpRemark(String opRemark) {
        this.opRemark = opRemark;
    }

    public DeliveryType getDeliveryType() {
        return deliveryType;
    }

    public void setDeliveryType(DeliveryType deliveryType) {
        this.deliveryType = deliveryType;
    }

    public BalanceType getBalanceType() {
        return balanceType;
    }

    public void setBalanceType(BalanceType balanceType) {
        this.balanceType = balanceType;
    }

    public Byte getBalanceBankId() {
        return balanceBankId;
    }

    public void setBalanceBankId(Byte balanceBankId) {
        this.balanceBankId = balanceBankId;
    }

    public String getBalanceAccount() {
        return balanceAccount;
    }

    public void setBalanceAccount(String balanceAccount) {
        this.balanceAccount = balanceAccount;
    }

    public String getQq() {
        return qq;
    }

    public void setQq(String qq) {
        this.qq = qq;
    }

    public Short getSellerType() {
        return sellerType;
    }

    public void setSellerType(Short sellerType) {
        this.sellerType = sellerType;
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

    public String getOpenBank() {
        return openBank;
    }

    public void setOpenBank(String openBank) {
        this.openBank = openBank;
    }

    public String getReceiverName() {
        return receiverName;
    }

    public void setReceiverName(String receiverName) {
        this.receiverName = receiverName;
    }

    public String getSelfhoodName() {
        return selfhoodName;
    }

    public void setSelfhoodName(String selfhoodName) {
        this.selfhoodName = selfhoodName;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }
}
