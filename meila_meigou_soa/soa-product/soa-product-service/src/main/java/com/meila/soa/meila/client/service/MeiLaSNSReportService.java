package com.meila.soa.meila.client.service;

import com.meila.soa.meila.client.model.OnPurchaseModel;

/**
 ************************************************************
 * @类名 : MeiLaSNSReportService.java
 *
 * @DESCRIPTION : 社区上报相关的一些接口操作
 * @AUTHOR : Toney
 * @DATE : 2015年10月14日
 ************************************************************
 */
public interface MeiLaSNSReportService {

    /**
     *
     * 功能描述：向社区上报详情页、购物流程 访问数据，封装数据 及 调用接口
     * 
     * @param model void
     * @Exception :
     */
    public void onPurchaseToMeila(final OnPurchaseModel model);

}
