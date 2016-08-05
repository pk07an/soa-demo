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

import com.meila.soa.proxy.utils.JaxbDateSerializer;

/**
 * 
 ************************************************************
 * @类名 : ErpSkuSyncRequestData.java
 *
 * @DESCRIPTION : erp商品同步请求对象
 * @AUTHOR :  abner
 * @DATE :  2016年1月7日
 ************************************************************
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType
@XmlRootElement(name="xmldata")
public class ErpSkuSyncRequestData  {
    
    @XmlElement(name="head")
    private ErpRequestHead head;

    @XmlElement(name="body")
    private Body body;
    
    public Body getBody() {
        return body;
    }
    public void setBody(Body body) {
        this.body = body;
    }
    
    public ErpRequestHead getHead() {
        return head;
    }
    public void setHead(ErpRequestHead head) {
        this.head = head;
    }

    //存放body节点
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType
    public static class Body{
        @XmlElementWrapper(name="datalist")
        @XmlElement(name="data")
        private List<Data> dataList;

        public Body(){}
        public Body(List<Data> dataList) {
            super();
            this.dataList = dataList;
        }
        public List<Data> getDataList() {
            return dataList;
        }
        public void setDataList(List<Data> dataList) {
            this.dataList = dataList;
        }
        
    }  
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType
    public static class Data{
        private String erp_sku_id      ;
        private String erp_sku_code    ;
        private String sku_name_cn     ;
        private String sku_name_en     ;
        private String belong_account  ;
        private String sku_str         ;
        @XmlJavaTypeAdapter(JaxbDateSerializer.class)
        private Date sync_time       ;
        private BigDecimal sale_price      ;
        private String sku_bar_code    ;
        private String purchase_place  ;
        private String production_place;
        private String brand_name_cn   ;
        private String brand_name_en   ;
        private String spec1_name      ;
        private String spec1_value     ;
        private String spec2_name      ;
        private String spec2_value     ;
        private String spec3_name      ;
        private String spec3_value     ;
        private String spec4_name      ;
        private String spec4_value     ;
        private String spec5_name      ;
        private String spec5_value     ;
        private String category_code   ;
        private String warehouse_code;
        private String unit_name;
        private int archive         ;
        
        public Data(){}

        public Data(String erp_sku_id, String erp_sku_code, String sku_name_cn,
				String sku_name_en, String belong_account, String sku_str,
				Date sync_time, BigDecimal sale_price, String sku_bar_code,
				String purchase_place, String production_place,
				String brand_name_cn, String brand_name_en, String spec1_name,
				String spec1_value, String spec2_name, String spec2_value,
				String spec3_name, String spec3_value, String spec4_name,
				String spec4_value, String spec5_name, String spec5_value,
				String category_code, String warehouse_code, String unit_name,
				int archive) {
			super();
			this.erp_sku_id = erp_sku_id;
			this.erp_sku_code = erp_sku_code;
			this.sku_name_cn = sku_name_cn;
			this.sku_name_en = sku_name_en;
			this.belong_account = belong_account;
			this.sku_str = sku_str;
			this.sync_time = sync_time;
			this.sale_price = sale_price;
			this.sku_bar_code = sku_bar_code;
			this.purchase_place = purchase_place;
			this.production_place = production_place;
			this.brand_name_cn = brand_name_cn;
			this.brand_name_en = brand_name_en;
			this.spec1_name = spec1_name;
			this.spec1_value = spec1_value;
			this.spec2_name = spec2_name;
			this.spec2_value = spec2_value;
			this.spec3_name = spec3_name;
			this.spec3_value = spec3_value;
			this.spec4_name = spec4_name;
			this.spec4_value = spec4_value;
			this.spec5_name = spec5_name;
			this.spec5_value = spec5_value;
			this.category_code = category_code;
			this.warehouse_code = warehouse_code;
			this.unit_name = unit_name;
			this.archive = archive;
		}



		public String getErp_sku_id() {
            return erp_sku_id;
        }

        public void setErp_sku_id(String erp_sku_id) {
            this.erp_sku_id = erp_sku_id;
        }

        public String getErp_sku_code() {
            return erp_sku_code;
        }

        public void setErp_sku_code(String erp_sku_code) {
            this.erp_sku_code = erp_sku_code;
        }

        public String getSku_name_cn() {
            return sku_name_cn;
        }

        public void setSku_name_cn(String sku_name_cn) {
            this.sku_name_cn = sku_name_cn;
        }

        public String getSku_name_en() {
            return sku_name_en;
        }

        public void setSku_name_en(String sku_name_en) {
            this.sku_name_en = sku_name_en;
        }

        public String getBelong_account() {
            return belong_account;
        }

        public void setBelong_account(String belong_account) {
            this.belong_account = belong_account;
        }

        public String getSku_str() {
            return sku_str;
        }

        public void setSku_str(String sku_str) {
            this.sku_str = sku_str;
        }

        public Date getSync_time() {
            return sync_time;
        }

        public void setSync_time(Date sync_time) {
            this.sync_time = sync_time;
        }

        public BigDecimal getSale_price() {
            return sale_price;
        }

        public void setSale_price(BigDecimal sale_price) {
            this.sale_price = sale_price;
        }

        public String getSku_bar_code() {
            return sku_bar_code;
        }

        public void setSku_bar_code(String sku_bar_code) {
            this.sku_bar_code = sku_bar_code;
        }

        public String getPurchase_place() {
            return purchase_place;
        }

        public void setPurchase_place(String purchase_place) {
            this.purchase_place = purchase_place;
        }

        public String getProduction_place() {
            return production_place;
        }

        public void setProduction_place(String production_place) {
            this.production_place = production_place;
        }

        public String getBrand_name_cn() {
            return brand_name_cn;
        }

        public void setBrand_name_cn(String brand_name_cn) {
            this.brand_name_cn = brand_name_cn;
        }

        public String getBrand_name_en() {
            return brand_name_en;
        }

        public void setBrand_name_en(String brand_name_en) {
            this.brand_name_en = brand_name_en;
        }

        public String getSpec1_name() {
            return spec1_name;
        }

        public void setSpec1_name(String spec1_name) {
            this.spec1_name = spec1_name;
        }

        public String getSpec1_value() {
            return spec1_value;
        }

        public void setSpec1_value(String spec1_value) {
            this.spec1_value = spec1_value;
        }

        public String getSpec2_name() {
            return spec2_name;
        }

        public void setSpec2_name(String spec2_name) {
            this.spec2_name = spec2_name;
        }

        public String getSpec2_value() {
            return spec2_value;
        }

        public void setSpec2_value(String spec2_value) {
            this.spec2_value = spec2_value;
        }

        public String getSpec3_name() {
            return spec3_name;
        }

        public void setSpec3_name(String spec3_name) {
            this.spec3_name = spec3_name;
        }

        public String getSpec3_value() {
            return spec3_value;
        }

        public void setSpec3_value(String spec3_value) {
            this.spec3_value = spec3_value;
        }

        public String getSpec4_name() {
            return spec4_name;
        }

        public void setSpec4_name(String spec4_name) {
            this.spec4_name = spec4_name;
        }

        public String getSpec4_value() {
            return spec4_value;
        }

        public void setSpec4_value(String spec4_value) {
            this.spec4_value = spec4_value;
        }

        public String getSpec5_name() {
            return spec5_name;
        }

        public void setSpec5_name(String spec5_name) {
            this.spec5_name = spec5_name;
        }

        public String getSpec5_value() {
            return spec5_value;
        }

        public void setSpec5_value(String spec5_value) {
            this.spec5_value = spec5_value;
        }

        public String getCategory_code() {
            return category_code;
        }

        public void setCategory_code(String category_code) {
            this.category_code = category_code;
        }

        public String getWarehouse_code() {
			return warehouse_code;
		}

		public void setWarehouse_code(String warehouse_code) {
			this.warehouse_code = warehouse_code;
		}

		public String getUnit_name() {
			return unit_name;
		}

		public void setUnit_name(String unit_name) {
			this.unit_name = unit_name;
		}

		public int getArchive() {
            return archive;
        }

        public void setArchive(int archive) {
            this.archive = archive;
        }
        
        
    }
}

