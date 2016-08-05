package com.meila.soa.proxy.model.erp;

import java.math.BigDecimal;
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
 * @类名 : ErpOrderPackageSyncRespData.java
 *
 * @DESCRIPTION : erp抓取已经出库的销售订单的响应报文(代理层->erp)
 * @AUTHOR :  meila-x
 * @DATE :  2016年1月14日
 ************************************************************
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType
@XmlRootElement(name="xmldata")
public class ErpOrderPackageSyncRespData {
	private ErpResponseHead head;
	private OrderPackageSyncBody body;
	
	public ErpOrderPackageSyncRespData() {
		super();
	}
	public ErpOrderPackageSyncRespData(ErpResponseHead head,
			OrderPackageSyncBody body) {
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
	public OrderPackageSyncBody getBody() {
		return body;
	}
	public void setBody(OrderPackageSyncBody body) {
		this.body = body;
	}


	//应答报文的body对象
	@XmlAccessorType(XmlAccessType.FIELD)
	@XmlType
	public static class OrderPackageSyncBody{
		@XmlElementWrapper(name="datalist")
		@XmlElement(name="data")
		private List<OrderPackageSyncData> dataList; //销售订单明细数据

		public OrderPackageSyncBody() {
			super();
		}

		public OrderPackageSyncBody(List<OrderPackageSyncData> dataList) {
			super();
			this.dataList = dataList;
		}

		public List<OrderPackageSyncData> getDataList() {
			return dataList;
		}

		public void setDataList(List<OrderPackageSyncData> dataList) {
			this.dataList = dataList;
		}
		
	}
	//销售订单的信息
	@XmlAccessorType(XmlAccessType.FIELD)
	@XmlType
	public static class OrderPackageSyncData{
		@Mapping("erpBuyerId")
		private String erp_buyer_id;  //客户(固定值)
		@Mapping("orderNo")
		private String order_no;      //原始订单号
		@Mapping("partner")
		private String partner;       //支付编码===商户号
		@Mapping("packageCode")
		private String package_code;  //OMS包裹号
		@Mapping("tradeNo")
		private String trade_no;      //支付流水号===第三方支付系统返回的流水号
		@Mapping("payType")
		private String pay_type;      //支付方式
		@XmlJavaTypeAdapter(JaxbDateSerializer.class)
		@Mapping("payTime")
		private Date pay_time;        //支付时间
		@XmlJavaTypeAdapter(JaxbDateSerializer.class)
		@Mapping("shippedTime")
		private Date shipped_time;    //发货时间
		
		@XmlElementWrapper(name="itemlist")
		@XmlElement(name="item")
		private List<OrderPackageSyncSkuItem> itemList; //sku明细

		public OrderPackageSyncData() {
			super();
		}

		public OrderPackageSyncData(String erp_buyer_id, String order_no,
				String partner, String package_code, String trade_no,
				String pay_type, Date pay_time, Date shipped_time,
				List<OrderPackageSyncSkuItem> itemList) {
			super();
			this.erp_buyer_id = erp_buyer_id;
			this.order_no = order_no;
			this.partner = partner;
			this.package_code = package_code;
			this.trade_no = trade_no;
			this.pay_type = pay_type;
			this.pay_time = pay_time;
			this.shipped_time = shipped_time;
			this.itemList = itemList;
		}

		public String getErp_buyer_id() {
			return erp_buyer_id;
		}

		public void setErp_buyer_id(String erp_buyer_id) {
			this.erp_buyer_id = erp_buyer_id;
		}

		public String getOrder_no() {
			return order_no;
		}

		public void setOrder_no(String order_no) {
			this.order_no = order_no;
		}

		public String getPartner() {
			return partner;
		}

		public void setPartner(String partner) {
			this.partner = partner;
		}

		public String getPackage_code() {
			return package_code;
		}

		public void setPackage_code(String package_code) {
			this.package_code = package_code;
		}

		public String getTrade_no() {
			return trade_no;
		}

		public void setTrade_no(String trade_no) {
			this.trade_no = trade_no;
		}

		public String getPay_type() {
			return pay_type;
		}

		public void setPay_type(String pay_type) {
			this.pay_type = pay_type;
		}

		public Date getPay_time() {
			return pay_time;
		}

		public void setPay_time(Date pay_time) {
			this.pay_time = pay_time;
		}

		public Date getShipped_time() {
			return shipped_time;
		}

		public void setShipped_time(Date shipped_time) {
			this.shipped_time = shipped_time;
		}

		public List<OrderPackageSyncSkuItem> getItemList() {
			return itemList;
		}

		public void setItemList(List<OrderPackageSyncSkuItem> itemList) {
			this.itemList = itemList;
		}
		
		
	}
	//销售订单的sku明细信息
	@XmlAccessorType(XmlAccessType.FIELD)
	@XmlType
	public static class OrderPackageSyncSkuItem{
		@Mapping("erpSkuId")
		private String erp_sku_id; //sku_id
		@Mapping("skuStr")
		private String sku_str;    //规格型号
		@Mapping("erpSkuCode")
		private String erp_sku_code; //物料编号
		@Mapping("erpSkuName")
		private String erp_sku_name; //物料名称
		@Mapping("amount")
		private int amount;          //数量
		@Mapping("skuPrice")
		private BigDecimal sku_price;  //含税单价
		@Mapping("skuTotalPrice")
		private BigDecimal sku_total_price; //含税金额 = 含税单价*数量
		@Mapping("skuDiscountFee")
		private BigDecimal sku_discount_fee; //折扣额 = 总的折扣金额
		@Mapping("warehouseCode")
		private String warehouse_code;
		public OrderPackageSyncSkuItem() {
			super();
		}
		public OrderPackageSyncSkuItem(String erp_sku_id, String sku_str,
				String erp_sku_code, String erp_sku_name, int amount,
				BigDecimal sku_price, BigDecimal sku_total_price,
				BigDecimal sku_discount_fee) {
			super();
			this.erp_sku_id = erp_sku_id;
			this.sku_str = sku_str;
			this.erp_sku_code = erp_sku_code;
			this.erp_sku_name = erp_sku_name;
			this.amount = amount;
			this.sku_price = sku_price;
			this.sku_total_price = sku_total_price;
			this.sku_discount_fee = sku_discount_fee;
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
		public int getAmount() {
			return amount;
		}
		public void setAmount(int amount) {
			this.amount = amount;
		}
		public BigDecimal getSku_price() {
			return sku_price;
		}
		public void setSku_price(BigDecimal sku_price) {
			this.sku_price = sku_price;
		}
		public BigDecimal getSku_total_price() {
			return sku_total_price;
		}
		public void setSku_total_price(BigDecimal sku_total_price) {
			this.sku_total_price = sku_total_price;
		}
		public BigDecimal getSku_discount_fee() {
			return sku_discount_fee;
		}
		public void setSku_discount_fee(BigDecimal sku_discount_fee) {
			this.sku_discount_fee = sku_discount_fee;
		}
		/**
		 * @return the warehouse_code
		 */
		public String getWarehouse_code() {
			return warehouse_code;
		}
		/**
		 * @param warehouse_code the warehouse_code to set
		 */
		public void setWarehouse_code(String warehouse_code) {
			this.warehouse_code = warehouse_code;
		}
		
		
	}
}
