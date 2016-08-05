package com.meila.soa.product.api.model.dto.product.v1;

import java.math.BigDecimal;
import java.util.Date;

import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

import com.meila.dubbo.base.model.BasicSeriModel;

/**
 * ************************************************************
 * 
 * @类名 : DubboSkuBundleInfo.java
 *
 * @DESCRIPTION :组合SKU信息类
 * @AUTHOR : hawk
 * @DATE : 2016年3月8日
 ************************************************************
 */
public class DubboBundleInfoV1 extends BasicSeriModel {

    private static final long serialVersionUID = 1L;

    private Long bundleInfoId;

    /**
     * 套餐sku id
     */
    private Long bundleId;

    /**
     * 套餐SKU所包含的子sku id
     */
    private Long subSkuId;

    /**
     * 商品报关价格
     */
    @DecimalMin(value = "0.0", message = "报关价格不合法")
    private BigDecimal clearancePrice;

    /**
     * 套餐中的搭配数量
     */
    @NotNull(message = "数量不能为空")
    @Min(value = 1, message = "搭配的商品数量不合法")
    private Integer matchCount;

    // 子sku所属商品名称
    private String productName;

    /**
     * 逻辑删除 0.有效 1.删除
     */

    private Boolean archive;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 最后更新时间
     */
    private Date updateTime;

    private DubboSkuV1 subSku;

    public DubboSkuV1 getSubSku() {
        return subSku;
    }

    public void setSubSku(DubboSkuV1 subSku) {
        this.subSku = subSku;
    }

    public Long getBundleInfoId() {
        return bundleInfoId;
    }

    public void setBundleInfoId(Long bundleInfoId) {
        this.bundleInfoId = bundleInfoId;
    }

    public Long getBundleId() {
        return bundleId;
    }

    public void setBundleId(Long bundleId) {
        this.bundleId = bundleId;
    }

    public Long getSubSkuId() {
        return subSkuId;
    }

    public void setSubSkuId(Long subSkuId) {
        this.subSkuId = subSkuId;
    }

    public BigDecimal getClearancePrice() {
        return clearancePrice;
    }

    public void setClearancePrice(BigDecimal clearancePrice) {
        this.clearancePrice = clearancePrice;
    }

    public Integer getMatchCount() {
        return matchCount;
    }

    public void setMatchCount(Integer matchCount) {
        this.matchCount = matchCount;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
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

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }
}
