/**
 * 
 */
package com.meila.soa.openapi.thrift.client;

import java.util.ArrayList;
import java.util.List;

import org.apache.thrift.TException;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.alibaba.fastjson.JSON;
import com.meila.soa.openapi.thrift.product.ThriftProductService;
import com.meila.soa.openapi.thrift.product.model.ThriftProductModel;
import com.meila.soa.openapi.thrift.product.model.ThriftSkuModel;

/**
 ************************************************************
 * @类名 : ThriftClientTest.java
 *
 * @DESCRIPTION :
 * @AUTHOR : flong
 * @DATE : 2016年5月23日
 ************************************************************
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:spring-thrift-client.xml")
public class ThriftClientTest {
    @Autowired
    private ThriftProductService.Iface productClient;

    @Test
    public void test() throws TException {
        while (true) {
            try {
                List<Long> ids = new ArrayList<Long>();
                ids.add(2999L);
                List<ThriftProductModel> list = productClient.findProductByIds(ids);
                System.out.println("size : " + (list == null ? 0 : list.size()));
                if (list != null && list.size() > 0) {
                    for (ThriftProductModel model : list) {
                        System.out.println(JSON.toJSONString(model));
                        for (ThriftSkuModel skuModel : model.getSkus()) {
                            System.out.println(skuModel.getDisplay() + "|" + skuModel.getDescription());
                        }
                    }
                }

                Thread.sleep(5000);
            } catch (Exception e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
    }
}
