package com.meila.soa.proxy.model.erp;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

/**
 * 
 ************************************************************
 * @类名 : BaseErpResponse.java
 *
 * @DESCRIPTION : erp基本的应答字段
 * @AUTHOR :  meila-x
 * @DATE :  2016年1月6日
 ************************************************************
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType
@XmlRootElement(name = "xmldata")
public class BaseErpResponse implements Serializable{

    @XmlElement(name="head")
    private ErpResponseHead head;

    public ErpResponseHead getHead() {
        return head;
    }

    public void setHead(ErpResponseHead head) {
        this.head = head;
    }
    
    
}
