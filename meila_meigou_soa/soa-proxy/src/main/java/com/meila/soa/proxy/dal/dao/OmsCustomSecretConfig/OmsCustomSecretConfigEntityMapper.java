package com.meila.soa.proxy.dal.dao.OmsCustomSecretConfig;

import org.apache.ibatis.annotations.Param;

import com.meila.soa.proxy.dal.entity.OmsCustomSecretConfig.OmsCustomSecretConfigEntity;


public interface OmsCustomSecretConfigEntityMapper {
    int deleteByPrimaryKey(Integer cusconfigId);

    int insert(OmsCustomSecretConfigEntity record);

    int insertSelective(OmsCustomSecretConfigEntity record);

    OmsCustomSecretConfigEntity selectByPrimaryKey(Integer cusconfigId);

    int updateByPrimaryKeySelective(OmsCustomSecretConfigEntity record);

    int updateByPrimaryKey(OmsCustomSecretConfigEntity record);
    
    /**************自定义sql语句开始**************/
    /**
     * 根据CustomCode查询secet配置信息
     * @param customCode
     * @return
     */
    OmsCustomSecretConfigEntity selectByCustomCode(@Param("customCode") String customCode);
    /**************自定义sql语句结束**************/
}