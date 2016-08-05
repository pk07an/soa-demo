package com.meila.soa.meila.client;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.HttpState;
import org.apache.commons.httpclient.HttpStatus;
import org.apache.commons.httpclient.NameValuePair;
import org.apache.commons.httpclient.methods.PostMethod;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

/**
 * 
 ************************************************************
 * @类名 : PushMessageClient.java
 *
 * @DESCRIPTION : 推送消息服务类
 * @AUTHOR : gogo
 * @DATE : 2016年5月13日
 ************************************************************
 */
@Service
public class PushMessageClient {

    private static final Logger logger = LoggerFactory.getLogger(PushMessageClient.class);

    private static final String charset = "utf-8";
    @Value("${pushmessage.server.host}")
    private String host;
    @Value("${pushmessage.server.path}")
    private String path;

    @Value("${sms.refund.seller.reject}")
    private String CONTENT_REFUND_SELLER_REJECT;
    @Value("${sms.refund.seller.accpect}")
    private String CONTENT_REFUND_SELLER_ACCPECT;

    private static final String SELLER_ACCPECT_SUMMARY = "退款同意通知";
    private static final String SELLER_REJECT_SUMMARY = "退款关闭通知";

    private static final String ORDER_DETAIL_URL = "/m/buyer/order/detail/?orderNo=%s";

    private static final String JUMP_LABEL = "url";

    /**
     * 
     *
     * 功能描述：推送卖家同意退款消息给买家
     * 
     * @param buyerId
     * @param orderNo
     * @return boolean
     *
     */
    public boolean pushMessageBySellerAccpectRefund(String buyerId, String orderNo) {
        String content = String.format(CONTENT_REFUND_SELLER_ACCPECT, orderNo);
        String url = String.format(ORDER_DETAIL_URL, orderNo);

        return pushMessage(buyerId, SELLER_ACCPECT_SUMMARY, content, JUMP_LABEL, url, PushType.TRADE);
    }

    /**
     * 
     *
     * 功能描述：推送卖家拒绝退款消息给买家
     * 
     * @param buyerId
     * @param orderNo
     * @return boolean
     *
     */
    public boolean pushMessageBySellerRejectRefund(String buyerId, String orderNo) {
        String content = String.format(CONTENT_REFUND_SELLER_REJECT, orderNo);
        String url = String.format(ORDER_DETAIL_URL, orderNo);

        return pushMessage(buyerId, SELLER_REJECT_SUMMARY, content, JUMP_LABEL, url, PushType.TRADE);
    }

    /**
     * 功能描述：给指定用户push消息。
     * 
     * @param pushMessage
     * @return
     * @throws IOException user_id(接收用户的id)，summary(消息短描述，小于20字)， content(消息详情)，jump_label(如果跳网页，就传’url’，可不传),
     *             jump_data(如果跳网页，传对应的网址，可不传)
     */
    private boolean pushMessage(String user_id, String summary, String content, String jump_label, String jump_data, PushType msg_group_type) {
        Map<String, String> pushMessage = new HashMap<String, String>();
        pushMessage.put("user_id", user_id);
        pushMessage.put("summary", summary);
        pushMessage.put("content", content);
        pushMessage.put("jump_label", jump_label);
        pushMessage.put("jump_data", jump_data);
        pushMessage.put("msg_group_type", (null == msg_group_type) ? PushType.TRADE.getCode() : msg_group_type.getCode());

        return sendToMeila(pushMessage);
    }

    private boolean sendToMeila(Map<String, String> paramMap) {
        logger.info("给指定用户push消息，参数:{}", JSON.toJSONString(paramMap));
        boolean result = false;
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
                logger.error("给指定用户push消息失败，URL ={} statusCode{}", host, statusCode);
                return result;
            }

            String responseBody = postMethod.getResponseBodyAsString();

            JSONObject json = JSONObject.parseObject(responseBody);
            logger.info("给指定用户push消息返回结果:{}", json);
            if (json.getInteger("ret") == 0) {
                result = true;
            }
        } catch (Exception e) {
            logger.error("给指定用户push消息失败，URL =" + host + "，path=" + path, e);
        } finally {
            if (postMethod != null) {
                postMethod.releaseConnection();
            }
        }

        return result;
    }

    /**
     * 消息推送类型
     */
    public enum PushType {

        VTALK("1", "话题消息通知"), MEILA("2", "美啦通知"), SNS("4", "新好友通知"), CHAT("8", "聊天"), PRIZE("16", "奖品通知"), TRADE("32", "交易通知");

        private final String code;
        private final String type;

        private PushType(String code, String type) {
            this.code = code;
            this.type = type;
        }

        public String getCode() {
            return code;
        }

        public String getType() {
            return type;
        }

    }
}
