/**
 * 
 */
package com.meila.soa.order.service.dubboservice;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.commons.collections4.CollectionUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.google.common.base.Function;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.google.common.collect.Multimap;
import com.google.common.collect.Multimaps;
import com.meila.common.bean.utils.BeanMapper;
import com.meila.common.collection.utils.Collections3;
import com.meila.common.utils.StringUtils;
import com.meila.common.utils.date.DateUtil;
import com.meila.dubbo.base.constant.DubboReturnCode;
import com.meila.soa.meila.client.OmsClient;
import com.meila.soa.meila.client.dto.BatchOrderPackageDto;
import com.meila.soa.meila.client.dto.OrderPackageDto;
import com.meila.soa.meila.client.dto.OrderPackageLogisticsDto;
import com.meila.soa.order.api.DubboOrderService;
import com.meila.soa.order.api.model.dto.DubboBatchOrderPackage;
import com.meila.soa.order.api.model.dto.DubboOrder;
import com.meila.soa.order.api.model.dto.DubboOrder4Share;
import com.meila.soa.order.api.model.dto.DubboOrderExtInfo;
import com.meila.soa.order.api.model.dto.DubboOrderInfo;
import com.meila.soa.order.api.model.dto.DubboOrderItem;
import com.meila.soa.order.api.model.dto.DubboOrderPackage;
import com.meila.soa.order.api.model.dto.DubboOrderPackageItem;
import com.meila.soa.order.api.model.dto.DubboOrderPackageTrack;
import com.meila.soa.order.api.model.dto.DubboOrderRefundApply;
import com.meila.soa.order.api.model.dto.DubboOrderRefundTrack;
import com.meila.soa.order.api.model.dto.DubboRefundOrder;
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
import com.meila.soa.order.dal.dao.order.OrderEntityMapper;
import com.meila.soa.order.dal.dao.order.OrderExtEntityMapper;
import com.meila.soa.order.dal.dao.order.OrderItemEntityMapper;
import com.meila.soa.order.dal.dao.order.OrderItemPromotionEntityMapper;
import com.meila.soa.order.dal.dao.order.OrderRefundApplyEntityMapper;
import com.meila.soa.order.dal.dao.order.SkuBomEntityMapper;
import com.meila.soa.order.dal.dao.order.TuanStatusEntityMapper;
import com.meila.soa.order.dal.entity.order.OrderEntity;
import com.meila.soa.order.dal.entity.order.OrderExtEntity;
import com.meila.soa.order.dal.entity.order.OrderItemEntity;
import com.meila.soa.order.dal.entity.order.OrderItemPromotionEntity;
import com.meila.soa.order.dal.entity.order.OrderRefundApplyEntity;
import com.meila.soa.order.dal.entity.order.SkuBomEntity;
import com.meila.soa.order.dal.entity.order.TuanStatusEntity;
import com.meila.soa.order.dal.vo.order.OrderVO;
import com.meila.soa.order.dal.vo.order.RefundOrderVO;

/**
 ************************************************************
 * @类名 : DubboOrderServiceImpl.java
 *
 * @DESCRIPTION :
 * @AUTHOR : flong
 * @DATE : 2016年3月14日
 ************************************************************
 */
public class DubboOrderServiceImpl implements DubboOrderService {
    private static Logger logger = LoggerFactory.getLogger(DubboOrderServiceImpl.class);
    @Autowired
    private OrderEntityMapper orderEntityMapper;
    @Autowired
    private OrderItemEntityMapper orderItemEntityMapper;
    @Autowired
    private SkuBomEntityMapper skuBomEntityMapper;
    @Autowired
    private OrderRefundApplyEntityMapper orderRefundApplyEntityMapper;
    @Autowired
    private OrderExtEntityMapper orderExtEntityMapper;
    @Autowired
    private TuanStatusEntityMapper tuanStatusEntityMapper;
    @Autowired
    private OmsClient omsClient;
    @Autowired
    private OrderItemPromotionEntityMapper orderItemPromotionEntityMapper;

