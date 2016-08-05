package com.meila.soa.product.service.dubboservice;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

import javax.annotation.Resource;

import com.meila.common.bean.utils.BeanMapper;
import com.meila.dubbo.base.model.DubboBasicResponse;
import com.meila.soa.product.api.DubboFragmentService;
import com.meila.soa.product.api.model.dto.fragment.DubboFragment;
import com.meila.soa.product.api.model.dto.fragment.DubboFragmentImage;
import com.meila.soa.product.api.model.dto.fragment.v1.DubboFragmentImageV1;
import com.meila.soa.product.api.model.dto.fragment.v1.DubboFragmentV1;
import com.meila.soa.product.api.model.request.DubboAddFragmentRequest;
import com.meila.soa.product.api.model.request.DubboAddProductFragmentInfoRequest;
import com.meila.soa.product.api.model.request.DubboQueryFragmentRequest;
import com.meila.soa.product.api.model.request.fragment.DubboQueryFragmentByProductIdRequest;
import com.meila.soa.product.api.model.response.DubboAddFragmentResponse;
import com.meila.soa.product.api.model.response.DubboQueryFragmentResponse;
import com.meila.soa.product.api.model.response.fragment.DubboQueryFragmentResponseV1;
import com.meila.soa.product.dal.dao.product.ProductMapper;
import com.meila.soa.product.dal.entity.fragment.Fragment;
import com.meila.soa.product.dal.entity.fragment.FragmentImage;
import com.meila.soa.product.dal.entity.fragment.ProductFragment;
import com.meila.soa.product.dal.entity.product.Product;
import com.meila.soa.product.service.exceptions.BizException;
import com.meila.soa.product.service.exceptions.GlobalErrorCode;
import com.meila.soa.product.service.innerservice.FragmentImageService;
import com.meila.soa.product.service.innerservice.FragmentService;
import com.meila.soa.product.service.innerservice.ProductFragmentService;
import com.meila.soa.product.service.innerservice.ProductService;

/**
 * 
 ************************************************************
 * @类名 : DubboFragmentServiceImpl.java
 *
 * @DESCRIPTION :
 * @AUTHOR : hawk
 * @DATE : 2016年3月25日
 ************************************************************
 */
public class DubboFragmentServiceImpl implements DubboFragmentService {

    @Resource
    private FragmentService fragmentService;

    @Resource
    private FragmentImageService fragmentImageService;

    @Resource
    private ProductFragmentService productFragmentService;

    @Resource
    private ProductService productService;

    @Resource
    private ProductMapper productMapper;

    @Override
    public DubboQueryFragmentResponse queryFragment(DubboQueryFragmentRequest req) {
        Fragment fragment = BeanMapper.map(req, Fragment.class);
        List<Fragment> fragmentList = fragmentService.selectBySelective(fragment);

        List<DubboFragment> dubboFragmentList = new ArrayList<DubboFragment>();

        for (Fragment vo : fragmentList) {
            List<FragmentImage> imgs = fragmentImageService.selectByFragmentId(vo.getId());

            DubboFragment tempDubboFragment = BeanMapper.map(vo, DubboFragment.class);

            tempDubboFragment.setFragmentImageList(BeanMapper.map(imgs, DubboFragmentImage.class));
            dubboFragmentList.add(tempDubboFragment);
        }

        DubboQueryFragmentResponse dubboResp = new DubboQueryFragmentResponse();
        dubboResp.setFragmentList(dubboFragmentList);

        return dubboResp;
    }

    @Override
    public DubboAddFragmentResponse addFragment(DubboAddFragmentRequest req) {
        Fragment fragment = BeanMapper.map(req, Fragment.class);

        Long shopId = req.getShopId();
        fragment.setShopId(shopId);
        fragment.setDescription(fragment.getDescription());

        List<FragmentImage> fragmentImageListOld;
        if (null == fragment.getId()) {
            fragmentService.insert(fragment);
        } else {
            fragmentService.update(fragment);
        }

        List<FragmentImage> fragmentImageList = BeanMapper.map(req.getFragmentImageList(), FragmentImage.class);
        fragmentImageListOld = fragmentImageService.selectByFragmentId(fragment.getId());

        // 删除老数据
        if (fragmentImageListOld != null && fragmentImageListOld.size() > 0) {
            for (int j = 0; j < fragmentImageListOld.size(); j++) {
                boolean isDel = false;
                for (int k = 0; k < fragmentImageList.size(); k++) {
                    if (fragmentImageListOld.get(j).getImg().equals(fragmentImageList.get(k))) {
                        isDel = true;
                    }
                }
                if (!isDel)
                    fragmentImageService.deleteById(fragmentImageListOld.get(j).getId());
            }
        }

        int i = 0;
        for (FragmentImage temp : fragmentImageList) {
            temp.setFragmentId(fragment.getId());
            temp.setIdx(i);
            fragmentImageService.insert(temp);
            i++;
        }

        DubboAddFragmentResponse dubboResp = new DubboAddFragmentResponse();

        DubboFragment dubboFragment = BeanMapper.map(fragment, DubboFragment.class);
        dubboFragment.setFragmentImageList(BeanMapper.map(fragmentImageList, DubboFragmentImage.class));

        dubboResp.setFragment(dubboFragment);

        return dubboResp;
    }

    @Override
    public DubboBasicResponse addProductFragmentInfo(DubboAddProductFragmentInfoRequest req) {
        Long shopId = req.getShopId();
        Product product = productMapper.selectById(req.getProductId());

        if (!shopId.equals(product.getShopId())) {
            throw new BizException(GlobalErrorCode.UNAUTHORIZED, "当前用户与店铺不符");
        }

        productFragmentService.deleteByProductId(req.getProductId());

        if (null != req.getFragmentIdList()) {
            List<Long> fragmentIds = req.getFragmentIdList();

            Set<Long> set = new LinkedHashSet<Long>(fragmentIds);

            fragmentIds = new ArrayList(set);

            for (int i = 0; i < fragmentIds.size(); i++) {
                Long fragmentId = fragmentIds.get(i);
                ProductFragment bean = new ProductFragment();
                bean.setProductId(req.getProductId());
                bean.setFragmentId(fragmentId);
                bean.setIdx(i);
                productFragmentService.insert(bean);
            }

            // 清除商品缓存
            productService.clearProductCache(product);
        }

        return new DubboBasicResponse();
    }

    @Override
    public DubboQueryFragmentResponseV1 queryFragmentByProductId(DubboQueryFragmentByProductIdRequest req) {
        DubboQueryFragmentResponseV1 dubboResp = new DubboQueryFragmentResponseV1();
        List<Fragment> fragmentList = fragmentService.selectByProductId(req.getProductId());
        dubboResp.setFragmentList(BeanMapper.map(fragmentList, DubboFragmentV1.class));

        for (DubboFragmentV1 temp : dubboResp.getFragmentList()) {
            List<FragmentImage> fragmentImageList = fragmentImageService.selectByFragmentId(temp.getFragmentId());
            temp.setFragmentImageList(BeanMapper.map(fragmentImageList, DubboFragmentImageV1.class));
        }

        return dubboResp;

    }
}
