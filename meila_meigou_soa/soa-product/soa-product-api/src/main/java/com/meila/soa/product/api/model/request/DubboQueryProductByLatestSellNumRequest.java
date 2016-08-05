package com.meila.soa.product.api.model.request;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

import com.meila.dubbo.base.model.DubboBasicPageRequest2;

public class DubboQueryProductByLatestSellNumRequest extends DubboBasicPageRequest2 {
    private static final long serialVersionUID = 1L;

    @NotNull(message = "卖家ID不能为空")
    @Min(value = 1, message = "卖家ID不合法")
    private Long sellerId;

    @NotNull(message = "查询天数不能为空")
    @Min(value = 1, message = "查询天数不合法")
    private Integer dayNum;

    public Long getSellerId() {
        return sellerId;
    }

    public void setSellerId(Long sellerId) {
        this.sellerId = sellerId;
    }

    public Integer getDayNum() {
        return dayNum;
    }

    public void setDayNum(Integer dayNum) {
        this.dayNum = dayNum;
    }
}
