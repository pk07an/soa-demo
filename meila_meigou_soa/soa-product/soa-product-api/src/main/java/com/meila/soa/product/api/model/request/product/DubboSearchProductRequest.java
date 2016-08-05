package com.meila.soa.product.api.model.request.product;

import javax.validation.constraints.Min;
import javax.validation.constraints.Pattern;

import com.meila.dubbo.base.model.DubboBasicPageRequest;

/**
 * 
 ************************************************************
 * @类名 : DubboSearchProductRequest.java
 *
 * @DESCRIPTION :搜索商品接口
 * @AUTHOR : hawk
 * @DATE : 2016年5月16日
 ************************************************************
 */
public class DubboSearchProductRequest extends DubboBasicPageRequest {
    private static final long serialVersionUID = 1L;

    /**
     * 商品名称
     */
    private String productName;

    /**
     * 用户ID, 将用户ID转换成对应店铺ID进行搜索
     */
    @Min(value = 0, message = "用户ID不合法")
    private Long userId;
    /**
     * 店铺ID
     */
    @Min(value = 0, message = "店铺ID不合法")
    private Long shopId;

    /**
     * 商品状态
     */
    @Pattern(regexp = "DRAFT|FORSALE|ONSALE|INSTOCK", message = "状态不合法")
    private String productStatus;

    /**
     * 排序字段
     */
    @Pattern(regexp = "amount|sales|price|onsale_at", message = "排序字段不合法")
    private String order;

    /**
     * 排序方向
     */
    @Pattern(regexp = "ASC|DESC", message = "方向不合法")
    private String direction;

    /**
     * 库存数量最大值, 对应搜索条件 amount <= amountMax
     */
    private Integer amountMax;

    public Integer getAmountMax() {
        return amountMax;
    }

    public void setAmountMax(Integer amountMax) {
        this.amountMax = amountMax;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public Long getShopId() {
        return shopId;
    }

    public void setShopId(Long shopId) {
        this.shopId = shopId;
    }

    public String getProductStatus() {
        return productStatus;
    }

    public void setProductStatus(String productStatus) {
        this.productStatus = productStatus;
    }

    public String getOrder() {
        return order;
    }

    public void setOrder(String order) {
        this.order = order;
    }

    public String getDirection() {
        return direction;
    }

    public void setDirection(String direction) {
        this.direction = direction;
    }
}
