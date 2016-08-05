package com.meila.soa.order.dal.dao.order;

import com.meila.soa.order.dal.entity.order.OrderAddressEntity;

public interface OrderAddressEntityMapper {

    int deleteByPrimaryKey(Long id);

    int insertSelective(OrderAddressEntity record);

    OrderAddressEntity selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(OrderAddressEntity record);
    
    /**
     * 
     *
     * 功能描述：根据orderId获取订单地址信息
     * 
     * @param orderId
     * @return OrderAddressEntity
     *
     */
    OrderAddressEntity selectByOrderId(Long orderId);
    
    /**
     * 
     *
     * 功能描述：根据OrderId更新地址表信息
     * 
     * @param record
     * @return int
     *
     */
    int updateByOrderId(OrderAddressEntity record);
    

}