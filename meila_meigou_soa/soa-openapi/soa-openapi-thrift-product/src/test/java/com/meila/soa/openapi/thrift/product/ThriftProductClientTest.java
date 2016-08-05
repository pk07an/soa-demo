/**
 * 
 */
package com.meila.soa.openapi.thrift.product;

import java.util.ArrayList;
import java.util.List;

import org.apache.thrift.TException;
import org.apache.thrift.protocol.TBinaryProtocol;
import org.apache.thrift.protocol.TProtocol;
import org.apache.thrift.transport.TFramedTransport;
import org.apache.thrift.transport.TSocket;
import org.apache.thrift.transport.TTransport;

import com.alibaba.fastjson.JSON;
import com.meila.soa.openapi.thrift.product.model.ThriftPageShopModel;
import com.meila.soa.openapi.thrift.product.model.ThriftPageSimpleProductModel;
import com.meila.soa.openapi.thrift.product.model.ThriftProductModel;

/**
 ************************************************************
 * @类名 : ThriftClientTest.java
 *
 * @DESCRIPTION :
 * @AUTHOR : flong
 * @DATE : 2016年1月18日
 ************************************************************
 */
public class ThriftProductClientTest {
    // public static final String SERVER_IP = "10.10.122.177";
    // public static String SERVER_IP = "172.18.5.66";
    public static String SERVER_IP = "127.0.0.1";
    public static final int SERVER_PORT = 10010;
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
        ThriftProductService.Client client = new ThriftProductService.Client(protocol);

        transport.open();
        List<Long> ids = new ArrayList<Long>();
        ids.add(2999L);
        // ids.add(3819L);
        // ids.add(3812L);
        // List<ThriftProductModel> list = client.findProductByIds(ids);
        // System.out.println("size : " + (list == null ? 0 : list.size()));
        // if (list != null && list.size() > 0) {
        // for (ThriftProductModel model : list) {
        // System.out.println(JSON.toJSONString(model));
        // for (ThriftSkuModel skuModel : model.getSkus()) {
        // System.out.println(skuModel.getDisplay() + "|" + skuModel.getDescription());
        // }
        // }
        // }
        List<String> codes = new ArrayList<String>();
        codes.add("cc9c6baa");
        codes.add("1a0dg");
        codes.add("118a3");
        codes.add("1cgtg");
        codes.add("1bls");
        codes.add("z18j");
        codes.add("1a9s4");
        codes.add("1libp");
        codes.add("1wqva");
        codes.add("27zev");
        codes.add("1bm0");
        codes.add("ck5l");
        codes.add("nsp6");
        codes.add("z18r");
        codes.add("1a9sc");
        codes.add("1libx");
        codes.add("1wqvi");
        codes.add("27zf3");
        codes.add("nspe");
        codes.add("z18z");
        List<ThriftProductModel> list2 = client.findSkuByIds(codes);
        System.out.println("queryByCode:" + JSON.toJSONString(list2));
        // ThriftBaseResult result = client.addToCart(99972L, "10m4r", 1, CartOperationType.NORMAL, "TestByFlong");
        // System.out.println("add cart resultcode:" + result.code + "|resultdesc:" + result.getDescription());
        // List<Long> sellerIds = new ArrayList<Long>();
        // sellerIds.add(1359374L);
        // List<ThriftShopModel> shopList = client.findShopBySellerId(sellerIds);
        // System.out.println("size : " + (shopList == null ? 0 : shopList.size()));
        // if (shopList != null && shopList.size() > 0) {
        // for (ThriftShopModel model : shopList) {
        // System.out.println(JSON.toJSONString(model));
        // }
        // }

        ThriftPageShopModel pageShopModel = client.findPagedShop(1, 100);
        System.out.println(JSON.toJSONString(pageShopModel));
        ThriftPageSimpleProductModel pageSimpleProductModel = client.findPagedProduct(1, 100);
        System.out.println(JSON.toJSONString(pageSimpleProductModel));
        // 关闭资源
        transport.close();
        System.out.println("time=" + (System.currentTimeMillis() - start));
    }
}
