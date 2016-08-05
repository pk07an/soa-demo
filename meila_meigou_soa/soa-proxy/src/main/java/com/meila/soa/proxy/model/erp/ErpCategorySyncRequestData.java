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
 * @类名 : ErpCategorySyncRequestData.java
 *
 * @DESCRIPTION : erp sku 分类树同步请求报文(erp->代理层)
 * @AUTHOR :  meila-x
 * @DATE :  2016年1月15日
 ************************************************************
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType
@XmlRootElement(name="xmldata")
public class ErpCategorySyncRequestData {
	private ErpRequestHead head;
	private CategorySyncReqBody body;

	public ErpCategorySyncRequestData() {
		super();
	}
	
	public ErpCategorySyncRequestData(ErpRequestHead head,
			CategorySyncReqBody body) {
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

	public CategorySyncReqBody getBody() {
		return body;
	}

	public void setBody(CategorySyncReqBody body) {
		this.body = body;
	}


	//分类树同步的报文体
	@XmlAccessorType(XmlAccessType.FIELD)
	@XmlType
	public static class CategorySyncReqBody{
		@XmlElementWrapper(name="datalist")
		@XmlElement(name="data")
		@Mapping("categoryList")
		private List<CategorySyncReqData>dataList;

		public CategorySyncReqBody() {
			super();
		}

		public CategorySyncReqBody(List<CategorySyncReqData> dataList) {
			super();
			this.dataList = dataList;
		}

		public List<CategorySyncReqData> getDataList() {
			return dataList;
		}

		public void setDataList(List<CategorySyncReqData> dataList) {
			this.dataList = dataList;
		}
		
	}
	//分类树同请求的明细数据
	@XmlAccessorType(XmlAccessType.FIELD)
	@XmlType
	public static class CategorySyncReqData{
		@Mapping("categoryCode")
		private String category_code;
		@Mapping("categoryName")
		private String category_name;
		@Mapping("parentCode")
		private String parent_code;
		public CategorySyncReqData() {
			super();
		}
		public CategorySyncReqData(String category_code, String category_name,
				String parent_code) {
			super();
			this.category_code = category_code;
			this.category_name = category_name;
			this.parent_code = parent_code;
		}
		public String getCategory_code() {
			return category_code;
		}
		public void setCategory_code(String category_code) {
			this.category_code = category_code;
		}
		public String getCategory_name() {
			return category_name;
		}
		public void setCategory_name(String category_name) {
			this.category_name = category_name;
		}
		public String getParent_code() {
			return parent_code;
		}
		public void setParent_code(String parent_code) {
			this.parent_code = parent_code;
		}
		
		
	}
}
