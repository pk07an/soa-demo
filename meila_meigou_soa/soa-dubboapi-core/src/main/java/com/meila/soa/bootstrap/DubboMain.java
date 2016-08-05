/**
 * 
 */
package com.meila.soa.bootstrap;

import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 ************************************************************
 * @类名 : DubboMain.java
 *
 * @DESCRIPTION : service启动类， 1。conf/config.properties中保存了数据库链接配置、缓存配置、dubbo配置，请先修改为正确值再进行打包
 *              2.META-INF/assembly/bin下的可执行文件是通用启动文件，不需要修改
 * 
 * @AUTHOR : flong
 * @DATE : 2016年1月14日
 ************************************************************
 */
public class DubboMain {

    public static void main(String[] args) {
        @SuppressWarnings("resource")
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("classpath:applicationContext.xml");
        context.start();
        System.out.println("SOA Service started.....");
        while (true) {
            try {
                Thread.sleep(1000000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
