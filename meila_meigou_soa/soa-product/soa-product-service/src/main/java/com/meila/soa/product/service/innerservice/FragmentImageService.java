package com.meila.soa.product.service.innerservice;

import java.util.List;

import com.meila.soa.product.dal.entity.fragment.FragmentImage;

public interface FragmentImageService {

    int insert(FragmentImage fragmentImage);

    int deleteById(Long id);

    int deleteByFragmentId(Long fragmentId);

    void delete4Update(Long fragmentId, List<Long> ids);

    List<FragmentImage> selectByFragmentId(Long fragmentId);

    List<FragmentImage> selectByImgKey(String imgKey);

    void moveBefore(Long srcId, Long desId);

    void moveAfter(Long srcId, Long desId);
}
