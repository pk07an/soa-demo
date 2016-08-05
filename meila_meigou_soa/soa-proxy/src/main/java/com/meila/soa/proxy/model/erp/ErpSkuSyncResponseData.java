package com.meila.soa.proxy.model.erp;

import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

/**
 * 
 ************************************************************
 * @类名 : ErpSkuSyncResponseData.java
 *
 * @DESCRIPTION : erp商品同步应答数据
 * @AUTHOR :  abner
 * @DATE :  2016年1月7日
 ************************************************************
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType
@XmlRootElement(name="xmldata")
public class ErpSkuSyncResponseData {
    @XmlElement(name="head")
    private ErpResponseHead head;
    private ErpSkuSyncResponseData.Body body;
    
    /**
	 * 
	 */
	public ErpSkuSyncResponseData() {
		super();
	}

	/**
	 * @param head
	 * @param body
	 */
	public ErpSkuSyncResponseData(ErpResponseHead head, Body body) {
		super();
		this.head = head;
		this.body = body;
	}

	public ErpResponseHead getHead() {
        return head;
    }

    public void setHead(ErpResponseHead head) {
        this.head = head;
    }
    
    
    
    /**
	 * @return the body
	 */
	public ErpSkuSyncResponseData.Body getBody() {
		return body;
	}

	/**
	 * @param body the body to set
	 */
	public void setBody(ErpSkuSyncResponseData.Body body) {
		this.body = body;
	}



	@XmlAccessorType(XmlAccessType.FIELD)
    @XmlType
    public static class Body{
        @XmlElementWrapper(name="datalist")
        @XmlElement(name="data")
        private List<Data> data;
        
        public Body(){}

        public Body(List<Data> data) {
            super();
            this.data = data;
        }

        public List<Data> getData() {
            return data;
        }

        public void setData(List<Data> data) {
            this.data = data;
        }
        
        
    }
    
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType
    public static class Data{
        private String erp_sku_id;
        private String error_code;
        private String error_msg;
        public Data(){}
        public Data(String erp_sku_id, String error_code, String error_msg) {
            super();
            this.erp_sku_id = erp_sku_id;
            this.error_code = error_code;
            this.error_msg = error_msg;
        }
       
        public String getErp_sku_id() {
			return erp_sku_id;
		}
		public void setErp_sku_id(String erp_sku_id) {
			this.erp_sku_id = erp_sku_id;
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
        
        
    }
}
