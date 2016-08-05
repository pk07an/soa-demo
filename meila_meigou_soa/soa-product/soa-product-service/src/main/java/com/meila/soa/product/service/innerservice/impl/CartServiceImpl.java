package com.meila.soa.product.service.innerservice.impl;

import java.util.HashSet;
import java.util.Set;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.meila.common.exceptions.ServiceException;
import com.meila.meigou.cachehelper.RedisAdapter;
import com.meila.soa.meila.client.model.OnPurchaseModel;
import com.meila.soa.meila.client.service.MeiLaSNSReportService;
import com.meila.soa.product.api.constant.ProductReturnCode;
import com.meila.soa.product.dal.dao.cart.CartItemMapper;
import com.meila.soa.product.dal.dao.product.ProductMapper;
import com.meila.soa.product.dal.dao.product.SkuMapper;
import com.meila.soa.product.dal.entity.cart.CartItem;
import com.meila.soa.product.dal.entity.product.Product;
import com.meila.soa.product.dal.entity.product.Sku;
import com.meila.soa.product.dal.mybatis.IdTypeHandler;
import com.meila.soa.product.dal.type.CartType;
import com.meila.soa.product.dal.type.DeliveryType;
import com.meila.soa.product.dal.type.ProductStatus;
import com.meila.soa.product.dal.type.ShopStatus;
import com.meila.soa.product.service.innerservice.CartService;
import com.meila.soa.product.service.innerservice.ProductService;
import com.meila.soa.product.service.innerservice.ShopService;
import com.meila.soa.product.service.model.ShopModel;

/**
 * @类名： CartServiceImpl.java @描述： @作者： Toney @修改日期： 2015年7月2日
 */
@Service("cartService")
public class CartServiceImpl implements CartService {
    private static final Logger logger = LoggerFactory.getLogger(CartServiceImpl.class);

    @Resource
    private ProductService productService;

    @Resource
    private ProductMapper productMapper;

    @Resource
    private ShopService shopService;

    @Resource
    private SkuMapper skuMapper;

    @Resource
    private CartItemMapper cartItemEntityMapper;

    @Resource
    private MeiLaSNSReportService meiLaSNSReportService;

    @Autowired
    private RedisAdapter redisAdapter;

    private static String CART_USER_ITEM = "CART_USER_ITEM_";

    @SuppressWarnings("unchecked")
    private void setCartUserItem(String op, Set<String> skuIds, Long userId) {
        try {
            final String key = CART_USER_ITEM + userId;
            Set<String> cartUserItemSet = new HashSet<String>();
            if (redisAdapter.exists(key)) {
                cartUserItemSet = (Set<String>) redisAdapter.get(key, Set.class);
            }

            if ("add".equals(op)) {
                cartUserItemSet.addAll(skuIds);
            } else if ("delete".equals(op)) {
                cartUserItemSet.removeAll(skuIds);
            } else if ("reset".equals(op)) {
                cartUserItemSet = new HashSet<String>();
                cartUserItemSet.addAll(skuIds);
            } else if ("clear".equals(op)) {
                cartUserItemSet = new HashSet<String>();
            }
            redisAdapter.set(key, cartUserItemSet);
        } catch (Exception ex) {
            logger.error("添加用户购物车缓存失败", ex);
        }
    }

