package com.meila.soa.product.api.model.response;

import java.util.List;

import com.meila.dubbo.base.model.DubboBasicPageResponse;
import com.meila.soa.product.api.model.dto.DubboSkuBasicInfo;

/**
 * 
 ************************************************************
 * @类名 : DubboQueryCategoryResponse.java
 *
 * @DESCRIPTION :查询分类树返回类
 * @AUTHOR : hawk
 * @DATE : 2016年1月14日
 ************************************************************
 */
public class DubboQuerySkuListResponse extends DubboBasicPageResponse {

    private static final long serialVersionUID = 1L;
    private List<DubboSkuBasicInfo> dubboSkuBasicInfoList;

    public List<DubboSkuBasicInfo> getDubboSkuBasicInfoList() {
        return dubboSkuBasicInfoList;
    }

    public void setDubboSkuBasicInfoList(List<DubboSkuBasicInfo> dubboSkuBasicInfoList) {
        this.dubboSkuBasicInfoList = dubboSkuBasicInfoList;
    }
}
