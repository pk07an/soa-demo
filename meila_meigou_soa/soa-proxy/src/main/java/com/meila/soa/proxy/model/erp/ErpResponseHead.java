package com.meila.soa.proxy.model.erp;

import java.util.Date;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

import com.meila.soa.proxy.utils.JaxbDateSerializer;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType
public class ErpResponseHead {
    private String op_type;
    private String batch_no;
    @XmlJavaTypeAdapter(JaxbDateSerializer.class)
    private Date send_time;
    private String op_result;
    private String error_code;
    private String error_msg;
    private Integer is_complete;
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
    public String getOp_result() {
        return op_result;
    }
    public void setOp_result(String op_result) {
        this.op_result = op_result;
    }
    public String getError_code() {
        return error_code;
    }
    public void setError_code(String error_code) {
        this.error_code = error_code;
    }
    public String getError_msg() {
        return error_msg;
    }
    public void setError_msg(String error_msg) {
        this.error_msg = error_msg;
    }
	public Integer getIs_complete() {
		return is_complete;
	}
	public void setIs_complete(Integer is_complete) {
		this.is_complete = is_complete;
	}
}
