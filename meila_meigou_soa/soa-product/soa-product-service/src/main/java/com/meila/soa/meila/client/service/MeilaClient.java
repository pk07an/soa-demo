package com.meila.soa.meila.client.service;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Objects;

import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.HttpState;
import org.apache.commons.httpclient.HttpStatus;
import org.apache.commons.httpclient.NameValuePair;
import org.apache.commons.httpclient.methods.PostMethod;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Lazy;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.converter.FormHttpMessageConverter;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestClientException;

import com.alibaba.fastjson.JSONObject;
import com.meila.soa.meila.client.model.GenShareImgResponse;
import com.meila.soa.meila.client.model.MeilaUser;
import com.meila.soa.meila.client.model.OnPurchaseModel;
import com.meila.soa.product.service.exceptions.BizException;
import com.meila.soa.product.service.exceptions.GlobalErrorCode;
import com.meila.soa.product.service.utils.MeiLaRestTemplate;

@Service("meilaClient")
public class MeilaClient {

    private static Logger LOG = LoggerFactory.getLogger(MeilaClient.class);

    // 这个地址是app接口权限校验，下单，支付成功通知接口等
    @Value("${meila.check.req.host}")
    private String checkReqHost;

    private String checkReqUrl = "/ouer/check_req";

    private String getUserUrl = "/ouer/user_info/";

    private String getUsersUrl = "/ouer/users_info?user_id=";

    private String getUserUrlByName = "/ouer/search_user?q=%s&offset=%s&limit=%s";

    private String productUpdateToMeila = "/ouer/update_es_ware";

    private String newWareCommentUrl = "/ouer/new_ware_comment";

    private String wareSnsInfo = "/ouer/ware_sns_info";

    private String wareCollectedCount = "/ouer/ware_collected_count";

    private String doOrderPayUrl = "/ouer/on_order_pay";

    private String weixinCardConsumUrl = "/ouer/weixin/card/consume/";

    private static final String CART_ITEM_SOLDOUT_URL = "/ouer/goods_sold_out_count"; // 售罄
    private static final String CART_ITEM_DOWN_URL = "/ouer/goods_price_off_count"; // 降价

    private String onPurchaseActionUrl = "/ouer/on_purchase_action?action=%s&user_id=%s&source=%s&refer=%s&num=%s&unit_price=%s&ware_id=%s&sku_id=%s&count=%s&total_price=%s&utm_channel=%s&utm_activity=%s&in_channel=%s&paid_price=%s&pay_type=%s&pay_no=%s&from_source=%s";

    @Autowired
    @Lazy
    private MeiLaRestTemplate meiLaRestTemplate;

    private static String charset = "utf-8";

    //// 这个只是用于web的获取请求用户信息
    @Value("${meila.client.host2}")
    private String meilaClientHost2;

    @Value("${meila.client.get_user_by_header}")
    private String getUserByHeader;

    private String addCollectUrl = "/collect/add/";
    private String delCollectUrl = "/collect/del/";
    private String userLikeUrl = "/ware/%s/userlike/";

    private String wareDiscussListUrl = "/ouer/ware_discuss_list";
    private String notifySNSOrder = "/ouer/on_new_order_v2";
    private String notifySNSPay = "/ouer/on_order_pay_v2";
    private String updateMeigouFlag = "/ouer/update_meigou_flag";
    private String pushMessageUrl = "/ouer/push_message";

    @Value("${shequ.gen_ware_share_img.url}")
    private String shequGenWareShareImgUrl;

    @Value("${site.web.host.name}")
    private String SITE_WEB_HOST_NAME;

    /** 社区Host URL */
    @Value("${meila.community.host.url}")
    private String MEILA_COMMUNITY_HOST_URL;

    /** 获取商品关联的妆品URL */
    @Value("${meila.community.get.relate.cosmetic.url}")
    private String MEILA_COMMUNITY_GET_RELATE_COSMETIC_URL;

    /** 妆品搜索URL */
    @Value("${meila.community.get.cosmetic.url}")
    private String MEILA_COMMUNITY_GET_COSMETIC_URL;

    @Value("${meila.community.relate.cosmetic.url}")
    private String MEILA_COMMUNITY_RELATE_COSMETIC_URL;

    @Value("${meila.community.remove.relate.cosmetic.url}")
    private String MEILA_COMMUNITY_REMOVE_RELATE_COSMETIC_URL;

