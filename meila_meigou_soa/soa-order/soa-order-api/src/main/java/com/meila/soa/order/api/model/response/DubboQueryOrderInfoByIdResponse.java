package com.meila.soa.order.api.model.response;

import com.meila.dubbo.base.model.DubboBasicResponse;
import com.meila.soa.order.api.model.dto.DubboOrderExtInfo;
import com.meila.soa.order.api.model.dto.DubboOrderInfo;

/**
 * 
 ************************************************************
 * @类名 : DubboQueryOrderInfoByIdResponse.java
 *
 * @DESCRIPTION : 根据Id获取订单信息
 * @AUTHOR : gogo
 * @DATE : 2016年5月12日
 ************************************************************
 */
@SuppressWarnings("serial")
public class DubboQueryOrderInfoByIdResponse extends DubboBasicResponse {

    private DubboOrderInfo dubboOrderInfo;
    
    private DubboOrderExtInfo dubboOrderExtInfo;

    public DubboOrderInfo getDubboOrderInfo() {
        return dubboOrderInfo;
    }

    public void setDubboOrderInfo(DubboOrderInfo dubboOrderInfo) {
        this.dubboOrderInfo = dubboOrderInfo;
    }

    public DubboOrderExtInfo getDubboOrderExtInfo() {
        return dubboOrderExtInfo;
    }

    public void setDubboOrderExtInfo(DubboOrderExtInfo dubboOrderExtInfo) {
        this.dubboOrderExtInfo = dubboOrderExtInfo;
    }

}
