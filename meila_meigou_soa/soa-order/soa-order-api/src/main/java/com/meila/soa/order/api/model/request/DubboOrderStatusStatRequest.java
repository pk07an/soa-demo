package com.meila.soa.order.api.model.request;

import com.meila.dubbo.base.model.DubboBasicRequest;

/**
 * 
 ************************************************************
 * @类名 : DubboOrderStatusStatRequest.java
 *
 * @DESCRIPTION : 订单状态统计Request
 * @AUTHOR : yongqi
 * @DATE : 2016年5月20日
 ************************************************************
 */
@SuppressWarnings("serial")
public class DubboOrderStatusStatRequest extends DubboBasicRequest {

    private Long sellerId;

	public Long getSellerId() {
		return sellerId;
	}

	public void setSellerId(Long sellerId) {
		this.sellerId = sellerId;
	}
}
