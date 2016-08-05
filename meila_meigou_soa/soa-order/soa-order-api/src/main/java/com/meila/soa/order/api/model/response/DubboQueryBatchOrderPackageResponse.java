package com.meila.soa.order.api.model.response;

import java.util.List;
import java.util.Map;

import com.meila.dubbo.base.model.DubboBasicResponse;
import com.meila.soa.order.api.model.dto.DubboBatchOrderPackage;

@SuppressWarnings("serial")
public class DubboQueryBatchOrderPackageResponse extends DubboBasicResponse {

    // key为orderNo，value为对应的包裹列表
    private Map<String, List<DubboBatchOrderPackage>> batchOrderPackageMap;

    public Map<String, List<DubboBatchOrderPackage>> getBatchOrderPackageMap() {
        return batchOrderPackageMap;
    }

    public void setBatchOrderPackageMap(Map<String, List<DubboBatchOrderPackage>> batchOrderPackageMap) {
        this.batchOrderPackageMap = batchOrderPackageMap;
    }


}
