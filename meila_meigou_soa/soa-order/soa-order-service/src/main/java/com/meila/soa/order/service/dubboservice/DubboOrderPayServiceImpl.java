/**
 * 
 */
package com.meila.soa.order.service.dubboservice;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.meila.common.bean.utils.BeanMapper;
import com.meila.soa.order.api.DubboOrderPayService;
import com.meila.soa.order.api.model.dto.DubboOutPay;
import com.meila.soa.order.api.model.request.DubboQueryOutPayMapByPayNosRequest;
import com.meila.soa.order.api.model.response.DubboQueryOutPayMapByPayNosResponse;
import com.meila.soa.order.dal.dao.order.OutPayEntityMapper;
import com.meila.soa.order.dal.entity.order.OutPayEntity;

/**
 ************************************************************
 * @类名 : DubboOrderPayServiceImpl.java
 *
 * @DESCRIPTION :订单支付服务
 * @AUTHOR : gogo
 * @DATE : 2016年6月12日
 ************************************************************
 */
public class DubboOrderPayServiceImpl implements DubboOrderPayService {

    private static Logger logger = LoggerFactory.getLogger(DubboOrderPayServiceImpl.class);

    @Autowired
    private OutPayEntityMapper outPayEntityMapper;

    @Override
    public DubboQueryOutPayMapByPayNosResponse queryOutPayMapByPayNos(DubboQueryOutPayMapByPayNosRequest request) {

        List<OutPayEntity> outPays = outPayEntityMapper.selectOutPaysByPayNoList(request.getPayNos());
        Map<String, DubboOutPay> dubboOutPays = new HashMap<>();

        for (OutPayEntity entity : outPays) {
            dubboOutPays.put(entity.getBillNo(), BeanMapper.map(entity, DubboOutPay.class));
        }

        DubboQueryOutPayMapByPayNosResponse response = new DubboQueryOutPayMapByPayNosResponse();

        response.setOutPayMap(dubboOutPays);

        return response;
    }

}
