/**
 * 
 */
package com.meila.soa.order.service.dubboservice;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.alibaba.fastjson.JSONObject;
import com.google.common.collect.Lists;
import com.meila.dubbo.base.constant.DubboReturnCode;
import com.meila.soa.order.api.DubboOrderStatService;
import com.meila.soa.order.api.model.dto.OrderStatusEnum;
import com.meila.soa.order.api.model.request.DubboOrderStatusStatRequest;
import com.meila.soa.order.api.model.response.DubboOrderStatusStatResponse;
import com.meila.soa.order.api.model.response.DubboYesterdayOrderResponse;
import com.meila.soa.order.dal.dao.order.OrderEntityMapper;
import com.meila.soa.order.dal.vo.order.OrderStatVO;

/**
 ************************************************************ 
 * @类名 : DubboOrderServiceImpl.java
 * 
 * @DESCRIPTION : 订单统计相关api服务实现类
 * @AUTHOR : yongqi
 * @DATE : 2016年5月20日
 ************************************************************ 
 */
public class DubboOrderStatServiceImpl implements DubboOrderStatService {

    private static Logger logger = LoggerFactory.getLogger(DubboOrderStatServiceImpl.class);

    @Autowired
    private OrderEntityMapper orderEntityMapper;

    @Override
    public DubboOrderStatusStatResponse queryOrderStatByStatus(DubboOrderStatusStatRequest request) {
        DubboOrderStatusStatResponse response = new DubboOrderStatusStatResponse();
        try {

            if (null == request) {
                throw new RuntimeException("DubboOrderStatusStatRequest 参数为 null");
            }
            
            List<OrderStatVO> statByStatus = orderEntityMapper.selectStatByStatus(request.getSellerId());

            if (null != statByStatus && statByStatus.size() > 0) {
                
                Map<String, Integer> countMap = new HashMap<>(statByStatus.size());
                for (OrderStatVO vo : statByStatus) {
                    countMap.put(vo.getStatus().toUpperCase(), vo.getCount());
                }

                response.setCancelledCount(null == countMap.get("CANCELLED") ? Integer.valueOf(0) : countMap.get("CANCELLED"));
                response.setClosedCount(null == countMap.get("CLOSED") ? Integer.valueOf(0) : countMap.get("CLOSED"));
                response.setPaidCount(null == countMap.get("PAID") ? Integer.valueOf(0) : countMap.get("PAID"));
                response.setPartShippedCount(null == countMap.get("PART_SHIPPED") ? Integer.valueOf(0) : countMap.get("PART_SHIPPED"));
                response.setRefundingCount(null == countMap.get("REFUNDING") ? Integer.valueOf(0) : countMap.get("REFUNDING"));
                response.setShippedCount(null == countMap.get("SHIPPED") ? Integer.valueOf(0) : countMap.get("SHIPPED"));
                response.setSubmittedCount(null == countMap.get("SUBMITTED") ? Integer.valueOf(0) : countMap.get("SUBMITTED"));
                response.setSuccessCount(null == countMap.get("SUCCESS") ? Integer.valueOf(0) : countMap.get("SUCCESS"));
                response.setWaitPayConfirmCount(null == countMap.get("WAITPAYCONFIRM") ? Integer.valueOf(0) : countMap.get("WAITPAYCONFIRM"));
            }


            response.setSellerId(request.getSellerId());
            
            logger.info("执行订单统计 , request: {}, response:{}", JSONObject.toJSONString(request), JSONObject.toJSONString(response));
            response.setCode(DubboReturnCode.SUCCESS);
            return response;

        } catch (Exception e) {
            logger.error("统计订单状态异常: ", e);
            response.setCode(DubboReturnCode.FAILED);
            response.setDesc("统计失败");
            return response;
        }
    }

    @Override
    public DubboYesterdayOrderResponse queryOrderStatYesterdayOrder(DubboOrderStatusStatRequest request) {
        DubboYesterdayOrderResponse response = new DubboYesterdayOrderResponse();
        try {

            if (null == request) {
                throw new RuntimeException("DubboOrderStatusStatRequest 参数为 null");
            }
            
            Map<String, Object> params = new HashMap<>(10);
            params.putAll(this.getYesterdayStr());
            params.put("sellerId", request.getSellerId());
//            params.put("status", Lists.newArrayList(OrderStatusEnum.PAID.name(), OrderStatusEnum.REFUNDING.name(), OrderStatusEnum.CANCELLED.name()));
            
            Integer yesterdayCount = orderEntityMapper.selectYesterdayOrder(params);

            if (null != yesterdayCount) {
                response.setYesterdayOrderCount(yesterdayCount);
            }
            
            response.setSellerId(request.getSellerId());

            logger.info("执行昨日订单统计 , request: {}, response:{}", JSONObject.toJSONString(request), JSONObject.toJSONString(response));
            response.setCode(DubboReturnCode.SUCCESS);
            return response;

        } catch (Exception e) {
            logger.error("统计昨日订单异常: ", e);
            response.setCode(DubboReturnCode.FAILED);
            response.setDesc("统计失败");
            return response;
        }
    }

    
    private SimpleDateFormat startFormat = new SimpleDateFormat("yyyy-MM-dd 00:00:00");
    private SimpleDateFormat endFormat = new SimpleDateFormat("yyyy-MM-dd 23:59:59");
    private long oneDay = 24 * 3600 * 1000;
    /**
     * 功能描述：获取昨天的时间范围字符串
     * @return Map<String,String>
     */
    private Map<String, String> getYesterdayStr() {
        
        Date as = new Date(new Date().getTime() - oneDay);
        
        String startStr = startFormat.format(as);
        String endStr = endFormat.format(as);
        
        Map<String, String> map  = new HashMap<>(2);
        map.put("startStr", startStr);
        map.put("endStr", endStr);
        
        return map;
    }
}
