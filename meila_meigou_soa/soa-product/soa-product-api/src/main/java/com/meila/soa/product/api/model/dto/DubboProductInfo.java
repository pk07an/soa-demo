package com.meila.soa.product.api.model.dto;

import java.math.BigDecimal;
import java.util.Date;

import com.meila.dubbo.base.model.BasicSeriModel;

/**
 * 
 ************************************************************
 * @类名 : DubboProduct.java
 *
 * @DESCRIPTION :商品SPU,用作dubbo调用中
 * @AUTHOR : hawk
 * @DATE : 2016年1月15日
 ************************************************************
 */
public class DubboProductInfo extends BasicSeriModel {

    private static final long serialVersionUID = 1L;

    /**
     * spu id
     */
    private Long productId;

    /**
     * 商品属性 1.一般商品 2.秒杀商品
     */
    private Integer property;

    /**
     * 秒杀价格
     */
    private BigDecimal secKillPrice;

    /**
     * 秒杀开始时间
     */
    private Date secKillStartTime;

    /**
     * 秒杀结束时间
     */
    private Date secKillEndTime;

    /**
     * 短描述
     */
    private String shortIntro;

    /**
     * 简短名称
     */
    private String shortName;

    /**
     * 库存总量
     */
    private Integer totalCount;

    /**
     * 评论总量
     */
    private Integer commentCount;

    /**
     * 荣耀徽标
     */
    private String badges;

    /**
     * 明日预告文案
     */
    private String presaleText;

    /**
     * 明日预告跳转类型
     */
    private String presaleJumpLabel;

    /**
     * 明日预告跳转数据
     */
    private String presaleJumpData;

    /**
     * 审核状态 [TODO] 添加注释
     */
    private Integer verify;

    /**
     * 是否需要M码
     */
    private Integer needMcode;

    /**
     * M码上提示文本
     */
    private String mcodeTip;

    /**
     * 限购数量
     */
    private Integer buyLimitCount;

    /**
     * 绑定的话题ID
     */
    private Long vtalkId;

    /**
     * 小编鉴定话题ID
     */
    private Long appraisalVtalkId;

    /**
     * 小编鉴定显示文本
     */
    private String appraisalText;

    /**
     * 买一件能兑换的美币数量
     */
    private Integer coinLimit;

    /**
     * 分销状态 1,自营 2,分销
     */
    private Integer distribStatus;

    /**
     * 发货模式
     */
    private Integer postMode;

    /**
     * 评分
     */
    private BigDecimal star;

    /**
     * 评分数量
     */
    private Integer starSum;

    /**
     * 评分用户数
     */
    private Integer starUsersCount;

    /**
     * 收藏数量
     */
    private Integer collectedCount;

    private String topComments;

    private String brandName;

    private Integer discussCount;

    private String shareImgUrl;

    private Integer shareImgWidth;

    private Integer shareImgHeight;

    /**
     * 采购地
     */
    private String purchaseSource;

    /**
     * 库存类型 SPOT:现货, NON_SPOT:非现货
     */
    private String storageType;

    /**
     * 备货时间 天数
     */
    private Integer productPrepareDays;

    /**
     * 国际物流时间 天数
     */
    private Integer logisticsInternaDays;

    /**
     * 发货方式: SELLER:卖家自发(非保税仓),BONDED_AREA:卖家自发(卖家保税仓), MEILA:美啦国内发货(美啦西丽WMS代发), BONDED_AREA_ML:美啦保税仓,
     * HONGKONG_ML:美啦香港直发
     */
    private String deliveryType;

    /**
     * 发货仓库: LOCAL_XILI:西丽, BONDED_AREA_GUANGZHOU:广州保税仓, BONDED_AREA_NINGBO:宁波保税仓, HONGKONG:香港
     */
    private String warehouse;

    /**
     * 包邮类型
     */
    private String postageType;

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    public Integer getProperty() {
        return property;
    }

    public void setProperty(Integer property) {
        this.property = property;
    }

    public BigDecimal getSecKillPrice() {
        return secKillPrice;
    }

    public void setSecKillPrice(BigDecimal secKillPrice) {
        this.secKillPrice = secKillPrice;
    }

    public Date getSecKillStartTime() {
        return secKillStartTime;
    }

    public void setSecKillStartTime(Date secKillStartTime) {
        this.secKillStartTime = secKillStartTime;
    }

    public Date getSecKillEndTime() {
        return secKillEndTime;
    }