    @Override
    public DubboQueryOrderByUserIds4ShareResponse queryByUserIds4Share(DubboQueryOrderByUserIds4ShareRequest request) {
        DubboQueryOrderByUserIds4ShareResponse response = new DubboQueryOrderByUserIds4ShareResponse();
        List<Long> userIds = request.getUserIds();
        if (userIds == null || userIds.size() == 0) {
            response.setOrderList(new ArrayList<DubboOrder4Share>());
            return response;
        }
        List<OrderEntity> list = orderEntityMapper.selectByBuyerIds(userIds);
        response.setOrderList(BeanMapper.map(list, DubboOrder4Share.class));
        return response;
    }

    @Override
    public DubboQueryOrderSellNumResponse querySellNumBySkuIds(DubboQueryOrderSellNumRequest request) {
        DubboQueryOrderSellNumResponse response = new DubboQueryOrderSellNumResponse();
        if (request.getSkuIds() == null || request.getSkuIds().size() == 0) {
            return response;
        }
        List<OrderItemEntity> orderItemList = orderItemEntityMapper.selectBySkuIds(request.getSkuIds(), request.getOrderStatus().name(),
            request.getBeginTime(), request.getEndTime());
        response.setResultMap(calculateAmount(orderItemList));
        return response;
    }

    private Map<Long, Integer> calculateAmount(List<OrderItemEntity> orderItemList) {
        Map<Long, Integer> resultMap = new HashMap<Long, Integer>();
        if (orderItemList == null || orderItemList.size() == 0) {
            return resultMap;
        }
        List<Long> skuIds = Lists.transform(orderItemList, new Function<OrderItemEntity, Long>() {
            public Long apply(OrderItemEntity entity) {
                return entity.getSkuId();
            }
        });
        // skuIds是有效数据，其中套餐类需要查询sku_bom计算套餐内sku总数，非套餐类直接使用amount
        List<SkuBomEntity> boms = skuBomEntityMapper.selectBySkuId(skuIds);
        // boms是套餐类
        List<Long> bomIds = Lists.transform(boms, new Function<SkuBomEntity, Long>() {
            public Long apply(SkuBomEntity entity) {
                return entity.getSpuId();
            }
        });

        Multimap<Long, OrderItemEntity> skuMap = Multimaps.index(orderItemList, new Function<OrderItemEntity, Long>() {
            @Override
            public Long apply(OrderItemEntity input) {
                return input.getSkuId();
            }
        });
        Multimap<Long, SkuBomEntity> bomMap = Multimaps.index(boms, new Function<SkuBomEntity, Long>() {
            @Override
            public Long apply(SkuBomEntity input) {
                return input.getSpuId();
            }
        });
        // 计算套餐类销量
        if (bomIds != null && bomIds.size() > 0) {
            for (Long bomId : bomIds) {
                // 提取套餐数
                int tmpBomCount = 0;
                // 提取套餐中的sku数
                int tmpBomSkuCount = 0;
                Iterator<OrderItemEntity> bomOrderItor = skuMap.get(bomId).iterator();
                while (bomOrderItor.hasNext()) {
                    OrderItemEntity bomEntity = bomOrderItor.next();
                    tmpBomCount += bomEntity.getAmount();
                }
                // 查询套餐内的sku amount
                Iterator<SkuBomEntity> bomItor = bomMap.get(bomId).iterator();
                while (bomItor.hasNext()) {
                    SkuBomEntity bomEntity = bomItor.next();
                    tmpBomSkuCount += bomEntity.getMatchCount();
                }
                resultMap.put(bomId, tmpBomCount * tmpBomSkuCount);
            }
        }
        // 计算非套餐类销量
        skuIds.removeAll(bomIds);
        if (skuIds != null && skuIds.size() > 0) {
            for (Long skuId : skuIds) {
                int tmpCount = 0;
                Iterator<OrderItemEntity> itor = skuMap.get(skuId).iterator();
                while (itor.hasNext()) {
                    OrderItemEntity bomEntity = itor.next();
                    tmpCount += bomEntity.getAmount();
                }
                resultMap.put(skuId, tmpCount);
            }
        }
        return resultMap;
    }

