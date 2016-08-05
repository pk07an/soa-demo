package com.meila.soa.proxy.model.erp;

import java.util.Date;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

import org.dozer.Mapping;

import com.meila.soa.proxy.utils.JaxbDateSerializer;

/**
 * 
 ************************************************************
 * @类名 : ErpPurchaseNoteStoreSyncRespData.java
 *
 * @DESCRIPTION : erp采购单入库同步返回(proxy->erp)
 * @AUTHOR :  abner
 * @DATE :  2016年1月14日
 ************************************************************
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType
@XmlRootElement(name="xmldata")
public class ErpPurchaseNoteStoreSyncRespData {
	private ErpResponseHead head;
	private PurchaseStoreBody body;
	
	public ErpPurchaseNoteStoreSyncRespData() {
		super();
	}
	
	public ErpPurchaseNoteStoreSyncRespData(ErpResponseHead head,
			PurchaseStoreBody body) {
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

	public PurchaseStoreBody getBody() {
		return body;
	}

	public void setBody(PurchaseStoreBody body) {
		this.body = body;
	}

	@XmlAccessorType(XmlAccessType.FIELD)
	@XmlType
	public static class PurchaseStoreBody{
		@XmlElementWrapper(name="datalist")
		@XmlElement(name="data")
		private List<PurchaseStoreData>dataList;

		public PurchaseStoreBody(List<PurchaseStoreData> dataList) {
			super();
			this.dataList = dataList;
		}

		public PurchaseStoreBody() {
			super();
		}

		public List<PurchaseStoreData> getDataList() {
			return dataList;
		}

		public void setDataList(List<PurchaseStoreData> dataList) {
			this.dataList = dataList;
		}
	}
	@XmlAccessorType(XmlAccessType.FIELD)
	@XmlType
	public static class PurchaseStoreData{
		@Mapping("purchaseCode")
		private String purchase_code;
		@XmlJavaTypeAdapter(JaxbDateSerializer.class)
		@Mapping("inStorageTime")
		private Date instore_time;
		@Mapping("asnNo")
		private String asn_no;
		@XmlElementWrapper(name="itemlist")
		@XmlElement(name="item")
		private List<PurchaseNoteStoreItem>itemList;
		public PurchaseStoreData() {
			super();
		}
		public PurchaseStoreData(String purchase_code, Date instore_time,String asn_no,
				List<PurchaseNoteStoreItem> itemList) {
			super();
			this.purchase_code = purchase_code;
			this.instore_time = instore_time;
			this.itemList = itemList;
			this.asn_no = asn_no;
		}
		public String getPurchase_code() {
			return purchase_code;
		}
		public void setPurchase_code(String purchase_code) {
			this.purchase_code = purchase_code;
		}
		public Date getInstore_time() {
			return instore_time;
		}
		public void setInstore_time(Date instore_time) {
			this.instore_time = instore_time;
		}
		public List<PurchaseNoteStoreItem> getItemList() {
			return itemList;
		}
		public void setItemList(List<PurchaseNoteStoreItem> itemList) {
			this.itemList = itemList;
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
	//采购单入库同步,入库明细数据
	@XmlAccessorType(XmlAccessType.FIELD)
	@XmlType
	public static class PurchaseNoteStoreItem{
		@Mapping("erpSkuId")
		private String erp_sku_id;
		@Mapping("realAmount")
		private Integer purchase_amount;
		@Mapping("skuBarCode")
		private String sku_bar_code;
		@Mapping("purchaseStorekeeper")
		private String purchase_storekeeper;
		@Mapping("purchaseAcceptance")
		private String purchase_acceptance;
		@Mapping("housingWarehouse")
		private String instore_warehouse;
		public PurchaseNoteStoreItem() {
			super();
		}
		public PurchaseNoteStoreItem(String erp_sku_id, int purchase_amount,
				String sku_bar_code, String purchase_storekeeper,
				String purchase_acceptance, String instore_warehouse) {
			super();
			this.erp_sku_id = erp_sku_id;
			this.purchase_amount = purchase_amount;
			this.sku_bar_code = sku_bar_code;
			this.purchase_storekeeper = purchase_storekeeper;
			this.purchase_acceptance = purchase_acceptance;
			this.instore_warehouse = instore_warehouse;
		}
		public String getErp_sku_id() {
			return erp_sku_id;
		}
		public void setErp_sku_id(String erp_sku_id) {
			this.erp_sku_id = erp_sku_id;
		}
		public int getPurchase_amount() {
			return purchase_amount;
		}
		public void setPurchase_amount(int purchase_amount) {
			this.purchase_amount = purchase_amount;
		}
		public String getSku_bar_code() {
			return sku_bar_code;
		}
		public void setSku_bar_code(String sku_bar_code) {
			this.sku_bar_code = sku_bar_code;
		}
		public String getPurchase_storekeeper() {
			return purchase_storekeeper;
		}
		public void setPurchase_storekeeper(String purchase_storekeeper) {
			this.purchase_storekeeper = purchase_storekeeper;
		}
		public String getPurchase_acceptance() {
			return purchase_acceptance;
		}
		public void setPurchase_acceptance(String purchase_acceptance) {
			this.purchase_acceptance = purchase_acceptance;
		}
		public String getInstore_warehouse() {
			return instore_warehouse;
		}
		public void setInstore_warehouse(String instore_warehouse) {
			this.instore_warehouse = instore_warehouse;
		}
	}
}
