package com.meila.soa.product.api.model.request;

import com.meila.common.bean.utils.annotaion.MappingField;
import com.meila.dubbo.base.model.DubboBasicPageRequest2;

/**
 * 
 ************************************************************
 * @类名 : DubboQuerySpuListRequest.java
 *
 * @DESCRIPTION : 分页查询商品SPU列表
 * @AUTHOR : hawk
 * @DATE : 2016年3月9日
 ************************************************************
 */
public class DubboQuerySpuListRequest extends DubboBasicPageRequest2 {
    private static final long serialVersionUID = 1L;

    /**
     * 商品ID spuId
     */
    @MappingField("id")
    private Long productId;

    /**
     * 商品编码
     */
    @MappingField("code")
    private Long productCode;

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
     * 是否延迟发货
     */
    private Boolean isDealy;

    /**
     * 是否有效 ，默认有效 false表示
     */
    private Boolean archive = false;

    public Long getProductCode() {
        return productCode;
    }

    public void setProductCode(Long productCode) {
        this.productCode = productCode;
    }

    public Boolean getIsDealy() {
        return isDealy;
    }

    public void setIsDealy(Boolean isDealy) {
        this.isDealy = isDealy;
    }

    public Boolean getArchive() {
        return archive;
    }

    public void setArchive(Boolean archive) {
        this.archive = archive;
    }

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
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
}
