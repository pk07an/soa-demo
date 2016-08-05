package com.meila.soa.order.api.model.request;

import java.util.List;

import org.hibernate.validator.constraints.NotEmpty;

import com.meila.dubbo.base.model.DubboBasicRequest;

/**
 * 
 ************************************************************
 * @类名 : DubboQueryOrderPackageRequest.java
 *
 * @DESCRIPTION : 获取订单包裹信息
 * @AUTHOR : gogo
 * @DATE : 2016年5月10日
 ************************************************************
 */
@SuppressWarnings("serial")
public class DubboQueryBatchOrderPackageRequest extends DubboBasicRequest {

    @NotEmpty(message = "订单编号列表不能为空")
    private List<String> orderNos;

    public List<String> getOrderNos() {
        return orderNos;
    }

    public void setOrderNos(List<String> orderNos) {
        this.orderNos = orderNos;
    }

}
