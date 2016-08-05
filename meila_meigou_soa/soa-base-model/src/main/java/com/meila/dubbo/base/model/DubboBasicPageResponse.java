/**
 * 
 */
package com.meila.dubbo.base.model;

/**
 * 
 ************************************************************
 * @类名 : DubboBasicPageResponse.java
 *
 * @DESCRIPTION : 分页请求返回基础类
 * @AUTHOR : hawk
 * @DATE : 2016年1月14日
 ************************************************************
 */
public class DubboBasicPageResponse extends DubboBasicResponse {

    private static final long serialVersionUID = 1L;

    private Long pageSize;

    private Long currentPage;

    private Long totalNum;

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

    public Long getTotalNum() {
        return totalNum;
    }

    public void setTotalNum(Long totalNum) {
        this.totalNum = totalNum;
    }
}
