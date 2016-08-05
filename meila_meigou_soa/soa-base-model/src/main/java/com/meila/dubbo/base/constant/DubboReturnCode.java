package com.meila.dubbo.base.constant;

/**
 * 
 ************************************************************
 * @类名 : DubboReturnCode.java
 *
 * @DESCRIPTION : 返回码列举类
 * @AUTHOR : hawk
 * @DATE : 2016年1月14日
 ************************************************************
 */
public class DubboReturnCode {
    /**
     * 成功
     */
    public static final int SUCCESS = 0;

    /**
     * 调用失败
     */
    public static final int FAILED = -1;

    /**
     * 客户端弹窗提示
     */
    public static final int ALERT_ERR = 1;

    /**
     * 客户端记录日志
     */
    public static final int CONSOLE_ERR = 2;

    /**
     * 参数错误
     */
    public static final int PARAMETER_ERR = 3;
    
    /**
     * 同步内部系统失败
     */
    public static final int SYNC_SERVER_ERR = 4;
}
