/**
 * 
 */
package com.meila.soa.order.service;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.alibaba.fastjson.JSON;
import com.google.common.collect.Lists;
import com.meila.dubbo.base.constant.DubboReturnCode;
import com.meila.soa.order.api.DubboOrderService;
import com.meila.soa.order.api.model.dto.OrderStatusEnum;
import com.meila.soa.order.api.model.request.DubboQueryBatchOrderPackageRequest;
import com.meila.soa.order.api.model.request.DubboQueryOrderByUserIds4ShareRequest;
import com.meila.soa.order.api.model.request.DubboQueryOrderCountRequest;
import com.meila.soa.order.api.model.request.DubboQueryOrderInfoByIdRequest;
import com.meila.soa.order.api.model.request.DubboQueryOrderItemByOrderIdRequest;
import com.meila.soa.order.api.model.request.DubboQueryOrderItemDiscountFeeRequest;
import com.meila.soa.order.api.model.request.DubboQueryOrderListRequest;
import com.meila.soa.order.api.model.request.DubboQueryOrderPackageRequest;
import com.meila.soa.order.api.model.request.DubboQueryOrderRefundApplyByOrderIdRequest;
import com.meila.soa.order.api.model.request.DubboQueryOrderRefundApplyByOrderIdsRequest;
import com.meila.soa.order.api.model.request.DubboQueryOrderRefundTrackByOrderIdRequest;
import com.meila.soa.order.api.model.request.DubboQueryOrderSellNumRequest;
import com.meila.soa.order.api.model.request.DubboQueryRefundOrderListRequest;
import com.meila.soa.order.api.model.response.DubboQueryBatchOrderPackageResponse;
import com.meila.soa.order.api.model.response.DubboQueryOrderByUserIds4ShareResponse;
import com.meila.soa.order.api.model.response.DubboQueryOrderCountResponse;
import com.meila.soa.order.api.model.response.DubboQueryOrderInfoByIdResponse;
import com.meila.soa.order.api.model.response.DubboQueryOrderItemByOrderIdResponse;
import com.meila.soa.order.api.model.response.DubboQueryOrderItemDiscountFeeResponse;
import com.meila.soa.order.api.model.response.DubboQueryOrderListResponse;
import com.meila.soa.order.api.model.response.DubboQueryOrderPackageResponse;
import com.meila.soa.order.api.model.response.DubboQueryOrderRefundApplyByOrderIdResponse;
import com.meila.soa.order.api.model.response.DubboQueryOrderRefundApplyByOrderIdsResponse;
import com.meila.soa.order.api.model.response.DubboQueryOrderRefundTrackByOrderIdResponse;
import com.meila.soa.order.api.model.response.DubboQueryOrderSellNumResponse;
import com.meila.soa.order.api.model.response.DubboQueryRefundOrderListResponse;

