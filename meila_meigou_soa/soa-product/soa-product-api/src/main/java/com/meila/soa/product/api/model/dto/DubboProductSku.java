package com.meila.soa.product.api.model.dto;

import java.math.BigDecimal;
import java.util.Date;

import com.meila.dubbo.base.model.BasicSeriModel;

/**
 * 
 ************************************************************
 * @类名 : DubboProductSku.java
 *
 * @DESCRIPTION :Erp SKU，用作dubbo调用中
 * @AUTHOR : hawk
 * @DATE : 2016年1月15日
 ************************************************************
 */
public class DubboProductSku extends BasicSeriModel {
    private static final long serialVersionUID = 1L;

    private Long prdSkuId;

    private String erpSkuId;

    private Long skuId;

    private String erpSkuCode;

    private String skuNameCn;

    private String skuNameEn;

    private String belongAccount;

    private String skuStr;

    private Date erpSyncTime;

    private String wmsStatus;

    private BigDecimal salePrice;

    private String skuBarCode;

    private String purchasePlace;

    private String productionPlace;

    private String brandNameCn;

    private String brandNameEn;

    private String spec1Name;

    private String spec1Value;

    private String spec2Name;

    private String spec2Value;

    private String spec3Name;

    private String spec3Value;

    private String spec4Name;

    private String spec4Value;

    private String spec5Name;

    private String spec5Value;

    private String categoryCode;

    private String warehouseCode;

    private String warehouseName;

    private Date wmsSyncTime;

    private String wmsRemark;

    private Integer archive;

    private String unitName;

    public Long getPrdSkuId() {
        return prdSkuId;
    }

    public void setPrdSkuId(Long prdSkuId) {
        this.prdSkuId = prdSkuId;
    }

    public String getErpSkuId() {
        return erpSkuId;
    }

    public void setErpSkuId(String erpSkuId) {
        this.erpSkuId = erpSkuId;
    }

    public Long getSkuId() {
        return skuId;
    }

    public void setSkuId(Long skuId) {
        this.skuId = skuId;
    }

    public String getErpSkuCode() {
        return erpSkuCode;
    }

    public void setErpSkuCode(String erpSkuCode) {
        this.erpSkuCode = erpSkuCode;
    }

    public String getSkuNameCn() {
        return skuNameCn;
    }

    public void setSkuNameCn(String skuNameCn) {
        this.skuNameCn = skuNameCn;
    }

    public String getSkuNameEn() {
        return skuNameEn;
    }

    public void setSkuNameEn(String skuNameEn) {
        this.skuNameEn = skuNameEn;
    }

    public String getBelongAccount() {
        return belongAccount;
    }

    public void setBelongAccount(String belongAccount) {
        this.belongAccount = belongAccount;
    }

    public String getSkuStr() {
        return skuStr;
    }

    public void setSkuStr(String skuStr) {
        this.skuStr = skuStr;
    }

    public Date getErpSyncTime() {
        return erpSyncTime;
    }

    public void setErpSyncTime(Date erpSyncTime) {
        this.erpSyncTime = erpSyncTime;
    }

    public String getWmsStatus() {
        return wmsStatus;
    }

    public void setWmsStatus(String wmsStatus) {
        this.wmsStatus = wmsStatus;
    }

    public BigDecimal getSalePrice() {
        return salePrice;
    }

    public void setSalePrice(BigDecimal salePrice) {
        this.salePrice = salePrice;
    }

    public String getSkuBarCode() {
        return skuBarCode;
    }

    public void setSkuBarCode(String skuBarCode) {
        this.skuBarCode = skuBarCode;
    }

    public String getPurchasePlace() {
        return purchasePlace;
    }

    public void setPurchasePlace(String purchasePlace) {
        this.purchasePlace = purchasePlace;
    }

    public String getProductionPlace() {
        return productionPlace;
    }

    public void setProductionPlace(String productionPlace) {
        this.productionPlace = productionPlace;
    }

    public String getBrandNameCn() {
        return brandNameCn;
    }

    public void setBrandNameCn(String brandNameCn) {
        this.brandNameCn = brandNameCn;
    }

    public String getBrandNameEn() {
        return brandNameEn;
    }

    public void setBrandNameEn(String brandNameEn) {
        this.brandNameEn = brandNameEn;
    }

    public String getSpec1Name() {
        return spec1Name;
    }

    public void setSpec1Name(String spec1Name) {
        this.spec1Name = spec1Name;
    }

    public String getSpec1Value() {
        return spec1Value;
    }

    public void setSpec1Value(String spec1Value) {
        this.spec1Value = spec1Value;
    }

    public String getSpec2Name() {
        return spec2Name;
    }

    public void setSpec2Name(String spec2Name) {
        this.spec2Name = spec2Name;
    }

    public String getSpec2Value() {
        return spec2Value;
    }

    public void setSpec2Value(String spec2Value) {
        this.spec2Value = spec2Value;
    }

    public String getSpec3Name() {
        return spec3Name;
    }

    public void setSpec3Name(String spec3Name) {
        this.spec3Name = spec3Name;
    }

    public String getSpec3Value() {
        return spec3Value;
    }

    public void setSpec3Value(String spec3Value) {
        this.spec3Value = spec3Value;
    }

    public String getSpec4Name() {
        return spec4Name;
    }

    public void setSpec4Name(String spec4Name) {
        this.spec4Name = spec4Name;
    }

    public String getSpec4Value() {
        return spec4Value;
    }

    public void setSpec4Value(String spec4Value) {
        this.spec4Value = spec4Value;
    }

    public String getSpec5Name() {
        return spec5Name;
    }

    public void setSpec5Name(String spec5Name) {
        this.spec5Name = spec5Name;
    }

    public String getSpec5Value() {
        return spec5Value;
    }

    public void setSpec5Value(String spec5Value) {
        this.spec5Value = spec5Value;
    }

    public String getCategoryCode() {
        return categoryCode;
    }

    public void setCategoryCode(String categoryCode) {
        this.categoryCode = categoryCode;
    }

    public String getWarehouseCode() {
        return warehouseCode;
    }

    public void setWarehouseCode(String warehouseCode) {
        this.warehouseCode = warehouseCode;
    }

    public Date getWmsSyncTime() {
        return wmsSyncTime;
    }

    public void setWmsSyncTime(Date wmsSyncTime) {
        this.wmsSyncTime = wmsSyncTime;
    }

    public String getWmsRemark() {
        return wmsRemark;
    }

    public void setWmsRemark(String wmsRemark) {
        this.wmsRemark = wmsRemark;
    }

    public Integer getArchive() {
        return archive;
    }

    public void setArchive(Integer archive) {
        this.archive = archive;
    }

    public String getUnitName() {
        return unitName;
    }

    public void setUnitName(String unitName) {
        this.unitName = unitName;
    }

    /**
     * @return the warehouseName
     */
    public String getWarehouseName() {
        return warehouseName;
    }

    /**
     * @param warehouseName the warehouseName to set
     */
    public void setWarehouseName(String warehouseName) {
        this.warehouseName = warehouseName;
    }
}
