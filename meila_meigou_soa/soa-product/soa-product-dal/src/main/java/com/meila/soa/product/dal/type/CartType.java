package com.meila.soa.product.dal.type;

public enum CartType {
    CART_NORMAL_TYPE(0, "NORMAL"), // 普通
    CART_SECKILL_TYPE(1, "SECKILL"), // 秒杀
    CART_NOWBUY_TYPE(2, "NOWBUY"); // 秒杀
    private final int code;
    private final String value;

    private CartType(int code, String value) {
        this.code = code;
        this.value = value;
    }

    public int getCode() {
        return code;
    }

    public String getValue() {
        return value;
    }
}
