package com.meila.soa.product.api.model.request;

import java.util.List;

import javax.validation.constraints.NotNull;

import com.meila.dubbo.base.model.DubboBasicRequest;

/**
 * 
 ************************************************************
 * @类名 : DubboAddProductFragmentInfoRequest.java
 *
 * @DESCRIPTION :添加商品对应的片段信息
 * @AUTHOR : hawk
 * @DATE : 2016年4月1日
 ************************************************************
 */
public class DubboAddProductFragmentInfoRequest extends DubboBasicRequest {
    private static final long serialVersionUID = 1L;

    @NotNull(message = "shopId不能为空")
    private Long shopId;

    @NotNull(message = "productId不能为空")
    private Long productId;

    private List<Long> fragmentIdList;

    public Long getShopId() {
        return shopId;
    }

    public void setShopId(Long shopId) {
        this.shopId = shopId;
    }

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    public List<Long> getFragmentIdList() {
        return fragmentIdList;
    }

    public void setFragmentIdList(List<Long> fragmentIdList) {
        this.fragmentIdList = fragmentIdList;
    }
}
