package com.meila.soa.order.api.model.response;

import java.util.List;

import com.meila.dubbo.base.model.DubboBasicResponse;
import com.meila.soa.order.api.model.dto.DubboAddressZone;

/**
 * 
 ************************************************************
 * @类名 : DubboOrderAddressAllZoneListResponse.java
 *
 * @DESCRIPTION : 获取所有地区信息
 * @AUTHOR : gogo
 * @DATE : 2016年5月12日
 ************************************************************
 */
@SuppressWarnings("serial")
public class DubboQueryOrderAddressAllZoneListResponse extends DubboBasicResponse {

    private List<DubboAddressZone> zoneList;

    public List<DubboAddressZone> getZoneList() {
        return zoneList;
    }

    public void setZoneList(List<DubboAddressZone> zoneList) {
        this.zoneList = zoneList;
    }

}
