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
 * @类名 : ErpPurchaseStoreResultReqData.java
 *
 * @DESCRIPTION : erp采购单入库结果回传请求报文(erp->代理层)
 * @AUTHOR :  abner
 * @DATE :  2016年1月14日
 ************************************************************
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType
@XmlRootElement(name="xmldata")
public class ErpPurchaseStoreResultReqData {
	private ErpRequestHead head;
	private PurchaseStoreResultBody body;
	
	public ErpPurchaseStoreResultReqData() {
		super();
	}
	public ErpPurchaseStoreResultReqData(ErpRequestHead head,
			PurchaseStoreResultBody body) {
		super();
		this.head = head;
		this.body = body;
	}

	public ErpRequestHead getHead() {
		return head;
	}
	public void setHead(ErpRequestHead head) {
		this.head = head;
	}
	public PurchaseStoreResultBody getBody() {
		return body;
	}
	public void setBody(PurchaseStoreResultBody body) {
		this.body = body;
	}

	//body对象
	@XmlAccessorType(XmlAccessType.FIELD)
	@XmlType
	public static class PurchaseStoreResultBody{
		@XmlElementWrapper(name="datalist")
		@XmlElement(name="data")
		private List<PurchaseStoreResultData> dataList;

		/**
		 * @param dataList
		 */
		public PurchaseStoreResultBody(List<PurchaseStoreResultData> dataList) {
			super();
			this.dataList = dataList;
		}

		/**
		 * 
		 */
		public PurchaseStoreResultBody() {
			super();
		}

		/**
		 * @return the dataList
		 */
		public List<PurchaseStoreResultData> getDataList() {
			return dataList;
		}

		/**
		 * @param dataList the dataList to set
		 */
		public void setDataList(List<PurchaseStoreResultData> dataList) {
			this.dataList = dataList;
		}
		
		
	}
	//采购单入库回传明细数据
	public static class PurchaseStoreResultData{
		//供应商名称
		@Mapping("supplierName")
		private String supplier_name;
		//采购单编号
		@Mapping("erpPurchaseCode")
		private String purchase_code;
		@Mapping("asnNo")
		private String asn_no;
		public PurchaseStoreResultData() {
			super();
		}
		public PurchaseStoreResultData(String supplier_name,String asn_no,
				String purchase_code) {
			super();
			this.supplier_name = supplier_name;
			this.purchase_code = purchase_code;
			this.asn_no = asn_no;
		}
		public String getSupplier_name() {
			return supplier_name;
		}
		public void setSupplier_name(String supplier_name) {
			this.supplier_name = supplier_name;
		}
		public String getPurchase_code() {
			return purchase_code;
		}
		public void setPurchase_code(String purchase_code) {
			this.purchase_code = purchase_code;
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
