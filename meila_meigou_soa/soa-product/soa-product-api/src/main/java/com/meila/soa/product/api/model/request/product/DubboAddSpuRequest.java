package com.meila.soa.product.api.model.request.product;

import java.math.BigDecimal;
import java.util.List;

import javax.validation.constraints.Digits;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.NotEmpty;

import com.meila.dubbo.base.model.DubboBasicRequest;
import com.meila.soa.product.api.model.dto.product.v1.DubboProductImg;

/**
 * 
 ************************************************************
 * @类名 : DubboAddSpuRequest.java
 *
 * @DESCRIPTION :
 * @AUTHOR : hawk
 * @DATE : 2016年3月25日
 ************************************************************
 */
public class DubboAddSpuRequest extends DubboBasicRequest {
    private static final long serialVersionUID = 1L;

    private Long userId;

    /** 商品状态 */
    private String productStatus;

    /** 商品名称 */
    @Size(min = 0, max = 60, message = "商品名称长度为0-60个字符")
    private String productName;

    /** 短名称 */
    private String shortName;

    /** 描述 */
    @NotBlank(message = "商品描述不能为空")
    private String productDesc;

    /** 短描述 */
    private String shortIntro;

    /** 商品价格 */
    @Digits(integer = 10, fraction = 2, message = "商品价格长度为十位，小数点为两位")
    private BigDecimal price;

    /** 商品原价 */
    @Digits(integer = 10, fraction = 2, message = "商品原价长度为十位，小数点为两位")
    private BigDecimal marketPrice;

    /** 商品库存 */
    private Integer amount;

    /** 采购地 */
    @NotNull(message = "采购地不能为空")
    private String purchaseSource;

    /** 计划发布时间 */
    private Long forsaleDate;

    /** 商品类别字段 （可以不填） */
    private String category;

    /** 是否延迟发货 （可以不填，默认为0） */
    private Boolean isDelay = false;

    /** 延迟发货时间（天） （delayed = 0的时候才有效） */
    private Integer delayDays = 0;

    /** 邮费 */
    private BigDecimal postage;

    /** 发货方式 */
    @NotNull(message = "发货方式不能为空")
    private String deliveryType;

    /** 发货仓库 */
    private String warehouse;

    /** 图片地址 */
    @NotNull(message = "图片地址不能为空")
    @NotEmpty(message = "图片地址不能为空")
    private List<DubboProductImg> productImgList;

    @NotBlank(message = "商品类型不能为空")
    @Pattern(regexp = "NORMAL|ERP", message = "商品类型不合法")
    private String productType;

    public String getProductType() {
        return productType;
    }

    public void setProductType(String productType) {
        this.productType = productType;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getProductStatus() {
        return productStatus;
    }

    public void setProductStatus(String productStatus) {
        this.productStatus = productStatus;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getShortName() {
        return shortName;
    }

    public void setShortName(String shortName) {
        this.shortName = shortName;
    }

    public String getProductDesc() {
        return productDesc;
    }

    public void setProductDesc(String productDesc) {
        this.productDesc = productDesc;
    }

    public String getShortIntro() {
        return shortIntro;
    }

    public void setShortIntro(String shortIntro) {
        this.shortIntro = shortIntro;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public BigDecimal getMarketPrice() {
        return marketPrice;
    }

    public void setMarketPrice(BigDecimal marketPrice) {
        this.marketPrice = marketPrice;
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    public String getPurchaseSource() {
        return purchaseSource;
    }

    public void setPurchaseSource(String purchaseSource) {
        this.purchaseSource = purchaseSource;
    }

    public Long getForsaleDate() {
        return forsaleDate;
    }

    public void setForsaleDate(Long forsaleDate) {
        this.forsaleDate = forsaleDate;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public Boolean getIsDelay() {
        return isDelay;
    }

    public void setIsDelay(Boolean isDelay) {
        this.isDelay = isDelay;
    }

    public Integer getDelayDays() {
        return delayDays;
    }

    public void setDelayDays(Integer delayDays) {
        this.delayDays = delayDays;
    }

    public BigDecimal getPostage() {
        return postage;
    }

    public void setPostage(BigDecimal postage) {
        this.postage = postage;
    }

    public String getDeliveryType() {
        return deliveryType;
    }

    public void setDeliveryType(String deliveryType) {
        this.deliveryType = deliveryType;
    }

    public String getWarehouse() {
        return warehouse;
    }

    public void setWarehouse(String warehouse) {
        this.warehouse = warehouse;
    }

    public List<DubboProductImg> getProductImgList() {
        return productImgList;
    }

    public void setProductImgList(List<DubboProductImg> productImgList) {
        this.productImgList = productImgList;
    }
}
