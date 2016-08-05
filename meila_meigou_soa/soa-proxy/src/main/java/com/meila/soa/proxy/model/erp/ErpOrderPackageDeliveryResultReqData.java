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
 * @类名 : ErpOrderPackageDeliveryResultReqData.java
 *
 * @DESCRIPTION : erp销售订单出库结果回传请求报文(erp->代理层)
 * @AUTHOR :  meila-x
 * @DATE :  2016年1月15日
 ************************************************************
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType
@XmlRootElement(name="xmldata")
public class ErpOrderPackageDeliveryResultReqData {
	private ErpRequestHead head;
	private OrderpackageDeliveryReqBody body;

	public ErpOrderPackageDeliveryResultReqData() {
		super();
	}
	
	public ErpOrderPackageDeliveryResultReqData(ErpRequestHead head,
			OrderpackageDeliveryReqBody body) {
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

	public OrderpackageDeliveryReqBody getBody() {
		return body;
	}

	public void setBody(OrderpackageDeliveryReqBody body) {
		this.body = body;
	}


	//erp推送销售出库单成功的报文体
	@XmlAccessorType(XmlAccessType.FIELD)
	@XmlType
	public static class OrderpackageDeliveryReqBody{
		@XmlElementWrapper(name="datalist")
		@XmlElement(name="data")
		private List<OrderPackageDeliveryReqData> dataList;

		public OrderpackageDeliveryReqBody() {
			super();
		}

		public OrderpackageDeliveryReqBody(
				List<OrderPackageDeliveryReqData> dataList) {
			super();
			this.dataList = dataList;
		}

		public List<OrderPackageDeliveryReqData> getDataList() {
			return dataList;
		}

		public void setDataList(List<OrderPackageDeliveryReqData> dataList) {
			this.dataList = dataList;
		}
		
		
	}
	//erp推送销售出库单同步成功的请求明细数据
	@XmlAccessorType(XmlAccessType.FIELD)
	@XmlType
	public static class OrderPackageDeliveryReqData{
		@Mapping("orderNo")
		private String order_no; //订单编号
		@Mapping("packageCode")
		private String package_code; //包裹号
		public OrderPackageDeliveryReqData() {
			super();
		}
		public OrderPackageDeliveryReqData(String order_no, String package_code) {
			super();
			this.order_no = order_no;
			this.package_code = package_code;
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
	}
}
