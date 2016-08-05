/**
 * 
 */
package com.meila.soa.openapi.thrift.order.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.thrift.TException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.alibaba.dubbo.rpc.RpcException;
import com.meila.dubbo.base.constant.DubboReturnCode;
import com.meila.soa.openapi.thrift.order.model.ThriftOrder4ShareModel;
import com.meila.soa.order.api.DubboOrderService;
import com.meila.soa.order.api.model.dto.DubboOrder4Share;
import com.meila.soa.order.api.model.request.DubboQueryOrderByUserIds4ShareRequest;
import com.meila.soa.order.api.model.response.DubboQueryOrderByUserIds4ShareResponse;

/**
 ************************************************************
 * @类名 : ThriftOrderServiceImpl.java
 *
 * @DESCRIPTION :
 * @AUTHOR : flong
 * @DATE : 2016年3月15日
 ************************************************************
 */
public class ThriftOrderServiceImpl implements com.meila.soa.openapi.thrift.order.ThriftOrderService.Iface {
    private final Logger logger = LoggerFactory.getLogger(getClass());
    @Autowired
    private DubboOrderService orderService;

    @Override
    public List<ThriftOrder4ShareModel> findFirstOrder4ShareByUserIds(List<Long> userIds) throws TException {
        List<ThriftOrder4ShareModel> result = new ArrayList<ThriftOrder4ShareModel>();
        if (userIds == null || userIds.size() == 0) {
            return result;
        }
        DubboQueryOrderByUserIds4ShareRequest request = new DubboQueryOrderByUserIds4ShareRequest();
        request.setUserIds(userIds);
        DubboQueryOrderByUserIds4ShareResponse response = null;
        try {
            response = orderService.queryByUserIds4Share(request);
        } catch (RpcException e) {
            logger.error("调用orderService.findFirstOrder4ShareByUserIds失败", e);
            return result;
        }
        if (response.getCode() == DubboReturnCode.SUCCESS) {
            ThriftOrder4ShareModel model = null;
            if (response.getOrderList() != null) {
                for (DubboOrder4Share order : response.getOrderList()) {
                    model = ThriftOrderConverter.dubboShareOrder2thrift(order);
                    result.add(model);
                }
            }
        }
        return result;
    }
}
