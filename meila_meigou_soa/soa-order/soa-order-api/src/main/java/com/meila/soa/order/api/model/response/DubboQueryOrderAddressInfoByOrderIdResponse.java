package com.meila.soa.order.api.model.response;

import com.meila.dubbo.base.model.DubboBasicResponse;
import com.meila.soa.order.api.model.dto.DubboOrderAddressInfo;

/**
 * 
 ************************************************************
 * @类名 : DubboQueryOrderAddressInfoByOrderIdResponse.java
 *
 * @DESCRIPTION : 根据orderId获取订单地址信息
 * @AUTHOR : gogo
 * @DATE : 2016年5月12日
 ************************************************************
 */
@SuppressWarnings("serial")
public class DubboQueryOrderAddressInfoByOrderIdResponse extends DubboBasicResponse {

    private DubboOrderAddressInfo dubboOrderAddressInfo;

    public DubboOrderAddressInfo getDubboOrderAddressInfo() {
        return dubboOrderAddressInfo;
    }

    public void setDubboOrderAddressInfo(DubboOrderAddressInfo dubboOrderAddressInfo) {
        this.dubboOrderAddressInfo = dubboOrderAddressInfo;
    }

}
