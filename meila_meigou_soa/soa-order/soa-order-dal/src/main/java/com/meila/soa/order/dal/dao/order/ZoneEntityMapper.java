package com.meila.soa.order.dal.dao.order;

import java.util.List;

import com.meila.soa.order.dal.entity.order.ZoneEntity;

public interface ZoneEntityMapper {

    int deleteByPrimaryKey(Long id);

    int insertSelective(ZoneEntity record);

    ZoneEntity selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(ZoneEntity record);
    
    /**
     * 
     *
     * 功能描述：查询所有的地区
     * 
     * @return List<ZoneEntity>
     *
     */
    List<ZoneEntity> selectAll();

}