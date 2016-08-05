/**
 * 
 */
package com.meila.soa.openapi.thrift.order.impl;

import com.meila.soa.openapi.thrift.order.model.ThriftOrder4ShareModel;
import com.meila.soa.order.api.model.dto.DubboOrder4Share;

/**
 ************************************************************
 * @类名 : ThriftOrderConverter.java
 *
 * @DESCRIPTION :
 * @AUTHOR : flong
 * @DATE : 2016年3月15日
 ************************************************************
 */
public class ThriftOrderConverter {
    public static ThriftOrder4ShareModel dubboShareOrder2thrift(DubboOrder4Share dubboOrder) {
        if (dubboOrder == null) {
            return null;
        }
        ThriftOrder4ShareModel thriftOrder = new ThriftOrder4ShareModel();
        thriftOrder.setBuyerId(dubboOrder.getBuyerId());
        thriftOrder.setOrderNo(dubboOrder.getOrderNo());
        thriftOrder.setStatus(dubboOrder.getStatus());
        thriftOrder.setCreateTime(dubboOrder.getCreatedAt() == null ? 0L : dubboOrder.getCreatedAt().getTime());
        thriftOrder.setSuccessTime(dubboOrder.getSucceedAt() == null ? 0L : dubboOrder.getSucceedAt().getTime());
        return thriftOrder;
    }
}