    @Override
    public DubboQueryOrderListResponse queryOrderList(DubboQueryOrderListRequest request) {

        DubboQueryOrderListResponse response = new DubboQueryOrderListResponse();
        response.setCurrentPage(request.getCurrentPage());
        response.setPageSize(request.getPageSize());

        Map<String, Object> params = new HashMap<>();
        // 是否使用到索引，条件不能为空，不然会导致订单表全表扫描
        boolean isUseIndex = false;
        if (request.getSellerId() != null) {
            params.put("sellerId", request.getSellerId());
            isUseIndex = true;
        }
        if (StringUtils.isNotBlank(request.getStatus())) {
            params.put("status", request.getStatus());
            isUseIndex = true;
        }

        if (request.getStartCreateAt() != null) {
            params.put("startCreateAt", request.getStartCreateAt());
            params.put("endCreateAt", request.getEndCreateAt() == null ? DateUtil.date() : request.getEndCreateAt());
            isUseIndex = true;
        }

        if (request.getStartPaidAt() != null) {
            params.put("startPaidAt", request.getStartPaidAt());
            params.put("endPaidAt", request.getEndPaidAt() == null ? DateUtil.date() : request.getEndPaidAt());
            isUseIndex = true;
        }

        if (StringUtils.isNotBlank(request.getOrderNo())) {
            params.put("orderNo", request.getOrderNo());
            isUseIndex = true;
        }
        if (StringUtils.isNotBlank(request.getConsignee())) {
            params.put("consignee", request.getConsignee());
            isUseIndex = true;
        }

        if (StringUtils.isNotBlank(request.getBuyerName())) {
            params.put("buyerName", request.getBuyerName() + "%");
            isUseIndex = true;
        }

        if (Collections3.isNotEmpty(request.getOrderIds())) {
            params.put("orderIds", request.getOrderIds());
            isUseIndex = true;
        }

        params.put("beginId", request.getBeginId());
        params.put("pageSize", request.getPageSize());

        if (!isUseIndex) {
            logger.error("缺少参数");
            response.setCode(DubboReturnCode.PARAMETER_ERR);
            response.setDesc("缺少参数");
            return response;
        }

        List<OrderVO> orderVOs = orderEntityMapper.selectByCondition(params);
        Long totalNum = orderEntityMapper.countByCondition(params);
        response.setTotalNum(totalNum);
        if (orderVOs.isEmpty()) {
            response.setOrderInfos(new ArrayList<DubboOrder>());
            return response;
        }

        List<DubboOrder> dubboOrderList = new ArrayList<>();
        List<Long> orderIds = new ArrayList<>();
        for (OrderVO orderVO : orderVOs) {
            DubboOrder dubboOrder = BeanMapper.map(orderVO, DubboOrder.class);
            dubboOrderList.add(dubboOrder);

            orderIds.add(orderVO.getId());
        }

        Set<String> tuanNoSet = new HashSet<>();

        // 根据orderId列表获取扩展信息
        List<OrderExtEntity> orderExts = orderExtEntityMapper.selectByOrderIds(orderIds);
        for (OrderExtEntity entity : orderExts) {
            for (DubboOrder dubboOrder : dubboOrderList) {
                if (dubboOrder.getId().longValue() == entity.getOrderId().longValue()) {
                    dubboOrder.setTuanFlag(entity.getTuanFlag());
                    dubboOrder.setSellerRemark(entity.getSellerRemark());
                    dubboOrder.setTuanNo(entity.getTuanNo());
                    break;
                }
            }
            if (StringUtils.isNotEmpty(entity.getTuanNo())) {
                tuanNoSet.add(entity.getTuanNo());
            }
        }

        if (!tuanNoSet.isEmpty()) {
            List<String> tuanNos = Lists.newArrayList();
            tuanNos.addAll(tuanNoSet);
            List<TuanStatusEntity> tuanStatusList = tuanStatusEntityMapper.selectByTuanNos(tuanNos);
            for (TuanStatusEntity entity : tuanStatusList) {
                for (DubboOrder dubboOrder : dubboOrderList) {
                    if (StringUtils.equals(dubboOrder.getTuanNo(), entity.getTuanNo())) {
                        dubboOrder.setTuanStatus(entity.getStatus());
                        break;
                    }
                }
            }
        }

        response.setOrderInfos(dubboOrderList);

        List<OrderItemEntity> orderItemList = orderItemEntityMapper.selectByOrderIds(orderIds);

        for (OrderItemEntity itemTemp : orderItemList) {
            for (DubboOrder orderTemp : dubboOrderList) {
                if (itemTemp.getOrderId().longValue() == orderTemp.getId().longValue()) {
                    orderTemp.getItems().add(BeanMapper.map(itemTemp, DubboOrderItem.class));
                    break;
                }
            }
        }

        return response;
    }

