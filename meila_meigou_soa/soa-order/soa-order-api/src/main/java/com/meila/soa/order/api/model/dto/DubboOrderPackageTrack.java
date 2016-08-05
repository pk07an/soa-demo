package com.meila.soa.order.api.model.dto;

import java.util.Date;

import com.meila.dubbo.base.model.BasicSeriModel;

@SuppressWarnings("serial")
public class DubboOrderPackageTrack extends BasicSeriModel {

    private String trackRemark; // 跟踪详情

    private Date operationTime; // 跟踪时间

    public String getTrackRemark() {
        return trackRemark;
    }

    public void setTrackRemark(String trackRemark) {
        this.trackRemark = trackRemark;
    }

    public Date getOperationTime() {
        return operationTime;
    }

    public void setOperationTime(Date operationTime) {
        this.operationTime = operationTime;
    }

}
