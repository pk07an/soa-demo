package com.meila.soa.order.api.model.dto;

import java.util.ArrayList;
import java.util.List;

import com.meila.dubbo.base.model.BasicSeriModel;

/**
 * 
 ************************************************************
 * @类名 : DubboAddressZone.java
 *
 * @DESCRIPTION : 获取地区数据
 * @AUTHOR : gogo
 * @DATE : 2016年5月30日
 ************************************************************
 */
@SuppressWarnings("serial")
public class DubboAddressZone extends BasicSeriModel {

    private Long id;
    private String name;

    private List<DubboAddressZone> zoneList;

    public void addZone(DubboAddressZone zone)
    {
        if(zoneList == null)
        {
            zoneList = new ArrayList<>();
        }
        
        zoneList.add(zone);
    }
    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<DubboAddressZone> getZoneList() {
        return zoneList;
    }

    public void setZoneList(List<DubboAddressZone> zoneList) {
        this.zoneList = zoneList;
    }

}
