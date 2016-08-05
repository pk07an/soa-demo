package com.meila.soa.product.service.innerservice.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.meila.soa.product.dal.dao.fragment.FragmentMapper;
import com.meila.soa.product.dal.entity.fragment.Fragment;
import com.meila.soa.product.dal.entity.fragment.FragmentImage;
import com.meila.soa.product.dal.entity.fragment.ProductFragment;
import com.meila.soa.product.service.innerservice.FragmentImageService;
import com.meila.soa.product.service.innerservice.FragmentService;
import com.meila.soa.product.service.innerservice.ProductFragmentService;

@Service
public class FragmentServiceImpl implements FragmentService {
    @Autowired
    private FragmentMapper fragmentMapper;
    @Autowired
    private FragmentImageService fragmentImageService;
    @Autowired
    private ProductFragmentService productFragmentService;

    @Override
    public int insert(Fragment fragment) {
        Integer maxIdx = fragmentMapper.selectMaxByShopId(fragment.getShopId());
        fragment.setIdx(maxIdx == null ? 0 : maxIdx + 1);
        int rc = fragmentMapper.insert(fragment);
        fragmentMapper.addCode(fragment.getId());
        return rc;
    }

    @Override
    public int update(Fragment fragment) {
        return fragmentMapper.update(fragment);
    }

    @Override
    public int delete(Long id) {
        return fragmentMapper.deleteById(id);
    }

    @Override
    public Fragment selectById(Long id) {
        return fragmentMapper.selectById(id);
    }

    @Override
    public List<Fragment> selectByProductId(Long productId) {
        return fragmentMapper.selectByProductId(productId);
    }

    @Override
    public List<Fragment> selectByShopId(Long shopId) {
        return fragmentMapper.selectByShopId(shopId);
    }

    @Override
    @Transactional
    public void moveBefore(Long srcId, Long destId) {
        Fragment dest = fragmentMapper.selectById(destId);
        fragmentMapper.incAllBeforeDest(dest.getShopId(), dest.getIdx(), 1);
        fragmentMapper.updateSrcIdx(srcId, dest.getIdx());
    }

    @Override
    @Transactional
    public void moveAfter(Long srcId, Long destId) {
        Fragment dest = fragmentMapper.selectById(destId);
        fragmentMapper.decAllAfterDest(dest.getShopId(), dest.getIdx(), -1);
        fragmentMapper.updateSrcIdx(srcId, dest.getIdx());
    }

    @Override
    @Transactional
    public void insertFragmentToProduct(Fragment fragment, List<FragmentImage> fragmentImgs, Long productId) {

        // fragment
        this.insert(fragment);

        // fragment img
        if (null != fragmentImgs) {
            FragmentImage img = null;
            for (int i = 0; i < fragmentImgs.size(); i++) {
                img = fragmentImgs.get(i);
                img.setFragmentId(fragment.getId());
                fragmentImageService.insert(img);
            }
        }

        // product fragment
        ProductFragment pf = new ProductFragment();
        pf.setProductId(productId);
        pf.setFragmentId(fragment.getId());
        productFragmentService.insert(pf);
    }

    @Override
    public List<Fragment> selectBySelective(Fragment fragment) {
        return fragmentMapper.selectBySelective(fragment);
    }
}
