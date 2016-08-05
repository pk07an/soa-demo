package com.meila.soa.product.dal.entity.product;

import java.math.BigDecimal;
import java.util.Date;

import com.meila.common.bean.utils.annotaion.MappingField;
import com.meila.soa.product.dal.type.ProductStatus;

public class Product {

    /**
     * SPU ID
     */
    @MappingField({ "productId" })
    private Long id;

    /**
     * 用户ID
     */
    private Long userId;

    /**
     * 店铺ID
     */
    private Long shopId;

    /**
     * 商品名称
     */
    @MappingField({ "productName" })
    private String name;

    /**
     * 商品主图
     */
    @MappingField({ "productImg", "productMainImg" })
    private String img;

    /**
     * 主图宽度
     */
    private Integer imgWidth;

    /**
     * 主图高度
     */
    private Integer imgHeight;

    /**
     * 图片描述信息
     */
    @MappingField({ "imgDesc" })
    private String descImg;

    /**
     * 商品描述
     */
    @MappingField({ "productDesc" })
    private String description;

    /**
     * 商品状态 DRAFT 草稿； FORSALE 待上架发布； ONSALE 上架； INSTOCK 下架
     */
    @MappingField({ "productStatus" })
    private ProductStatus status;

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
     * 逻辑删除
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
     * 优惠金额
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
     * 等待发布时间
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
    private Date createdAt;

    /**
     * 更新时间
     */
    private Date updatedAt;

    /**
     * 伪销量
     */
    private Long fakeSales;

    /**
     * 是否延迟发货
     */
    private Boolean isDelay;

    /**
     * 延迟天数
     */
    private Integer delayDays;

    /**
     * 锁定
     */
    private Boolean updateLock;

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
    @MappingField({ "productCode" })
    private String code;

    /**
     * 冗余字段，临时兼容
     */
    private Boolean freePostage = false;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Boolean getFreePostage() {
        return freePostage;
    }

    public void setFreePostage(Boolean freePostage) {
        this.freePostage = freePostage;
    }

    public Long getShopId() {
        return shopId;
    }

    public void setShopId(Long shopId) {
        this.shopId = shopId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
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

    public ProductStatus getStatus() {
        return status;
    }

    public void setStatus(ProductStatus status) {
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

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public Date getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
    }

    public Long getFakeSales() {
        return fakeSales;
    }

    public void setFakeSales(Long fakeSales) {
        this.fakeSales = fakeSales;
    }

    public Boolean getIsDelay() {
        return isDelay;
    }

    public void setIsDelay(Boolean isDelay) {
        this.isDelay = isDelay;
    }

    public Integer getDelayDays() {
        return delayDays;
    }

    public void setDelayDays(Integer delayDays) {
        this.delayDays = delayDays;
    }

    public Boolean getUpdateLock() {
        return updateLock;
    }

    public void setUpdateLock(Boolean updateLock) {
        this.updateLock = updateLock;
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

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