/**
 ************************************************************
 * @类名 : DubboOrderConsumerTest.java
 *
 * @DESCRIPTION :
 * @AUTHOR : flong
 * @DATE : 2016年3月15日
 ************************************************************
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:dubbo-consumer.xml" })
public class DubboOrderConsumerTest {
    @Resource
    private DubboOrderService dubboOrderService;

    @Test
    public void testQueryOrder4Share() {
        DubboQueryOrderByUserIds4ShareRequest request = new DubboQueryOrderByUserIds4ShareRequest();
        request.setUserIds(Lists.newArrayList(1134122L, 3102766L, 3303450L));
        DubboQueryOrderByUserIds4ShareResponse response = dubboOrderService.queryByUserIds4Share(request);
        System.out.println(JSON.toJSONString(response));
        Assert.assertEquals(DubboReturnCode.SUCCESS, response.getCode());
    }

    @Test
    public void testQueryOrderNum() {
        DubboQueryOrderSellNumRequest request = new DubboQueryOrderSellNumRequest();
        request.setSkuIds(Lists.newArrayList(8585L));
        request.setOrderStatus(OrderStatusEnum.SUCCESS);
        DubboQueryOrderSellNumResponse response = dubboOrderService.querySellNumBySkuIds(request);
        System.out.println(JSON.toJSONString(response));
        Assert.assertEquals(DubboReturnCode.SUCCESS, response.getCode());
    }

    @Test
    public void queryOrderList() {
        DubboQueryOrderListRequest request = new DubboQueryOrderListRequest();
        request.setCurrentPage(1L);
        request.setPageSize(10L);
        request.setSellerId(1134122L);
        List<Long> orderIds = Lists.newArrayList();
        orderIds.add(90561964L);
        orderIds.add(90561958L);
        orderIds.add(90561949L);
        request.setOrderIds(orderIds);

        request.setStartCreateAt(new Date(0L));

        DubboQueryOrderListResponse response = dubboOrderService.queryOrderList(request);

        System.out.println("queryOrderList:----" + JSON.toJSONString(response));
        Assert.assertEquals(DubboReturnCode.SUCCESS, response.getCode());
    }

    @Test
    public void queryRefundOrderList() {
        DubboQueryRefundOrderListRequest request = new DubboQueryRefundOrderListRequest();
        request.setCurrentPage(1L);
        request.setPageSize(10L);
        request.setSellerId(1134122L);
        request.setOrderNo("SO151123182827001036");

        DubboQueryRefundOrderListResponse response = dubboOrderService.queryRefundOrderList(request);

        System.out.println("queryRefundOrderList:----" + JSON.toJSONString(response));
        Assert.assertEquals(DubboReturnCode.SUCCESS, response.getCode());
    }

    @Test
    public void queryOrderRefundApplyByOrderIds() {
        DubboQueryOrderRefundApplyByOrderIdsRequest request = new DubboQueryOrderRefundApplyByOrderIdsRequest();
        request.setOrderids(Lists.newArrayList(10000136L, 10000130L));
        DubboQueryOrderRefundApplyByOrderIdsResponse response = dubboOrderService.queryOrderRefundApplyByOrderIds(request);
        System.out.println("queryOrderRefundApplyByOrderIds:----" + JSON.toJSONString(response.getDubboOrderRefundApplyList()));

        Assert.assertEquals(DubboReturnCode.SUCCESS, response.getCode());
    }

    @Test
    public void queryOrderPackage() {
        DubboQueryOrderPackageRequest request = new DubboQueryOrderPackageRequest();
        request.setOrderNo("SO151102201133001087");
        request.setBuyerId(3673651L);
        DubboQueryOrderPackageResponse response = dubboOrderService.queryOrderPackage(request);

        System.out.println("queryOrderPackage:----" + JSON.toJSONString(response));
        Assert.assertEquals(DubboReturnCode.SUCCESS, response.getCode());
    }
    
    @Test
    public void queryOrderInfoById() {
        DubboQueryOrderInfoByIdRequest request = new DubboQueryOrderInfoByIdRequest();
        request.setOrderId(90561958L);
        DubboQueryOrderInfoByIdResponse response = dubboOrderService.queryOrderInfoById(request);

        System.out.println("queryOrderInfoById:----" + JSON.toJSONString(response));
        Assert.assertEquals(DubboReturnCode.SUCCESS, response.getCode());
    }
    
    @Test
    public void queryOrderRefundApplyByOrderId() {
        DubboQueryOrderRefundApplyByOrderIdRequest request = new DubboQueryOrderRefundApplyByOrderIdRequest();
        request.setOrderId(10000696L);
        DubboQueryOrderRefundApplyByOrderIdResponse response = dubboOrderService.queryOrderRefundApplyByOrderId(request);

        System.out.println("queryOrderRefundApplyByOrderId:----" + JSON.toJSONString(response));
        Assert.assertEquals(DubboReturnCode.SUCCESS, response.getCode());
    }
    
    @Test
    public void queryBatchOrderPackage() {
        DubboQueryBatchOrderPackageRequest request = new DubboQueryBatchOrderPackageRequest();
        List<String> orderNos = Lists.newArrayList();
        orderNos.add("SO160524154125001023");
        orderNos.add("SO160518170056001001");
        request.setOrderNos(orderNos);
        DubboQueryBatchOrderPackageResponse response = dubboOrderService.queryBatchOrderPackage(request);

        System.out.println("queryBatchOrderPackage:----" + JSON.toJSONString(response));
        Assert.assertEquals(DubboReturnCode.SUCCESS, response.getCode());
    }
    
    @Test
    public void queryOrderItemByOrderId() {
        DubboQueryOrderItemByOrderIdRequest request = new DubboQueryOrderItemByOrderIdRequest();
        request.setOrderId(90561958L);
        DubboQueryOrderItemByOrderIdResponse response = dubboOrderService.queryOrderItemByOrderId(request);

        System.out.println("queryOrderItemByOrderId:----" + JSON.toJSONString(response));
        Assert.assertEquals(DubboReturnCode.SUCCESS, response.getCode());
    }
    
    @Test
    public void queryOrderRefundTrackByOrderId() {
        DubboQueryOrderRefundTrackByOrderIdRequest request = new DubboQueryOrderRefundTrackByOrderIdRequest();
        request.setOrderId(10000136L);
        DubboQueryOrderRefundTrackByOrderIdResponse response = dubboOrderService.queryOrderRefundTrackByOrderId(request);

        System.out.println("queryOrderRefundTrackByOrderId:----" + JSON.toJSONString(response));
        Assert.assertEquals(DubboReturnCode.SUCCESS, response.getCode());
    }
    
    @Test
    public void queryOrderCount() {
        DubboQueryOrderCountRequest request = new DubboQueryOrderCountRequest();
        request.setSellerId(1134122L);
        request.setStartPaidDate(new Date(new Date().getTime() - 5184000000L));
        DubboQueryOrderCountResponse response = dubboOrderService.queryOrderCount(request);

        System.out.println("queryOrderCount:----" + JSON.toJSONString(response));
        Assert.assertEquals(DubboReturnCode.SUCCESS, response.getCode());
    }
    
    @Test
    public void queryOrderItemDiscountFee() {
        DubboQueryOrderItemDiscountFeeRequest request = new DubboQueryOrderItemDiscountFeeRequest();
        request.setOrderNos(Lists.newArrayList("SO160612180637001003"));
        DubboQueryOrderItemDiscountFeeResponse response = dubboOrderService.queryOrderItemDiscountFee(request);

        System.out.println("queryOrderItemDiscountFee:----" + JSON.toJSONString(response));
        Assert.assertEquals(DubboReturnCode.SUCCESS, response.getCode());
    }
}
