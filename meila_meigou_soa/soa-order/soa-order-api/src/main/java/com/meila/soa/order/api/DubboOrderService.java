/**
 * 
 */
package com.meila.soa.order.api;

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
 * @类名 : DubboOrderService.java
 *
 * @DESCRIPTION : 订单接口
 * @AUTHOR : flong
 * @DATE : 2016年3月14日
 ************************************************************
 */
public interface DubboOrderService {
    /**
     * 
     *
     * 功能描述：用户分享时，批量查询userid对应的首单信息
     * 
     * @param request
     * @return DubboQueryOrderByUserIds4ShareResponse
     *
     */
    DubboQueryOrderByUserIds4ShareResponse queryByUserIds4Share(DubboQueryOrderByUserIds4ShareRequest request);

    /**
     * 
     *
     * 功能描述：根据skuIds批量查询指定状态的订单商品销售数量
     * 
     * @param request
     * @return DubboQueryOrderNumByStatusResponse
     *
     */
    DubboQueryOrderSellNumResponse querySellNumBySkuIds(DubboQueryOrderSellNumRequest request);

    /**
     * 
     *
     * 功能描述：根据条件查询订单列表，支持分页
     * 
     * @param request
     * @return DubboQueryOrderListResponse
     *
     */
    DubboQueryOrderListResponse queryOrderList(DubboQueryOrderListRequest request);

    /**
     * 
     *
     * 功能描述：根据条件查询退款订单列表，支持分页
     * 
     * @param request
     * @return DubboQueryOrderListResponse
     *
     */
    DubboQueryRefundOrderListResponse queryRefundOrderList(DubboQueryRefundOrderListRequest request);

    /**
     * 
     *
     * 功能描述：根据orderId列表查询订单退款信息
     * 
     * @param request
     * @return DubboQueryOrderRefundApplyByOrderIdsResponse
     *
     */
    DubboQueryOrderRefundApplyByOrderIdsResponse queryOrderRefundApplyByOrderIds(DubboQueryOrderRefundApplyByOrderIdsRequest request);

    /**
     * 
     *
     * 功能描述：根据orderId查询订单退款信息
     * 
     * @param request
     * @return DubboQueryOrderRefundApplyByOrderIdResponse
     *
     */
    DubboQueryOrderRefundApplyByOrderIdResponse queryOrderRefundApplyByOrderId(DubboQueryOrderRefundApplyByOrderIdRequest request);

    /**
     * 
     *
     * 功能描述：获取订单包裹信息
     * 
     * @param request
     * @return DubboQueryOrderPackageResponse
     *
     */
    DubboQueryOrderPackageResponse queryOrderPackage(DubboQueryOrderPackageRequest request);

    /**
     * 
     *
     * 功能描述：根据订单编号列表获取订单包裹信息
     * 
     * @param request
     * @return DubboQueryBatchOrderPackageResponse
     *
     */
    DubboQueryBatchOrderPackageResponse queryBatchOrderPackage(DubboQueryBatchOrderPackageRequest request);

    /**
     * 
     *
     * 功能描述：根据订单ID获取订单信息
     * 
     * @param request
     * @return DubboQueryOrderInfoByIdResponse
     *
     */
    DubboQueryOrderInfoByIdResponse queryOrderInfoById(DubboQueryOrderInfoByIdRequest request);

    /**
     * 
     *
     * 功能描述：根据订单ID获取订单明细
     * 
     * @param request
     * @return DubboQueryOrderItemByOrderIdResponse
     *
     */
    DubboQueryOrderItemByOrderIdResponse queryOrderItemByOrderId(DubboQueryOrderItemByOrderIdRequest request);

    /**
     * 
     *
     * 功能描述：根据订单ID获取退款轨迹
     * 
     * @param request
     * @return DubboQueryOrderRefundTrackByOrderIdResponse
     *
     */
    DubboQueryOrderRefundTrackByOrderIdResponse queryOrderRefundTrackByOrderId(DubboQueryOrderRefundTrackByOrderIdRequest request);
    
    /**
     * 
     *
     * 功能描述：根据条件获取订单总数
     * 
     * @param request
     * @return DubboQueryOrderCountResponse
     *
     */
    DubboQueryOrderCountResponse queryOrderCount(DubboQueryOrderCountRequest request);
    
    /**
     * 
     *
     * 功能描述：根据订单号列表获取对应明细的优惠金额
     * 
     * @param request
     * @return DubboQueryOrderItemDiscountFeeResponse
     *
     */
    DubboQueryOrderItemDiscountFeeResponse queryOrderItemDiscountFee(DubboQueryOrderItemDiscountFeeRequest request); 

}
