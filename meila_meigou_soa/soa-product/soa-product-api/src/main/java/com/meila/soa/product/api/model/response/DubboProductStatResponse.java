/**
 * 
 */
package com.meila.soa.product.api.model.response;

import com.meila.dubbo.base.model.DubboBasicResponse;

/**
 ************************************************************ 
 * @类名 : DubboProductStatResponse.java
 * 
 * @DESCRIPTION : 商品统计response
 * @AUTHOR : yongqi
 * @DATE : 2016-5-23
 ************************************************************ 
 */
public class DubboProductStatResponse extends DubboBasicResponse {

    private static final long serialVersionUID = 769764442956281143L;

    private Long sellerId;
    private Integer onSaleCount; // 上架商品数量
    private Integer soldOutCount; // 售罄商品数量

    public Long getSellerId() {
        return sellerId;
    }

    public void setSellerId(Long sellerId) {
        this.sellerId = sellerId;
    }

    public Integer getOnSaleCount() {
        return onSaleCount;
    }

    public void setOnSaleCount(Integer onSaleCount) {
        this.onSaleCount = onSaleCount;
    }

    public Integer getSoldOutCount() {
        return soldOutCount;
    }

    public void setSoldOutCount(Integer soldOutCount) {
        this.soldOutCount = soldOutCount;
    }

}
