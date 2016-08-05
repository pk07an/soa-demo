package com.meila.soa.product.api.model.dto;

import java.math.BigDecimal;
import java.util.List;

import javax.validation.Valid;
import javax.validation.constraints.Digits;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;

import com.meila.dubbo.base.model.BasicSeriModel;

/**
 * 
 ************************************************************
 * @类名 : DubboSkuBundle.java
 *
 * @DESCRIPTION : sku套餐
 * @AUTHOR : hawk
 * @DATE : 2016年3月8日
 ************************************************************
 */
public class DubboSkuBundle extends BasicSeriModel {
    private static final long serialVersionUID = 1L;
    /**
     * 套餐商品skuId 对应skuId字段
     */
    private Long skuBundleId;

    /**
     * 套餐名称 对应spec1字段
     */
    @Size(min = 1, max = 128)
    private String skuBundleName;

    /**
     * 售价
     */
    @Digits(fraction = 2, integer = 10, message = "价格位数不合法")
    private BigDecimal price;

    /**
     * 库存
     */
    @Min(value = 0, message = "库存数量不合法")
    private Integer amount;

    /**
     * 是否显示或隐藏 使用字符串表示 SHOW HIDE
     */
    @Pattern(regexp = "SHOW|HIDE")
    private String isDisplay;

    /**
     * 套餐商品集合
     */
    @Valid
    @NotEmpty(message = "sku不能为空")
    @NotNull(message = "sku不能为空")
    private List<DubboSkuBundleInfo> skuBundleInfoList;

    public Long getSkuBundleId() {
        return skuBundleId;
    }

    public void setSkuBundleId(Long skuBundleId) {
        this.skuBundleId = skuBundleId;
    }

    public String getSkuBundleName() {
        return skuBundleName;
    }

    public void setSkuBundleName(String skuBundleName) {
        this.skuBundleName = skuBundleName;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    public String getIsDisplay() {
        return isDisplay;
    }

    public void setIsDisplay(String isDisplay) {
        this.isDisplay = isDisplay;
    }

    public List<DubboSkuBundleInfo> getSkuBundleInfoList() {
        return skuBundleInfoList;
    }

    public void setSkuBundleInfoList(List<DubboSkuBundleInfo> skuBundleInfoList) {
        this.skuBundleInfoList = skuBundleInfoList;
    }
}
