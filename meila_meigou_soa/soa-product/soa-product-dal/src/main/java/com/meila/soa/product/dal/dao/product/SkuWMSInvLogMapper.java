package com.meila.soa.product.dal.dao.product;

import com.meila.soa.product.dal.entity.product.SkuWMSInvLog;

public interface SkuWMSInvLogMapper {
    int deleteByPrimaryKey(Long invLogId);

    int insert(SkuWMSInvLog record);

    int insertSelective(SkuWMSInvLog record);

    SkuWMSInvLog selectByPrimaryKey(Long invLogId);

    int updateByPrimaryKeySelective(SkuWMSInvLog record);

    int updateByPrimaryKey(SkuWMSInvLog record);
}
