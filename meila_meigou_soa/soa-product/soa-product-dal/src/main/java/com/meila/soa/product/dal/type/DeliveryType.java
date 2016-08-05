package com.meila.soa.product.dal.type;

/**
 * 卖家发货类型
 * 
 * @author yongqi.wu@meila.com
 */
public enum DeliveryType {

    MEILA, // 美啦代发货
    SELLER, // 卖家发货
    BONDED_AREA, // 保税仓发货
    BONDED_AREA_ML, // 美啦保税仓
    HONGKONG_ML, // 香港发货
    OVERSEAS_DIRECT_MAIL // 海外直邮
}
