package com.meila.soa.order.api;

import com.meila.soa.order.api.model.request.DubboOrderStatusStatRequest;
import com.meila.soa.order.api.model.response.DubboOrderStatusStatResponse;
import com.meila.soa.order.api.model.response.DubboYesterdayOrderResponse;

/**
 * 
 ************************************************************
 * @类名 : DubboOrderStatService.java
 *
 * @DESCRIPTION : 订单统计相关服务API接口
 * @AUTHOR :  yongqi
 * @DATE :  2016年5月20日
 ************************************************************
 */
public interface DubboOrderStatService {
    /**
     * 
     *
     * 功能描述：统计订单状态数量
     * 
     * @param request
     * @return DubboOrderStatusStatResponse
     *
     */
	DubboOrderStatusStatResponse queryOrderStatByStatus(DubboOrderStatusStatRequest request);
	
	/**
	 * 
	 *
	 * 功能描述：统计昨日订单(昨日支付的订单)
	 * 
	 * @param request
	 * @return DubboOrderStatusStatResponse
	 *
	 */
	DubboYesterdayOrderResponse queryOrderStatYesterdayOrder(DubboOrderStatusStatRequest request);
}
