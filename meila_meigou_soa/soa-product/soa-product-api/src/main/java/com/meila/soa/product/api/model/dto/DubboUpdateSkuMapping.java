package com.meila.soa.product.api.model.dto;

import javax.validation.constraints.Min;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Range;

import com.meila.dubbo.base.model.BasicSeriModel;

/**
 * 
 ************************************************************
 * @类名 : SkuMappingForm.java
 *
 * @DESCRIPTION :
 * @AUTHOR : hawk
 * @DATE : 2016年5月31日
 ************************************************************
 */
public class DubboUpdateSkuMapping extends BasicSeriModel {
    private static final long serialVersionUID = 1L;

    @Min(value = 0, message = "商品ID不合法")
    private Long productId;

    @Size(min = 0, max = 100, message = "sku规格key长度为0-100")
    private String specKey;

    @Size(min = 0, max = 100, message = "sku规格名key长度为0-100")
    private String specName;

    @Range(min = 1, max = 5, message = "顺序值不合法")
    private Integer specOrder;

    public Integer getSpecOrder() {
        return specOrder;
    }

    public void setSpecOrder(Integer specOrder) {
        this.specOrder = specOrder;
    }

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    public String getSpecKey() {
        return specKey;
    }

    public void setSpecKey(String specKey) {
        this.specKey = specKey;
    }

    public String getSpecName() {
        return specName;
    }

    public void setSpecName(String specName) {
        this.specName = specName;
    }
}
