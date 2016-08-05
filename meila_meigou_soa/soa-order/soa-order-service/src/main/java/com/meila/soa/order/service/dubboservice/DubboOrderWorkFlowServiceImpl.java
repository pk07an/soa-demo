package com.meila.soa.order.service.dubboservice;

import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import com.meila.common.utils.date.DateUtil;
import com.meila.dubbo.base.constant.DubboReturnCode;
import com.meila.soa.meila.client.OmsClient;
import com.meila.soa.meila.client.PushMessageClient;
import com.meila.soa.meila.client.SmsClient;
import com.meila.soa.meila.client.dto.OrderLogisticsDto;
import com.meila.soa.meila.client.dto.OrderSellerRemarkDto;
import com.meila.soa.order.api.DubboOrderWorkFlowService;
import com.meila.soa.order.api.model.dto.OrderRefundStatus;
import com.meila.soa.order.api.model.dto.OrderStatusEnum;
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
import com.meila.soa.order.dal.dao.order.OrderAddressEntityMapper;
import com.meila.soa.order.dal.dao.order.OrderEntityMapper;
import com.meila.soa.order.dal.dao.order.OrderExtEntityMapper;
import com.meila.soa.order.dal.dao.order.OrderRefundApplyEntityMapper;
import com.meila.soa.order.dal.entity.order.OrderAddressEntity;
import com.meila.soa.order.dal.entity.order.OrderEntity;
import com.meila.soa.order.dal.entity.order.OrderExtEntity;
import com.meila.soa.order.dal.entity.order.OrderRefundApplyEntity;

/**
 * 
 ************************************************************
 * @类名 : DubboOrderWorkFlowServiceImpl.java
 *
 * @DESCRIPTION : 订单工作流服务，类似发货、退款、取消订单等操作
 * @AUTHOR : gogo
 * @DATE : 2016年5月12日
 ************************************************************
 */
public class DubboOrderWorkFlowServiceImpl implements DubboOrderWorkFlowService {

    private static Logger logger = LoggerFactory.getLogger(DubboOrderWorkFlowServiceImpl.class);

    @Autowired
    private OrderEntityMapper orderEntityMapper;
    @Autowired
    private OrderRefundApplyEntityMapper orderRefundApplyEntityMapper;
    @Autowired
    private OrderAddressEntityMapper orderAddressEntityMapper;
    @Autowired
    private SmsClient smsClient;
    @Autowired
    private OmsClient omsClient;
    @Autowired
    private PushMessageClient pushMessageClient;
    @Autowired
    private ThreadPoolTaskExecutor threadPoolTaskExecutor;
    @Autowired
    private OrderExtEntityMapper orderExtEntityMapper;

    // 延迟签收天数
    @Value("${workflow.delaysign.days}")
    private int delaySignDays;

    @Override
    public DubboExecuteSellerShipResponse executeSellerShip(DubboExecuteSellerShipRequest request) {

        DubboExecuteSellerShipResponse response = new DubboExecuteSellerShipResponse();

        OrderLogisticsDto dto = new OrderLogisticsDto();
        dto.setOrderNo(request.getOrderNo());
        dto.setSellerId(request.getSellerId());
        dto.setLogisticsCompany(request.getLogisticsCompany());
        dto.setLogisticsNo(request.getLogisticsOrderNo());
        dto.setPackageCode(request.getPackageCode());
        dto.setInternalFlag(request.getInternationalFlag());

        if (!omsClient.sendSyncOrderLogistics(dto)) {
            response.setCode(DubboReturnCode.FAILED);
            response.setDesc("同步OMS失败");
        }

        return response;
    }

    @Override
    public DubboExecuteSellerCancelResponse executeSellerCancel(DubboExecuteSellerCancelRequest request) {

        DubboExecuteSellerCancelResponse response = new DubboExecuteSellerCancelResponse();
        Calendar calendar = Calendar.getInstance();
        OrderEntity params = new OrderEntity();
        params.setStatus(OrderStatusEnum.CANCELLED.name());
        params.setUpdatedAt(calendar.getTime());
        params.setCancelledAt(calendar.getTime());

        int count = orderEntityMapper.updateByExecuteCondition(params, request.getOrderId(), OrderStatusEnum.SUBMITTED.name());
        if (count == 0) {
            logger.error("没有符合条件的订单，操作失败");
            response.setCode(DubboReturnCode.FAILED);
            response.setDesc("没有符合条件的订单，操作失败");
        }

        return response;
    }