    @Override
    public DubboQueryRefundOrderListResponse queryRefundOrderList(DubboQueryRefundOrderListRequest request) {

        DubboQueryRefundOrderListResponse response = new DubboQueryRefundOrderListResponse();
        response.setCurrentPage(request.getCurrentPage());
        response.setPageSize(request.getPageSize());

        Map<String, Object> params = new HashMap<>();
        // 是否使用到索引，条件不能为空，不然会导致订单表全表扫描
        boolean isUseIndex = false;
        if (request.getSellerId() != null) {
            params.put("sellerId", request.getSellerId());
            isUseIndex = true;
        }
        if (StringUtils.isNotBlank(request.getRefundStatus())) {
            params.put("refundStatus", request.getRefundStatus());
            isUseIndex = true;
        }

        if (request.getStartRefundTime() != null) {
            params.put("startRefundTime", request.getStartRefundTime());
            params.put("endRefundTime", request.getEndRefundTime() == null ? DateUtil.date() : request.getEndRefundTime());
            isUseIndex = true;
        }
        if (StringUtils.isNotBlank(request.getOrderNo())) {
            params.put("orderNo", request.getOrderNo());
            isUseIndex = true;
        }
        if (StringUtils.isNotBlank(request.getConsignee())) {
            params.put("consignee", request.getConsignee());
            isUseIndex = true;
        }

        if (StringUtils.isNotBlank(request.getBuyerName())) {
            params.put("buyerName", request.getBuyerName() + "%");
            isUseIndex = true;
        }

        params.put("beginId", request.getBeginId());
        params.put("pageSize", request.getPageSize());

        if (!isUseIndex) {
            logger.error("缺少参数");
            response.setCode(DubboReturnCode.PARAMETER_ERR);
            response.setDesc("缺少参数");
            return response;
        }

        List<RefundOrderVO> refundOrderVOs = orderRefundApplyEntityMapper.selectByCondition(params);
        Long totalNum = orderRefundApplyEntityMapper.countByCondition(params);
        response.setTotalNum(totalNum);
        if (refundOrderVOs.isEmpty()) {
            response.setRefundOrderInfos(new ArrayList<DubboRefundOrder>());
            return response;
        }

        List<DubboRefundOrder> dubboRefundOrderList = new ArrayList<>();
        List<Long> orderIds = new ArrayList<>();
        for (RefundOrderVO refundOrderVO : refundOrderVOs) {
            DubboRefundOrder dubboOrder = BeanMapper.map(refundOrderVO, DubboRefundOrder.class);
            dubboRefundOrderList.add(dubboOrder);

            orderIds.add(refundOrderVO.getId());
        }

        response.setRefundOrderInfos(dubboRefundOrderList);

        List<OrderItemEntity> orderItemList = orderItemEntityMapper.selectByOrderIds(orderIds);

        for (OrderItemEntity itemTemp : orderItemList) {
            for (DubboRefundOrder orderTemp : dubboRefundOrderList) {
                if (itemTemp.getOrderId().longValue() == orderTemp.getId().longValue()) {
                    orderTemp.getItems().add(BeanMapper.map(itemTemp, DubboOrderItem.class));
                    break;
                }
            }
        }

        return response;
    }

