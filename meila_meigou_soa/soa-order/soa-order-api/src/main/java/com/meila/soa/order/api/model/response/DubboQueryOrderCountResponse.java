/**
 * 
 */
package com.meila.soa.order.api.model.response;

import com.meila.dubbo.base.model.DubboBasicResponse;

/**
 ************************************************************
 * @类名 : DubboQueryOrderSellNumResponse.java
 *
 * @DESCRIPTION :
 * @AUTHOR : flong
 * @DATE : 2016年4月6日
 ************************************************************
 */
@SuppressWarnings("serial")
public class DubboQueryOrderCountResponse extends DubboBasicResponse {

    private Integer count;

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

}
