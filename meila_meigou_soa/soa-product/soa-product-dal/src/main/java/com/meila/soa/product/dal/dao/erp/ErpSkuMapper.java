package com.meila.soa.product.dal.dao.erp;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.meila.soa.product.dal.entity.erp.ErpSku;

public interface ErpSkuMapper {
    int deleteByPrimaryKey(Long prdSkuId);

    int insert(ErpSku record);

    int insertSelective(ErpSku record);

    ErpSku selectByPrimaryKey(Long prdSkuId);

    int updateByPrimaryKeySelective(ErpSku record);

    int updateByPrimaryKey(ErpSku record);

    int insertList(List<ErpSku> recordList);

    List<ErpSku> selectPageBySelective(@Param("record") ErpSku record, @Param("param") Map<String, Object> paramMap);

    int deleteByIdList(List<ErpSku> recordList);

    Long selectPageTotalNumBySelective(@Param("record") ErpSku record, @Param("param") Map<String, Object> param);
}
