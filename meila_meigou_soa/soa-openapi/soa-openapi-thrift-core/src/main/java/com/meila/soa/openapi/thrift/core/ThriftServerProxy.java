/**
 * 
 */
package com.meila.soa.openapi.thrift.core;

import java.lang.reflect.Constructor;

import org.apache.thrift.TProcessor;
import org.apache.thrift.protocol.TBinaryProtocol;
import org.apache.thrift.server.TThreadedSelectorServer;
import org.apache.thrift.transport.TFramedTransport;
import org.apache.thrift.transport.TNonblockingServerSocket;
import org.apache.thrift.transport.TNonblockingServerTransport;
import org.apache.thrift.transport.TTransportException;
import org.apache.thrift.transport.TTransportFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;

/**
 ************************************************************
 * @类名 : ThriftServerProxy.java
 *
 * @DESCRIPTION :thrift服务代理类，将外部传入的接口列表注册并发布
 * @AUTHOR : flong
 * @DATE : 2016年1月15日
 ************************************************************
 */

public class ThriftServerProxy {
    private final Logger logger = LoggerFactory.getLogger(getClass());
    /**
     * 发布服务的端口
     */
    @Value("${thrift.protocol.port}")
    private int port;
    @Value("${thrift.worker.num:300}")
    private int workerNum;
    @Value("${thrift.selector.num:10}")
    private int selectorNum;
    /**
     * 发布的服务名称
     */
    private String serviceInterface;
    /**
     * 发布服务的实现类
     */
    private Object serviceImplementObject;

    public void setPort(int port) {
        this.port = port;
    }

    public void setServiceInterface(String serviceInterface) {
        this.serviceInterface = serviceInterface;
    }

    public void setServiceImplementObject(Object serviceImplementObject) {
        this.serviceImplementObject = serviceImplementObject;
    }

    public void publish() {
        if (serviceInterface == null) {
            logger.error("没有任何服务需要发布，请检查配置！");
            System.out.println("没有任何服务需要发布，请检查配置！");
            return;
        }

        Class Iface = null;
        Class Processor = null;
        // 检查接口类是否存在
        try {
            Iface = Class.forName(serviceInterface + "$Iface");
            Processor = Class.forName(serviceInterface + "$Processor");
        } catch (ClassNotFoundException e) {
            logger.info("接口 {} 没有正确的接口文件", serviceInterface);
            System.out.println("接口 {" + serviceInterface + "} 没有正确的接口文件");
            return;
        }
        // 处理器，由配置文件传入具体实现
        TProcessor processor = null;
        try {
            // 接口构造方法类
            Constructor constructor = Processor.getConstructor(Iface);
            processor = (TProcessor) constructor.newInstance(serviceImplementObject);
            logger.info("注册服务 {} 成功", serviceInterface);
            System.out.println("注册服务 " + serviceInterface + " 成功");
        } catch (Throwable e) {
            logger.info("构造服务异常", e);
        }
        /**
         * TThreadPoolServer方式
         */
        // TServerTransport serverTransport = null;
        // try {
        // serverTransport = new TServerSocket(this.port);
        // } catch (TTransportException e) {
        // logger.error("初始化server端口异常", e);
        // }
        // TThreadPoolServer.Args args = new TThreadPoolServer.Args(serverTransport);
        // TBinaryProtocol.Factory protFactory = new TBinaryProtocol.Factory(true, true);
        // args.protocolFactory(protFactory);
        // args.processor(processor);
        // args.maxWorkerThreads(workerNum);
        // TServer server = new TThreadPoolServer(args);
        /**
         * TThreadedSelectorServer方式
         */
        TNonblockingServerTransport serverTransport = null;
        try {
            serverTransport = new TNonblockingServerSocket(this.port);
        } catch (TTransportException e) {
            logger.error("初始化server端口异常", e);
        }
        // transport是通信协议
        TTransportFactory transportFactory = new TFramedTransport.Factory();
        // protocol是序列化方式
        TBinaryProtocol.Factory protFactory = new TBinaryProtocol.Factory(true, true);
        // init server
        TThreadedSelectorServer.Args ttsargs = new TThreadedSelectorServer.Args(serverTransport);
        ttsargs.protocolFactory(protFactory);
        ttsargs.transportFactory(transportFactory);
        ttsargs.processor(processor);
        ttsargs.selectorThreads(selectorNum);
        ttsargs.workerThreads(workerNum);
        TThreadedSelectorServer server = new TThreadedSelectorServer(ttsargs);
        logger.info("Starting thrift server on port {} success", this.port);
        System.out.println("Starting server on port " + this.port + " success");
        server.serve();
    }
}
