package com.meila.soa.product.service.innerservice.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.meila.soa.product.dal.dao.fragment.ProductFragmentMapper;
import com.meila.soa.product.dal.entity.fragment.ProductFragment;
import com.meila.soa.product.service.innerservice.ProductFragmentService;

@Service
public class ProductFragmentServiceImpl implements ProductFragmentService {

    @Autowired
    private ProductFragmentMapper productFragmentMapper;

    @Override
    public int insert(ProductFragment productFragment) {
        // Integer maxIdx = productFragmentMapper.selectMaxByProductId(productFragment.getProductId());
        // productFragment.setIdx(maxIdx == null ? 0 : maxIdx + 1);
        return productFragmentMapper.insert(productFragment);
    }

    @Override
    public int deleteById(Long id) {
        return productFragmentMapper.deleteById(id);
    }

    @Override
    public List<ProductFragment> selectByProductId(Long productId) {
        return productFragmentMapper.selectByProductId(productId);
    }

    @Override
    @Transactional
    public void moveBefore(Long srcId, Long destId) {
        ProductFragment dest = productFragmentMapper.selectById(destId);
        productFragmentMapper.incAllBeforeDest(dest.getProductId(), dest.getIdx(), 1);
        productFragmentMapper.updateSrcIdx(srcId, dest.getIdx());
    }

    @Override
    @Transactional
    public void moveAfter(Long srcId, Long destId) {
        ProductFragment dest = productFragmentMapper.selectById(destId);
        productFragmentMapper.decAllAfterDest(dest.getProductId(), dest.getIdx(), -1);
        productFragmentMapper.updateSrcIdx(srcId, dest.getIdx());
    }

    @Override
    public int deleteByProductId(Long productId) {
        return productFragmentMapper.deleteByProductId(productId);
    }
}
