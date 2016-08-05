/**
 * 
 */
package com.meila.soa.openapi.thrift.client;

import org.apache.commons.pool.PoolableObjectFactory;
import org.apache.thrift.transport.TFramedTransport;
import org.apache.thrift.transport.TSocket;
import org.apache.thrift.transport.TTransport;

/**
 ************************************************************
 * @类名 : ThriftPoolableObjectFactory.java
 *
 * @DESCRIPTION :
 * @AUTHOR : flong
 * @DATE : 2016年5月23日
 ************************************************************
 */
public class ThriftPoolableObjectFactory implements PoolableObjectFactory<TTransport> {

    /** 服务的IP */
    private String ip;
    /** 服务的端口 */
    private int port;
    /** 超时设置 */
    private int timeout;
    private boolean frame;

    public ThriftPoolableObjectFactory(String ip, int port, int timeout, boolean frame) {
        super();
        this.ip = ip;
        this.port = port;
        this.timeout = timeout;
        this.frame = frame;
    }

    @Override
    public TTransport makeObject() throws Exception {
        TTransport transport = null;
        if (frame) {
            transport = new TFramedTransport(transport);
        } else {
            transport = new TSocket(ip, port, timeout);
        }
        transport.open();
        return transport;
    }

    @Override
    public void destroyObject(TTransport obj) throws Exception {
        if (obj.isOpen()) {
            obj.close();
        }
    }

    @Override
    public boolean validateObject(TTransport obj) {
        try {
            if (obj instanceof TSocket) {
                TSocket thriftSocket = (TSocket) obj;
                if (thriftSocket.isOpen()) {
                    return true;
                } else {
                    return false;
                }
            } else {
                return false;
            }
        } catch (Exception e) {
            return false;
        }
    }

    @Override
    public void activateObject(TTransport obj) throws Exception {
        // TODO Auto-generated method stub

    }

    @Override
    public void passivateObject(TTransport obj) throws Exception {
        // TODO Auto-generated method stub

    }

}
