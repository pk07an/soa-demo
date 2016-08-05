/**
 * 
 */
package com.meila.soa.order.service;

import javax.annotation.Resource;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.alibaba.fastjson.JSON;
import com.google.common.collect.Lists;
import com.meila.dubbo.base.constant.DubboReturnCode;
import com.meila.soa.order.api.DubboOrderPayService;
import com.meila.soa.order.api.model.request.DubboQueryOutPayMapByPayNosRequest;
import com.meila.soa.order.api.model.response.DubboQueryOutPayMapByPayNosResponse;

/**
 ************************************************************
 * @类名 : DubboOrderPayTest.java
 *
 * @DESCRIPTION :
 * @AUTHOR : gogo
 * @DATE : 2016年6月12日
 ************************************************************
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:dubbo-consumer.xml" })
public class DubboOrderPayTest {
    @Resource
    private DubboOrderPayService dubboOrderPayService;

    @Test
    public void testQueryOutPayMapByPayNos() {
        DubboQueryOutPayMapByPayNosRequest request = new DubboQueryOutPayMapByPayNosRequest();
        request.setPayNos(Lists.newArrayList("P160607180826001006", "P160607170100001016", "P160607165203001004"));
        DubboQueryOutPayMapByPayNosResponse response = dubboOrderPayService.queryOutPayMapByPayNos(request);
        System.out.println(JSON.toJSONString(response));
        Assert.assertEquals(DubboReturnCode.SUCCESS, response.getCode());
    }

    
}
