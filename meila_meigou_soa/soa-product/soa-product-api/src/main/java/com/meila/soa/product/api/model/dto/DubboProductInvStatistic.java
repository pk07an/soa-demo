package com.meila.soa.product.api.model.dto;

import java.util.Date;

import com.meila.dubbo.base.model.BasicSeriModel;

public class DubboProductInvStatistic extends BasicSeriModel {
    /**
     * 
     */
    private static final long serialVersionUID = 1L;

    /**
     * 卖家ID
     */
    private Long sellerId;

    /**
     * sku ID
     */
    private Long skuId;

    /**
     * 商品名称
     */
    private String productName;

    /**
     * 商品主图
     */
    private String productMainImg;

    /**
     * 商品规格
     */
    private String skuSpec;

    private String storageType;

    public String getStorageType() {
        return storageType;
    }

    public void setStorageType(String storageType) {
        this.storageType = storageType;
    }

    /**
     * 订单数量
     */
    private Integer orderNum;

    /**
     * wms实际库存数量
     */
    private Integer inventory;

    /**
     * 库存短缺数量
     */
    private Integer invShortage;

    /**
     * 逻辑删除
     */
    private Boolean archive;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 更新时间
     */
    private Date updateTime;

    public Long getSellerId() {
        return sellerId;
    }

    public void setSellerId(Long sellerId) {
        this.sellerId = sellerId;
    }

    /**
     * @return the skuId
     */
    public Long getSkuId() {
        return skuId;
    }

    /**
     * @param skuId the skuId to set
     */
    public void setSkuId(Long skuId) {
        this.skuId = skuId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getProductMainImg() {
        return productMainImg;
    }

    public void setProductMainImg(String productMainImg) {
        this.productMainImg = productMainImg;
    }

    public String getSkuSpec() {
        return skuSpec;
    }

    public void setSkuSpec(String skuSpec) {
        this.skuSpec = skuSpec;
    }

    public Integer getOrderNum() {
        return orderNum;
    }

    public void setOrderNum(Integer orderNum) {
        this.orderNum = orderNum;
    }

    public Integer getInventory() {
        return inventory;
    }

    public void setInventory(Integer inventory) {
        this.inventory = inventory;
    }

    public Integer getInvShortage() {
        return invShortage;
    }

    public void setInvShortage(Integer invShortage) {
        this.invShortage = invShortage;
    }

    public Boolean getArchive() {
        return archive;
    }

    public void setArchive(Boolean archive) {
        this.archive = archive;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createtime) {
        this.createTime = createtime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updatetime) {
        this.updateTime = updatetime;
    }
}
