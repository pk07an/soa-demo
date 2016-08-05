package com.meila.soa.product.dal.dao.product;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.meila.soa.product.dal.entity.product.SkuWMSInv;

public interface SkuWMSInvMapper {
    int deleteByPrimaryKey(Long skuInvId);

    int insert(SkuWMSInv record);

    int insertSelective(SkuWMSInv record);

    SkuWMSInv selectByPrimaryKey(Long skuInvId);

    int updateByPrimaryKeySelective(SkuWMSInv record);

    int updateByPrimaryKey(SkuWMSInv record);

    int updateInv(@Param("skuId") String skuId, @Param("changeNum") Integer changeNum, @Param("lockNum") Integer lockNum);

    List<SkuWMSInv> selectByselective(SkuWMSInv skuWMSInvRecord);

    int lockInv(@Param("record") SkuWMSInv skuWMSInvRecord, @Param("params") Map<String, Object> params);

    void unlockInv(@Param("record") SkuWMSInv skuWMSInvRecord);
}
