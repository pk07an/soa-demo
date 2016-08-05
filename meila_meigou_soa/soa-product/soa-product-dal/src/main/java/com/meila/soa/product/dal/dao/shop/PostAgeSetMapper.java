package com.meila.soa.product.dal.dao.shop;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.meila.soa.product.dal.entity.PostAgeSet;

public interface PostAgeSetMapper {

    PostAgeSet selectByPrimaryKey(Long id);

    List<PostAgeSet> selectByShopId(@Param("shopId") Long shopId);

    Long insert(PostAgeSet record);

    Long update(PostAgeSet record);

    int deleteByPrimaryKey(Long id);

}