    private JSONObject parseMeilaResult(JSONObject json) {
        if (json.getString("ret").equals("0")) {
            return json.getJSONObject("data");
        } else if (json.getString("ret").equals("-1")) {
            throw new BizException(GlobalErrorCode.MEILA_CHECK_REQ_ERROR, json.getString("msg"));
        } else if (json.getString("ret").equals("1")) {
            throw new BizException(GlobalErrorCode.MEILA_CHECK_REQ_ERROR, json.getString("msg"));
        } else {
            LOG.error("解析用户信息失败" + json);
            throw new BizException(GlobalErrorCode.UNKNOWN, json.getString("msg"));
        }
    }

    public MeilaUser getUserInfo(String id) {
        String gateway = checkReqHost + getUserUrl + id;
        String res = meiLaRestTemplate.getForObject(gateway, String.class);
        JSONObject json = JSONObject.parseObject(res);
        JSONObject data = parseMeilaResult(json);
        MeilaUser user = JSONObject.parseObject(data.getString("user"), MeilaUser.class);
        // if(json.getIntValue("ret")==0){
        // String data = json.getJSONObject("data").getString("user");
        // user = JSONObject.parseObject(data, MeilaUser.class);
        // } else if (json.getIntValue("ret") == -1) {
        // throw new BizException(GlobalErrorCode.MEILA_CHECK_REQ_ERROR,
        // json.getString("msg"));
        // } else if (json.getIntValue("ret") == 1) {
        // throw new BizException(GlobalErrorCode.MEILA_CHECK_REQ_ERROR,
        // json.getString("msg"));
        // }
        if (user != null) {
            user.setId(id);
        }
        return user;
    }

    public Map<String, MeilaUser> getUsersInfo(List<String> ids) {
        long startTime = System.currentTimeMillis();

        if (null == ids || ids.size() <= 0) {
            return null;
        }
        if (ids.size() > 100) {
            throw new BizException(GlobalErrorCode.UNKNOWN, "不能超过100个");
        }
        StringBuilder sb = new StringBuilder();
        for (String id : ids) {
            sb.append(id).append(",");
        }
        sb.deleteCharAt(sb.length() - 1);

        String gateway = checkReqHost + getUsersUrl + sb.toString();
        String res = null;

        try {
            res = meiLaRestTemplate.getForObject(gateway, String.class);
            JSONObject json = JSONObject.parseObject(res);
            JSONObject data = parseMeilaResult(json);

            Map<String, Object> map = (Map<String, Object>) JSONObject.parse(data.getString("users"));

            Map<String, MeilaUser> userMap = new HashMap<>();
            for (String id : map.keySet()) {
                userMap.put(id, JSONObject.parseObject(map.get(id).toString(), MeilaUser.class));
            }

            long time = System.currentTimeMillis() - startTime;
            LOG.debug("根据id批量获取用户成功   ids=[" + sb.toString() + "], res=[" + res + "], time: " + time);
            if (time > 200) {
                LOG.warn("根据id批量获取用户时间超长:  " + time + " ms.");
            }
            return userMap;
        } catch (Exception e) {
            String msg = "根据id批量获取用户失败 gateway=[" + gateway + "], res=[" + res + "], message: [" + e.getMessage() + "]";
            LOG.error(msg, e);
            throw new BizException(GlobalErrorCode.UNKNOWN, msg, e);
        }
    }

    /**
     * 根据用户昵称在查询社区的用户
     * 
     * @param name
     * @return
     */
    public List<MeilaUser> getUserInfoByName(String name) {
        long startTime = System.currentTimeMillis();
        String gateway = checkReqHost + String.format(getUserUrlByName, name, "0", "50");
        String res = null;
        try {
            res = meiLaRestTemplate.getForObject(gateway, String.class);
            JSONObject json = JSONObject.parseObject(res);
            JSONObject data = parseMeilaResult(json);
            List<MeilaUser> userList = JSONObject.parseArray(data.getString("users"), MeilaUser.class);
            long time = System.currentTimeMillis() - startTime;
            LOG.debug("根据昵称获取用户成功   name=[" + name + "], res=[" + res + "], time: " + time);
            if (time > 200) {
                LOG.warn("根据昵称获取用户时间超长:  " + time + " ms.");
            }
            return userList;
        } catch (Exception e) {
            String msg = "根据昵称获取用户失败 gateway=[" + gateway + "], res=[" + res + "], message: [" + e.getMessage() + "]";
            LOG.error(msg, e);
            throw new BizException(GlobalErrorCode.UNKNOWN, msg, e);
        }
    }

