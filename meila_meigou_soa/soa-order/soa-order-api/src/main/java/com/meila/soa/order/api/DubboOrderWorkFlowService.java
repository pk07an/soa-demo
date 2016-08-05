package com.meila.soa.order.api;

import com.meila.soa.order.api.model.request.DubboExecuteSellerAcceptRefundRequest;
import com.meila.soa.order.api.model.request.DubboExecuteSellerCancelRequest;
import com.meila.soa.order.api.model.request.DubboExecuteSellerRejectRefundRequest;
import com.meila.soa.order.api.model.request.DubboExecuteSellerRemarkRequest;
import com.meila.soa.order.api.model.request.DubboExecuteSellerShipRequest;
import com.meila.soa.order.api.model.response.DubboExecuteSellerAcceptRefundResponse;
import com.meila.soa.order.api.model.response.DubboExecuteSellerCancelResponse;
import com.meila.soa.order.api.model.response.DubboExecuteSellerRejectRefundResponse;
import com.meila.soa.order.api.model.response.DubboExecuteSellerRemarkResponse;
import com.meila.soa.order.api.model.response.DubboExecuteSellerShipResponse;

/**
 * 
 ************************************************************
 * @类名 : DubboOrderWorkFlowService.java
 *
 * @DESCRIPTION : 订单工作流服务，类似发货、退款、取消订单等操作 
 * @AUTHOR :  gogo
 * @DATE :  2016年5月12日
 ************************************************************
 */
public interface DubboOrderWorkFlowService {

    /**
     * 
     *
     * 功能描述：卖家执行发货操作
     * 
     * @param request
     * @return DubboExecuteSellerShipResponse
     *
     */
    DubboExecuteSellerShipResponse executeSellerShip(DubboExecuteSellerShipRequest request);
    
    /**
     * 
     *
     * 功能描述：卖家执行取消操作
     * 
     * @param request
     * @return DubboExecuteSellerCancelResponse
     *
     */
    DubboExecuteSellerCancelResponse executeSellerCancel(DubboExecuteSellerCancelRequest request);
    
    /**
     * 
     *
     * 功能描述：卖家执行同意退款操作
     * 
     * @param request
     * @return DubboExecuteSellerAcceptRefundResponse
     *
     */
    DubboExecuteSellerAcceptRefundResponse executeSellerAcceptRefund(DubboExecuteSellerAcceptRefundRequest request);
    
    /**
     * 
     *
     * 功能描述：卖家执行拒绝退款操作
     * 
     * @param request
     * @return DubboExecuteSellerRejectRefundResponse
     *
     */
    DubboExecuteSellerRejectRefundResponse executeSellerRejectRefund(DubboExecuteSellerRejectRefundRequest request);
    
    /**
     * 
     *
     * 功能描述：卖家回写备注
     * 
     * @param request
     * @return DubboExecuteSellerRemarkResponse
     *
     */
    DubboExecuteSellerRemarkResponse executeSellerRemark(DubboExecuteSellerRemarkRequest request);
    
}
