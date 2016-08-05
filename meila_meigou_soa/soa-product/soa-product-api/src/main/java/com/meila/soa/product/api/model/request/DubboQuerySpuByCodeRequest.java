package com.meila.soa.product.api.model.request;

import java.util.List;

import org.hibernate.validator.constraints.NotEmpty;

import com.meila.dubbo.base.model.DubboBasicRequest;

/**
 ************************************************************
 * @类名 : DubboQuerySpuByIdRequest.java
 *
 * @DESCRIPTION : 查询商品SPU信息请求类
 * @AUTHOR : hawk
 * @DATE : 2016年1月20日
 ************************************************************
 */
public class DubboQuerySpuByCodeRequest extends DubboBasicRequest {
    private static final long serialVersionUID = 1L;

    @NotEmpty
    List<String> codeList;

    /**
     * @return the codeList
     */
    public List<String> getCodeList() {
        return codeList;
    }

    /**
     * @param codeList the codeList to set
     */
    public void setCodeList(List<String> codeList) {
        this.codeList = codeList;
    }
}
