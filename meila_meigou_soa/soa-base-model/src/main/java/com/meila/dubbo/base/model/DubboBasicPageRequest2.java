package com.meila.dubbo.base.model;

import java.util.List;

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
public class DubboBasicPageRequest2 extends DubboBasicRequest {
    /**
     * 
     ************************************************************
     * @类名 : DubboSort
     *
     * @DESCRIPTION : 排序列
     * @AUTHOR : hawk
     * @DATE : 2016年3月16日
     ************************************************************
     */
    public static class DubboSort extends BasicSeriModel {

        private static final long serialVersionUID = 1L;

        private String property;

        private String direction;

        private Boolean ignoreCase;

        public String getDirection() {
            return direction;
        }

        public Boolean getIgnoreCase() {
            return ignoreCase;
        }

        public String getProperty() {
            return property;
        }

        public void setDirection(String direction) {
            this.direction = direction;
        }

        public void setIgnoreCase(Boolean ignoreCase) {
            this.ignoreCase = ignoreCase;
        }

        public void setProperty(String property) {
            this.property = property;
        }

    }

    private static final long serialVersionUID = 1L;

    @NotNull
    @Min(value = 1)
    @Max(value = 1000)
    private Long pageSize = 1000L;

    @NotNull
    @Min(value = 1)
    private Long currentPage = 1L;

    /**
     * 排序列表
     */
    private List<DubboSort> sortList;

    public Long getBeginId() {
        return (currentPage - 1) * pageSize;
    }

    public Long getCurrentPage() {
        return currentPage;
    }

    public Long getPageSize() {
        return pageSize;
    }

    public void setCurrentPage(Long currentPage) {
        this.currentPage = currentPage;
    }

    public void setPageSize(Long pageSize) {
        this.pageSize = pageSize;
    }

    public List<DubboSort> getSortList() {
        return sortList;
    }

    public void setSortList(List<DubboSort> sortList) {
        this.sortList = sortList;
    }
}
