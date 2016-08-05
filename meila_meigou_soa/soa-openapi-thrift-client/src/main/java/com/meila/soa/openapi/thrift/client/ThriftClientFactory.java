/**
 * 
 */
package com.meila.soa.openapi.thrift.client;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 ************************************************************
 * @类名 : ThriftClientFactory.java
 *
 * @DESCRIPTION :工厂类，用于生成proxy
 * @AUTHOR : flong
 * @DATE : 2016年5月23日
 ************************************************************
 */
public class ThriftClientFactory {
    private static final Logger logger = LoggerFactory.getLogger(ThriftClientFactory.class);

    @SuppressWarnings("unchecked")
    public static Object createProxy(ThriftClientProxy proxy, String className) {
        try {
            String clientClassName = className.trim() + "$Client";
            Class<?> clientClazz = Class.forName(clientClassName);
            return proxy.newInstance(clientClazz);
        } catch (Exception e) {
            logger.error("创建proxy失败", e);
        }
        return null;
    }

}
