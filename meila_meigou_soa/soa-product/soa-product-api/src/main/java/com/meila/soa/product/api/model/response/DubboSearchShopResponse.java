package com.meila.soa.product.api.model.response;

import java.util.List;

import com.meila.dubbo.base.model.DubboBasicPageResponse;
import com.meila.soa.product.api.model.dto.DubboShopAdmin;

/**
 * 
 ************************************************************
 * @类名 : DubboSearchShopResponse.java
 *
 * @DESCRIPTION :搜索店铺返回
 * @AUTHOR : hawk
 * @DATE : 2016年3月16日
 ************************************************************
 */
public class DubboSearchShopResponse extends DubboBasicPageResponse {
    private static final long serialVersionUID = 1L;

    private List<DubboShopAdmin> shopAdminList;

    public List<DubboShopAdmin> getShopAdminList() {
        return shopAdminList;
    }

    public void setShopAdminList(List<DubboShopAdmin> shopAdminList) {
        this.shopAdminList = shopAdminList;
    }

}
