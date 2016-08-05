/**
 * 
 */
package com.meila.soa.openapi.thrift.hello;

import org.apache.thrift.TException;
import org.apache.thrift.protocol.TBinaryProtocol;
import org.apache.thrift.protocol.TProtocol;
import org.apache.thrift.transport.TSocket;
import org.apache.thrift.transport.TTransport;

/**
 ************************************************************
 * @类名 : ThriftClientTest.java
 *
 * @DESCRIPTION :
 * @AUTHOR : flong
 * @DATE : 2016年1月18日
 ************************************************************
 */
public class ThriftClientTest {
    public static final String SERVER_IP = "127.0.0.1";
    public static final int SERVER_PORT = 10010;
    public static final int TIMEOUT = 3000;

    /**
     *
     * 功能描述：
     * 
     * @param args void
     * @throws TException
     *
     */
    public static void main(String[] args) throws TException {
        // 设置传输通道
        TTransport transport = new TSocket(SERVER_IP, SERVER_PORT, TIMEOUT);
        // 协议要和服务端一致
        // 使用二进制协议
        TProtocol protocol = new TBinaryProtocol(transport);
        // 创建Client
        ThriftHelloService.Client client = new ThriftHelloService.Client(protocol);
        transport.open();
        String result = client.helloString("flong");
        System.out.println("result : " + result);
        // 关闭资源
        transport.close();
    }

}
