package com.meila.soa.proxy.service.secretconfig;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.meila.soa.proxy.dal.dao.OmsCustomSecretConfig.OmsCustomSecretConfigEntityMapper;
import com.meila.soa.proxy.dal.entity.OmsCustomSecretConfig.OmsCustomSecretConfigEntity;

/**
 *@Description:接收日志服务类
 *@Author:marshall
 *@Since:2015年11月6日
 *@Version:1.1.0
 */
@Service("omsKeyConfigService")
public class OmsCustomerSecretConfigService {

	private final Logger logger = LoggerFactory.getLogger(getClass());
    @Autowired
    private OmsCustomSecretConfigEntityMapper omsCustomSecretConfigMapper;
    
    /**
     * 根据appkey查询appSecret
     */
    public OmsCustomSecretConfigEntity queryKeyConfig(String customCode){
    	
    	OmsCustomSecretConfigEntity omsCustomSecretConfigEntity=omsCustomSecretConfigMapper.selectByCustomCode(customCode);
		return omsCustomSecretConfigEntity;
    }
}
