package com.meila.soa.product.api.model.request.inventory;

import java.util.List;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotEmpty;

import com.meila.dubbo.base.model.DubboBasicRequest;
import com.meila.soa.product.api.model.dto.DubboSkuAmountInfo;

public class DubboRecoveryInvRequest extends DubboBasicRequest {
    private static final long serialVersionUID = 1L;

    /**
     * 订单编号
     */
    private String orderNo;

    @NotNull(message = "sku信息不能为空")
    @NotEmpty(message = "不包含sku信息")
    private List<DubboSkuAmountInfo> skuAmountInfoList;

    public String getOrderNo() {
        return orderNo;
    }

    public void setOrderNo(String orderNo) {
        this.orderNo = orderNo;
    }

    public List<DubboSkuAmountInfo> getSkuAmountInfoList() {
        return skuAmountInfoList;
    }

    public void setSkuAmountInfoList(List<DubboSkuAmountInfo> skuAmountInfoList) {
        this.skuAmountInfoList = skuAmountInfoList;
    }
}
