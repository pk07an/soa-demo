/**
 * 
 */
package com.meila.soa.product.api.model.request;

import com.meila.dubbo.base.model.DubboBasicRequest;

/**
 ************************************************************
 * @类名 : DubboProductStatRequest.java
 *
 * @DESCRIPTION : 商品统计信息request
 * @AUTHOR : yongqi
 * @DATE : 2016-5-23
 ************************************************************
 */
public class DubboProductStatRequest extends DubboBasicRequest {

    private static final long serialVersionUID = -8804610550912063366L;

    private Long sellerId;

    public Long getSellerId() {
        return sellerId;
    }

    public void setSellerId(Long sellerId) {
        this.sellerId = sellerId;
    }
}
