package com.meila.soa.product.api.model.response;

import java.util.List;

import com.meila.dubbo.base.model.DubboBasicPageResponse;
import com.meila.soa.product.api.model.dto.DubboProductSku;

/**
 * 
 ************************************************************
 * @类名 : DubboQueryErpSkuListResponse.java
 *
 * @DESCRIPTION :查询商品信息返回类
 * @AUTHOR : hawk
 * @DATE : 2016年1月14日
 ************************************************************
 */
public class DubboQueryErpSkuListResponse extends DubboBasicPageResponse {
    private static final long serialVersionUID = 1L;

    private List<DubboProductSku> productSkuList;

    public List<DubboProductSku> getProductSkuList() {
        return productSkuList;
    }

    public void setProductSkuList(List<DubboProductSku> productSkuList) {
        this.productSkuList = productSkuList;
    }
}
