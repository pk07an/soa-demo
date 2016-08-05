/**
 * 
 */
package com.meila.soa.openapi.thrift.client;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

import org.apache.thrift.protocol.TBinaryProtocol;
import org.apache.thrift.protocol.TProtocol;
import org.apache.thrift.transport.TFramedTransport;
import org.apache.thrift.transport.TSocket;
import org.apache.thrift.transport.TTransport;
import org.apache.thrift.transport.TTransportException;

/**
 ************************************************************
 * @类名 : ThriftClientProxy.java
 *
 * @DESCRIPTION :利用jdk的动态代理封装thrift连接功能
 * @AUTHOR : flong
 * @DATE : 2016年5月23日
 ************************************************************
 */
public class ThriftClientProxy<T> implements InvocationHandler {

    private Class<T> clazz = null;

    private ThriftClientConfig config;// 当pool未配置时，表示不使用线程池，那么这里的config对所有连接生效
    private ThriftClientPool pool;// thrift线程池

    public Object newInstance(Class<T> clazz) {
        this.clazz = clazz;
        return Proxy.newProxyInstance(clazz.getClassLoader(), clazz.getInterfaces(), this);
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        TTransport transport = null;
        try {
            if (pool == null) {
                if (config.isFrame()) {
                    transport = new TFramedTransport(transport);
                } else {
                    transport = new TSocket(config.getServerIp(), config.getServerPort(), config.getTimeout());
                }
                transport.open();
            } else {
                transport = pool.getConnection();
            }
            // 目前社区侧使用二进制协议，这里直接写死为binary
            TProtocol protocol = new TBinaryProtocol(transport);
            Class[] argsClass = new Class[] { TProtocol.class };
            Constructor<T> constructor = (Constructor<T>) clazz.getConstructor(argsClass);
            T client = (T) constructor.newInstance(protocol);

            return method.invoke(client, args);
        } catch (TTransportException e) {
            if (pool != null) {
                pool.invalid(transport);
            }
            throw e;
        } catch (InvocationTargetException e) {
            Throwable te = e.getCause();
            if (te != null && (te instanceof TTransportException)) {
                te.printStackTrace();
                if (pool != null) {
                    pool.invalid(transport);
                }
            }
            throw e.getTargetException();
        } catch (Throwable e) {
            Throwable te = e.getCause();
            if (te != null && (te instanceof RuntimeException)) {
                Throwable te2 = te.getCause();
                if (te2 != null && (te2 instanceof TTransportException)) {
                    if (pool != null) {
                        pool.invalid(transport);
                    }
                }
            }
            throw e;
        } finally {
            if (transport != null) {
                if (pool == null) {
                    transport.close();
                } else {
                    pool.recycle(transport);
                }
            }
        }
    }

    public ThriftClientConfig getConfig() {
        return config;
    }

    public void setConfig(ThriftClientConfig config) {
        this.config = config;
    }

    public ThriftClientPool getPool() {
        return pool;
    }

    public void setPool(ThriftClientPool pool) {
        this.pool = pool;
    }

}
