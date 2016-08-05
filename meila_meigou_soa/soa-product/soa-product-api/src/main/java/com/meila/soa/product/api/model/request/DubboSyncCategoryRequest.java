package com.meila.soa.product.api.model.request;

import java.util.List;

import org.hibernate.validator.constraints.NotEmpty;

import com.meila.dubbo.base.model.DubboBasicRequest;
import com.meila.soa.product.api.model.dto.DubboCategory;

/**
 * 
 ************************************************************
 * @类名 : DubboSyncCategoryRequest.java
 *
 * @DESCRIPTION :同步分类树请求类
 * @AUTHOR : hawk
 * @DATE : 2016年1月14日
 ************************************************************
 */
public class DubboSyncCategoryRequest extends DubboBasicRequest {
    private static final long serialVersionUID = 1L;

    @NotEmpty
    private List<DubboCategory> categoryList;

    public List<DubboCategory> getCategoryList() {
        return categoryList;
    }

    public void setCategoryList(List<DubboCategory> categoryList) {
        this.categoryList = categoryList;
    }
}