    public Map<String, String> getNewWareCommentUrl(String userId, String commentId, String hasImg) throws Exception {
        // String gateway = checkReqHost + newWareCommentUrl;
        Map<String, String> map = new HashMap<String, String>();
        map.put("user_id", userId);
        map.put("comment_id", commentId);
        map.put("has_img", hasImg);
        String res = doPostMethod(checkReqHost, newWareCommentUrl, map);
        // String res = restTemplate.getForObject(gateway, String.class);
        LOG.info(res);
        Map<String, String> result = new HashMap<String, String>();
        JSONObject json = JSONObject.parseObject(res);
        JSONObject data = parseMeilaResult(json);
        result.put("gain_score_msg", data.getString("gain_score_msg"));
        result.put("gain_new_level", data.getString("gain_new_level"));
        result.put("gain_score_count", data.getString("gain_score_count"));
        // if(json.getIntValue("ret")==0){
        // result.put("gain_score_msg", json.getJSONObject("data").getString("gain_score_msg"));
        // result.put("gain_new_level", json.getJSONObject("data").getString("gain_new_level"));
        // result.put("gain_score_count", json.getJSONObject("data").getString("gain_score_count"));
        // }else{
        // result.put("gain_score_msg", "");
        // result.put("gain_new_level", "");
        // result.put("gain_score_count", "");
        // }
        return result;
    }

    public Long wareCollectedCount(String ware_id, String user_id) {
        String gateway = checkReqHost + wareCollectedCount + "?ware_id=" + ware_id + "&user_id" + user_id;
        String res = meiLaRestTemplate.getForObject(gateway, String.class);
        LOG.info(res);
        JSONObject json = JSONObject.parseObject(res);
        JSONObject data = parseMeilaResult(json);
        Long result = JSONObject.parseObject(data.getString("collected_count"), Long.class);
        return result;
    }

    public String doPostMethod(String host, String path, Map<String, String> paramMap) {
        HttpClient client = new HttpClient();
        client.getHttpConnectionManager().getParams().setConnectionTimeout(60000);
        client.getHttpConnectionManager().getParams().setSoTimeout(60000);
        // cookie
        HttpState state = new HttpState();
        client.setState(state);
        PostMethod postMethod = null;
        try {
            postMethod = new PostMethod(host);
            postMethod.addRequestHeader("Connection", "close");
            postMethod.setPath(path);
            postMethod.getParams().setContentCharset(charset);
            List<NameValuePair> list = new ArrayList<NameValuePair>();
            String name = null;
            String value = null;
            Iterator<String> it = paramMap.keySet().iterator();
            while (it.hasNext()) {
                name = it.next();
                value = paramMap.get(name);
                NameValuePair pair = new NameValuePair(name, value);
                list.add(pair);
            }
            NameValuePair[] pairs = list.toArray(new NameValuePair[0]);
            postMethod.setRequestBody(pairs);
            int statusCode = client.executeMethod(postMethod);
            if (statusCode != HttpStatus.SC_OK) {
                LOG.error("请求美啦校验逻辑接口失败，URL ={} statusCode{}", host, statusCode);
                throw new Exception("请求美啦校验逻辑接口失败，URL =" + host + "，path=" + path);
            }
            return postMethod.getResponseBodyAsString();
        } catch (Exception e) {
            LOG.error("请求美啦校验逻辑接口失败，URL =" + host + "，path=" + path, e);
            throw new BizException(GlobalErrorCode.UNKNOWN, e);
        } finally {
            if (postMethod != null) {
                postMethod.releaseConnection();
            }
        }
    }

    /**
     * 功能描述：订单提交后需要通知社区
     * 
     * @param sourceMap
     * @throws IOException
     * @throws RestClientException
     */
    public Boolean notifySNSOrder(String order_data) throws RestClientException, IOException {
        Map<String, String> orderMap = new HashMap<String, String>();
        orderMap.put("order_data", order_data);
        String res = doPostMethod(checkReqHost, notifySNSOrder, orderMap);
        LOG.info(" 订单提交成功通知社区 notifySNSOrder {}", new Object[] { res });
        JSONObject json = JSONObject.parseObject(res);
        if (json.getInteger("ret") == 0) {
            return true;
        }
        return false;
    }

    /**
     * 功能描述：支付成功后需要通知社区
     * 
     * @param sourceMap
     * @throws IOException
     * @throws RestClientException
     */
    public Boolean notifySNSPay(String order_data) throws RestClientException, IOException {
        Map<String, String> orderMap = new HashMap<String, String>();
        orderMap.put("order_data", order_data);
        String res = doPostMethod(checkReqHost, notifySNSPay, orderMap);
        LOG.info(" 订单支付成功通知社区 notifySNSPay {}", new Object[] { res });
        JSONObject json = JSONObject.parseObject(res);
        if (json.getInteger("ret") == 0) {
            return true;
        }
        return false;
    }

