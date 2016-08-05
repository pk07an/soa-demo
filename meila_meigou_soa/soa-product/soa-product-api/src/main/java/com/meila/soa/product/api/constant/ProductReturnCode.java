package com.meila.soa.product.api.constant;

import com.meila.dubbo.base.constant.DubboReturnCode;

public class ProductReturnCode extends DubboReturnCode {

    /**
     * 商品相关错误码
     */
    /**
     * sku不存在
     */
    public static final int SKU_NOT_EXIST = 10001;

    /**
     * 商品未上架
     */
    public static final int PRODUCT_NOT_ONSALE = 10002;

    /**
     * 库存不足
     */
    public static final int SKU_INVENTORY_NOT_ENOUGH = 10003;

    /**
     * skuMapping数量不合法
     */
    public static final int SKU_MAPPING_NUM_INVLAID = 10004;

    /**
     * sku 套餐已经存在
     */
    public static final int SKU_BUNDLE_EXIST = 10005;

    /**
     * 商品不存在
     */
    public static final int SPU_NOT_EXIST = 10006;

    /**
     * SPU 上架失败
     */
    public static final int SPU_INSTOCK_FAILED = 10007;

    /**
     * 购物车错误码
     */
    public static final int CART_IS_FULL = 20001;

    /**
     * 保税仓商品，不允许添加到购物车
     */
    public static final int CART_BONDED_AREA_PRO_INVALID = 20002;

    /**
     * 商铺不存在
     */
    public static final int SHOP_NOT_EXIST = 30001;

    /**
     * 商铺被冻结
     */
    public static final int SHOP_IS_FROZEN = 30002;

    /**
     * 店主不能购买或者添加自己店铺商品到购物车
     */
    public static final int SHOP_OWNER_LIMIT = 30003;

    /**
     * 店铺name已经存在
     */
    public static final int SHOP_NAME_EXIST = 30004;

    /**
     * 用户不存在
     */
    public static final int USER_NOT_EXIST = 40001;
}
