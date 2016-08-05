/**   
* @Title: DubboBasicResponse.java 
* @Package com.pubpi.valinor.dubbo.base.model 
* @Description: TODO(desc the file) 
* @author skyhawk wthuan@foxmail.com
* @date 2015年10月28日 上午11:34:40 
* @version V0.1
*/
package com.meila.dubbo.base.model;

import com.meila.dubbo.base.TidManager;
import com.meila.dubbo.base.constant.DubboReturnCode;

/**
 * 
 ************************************************************
 * @类名 : DubboBasicResponse.java
 *
 * @DESCRIPTION :dubbo请求基础返回类
 * @AUTHOR : hawk
 * @DATE : 2016年1月14日
 ************************************************************
 */
public class DubboBasicResponse extends BasicSeriModel {

    private static final long serialVersionUID = 1L;

    private String tid;

    /**
     * 返回结果编码 0:代表成功 其他：代表异常
     */
    private Integer code;

    /**
     * 错误描述
     */
    private String desc;

    public DubboBasicResponse() {
        super();
        this.code = DubboReturnCode.SUCCESS;
        this.desc = "success";
        tid = TidManager.getTid();
    }

    public DubboBasicResponse(Integer code, String desc) {
        super();
        tid = TidManager.getTid();
        this.code = code;
        this.desc = desc;
    }

    public int getCode() {
        return code;
    }

    public void setCode(Integer resultCode) {
        this.code = resultCode;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String errorMsg) {
        this.desc = errorMsg;
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
}
