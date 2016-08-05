package com.meila.soa.product.api.model.response;

import java.util.List;

import com.meila.dubbo.base.model.DubboBasicPageResponse;
import com.meila.soa.product.api.model.dto.DubboProductInvStatistic;

/**
 * 
 ************************************************************
 * @类名 : DubboQueryCachedInvResponse.java
 *
 * @DESCRIPTION :查询库存短缺数量信息
 * @AUTHOR : hawk
 * @DATE : 2016年3月31日
 ************************************************************
 */
public class DubboQueryCachedInvResponse extends DubboBasicPageResponse {
    private static final long serialVersionUID = 1L;

    private List<DubboProductInvStatistic> productInvStatisticList;

    /**
     * @return the productInvStatisticList
     */
    public List<DubboProductInvStatistic> getProductInvStatisticList() {
        return productInvStatisticList;
    }

    /**
     * @param productInvStatisticList the productInvStatisticList to set
     */
    public void setProductInvStatisticList(List<DubboProductInvStatistic> productInvStatisticList) {
        this.productInvStatisticList = productInvStatisticList;
    }
}
