package com.meila.soa.product.api.model.response;

import java.util.ArrayList;
import java.util.List;

import com.meila.dubbo.base.model.DubboBasicResponse;
import com.meila.soa.product.api.model.dto.DubboProduct;

/**
 ************************************************************
 * @类名 : DubboQuerySpuResponse.java
 *
 * @DESCRIPTION : 查询SPU信息返回类
 * @AUTHOR : hawk
 * @DATE : 2016年1月20日
 ************************************************************
 */
public class DubboQuerySpuResponse extends DubboBasicResponse {
    private static final long serialVersionUID = 1L;
    private List<DubboProduct> productList;

    public DubboQuerySpuResponse() {
        productList = new ArrayList<DubboProduct>();
    }

    public List<DubboProduct> getProductList() {
        return productList;
    }

    public void setProductList(List<DubboProduct> productList) {
        this.productList = productList;
    }
}
