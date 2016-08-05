package com.meila.soa.order.dal.dao.order;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.meila.soa.order.dal.entity.order.OrderEntity;
import com.meila.soa.order.dal.vo.order.OrderStatVO;
import com.meila.soa.order.dal.vo.order.OrderVO;

public interface OrderEntityMapper {
    int deleteByPrimaryKey(Long id);

    int insert(OrderEntity record);

    int insertSelective(OrderEntity record);

    OrderEntity selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(OrderEntity record);

    int updateByPrimaryKey(OrderEntity record);

    List<OrderEntity> selectByBuyerIds(List<Long> buyerIds);
    
    List<OrderVO> selectByCondition(@Param("params")Map<String,Object> params);
    Long countByCondition(@Param("params")Map<String,Object> params);
    
    int updateByExecuteCondition(@Param("params")OrderEntity params, @Param("id")Long id, @Param("status")String status);

    /**
     *
     * 功能描述：统计订单状态的数量
     * 
     * @param sellerId
     * @return List<OrderStatVO>
     *
     */
    List<OrderStatVO> selectStatByStatus(@Param("sellerId") Long sellerId);

    
    /**
     *
     * 功能描述：统计昨日订单数量
     * 
     * @param params
     * @return Integer
     *
     */
    Integer selectYesterdayOrder(@Param("params") Map<String, Object> params);
    
    /**
     * 
     *
     * 功能描述：获取订单数，来自导出订单
     * 
     * @param params
     * @return Integer
     *
     */
    Integer countOrderByExport(@Param("params") Map<String, Object> params);
}
