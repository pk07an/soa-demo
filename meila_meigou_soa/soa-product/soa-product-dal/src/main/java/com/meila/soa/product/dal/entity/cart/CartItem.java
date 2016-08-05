package com.meila.soa.product.dal.entity.cart;

import java.util.Date;

public class CartItem {

    private Long id;

    private Long userId;

    private Long skuId;

    private Long productId;

    private Long shopId;

    private Long sellerId;

    private Integer amount;

    private String status;

    private Boolean archive;

    private String domain; // xiangqu, kkkd

    private String source; // wap, web

    private long idRaw = -1;

    private Date createdAt;// 插入逻辑在mysql实现，只查询

    private Date updatedAt;// 更新逻辑在mysql实现，只查询

    private String fromSource;

    /**
     * @return the fromSource
     */
    public String getFromSource() {
        return fromSource;
    }

    /**
     * @param fromSource the fromSource to set
     */
    public void setFromSource(String fromSource) {
        this.fromSource = fromSource;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    long getIdRaw() {
        return idRaw;
    }

    void setIdRaw(long idRaw) {
        this.idRaw = idRaw;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
    }

    public Date getUpdatedAt() {
        return updatedAt;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    public Long getSkuId() {
        return skuId;
    }

    public void setSkuId(Long skuId) {
        this.skuId = skuId;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    public Boolean getArchive() {
        return archive;
    }

    public void setArchive(Boolean archive) {
        this.archive = archive;
    }

    public Long getShopId() {
        return shopId;
    }

    public void setShopId(Long shopId) {
        this.shopId = shopId;
    }

    public Long getSellerId() {
        return sellerId;
    }

    public void setSellerId(Long sellerId) {
        this.sellerId = sellerId;
    }

    public String getDomain() {
        return domain;
    }

    public void setDomain(String domain) {
        this.domain = domain;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }
}
