package com.meila.soa.product.dal.dao.product;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.meila.soa.product.dal.entity.product.StatisticSpuSellnum;

public interface StatisticSpuSellnumMapper {
    int deleteByPrimaryKey(Long id);

    int insert(StatisticSpuSellnum record);

    int insertSelective(StatisticSpuSellnum record);

    StatisticSpuSellnum selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(StatisticSpuSellnum record);

    int updateByPrimaryKey(StatisticSpuSellnum record);

    List<StatisticSpuSellnum> selectByProductList(@Param("list") List<Long> productList, @Param("page") Map<String, Long> page);

    Long countByProductList(@Param("list") List<Long> productList);

    void deleteByProductId(@Param("productId") Long id);
}
