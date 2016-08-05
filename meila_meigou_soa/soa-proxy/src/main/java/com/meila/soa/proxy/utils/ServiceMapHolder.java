package com.meila.soa.proxy.utils;

import java.io.IOException;
import java.util.Properties;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.io.Resource;

/**
 *@Description:服务码与服务提供者的映射关系封装
 *@Author:marshall
 *@Since:2015年11月4日
 *@Version:1.1.0
 */
public class ServiceMapHolder {
	private final Logger log = LoggerFactory.getLogger(getClass());
    private static Properties properties;
    private static Resource configLocation;

    public Resource getConfigLocation() {
        return configLocation;
    }

    /**
     * 读取注入的配置文件并封装到Properties
     * @param configLocation
     */
    public void setConfigLocation(Resource configLocation) {
    	ServiceMapHolder.configLocation = configLocation;
        if (ServiceMapHolder.configLocation != null) {
        	ServiceMapHolder.properties = new Properties();
            try {
            	ServiceMapHolder.properties.load(configLocation.getInputStream());
            } catch (IOException e) {
                log.error(e.getMessage());
            }
        }
    }

    /**
     * 读取指定服务码的服务提供者
     * @param serviceCode
     * @return
     */
    public static String getServiceProvider(String serviceCode) {
        if (properties != null)
            return (String) properties.get(serviceCode);
        return null;
    }
}
