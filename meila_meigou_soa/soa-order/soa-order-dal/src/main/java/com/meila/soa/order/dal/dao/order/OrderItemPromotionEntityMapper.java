package com.meila.soa.order.dal.dao.order;

import java.util.List;

import com.meila.soa.order.dal.entity.order.OrderItemPromotionEntity;

public interface OrderItemPromotionEntityMapper {
    int deleteByPrimaryKey(Long id);

    int insertSelective(OrderItemPromotionEntity record);

    OrderItemPromotionEntity selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(OrderItemPromotionEntity record);
    
    /**
     * 
     *
     * 功能描述：根据订单号列表获取订单明细的优惠金额
     * 
     * @param orderNos
     * @return List<OrderItemPromotionEntity>
     *
     */
    List<OrderItemPromotionEntity> selectByOrderNos(List<String> orderNos);

}
