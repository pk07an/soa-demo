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
 * @类名 : ErpOrderPackageDeliveryResultRespData.java
 *
 * @DESCRIPTION : erp销售出库单结果回传应答(代理层->erp)
 * @AUTHOR :  abner
 * @DATE :  2016年1月15日
 ************************************************************
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType
@XmlRootElement(name="xmldata")
public class ErpOrderPackageDeliveryResultRespData {
	private ErpResponseHead head;
	private OrderpackageDeliveryResultRespBody body;
	
	public ErpOrderPackageDeliveryResultRespData() {
		super();
	}

	public ErpOrderPackageDeliveryResultRespData(ErpResponseHead head,
			OrderpackageDeliveryResultRespBody body) {
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

	public OrderpackageDeliveryResultRespBody getBody() {
		return body;
	}

	public void setBody(OrderpackageDeliveryResultRespBody body) {
		this.body = body;
	}

	//应答的报文体
	@XmlAccessorType(XmlAccessType.FIELD)
	@XmlType
	public static class OrderpackageDeliveryResultRespBody{
		@XmlElementWrapper(name="datalist")
		@XmlElement(name="data")
		private List<OrderpackageDeliveryResultRespData> dataList;

		public OrderpackageDeliveryResultRespBody() {
			super();
		}

		public OrderpackageDeliveryResultRespBody(
				List<OrderpackageDeliveryResultRespData> dataList) {
			super();
			this.dataList = dataList;
		}

		public List<OrderpackageDeliveryResultRespData> getDataList() {
			return dataList;
		}

		public void setDataList(List<OrderpackageDeliveryResultRespData> dataList) {
			this.dataList = dataList;
		}
		
		
	}
	
	//应答数据
	@XmlAccessorType(XmlAccessType.FIELD)
	@XmlType
	public static class OrderpackageDeliveryResultRespData{
		@Mapping("orderNo")
		private String order_no;
		@Mapping("packageCode")
		private String package_code;
		@Mapping("errorCode")
		private String error_code;
		@Mapping("errorMsg")
		private String error_msg;
		public OrderpackageDeliveryResultRespData() {
			super();
		}
		public OrderpackageDeliveryResultRespData(String order_no,
				String package_code, String error_code, String error_msg) {
			super();
			this.order_no = order_no;
			this.package_code = package_code;
			this.error_code = error_code;
			this.error_msg = error_msg;
		}
		public String getOrder_no() {
			return order_no;
		}
		public void setOrder_no(String order_no) {
			this.order_no = order_no;
		}
		public String getPackage_code() {
			return package_code;
		}
		public void setPackage_code(String package_code) {
			this.package_code = package_code;
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