    /**
     * 功能描述：支付成功后需要通知社区
     * 
     * @param sourceMap
     * @throws IOException
     * @throws RestClientException
     */
    public Boolean updateMeigouFlag(Map<String, String> data) throws RestClientException, IOException {
        String res = doPostMethod(checkReqHost, updateMeigouFlag, data);
        LOG.info("订单支付成功通知社区用户已下订单 updateMeigouFlag {}", new Object[] { res });
        JSONObject json = JSONObject.parseObject(res);
        if (json.getInteger("ret") == 0) {
            return true;
        }
        return false;
    }

    /**
     * 功能描述：微信优惠券活动卡注销。
     * 
     * @param order_data
     * @return
     * @throws RestClientException
     * @throws IOException
     */
    public Boolean weixinCardConsum(Map<String, String> consumData) throws RestClientException, IOException {
        String res = doPostMethod(meilaClientHost2, weixinCardConsumUrl, consumData);
        LOG.info(" 微信优惠券活动卡注销 weixinCardConsum {}", new Object[] { res });
        JSONObject json = JSONObject.parseObject(res);
        if (json.getInteger("errcode") == 0) {
            return true;
        }
        return false;
    }

    /**
     * 商品变更通知社区搜索
     * 
     * @param productId
     */
    public void noticeProductUpdateToMeila(Long productId) {
        StringBuilder gateway = new StringBuilder(checkReqHost + productUpdateToMeila);
        String res = null;
        try {
            gateway.append("?id=").append(productId);
            LOG.debug("通知社区商品变更: gateway=[" + gateway + "]");
            res = meiLaRestTemplate.postForObject(gateway.toString(), null, String.class);
            LOG.info("通知社区商品变更返回: " + res);
        } catch (Exception e) {
            LOG.error("通知社区商品变更失败: gateway=[" + gateway + "], res=[" + res + "]", e);
            e.printStackTrace();
        }
    }

    /**
     * 功能描述：给指定用户push消息。
     * 
     * @param pushMessage
     * @return
     * @throws RestClientException
     * @throws IOException user_id(接收用户的id)，summary(消息短描述，小于20字)， content(消息详情)，jump_label(如果跳网页，就传’url’，可不传),
     *             jump_data(如果跳网页，传对应的网址，可不传)
     */

    public void doCartItemSoldoutToMeila(String userId, int count) {
        try {
            Map<String, String> map = new HashMap<String, String>();
            map.put("user_id", userId);
            map.put("count", String.valueOf(count));
            String res = doPostMethod(checkReqHost, CART_ITEM_SOLDOUT_URL, map);
            JSONObject json = JSONObject.parseObject(res);
            String ret = json.getString("ret");
            if (!"0".equals(ret)) {
                throw new BizException(GlobalErrorCode.INTERNAL_ERROR, "调用购物车售罄置数接口失败");
            }
        } catch (Exception ex) {
            LOG.error("调用购物车售罄置数接口失败", ex);
        }
    }

    public void doCartItemDownToMeila(String userId, int count) {
        try {
            Map<String, String> map = new HashMap<String, String>();
            map.put("user_id", userId);
            map.put("count", String.valueOf(count));
            String res = doPostMethod(checkReqHost, CART_ITEM_DOWN_URL, map);
            JSONObject json = JSONObject.parseObject(res);
            String ret = json.getString("ret");
            if (!"0".equals(ret)) {
                throw new BizException(GlobalErrorCode.INTERNAL_ERROR, "调用购物车降价置数接口失败");
            }
        } catch (Exception ex) {
            LOG.error("调用购物车降价置数接口失败", ex);
        }
    }

