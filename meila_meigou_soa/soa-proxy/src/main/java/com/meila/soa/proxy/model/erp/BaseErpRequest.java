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
 * @类名 : BaseErpRequest.java
 *
 * @DESCRIPTION : erp请求的基本节点,即头结点
 * @AUTHOR :  abner
 * @DATE :  2016年1月6日
 ************************************************************
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType
@XmlRootElement( name = "xmldata")

public class BaseErpRequest implements Serializable{
    
    @XmlElement(name="head")
    private ErpRequestHead head;

    public ErpRequestHead getHead() {
        return head;
    }

    public void setHead(ErpRequestHead head) {
        this.head = head;
    }
    
    
}
