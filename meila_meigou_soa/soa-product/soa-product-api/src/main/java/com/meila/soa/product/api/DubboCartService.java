package com.meila.soa.product.api;

import com.meila.dubbo.base.model.DubboBasicResponse;
import com.meila.soa.product.api.model.request.DubboAddToCartBySkuCodRequest;
import com.meila.soa.product.api.model.request.DubboAddToCartRequest;
import com.meila.soa.product.api.model.response.DubboAddCartResponse;

public interface DubboCartService {
    /**
     * 功能描述：添加sku到购物车
     * 
     * @param req
     * @return DubboAddToCartResponse
     *
     */
    DubboBasicResponse addToCart(DubboAddToCartRequest req);

    /**
     * 
     * 功能描述：通过skuCode添加到购物车
     * 
     * @param req
     * @return DubboBasicResponse
     *
     */
    DubboBasicResponse addToCartBySkuCode(DubboAddToCartBySkuCodRequest req);

    DubboAddCartResponse addToCartBySkuCodeWithItemIdReturn(DubboAddToCartBySkuCodRequest req);
}
