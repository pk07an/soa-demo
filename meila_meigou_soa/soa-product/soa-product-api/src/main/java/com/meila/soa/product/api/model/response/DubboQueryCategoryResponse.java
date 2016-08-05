package com.meila.soa.product.api.model.response;

import java.util.List;

import com.meila.dubbo.base.model.DubboBasicResponse;
import com.meila.soa.product.api.model.dto.DubboCategory;

/**
 * 
 ************************************************************
 * @类名 : DubboQueryCategoryResponse.java
 *
 * @DESCRIPTION :查询分类树返回类
 * @AUTHOR : hawk
 * @DATE : 2016年1月14日
 ************************************************************
 */
public class DubboQueryCategoryResponse extends DubboBasicResponse {
    private static final long serialVersionUID = 1L;
    private List<DubboCategory> categoryList;

    public List<DubboCategory> getCategoryList() {
        return categoryList;
    }

    public void setCategoryList(List<DubboCategory> categoryList) {
        this.categoryList = categoryList;
    }
}
