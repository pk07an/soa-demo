package com.meila.soa.product.dal.dao.product;

import java.awt.print.Pageable;
import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.meila.soa.product.dal.entity.product.SkuExt;
import com.meila.soa.product.dal.entity.product.SkuExtExample;

public interface SkuExtMapper {
    int countByExample(@Param("example") SkuExtExample example);

    int deleteByExample(SkuExtExample example);

    int deleteByPrimaryKey(Long id);

    int insert(SkuExt record);

    int insertSelective(SkuExt record);

    List<SkuExt> selectByExample(@Param("example") SkuExtExample example);

    SkuExt selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") SkuExt record, @Param("example") SkuExtExample example);

    int updateByExample(@Param("record") SkuExt record, @Param("example") SkuExtExample example);

    int updateByPrimaryKeySelective(SkuExt record);

    int updateByPrimaryKey(SkuExt record);

    /**
     * 
     *
     * 功能描述：分页查询列表
     * 
     * @param example 查询条件
     * @param page 分页参数
     * @return List<SkuExt>
     *
     */
    List<SkuExt> selectByPage(@Param("example") SkuExtExample example, @Param("page") Pageable page);

    /**
     * 
     *
     * 功能描述：批量入库
     * 
     * @param skuExts
     * @return int
     *
     */
    int insertBatchSkuExt(@Param("skuExts") List<SkuExt> skuExts);

    /**
     * 根据SkuId查询Ext信息
     * 
     * @param skuId sku的ID
     * @return List&lt;SkuExt&gt; skuExt集合
     * @exception {说明在某情况下,将发生什么异常}
     */
    List<SkuExt> selectBySkuId(@Param("skuId") Long skuId);

    /**
     * 根据SkuId集合查询Ext信息
     * 
     * @param skuIdList skuId集合
     * @return List&lt;SkuExt&gt; skuExt集合
     * @exception {说明在某情况下,将发生什么异常}
     */
    List<SkuExt> selectBySkuIdList(List<Long> skuIdList);
}
