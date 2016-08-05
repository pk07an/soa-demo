package com.meila.soa.order.service;

import javax.annotation.Resource;
import javax.validation.constraints.NotNull;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.alibaba.fastjson.JSON;
import com.meila.dubbo.base.constant.DubboReturnCode;
import com.meila.soa.order.api.DubboOrderAddressService;
import com.meila.soa.order.api.model.request.DubboQueryOrderAddressAllZoneListRequest;
import com.meila.soa.order.api.model.request.DubboQueryOrderAddressInfoByOrderIdRequest;
import com.meila.soa.order.api.model.request.DubboUpdateAddressRequest;
import com.meila.soa.order.api.model.response.DubboQueryOrderAddressAllZoneListResponse;
import com.meila.soa.order.api.model.response.DubboQueryOrderAddressInfoByOrderIdResponse;
import com.meila.soa.order.api.model.response.DubboUpdateAddressResponse;

/**
 * 
 ************************************************************
 * @类名 : DubboOrderAddressServiceTest.java
 *
 * @DESCRIPTION : 地址用例
 * @AUTHOR :  gogo
 * @DATE :  2016年5月16日
 ************************************************************
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:dubbo-consumer.xml" })
public class DubboOrderAddressServiceTest {

    @Resource
    private DubboOrderAddressService dubboOrderAddressService;
    
    @Test
    public void updateAddress()
    {
        DubboUpdateAddressRequest request = new DubboUpdateAddressRequest();
        request.setOrderId(7L);
        request.setZoneId(1011L);
        request.setConsignee("gogo哥");
        request.setStreet("A栋4楼");
        request.setPhone("99123");
        request.setIdCard("440583789789789");
        
        DubboUpdateAddressResponse response = dubboOrderAddressService.updateAddress(request);
        System.out.println(JSON.toJSONString(response));
        Assert.assertEquals(DubboReturnCode.SUCCESS, response.getCode());
    }
    
    @Test
    public void queryOrderAddressInfoByOrderId()
    {
        DubboQueryOrderAddressInfoByOrderIdRequest request = new DubboQueryOrderAddressInfoByOrderIdRequest();
        request.setOrderId(7L);
        
        DubboQueryOrderAddressInfoByOrderIdResponse response = dubboOrderAddressService.queryOrderAddressInfoByOrderId(request);
        System.out.println("queryOrderAddressInfoByOrderId----" + JSON.toJSONString(response));
        Assert.assertEquals(DubboReturnCode.SUCCESS, response.getCode());
    }
    
    @Test
    public void queryOrderAddressAllZoneList()
    {
        DubboQueryOrderAddressAllZoneListRequest request = new DubboQueryOrderAddressAllZoneListRequest();
        
        DubboQueryOrderAddressAllZoneListResponse response = dubboOrderAddressService.queryOrderAddressAllZoneList(request);
        System.out.println("queryOrderAddressAllZoneList----" + JSON.toJSONString(response));
        Assert.assertEquals(DubboReturnCode.SUCCESS, response.getCode());
    }
}
