package com.meila.soa.product.api.model.dto;

import java.math.BigDecimal;
import java.util.Date;

import com.meila.common.bean.utils.annotaion.MappingField;
import com.meila.dubbo.base.model.BasicSeriModel;

/**
 * 
 ************************************************************
 * @类名 : DubboSpuBasicInfo.java
 *
 * @DESCRIPTION :商品SPU基础信息
 * @AUTHOR : hawk
 * @DATE : 2016年3月10日
 ************************************************************
 */
public class DubboSpuBasicInfo extends BasicSeriModel {
    private static final long serialVersionUID = 1L;

    /**
     * 商品ID
     */
    @MappingField("id")
    private Long productId;

    /**
     * 商品名称
     */
    @MappingField("name")
    private String productName;

    /**
     * 用户ID
     */
    private Long userId;

    /**
     * 店铺ID
     */
    private Long shopId;

    /**
     * 商品主图
     */
    @MappingField("img")
    private String productImg;

    /**
     * 主图宽度
     */
    private Integer imgWidth;

    /**
     * 主图高度
     */
    private Integer imgHeight;

    /**
     * 主图描述
     */
    @MappingField("descImg")
    private String descImg;

    /**
     * 商品状态 状态: DRAFT 草稿； FORSALE 待上架发布； ONSALE 上架； INSTOCK 下架
     */
    private String status;

    /**
     * 原价
     */
    private BigDecimal marketPrice;

    /**
     * 现价
     */
    private BigDecimal price;

    /**
     * 邮费
     */
    private BigDecimal postage;

    /**
     * 库存数量
     */
    private Long amount;

    /**
     * 已售数量
     */
    private Long sales;

    /**
     * 逻辑删除标示
     */
    private Boolean archive;

    /**
     * 是否推荐商品
     */
    private Boolean recommend;

    /**
     * 推荐时间
     */
    private Date recommendAt;

    /**
     * 优惠折扣
     */
    private BigDecimal discount;

    /**
     * 是否分润商品
     */
    private Boolean isCommission;

    /**
     * 分润比例
     */
    private BigDecimal commissionRate;

    /**
     * 待发布时间
     */
    private Date forsaleAt;

    /**
     * 上架时间
     */
    private Date onsaleAt;

    /**
     * 下架时间
     */
    private Date instockAt;

    /**
     * 创建时间
     */
    private Date createAt;

    /**
     * 更新时间
     */
    private Date updateAt;

    /**
     * 伪销量
     */
    private Long fakeSales;

    /**
     * 是否延迟发货
     */
    private Boolean isdelay;

    /**
     * 延迟天数
     */
    private Integer delaydays;

    /**
     * 同步渠道
     */
    private String synchronousflag;

    /**
     * 第三方同步ID
     */
    private String thirdItemId;

    /**
     * 第三方商品ID
     */
    private Long partnerProductId;

    /**
     * 商品编码
     */
    @MappingField("code")
    private String productCode;

    /**
     * 商品描述
     */
    @MappingField("description")
    private String productDesc;

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getShopId() {
        return shopId;
    }

    public void setShopId(Long shopId) {
        this.shopId = shopId;
    }

    public String getProductImg() {
        return productImg;
    }

    public void setProductImg(String productImg) {
        this.productImg = productImg;
    }

    public Integer getImgWidth() {
        return imgWidth;
    }

    public void setImgWidth(Integer imgWidth) {
        this.imgWidth = imgWidth;
    }

    public Integer getImgHeight() {
        return imgHeight;
    }

    public void setImgHeight(Integer imgHeight) {
        this.imgHeight = imgHeight;
    }

    public String getDescImg() {
        return descImg;
    }

    public void setDescImg(String descImg) {
        this.descImg = descImg;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public BigDecimal getMarketPrice() {
        return marketPrice;
    }

    public void setMarketPrice(BigDecimal marketPrice) {
        this.marketPrice = marketPrice;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public BigDecimal getPostage() {
        return postage;
    }

    public void setPostage(BigDecimal postage) {
        this.postage = postage;
    }

    public Long getAmount() {
        return amount;
    }

    public void setAmount(Long amount) {
        this.amount = amount;
    }

    public Long getSales() {
        return sales;
    }

    public void setSales(Long sales) {
        this.sales = sales;
    }

    public Boolean getArchive() {
        return archive;
    }

    public void setArchive(Boolean archive) {
        this.archive = archive;
    }

    public Boolean getRecommend() {
        return recommend;
    }

    public void setRecommend(Boolean recommend) {
        this.recommend = recommend;
    }

    public Date getRecommendAt() {
        return recommendAt;
    }

    public void setRecommendAt(Date recommendAt) {
        this.recommendAt = recommendAt;
    }

    public BigDecimal getDiscount() {
        return discount;
    }

    public void setDiscount(BigDecimal discount) {
        this.discount = discount;
    }

    public Boolean getIsCommission() {
        return isCommission;
    }

    public void setIsCommission(Boolean isCommission) {
        this.isCommission = isCommission;
    }

    public BigDecimal getCommissionRate() {
        return commissionRate;
    }

    public void setCommissionRate(BigDecimal commissionRate) {
        this.commissionRate = commissionRate;
    }

    public Date getForsaleAt() {
        return forsaleAt;
    }

    public void setForsaleAt(Date forsaleAt) {
        this.forsaleAt = forsaleAt;
    }

    public Date getOnsaleAt() {
        return onsaleAt;
    }

    public void setOnsaleAt(Date onsaleAt) {
        this.onsaleAt = onsaleAt;
    }

    public Date getInstockAt() {
        return instockAt;
    }

    public void setInstockAt(Date instockAt) {
        this.instockAt = instockAt;
    }

    public Date getCreateAt() {
        return createAt;
    }

    public void setCreateAt(Date createAt) {
        this.createAt = createAt;
    }

    public Date getUpdateAt() {
        return updateAt;
    }

    public void setUpdateAt(Date updateAt) {
        this.updateAt = updateAt;
    }

    public Long getFakeSales() {
        return fakeSales;
    }

    public void setFakeSales(Long fakeSales) {
        this.fakeSales = fakeSales;
    }

    public Boolean getIsdelay() {
        return isdelay;
    }

    public void setIsdelay(Boolean isdelay) {
        this.isdelay = isdelay;
    }

    public Integer getDelaydays() {
        return delaydays;
    }

    public void setDelaydays(Integer delaydays) {
        this.delaydays = delaydays;
    }

    public String getSynchronousflag() {
        return synchronousflag;
    }

    public void setSynchronousflag(String synchronousflag) {
        this.synchronousflag = synchronousflag;
    }

    public String getThirdItemId() {
        return thirdItemId;
    }

    public void setThirdItemId(String thirdItemId) {
        this.thirdItemId = thirdItemId;
    }

    public Long getPartnerProductId() {
        return partnerProductId;
    }

    public void setPartnerProductId(Long partnerProductId) {
        this.partnerProductId = partnerProductId;
    }

    public String getProductCode() {
        return productCode;
    }

    public void setProductCode(String productCode) {
        this.productCode = productCode;
    }

    public String getProductDesc() {
        return productDesc;
    }

    public void setProductDesc(String productDesc) {
        this.productDesc = productDesc;
    }
}
