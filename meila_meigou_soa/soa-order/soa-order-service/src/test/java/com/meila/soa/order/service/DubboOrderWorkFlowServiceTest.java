package com.meila.soa.order.service;

import javax.annotation.Resource;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.alibaba.fastjson.JSON;
import com.meila.dubbo.base.constant.DubboReturnCode;
import com.meila.soa.order.api.DubboOrderWorkFlowService;
import com.meila.soa.order.api.model.request.DubboExecuteSellerAcceptRefundRequest;
import com.meila.soa.order.api.model.response.DubboExecuteSellerAcceptRefundResponse;

/**
 * 
 ************************************************************
 * @类名 : DubboOrderWorkFlowServiceTest.java
 *
 * @DESCRIPTION : 工作流测试用例
 * @AUTHOR :  gogo
 * @DATE :  2016年5月16日
 ************************************************************
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:dubbo-consumer.xml" })
public class DubboOrderWorkFlowServiceTest {

    @Resource
    private DubboOrderWorkFlowService dubboOrderWorkFlowService;
    
    public void ship()
    {
    }
    
    @Test
    public void executeSellerAcceptRefund()
    {
        DubboExecuteSellerAcceptRefundRequest request = new DubboExecuteSellerAcceptRefundRequest();
        request.setOrderId(90558819L);
        DubboExecuteSellerAcceptRefundResponse response = dubboOrderWorkFlowService.executeSellerAcceptRefund(request);

        System.out.println("executeSellerAcceptRefund:----" + JSON.toJSONString(response));
        Assert.assertEquals(DubboReturnCode.SUCCESS, response.getCode());
    }
    
}
