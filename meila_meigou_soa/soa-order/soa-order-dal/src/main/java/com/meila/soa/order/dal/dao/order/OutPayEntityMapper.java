package com.meila.soa.order.dal.dao.order;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.meila.soa.order.dal.entity.order.OutPayEntity;

public interface OutPayEntityMapper {
    int deleteByPrimaryKey(Long id);

    int insertSelective(OutPayEntity record);

    OutPayEntity selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(OutPayEntity record);

    /**
     * 
     *
     * 功能描述：根据PayNo查询OutPay集合
     * 
     * @param payNoList
     * @return List<OutPayEntity>
     *
     */
    List<OutPayEntity> selectOutPaysByPayNoList(@Param("payNoList") List<String> payNoList);
}
