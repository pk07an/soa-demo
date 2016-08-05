package com.meila.soa.product.api.model.request;

import com.meila.dubbo.base.model.DubboBasicRequest;

/**
 * 
 ************************************************************
 * @类名 : DubboQueryShopRequest.java
 *
 * @DESCRIPTION :查询店铺信息
 * @AUTHOR : hawk
 * @DATE : 2016年3月16日
 ************************************************************
 */
public class DubboQueryShopRequest extends DubboBasicRequest {
    private static final long serialVersionUID = 1L;

    /**
     * 店铺ID
     */
    private Long shopId;

    /**
     * 用户ID
     */
    private Long ownerId;

    /**
     * 店铺名称
     */
    private String shopName;

    public Long getShopId() {
        return shopId;
    }

    public void setShopId(Long shopId) {
        this.shopId = shopId;
    }

    public Long getOwnerId() {
        return ownerId;
    }

    public void setOwnerId(Long ownerId) {
        this.ownerId = ownerId;
    }

    public String getShopName() {
        return shopName;
    }

    public void setShopName(String shopName) {
        this.shopName = shopName;
    }

}
