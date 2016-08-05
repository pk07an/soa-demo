package com.meila.soa.order.api.model.response;

import java.util.Map;

import com.meila.dubbo.base.model.DubboBasicResponse;
import com.meila.soa.order.api.model.dto.DubboOutPay;

@SuppressWarnings("serial")
public class DubboQueryOutPayMapByPayNosResponse extends DubboBasicResponse {

    private Map<String, DubboOutPay> outPayMap;

    public Map<String, DubboOutPay> getOutPayMap() {
        return outPayMap;
    }

    public void setOutPayMap(Map<String, DubboOutPay> outPayMap) {
        this.outPayMap = outPayMap;
    }

}
