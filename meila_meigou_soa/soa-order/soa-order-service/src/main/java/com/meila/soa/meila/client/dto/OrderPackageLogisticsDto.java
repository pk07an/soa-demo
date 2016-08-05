package com.meila.soa.meila.client.dto;

import java.io.Serializable;
import java.util.Date;

/**
 ************************************************************
 * @类名 : OrderPackageLogisticsDto.java
 *
 * @DESCRIPTION : 订单物流DTO
 * @AUTHOR : gogo
 * @DATE : 2016年05月20日
 ************************************************************
 */
public class OrderPackageLogisticsDto implements Serializable {

    /**
     * 
     */
    private static final long serialVersionUID = 1L;

    private Long ptrackId;// 轨迹id

    private String packageCode;// 包裹编号

    private String ptrackType;// 轨迹类型: WMS_TRACK.仓储轨迹 INLAND_TRACK.国内物流轨迹 FOREIGN_TRACK.海外物流轨迹

    private Date ptrackTime;// 状态变化时间

    /**
     * WMS方面的状态：质检(30) 分配（40），拣货（60），复核打包（63），发运（80） \r\n 国内物流的状态：1已揽收，2疑难，3已签收，4退签，5同城派送中，6退回，7转单
     */
    private String ptrackStatus;

    private String ptrackRemark;// 描述

    private Date createTime;// 创建时间

    private Date updateTime;// 修改时间

    public Long getPtrackId() {
        return ptrackId;
    }

    public void setPtrackId(Long ptrackId) {
        this.ptrackId = ptrackId;
    }

    public String getPackageCode() {
        return packageCode;
    }

    public void setPackageCode(String packageCode) {
        this.packageCode = packageCode;
    }

    public String getPtrackType() {
        return ptrackType;
    }

    public void setPtrackType(String ptrackType) {
        this.ptrackType = ptrackType;
    }

    public Date getPtrackTime() {
        return ptrackTime;
    }

    public void setPtrackTime(Date ptrackTime) {
        this.ptrackTime = ptrackTime;
    }

    public String getPtrackStatus() {
        return ptrackStatus;
    }

    public void setPtrackStatus(String ptrackStatus) {
        this.ptrackStatus = ptrackStatus;
    }

    public String getPtrackRemark() {
        return ptrackRemark;
    }

    public void setPtrackRemark(String ptrackRemark) {
        this.ptrackRemark = ptrackRemark;
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
}
