package com.meila.dubbo.base.model;

import com.meila.dubbo.base.TidManager;

/**
 * 
 ************************************************************
 * @类名 : DubboBasicRequest.java
 *
 * @DESCRIPTION : dubbo请求基础类
 * @AUTHOR : hawk
 * @DATE : 2016年1月14日
 ************************************************************
 */
public class DubboBasicRequest extends BasicSeriModel {
    private static final long serialVersionUID = 1L;

    private String tid;

    private String sourceFrom;// 请求方身份标识

    public DubboBasicRequest() {
        this.tid = TidManager.getTid();
        this.sourceFrom = TidManager.getSourceFrom();
    }

    /**
     * @return the tid
     */
    public String getTid() {
        return tid;
    }

    /**
     * @param tid the tid to set
     */
    public void setTid(String tid) {
        this.tid = tid;
    }

    public String getSourceFrom() {
        return sourceFrom;
    }

    public void setSourceFrom(String sourceFrom) {
        this.sourceFrom = sourceFrom;
    }

}