    /**
     * 简化流程 三种使用场景，validate, checkout, add, update 功能描述：
     * 
     * @param amount
     * @param cartType
     * @param skuId
     * 
     * @return
     */
    @Override
    public CartItem addToCart(Long userId, Sku sku, Integer amount, Integer cartType, String fromSource) {
        Product product = productMapper.selectById(sku.getProductId());
        // check sku
        if (!ProductStatus.ONSALE.equals(product.getStatus())) {
            throw new ServiceException(ProductReturnCode.PRODUCT_NOT_ONSALE, "美妞，当前商品已失效，请购买其他卖家的商品");
        }

        // 将来增加的店铺状态检查
        ShopModel shopModel = shopService.loadShopAndExt(product.getShopId());
        if (shopModel == null) {
            throw new ServiceException(ProductReturnCode.SHOP_NOT_EXIST, "美妞，当前商品已失效，请购买其他卖家的商品");
        }
        if (ShopStatus.FROZEN.equals(shopModel.getShopEntity().getStatus())) {
            throw new ServiceException(ProductReturnCode.SHOP_IS_FROZEN, "美妞，当前商品已失效，请购买其他卖家的商品");
        }
        if (shopModel.getShopEntity().getOwnerId().equals(userId)) {
            throw new ServiceException(ProductReturnCode.SHOP_OWNER_LIMIT, "店主不能添加自己店铺商品到购物车");
        }
        CartItem item = null;
        // 秒杀
        if (CartType.CART_SECKILL_TYPE.getCode() == cartType) {
            item = addToSecKill(sku.getId(), amount, userId, sku, shopModel, fromSource);
        }
        // 立即购买
        else if (CartType.CART_NOWBUY_TYPE.getCode() == cartType) {
            item = addToNowBuy(sku.getId(), amount, userId, sku, shopModel, fromSource);
        }
        // 普通购买
        else {
            Integer count = cartItemEntityMapper.countByUserIdAndCartType(userId, CartType.CART_NORMAL_TYPE.getValue());
            if (count != null && count >= 50) {
                throw new ServiceException(ProductReturnCode.CART_IS_FULL, "购物车已满");
            }
            item = addToNormal(sku.getId(), amount, userId, sku, shopModel, fromSource);
            Set<String> skuIds = new HashSet<String>();
            skuIds.add(IdTypeHandler.encode(sku.getId()));
            this.setCartUserItem("add", skuIds, userId);
        }
        return item;
    }

    /**
     *
     * 功能描述：通过 秒杀按钮 购买
     * 
     * @param skuId
     * @param amount
     * @param sku
     * @param shop
     * @param fromSource TODO
     * @param user
     * @param onPurchaseModel void
     * @Exception :
     */
    private CartItem addToSecKill(Long skuId, Integer amount, Long userId, Sku sku, ShopModel shop, String fromSource) {
        CartItem item = cartItemEntityMapper.selectByUserIdAndSku(skuId, userId, CartType.CART_SECKILL_TYPE.getValue());
        if (item == null) {
            item = new CartItem();
            item.setSkuId(skuId);
            item.setProductId(sku.getProductId());
            item.setShopId(shop.getShopEntity().getId());
            item.setSellerId(shop.getShopEntity().getOwnerId());
            item.setAmount(1);
            item.setUserId(userId);
            item.setStatus(CartType.CART_SECKILL_TYPE.getValue());
            item.setFromSource(fromSource);
            cartItemEntityMapper.insert(item);
        } else {
            item.setAmount(1);
            cartItemEntityMapper.updateByPrimaryKeySelective(item);
        }
        return item;
    }

