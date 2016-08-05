package com.meila.soa.product.dal.dao.product;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.meila.soa.product.dal.entity.product.Sku;
import com.meila.soa.product.dal.type.SkuType;

public interface SkuMapper {
    int deleteByPrimaryKey(Long id);

    int insert(Sku record);

    int insertSelective(Sku record);

    Sku selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(Sku record);

    int updateByPrimaryKey(Sku record);

    List<Sku> selectByList(List<Long> productIdList);

    Sku selectOriginalById(Long id);

    Sku selectByCode(String code);

    Sku select(String productId, Long skuId);

    int updateForArchive(Long id);

    int updateAmount(Long id, Integer amount);

    List<Sku> selectByProductId(Long id);

    // void deductAmountByOrderId(String orderId);

    // void restoreAmountByOrderId(String orderId);

    int updatePriceDiscountByShop(@Param("shopId") Long shopId, @Param("discount") Float discount);

    int updatePriceDiscount(@Param("productId") String productId, @Param("discount") Float discount);

    int updatePriceReduction(@Param("productId") String productId, @Param("reduction") Float reduction);

    int updatePriceFromMarketPriceByShop(@Param("shopId") Long shopId);

    int updatePriceFromMarketPrice(@Param("productId") String productId);

    List<Sku> selectByIds(String... ids);

    List<Sku> selectByIdList(@Param("ids") List<Long> ids);

    int addCode(@Param("id") Long id, @Param("code") String code);

    int updateSaleBySkuId(@Param("skuId") Long skuId, @Param("sale") Integer sale);

    List<Sku> findSpuByProductIdAndName(@Param("productId") Long productId, @Param("spuName") String spuName);

    List<Sku> selectSkuListByProductId(@Param("productId") Long productId, @Param("skuType") SkuType skuType);

    List<Sku> querySkuByProductIds(@Param("productIds") List<Long> productIds);

    List<Sku> querySku(@Param("productIds") List<Long> productIds, @Param("skuType") String skuType);

    List<Sku> searchSkuByProductIdList(@Param("params") Map<String, Object> params, @Param("list") List<Long> productIdList,
        @Param("page") Map<String, Long> page);

    Long countSkuByProductIdList(@Param("params") Map<String, Object> params, @Param("list") List<Long> productIdList);
}
