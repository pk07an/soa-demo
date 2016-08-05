/**
 * 
 */
package com.meila.soa.proxy.model;

/**
 ************************************************************
 * @类名 : JsonResult.java
 *
 * @DESCRIPTION :
 * @AUTHOR : flong
 * @DATE : 2016年1月13日
 ************************************************************
 */
public class JsonResult {

    private String code;
    private String msg;
    private Object data;

    public JsonResult(String retCode, String retMsg, Object data) {
        this.code = retCode;
        this.msg = retMsg;
        this.data = data;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

}
