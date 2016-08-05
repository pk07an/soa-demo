package com.meila.soa.product.api.model.response;

import java.util.List;

import com.meila.dubbo.base.model.DubboBasicPageResponse;
import com.meila.soa.product.api.model.dto.fragment.DubboFragment;

/**
 ************************************************************
 * @类名 : DubboQueryFragmentResponse.java
 *
 * @DESCRIPTION :
 * @AUTHOR : hawk
 * @DATE : 2016年3月31日
 ************************************************************
 */
public class DubboQueryFragmentResponse extends DubboBasicPageResponse {

    private static final long serialVersionUID = 1L;

    private List<DubboFragment> fragmentList;

    public List<DubboFragment> getFragmentList() {
        return fragmentList;
    }

    public void setFragmentList(List<DubboFragment> fragmentList) {
        this.fragmentList = fragmentList;
    }
}
