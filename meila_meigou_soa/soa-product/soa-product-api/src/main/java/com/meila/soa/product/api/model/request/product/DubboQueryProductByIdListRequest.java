package com.meila.soa.product.api.model.request.product;

import java.util.List;

import com.meila.dubbo.base.model.DubboBasicRequest;

/**
 * 
 ************************************************************
 * @类名 : DubboQueryProductByIdListRequest.java
 *
 * @DESCRIPTION :根据ID列表查询商品基础信息
 * @AUTHOR : hawk
 * @DATE : 2016年5月20日
 ************************************************************
 */
public class DubboQueryProductByIdListRequest extends DubboBasicRequest {
    private static final long serialVersionUID = 1L;

    private List<Long> productIdList;

    public List<Long> getProductIdList() {
        return productIdList;
    }

    public void setProductIdList(List<Long> productIdList) {
        this.productIdList = productIdList;
    }
}