    /**
     *
     * 功能描述：通过 立即购买 商品添加到购物车
     * 
     * @param skuId
     * @param amount
     * @param sku
     * @param shop
     * @param fromSource TODO
     * @param user
     * @param onPurchaseModel void
     * @Exception :
     */
    private CartItem addToNowBuy(Long skuId, Integer amount, Long userId, Sku sku, ShopModel shop, String fromSource) {

        // 美啦保税仓库逻辑
        if (DeliveryType.BONDED_AREA_ML.equals(shop.getShopExtEntity().getDeliveryType())) {
            // 默认只能1件
            amount = 1;
        }

        CartItem item = cartItemEntityMapper.selectByUserIdAndSku(skuId, userId, CartType.CART_NOWBUY_TYPE.getValue());
        // 店铺的判断
        if (item == null) {
            item = new CartItem();
            item.setSkuId(skuId);
            item.setProductId(sku.getProductId());
            item.setShopId(shop.getShopEntity().getId());
            item.setSellerId(shop.getShopEntity().getOwnerId());
            item.setAmount(amount == null ? 1 : amount);
            item.setUserId(userId);
            item.setStatus(CartType.CART_NOWBUY_TYPE.getValue());
            item.setFromSource(fromSource);
            cartItemEntityMapper.insert(item);
        } else {
            item.setAmount(amount);
            if (sku.getAmount() > 0 && item.getAmount() > sku.getAmount()) {
                // 超过sku库存数量，自动纠正购买数量
                logger.info("商品规格[" + sku.getSpec() + "]库存[" + sku.getAmount() + "]不足，自动修正购物车中的购买数量。");
                item.setAmount(sku.getAmount());
            }
            cartItemEntityMapper.updateByPrimaryKeySelective(item);
        }
        return item;
    }

    /**
     *
     * 功能描述：功能描述：通过 加入购物车 商品添加到购物车
     * 
     * @param skuId
     * @param amount
     * @param sku
     * @param shop
     * @param fromSource TODO
     * @param user
     * @param onPurchaseModel void
     * @Exception :
     */
    private CartItem addToNormal(Long skuId, Integer amount, Long userId, Sku sku, ShopModel shop, String fromSource) {
        // 美啦保税仓逻辑，不允许加入购物车
        if (DeliveryType.BONDED_AREA_ML.equals(shop.getShopExtEntity().getDeliveryType())) {
            throw new ServiceException(ProductReturnCode.CART_BONDED_AREA_PRO_INVALID, "保税仓货物，不允许加入购物车");
        }
        // 店铺的判断
        CartItem item = cartItemEntityMapper.selectByUserIdAndSku(skuId, userId, CartType.CART_NORMAL_TYPE.getValue());

        if (item == null) {
            item = new CartItem();
            item.setSkuId(skuId);
            item.setProductId(sku.getProductId());
            item.setShopId(shop.getShopEntity().getId());
            item.setSellerId(shop.getShopEntity().getOwnerId());
            item.setAmount(amount == null ? 1 : amount);
            item.setUserId(userId);
            item.setStatus(CartType.CART_NORMAL_TYPE.getValue());
            item.setFromSource(fromSource);
            cartItemEntityMapper.insert(item);
        } else {
            if (item.getAmount() + amount > sku.getAmount()) {
                // 超过sku库存数量，自动纠正购买数量
                logger.info("商品规格[" + sku.getSpec() + "]库存[" + sku.getAmount() + "]不足，自动修正购物车中的购买数量。");
                item.setAmount(sku.getAmount());
            } else {
                item.setAmount(item.getAmount() + amount);
            }
            cartItemEntityMapper.updateByPrimaryKeySelective(item);
        }

        // 上报社区
        try {
            OnPurchaseModel onPurchaseModel = new OnPurchaseModel();
            onPurchaseModel.setAction("addtocart");
            onPurchaseModel.setUserId(String.valueOf(userId));
            onPurchaseModel.setFrom_source(fromSource);
            onPurchaseModel.setNum(amount);
            onPurchaseModel.setSource("web");
            cartOnPurchaseModel(amount, onPurchaseModel, sku);
        } catch (Exception e) {
            logger.error("收集上报社区数据失败", e);
        }
        return item;
    }

    private void cartOnPurchaseModel(Integer amount, OnPurchaseModel onPurchaseModel, Sku sku) {
        // 上报访问到社区
        onPurchaseModel.setNum(amount);
        onPurchaseModel.setUnitPrice(sku.getPrice());
        onPurchaseModel.setWareId(sku.getProductId());
        onPurchaseModel.setSkuId(sku.getId());
        meiLaSNSReportService.onPurchaseToMeila(onPurchaseModel);
        // 上报访问到社区
    }
}
