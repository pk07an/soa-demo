package com.meila.soa.order.service;

import javax.annotation.Resource;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.alibaba.fastjson.JSONObject;
import com.meila.dubbo.base.constant.DubboReturnCode;
import com.meila.soa.order.api.DubboOrderStatService;
import com.meila.soa.order.api.model.request.DubboOrderStatusStatRequest;
import com.meila.soa.order.api.model.response.DubboOrderStatusStatResponse;
import com.meila.soa.order.api.model.response.DubboYesterdayOrderResponse;

/**
 ************************************************************
 * @类名 : DubboOrderStatServiceTest.java
 *
 * @DESCRIPTION :
 * @AUTHOR : yognqi
 * @DATE : 2016年5月20日
 ************************************************************
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:dubbo-consumer.xml" })
public class DubboOrderStatServiceTest {
    @Resource
    private DubboOrderStatService dubboOrderStatService;

    @Test
    public void testQueryOrderStatByStatus() {
        
        System.out.println("===DubboOrderStatServiceTest # testQueryOrderStatByStatus in.");
        
        DubboOrderStatusStatRequest request = new DubboOrderStatusStatRequest();
        request.setSellerId(1359374L);
        DubboOrderStatusStatResponse response = dubboOrderStatService.queryOrderStatByStatus(request);
        System.out.println("response: " + JSONObject.toJSONString(response));

        Assert.assertEquals(DubboReturnCode.SUCCESS, response.getCode());
        
    }
    @Test
    public void testQueryYesterdayOrder() {
        
        System.out.println("===DubboOrderStatServiceTest # testQueryYesterdayOrder in.");
        
        DubboOrderStatusStatRequest request = new DubboOrderStatusStatRequest();
        request.setSellerId(1134122L);
        
        DubboYesterdayOrderResponse response = dubboOrderStatService.queryOrderStatYesterdayOrder(request);
        System.out.println("response: " + JSONObject.toJSONString(response));
        
        Assert.assertEquals(DubboReturnCode.SUCCESS, response.getCode());
        
        
        
    }

    
}
