package com.meila.soa.product.api.model.response;

import java.util.List;

import com.meila.dubbo.base.model.DubboBasicPageResponse;
import com.meila.soa.product.api.model.dto.DubboSpuBasicInfo;

/**
 * 
 ************************************************************
 * @类名 : DubboQuerySpuListResponse.java
 *
 * @DESCRIPTION :查询SPU基础信息
 * @AUTHOR : hawk
 * @DATE : 2016年3月22日
 ************************************************************
 */
public class DubboQuerySpuListResponse extends DubboBasicPageResponse {
    private static final long serialVersionUID = 1L;

    private List<DubboSpuBasicInfo> spuBasicInfoList;

    public List<DubboSpuBasicInfo> getSpuBasicInfoList() {
        return spuBasicInfoList;
    }

    public void setSpuBasicInfoList(List<DubboSpuBasicInfo> spuBasicInfoList) {
        this.spuBasicInfoList = spuBasicInfoList;
    }
}
