package com.meila.soa.product.dal.entity.product;

import java.util.Date;

/**
 * 商品信息修改记录 reese 2015/7/15
 */
public class ProductUpdateLog {

    private long id;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    private int type;
    private String preUpdate;
    private String afterUpdate;
    private Long opUserId;
    private Date updateAt;
    private SystemEnum system; // 更新数据的系统
    private Long productId; // 被更新的商品id

    public ProductUpdateLog() {

    }

    public ProductUpdateLog(int type, String preUpdate, String afterUpdate, Long opUserId, SystemEnum system, Long productId) {
        this.type = type;
        this.preUpdate = preUpdate;
        this.afterUpdate = afterUpdate;
        this.opUserId = opUserId;
        this.updateAt = new Date();
        this.system = system;
        this.productId = productId;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public String getPreUpdate() {
        return preUpdate;
    }

    public void setPreUpdate(String preUpdate) {
        this.preUpdate = preUpdate == null ? null : preUpdate.trim();
    }

    public String getAfterUpdate() {
        return afterUpdate;
    }

    public void setAfterUpdate(String afterUpdate) {
        this.afterUpdate = afterUpdate == null ? null : afterUpdate.trim();
    }

    public Long getOpUserId() {
        return opUserId;
    }

    public void setOpUserId(Long opUserId) {
        this.opUserId = opUserId;
    }

    public Date getUpdateAt() {
        return updateAt;
    }

    public void setUpdateAt(Date updateAt) {
        this.updateAt = updateAt;
    }

    public SystemEnum getSystem() {
        return system;
    }

    public void setSystem(SystemEnum system) {
        this.system = system;
    }

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    public enum SystemEnum {
        BOS, SELLERPC
    }
}
