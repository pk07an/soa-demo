package com.meila.soa.product.api.model.response.fragment;

import java.util.List;

import com.meila.dubbo.base.model.DubboBasicPageResponse;
import com.meila.soa.product.api.model.dto.fragment.v1.DubboFragmentV1;

/**
 ************************************************************
 * @类名 : DubboQueryFragmentResponse.java
 *
 * @DESCRIPTION :
 * @AUTHOR : hawk
 * @DATE : 2016年3月31日
 ************************************************************
 */
public class DubboQueryFragmentResponseV1 extends DubboBasicPageResponse {

    private static final long serialVersionUID = 1L;

    private List<DubboFragmentV1> fragmentList;

    public List<DubboFragmentV1> getFragmentList() {
        return fragmentList;
    }

    public void setFragmentList(List<DubboFragmentV1> fragmentList) {
        this.fragmentList = fragmentList;
    }
}
