package com.meila.soa.product.service.innerservice.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.meila.soa.product.dal.dao.fragment.FragmentImageMapper;
import com.meila.soa.product.dal.entity.fragment.FragmentImage;
import com.meila.soa.product.service.innerservice.FragmentImageService;

@Service
public class FragmentImageServiceImpl implements FragmentImageService {
    @Autowired
    private FragmentImageMapper fragmentImageMapper;

    @Override
    public int insert(FragmentImage fragmentImage) {
        return fragmentImageMapper.insert(fragmentImage);
    }

    @Override
    public int deleteById(Long id) {
        return fragmentImageMapper.deleteById(id);
    }

    @Override
    public int deleteByFragmentId(Long id) {
        return fragmentImageMapper.deleteByFragmentId(id);
    }

    @Override
    public List<FragmentImage> selectByFragmentId(Long fragmentId) {
        return fragmentImageMapper.selectByFragmentId(fragmentId);
    }

    @Override
    public List<FragmentImage> selectByImgKey(String imgKey) {
        return fragmentImageMapper.selectByImgKey(imgKey);
    }

    @Override
    @Transactional
    public void moveBefore(Long srcId, Long destId) {
        FragmentImage dest = fragmentImageMapper.selectById(destId);
        fragmentImageMapper.incAllBeforeDest(dest.getFragmentId(), dest.getIdx(), 1);
        fragmentImageMapper.updateSrcIdx(srcId, dest.getIdx());
    }

    @Override
    @Transactional
    public void moveAfter(Long srcId, Long destId) {
        FragmentImage dest = fragmentImageMapper.selectById(destId);
        fragmentImageMapper.decAllAfterDest(dest.getFragmentId(), dest.getIdx(), -1);
        fragmentImageMapper.updateSrcIdx(srcId, dest.getIdx());
    }

    @Override
    public void delete4Update(Long fragmentId, List<Long> ids) {
        fragmentImageMapper.delete4Update(fragmentId, ids);
    }
}