    public void setSecKillEndTime(Date secKillEndTime) {
        this.secKillEndTime = secKillEndTime;
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

    public Integer getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(Integer totalCount) {
        this.totalCount = totalCount;
    }

    public Integer getCommentCount() {
        return commentCount;
    }

    public void setCommentCount(Integer commentCount) {
        this.commentCount = commentCount;
    }

    public String getBadges() {
        return badges;
    }

    public void setBadges(String badges) {
        this.badges = badges;
    }

    public String getPresaleText() {
        return presaleText;
    }

    public void setPresaleText(String presaleText) {
        this.presaleText = presaleText;
    }

    public String getPresaleJumpLabel() {
        return presaleJumpLabel;
    }

    public void setPresaleJumpLabel(String presaleJumpLabel) {
        this.presaleJumpLabel = presaleJumpLabel;
    }

    public String getPresaleJumpData() {
        return presaleJumpData;
    }

    public void setPresaleJumpData(String presaleJumpData) {
        this.presaleJumpData = presaleJumpData;
    }

    public Integer getVerify() {
        return verify;
    }

    public void setVerify(Integer verify) {
        this.verify = verify;
    }

    public Integer getNeedMcode() {
        return needMcode;
    }

    public void setNeedMcode(Integer needMcode) {
        this.needMcode = needMcode;
    }

    public String getMcodeTip() {
        return mcodeTip;
    }

    public void setMcodeTip(String mcodeTip) {
        this.mcodeTip = mcodeTip;
    }

    public Integer getBuyLimitCount() {
        return buyLimitCount;
    }

    public void setBuyLimitCount(Integer buyLimitCount) {
        this.buyLimitCount = buyLimitCount;
    }

    public Long getVtalkId() {
        return vtalkId;
    }

    public void setVtalkId(Long vtalkId) {
        this.vtalkId = vtalkId;
    }

    public Long getAppraisalVtalkId() {
        return appraisalVtalkId;
    }

    public void setAppraisalVtalkId(Long appraisalVtalkId) {
        this.appraisalVtalkId = appraisalVtalkId;
    }

    public String getAppraisalText() {
        return appraisalText;
    }

    public void setAppraisalText(String appraisalText) {
        this.appraisalText = appraisalText;
    }

    public Integer getCoinLimit() {
        return coinLimit;
    }

    public void setCoinLimit(Integer coinLimit) {
        this.coinLimit = coinLimit;
    }

    public Integer getDistribStatus() {
        return distribStatus;
    }

    public void setDistribStatus(Integer distribStatus) {
        this.distribStatus = distribStatus;
    }

    public Integer getPostMode() {
        return postMode;
    }

    public void setPostMode(Integer postMode) {
        this.postMode = postMode;
    }

    public BigDecimal getStar() {
        return star;
    }

    public void setStar(BigDecimal star) {
        this.star = star;
    }

    public Integer getStarSum() {
        return starSum;
    }

    public void setStarSum(Integer starSum) {
        this.starSum = starSum;
    }

    public Integer getStarUsersCount() {
        return starUsersCount;
    }

    public void setStarUsersCount(Integer starUsersCount) {
        this.starUsersCount = starUsersCount;
    }

    public Integer getCollectedCount() {
        return collectedCount;
    }

    public void setCollectedCount(Integer collectedCount) {
        this.collectedCount = collectedCount;
    }

    public String getTopComments() {
        return topComments;
    }

    public void setTopComments(String topComments) {
        this.topComments = topComments;
    }

    public String getBrandName() {
        return brandName;
    }

    public void setBrandName(String brandName) {
        this.brandName = brandName;
    }

    public Integer getDiscussCount() {
        return discussCount;
    }

    public void setDiscussCount(Integer discussCount) {
        this.discussCount = discussCount;
    }

    public String getShareImgUrl() {
        return shareImgUrl;
    }

    public void setShareImgUrl(String shareImgUrl) {
        this.shareImgUrl = shareImgUrl;
    }

    public Integer getShareImgWidth() {
        return shareImgWidth;
    }

    public void setShareImgWidth(Integer shareImgWidth) {
        this.shareImgWidth = shareImgWidth;
    }

    public Integer getShareImgHeight() {
        return shareImgHeight;
    }

    public void setShareImgHeight(Integer shareImgHeight) {
        this.shareImgHeight = shareImgHeight;
    }

    public String getPurchaseSource() {
        return purchaseSource;
    }

    public void setPurchaseSource(String purchaseSource) {
        this.purchaseSource = purchaseSource;
    }

    public String getStorageType() {
        return storageType;
    }

    public void setStorageType(String storageType) {
        this.storageType = storageType;
    }

    public Integer getProductPrepareDays() {
        return productPrepareDays;
    }

    public void setProductPrepareDays(Integer productPrepareDays) {
        this.productPrepareDays = productPrepareDays;
    }

    public Integer getLogisticsInternaDays() {
        return logisticsInternaDays;
    }

    public void setLogisticsInternaDays(Integer logisticsInternaDays) {
        this.logisticsInternaDays = logisticsInternaDays;
    }

    public String getDeliveryType() {
        return deliveryType;
    }

    public void setDeliveryType(String deliveryType) {
        this.deliveryType = deliveryType;
    }

    public String getWarehouse() {
        return warehouse;
    }

    public void setWarehouse(String warehouse) {
        this.warehouse = warehouse;
    }

    public String getPostageType() {
        return postageType;
    }

    public void setPostageType(String postageType) {
        this.postageType = postageType;
    }
}
