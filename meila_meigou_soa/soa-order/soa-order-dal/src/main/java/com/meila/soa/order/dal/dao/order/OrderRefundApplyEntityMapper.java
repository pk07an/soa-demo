package com.meila.soa.order.dal.dao.order;


import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.meila.soa.order.dal.entity.order.OrderRefundApplyEntity;
import com.meila.soa.order.dal.vo.order.RefundOrderVO;

public interface OrderRefundApplyEntityMapper {

    int deleteByPrimaryKey(Long id);

    int insertSelective(OrderRefundApplyEntity record);

    OrderRefundApplyEntity selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(OrderRefundApplyEntity record);
    
    /**
     * 
     *
     * 功能描述：根据order_id列表获取退款申请
     * 
     * @param orderIds
     * @return List<OrderRefundApply>
     *
     */
    List<OrderRefundApplyEntity> selectByOrderIds(List<Long> orderIds);
    
    /**
     * 
     *
     * 功能描述：根据order_id获取退款申请，已取最新的一条记录
     * 
     * @param OrderId
     * @return OrderRefundApplyEntity
     *
     */
    OrderRefundApplyEntity selectByOrderId(Long OrderId);
    
    /**
     * 
     *
     * 功能描述：根据条件更新表
     * 
     * @param entity
     * @param condition
     * @return int
     *
     */
    int updateByCondition(@Param("entity") OrderRefundApplyEntity entity, @Param("condition")Map<String,Object> condition);
    
    List<RefundOrderVO> selectByCondition(@Param("params")Map<String,Object> params);
    Long countByCondition(@Param("params")Map<String,Object> params);

}