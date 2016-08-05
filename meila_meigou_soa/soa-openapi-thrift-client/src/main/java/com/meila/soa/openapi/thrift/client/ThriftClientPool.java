/**
 * 
 */
package com.meila.soa.openapi.thrift.client;

import java.util.concurrent.atomic.AtomicInteger;

import org.apache.commons.pool.ObjectPool;
import org.apache.commons.pool.impl.GenericObjectPool;
import org.apache.thrift.transport.TTransport;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;

/**
 ************************************************************
 * @类名 : ThriftClientPool.java
 *
 * @DESCRIPTION :thrift线程池
 * @AUTHOR : flong
 * @DATE : 2016年5月23日
 ************************************************************
 */
public class ThriftClientPool implements InitializingBean, DisposableBean {
    private ThriftClientConfig config;

    /** 可以从缓存池中分配对象的最大数量 */
    private int maxActive = GenericObjectPool.DEFAULT_MAX_ACTIVE;
    /** 缓存池中最大空闲对象数量 */
    private int maxIdle = GenericObjectPool.DEFAULT_MAX_IDLE;
    /** 缓存池中最小空闲对象数量 */
    private int minIdle = GenericObjectPool.DEFAULT_MIN_IDLE;
    /** 阻塞的最大数量 */
    private long maxWait = GenericObjectPool.DEFAULT_MAX_WAIT;

    /** 从缓存池中分配对象，是否执行PoolableObjectFactory.validateObject方法 */
    private boolean testOnBorrow = GenericObjectPool.DEFAULT_TEST_ON_BORROW;
    private boolean testOnReturn = GenericObjectPool.DEFAULT_TEST_ON_RETURN;
    private boolean testWhileIdle = GenericObjectPool.DEFAULT_TEST_WHILE_IDLE;

    /** 对象缓存池 */
    private ObjectPool<TTransport> objectPool = null;
    private static AtomicInteger num = new AtomicInteger(0);

    public TTransport getConnection() {
        try {
            // 从对象池取对象
            TTransport transport = (TTransport) objectPool.borrowObject();
            if (!transport.isOpen()) {// 重要，当服务端重启时，这里必须重打开
                transport.open();
            }
            return transport;
        } catch (Exception e) {
            throw new RuntimeException("error getConnection()", e);
        }
    }

    public void recycle(TTransport transport) {
        try {
            // 将对象放回对象池
            objectPool.returnObject(transport);
        } catch (Exception e) {
            throw new RuntimeException("error recycle()", e);
        }
    }

    public void invalid(TTransport transport) {
        try {
            // 将对象放回对象池
            if (transport != null) {
                objectPool.invalidateObject(transport);
            }
        } catch (Exception e) {
            throw new RuntimeException("error close()", e);
        }
    }

    @Override
    public void destroy() throws Exception {
        try {
            objectPool.close();
        } catch (Exception e) {
            throw new RuntimeException("erorr destroy()", e);
        }
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        init();
    }

    private void init() {
        // 对象池
        ThriftPoolableObjectFactory thriftPoolableObjectFactory = new ThriftPoolableObjectFactory(config.getServerIp(), config.getServerPort(),
            config.getTimeout(), config.isFrame());
        objectPool = new GenericObjectPool<TTransport>(thriftPoolableObjectFactory);
        //
        ((GenericObjectPool<TTransport>) objectPool).setMaxActive(maxActive);
        ((GenericObjectPool<TTransport>) objectPool).setMaxIdle(maxIdle);
        ((GenericObjectPool<TTransport>) objectPool).setMinIdle(minIdle);
        ((GenericObjectPool<TTransport>) objectPool).setMaxWait(maxWait);
        ((GenericObjectPool<TTransport>) objectPool).setTestOnBorrow(testOnBorrow);
        ((GenericObjectPool<TTransport>) objectPool).setTestOnReturn(testOnReturn);
        ((GenericObjectPool<TTransport>) objectPool).setTestWhileIdle(testWhileIdle);
        ((GenericObjectPool<TTransport>) objectPool).setWhenExhaustedAction(GenericObjectPool.WHEN_EXHAUSTED_BLOCK);
    }

    public ThriftClientConfig getConfig() {
        return config;
    }

    public void setConfig(ThriftClientConfig config) {
        this.config = config;
    }

    public int getMaxActive() {
        return maxActive;
    }

    public void setMaxActive(int maxActive) {
        this.maxActive = maxActive;
    }

    public int getMaxIdle() {
        return maxIdle;
    }

    public void setMaxIdle(int maxIdle) {
        this.maxIdle = maxIdle;
    }

    public int getMinIdle() {
        return minIdle;
    }

    public void setMinIdle(int minIdle) {
        this.minIdle = minIdle;
    }

    public long getMaxWait() {
        return maxWait;
    }

    public void setMaxWait(long maxWait) {
        this.maxWait = maxWait;
    }

    public boolean isTestOnBorrow() {
        return testOnBorrow;
    }

    public void setTestOnBorrow(boolean testOnBorrow) {
        this.testOnBorrow = testOnBorrow;
    }

    public boolean isTestOnReturn() {
        return testOnReturn;
    }

    public void setTestOnReturn(boolean testOnReturn) {
        this.testOnReturn = testOnReturn;
    }

    public boolean isTestWhileIdle() {
        return testWhileIdle;
    }

    public void setTestWhileIdle(boolean testWhileIdle) {
        this.testWhileIdle = testWhileIdle;
    }

    public ObjectPool<TTransport> getObjectPool() {
        return objectPool;
    }

    public void setObjectPool(ObjectPool<TTransport> objectPool) {
        this.objectPool = objectPool;
    }

}
