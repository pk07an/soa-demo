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
 * @类名 : ErpCategorySyncRespData.java
 *
 * @DESCRIPTION : 分类树同步应答报文体
 * @AUTHOR :  abner
 * @DATE :  2016年1月15日
 ************************************************************
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType
@XmlRootElement(name="xmldata")
public class ErpCategorySyncRespData {
	private ErpResponseHead head;
	private CategorySyncRespBody body;
	
	public ErpCategorySyncRespData() {
		super();
	}
	
	public ErpCategorySyncRespData(ErpResponseHead head,
			CategorySyncRespBody body) {
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

	public CategorySyncRespBody getBody() {
		return body;
	}

	public void setBody(CategorySyncRespBody body) {
		this.body = body;
	}


	//应答报文体
	@XmlAccessorType(XmlAccessType.FIELD)
	@XmlType
	public static class CategorySyncRespBody{
		@XmlElementWrapper(name="datalist")
		@XmlElement(name="data")
		@Mapping("resultList")
		private List<CategorySyncRespData> dataList;

		public CategorySyncRespBody() {
			super();
		}

		public CategorySyncRespBody(List<CategorySyncRespData> dataList) {
			super();
			this.dataList = dataList;
		}

		public List<CategorySyncRespData> getDataList() {
			return dataList;
		}

		public void setDataList(List<CategorySyncRespData> dataList) {
			this.dataList = dataList;
		}
		
		
	}
	//应答明细(在部分失败的情况下才会有数据)
	@XmlAccessorType(XmlAccessType.FIELD)
	@XmlType
	public static class CategorySyncRespData{
		@Mapping("categoryCode")
		private String category_code;
		@Mapping("errorCode")
		private String error_code;
		@Mapping("errorMsg")
		private String error_msg;
		public CategorySyncRespData() {
			super();
		}
		public CategorySyncRespData(String category_code, String error_code,
				String error_msg) {
			super();
			this.category_code = category_code;
			this.error_code = error_code;
			this.error_msg = error_msg;
		}
		public String getCategory_code() {
			return category_code;
		}
		public void setCategory_code(String category_code) {
			this.category_code = category_code;
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
