package com.meila.soa.product.api.model.request;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

import com.meila.dubbo.base.model.DubboBasicPageRequest2;

/**
 * 
 ************************************************************
 * @类名 : DubboAddFragmentRequest.java
 *
 * @DESCRIPTION :添加片段信息
 * @AUTHOR : hawk
 * @DATE : 2016年4月1日
 ************************************************************
 */
public class DubboListProductOfShopRequest extends DubboBasicPageRequest2 {
    private static final long serialVersionUID = 1L;

    @NotNull(message = "店铺ID不能为空")
    @Min(value = 1, message = "店铺ID不合法")
    private Long shopId;

    public Long getShopId() {
        return shopId;
    }

    public void setShopId(Long shopId) {
        this.shopId = shopId;
    }
}
