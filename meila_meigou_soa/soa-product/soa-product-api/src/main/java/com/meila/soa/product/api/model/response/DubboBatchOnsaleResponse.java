package com.meila.soa.product.api.model.response;

import java.util.List;

import com.meila.dubbo.base.model.BasicSeriModel;
import com.meila.dubbo.base.model.DubboBasicPageResponse;

public class DubboBatchOnsaleResponse extends DubboBasicPageResponse {

    private static final long serialVersionUID = 1L;

    private List<OnsaleResult> failList;

    public List<OnsaleResult> getFailList() {
        return failList;
    }

    public void setFailList(List<OnsaleResult> failList) {
        this.failList = failList;
    }

    public static class OnsaleResult extends BasicSeriModel {
        private static final long serialVersionUID = 1L;

        private Long productId;

        private String desc;

        public Long getProductId() {
            return productId;
        }

        public void setProductId(Long productId) {
            this.productId = productId;
        }

        public String getDesc() {
            return desc;
        }

        public void setDesc(String desc) {
            this.desc = desc;
        }
    }
}
