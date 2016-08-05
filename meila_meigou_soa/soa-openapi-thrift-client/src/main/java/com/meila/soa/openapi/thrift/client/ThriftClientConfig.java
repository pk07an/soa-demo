/**
 * 
 */
package com.meila.soa.openapi.thrift.client;

/**
 ************************************************************
 * @类名 : ThriftClientConfig.java
 *
 * @DESCRIPTION :thrift-client接口配置
 * @AUTHOR : flong
 * @DATE : 2016年5月24日
 ************************************************************
 */
public class ThriftClientConfig {
    /** 服务端IP */
    private String serverIp;
    /** 服务端端口 */
    private int serverPort;
    /** 超时时间 */
    private int timeout;
    /** 是否使用frame单位传输 */
    private boolean frame;

    public String getServerIp() {
        return serverIp;
    }

    public void setServerIp(String serverIp) {
        this.serverIp = serverIp;
    }

    public int getServerPort() {
        return serverPort;
    }

    public void setServerPort(int serverPort) {
        this.serverPort = serverPort;
    }

    public int getTimeout() {
        return timeout;
    }

    public void setTimeout(int timeout) {
        this.timeout = timeout;
    }

    public boolean isFrame() {
        return frame;
    }

    public void setFrame(boolean frame) {
        this.frame = frame;
    }

}
