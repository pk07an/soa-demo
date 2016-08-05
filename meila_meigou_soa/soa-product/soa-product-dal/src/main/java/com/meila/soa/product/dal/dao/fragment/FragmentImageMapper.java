package com.meila.soa.product.dal.dao.fragment;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.meila.soa.product.dal.entity.fragment.FragmentImage;

public interface FragmentImageMapper {

    int insert(FragmentImage fragmentImage);

    int deleteById(@Param(value = "id") Long id);

    int deleteByFragmentId(@Param(value = "fragmentId") Long fragmentId);

    FragmentImage selectById(@Param(value = "id") Long id);

    Integer selectMaxByFragmentId(@Param(value = "fragmentId") Long fragmentId);

    List<FragmentImage> selectByFragmentId(@Param(value = "fragmentId") Long fragmentId);

    List<FragmentImage> selectByImgKey(@Param(value = "imgKey") String imgKey);

    void incAllBeforeDest(@Param(value = "fragmentId") Long fragmentId, @Param(value = "idx") int idx, @Param(value = "increment") int increment);

    void decAllAfterDest(@Param(value = "fragmentId") Long fragmentId, @Param(value = "idx") int idx, @Param(value = "increment") int increment);

    int updateSrcIdx(@Param(value = "id") Long id, @Param(value = "idx") int idx);

    void delete4Update(@Param("fragmentId") Long fragmentId, @Param("ids") List<Long> ids);
}
