package com.meila.soa.meila.client.model;

import java.math.BigDecimal;

/**
 * 社区上报数据MODEL
 * 
 * @author yongqi
 */
public class OnPurchaseModel {

    private String action; // 操作的名字viewware(商品详情), addtocart(添加到购物车),
                           // rmfromcart(移除商品)，viewcart(浏览购物车),confirmorder(订单确认页)
    private String userId; // (int形)社区userid，可以通过鉴权接口获取
    private String source; // 来源,app接口传空字符串,web传’web’
    private String refer; // 当action为viewcart, confirmorder时，才有此参数，index-美购首页，ware-商品详情页，cart-购物车页
    private Integer num; // 当action为addtocart时，有此参数，代表添加的商品数量
    private BigDecimal unitPrice; // 当action为addtocart时有此参数
    private Long wareId; // (int形)： 当action为viewware，addtocart，rmfromcart时有此参数
    private Long skuId; // (int形): 当action为addtocart，rmfromcart时有此参数
    private Integer count; // 当action为viewcart时有此参数，代表购物车中商品的数量
    private BigDecimal totalPrice; // 当action为confirmorder时有此参数，代表总金额
    private String utmChannel;
    private String utmActivity;
    private String inChannel;

    private BigDecimal paidPrice; // 代表订单需要支付的金额
    private int payType; // 代表选择的支付类型
    private String payNo; // 代表支付单号

    private String from_source;// 来源

    public OnPurchaseModel() {

    }

    public OnPurchaseModel(String action, String userId, String source, String refer, Integer num, BigDecimal unitPrice, Long wareId, Long skuId,
            Integer count, BigDecimal totalPrice, String utmChannel, String utmActivity, String inChannel) {
        this.action = action;
        this.userId = userId;
        this.source = source;
        this.refer = refer;
        this.num = num;
        this.unitPrice = unitPrice;
        this.wareId = wareId;
        this.skuId = skuId;
        this.count = count;
        this.totalPrice = totalPrice;
        this.utmChannel = utmChannel;
        this.utmActivity = utmActivity;
        this.inChannel = inChannel;
    }

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public String getRefer() {
        return refer;
    }

    public void setRefer(String refer) {
        this.refer = refer;
    }

    public Integer getNum() {
        return num;
    }

    public void setNum(Integer num) {
        this.num = num;
    }

    public BigDecimal getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(BigDecimal unitPrice) {
        this.unitPrice = unitPrice;
    }

    public Long getWareId() {
        return wareId;
    }

    public void setWareId(Long wareId) {
        this.wareId = wareId;
    }

    public Long getSkuId() {
        return skuId;
    }

    public void setSkuId(Long skuId) {
        this.skuId = skuId;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public BigDecimal getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(BigDecimal totalPrice) {
        this.totalPrice = totalPrice;
    }

    public String getUtmChannel() {
        return utmChannel;
    }

    public void setUtmChannel(String utmChannel) {
        this.utmChannel = utmChannel;
    }

    public String getUtmActivity() {
        return utmActivity;
    }

    public void setUtmActivity(String utmActivity) {
        this.utmActivity = utmActivity;
    }

    public String getInChannel() {
        return inChannel;
    }

    public void setInChannel(String inChannel) {
        this.inChannel = inChannel;
    }

    public String getPayNo() {
        return payNo;
    }

    public void setPayNo(String payNo) {
        this.payNo = payNo;
    }

    public int getPayType() {
        return payType;
    }

    public void setPayType(int payType) {
        this.payType = payType;
    }

    public BigDecimal getPaidPrice() {
        return paidPrice;
    }

    public void setPaidPrice(BigDecimal paidPrice) {
        this.paidPrice = paidPrice;
    }

    public String getFrom_source() {
        return from_source;
    }

    public void setFrom_source(String from_source) {
        this.from_source = from_source;
    }

}
