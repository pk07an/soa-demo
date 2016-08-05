package com.meila.soa.product.api.model.dto;

import java.math.BigDecimal;

import javax.validation.constraints.Digits;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.NotEmpty;
import org.hibernate.validator.constraints.Range;

import com.meila.dubbo.base.model.BasicSeriModel;

/**
 ************************************************************
 * @类名 SkuForm
 * 
 * @DESCRIPTION sku表单类
 * @AUTHOR Neo
 * @DATE 2016年1月24日
 ************************************************************
 */
public class DubboUpdateSku extends BasicSeriModel {
    private static final long serialVersionUID = 1L;

    @Min(value = 1, message = "skuId不合法")
    private Long skuId;

    @Size(min = 0, max = 100, message = "sku规格1不能长度超过100")
    @NotBlank(message = "spec1信息不能为空")
    private String spec1;

    @Size(min = 0, max = 100, message = "sku规格2不能长度超过100")
    private String spec2;

    @Size(min = 0, max = 100, message = "sku规格3不能长度超过100")
    private String spec3;

    @Size(min = 0, max = 100, message = "sku规格4不能长度超过100")
    private String spec4;

    @Size(min = 0, max = 100, message = "sku规格5不能长度超过100")
    private String spec5;

    @NotNull(message = "sku价格不能为空")
    @Digits(integer = 10, fraction = 2, message = "sku价格长度为十位，小数点为两位")
    private BigDecimal price;

    @NotNull(message = "sku库存不能为空")
    @Range(min = 0, max = 99999999, message = "sku库存的范围为0-99999999")
    private Integer amount;

    @NotEmpty(message = "是否显示不能为空")
    @Pattern(regexp = "SHOW|HIDE", message = "是否显示字段格式不合法")
    private String isDisplay;

    /** ERP中定义的SKU_ID */
    private String erpSkuId;

    /** Erp 中的仓库Code */
    private String warehouseCode;

    /** Erp 中的仓库名称 */
    private String warehouseName;

    private String skuMainImg;

    private Integer imgWidth;

    private Integer imgHeight;

    /**
     * 商家自己填写的商品编码
     */
    private String outsideSkuCode;

    public String getOutsideSkuCode() {
        return outsideSkuCode;
    }

    public void setOutsideSkuCode(String outsideSkuCode) {
        this.outsideSkuCode = outsideSkuCode;
    }

    public Long getSkuId() {
        return skuId;
    }

    public void setSkuId(Long skuId) {
        this.skuId = skuId;
    }

    public String getSpec1() {
        return spec1;
    }

    public void setSpec1(String spec1) {
        this.spec1 = spec1;
    }

    public String getSpec2() {
        return spec2;
    }

    public void setSpec2(String spec2) {
        this.spec2 = spec2;
    }

    public String getSpec3() {
        return spec3;
    }

    public void setSpec3(String spec3) {
        this.spec3 = spec3;
    }

    public String getSpec4() {
        return spec4;
    }

    public void setSpec4(String spec4) {
        this.spec4 = spec4;
    }

    public String getSpec5() {
        return spec5;
    }

    public void setSpec5(String spec5) {
        this.spec5 = spec5;
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

    public String getErpSkuId() {
        return erpSkuId;
    }

    public void setErpSkuId(String erpSkuId) {
        this.erpSkuId = erpSkuId;
    }

    public String getWarehouseCode() {
        return warehouseCode;
    }

    public void setWarehouseCode(String warehouseCode) {
        this.warehouseCode = warehouseCode;
    }

    public String getWarehouseName() {
        return warehouseName;
    }

    public void setWarehouseName(String warehouseName) {
        this.warehouseName = warehouseName;
    }

    public String getSkuMainImg() {
        return skuMainImg;
    }

    public void setSkuMainImg(String skuMainImg) {
        this.skuMainImg = skuMainImg;
    }

    public Integer getImgWidth() {
        return imgWidth;
    }

    public void setImgWidth(Integer imgWidth) {
        this.imgWidth = imgWidth;
    }

    public Integer getImgHeight() {
        return imgHeight;
    }

    public void setImgHeight(Integer imgHeight) {
        this.imgHeight = imgHeight;
    }
}
