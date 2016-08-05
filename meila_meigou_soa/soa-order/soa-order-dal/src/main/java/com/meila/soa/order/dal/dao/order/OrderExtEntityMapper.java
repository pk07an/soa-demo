package com.meila.soa.order.dal.dao.order;

import java.util.List;

import com.meila.soa.order.dal.entity.order.OrderExtEntity;

public interface OrderExtEntityMapper {
    int deleteByPrimaryKey(Long id);

    int insertSelective(OrderExtEntity record);

    OrderExtEntity selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(OrderExtEntity record);
    
    /**
     * 
     *
     * 功能描述：根据orderId列表获取订单扩展信息
     * 
     * @param orderIds
     * @return List<OrderExtVO>
     *
     */
    List<OrderExtEntity> selectByOrderIds(List<Long> orderIds);
    
    /**
     * 
     *
     * 功能描述：根据orderId
     * 
     * @param orderId
     * @return OrderExtVO
     *
     */
    OrderExtEntity selectByOrderId(Long orderId);
    
    /**
     * 
     *
     * 功能描述：更新orderId更新扩展表数据
     * 
     * @param record
     * @return int
     *
     */
    int updateByOrderId(OrderExtEntity record);
}