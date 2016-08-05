package com.meila.soa.proxy.model.erp;

import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

import org.dozer.Mapping;

/**
 * 
 ************************************************************
 * @类名 : ErpInventorySyncRespData.java
 *
 * @DESCRIPTION : erp库存同步的应答报文(代理层->erp)
 * @AUTHOR :  abner
 * @DATE :  2016年1月15日
 ************************************************************
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType
@XmlRootElement(name="xmldata")
public class ErpInventorySyncRespData {
	private ErpResponseHead head;
	private InventorySyncRespBody body;
	
	public ErpInventorySyncRespData() {
		super();
	}
	
	public ErpInventorySyncRespData(ErpResponseHead head,
			InventorySyncRespBody body) {
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

	public InventorySyncRespBody getBody() {
		return body;
	}

	public void setBody(InventorySyncRespBody body) {
		this.body = body;
	}


	//应答报文体,只有部分成功是,才存在
	@XmlAccessorType(XmlAccessType.FIELD)
	@XmlType
	public static class InventorySyncRespBody{
		@XmlElementWrapper(name="datalist")
		@XmlElement(name="data")
		@Mapping("resultList")
		private List<InventorySyncRespData> datalist;

		public InventorySyncRespBody() {
			super();
		}

		public InventorySyncRespBody(List<InventorySyncRespData> datalist) {
			super();
			this.datalist = datalist;
		}

		public List<InventorySyncRespData> getDatalist() {
			return datalist;
		}

		public void setDatalist(List<InventorySyncRespData> datalist) {
			this.datalist = datalist;
		}
		
		
	}
	//应答报文明细数据(只包含同步处理失败的sku)
	@XmlAccessorType(XmlAccessType.FIELD)
	@XmlType
	public static class InventorySyncRespData{
		@Mapping("erpSkuId")
		private String erp_sku_id;
		@Mapping("errorCode")
		private String error_code;
		@Mapping("errorMsg")
		private String error_msg;
		public InventorySyncRespData() {
			super();
		}
		public InventorySyncRespData(String erp_sku_id, String error_code,
				String error_msg) {
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
