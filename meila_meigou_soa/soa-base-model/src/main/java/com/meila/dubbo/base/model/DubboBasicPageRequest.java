package com.meila.dubbo.base.model;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

/**
 * 
 ************************************************************
 * @类名 : DubboBasicPageRequest.java
 *
 * @DESCRIPTION : 分页请求基础类
 * @AUTHOR : hawk
 * @DATE : 2016年1月14日
 ************************************************************
 */
public class DubboBasicPageRequest extends DubboBasicRequest {
    private static final long serialVersionUID = 1L;

    @NotNull
    @Min(value = 1)
    @Max(value = 1000)
    private Long pageSize = 1000L;

    @NotNull
    @Min(value = 1)
    private Long currentPage = 1L;

    public Long getPageSize() {
        return pageSize;
    }

    public void setPageSize(Long pageSize) {
        this.pageSize = pageSize;
    }

    public Long getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(Long currentPage) {
        this.currentPage = currentPage;
    }

    public Long getBeginId() {
        return (currentPage - 1) * pageSize;
    }
}
