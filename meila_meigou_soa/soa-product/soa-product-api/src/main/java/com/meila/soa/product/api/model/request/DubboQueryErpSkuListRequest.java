package com.meila.soa.product.api.model.request;

import java.util.Date;

import javax.validation.constraints.Min;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import com.meila.dubbo.base.model.DubboBasicPageRequest;

/**
 * 
 ************************************************************
 * @类名 : DubboQueryErpSkuListRequest.java
 *
 * @DESCRIPTION :查询商品信息请求类
 * @AUTHOR : hawk
 * @DATE : 2016年1月14日
 ************************************************************
 */
public class DubboQueryErpSkuListRequest extends DubboBasicPageRequest {
    private static final long serialVersionUID = 1L;

    /**
     * 通过erpSkuId查找ErpSku列表,全匹配
     */
    @Size(max = 128, message = "erpSkuId太长")
    private String erpSkuId;

    /**
     * 通过erpSkuId查找ErpSku列表,全匹配
     */
    @Min(value = 0, message = "skuId不合法")
    private Long skuId;

    /**
     * 通过erpSkuCode查找ErpSku列表,全匹配
     */
    @Size(max = 128, message = "erpSkuCode太长")
    private String erpSkuCode;

    /**
     * 通过sku中文名称查找ErpSku列表,全匹配
     */
    @Size(max = 128, message = "skuNameCn太长")
    private String skuNameCn;

    /**
     * 通过sku英文名称查找ErpSku列表,前匹配
     */
    @Size(max = 128, message = "skuNameEn太长")
    private String skuNameEn;

    /**
     * 通过所属账套查询ErpSku列表,全匹配
     */
    @Size(max = 128, message = "belongAccount太长")
    private String belongAccount;

    /**
     * erp同步时间，匹配规则,erpSyncTime>erpSyncTimeBegin
     */
    private Date erpSyncTimeBegin;

    /**
     * erp同步时间，匹配规则,erpSyncTime<erpSyncTimeEnd
     */
    private Date erpSyncTimeEnd;

    /**
     * 根据同步到wmsStatus状态查询,匹配规则：全匹配，可选值"WAIT","SYNCED","SYNC_FAIL"
     */
    @Pattern(regexp = "[WAIT|SYNCED|SYNC_FAIL]", message = "wmsStatus错误")
    private String wmsStatus;

    /**
     * 根据sku条形码查询,匹配规则,前匹配
     */
    private String skuBarCode;

    /**
     * 根据采购地查询，匹配规则，前匹配
     */
    private String purchasePlace;

    /**
     * 根据产地查询，匹配规则，前查询
     */
    private String productionPlace;

    /**
     * 根据品牌中文名查询，匹配规则，前查询
     */
    private String brandNameCn;

    /**
     * 根据品牌英文名查询，匹配规则，前查询
     */
    private String brandNameEn;

    /**
     * 根据分类编码查询，匹配规则，全匹配
     */
    private String categoryCode;

    /**
     * 根据仓库查询，匹配规则，全匹配
     */
    private String warehouseCode;

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

    public Date getErpSyncTimeBegin() {
        return erpSyncTimeBegin;
    }

    public void setErpSyncTimeBegin(Date erpSyncTimeBegin) {
        this.erpSyncTimeBegin = erpSyncTimeBegin;
    }

    public Date getErpSyncTimeEnd() {
        return erpSyncTimeEnd;
    }

    public void setErpSyncTimeEnd(Date erpSyncTimeEnd) {
        this.erpSyncTimeEnd = erpSyncTimeEnd;
    }

    public String getWmsStatus() {
        return wmsStatus;
    }

    public void setWmsStatus(String wmsStatus) {
        this.wmsStatus = wmsStatus;
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

}
