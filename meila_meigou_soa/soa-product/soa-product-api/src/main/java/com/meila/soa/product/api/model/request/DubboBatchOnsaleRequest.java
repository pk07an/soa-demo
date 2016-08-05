package com.meila.soa.product.api.model.request;

import java.util.List;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotEmpty;

import com.meila.dubbo.base.model.DubboBasicRequest;

/**
 * 
 ************************************************************
 * @类名 : DubboBatchOnsaleRequest.java
 *
 * @DESCRIPTION :
 * @AUTHOR : hawk
 * @DATE : 2016年4月12日
 ************************************************************
 */
public class DubboBatchOnsaleRequest extends DubboBasicRequest {
    private static final long serialVersionUID = 1L;

    @NotNull(message = "用户ID不能为空")
    private Long userId;

    @NotNull(message = "id列表不能为空")
    @NotEmpty(message = "id列表不能为空")
    private List<Long> idList;

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public List<Long> getIdList() {
        return idList;
    }

    public void setIdList(List<Long> idList) {
        this.idList = idList;
    }
}
