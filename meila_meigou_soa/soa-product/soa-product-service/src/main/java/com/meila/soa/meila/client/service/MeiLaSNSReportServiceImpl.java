package com.meila.soa.meila.client.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.stereotype.Service;

import com.meila.common.utils.CommonUtils;
import com.meila.soa.meila.client.model.OnPurchaseModel;

/**
 ************************************************************
 * @类名 : MeiLaSNSReportServiceImpl.java
 *
 * @DESCRIPTION :
 * @AUTHOR : Toney
 * @DATE : 2015年10月14日
 ************************************************************
 */
@Service
public class MeiLaSNSReportServiceImpl implements MeiLaSNSReportService {
    private static final Logger logger = LoggerFactory.getLogger(MeiLaSNSReportServiceImpl.class);

    @Autowired
    @Lazy
    private MeilaClient meilaClient;

    @Autowired
    private ThreadPoolTaskExecutor syncTaskExecutor;

    @Override
    public void onPurchaseToMeila(final OnPurchaseModel model) {
        syncTaskExecutor.execute(new Runnable() {
            @Override
            public void run() {
                try {
                    logger.info("向社区上报购物流程访问数据:{}", CommonUtils.objectToString(model));
                    meilaClient.doOnPurchaseToMeila(model);
                } catch (Throwable t) {
                    logger.error("向社区上报物流程访问数据失败,数据:" + CommonUtils.objectToString(model), t);
                }
            }
        });
    }

}
