package com.meila.soa.order.api.model.request;

import java.util.List;

import org.hibernate.validator.constraints.NotEmpty;

import com.meila.dubbo.base.model.DubboBasicRequest;

@SuppressWarnings("serial")
public class DubboQueryOutPayMapByPayNosRequest extends DubboBasicRequest {

    @NotEmpty
    private List<String> payNos;

    public List<String> getPayNos() {
        return payNos;
    }

    public void setPayNos(List<String> payNos) {
        this.payNos = payNos;
    }

}
