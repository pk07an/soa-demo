package com.meila.soa.meila.client;

import org.apache.commons.lang3.StringUtils;
import org.apache.thrift.protocol.TBinaryProtocol;
import org.apache.thrift.protocol.TProtocol;
import org.apache.thrift.transport.TSocket;
import org.apache.thrift.transport.TTransport;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.meila.common.sms.SmsService;

/**
 * 
 ************************************************************
 * @类名 : SmsClient.java
 *
 * @DESCRIPTION : 发送短信服务类
 * @AUTHOR : gogo
 * @DATE : 2016年5月13日
 ************************************************************
 */
@Service
public class SmsClient {
    @Value("${sms.server.ip}")
    private String SERVER_IP;
    @Value("${sms.server.port}")
    private int SERVER_PORT;
    @Value("${sms.server.timeout}")
    private int TIMEOUT = 30000;

    @Value("${sms.refund.seller.reject}")
    private String CONTENT_REFUND_SELLER_REJECT;
    @Value("${sms.refund.seller.accpect}")
    private String CONTENT_REFUND_SELLER_ACCPECT;

    private static final String CALLER = "meigou";
    private static final String EXT = "1";

    private static final Logger logger = LoggerFactory.getLogger(SmsClient.class);

    /**
     * 
     *
     * 功能描述：发送卖家同意退款短信
     * 
     * @param phoneNum
     * @param orderNo
     * @return boolean
     *
     */
    public void sendSmsBySellerAccpectRefund(String phoneNum, String orderNo) {

        String content = String.format(CONTENT_REFUND_SELLER_ACCPECT, orderNo);

        pushSmsMsg(phoneNum, content);
    }

    /**
     * 
     *
     * 功能描述：发送卖家拒绝退款短信
     * 
     * @param phoneNum
     * @param orderNo
     * @return boolean
     *
     */
    public void sendSmsBySellerRejectRefund(String phoneNum, String orderNo) {

        String content = String.format(CONTENT_REFUND_SELLER_REJECT, orderNo);

        pushSmsMsg(phoneNum, content);
    }

    /**
     * 
     * 发送短信方法
     * 
     * @param phone 手机号码
     * @param replaceValues 替换占位符的map，key为占位符，value为替换的值
     * @return
     */
    private boolean pushSmsMsg(String phone, String content) {
        logger.info("发送短信，手机号码:{}，短信内容:{}", phone, content);
        TTransport transport = null;
        boolean result = false;
        try {

            if (StringUtils.isBlank(phone)) {
                logger.error("发短信的手机号不能为空");
                return result;
            }
            transport = new TSocket(SERVER_IP, SERVER_PORT, TIMEOUT);
            // 协议要和服务端一致
            TProtocol protocol = new TBinaryProtocol(transport);
            SmsService.Client client = new SmsService.Client(protocol);
            transport.open();

            result = client.send_sms(phone, content, EXT, CALLER);
        } catch (Exception e) {
            logger.error("短信推送失败", e);
        } finally {
            if (null != transport) {
                transport.close();
            }
        }
        return result;
    }

}
