package com.meila.soa.order.dal.dao.order;

import java.util.Date;
import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.meila.soa.order.dal.entity.order.OrderItemEntity;

public interface OrderItemEntityMapper {
    int deleteByPrimaryKey(Long id);

    int insert(OrderItemEntity record);

    int insertSelective(OrderItemEntity record);

    OrderItemEntity selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(OrderItemEntity record);

    int updateByPrimaryKey(OrderItemEntity record);

    List<OrderItemEntity> selectBySkuIds(@Param("skuIds") List<Long> skuIds, @Param("orderStatus") String orderStatus,
        @Param("beginTime") Date beginTime, @Param("endTime") Date endTime);
    
    List<OrderItemEntity> selectByOrderIds(List<Long> orderIds);
}
