package com.meila.soa.product.api.model.request;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

import com.meila.dubbo.base.model.DubboBasicRequest;

/**
 * 
 ************************************************************
 * @类名 : DubboAddShopRequest.java
 *
 * @DESCRIPTION :添加店铺信息
 * @AUTHOR : hawk
 * @DATE : 2016年3月16日
 ************************************************************
 */
public class DubboAddShopRequest extends DubboBasicRequest {
    private static final long serialVersionUID = 1L;

    @Min(value = 1, message = "用户ID不合法")
    private String extUserId;

    @NotNull(message = "来源不合法")
    private String sellerSource;

    public String getExtUserId() {
        return extUserId;
    }

    public void setExtUserId(String extUserId) {
        this.extUserId = extUserId;
    }

    public String getSellerSource() {
        return sellerSource;
    }

    public void setSellerSource(String sellerSource) {
        this.sellerSource = sellerSource;
    }
}
