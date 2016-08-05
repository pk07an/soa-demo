package com.meila.soa.product.api.model.request;

import com.meila.dubbo.base.model.DubboBasicPageRequest2;

/**
 * 
 ************************************************************
 * @类名 : DubboQuerySpuListRequest.java
 *
 * @DESCRIPTION : 分页查询商品SPU列表
 * @AUTHOR : hawk
 * @DATE : 2016年3月9日
 ************************************************************
 */
public class DubboQuerySkuListRequest extends DubboBasicPageRequest2 {
    private static final long serialVersionUID = 1L;

    /**
     * 商品ID spuId
     */
    private Long productId;

    /**
     * skuId
     */
    private Long skuId;

    /**
     * 店铺ID
     */
    private Long shopId;

    /**
     * 商品状态
     */
    private String status;

    /**
     * 是否店长推荐
     */
    private Boolean recommend;

    /**
     * 根据上架时间查询 onSaleAt >= onSaleAtBegin
     */
    private String onSaleAtBegin;

    /**
     * 根据上架时间查询 onSaleAt <= onSaleAtEnd
     */
    private String onSaleAtEnd;

    /**
     * 商品名称
     */
    private String productName;

    /**
     * 排序字段
     */
    private String orderField;
    /**
     * 排序方向
     */
    private String orderDirection;
    /**
     * sku类型
     */
    private String skuType;
    /**
     * null or 1:仅上架商品 0:所有商品 0
     */
    private Integer onlyOnSale;

    private String deliveryType;

    public String getDeliveryType() {
        return deliveryType;
    }

    public void setDeliveryType(String deliveryType) {
        this.deliveryType = deliveryType;
    }

    public String getOnSaleAtBegin() {
        return onSaleAtBegin;
    }

    public void setOnSaleAtBegin(String onSaleAtBegin) {
        this.onSaleAtBegin = onSaleAtBegin;
    }

    public String getOnSaleAtEnd() {
        return onSaleAtEnd;
    }

    public void setOnSaleAtEnd(String onSaleAtEnd) {
        this.onSaleAtEnd = onSaleAtEnd;
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

    public Long getShopId() {
        return shopId;
    }

    public void setShopId(Long shopId) {
        this.shopId = shopId;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Boolean getRecommend() {
        return recommend;
    }

    public void setRecommend(Boolean recommend) {
        this.recommend = recommend;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getOrderField() {
        return orderField;
    }

    public void setOrderField(String orderField) {
        this.orderField = orderField;
    }

    public String getOrderDirection() {
        return orderDirection;
    }

    public void setOrderDirection(String orderDirection) {
        this.orderDirection = orderDirection;
    }

    public String getSkuType() {
        return skuType;
    }

    public void setSkuType(String skuType) {
        this.skuType = skuType;
    }

    public Integer getOnlyOnSale() {
        return onlyOnSale;
    }

    public void setOnlyOnSale(Integer onlyOnSale) {
        this.onlyOnSale = onlyOnSale;
    }
}
