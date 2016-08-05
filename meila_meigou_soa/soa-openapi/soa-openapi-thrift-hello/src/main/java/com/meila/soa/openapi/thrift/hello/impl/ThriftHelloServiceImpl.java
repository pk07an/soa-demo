/**
 * 
 */
package com.meila.soa.openapi.thrift.hello.impl;

import org.apache.thrift.TException;

/**
 ************************************************************
 * @类名 : ThriftHelloServiceImpl.java
 *
 * @DESCRIPTION :
 * @AUTHOR : flong
 * @DATE : 2016年1月18日
 ************************************************************
 */
public class ThriftHelloServiceImpl implements com.meila.soa.openapi.thrift.hello.ThriftHelloService.Iface {

    @Override
    public String helloString(String para) throws TException {
        return "hello " + para;
    }

    @Override
    public int add(int num) throws TException {
        num++;
        return num;
    }

}
