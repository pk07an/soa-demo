package com.meila.soa.product.dal.dao.erp;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.meila.soa.product.dal.entity.erp.ErpInventory;

public interface ErpInventoryMapper {
    int deleteByPrimaryKey(Long erpInveId);

    int insert(ErpInventory record);

    int insertSelective(ErpInventory record);

    ErpInventory selectByPrimaryKey(Long erpInveId);

    int updateByPrimaryKeySelective(ErpInventory record);

    int updateByPrimaryKey(ErpInventory record);

    int insertList(List<ErpInventory> recordList);

    List<ErpInventory> selectBySelective(ErpInventory record);

    List<ErpInventory> selectPageBySelective(@Param("record") ErpInventory record, @Param("beginId") Long beginId, @Param("pageSize") Long pageSize);

    int deleteByIdList(List<ErpInventory> recordList);
}
