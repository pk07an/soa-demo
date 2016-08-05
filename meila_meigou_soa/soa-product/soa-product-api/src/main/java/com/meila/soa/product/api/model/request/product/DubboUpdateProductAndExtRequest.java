package com.meila.soa.product.api.model.request.product;

import java.math.BigDecimal;
import java.util.Date;

import com.meila.dubbo.base.model.DubboBasicRequest;

/**
 * 
 ************************************************************
 * @类名 : DubboUpdateProductAndExtRequest.java
 *
 * @DESCRIPTION :更新商品和Ext信息请求类
 * @AUTHOR : hawk
 * @DATE : 2016年4月28日
 ************************************************************
 */
public class DubboUpdateProductAndExtRequest extends DubboBasicRequest {
    private static final long serialVersionUID = 1L;

    private String img;

    private Long userId;

    private Long productId;

    // DEFAULT '0' 修改类型 1.商品-基本信息 2.商品-图文详情',
    private String type = "0";

    private String status;

    // 是否只修改伪销量;
    private Boolean onlyUpdSales = false;

    // 零时使用产品销量
    private Integer fakeSales;

    private String shortIntro;

    private String shortName;

    private BigDecimal msPrice;

    // 秒杀-开始时间
    private Date startTime;
    // 秒杀-结束时间
    private Date endTime;

    /**
     * 商品前缀
     */
    private String productPrefix;

    /**
     * 商品后缀
     */
    private String productSuffix;

    private String name;

    private String shopId;

    private String description;

    private Boolean archive;

    private BigDecimal marketPrice; // 市场价

    private BigDecimal price; // 最低价格

    private BigDecimal postage; // 邮费

    private Integer sales;// 产品销

    private Boolean freePostage = false;

    // private BigInteger thirdItemId; //第三方同步id
    private String thirdItemId;

    // add by luojy 20150708
    private Boolean enableDesc;

    // 是否是特价商品 seker 20150114增加
    private Boolean productSP = false;

    private String code;

    private String descImg;

    private Long opUserId;

    public Long getOpUserId() {
        return opUserId;
    }

    public void setOpUserId(Long opUserId) {
        this.opUserId = opUserId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getShopId() {
        return shopId;
    }

    public void setShopId(String shopId) {
        this.shopId = shopId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Boolean getArchive() {
        return archive;
    }

    public void setArchive(Boolean archive) {
        this.archive = archive;
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

    public Integer getSales() {
        return sales;
    }

    public void setSales(Integer sales) {
        this.sales = sales;
    }

    public Boolean getFreePostage() {
        return freePostage;
    }

    public void setFreePostage(Boolean freePostage) {
        this.freePostage = freePostage;
    }

    public String getThirdItemId() {
        return thirdItemId;
    }

    public void setThirdItemId(String thirdItemId) {
        this.thirdItemId = thirdItemId;
    }

    public Boolean getEnableDesc() {
        return enableDesc;
    }

    public void setEnableDesc(Boolean enableDesc) {
        this.enableDesc = enableDesc;
    }

    public Boolean getProductSP() {
        return productSP;
    }

    public void setProductSP(Boolean productSP) {
        this.productSP = productSP;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getDescImg() {
        return descImg;
    }

    public void setDescImg(String descImg) {
        this.descImg = descImg;
    }

    public String getShortIntro() {
        return shortIntro;
    }

    public void setShortIntro(String shortIntro) {
        this.shortIntro = shortIntro;
    }

    public String getShortName() {
        return shortName;
    }

    public void setShortName(String shortName) {
        this.shortName = shortName;
    }

    public BigDecimal getMsPrice() {
        return msPrice;
    }

    public void setMsPrice(BigDecimal msPrice) {
        this.msPrice = msPrice;
    }

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    public String getProductPrefix() {
        return productPrefix;
    }

    public void setProductPrefix(String productPrefix) {
        this.productPrefix = productPrefix;
    }

    public String getProductSuffix() {
        return productSuffix;
    }

    public void setProductSuffix(String productSuffix) {
        this.productSuffix = productSuffix;
    }

    public Integer getFakeSales() {
        return fakeSales;
    }

    public void setFakeSales(Integer fakeSales) {
        this.fakeSales = fakeSales;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    public Boolean getOnlyUpdSales() {
        return onlyUpdSales;
    }

    public void setOnlyUpdSales(Boolean onlyUpdSales) {
        this.onlyUpdSales = onlyUpdSales;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
