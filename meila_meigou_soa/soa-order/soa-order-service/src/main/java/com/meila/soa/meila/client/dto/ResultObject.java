package com.meila.soa.meila.client.dto;

/**
 * 
 ************************************************************
 * @类名 : ResultObject.java
 *
 * @DESCRIPTION : OMS返回结果
 * @AUTHOR : gogo
 * @DATE : 2016年5月16日
 ************************************************************
 */
public class ResultObject {
    public static final int RET_SUCCESS = 0;
    public static final int RET_FAIL = 1;

    private int ret;

    private String errorCode;

    private String errorMsg;

    private Object data;

    public ResultObject() {
        this.ret = RET_SUCCESS;
    }

    public ResultObject(Object data) {
        this.data = data;
    }

    public ResultObject(String errorCode, String errorMsg) {
        this.errorCode = errorCode;
        this.errorMsg = errorMsg;
    }

    public String getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(String errorCode) {
        this.errorCode = errorCode;
    }

    public String getErrorMsg() {
        return errorMsg;
    }

    public void setErrorMsg(String errorMsg) {
        this.errorMsg = errorMsg;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public int getRet() {
        return ret;
    }

    public void setRet(int ret) {
        this.ret = ret;
    }
}
