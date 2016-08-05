package com.meila.soa.product.api.model.request;

import com.meila.common.bean.utils.annotaion.MappingField;
import com.meila.dubbo.base.model.DubboBasicPageRequest2;

/**
 * 
 ************************************************************
 * @类名 : DubboSearchSpuListRequest.java
 *
 * @DESCRIPTION :
 * @AUTHOR : hawk
 * @DATE : 2016年3月22日
 ************************************************************
 */
public class DubboSearchSpuListRequest extends DubboBasicPageRequest2 {
    private static final long serialVersionUID = 1L;

    @MappingField("name")
    private String productName;

    /**
     * 店铺ID
     */
    private Long shopId;

    /**
     * 商品状态
     */
    private String status;

    /**
     * 是否店长推荐
     */
    private Boolean recommend;

    /**
     * 根据上架时间查询 onSaleAt >= onSaleAtBegin
     */
    private String onSaleAtBegin;

    /**
     * 根据上架时间查询 onSaleAt <= onSaleAtEnd
     */
    private String onSaleAtEnd;

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

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Boolean getRecommend() {
        return recommend;
    }

    public void setRecommend(Boolean recommend) {
        this.recommend = recommend;
    }

    public String getOnSaleAtBegin() {
        return onSaleAtBegin;
    }

    public void setOnSaleAtBegin(String onSaleAtBegin) {
        this.onSaleAtBegin = onSaleAtBegin;
    }

    public String getOnSaleAtEnd() {
        return onSaleAtEnd;
    }

    public void setOnSaleAtEnd(String onSaleAtEnd) {
        this.onSaleAtEnd = onSaleAtEnd;
    }
}
