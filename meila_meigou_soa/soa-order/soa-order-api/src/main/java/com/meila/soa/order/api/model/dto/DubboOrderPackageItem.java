package com.meila.soa.order.api.model.dto;

import java.math.BigDecimal;

import com.meila.dubbo.base.model.BasicSeriModel;


@SuppressWarnings("serial")
public class DubboOrderPackageItem extends BasicSeriModel{
    
    /**
     * SKU 规格
     */
    private String skuStr;
    
    /**
     * 商品售价
     */
    private BigDecimal skuPrice;
    
    /**
     * 商品优惠
     */
    private BigDecimal skuDiscountFee;
    
    /**
     * 退款标志
     */
    private Integer refundFlag;
    
    private Long packageItemId;// 包裹商品id

    private Long orderItemId; // 订单商品id vldm_order_item.id

    private Long productId;// 商品ID

    private String productName;// 商品名称

    private String productImg;// 商品图片

    private Long skuId; // sku的id

    private Integer amount;// 购买数量

    private String itemRemark;// 备注
    
    private BigDecimal logisticsFee = BigDecimal.ZERO;//运费

    public String getSkuStr() {
        return skuStr;
    }

    public void setSkuStr(String skuStr) {
        this.skuStr = skuStr;
    }

    public BigDecimal getSkuPrice() {
        return skuPrice;
    }

    public void setSkuPrice(BigDecimal skuPrice) {
        this.skuPrice = skuPrice;
    }

    public BigDecimal getSkuDiscountFee() {
        return skuDiscountFee;
    }

    public void setSkuDiscountFee(BigDecimal skuDiscountFee) {
        this.skuDiscountFee = skuDiscountFee;
    }

    public Integer getRefundFlag() {
        return refundFlag;
    }

    public void setRefundFlag(Integer refundFlag) {
        this.refundFlag = refundFlag;
    }

    public Long getPackageItemId() {
        return packageItemId;
    }

    public void setPackageItemId(Long packageItemId) {
        this.packageItemId = packageItemId;
    }

    public Long getOrderItemId() {
        return orderItemId;
    }

    public void setOrderItemId(Long orderItemId) {
        this.orderItemId = orderItemId;
    }

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getProductImg() {
        return productImg;
    }

    public void setProductImg(String productImg) {
        this.productImg = productImg;
    }

    public Long getSkuId() {
        return skuId;
    }

    public void setSkuId(Long skuId) {
        this.skuId = skuId;
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    public String getItemRemark() {
        return itemRemark;
    }

    public void setItemRemark(String itemRemark) {
        this.itemRemark = itemRemark;
    }

    public BigDecimal getLogisticsFee() {
        return logisticsFee;
    }

    public void setLogisticsFee(BigDecimal logisticsFee) {
        this.logisticsFee = logisticsFee;
    }
    
    
}
