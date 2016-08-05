package com.meila.soa.product.api.model.request.shop;

import java.util.List;

import com.meila.dubbo.base.model.DubboBasicRequest;

/**
 * 
 ************************************************************
 * @类名 : DubboQueryShopByIdListRequest.java
 *
 * @DESCRIPTION :根据用户ID批量查询店铺信息
 * @AUTHOR : hawk
 * @DATE : 2016年4月25日
 ************************************************************
 */
public class DubboQueryShopByOwnerIdListRequest extends DubboBasicRequest {
    private static final long serialVersionUID = 1L;

    /**
     * 用户ID
     */
    private List<Long> ownerIdList;

    public List<Long> getOwnerIdList() {
        return ownerIdList;
    }

    public void setOwnerIdList(List<Long> ownerIdList) {
        this.ownerIdList = ownerIdList;
    }
}
