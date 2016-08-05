package com.meila.soa.product.api.model.request.product;

import java.util.Date;

import javax.validation.constraints.Future;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import com.meila.dubbo.base.model.DubboBasicRequest;

/**
 * 
 ************************************************************
 * @类名 : DubboAddSpuRequest.java
 *
 * @DESCRIPTION :
 * @AUTHOR : hawk
 * @DATE : 2016年3月25日
 ************************************************************
 */
public class DubboUpdateProductStatusRequest extends DubboBasicRequest {
    private static final long serialVersionUID = 1L;

    @Min(value = 1, message = "用户ID不合法")
    @NotNull(message = "用户ID不能为空")
    private Long userId;
    @Min(value = 1, message = "商品ID不合法")
    @NotNull(message = "商品ID不能为空")
    private Long productId;

    @Pattern(regexp = "ONSALE|FORSALE|INSTOCK|DRAFT")
    private String productStatus;

    @Future(message = "上架时间不合法")
    private Date forsaleAt;

    public Date getForsaleAt() {
        return forsaleAt;
    }

    public void setForsaleAt(Date forsaleAt) {
        this.forsaleAt = forsaleAt;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    public String getProductStatus() {
        return productStatus;
    }

    public void setProductStatus(String productStatus) {
        this.productStatus = productStatus;
    }
}
