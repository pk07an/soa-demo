package com.meila.soa.product.api.model.response.inventory;

import java.util.List;

import com.meila.dubbo.base.model.BasicSeriModel;
import com.meila.dubbo.base.model.DubboBasicResponse;

public class DubboWmsInvNotifyResponse extends DubboBasicResponse {

    /**
     * 
     */
    private static final long serialVersionUID = 1L;
    private List<InvNotifyResult> result;

    public List<InvNotifyResult> getResult() {
        return result;
    }

    public void setResult(List<InvNotifyResult> result) {
        this.result = result;
    }

    public static class InvNotifyResult extends BasicSeriModel {
        /**
         * 
         */
        private static final long serialVersionUID = 1L;

        private String transactionId;

        private String desc;

        public String getTransactionId() {
            return transactionId;
        }

        public void setTransactionId(String transactionId) {
            this.transactionId = transactionId;
        }

        public String getDesc() {
            return desc;
        }

        public void setDesc(String desc) {
            this.desc = desc;
        }

    }
}
