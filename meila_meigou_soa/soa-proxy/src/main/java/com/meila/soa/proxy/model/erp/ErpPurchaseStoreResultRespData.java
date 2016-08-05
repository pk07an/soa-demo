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
 * @类名 : ErpPurchaseStoreResultRespData.java
 *
 * @DESCRIPTION : erp采购单入库结果回传应答报文(代理层->erp)
 * @AUTHOR :  abner
 * @DATE :  2016年1月14日
 ************************************************************
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType
@XmlRootElement(name="xmldata")
public class ErpPurchaseStoreResultRespData {
	private ErpResponseHead head;
	private PurchaseStoreResultBody body;
	
	
	public ErpPurchaseStoreResultRespData(ErpResponseHead head,
			PurchaseStoreResultBody body) {
		super();
		this.head = head;
		this.body = body;
	}
	public ErpPurchaseStoreResultRespData() {
		super();
	}
	
	public ErpResponseHead getHead() {
		return head;
	}
	public void setHead(ErpResponseHead head) {
		this.head = head;
	}
	public PurchaseStoreResultBody getBody() {
		return body;
	}
	public void setBody(PurchaseStoreResultBody body) {
		this.body = body;
	}


	//采购单入库结果回传响应的报文体
	@XmlAccessorType(XmlAccessType.FIELD)
	@XmlType
	public static class PurchaseStoreResultBody{
		@XmlElementWrapper(name="datalist")
		@XmlElement(name="data")
		private List<PurchaseStoreResultRespDateItem> dataList;

		public PurchaseStoreResultBody() {
			super();
		}

		public PurchaseStoreResultBody(
				List<PurchaseStoreResultRespDateItem> dataList) {
			super();
			this.dataList = dataList;
		}

		public List<PurchaseStoreResultRespDateItem> getDataList() {
			return dataList;
		}

		public void setDataList(List<PurchaseStoreResultRespDateItem> dataList) {
			this.dataList = dataList;
		}

	}
	//采购单入库结果回传应答明细数据--只将失败的采购单数据返回
	@XmlAccessorType(XmlAccessType.FIELD)
	@XmlType
	public static class PurchaseStoreResultRespDateItem{
		//采购单编号
		@Mapping("erpPurchaseCode")
		private String purchase_code;
		@Mapping("asnNo")
		private String asn_no;
		//错误码
		@Mapping("errorCode")
		private String error_code;
		//错误消息
		@Mapping("errorMsg")
		private String error_msg;
		public PurchaseStoreResultRespDateItem() {
			super();
		}
		public PurchaseStoreResultRespDateItem(String purchase_code,String asn_no,
				String error_code, String error_msg) {
			super();
			this.purchase_code = purchase_code;
			this.error_code = error_code;
			this.error_msg = error_msg;
			this.asn_no = asn_no;
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
		/**
		 * @return the asn_no
		 */
		public String getAsn_no() {
			return asn_no;
		}
		/**
		 * @param asn_no the asn_no to set
		 */
		public void setAsn_no(String asn_no) {
			this.asn_no = asn_no;
		}
		
	}
}
