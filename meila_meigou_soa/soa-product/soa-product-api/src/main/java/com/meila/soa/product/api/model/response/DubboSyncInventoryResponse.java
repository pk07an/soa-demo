package com.meila.soa.product.api.model.response;

import java.util.List;

import com.meila.dubbo.base.model.BasicSeriModel;
import com.meila.dubbo.base.model.DubboBasicResponse;

/**
 * 
 ************************************************************
 * @类名 : DubboSyncInventoryResponse.java
 *
 * @DESCRIPTION :同步库存返回类
 * @AUTHOR : hawk
 * @DATE : 2016年1月14日
 ************************************************************
 */
public class DubboSyncInventoryResponse extends DubboBasicResponse {
    private static final long serialVersionUID = 1L;

    private List<DubboSyncInventoryResult> resultList;

    public List<DubboSyncInventoryResult> getResultList() {
        return resultList;
    }

    public void setResultList(List<DubboSyncInventoryResult> resultList) {
        this.resultList = resultList;
    }

    public static class DubboSyncInventoryResult extends BasicSeriModel {
        private static final long serialVersionUID = 1L;

        private String erpSkuId;

        private String errorCode;

        private String errorMsg;

        public String getErpSkuId() {
            return erpSkuId;
        }

        public void setErpSkuId(String erpSkuId) {
            this.erpSkuId = erpSkuId;
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
