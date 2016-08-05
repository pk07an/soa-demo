package com.meila.soa.product.api.model.request;

import java.util.List;

import com.meila.dubbo.base.model.DubboBasicRequest;
import com.meila.soa.product.api.model.dto.DubboInventory;

/**
 * 
 ************************************************************
 * @类名 : DubboSyncInventoryRequest.java
 *
 * @DESCRIPTION :同步库存请求信息类
 * @AUTHOR : hawk
 * @DATE : 2016年1月14日
 ************************************************************
 */
public class DubboSyncInventoryRequest extends DubboBasicRequest {
    private static final long serialVersionUID = 1L;

    private List<DubboInventory> inventoryList;

    public List<DubboInventory> getInventoryList() {
        return inventoryList;
    }

    public void setInventoryList(List<DubboInventory> inventoryList) {
        this.inventoryList = inventoryList;
    }
}
