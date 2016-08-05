package com.meila.soa.proxy.model.erp;

import java.io.Serializable;
import java.util.Date;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

import com.meila.soa.proxy.utils.JaxbDateSerializer;

/**
 * 
 ************************************************************
 * @类名 : ErpRequestHead.java
 *
 * @DESCRIPTION : erp请求的报文的头部信息
 * @AUTHOR :  meila-x
 * @DATE :  2016年1月6日
 ************************************************************
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType
public class ErpRequestHead implements Serializable{
    private String op_type;
    private String batch_no;
    
    @XmlJavaTypeAdapter(JaxbDateSerializer.class)
    private Date send_time;
    
    public String getOp_type() {
        return op_type;
    }
    public void setOp_type(String op_type) {
        this.op_type = op_type;
    }
    public String getBatch_no() {
        return batch_no;
    }
    public void setBatch_no(String batch_no) {
        this.batch_no = batch_no;
    }
    public Date getSend_time() {
        return send_time;
    }
    public void setSend_time(Date send_time) {
        this.send_time = send_time;
    }
    
}
