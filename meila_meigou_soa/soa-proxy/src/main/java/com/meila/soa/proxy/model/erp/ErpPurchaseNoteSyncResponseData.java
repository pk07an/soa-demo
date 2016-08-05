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
 * @类名 : ErpPurchaseNoteSyncResponseData.java
 *
 * @DESCRIPTION : 
 * @AUTHOR :  abner
 * @DATE :  2016年1月14日
 ************************************************************
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType
@XmlRootElement(name="xmldata")
public class ErpPurchaseNoteSyncResponseData {
	private ErpResponseHead head;
	private PurchaseRespBody body;
	
	public ErpPurchaseNoteSyncResponseData() {
		super();
	}
	public ErpPurchaseNoteSyncResponseData(ErpResponseHead head,
			PurchaseRespBody body) {
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
	public PurchaseRespBody getBody() {
		return body;
	}
	public void setBody(PurchaseRespBody body) {
		this.body = body;
	}

	//定义返回报文体
	@XmlAccessorType(XmlAccessType.FIELD)
	@XmlType
	public static class PurchaseRespBody{
		@XmlElementWrapper(name="datalist")
		@XmlElement(name="data")
		private List<PurchaseNoteRespData>dataList;

		public PurchaseRespBody() {
			super();
		}

		public PurchaseRespBody(List<PurchaseNoteRespData> dataList) {
			super();
			this.dataList = dataList;
		}

		public List<PurchaseNoteRespData> getDataList() {
			return dataList;
		}

		public void setDataList(List<PurchaseNoteRespData> dataList) {
			this.dataList = dataList;
		}
		
		
	}
	//定义返回报文体明细对象
	@XmlAccessorType(XmlAccessType.FIELD)
	@XmlType
	public static class PurchaseNoteRespData{
		@Mapping("erpPurchaseCode")
		private String purchase_code;
		@Mapping("errorCode")
		private String error_code;
		@Mapping("errorMsg")
		private String error_msg;
		public PurchaseNoteRespData() {
			super();
		}
		public PurchaseNoteRespData(String purchase_code, String error_code,
				String error_msg) {
			super();
			this.purchase_code = purchase_code;
			this.error_code = error_code;
			this.error_msg = error_msg;
		}
		public String getPurchase_code() {
			return purchase_code;
		}
		public void setPurchase_code(String purchase_code) {
			this.purchase_code = purchase_code;
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
