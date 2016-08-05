package com.meila.soa.proxy.dal.entity.OmsCustomSecretConfig;

import java.util.Date;

public class OmsCustomSecretConfigEntity {
    private Integer cusconfigId;

    private String customCode;

    private String customKey;

    private String customSecret;

    private String customStatus;

    private Date createTime;

    private Date updateTime;

    private Boolean archive;

    private Integer createUser;

    public Integer getCusconfigId() {
        return cusconfigId;
    }

    public void setCusconfigId(Integer cusconfigId) {
        this.cusconfigId = cusconfigId;
    }

    public String getCustomCode() {
        return customCode;
    }

    public void setCustomCode(String customCode) {
        this.customCode = customCode;
    }

    public String getCustomKey() {
        return customKey;
    }

    public void setCustomKey(String customKey) {
        this.customKey = customKey;
    }

    public String getCustomSecret() {
        return customSecret;
    }

    public void setCustomSecret(String customSecret) {
        this.customSecret = customSecret;
    }

    public String getCustomStatus() {
        return customStatus;
    }

    public void setCustomStatus(String customStatus) {
        this.customStatus = customStatus;
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

    public Boolean getArchive() {
        return archive;
    }

    public void setArchive(Boolean archive) {
        this.archive = archive;
    }

    public Integer getCreateUser() {
        return createUser;
    }

    public void setCreateUser(Integer createUser) {
        this.createUser = createUser;
    }
}