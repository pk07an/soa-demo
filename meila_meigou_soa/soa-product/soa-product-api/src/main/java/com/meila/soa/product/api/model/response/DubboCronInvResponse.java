package com.meila.soa.product.api.model.response;

import com.meila.dubbo.base.model.DubboBasicPageResponse;

public class DubboCronInvResponse extends DubboBasicPageResponse {

    private static final long serialVersionUID = 1L;

    private Boolean continueFlag;

    public Boolean getContinueFlag() {
        return continueFlag;
    }

    public void setContinueFlag(Boolean continueFlag) {
        this.continueFlag = continueFlag;
    }
}
