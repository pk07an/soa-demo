package com.meila.soa.product.dal.dao.product;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.meila.soa.product.dal.entity.product.SkuBom;
import com.meila.soa.product.dal.entity.product.SkuBomExample;

public interface SkuBomMapper {
    int countByExample(SkuBomExample example);

    int deleteByExample(SkuBomExample example);

    int deleteByPrimaryKey(Long id);

    int insert(SkuBom record);

    int insertSelective(SkuBom record);

    List<SkuBom> selectByExample(SkuBomExample example);

    // List<SkuBomInfoVO> selectBySpuId(@Param("spuId") String spuId);

    SkuBom selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") SkuBom record, @Param("example") SkuBomExample example);

    int updateByExample(@Param("record") SkuBom record, @Param("example") SkuBomExample example);

    int updateByPrimaryKeySelective(SkuBom record);

    int updateByPrimaryKey(SkuBom record);

    List<SkuBom> selectBomListBySkuIdList(List<Long> skuIdList);

    List<SkuBom> selectBomListBySkuBundleIdList(List<Long> skunBundleIdList);
}