    /**
     * 获取商品分享的二维码图片
     * 
     * @param id
     * @param slug
     * @param name
     * @param price
     * @param mainImg
     * @param purchaseSource
     * @param shippingText
     * @return
     */
    public GenShareImgResponse genShareImgForProduct(Long id, String slug, String name, BigDecimal price, String mainImg, String purchaseSource,
        String shippingText) {

        StringBuilder gateway = new StringBuilder(shequGenWareShareImgUrl);

        /*
         * Map<String, String> param = new HashMap<String, String>(); param.put("id", String.valueOf(id));
         * param.put("slug", String.valueOf(slug)); param.put("name", name); param.put("price", String.valueOf(price));
         * param.put("banner_url", mainImg); param.put("is_shipping", "true");
         * 
         * if (StringUtils.isNoneBlank(purchaseSource)) { StringBuilder sb = new StringBuilder();
         * sb.append(SITE_WEB_HOST_NAME);
         * 
         * if(!StringUtils.endsWith(SITE_WEB_HOST_NAME, "/")) { sb.append("/"); }
         * 
         * sb.append("res_mgi/web/images/mobile/ware_detail/"); sb.append(purchaseSource); sb.append(".jpg");
         * 
         * param.put("purchase_source_url", sb.toString()); }
         * 
         * param.put("shipping_text", shippingText); String res = doPostMethod(gateway.toString(), null, param);
         */

        LOG.debug("获取分享二维码: " + gateway);

        try {

            HttpHeaders headers = new HttpHeaders();

            MultiValueMap<String, String> parameters = new LinkedMultiValueMap<String, String>();

            parameters.add("id", String.valueOf(id));
            parameters.add("slug", String.valueOf(slug));
            parameters.add("name", name);
            parameters.add("price", String.valueOf(price));
            parameters.add("banner_url", mainImg);

            // 包邮标识
            parameters.add("is_shipping", "true");

            // 采购地
            if (StringUtils.isNoneBlank(purchaseSource)) {
                StringBuilder sb = new StringBuilder();
                sb.append(SITE_WEB_HOST_NAME);

                if (!StringUtils.endsWith(SITE_WEB_HOST_NAME, "/")) {
                    sb.append("/");
                }

                sb.append("res_mgi/web/images/mobile/ware_detail/");
                sb.append(purchaseSource);
                sb.append(".jpg");

                parameters.add("purchase_source_url", sb.toString());
            }

            // 发货方式
            parameters.add("shipping_text", shippingText);

            HttpMessageConverter<String> stringConverter = new StringHttpMessageConverter();
            FormHttpMessageConverter formConverter = new FormHttpMessageConverter();
            List<HttpMessageConverter<?>> msgConverters = new ArrayList<HttpMessageConverter<?>>();
            msgConverters.add(formConverter);
            msgConverters.add(stringConverter);
            meiLaRestTemplate.setMessageConverters(msgConverters);

            headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);

            HttpEntity<MultiValueMap<String, String>> request = new HttpEntity<MultiValueMap<String, String>>(parameters, headers);

            String res = meiLaRestTemplate.postForObject(gateway.toString(), request, String.class);

            LOG.info("获取分享二维码: " + res);

            JSONObject json = JSONObject.parseObject(res);
            GenShareImgResponse imgResponse = json.getObject("data", GenShareImgResponse.class);
            return imgResponse;

        } catch (Exception e) {
            throw new BizException(GlobalErrorCode.INTERNAL_ERROR, "调用社区接口失败");
        }

    }

    /**
     * 详情页，购物流程各环节上报社区数据
     * 
     * @return
     */
    public Boolean doOnPurchaseToMeila(OnPurchaseModel model) {
        String gateway = null;
        String res = null;
        try {
            if (null == model) {
                return Boolean.FALSE;
            }
            String action = Objects.toString(model.getAction(), "");
            String userId = Objects.toString(model.getUserId(), "");
            String source = Objects.toString(model.getSource(), "");
            String refer = Objects.toString(model.getRefer(), "");
            String num = Objects.toString(model.getNum(), "");
            String unitPrice = Objects.toString(model.getUnitPrice(), "");
            String wareId = Objects.toString(model.getWareId(), "");
            String skuId = Objects.toString(model.getSkuId(), "");
            String count = Objects.toString(model.getCount(), "");
            String totalPrice = Objects.toString(model.getTotalPrice(), "");
            String utmChannel = Objects.toString(model.getUtmChannel(), "");
            String utmActivity = Objects.toString(model.getUtmActivity(), "");
            String inChannel = Objects.toString(model.getInChannel(), "");

            String paidPrice = Objects.toString(model.getPaidPrice(), "");
            String payType = Objects.toString(model.getPayType(), "");
            String payNo = Objects.toString(model.getPayNo(), "");
            String from_source = Objects.toString(model.getFrom_source(), "");

            gateway = String.format(checkReqHost + onPurchaseActionUrl, action, userId, source, refer, num, unitPrice, wareId, skuId, count,
                totalPrice, utmChannel, utmActivity, inChannel, paidPrice, payType, payNo, from_source);

            LOG.debug("向社区上报购物流程访问数据: gateway=[" + gateway + "]");
            res = meiLaRestTemplate.postForObject(gateway, null, String.class);
            LOG.debug("向社区上报购物流程访问数据: " + res);

            return Boolean.TRUE;
        } catch (Exception e) {
            LOG.error("向社区上报购物流程访问数据: gateway=[" + gateway + "], res=[" + res + "]", e);
            return Boolean.FALSE;
        }
    }

}
