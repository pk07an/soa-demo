package com.meila.soa.proxy.dal.entity.ErpResponseLog;

import java.util.Date;

public class ErpResponseLogEntity {
    private Long erpRespId;

    private Long erpReqId;

    private String erpReqType;

    private String erpRespRemark;

    private Date createTime;

    private Date updateTime;

    private Byte archive;

    private String erpRespDetail;

    public Long getErpRespId() {
        return erpRespId;
    }

    public void setErpRespId(Long erpRespId) {
        this.erpRespId = erpRespId;
    }

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

    public String getErpRespRemark() {
        return erpRespRemark;
    }

    public void setErpRespRemark(String erpRespRemark) {
        this.erpRespRemark = erpRespRemark;
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

    public String getErpRespDetail() {
        return erpRespDetail;
    }

    public void setErpRespDetail(String erpRespDetail) {
        this.erpRespDetail = erpRespDetail;
    }
}