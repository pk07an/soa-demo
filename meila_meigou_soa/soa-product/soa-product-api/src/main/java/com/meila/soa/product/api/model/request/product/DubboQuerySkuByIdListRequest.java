package com.meila.soa.product.api.model.request.product;

import java.util.List;

import com.meila.dubbo.base.model.DubboBasicRequest;

/**
 * 
 ************************************************************
 * @类名 : DubboQuerySpuListRequest.java
 *
 * @DESCRIPTION : 分页查询商品SPU列表
 * @AUTHOR : hawk
 * @DATE : 2016年3月9日
 ************************************************************
 */
public class DubboQuerySkuByIdListRequest extends DubboBasicRequest {
    private static final long serialVersionUID = 1L;

    private List<Long> skuIdList;

    public List<Long> getSkuIdList() {
        return skuIdList;
    }

    public void setSkuIdList(List<Long> skuIdList) {
        this.skuIdList = skuIdList;
    }

}
