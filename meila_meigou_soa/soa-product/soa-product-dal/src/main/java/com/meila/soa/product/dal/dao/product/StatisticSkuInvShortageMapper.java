package com.meila.soa.product.dal.dao.product;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.meila.soa.product.dal.entity.product.StatisticSkuInvShortage;

public interface StatisticSkuInvShortageMapper {
    int deleteByPrimaryKey(Long id);

    int insert(StatisticSkuInvShortage record);

    int insertSelective(StatisticSkuInvShortage record);

    StatisticSkuInvShortage selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(StatisticSkuInvShortage record);

    int updateByPrimaryKey(StatisticSkuInvShortage record);

    List<StatisticSkuInvShortage> selectBySearch(@Param("record") StatisticSkuInvShortage statisticSkuInvShortage,
        @Param("param") Map<String, Object> param);

    Long countBySearch(@Param("record") StatisticSkuInvShortage statisticSkuInvShortage);

    void deleteBySellerId(Long sellerId);
}
