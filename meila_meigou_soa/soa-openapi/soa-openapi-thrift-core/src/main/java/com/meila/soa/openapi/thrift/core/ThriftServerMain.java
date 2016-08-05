/**
 * 
 */
package com.meila.soa.openapi.thrift.core;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 ************************************************************
 * @类名 : ThriftServerMain.java
 *
 * @DESCRIPTION : thrift server启动类
 * @AUTHOR : flong
 * @DATE : 2016年1月15日
 ************************************************************
 */
public class ThriftServerMain {
    private static final Logger logger = LoggerFactory.getLogger(ThriftServerMain.class);

    private static volatile boolean running = true;

    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("classpath:applicationContext.xml");
        context.start();
        ThriftServerProxy thriftServerProxy = (ThriftServerProxy) context.getBean("thriftServerProxy");
        thriftServerProxy.publish();
        System.out.println("Thrift Service started.....");
        synchronized (ThriftServerMain.class) {
            while (running) {
                try {
                    ThriftServerMain.class.wait();
                } catch (Throwable e) {
                    e.printStackTrace();
                }
            }
        }

    }

}
