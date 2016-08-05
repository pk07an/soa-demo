package com.meila.soa.product.dal.dao.cart;

import java.util.List;
import java.util.Set;

import org.apache.ibatis.annotations.Param;

import com.meila.soa.product.dal.entity.cart.CartItem;

public interface CartItemMapper {
    /**
     * 功能描述：用户购物车中的商品数量
     * 
     * @param userId
     * @param cartType
     * @return
     */
    public Integer countByUserIdAndCartType(@Param("userId") Long userId, @Param("cartType") String cartType);

    public int deleteByKeyAndUserId(@Param("ids") List<String> ids, @Param("userId") Long userId, @Param("cartType") String cartType);

    int deleteByPrimaryKey(Long id);

    int deleteBySku(Long skuId);

    public void deleteBySkuAndCartType(@Param("userId") Long userId, @Param("skuId") Long skuId, @Param("cartType") String cartType);

    int deleteByUserId(Long userId);

    int deleteByUserIdAndShopId(Long id, Long shopId);

    int deleteByUserIdAndSkuId(Long userId, Long skuId);

    /**
     * 功能描述：物理商品skuId
     * 
     * @param userId
     * @param skuId
     * @param cartType
     * @return
     */
    public int deleteByUserIdAndSkuId(@Param("userId") Long userId, @Param("skuId") Long skuId, @Param("cartType") String cartType);

    int insert(CartItem record);

    CartItem selectByPrimaryKey(Long id);

    List<CartItem> selectByUserId(Long userId);

    public List<CartItem> selectByUserIdAndCartType(@Param("userId") Long userId, @Param("cartType") String cartType,
        @Param("skuIds") Set<String> skuIds);

    List<CartItem> selectByUserIdAndShopId(Long userId, Long shopId);

    CartItem selectByUserIdAndSku(Long userId, Long skuId);

    public CartItem selectByUserIdAndSku(@Param("skuId") Long skuId, @Param("userId") Long userId, @Param("cartType") String cartType);

    Integer selectCount(Long userId);

    int undeleteByPrimaryKey(Long id);

    int updateByPrimaryKey(CartItem record);

    int updateByPrimaryKeySelective(CartItem record);

    /**
     * 功能描述：更新购物车中的数量
     * 
     * @param skuId
     * @param amount
     * @param userId
     */
    public void updateBySkuSelective(@Param("skuId") Long skuId, @Param("amount") int amount, @Param("userId") Long userId);
}
