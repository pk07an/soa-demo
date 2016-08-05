package com.meila.soa.product.dal.dao.product;

import java.util.List;

import com.meila.soa.product.dal.entity.product.SkuInvOperateLog;

public interface SkuInvOperateLogMapper {
    int deleteByPrimaryKey(Long logId);

    int insert(SkuInvOperateLog record);

    int insertSelective(SkuInvOperateLog record);

    SkuInvOperateLog selectByPrimaryKey(Long logId);

    int updateByPrimaryKeySelective(SkuInvOperateLog record);

    int updateByPrimaryKey(SkuInvOperateLog record);

    List<SkuInvOperateLog> selectBySelective(SkuInvOperateLog record);
}
