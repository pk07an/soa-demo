/**
 * 
 */
package com.meila.soa.order.api;

import com.meila.soa.order.api.model.request.DubboQueryOutPayMapByPayNosRequest;
import com.meila.soa.order.api.model.response.DubboQueryOutPayMapByPayNosResponse;

/**
 ************************************************************
 * @类名 : DubboOrderPayService.java
 *
 * @DESCRIPTION : 订单支付接口
 * @AUTHOR : gogo
 * @DATE : 2016年6月12日
 ************************************************************
 */
public interface DubboOrderPayService {

    /**
     * 
     *
     * 功能描述：根据支付号获取支付信息
     * 
     * @param request
     * @return DubboQueryOutPayMapByPayNosResponse
     *
     */
    DubboQueryOutPayMapByPayNosResponse queryOutPayMapByPayNos(DubboQueryOutPayMapByPayNosRequest request);

}
