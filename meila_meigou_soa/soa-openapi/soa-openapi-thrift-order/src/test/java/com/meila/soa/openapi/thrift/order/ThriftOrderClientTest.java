/**
 * 
 */
package com.meila.soa.openapi.thrift.order;

import java.util.ArrayList;
import java.util.List;

import org.apache.thrift.TException;
import org.apache.thrift.protocol.TBinaryProtocol;
import org.apache.thrift.protocol.TProtocol;
import org.apache.thrift.transport.TFramedTransport;
import org.apache.thrift.transport.TSocket;
import org.apache.thrift.transport.TTransport;

import com.alibaba.fastjson.JSON;
import com.meila.soa.openapi.thrift.order.model.ThriftOrder4ShareModel;

/**
 ************************************************************
 * @类名 : ThriftClientTest.java
 *
 * @DESCRIPTION :
 * @AUTHOR : flong
 * @DATE : 2016年1月18日
 ************************************************************
 */
public class ThriftOrderClientTest {
    // public static final String SERVER_IP = "10.10.122.177";
    public static String SERVER_IP = "172.18.5.66";
    // public static String SERVER_IP = "127.0.0.1";
    public static final int SERVER_PORT = 10020;
    public static final int TIMEOUT = 30000;

    /**
     *
     * 功能描述：
     * 
     * @param args void
     * @throws TException
     *
     */
    public static void main(String[] args) throws TException {
        long start = System.currentTimeMillis();
        // 设置传输通道
        if (args != null && args.length > 0) {
            SERVER_IP = args[0];
        }
        TTransport transport = new TSocket(SERVER_IP, SERVER_PORT, TIMEOUT);
        transport = new TFramedTransport(transport);
        // 协议要和服务端一致
        // 使用二进制协议
        TProtocol protocol = new TBinaryProtocol(transport);
        // 创建Client
        ThriftOrderService.Client client = new ThriftOrderService.Client(protocol);
        transport.open();
        List<Long> ids = new ArrayList<Long>();
        ids.add(1134122L);
        ids.add(3102766L);
        ids.add(3303450L);
        List<ThriftOrder4ShareModel> list = client.findFirstOrder4ShareByUserIds(ids);
        System.out.println("size : " + (list == null ? 0 : list.size()));
        if (list != null && list.size() > 0) {
            for (ThriftOrder4ShareModel model : list) {
                System.out.println(JSON.toJSONString(model));
            }
        }

        // 关闭资源
        transport.close();
        System.out.println("time=" + (System.currentTimeMillis() - start));
    }
}
