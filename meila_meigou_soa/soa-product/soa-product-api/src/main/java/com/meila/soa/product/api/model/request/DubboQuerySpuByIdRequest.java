package com.meila.soa.product.api.model.request;

import java.util.List;

import com.meila.dubbo.base.model.DubboBasicRequest;

/**
 ************************************************************
 * @类名 : DubboQuerySpuByIdRequest.java
 *
 * @DESCRIPTION : 根据查询商品SPU信息请求类
 * @AUTHOR : hawk
 * @DATE : 2016年1月20日
 ************************************************************
 */
public class DubboQuerySpuByIdRequest extends DubboBasicRequest {
    private static final long serialVersionUID = 1L;

    List<Long> productIdList;

    public List<Long> getProductIdList() {
        return productIdList;
    }

    public void setProductIdList(List<Long> productIdList) {
        this.productIdList = productIdList;
    }
}
