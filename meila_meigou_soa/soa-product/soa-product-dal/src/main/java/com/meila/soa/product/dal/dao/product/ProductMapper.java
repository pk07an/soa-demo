package com.meila.soa.product.dal.dao.product;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;
import org.springframework.data.domain.Sort.Direction;

import com.meila.soa.product.dal.entity.product.Product;

public interface ProductMapper {
    int deleteByPrimaryKey(Long id);

    int insert(Product record);

    int insertSelective(Product record);

    Product selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(Product record);

    int updateByPrimaryKeyWithBLOBs(Product record);

    int updateByPrimaryKey(Product record);

    List<Product> selectByIdList(List<Long> productIdList);

    List<Product> selectByCodeList(List<String> codeList);

    public Product selectById(@Param("id") Long id);

    void addCode(@Param("code") String code, @Param("id") Long id);

    /**
     * 功能描述：返库存使用
     * 
     * @param id
     * @return
     */
    public int refundAmountAndSales(@Param("id") Long id, @Param("amount") int amount);

    void updateProductAmountIncludeBom(Long productId);

    void updateProductPriceIncludeBom(Long productId);

    List<Product> selectBySelective(@Param("record") Product product, @Param("page") Map<String, Long> page);

    List<Product> selectByKwd(@Param("record") Product product, @Param("params") Map<String, Object> params);

    Long countByKwd(@Param("record") Product product, @Param("params") Map<String, Object> params);

    // 获取扩展属性
    Map<String, Object> loadInfo(Long productId);

    List<Product> selectProductListByShopId(Long shopId);

    int updateForInstock(Long id);

    int updateForOnsale(Long id);

    List<Product> listProductsBySales(@Param("shopId") Long shopId, @Param("page") Map<String, Long> page, @Param("direction") Direction direction);

    List<Product> listProductsBySales1(@Param("shopId") Long shopId, @Param("page") Map<String, Object> page,
        @Param("direction") Direction direction);

    List<Product> listProductsByAmount(@Param("shopId") Long shopId, @Param("page") Map<String, Long> page, @Param("direction") Direction direction);

    List<Product> listProductsByAmount1(@Param("shopId") Long shopId, @Param("page") Map<String, Object> page,
        @Param("direction") Direction direction);

    List<Product> listProductsBySoldout(@Param("shopId") Long shopId, @Param("page") Map<String, Long> page, @Param("direction") Direction direction);

    List<Product> listProductsBySoldout1(@Param("shopId") Long shopId, @Param("page") Map<String, Object> page,
        @Param("direction") Direction direction);

    List<Product> listProductsByStatusDraft(@Param("shopId") Long shopId, @Param("page") Map<String, Long> page);

    List<Product> listProductsByStatusDraft1(@Param("shopId") Long shopId, @Param("page") Map<String, Object> page);

    List<Product> listProductsByOutOfStock(@Param("shopId") Long shopId, @Param("page") Map<String, Long> page);

    List<Product> listProductsByOutOfStock1(@Param("shopId") Long shopId, @Param("page") Map<String, Object> page);

    List<Product> listProductsByOnsaleAt(@Param("shopId") Long shopId, @Param("page") Map<String, Long> page,
        @Param("params") HashMap<String, Object> params);

    List<Product> searchProduct(@Param("params") Map<String, Object> params, @Param("page") Map<String, Long> page);

    Long selectLastCnt(@Param("shopId") Long shopId, @Param(value = "catType") String catType, @Param("params") HashMap<String, Object> params);

    Long countBySelective(@Param("record") Product product, @Param("page") Map<String, Long> page);

    int updateFakeSales(@Param("id") Long productId, @Param("count") Integer fakeSales);

    List<Product> selectProductList(@Param("shopId") Long shopId, @Param("productName") String productName, @Param("onlyOnSale") Integer onlyOnSale);

    Long countProductBySearchParmas(@Param("params") Map<String, Object> params);

    /**
     *
     * 功能描述：计算卖家在售商品的数量
     * 
     * @param sellerId
     * @return Integer
     *
     */
    Integer selectOnSaleProductCount(@Param("sellerId") Long sellerId);

    /**
     *
     * 功能描述：售馨商品数量
     * 
     * @param sellerId
     * @return Integer
     *
     */
    Integer selectSoldOutProductCount(@Param("sellerId") Long sellerId);
}
