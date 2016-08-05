package com.meila.soa.product.api.model.request;

import java.util.Date;

import javax.validation.constraints.Pattern;

import com.meila.dubbo.base.model.DubboBasicPageRequest2;

/**
 * 
 ************************************************************
 * @类名 : DubboSearchShopRequest.java
 *
 * @DESCRIPTION :搜索店铺信息
 * @AUTHOR : hawk
 * @DATE : 2016年3月16日
 ************************************************************
 */
public class DubboSearchShopRequest extends DubboBasicPageRequest2 {
    private static final long serialVersionUID = 1L;

    /**
     * 手机号码
     */
    private String phone;

    /**
     * 店铺名称
     */
    private String shopName;

    /**
     * 逻辑删除标识
     */
    private Boolean archive;

    /**
     * 佣金
     */
    private String commision;

    /**
     * 担保
     */
    private String danbao;

    /**
     * 创建时间：开始
     */
    private Date beginTime;

    /**
     * 创建时间：结束
     */
    private Date endTime;

    /**
     * 卖家类型
     */
    private Short sellerType;

    /**
     * 发货类型
     */
    private String deliveryType;

    /**
     * 结算方式
     */
    private String balanceType;

    /**
     * 结算银行ID
     */
    private Byte balanceBankId;

    /**
     * 微信号
     */
    private String wechat;

    /**
     * QQ号码
     */
    private String qq;

    /**
     * 用户ID
     */
    private String ownerId;

    /**
     * 卖家昵称
     */
    private String userName;

    @Pattern(regexp = "ACTIVE|FROZEN")
    private String shopStatus;

    public String getShopStatus() {
        return shopStatus;
    }

    public void setShopStatus(String shopStatus) {
        this.shopStatus = shopStatus;
    }

    /**
     * 卖家来源
     */
    private String sellerSource;

    public String getBalanceType() {
        return balanceType;
    }

    public void setBalanceType(String balanceType) {
        this.balanceType = balanceType;
    }

    public Byte getBalanceBankId() {
        return balanceBankId;
    }

    public void setBalanceBankId(Byte balanceBankId) {
        this.balanceBankId = balanceBankId;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getShopName() {
        return shopName;
    }

    public void setShopName(String shopName) {
        this.shopName = shopName;
    }

    public Boolean getArchive() {
        return archive;
    }

    public void setArchive(Boolean archive) {
        this.archive = archive;
    }

    public String getCommision() {
        return commision;
    }

    public void setCommision(String commision) {
        this.commision = commision;
    }

    public String getDanbao() {
        return danbao;
    }

    public void setDanbao(String danbao) {
        this.danbao = danbao;
    }

    public Date getBeginTime() {
        return beginTime;
    }

    public void setBeginTime(Date beginTime) {
        this.beginTime = beginTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    public Short getSellerType() {
        return sellerType;
    }

    public void setSellerType(Short sellerType) {
        this.sellerType = sellerType;
    }

    public String getDeliveryType() {
        return deliveryType;
    }

    public void setDeliveryType(String deliveryType) {
        this.deliveryType = deliveryType;
    }

    public String getWechat() {
        return wechat;
    }

    public void setWechat(String wechat) {
        this.wechat = wechat;
    }

    public String getQq() {
        return qq;
    }

    public void setQq(String qq) {
        this.qq = qq;
    }

    public String getOwnerId() {
        return ownerId;
    }

    public void setOwnerId(String ownerId) {
        this.ownerId = ownerId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getSellerSource() {
        return sellerSource;
    }

    public void setSellerSource(String sellerSource) {
        this.sellerSource = sellerSource;
    }
}
