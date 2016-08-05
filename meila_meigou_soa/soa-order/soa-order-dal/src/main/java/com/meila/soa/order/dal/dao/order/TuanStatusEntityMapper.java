package com.meila.soa.order.dal.dao.order;

import java.util.List;

import com.meila.soa.order.dal.entity.order.TuanStatusEntity;

public interface TuanStatusEntityMapper {

    int deleteByPrimaryKey(Long id);

    int insertSelective(TuanStatusEntity record);

    TuanStatusEntity selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(TuanStatusEntity record);
    
    /**
     * 
     *
     * 功能描述：根据拼团编号查找拼团状态
     * 
     * @param tuanNo
     * @return TuanStatusEntity
     *
     */
    TuanStatusEntity selectByTuanNo(String tuanNo);
    
    /**
     * 
     *
     * 功能描述：根据拼团编号获取团状态
     * 
     * @param tuanNos
     * @return List<TuanStatusEntity>
     *
     */
    List<TuanStatusEntity> selectByTuanNos(List<String> tuanNos);
}