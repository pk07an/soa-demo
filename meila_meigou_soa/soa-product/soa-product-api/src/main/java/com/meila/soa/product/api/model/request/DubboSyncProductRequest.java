package com.meila.soa.product.api.model.request;

import java.util.List;

import org.hibernate.validator.constraints.NotEmpty;

import com.meila.dubbo.base.model.DubboBasicRequest;
import com.meila.soa.product.api.model.dto.DubboProductSku;

/**
 ************************************************************
 * @类名 : DubboSyncProductRequest.java
 *
 * @DESCRIPTION : 同步Erp Sku信息请求类
 * @AUTHOR : hawk
 * @DATE : 2016年1月26日
 ************************************************************
 */
public class DubboSyncProductRequest extends DubboBasicRequest {
    private static final long serialVersionUID = 1L;

    /**
     * erp sku 列表
     */
    @NotEmpty
    private List<DubboProductSku> productSkuList;

    public List<DubboProductSku> getProductSkuList() {
        return productSkuList;
    }

    public void setProductSkuList(List<DubboProductSku> productSkuList) {
        this.productSkuList = productSkuList;
    }
}
