package com.meila.soa.product.dal.dao.erp;

import java.util.List;

import com.meila.soa.product.dal.entity.erp.ErpCategory;

public interface ErpCategoryMapper {
    int deleteByPrimaryKey(Long categoryId);

    int insert(ErpCategory record);

    int insertSelective(ErpCategory record);

    ErpCategory selectByPrimaryKey(Long categoryId);

    int updateByPrimaryKeySelective(ErpCategory record);

    int updateByPrimaryKey(ErpCategory record);

    int insertList(List<ErpCategory> recordList);

    List<ErpCategory> selectPageBySelective(ErpCategory record);

    int deleteByIdList(List<ErpCategory> recordList);
}
