package com.meila.soa.product.api.model.response;

import com.meila.dubbo.base.model.DubboBasicPageResponse;
import com.meila.soa.product.api.model.dto.fragment.DubboFragment;

public class DubboAddFragmentResponse extends DubboBasicPageResponse {

    private static final long serialVersionUID = 1L;

    private DubboFragment fragment;

    public DubboFragment getFragment() {
        return fragment;
    }

    public void setFragment(DubboFragment fragment) {
        this.fragment = fragment;
    }
}
