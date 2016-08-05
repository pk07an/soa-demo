package com.meila.soa.proxy.dal.dao.ErpRequestLog;

import com.meila.soa.proxy.dal.entity.ErpRequestLog.ErpRequestLogEntity;

public interface ErpRequestLogEntityMapper {
    int deleteByPrimaryKey(Long erpReqId);

    int insert(ErpRequestLogEntity record);

    int insertSelective(ErpRequestLogEntity record);

    ErpRequestLogEntity selectByPrimaryKey(Long erpReqId);

    int updateByPrimaryKeySelective(ErpRequestLogEntity record);

    int updateByPrimaryKeyWithBLOBs(ErpRequestLogEntity record);

    int updateByPrimaryKey(ErpRequestLogEntity record);
}