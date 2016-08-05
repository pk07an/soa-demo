package com.meila.soa.meila.client.model;

/**
 ************************************************************
 * @类名 : OmsJsonResult.java
 *
 * @DESCRIPTION : oms接口返回对象
 * @AUTHOR : yongqi
 * @DATE : 2015年11月23日
 ************************************************************
 */
public class OmsJsonResult {

    public static final int FAILED = 1;
    public static final int SUCCESS = 0;

    private int ret;

    private String errorMsg;

    private Object data;

    private String errorCode;

    public boolean isSuccess() {
        return ret == SUCCESS;
    }

    public boolean isFail() {
        return ret == FAILED;
    }

    public static OmsJsonResult buildSuccessResult() {
        OmsJsonResult result = new OmsJsonResult();
        result.setRet(SUCCESS);
        return result;
    }

    public int getRet() {
        return ret;
    }

    public void setRet(int ret) {
        this.ret = ret;
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

    public String getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(String errorCode) {
        this.errorCode = errorCode;
    }
}
