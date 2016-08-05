package com.meila.soa.product.dal.dao.shop;

import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.ibatis.annotations.Param;

import com.meila.soa.product.dal.entity.shop.Shop;
import com.meila.soa.product.dal.entity.shop.ShopAdmin;

public interface ShopMapper {

    int deleteByPrimaryKey(Long id);

    int insert(Shop record);

    int insertSelective(Shop record);

    Shop selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(Shop record);

    int updateByPrimaryKey(Shop record);

    List<Shop> selectByList(List<Long> shopIdList);

    Shop selectByCode(@Param(value = "code") String code);

    List<Shop> selectByIdList(@Param(value = "ids") Set<String> shopIds);

    Shop selectByShopName(String shopName);

    Shop selectByUserId(Long userId);

    Long countByCode(@Param("code") String code);

    List<Shop> selectBySelective(Shop shop);

    List<Shop> selectByPage(@Param("record") Shop record, @Param("param") Map<String, Long> param);

    List<ShopAdmin> listShopsByAdmin(@Param(value = "params") Map<String, Object> params, @Param(value = "page") Map<String, Long> pageable);

    Long countShopsByAdmin(@Param(value = "params") Map<String, Object> params);

    List<Shop> selectbyUserIdList(List<Long> ownerIdList);
}
