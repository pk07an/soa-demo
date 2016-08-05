/**
 * 
 */
package com.meila.soa.order.api.model.request;

import java.util.List;

import com.meila.dubbo.base.model.DubboBasicRequest;

/**
 ************************************************************
 * @类名 : DubboQueryOrderByUserIds.java
 *
 * @DESCRIPTION :好友分享时，通过userid批量查询订单信息
 * @AUTHOR : flong
 * @DATE : 2016年3月14日
 ************************************************************
 */
public class DubboQueryOrderByUserIds4ShareRequest extends DubboBasicRequest {
    private static final long serialVersionUID = 1L;

    private List<Long> userIds;

    public List<Long> getUserIds() {
        return userIds;
    }

    public void setUserIds(List<Long> userIds) {
        this.userIds = userIds;
    }

}
