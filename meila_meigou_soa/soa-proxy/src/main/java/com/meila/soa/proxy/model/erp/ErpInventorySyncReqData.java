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
 * @类名 : ErpInventorySyncReqData.java
 *
 * @DESCRIPTION : ERP Sku 库存同步请求(erp->代理层)
 * @AUTHOR :  meila-x
 * @DATE :  2016年1月15日
 ************************************************************
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType
@XmlRootElement(name="xmldata")
public class ErpInventorySyncReqData {
	private ErpRequestHead head;
	private InventorySyncReqBody body;
	
	public ErpInventorySyncReqData() {
		super();
	}
	
	public ErpInventorySyncReqData(ErpRequestHead head,
			InventorySyncReqBody body) {
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

	public InventorySyncReqBody getBody() {
		return body;
	}

	public void setBody(InventorySyncReqBody body) {
		this.body = body;
	}


	//库存同步请求的报文体
	@XmlAccessorType(XmlAccessType.FIELD)
	@XmlType
	public static class InventorySyncReqBody{
		@XmlElementWrapper(name="datalist")
		@XmlElement(name="data")
		@Mapping("inventoryList")
		private List<InventorySyncReqData>dataList;

		public InventorySyncReqBody() {
			super();
		}

		public InventorySyncReqBody(List<InventorySyncReqData> dataList) {
			super();
			this.dataList = dataList;
		}

		public List<InventorySyncReqData> getDataList() {
			return dataList;
		}

		public void setDataList(List<InventorySyncReqData> dataList) {
			this.dataList = dataList;
		}
		
		
	}
	//报文中的明细数据
	@XmlAccessorType(XmlAccessType.FIELD)
	@XmlType
	public static class InventorySyncReqData{
		@Mapping("erpSkuId")
		private String erp_sku_id; //sku_id
		@Mapping("batchNo")
		private String erp_batch_no; //批次号,如果erp启用了批次管理,如果没有则为空
		@Mapping("realAmount")
		private int real_amount;  //实际可用库存
		@Mapping("warehouse")
		private String warehouse; //仓库
		public InventorySyncReqData() {
			super();
		}
		public InventorySyncReqData(String erp_sku_id, String erp_batch_no,
				int real_amount, String warehouse) {
			super();
			this.erp_sku_id = erp_sku_id;
			this.erp_batch_no = erp_batch_no;
			this.real_amount = real_amount;
			this.warehouse = warehouse;
		}
		public String getErp_sku_id() {
			return erp_sku_id;
		}
		public void setErp_sku_id(String erp_sku_id) {
			this.erp_sku_id = erp_sku_id;
		}
		public String getErp_batch_no() {
			return erp_batch_no;
		}
		public void setErp_batch_no(String erp_batch_no) {
			this.erp_batch_no = erp_batch_no;
		}
		public int getReal_amount() {
			return real_amount;
		}
		public void setReal_amount(int real_amount) {
			this.real_amount = real_amount;
		}
		public String getWarehouse() {
			return warehouse;
		}
		public void setWarehouse(String warehouse) {
			this.warehouse = warehouse;
		}
		
		
	}
}