    @Override
    public DubboQueryOrderRefundApplyByOrderIdsResponse queryOrderRefundApplyByOrderIds(DubboQueryOrderRefundApplyByOrderIdsRequest request) {
        DubboQueryOrderRefundApplyByOrderIdsResponse response = new DubboQueryOrderRefundApplyByOrderIdsResponse();

        List<OrderRefundApplyEntity> orderRefunds = orderRefundApplyEntityMapper.selectByOrderIds(request.getOrderids());

        // 订单退款申请表里会存在两条记录对应一个order_id，出现这种情况，取最新的记录
        List<OrderRefundApplyEntity> discardOrderRefunds = new ArrayList<>();
        for (OrderRefundApplyEntity entity : orderRefunds) {
            for (OrderRefundApplyEntity temp : orderRefunds) {
                if (entity.getOrderId().longValue() == temp.getOrderId().longValue() && entity.getId().longValue() < temp.getId().longValue()) {
                    discardOrderRefunds.add(entity);
                }
            }
        }
        orderRefunds.removeAll(discardOrderRefunds);

        response.setDubboOrderRefundApplyList(BeanMapper.map(orderRefunds, DubboOrderRefundApply.class));

        return response;
    }

    @Override
    public DubboQueryOrderPackageResponse queryOrderPackage(DubboQueryOrderPackageRequest request) {

        DubboQueryOrderPackageResponse response = new DubboQueryOrderPackageResponse();

        List<OrderPackageDto> orderPackageDtos = omsClient.getOrderLogisticsList(request.getOrderNo(), request.getBuyerId());

        if (orderPackageDtos == null) {
            response.setCode(DubboReturnCode.SYNC_SERVER_ERR);
            response.setDesc("调用内部系统失败");
            return response;
        }

        List<DubboOrderPackage> dubboOrderPackages = Lists.newArrayList();
        response.setOrderPackages(dubboOrderPackages);
        for (OrderPackageDto orderPackageDto : orderPackageDtos) {
            DubboOrderPackage dubboOrderPackage = BeanMapper.map(orderPackageDto, DubboOrderPackage.class);

            List<DubboOrderPackageItem> dubboOrderPackageItems = BeanMapper.map(orderPackageDto.getOrderPackageItemDtos(),
                DubboOrderPackageItem.class);
            dubboOrderPackage.setItems(dubboOrderPackageItems);
            if (CollectionUtils.isNotEmpty(orderPackageDto.getOrderPackageLogisticsDtos())) {
                List<DubboOrderPackageTrack> dubboOrderPackageTracks = Lists.newArrayList();
                dubboOrderPackage.setTracks(dubboOrderPackageTracks);
                for (OrderPackageLogisticsDto logisiticsDto : orderPackageDto.getOrderPackageLogisticsDtos()) {
                    DubboOrderPackageTrack track = new DubboOrderPackageTrack();
                    track.setOperationTime(logisiticsDto.getPtrackTime());
                    track.setTrackRemark(logisiticsDto.getPtrackRemark());

                    dubboOrderPackageTracks.add(track);
                }
            }

            dubboOrderPackages.add(dubboOrderPackage);
        }
        return response;
    }

