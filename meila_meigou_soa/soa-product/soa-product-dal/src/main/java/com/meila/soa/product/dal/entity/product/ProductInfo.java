package com.meila.soa.product.dal.entity.product;

import java.math.BigDecimal;
import java.util.Date;

import com.meila.soa.product.dal.type.PostageType;
import com.meila.soa.product.dal.type.StorageType;

public class ProductInfo {

    /**
     * productInfo ID
     */
    private Long id;

    /**
     * SPU ID
     */
    private Long productId;

    /**
     * 商品属性 1.一般商品 2.秒杀商品
     */
    private Integer property;

    /**
     * 秒杀价格
     */
    private BigDecimal msPrice;

    /**
     * 秒杀开始时间
     */
    private Date startTime;

    /**
     * 秒杀结束时间
     */
    private Date endTime;

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
     * 评论数量
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
     * 审核状态 0, 待审核 9,审核失败 5,被举报 2,可疑，仅发表者可见 1,审核通过
     */
    private Short verify;
    /**
     * 是否需要M码
     */
    private Boolean needMcode;
    /**
     * 输入M码上面的提示文本
     */
    private String mcodeTip;
    /**
     * 限购数量
     */
    private Integer buyLimitCount;
    /**
     * 绑定的话题id
     */
    private Integer vtalkId;
    /**
     * 小编鉴定话题
     */
    private Integer appraisalVtalkId;
    /**
     * 小编鉴定显示文本
     */
    private String appraisalText;
    /**
     * 买一件能够兑换的美币数量
     */
    private Short coinLimit;
    /**
     * 分销状态 1,自营 2,分销
     */
    private Short distribStatus;
    /**
     * 发货模式: 1.卖家自发 2.美啦代发
     */
    private Integer postMode;
    /**
     * 星级
     */
    private BigDecimal star;
    /**
     * 评星数量
     */
    private Integer starSum;
    /**
     * 评星用户数量
     */
    private Integer starUsersCount;
    /**
     * 收藏的数量
     */
    private Integer collectedCount;
    /**
     * 评论数量
     */
    private Integer commentedCount;
    /**
     * 
     */
    private String topComments;
    /**
     * 商标名称
     */
    private String brandName;
    /**
     * 讨论数量
     */
    private Integer discussCount;
    /**
     * 分享图片
     */
    private String shareImg;
    /**
     * 分享图片宽度
     */
    private Integer shareImgWidth;
    /**
     * 分享图片高度
     */
    private Integer shareImgHeight;
    /**
     * 创建时间
     */
    private Date createdAt;
    /**
     * 最后更新时间
     */
    private Date updatedAt;
    /**
     * 采购地 国家或者地区
     */
    private String purchaseSource;
    /**
     * 库存类型 SPOT:现货, NON_SPOT:非现货
     */
    private StorageType storageType;
    /**
     * 备货天数
     */
    private Integer productPrepareDays;
    /**
     * 国际物流天数
     */
    private Integer logisticsInternaDays;
    /**
     * 发货方式: SELLER:卖家自发(非保税仓),BONDED_AREA:卖家自发(卖家保税仓), MEILA:美啦国内发货(美啦西丽WMS代发), BONDED_AREA_ML:美啦保税仓,
     * HONGKONG_ML:美啦香港直发
     */
    private String deliveryType;
    /**
     * 发货仓库: LOCAL_XILI:西丽, BONDED_AREA_GUANGZHOU:广州保税仓, BONDED_AREA_NINGBO:宁波保税仓, HONGKONG:香港a
     */
    private String warehouse;

    /**
     * 包邮类型
     */
    private PostageType postageType;

    /**
     * 商品类型 NORMAL:普通商品 ERP:erp商品
     */
    private String productType;

    public String getProductType() {
        return productType;
    }

    public void setProductType(String productType) {
        this.productType = productType;
    }

    public PostageType getPostageType() {
        return postageType;
    }

    public void setPostageType(PostageType postageType) {
        this.postageType = postageType;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

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

    public Short getVerify() {
        return verify;
    }

    public void setVerify(Short verify) {
        this.verify = verify;
    }

    public Boolean getNeedMcode() {
        return needMcode;
    }

    public void setNeedMcode(Boolean needMcode) {
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

    public Integer getVtalkId() {
        return vtalkId;
    }

    public void setVtalkId(Integer vtalkId) {
        this.vtalkId = vtalkId;
    }

    public Integer getAppraisalVtalkId() {
        return appraisalVtalkId;
    }

    public void setAppraisalVtalkId(Integer appraisalVtalkId) {
        this.appraisalVtalkId = appraisalVtalkId;
    }

    public String getAppraisalText() {
        return appraisalText;
    }

    public void setAppraisalText(String appraisalText) {
        this.appraisalText = appraisalText;
    }

    public Short getCoinLimit() {
        return coinLimit;
    }

    public void setCoinLimit(Short coinLimit) {
        this.coinLimit = coinLimit;
    }

    public Short getDistribStatus() {
        return distribStatus;
    }

    public void setDistribStatus(Short distribStatus) {
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

    public Integer getCommentedCount() {
        return commentedCount;
    }

    public void setCommentedCount(Integer commentedCount) {
        this.commentedCount = commentedCount;
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

    public String getShareImg() {
        return shareImg;
    }

    public void setShareImg(String shareImg) {
        this.shareImg = shareImg;
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

    public String getPurchaseSource() {
        return purchaseSource;
    }

    public void setPurchaseSource(String purchaseSource) {
        this.purchaseSource = purchaseSource;
    }

    public StorageType getStorageType() {
        return storageType;
    }

    public void setStorageType(StorageType storageType) {
        this.storageType = storageType;
    }

    public Integer getProductPrepareDays() {
        if (null == productPrepareDays) {
            return 0;
        }
        return productPrepareDays;
    }

    public void setProductPrepareDays(Integer productPrepareDays) {
        this.productPrepareDays = productPrepareDays;
    }

    public Integer getLogisticsInternaDays() {
        if (null == logisticsInternaDays) {
            return 0;
        }
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
}
