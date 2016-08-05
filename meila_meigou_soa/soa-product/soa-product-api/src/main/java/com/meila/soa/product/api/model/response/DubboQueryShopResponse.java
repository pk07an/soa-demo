package com.meila.soa.product.api.model.response;

import java.util.List;

import com.meila.dubbo.base.model.DubboBasicPageResponse;
import com.meila.soa.product.api.model.dto.DubboShop;

/**
 * 
 ************************************************************
 * @类名 : DubboQueryShopResponse.java
 *
 * @DESCRIPTION :查询商品列表
 * @AUTHOR : hawk
 * @DATE : 2016年3月14日
 ************************************************************
 */
public class DubboQueryShopResponse extends DubboBasicPageResponse {
    private static final long serialVersionUID = 1L;

    /**
     * 店铺信息列表
     */
    private List<DubboShop> shopList;

    public List<DubboShop> getShopList() {
        return shopList;
    }

    public void setShopList(List<DubboShop> shopList) {
        this.shopList = shopList;
    }
}
