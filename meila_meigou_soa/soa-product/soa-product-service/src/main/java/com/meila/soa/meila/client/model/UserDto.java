package com.meila.soa.meila.client.model;

import java.io.Serializable;

/**
 ************************************************************
 * @类名 : UserDto.java
 *
 * @DESCRIPTION : 用户同步DTO
 * @AUTHOR : Toney
 * @DATE : 2015年11月25日
 ************************************************************
 */
public class UserDto implements Serializable {

    /**
     * 
     */
    private static final long serialVersionUID = 1L;
    /**
     * 必填
     */
    private Long userId;
    /**
     * 昵称 必填
     */
    private String name;
    /**
     * 描述
     */
    private String desc;
    /**
     * 备注
     */
    private String remark;
    /**
     * 电话
     */
    private String phone;
    /**
     * 必填 是否删除或冻结。0：未删除未冻结。1：已删除或已冻结
     */
    private int archive;

    /**
     * 发货类型 MEILA：美啦代发货 SELLER：卖家发货 BONDED_AREA：保税仓发货
     */
    private String deliveryType;
    /**
     * 当Sku库存小于或等于这个数时,系统会发alert给卖家，无则使用默认值
     */
    private String remindAmount;
    /**
     * 是否要开启库存不足提醒, 0关闭 1开启，无则使用默认值
     */
    private int openSkuRemind;

    public int getArchive() {
        return archive;
    }

    public void setArchive(int archive) {
        this.archive = archive;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getDeliveryType() {
        return deliveryType;
    }

    public void setDeliveryType(String deliveryType) {
        this.deliveryType = deliveryType;
    }

    public String getRemindAmount() {
        return remindAmount;
    }

    public void setRemindAmount(String remindAmount) {
        this.remindAmount = remindAmount;
    }

    public int getOpenSkuRemind() {
        return openSkuRemind;
    }

    public void setOpenSkuRemind(int openSkuRemind) {
        this.openSkuRemind = openSkuRemind;
    }

}
