package com.meila.soa.proxy.service.erp;

import javax.jws.WebMethod;
import javax.jws.WebService;

/**
 * 
 ************************************************************
 * @类名 : IerpRequest.java
 *
 * @DESCRIPTION : 处理Erp请求
 * @AUTHOR :  abner
 * @DATE :  2016年1月5日
 ************************************************************
 */
@WebService
public interface IerpRequest {
    /**
     * 
     *
     * 功能描述：处理erp的请求
     * 
     * @param xmlData
     * @return String
     *
     */
    @WebMethod
    String erpRequestDeal(String xmldata);
}
