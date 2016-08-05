package com.meila.soa.product.api.model.request;

import java.util.List;

import javax.validation.Valid;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotEmpty;

import com.meila.dubbo.base.model.DubboBasicRequest;
import com.meila.soa.product.api.model.dto.DubboSkuBundle;

/**
 ************************************************************
 * @类名 : DubboAddToCartRequest.java
 *
 * @DESCRIPTION :添加购物车请求类
 * @AUTHOR : hawk
 * @DATE : 2016年1月26日
 ************************************************************
 */
public class DubboAddSkuBundleRequest extends DubboBasicRequest {
    private static final long serialVersionUID = 1L;

    /**
     * 用户id
     */
    @Min(value = 1, message = "商品ID不合法")
    @NotNull(message = "商品ID不能为空")
    private Long productId;

    @Valid
    @NotEmpty(message = "套餐列表不能为空")
    @NotNull(message = "套餐列表不能为空")
    private List<DubboSkuBundle> DubboSkuBundleList;

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    public List<DubboSkuBundle> getDubboSkuBundleList() {
        return DubboSkuBundleList;
    }

    public void setDubboSkuBundleList(List<DubboSkuBundle> dubboSkuBundleList) {
        DubboSkuBundleList = dubboSkuBundleList;
    }
}