    @Override
    public DubboQueryOrderInfoByIdResponse queryOrderInfoById(DubboQueryOrderInfoByIdRequest request) {

        DubboQueryOrderInfoByIdResponse response = new DubboQueryOrderInfoByIdResponse();
        OrderEntity orderEntity = orderEntityMapper.selectByPrimaryKey(request.getOrderId());
        if (orderEntity == null) {
            response.setCode(DubboReturnCode.PARAMETER_ERR);
            response.setDesc("查找不到对应的订单");
            return response;
        }
        DubboOrderInfo dubboOrderInfo = BeanMapper.map(orderEntity, DubboOrderInfo.class);
        response.setDubboOrderInfo(dubboOrderInfo);

        // 根据orderId列表获取扩展信息
        OrderExtEntity orderExtEntity = orderExtEntityMapper.selectByOrderId(request.getOrderId());
        DubboOrderExtInfo dubboOrderExtInfo = BeanMapper.map(orderExtEntity, DubboOrderExtInfo.class);
        if (StringUtils.isNotEmpty(orderExtEntity.getTuanNo())) {
            TuanStatusEntity tuanStatusEntity = tuanStatusEntityMapper.selectByTuanNo(orderExtEntity.getTuanNo());
            dubboOrderExtInfo.setTuanStatus(tuanStatusEntity.getStatus());
        }

        response.setDubboOrderExtInfo(dubboOrderExtInfo);

        return response;
    }

    @Override
    public DubboQueryOrderRefundApplyByOrderIdResponse queryOrderRefundApplyByOrderId(DubboQueryOrderRefundApplyByOrderIdRequest request) {

        DubboQueryOrderRefundApplyByOrderIdResponse response = new DubboQueryOrderRefundApplyByOrderIdResponse();

        OrderRefundApplyEntity orderRefundApplyEntity = orderRefundApplyEntityMapper.selectByOrderId(request.getOrderId());
        if (orderRefundApplyEntity == null) {
            response.setCode(DubboReturnCode.PARAMETER_ERR);
            response.setDesc("查找不到对应的退款申请");
            return response;
        }

        response.setDubboOrderRefundApply(BeanMapper.map(orderRefundApplyEntity, DubboOrderRefundApply.class));

        return response;
    }

    @Override
    public DubboQueryBatchOrderPackageResponse queryBatchOrderPackage(DubboQueryBatchOrderPackageRequest request) {

        DubboQueryBatchOrderPackageResponse response = new DubboQueryBatchOrderPackageResponse();

        List<BatchOrderPackageDto> batchOrderPackageDtos = omsClient.getOrderPackages(request.getOrderNos());

        if (batchOrderPackageDtos == null) {
            response.setCode(DubboReturnCode.SYNC_SERVER_ERR);
            response.setDesc("调用内部系统失败");
            return response;
        }

        Map<String, List<DubboBatchOrderPackage>> dubboBatchOrderPackageMap = Maps.newHashMap();
        response.setBatchOrderPackageMap(dubboBatchOrderPackageMap);

        for (BatchOrderPackageDto batchOrderPackageDto : batchOrderPackageDtos) {
            List<DubboBatchOrderPackage> dubboBatchOrderPackages = dubboBatchOrderPackageMap.get(batchOrderPackageDto.getOrderNo());
            if (dubboBatchOrderPackages == null) {
                dubboBatchOrderPackages = Lists.newArrayList();
                dubboBatchOrderPackageMap.put(batchOrderPackageDto.getOrderNo(), dubboBatchOrderPackages);
            }

            DubboBatchOrderPackage dubboBatchOrderPackage = BeanMapper.map(batchOrderPackageDto, DubboBatchOrderPackage.class);

            List<DubboOrderPackageItem> dubboOrderPackageItems = BeanMapper.map(batchOrderPackageDto.getOrderPackageItemDtos(),
                DubboOrderPackageItem.class);
            dubboBatchOrderPackage.setItems(dubboOrderPackageItems);

            dubboBatchOrderPackages.add(dubboBatchOrderPackage);
        }
        return response;
    }

    @Override
    public DubboQueryOrderItemByOrderIdResponse queryOrderItemByOrderId(DubboQueryOrderItemByOrderIdRequest request) {
        DubboQueryOrderItemByOrderIdResponse response = new DubboQueryOrderItemByOrderIdResponse();
        List<Long> orderIds = Lists.newArrayList();
        orderIds.add(request.getOrderId());
        List<OrderItemEntity> orderItemList = orderItemEntityMapper.selectByOrderIds(orderIds);

        if (Collections3.isEmpty(orderItemList)) {
            response.setCode(DubboReturnCode.PARAMETER_ERR);
            response.setDesc("查找不到对应的订单明细");
            return response;
        }

        List<DubboOrderItem> dubboOrderItems = Lists.newArrayList();
        for (OrderItemEntity itemTemp : orderItemList) {
            dubboOrderItems.add(BeanMapper.map(itemTemp, DubboOrderItem.class));
        }

        response.setOrderItems(dubboOrderItems);
        return response;
    }

