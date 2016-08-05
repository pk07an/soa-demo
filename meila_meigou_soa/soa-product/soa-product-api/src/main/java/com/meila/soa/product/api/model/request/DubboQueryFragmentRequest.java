package com.meila.soa.product.api.model.request;

import com.meila.common.bean.utils.annotaion.MappingField;
import com.meila.dubbo.base.model.DubboBasicRequest;

/**
 * 
 ************************************************************
 * @类名 : DubboQueryFragmentRequest.java
 *
 * @DESCRIPTION :查询Fragment
 * @AUTHOR : hawk
 * @DATE : 2016年3月17日
 ************************************************************
 */
public class DubboQueryFragmentRequest extends DubboBasicRequest {
    private static final long serialVersionUID = 1L;

    /**
     * fragmentId
     */
    @MappingField("id")
    private Long fragmentId;

    /**
     * 店铺ID
     */
    private Long shopId;

    public Long getFragmentId() {
        return fragmentId;
    }

    public void setFragmentId(Long fragmentId) {
        this.fragmentId = fragmentId;
    }

    public Long getShopId() {
        return shopId;
    }

    public void setShopId(Long shopId) {
        this.shopId = shopId;
    }
}
