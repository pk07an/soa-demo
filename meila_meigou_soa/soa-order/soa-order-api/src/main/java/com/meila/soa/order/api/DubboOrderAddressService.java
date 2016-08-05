package com.meila.soa.order.api;

import com.meila.soa.order.api.model.request.DubboQueryOrderAddressAllZoneListRequest;
import com.meila.soa.order.api.model.request.DubboQueryOrderAddressInfoByOrderIdRequest;
import com.meila.soa.order.api.model.request.DubboUpdateAddressRequest;
import com.meila.soa.order.api.model.response.DubboQueryOrderAddressAllZoneListResponse;
import com.meila.soa.order.api.model.response.DubboQueryOrderAddressInfoByOrderIdResponse;
import com.meila.soa.order.api.model.response.DubboUpdateAddressResponse;

/**
 * 
 ************************************************************
 * @类名 : DubboOrderAddressService.java
 *
 * @DESCRIPTION : 订单地址服务
 * @AUTHOR :  gogo
 * @DATE :  2016年5月16日
 ************************************************************
 */
public interface DubboOrderAddressService {
    /**
     * 
     *
     * 功能描述：根据订单号更新用户收货地址
     * 
     * @param request
     * @return DubboUpdateAddressResponse
     *
     */
    DubboUpdateAddressResponse updateAddress(DubboUpdateAddressRequest request);
    
    /**
     * 
     *
     * 功能描述：根据订单ID获取订单地址信息
     * 
     * @param request
     * @return DubboQueryOrderAddressInfoByOrderIdResponse
     *
     */
    DubboQueryOrderAddressInfoByOrderIdResponse queryOrderAddressInfoByOrderId(DubboQueryOrderAddressInfoByOrderIdRequest request);
    
    /**
     * 
     *
     * 功能描述：获取全部地区信息
     * 
     * @param request
     * @return DubboQueryOrderAddressAllZoneListResponse
     *
     */
    DubboQueryOrderAddressAllZoneListResponse queryOrderAddressAllZoneList(DubboQueryOrderAddressAllZoneListRequest request);
    
}
