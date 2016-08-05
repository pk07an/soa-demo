package com.meila.soa.product.api;

import com.meila.dubbo.base.model.DubboBasicResponse;
import com.meila.soa.product.api.model.request.DubboAddFragmentRequest;
import com.meila.soa.product.api.model.request.DubboAddProductFragmentInfoRequest;
import com.meila.soa.product.api.model.request.DubboQueryFragmentRequest;
import com.meila.soa.product.api.model.request.fragment.DubboQueryFragmentByProductIdRequest;
import com.meila.soa.product.api.model.response.DubboAddFragmentResponse;
import com.meila.soa.product.api.model.response.DubboQueryFragmentResponse;
import com.meila.soa.product.api.model.response.fragment.DubboQueryFragmentResponseV1;

public interface DubboFragmentService {
    DubboQueryFragmentResponse queryFragment(DubboQueryFragmentRequest req);

    DubboAddFragmentResponse addFragment(DubboAddFragmentRequest req);

    DubboBasicResponse addProductFragmentInfo(DubboAddProductFragmentInfoRequest req);

    DubboQueryFragmentResponseV1 queryFragmentByProductId(DubboQueryFragmentByProductIdRequest req);

}
