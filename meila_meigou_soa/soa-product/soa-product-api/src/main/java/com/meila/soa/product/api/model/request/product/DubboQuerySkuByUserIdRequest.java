package com.meila.soa.product.api.model.request.product;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import com.meila.dubbo.base.model.DubboBasicPageRequest;

public class DubboQuerySkuByUserIdRequest extends DubboBasicPageRequest {
    private static final long serialVersionUID = 1L;

    @NotNull(message = "店铺名称不能为空")
    private Long userId;

    private String productName;

    @Pattern(regexp = "SPU|NORMAL")
    private String skuType;

    @Pattern(regexp = "ERP|NORMAL")
    private String skuSource;

    public String getSkuSource() {
        return skuSource;
    }

    public void setSkuSource(String skuSource) {
        this.skuSource = skuSource;
    }

    public String getProductName() {
        return productName;
    }

    public String getSkuType() {
        return skuType;
    }

    public void setSkuType(String skuType) {
        this.skuType = skuType;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }
}
