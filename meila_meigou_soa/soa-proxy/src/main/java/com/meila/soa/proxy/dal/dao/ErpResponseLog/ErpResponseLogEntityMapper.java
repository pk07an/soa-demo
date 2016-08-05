package com.meila.soa.proxy.dal.dao.ErpResponseLog;

import com.meila.soa.proxy.dal.entity.ErpResponseLog.ErpResponseLogEntity;

public interface ErpResponseLogEntityMapper {
    int deleteByPrimaryKey(Long erpRespId);

    int insert(ErpResponseLogEntity record);

    int insertSelective(ErpResponseLogEntity record);

    ErpResponseLogEntity selectByPrimaryKey(Long erpRespId);

    int updateByPrimaryKeySelective(ErpResponseLogEntity record);

    int updateByPrimaryKeyWithBLOBs(ErpResponseLogEntity record);

    int updateByPrimaryKey(ErpResponseLogEntity record);
}