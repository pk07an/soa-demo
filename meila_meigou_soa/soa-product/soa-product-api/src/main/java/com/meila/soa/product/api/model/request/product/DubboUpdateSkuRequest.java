package com.meila.soa.product.api.model.request.product;

import java.util.List;

import javax.validation.Valid;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;

import com.meila.dubbo.base.model.DubboBasicRequest;
import com.meila.soa.product.api.model.dto.DubboUpdateSku;
import com.meila.soa.product.api.model.dto.DubboUpdateSkuMapping;

/**
 * 
 ************************************************************
 * @类名 : DubboAddSkuRequest.java
 *
 * @DESCRIPTION : 添加SKU接口请求类
 * @AUTHOR : hawk
 * @DATE : 2016年4月1日
 ************************************************************
 */
public class DubboUpdateSkuRequest extends DubboBasicRequest {
    private static final long serialVersionUID = 1L;

    /**
     * 用户ID
     */
    @Min(value = 1, message = "用户ID不合法")
    @NotNull(message = "用户ID不能为空")
    private Long userId;

    /** 商品ID */
    @Min(value = 1, message = "商品ID不合法")
    @NotNull(message = "商品ID不能为空")
    private Long productId;

    @Valid
    @NotNull(message = "sku不能为空")
    @NotEmpty(message = "sku不能为空")
    private List<DubboUpdateSku> skuList;

    @Valid
    @NotNull(message = "skuMapping规格不能为空")
    @Size(max = 5, message = "skuMapping规格数量过多")
    private List<DubboUpdateSkuMapping> skuMappingList;

    /** 套餐标识符，值为套餐数量 */
    private Integer skuBundleNum;

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    public List<DubboUpdateSku> getSkuList() {
        return skuList;
    }

    public void setSkuList(List<DubboUpdateSku> skuList) {
        this.skuList = skuList;
    }

    public List<DubboUpdateSkuMapping> getSkuMappingList() {
        return skuMappingList;
    }

    public void setSkuMappingList(List<DubboUpdateSkuMapping> skuMappingList) {
        this.skuMappingList = skuMappingList;
    }

    public Integer getSkuBundleNum() {
        return skuBundleNum;
    }

    public void setSkuBundleNum(Integer skuBundleNum) {
        this.skuBundleNum = skuBundleNum;
    }
}
