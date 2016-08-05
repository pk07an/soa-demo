package com.meila.soa.proxy.dal.entity.ErpRequestLog;

import java.util.Date;

public class ErpRequestLogEntity {
    private Long erpReqId;

    private String erpReqType;

    private String erpReqRemark;

    private Date createTime;

    private Date updateTime;

    private Byte archive;

    private String erpReqDetail;

    public Long getErpReqId() {
        return erpReqId;
    }

    public void setErpReqId(Long erpReqId) {
        this.erpReqId = erpReqId;
    }

    public String getErpReqType() {
        return erpReqType;
    }

    public void setErpReqType(String erpReqType) {
        this.erpReqType = erpReqType;
    }

    public String getErpReqRemark() {
        return erpReqRemark;
    }

    public void setErpReqRemark(String erpReqRemark) {
        this.erpReqRemark = erpReqRemark;
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

    public Byte getArchive() {
        return archive;
    }

    public void setArchive(Byte archive) {
        this.archive = archive;
    }

    public String getErpReqDetail() {
        return erpReqDetail;
    }

    public void setErpReqDetail(String erpReqDetail) {
        this.erpReqDetail = erpReqDetail;
    }
}