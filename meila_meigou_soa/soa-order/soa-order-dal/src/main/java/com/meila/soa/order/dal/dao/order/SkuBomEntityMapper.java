package com.meila.soa.order.dal.dao.order;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.meila.soa.order.dal.entity.order.SkuBomEntity;

public interface SkuBomEntityMapper {
    int deleteByPrimaryKey(Long id);

    int insert(SkuBomEntity record);

    int insertSelective(SkuBomEntity record);

    SkuBomEntity selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(SkuBomEntity record);

    int updateByPrimaryKey(SkuBomEntity record);

    List<SkuBomEntity> selectBySkuId(@Param("skuIds") List<Long> skuIds);
}