    @Override
    public DubboQueryOrderRefundTrackByOrderIdResponse queryOrderRefundTrackByOrderId(DubboQueryOrderRefundTrackByOrderIdRequest request) {

        DubboQueryOrderRefundTrackByOrderIdResponse response = new DubboQueryOrderRefundTrackByOrderIdResponse();
        List<Long> orderIds = Lists.newArrayList();
        orderIds.add(request.getOrderId());
        List<OrderRefundApplyEntity> orderRefundApplyEntities = orderRefundApplyEntityMapper.selectByOrderIds(orderIds);
        if (Collections3.isEmpty(orderRefundApplyEntities)) {
            response.setCode(DubboReturnCode.PARAMETER_ERR);
            response.setDesc("查找不到对应的退款数据");
            return response;
        }

        List<DubboOrderRefundTrack> tracks = Lists.newArrayList();
        response.setDubboOrderRefundTrack(tracks);
        for (OrderRefundApplyEntity entity : orderRefundApplyEntities) {
            DubboOrderRefundTrack track = new DubboOrderRefundTrack();
            track.setSellerRejectReason(entity.getRejectReason());
            track.setSellerRejectRemark(entity.getRejectRemark());
            track.setSellerConfirmTime(entity.getsConfirmTime());
            track.setpConfirmTime(entity.getpConfirmTime());
            track.setTransferTime(entity.getTransferTime());
            track.setCancelTime(entity.getCancelTime());

            track.setRefundFee(entity.getRefundFee());
            track.setRefundReason(entity.getRefundReason());
            track.setRefundRemark(entity.getRefundRemark());
            track.setRefundType(entity.getRefundType());
            track.setRefundTime(entity.getRefundTime());

            track.setRequestBy(entity.getRequestBy());
            tracks.add(track);
        }

        return response;
    }

    @Override
    public DubboQueryOrderCountResponse queryOrderCount(DubboQueryOrderCountRequest request) {
        DubboQueryOrderCountResponse response = new DubboQueryOrderCountResponse();
        Map<String, Object> params = new HashMap<>();
        params.put("sellerId", request.getSellerId());
        if (StringUtils.isNotBlank(request.getStatus())) {
            params.put("status", request.getStatus());
        }

        params.put("startPaidDate", request.getStartPaidDate());
        params.put("endPaidDate", request.getEndPaidDate() == null ? DateUtil.date() : request.getEndPaidDate());

        Integer count = orderEntityMapper.countOrderByExport(params);
        response.setCount(count);
        return response;
    }

    @Override
    public DubboQueryOrderItemDiscountFeeResponse queryOrderItemDiscountFee(DubboQueryOrderItemDiscountFeeRequest request) {

        DubboQueryOrderItemDiscountFeeResponse response = new DubboQueryOrderItemDiscountFeeResponse();
        Map<Long, BigDecimal> discountFeeMap = new HashMap<>();
        response.setDiscountFeeMap(discountFeeMap);
        List<OrderItemPromotionEntity> orderItemPromotionEntities = orderItemPromotionEntityMapper.selectByOrderNos(request.getOrderNos());
        if (Collections3.isEmpty(orderItemPromotionEntities)) {
            return response;
        }

        for (OrderItemPromotionEntity entity : orderItemPromotionEntities) {
            BigDecimal temp = discountFeeMap.get(entity.getOrderItemId());
            if (temp == null) {
                discountFeeMap.put(entity.getOrderItemId(), entity.getDiscountFee());
            } else {
                discountFeeMap.put(entity.getOrderItemId(), temp.add(entity.getDiscountFee()));
            }
        }

        return response;
    }

}
