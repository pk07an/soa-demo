package com.meila.soa.product.service.dubboservice;

import javax.annotation.Resource;

import com.meila.common.exceptions.ServiceException;
import com.meila.dubbo.base.model.DubboBasicResponse;
import com.meila.soa.product.api.DubboCartService;
import com.meila.soa.product.api.constant.ProductReturnCode;
import com.meila.soa.product.api.model.request.DubboAddToCartBySkuCodRequest;
import com.meila.soa.product.api.model.request.DubboAddToCartRequest;
import com.meila.soa.product.api.model.response.DubboAddCartResponse;
import com.meila.soa.product.dal.dao.product.SkuMapper;
import com.meila.soa.product.dal.dao.user.UserMapper;
import com.meila.soa.product.dal.entity.cart.CartItem;
import com.meila.soa.product.dal.entity.product.Sku;
import com.meila.soa.product.dal.entity.user.User;
import com.meila.soa.product.service.innerservice.CartService;

/**
 ************************************************************
 * @类名 : DubboProductServiceImpl.java
 *
 * @DESCRIPTION : 商品接口实现类
 * @AUTHOR : hawk
 * @DATE : 2016年1月15日
 ************************************************************
 */
public class DubboCartServiceImpl implements DubboCartService {

    @Resource
    private CartService cartService;

    @Resource
    private SkuMapper skuMapper;

    @Resource
    private UserMapper userMapper;

    @Override
    public DubboBasicResponse addToCart(DubboAddToCartRequest req) {
        Sku sku = skuMapper.selectByPrimaryKey(req.getSkuId());
        if (null == sku) {
            return new DubboBasicResponse(ProductReturnCode.SKU_NOT_EXIST, "SKU不存在");
        }

        return addToCart(req.getUserId(), sku, req.getAmount(), req.getCartType(), req.getFromSource());
    }

    @Override
    public DubboBasicResponse addToCartBySkuCode(DubboAddToCartBySkuCodRequest req) {
        Sku sku = skuMapper.selectByCode(req.getSkuCode());
        if (null == sku) {
            return new DubboBasicResponse(ProductReturnCode.SKU_NOT_EXIST, "SKU不存在");
        }

        return addToCart(req.getUserId(), sku, req.getAmount(), req.getCartType(), req.getFromSource());
    }

    private DubboAddCartResponse addToCart(Long userId, Sku sku, Integer amount, Integer cartType, String fromSource) {
        DubboAddCartResponse dubboResp = new DubboAddCartResponse();

        try {
            // 检查用户是否存在
            User user = userMapper.selectByPrimaryKey(userId);
            if (null == user) {
                dubboResp.setCode(ProductReturnCode.USER_NOT_EXIST);
                dubboResp.setDesc("用户不存在");
                return dubboResp;
            }

            CartItem item = cartService.addToCart(userId, sku, amount, cartType, fromSource);
            dubboResp.setItemId(item.getId());
            return dubboResp;
        } catch (ServiceException e) {
            dubboResp.setCode(e.getCode());
            dubboResp.setDesc(e.getMessage());
            return dubboResp;
        }
    }

    @Override
    public DubboAddCartResponse addToCartBySkuCodeWithItemIdReturn(DubboAddToCartBySkuCodRequest req) {
        DubboAddCartResponse dubboResp = new DubboAddCartResponse();
        Sku sku = skuMapper.selectByCode(req.getSkuCode());
        if (null == sku) {
            dubboResp.setCode(ProductReturnCode.SKU_NOT_EXIST);
            dubboResp.setDesc("SKU不存在");
            return dubboResp;
        }

        dubboResp = addToCart(req.getUserId(), sku, req.getAmount(), req.getCartType(), req.getFromSource());
        dubboResp.setSkuId(sku.getId());
        dubboResp.setProductId(sku.getProductId());
        dubboResp.setPrice(sku.getPrice());

        return dubboResp;
    }
}
