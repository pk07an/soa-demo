package com.meila.soa.order.api.model.response;

import java.util.List;

import com.meila.dubbo.base.model.DubboBasicResponse;
import com.meila.soa.order.api.model.dto.DubboOrderPackage;

@SuppressWarnings("serial")
public class DubboQueryOrderPackageResponse extends DubboBasicResponse {

    private List<DubboOrderPackage> orderPackages;

    public List<DubboOrderPackage> getOrderPackages() {
        return orderPackages;
    }

    public void setOrderPackages(List<DubboOrderPackage> orderPackages) {
        this.orderPackages = orderPackages;
    }

}