    @Override
    public DubboExecuteSellerAcceptRefundResponse executeSellerAcceptRefund(final DubboExecuteSellerAcceptRefundRequest request) {
        DubboExecuteSellerAcceptRefundResponse response = new DubboExecuteSellerAcceptRefundResponse();

        final OrderEntity orderEntity = orderEntityMapper.selectByPrimaryKey(request.getOrderId());
        if (!StringUtils.equals(OrderStatusEnum.REFUNDING.name(), orderEntity.getStatus())) {
            logger.error("同意退款失败，该订单不为退款中的状态");
            response.setCode(DubboReturnCode.FAILED);
            response.setDesc("同意退款失败，该订单不为退款中的状态");
            return response;
        }
        Calendar calendar = Calendar.getInstance();
        OrderRefundApplyEntity entity = new OrderRefundApplyEntity();
        entity.setRefundStatus(OrderRefundStatus.S_ACCPECT.name());
        entity.setsConfirmTime(calendar.getTime());
        entity.setUpdatedAt(calendar.getTime());

        Map<String, Object> condition = new HashMap<>();
        condition.put("orderId", request.getOrderId());
        condition.put("refundStatus", OrderRefundStatus.PROCESS.name());
        condition.put("requestBy", "BUYER");
        int count = orderRefundApplyEntityMapper.updateByCondition(entity, condition);

        if (count == 0) {
            logger.error("没有符合条件的订单，操作失败");
            response.setCode(DubboReturnCode.FAILED);
            response.setDesc("没有符合条件的订单，操作失败");
        } else {
            threadPoolTaskExecutor.execute(new Runnable() {

                @Override
                public void run() {
                    // 推送消息到买家客户端
                    pushMessageClient.pushMessageBySellerAccpectRefund(orderEntity.getBuyerId().toString(), orderEntity.getOrderNo());

                    // 发送短信到收货人手机
                    OrderAddressEntity orderAddressEntity = orderAddressEntityMapper.selectByOrderId(request.getOrderId());
                    smsClient.sendSmsBySellerAccpectRefund(orderAddressEntity.getPhone(), orderEntity.getOrderNo());

                }
            });
        }

        return response;
    }

    @Override
    public DubboExecuteSellerRejectRefundResponse executeSellerRejectRefund(final DubboExecuteSellerRejectRefundRequest request) {
        DubboExecuteSellerRejectRefundResponse response = new DubboExecuteSellerRejectRefundResponse();

        final OrderEntity orderEntity = orderEntityMapper.selectByPrimaryKey(request.getOrderId());

        if (!StringUtils.equals(OrderStatusEnum.REFUNDING.name(), orderEntity.getStatus())) {
            logger.error("拒绝退款失败，该订单不为退款中的状态");
            response.setCode(DubboReturnCode.FAILED);
            response.setDesc("拒绝退款失败，该订单不为退款中的状态");
            return response;
        }

        OrderRefundApplyEntity orderRefundApplyEntity = orderRefundApplyEntityMapper.selectByOrderId(request.getOrderId());
        if (orderRefundApplyEntity == null) {
            logger.error("拒绝退款失败，该订单没有退款申请");
            response.setCode(DubboReturnCode.FAILED);
            response.setDesc("拒绝退款失败，该订单没有退款申请");
            return response;
        }

        Calendar calendar = Calendar.getInstance();
        OrderRefundApplyEntity entity = new OrderRefundApplyEntity();
        entity.setRefundStatus(OrderRefundStatus.S_REJECT.name());
        entity.setRejectRemark(request.getRejectRemark());
        entity.setsConfirmTime(calendar.getTime());
        entity.setUpdatedAt(calendar.getTime());

        Map<String, Object> condition = new HashMap<>();
        condition.put("orderId", request.getOrderId());
        condition.put("refundStatus", OrderRefundStatus.PROCESS.name());
        condition.put("requestBy", "BUYER");
        int count = orderRefundApplyEntityMapper.updateByCondition(entity, condition);

        OrderEntity record = new OrderEntity();
        record.setId(request.getOrderId());
        record.setStatus(orderRefundApplyEntity.getOrderStatus());
        orderEntityMapper.updateByPrimaryKeySelective(record);

        if (count == 0) {
            logger.error("没有符合条件的订单，操作失败");
            response.setCode(DubboReturnCode.FAILED);
            response.setDesc("没有符合条件的订单，操作失败");
        } else {
            threadPoolTaskExecutor.execute(new Runnable() {

                @Override
                public void run() {
                    // 推送消息到买家客户端
                    pushMessageClient.pushMessageBySellerRejectRefund(orderEntity.getBuyerId().toString(), orderEntity.getOrderNo());

                    // 发送短信到收货人手机
                    OrderAddressEntity orderAddressEntity = orderAddressEntityMapper.selectByOrderId(request.getOrderId());
                    smsClient.sendSmsBySellerRejectRefund(orderAddressEntity.getPhone(), orderEntity.getOrderNo());

                }
            });
        }

        return response;
    }

    @Override
    public DubboExecuteSellerRemarkResponse executeSellerRemark(DubboExecuteSellerRemarkRequest request) {
        DubboExecuteSellerRemarkResponse response = new DubboExecuteSellerRemarkResponse();

        OrderSellerRemarkDto dto = new OrderSellerRemarkDto();
        dto.setOrderNo(request.getOrderNo());
        dto.setSellerId(request.getSellerId().toString());
        dto.setRemark(request.getRemark());
        dto.setOperationTime(String.valueOf(DateUtil.date().getTime()));

        if (!StringUtils.equals(request.getOrderStatus(), OrderStatusEnum.SUBMITTED.name())
                && !StringUtils.equals(request.getOrderStatus(), OrderStatusEnum.CANCELLED.name())
                && !isNotSuccessTuan(request.getTuanFlag(), request.getTuanStatus()) && !omsClient.sendSyncSellerRemark(dto)) {
            response.setCode(DubboReturnCode.SYNC_SERVER_ERR);
            response.setDesc("同步到OMS失败");
            return response;
        }

        OrderExtEntity record = new OrderExtEntity();
        record.setOrderId(request.getOrderId());
        record.setSellerRemark(request.getRemark());
        orderExtEntityMapper.updateByOrderId(record);

        return response;
    }

    private boolean isNotSuccessTuan(Boolean tuanFlag, String tuanStatus) {
        boolean result = false;
        if (tuanFlag != null && tuanFlag.booleanValue() && "PROCESS".equals(tuanStatus)) {
            result = true;
        }
        return result;
    }

}
