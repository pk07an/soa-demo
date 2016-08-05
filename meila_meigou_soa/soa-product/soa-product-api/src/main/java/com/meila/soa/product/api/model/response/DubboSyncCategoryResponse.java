package com.meila.soa.product.api.model.response;

import java.util.List;

import com.meila.dubbo.base.model.BasicSeriModel;
import com.meila.dubbo.base.model.DubboBasicResponse;

/**
 * 
 ************************************************************
 * @类名 : DubboSyncCategoryResponse.java
 *
 * @DESCRIPTION :同步分类树返回类
 * @AUTHOR : hawk
 * @DATE : 2016年1月14日
 ************************************************************
 */
public class DubboSyncCategoryResponse extends DubboBasicResponse {
    private static final long serialVersionUID = 1L;
    private List<DubboSyncCategoryResult> resultList;

    public List<DubboSyncCategoryResult> getResultList() {
        return resultList;
    }

    public void setResultList(List<DubboSyncCategoryResult> resultList) {
        this.resultList = resultList;
    }

    public static class DubboSyncCategoryResult extends BasicSeriModel {
        private static final long serialVersionUID = 1L;

        private String categoryCode;

        private String errorCode;

        private String errorMsg;

        public String getCategoryCode() {
            return categoryCode;
        }

        public void setCategoryCode(String categoryCode) {
            this.categoryCode = categoryCode;
        }

        public String getErrorCode() {
            return errorCode;
        }

        public void setErrorCode(String errorCode) {
            this.errorCode = errorCode;
        }

        public String getErrorMsg() {
            return errorMsg;
        }

        public void setErrorMsg(String errorMsg) {
            this.errorMsg = errorMsg;
        }
    }

}
