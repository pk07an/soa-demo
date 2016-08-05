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
 * @类名 : ErpPurchaseNoteSyncRequestData.java
 *
 * @DESCRIPTION : Erp采购单同步请求数据
 * @AUTHOR :  abner
 * @DATE :  2016年1月14日
 ************************************************************
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType
@XmlRootElement(name="xmldata")
public class ErpPurchaseNoteSyncRequestData {
	//@XmlElement(name="head")
	private ErpRequestHead head;
	private PurchaseBody body;

	public ErpPurchaseNoteSyncRequestData() {
		super();
	}
	public ErpPurchaseNoteSyncRequestData(ErpRequestHead head, PurchaseBody body) {
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
	public PurchaseBody getBody() {
		return body;
	}
	public void setBody(PurchaseBody body) {
		this.body = body;
	}


	@XmlAccessorType(XmlAccessType.FIELD)
	@XmlType
	public static class PurchaseBody{
		@XmlElementWrapper(name="datalist")
		@XmlElement(name="data")
		private List<PurchaseDataItem> dataList;

		public PurchaseBody() {
			super();
		}

		public PurchaseBody(List<PurchaseDataItem> dataList) {
			super();
			this.dataList = dataList;
		}

		public List<PurchaseDataItem> getDataList() {
			return dataList;
		}

		public void setDataList(List<PurchaseDataItem> dataList) {
			this.dataList = dataList;
		}
		
	}
	@XmlAccessorType(XmlAccessType.FIELD)
	@XmlType
	public static class PurchaseDataItem{
		@Mapping("supplierName") //使用属性赋值的注解
		private String supplier_name;
		@Mapping("erpPurchaseCode")
		private String purchase_code;
		@Mapping("defaultWarehouse")
		private String default_warehouse;
		@Mapping("warehouseAddress")
		private String warehouse_address;
		@XmlJavaTypeAdapter(JaxbDateSerializer.class)
		@Mapping("purchaseTime")
		private Date apply_time;
		@XmlElementWrapper(name="itemlist")
		@XmlElement(name="item")
		private List<SkuItem> itemList;
		
		public PurchaseDataItem(){
			super();
		}

		public PurchaseDataItem(String supplier_name, String purchase_code,
				String default_warehouse, String warehouse_address,
				Date apply_time, List<SkuItem> itemList) {
			super();
			this.supplier_name = supplier_name;
			this.purchase_code = purchase_code;
			this.default_warehouse = default_warehouse;
			this.warehouse_address = warehouse_address;
			this.apply_time = apply_time;
			this.itemList = itemList;
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

		public String getDefault_warehouse() {
			return default_warehouse;
		}

		public void setDefault_warehouse(String default_warehouse) {
			this.default_warehouse = default_warehouse;
		}

		public String getWarehouse_address() {
			return warehouse_address;
		}

		public void setWarehouse_address(String warehouse_address) {
			this.warehouse_address = warehouse_address;
		}

		public Date getApply_time() {
			return apply_time;
		}

		public void setApply_time(Date apply_time) {
			this.apply_time = apply_time;
		}

		public List<SkuItem> getItemList() {
			return itemList;
		}

		public void setItemList(List<SkuItem> itemList) {
			this.itemList = itemList;
		}
		
	}
	@XmlAccessorType(XmlAccessType.FIELD)
	@XmlType
	public static class SkuItem{
		@Mapping("erpSkuId")
		private String erp_sku_id;
		private String sku_str;
		@Mapping("erpSkuCode")
		private String erp_sku_code;
		private String erp_sku_name;
		@Mapping("purchaseAmount")
		private int purchase_amount;
		@XmlJavaTypeAdapter(JaxbDateSerializer.class)
		@Mapping("expecteTime")
		private Date expecte_time;
		public SkuItem() {
			super();
		}
		public SkuItem(String erp_sku_id, String sku_str, String erp_sku_code,
				String erp_sku_name, int purchase_amount, Date expecte_time) {
			super();
			this.erp_sku_id = erp_sku_id;
			this.sku_str = sku_str;
			this.erp_sku_code = erp_sku_code;
			this.erp_sku_name = erp_sku_name;
			this.purchase_amount = purchase_amount;
			this.expecte_time = expecte_time;
		}
		public String getErp_sku_id() {
			return erp_sku_id;
		}
		public void setErp_sku_id(String erp_sku_id) {
			this.erp_sku_id = erp_sku_id;
		}
		public String getSku_str() {
			return sku_str;
		}
		public void setSku_str(String sku_str) {
			this.sku_str = sku_str;
		}
		public String getErp_sku_code() {
			return erp_sku_code;
		}
		public void setErp_sku_code(String erp_sku_code) {
			this.erp_sku_code = erp_sku_code;
		}
		public String getErp_sku_name() {
			return erp_sku_name;
		}
		public void setErp_sku_name(String erp_sku_name) {
			this.erp_sku_name = erp_sku_name;
		}
		public int getPurchase_amount() {
			return purchase_amount;
		}
		public void setPurchase_amount(int purchase_amount) {
			this.purchase_amount = purchase_amount;
		}
		public Date getExpecte_time() {
			return expecte_time;
		}
		public void setExpecte_time(Date expecte_time) {
			this.expecte_time = expecte_time;
		}
		
		
	}
}
