package com.meila.soa.product.api.model.dto.product.v1;

import java.math.BigDecimal;
import java.util.List;

import com.meila.dubbo.base.model.BasicSeriModel;

/**
 * 
 ************************************************************
 * @类名 : DubboSkuBundle.java
 *
 * @DESCRIPTION : 组合SKU
 * @AUTHOR : hawk
 * @DATE : 2016年3月8日
 ************************************************************
 */
public class DubboBundleV1 extends BasicSeriModel {
    private static final long serialVersionUID = 1L;
    /**
     * 套餐商品skuId 对应skuId字段
     */
    private Long bundleId;

    /**
     * 套餐名称 对应spec1字段
     */
    private String bundleName;

    /**
     * 售价
     */

    private BigDecimal price;

    /**
     * 库存
     */
    private Integer amount;

    /**
     * 是否显示或隐藏 使用字符串表示 SHOW HIDE
     */
    private String isDisplay;

    /**
     * 套餐商品集合
     */

    List<DubboBundleInfoV1> bundleInfoList;

    public Long getBundleId() {
        return bundleId;
    }

    public void setBundleId(Long bundleId) {
        this.bundleId = bundleId;
    }

    public String getBundleName() {
        return bundleName;
    }

    public void setBundleName(String bundleName) {
        this.bundleName = bundleName;
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

    public List<DubboBundleInfoV1> getBundleInfoList() {
        return bundleInfoList;
    }

    public void setBundleInfoList(List<DubboBundleInfoV1> bundleInfoList) {
        this.bundleInfoList = bundleInfoList;
    }
}
