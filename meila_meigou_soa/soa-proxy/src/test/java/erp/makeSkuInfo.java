package erp;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.meila.soa.proxy.model.erp.ErpRequestHead;
import com.meila.soa.proxy.model.erp.ErpSkuSyncRequestData;

public class makeSkuInfo {

	public static void main(String[] args) {
		ErpSkuSyncRequestData data = new ErpSkuSyncRequestData();
		ErpRequestHead head = new ErpRequestHead();
		ErpSkuSyncRequestData.Body body = new ErpSkuSyncRequestData.Body();
		List<ErpSkuSyncRequestData.Data> detailDataList = new ArrayList<>();
	
		head.setBatch_no("2016011800001");
		head.setOp_type("SKU_SYNC");
		head.setSend_time(new Date());
		data.setHead(head);
		
		ErpSkuSyncRequestData.Data detail1 = new ErpSkuSyncRequestData.Data();
		detail1.setErp_sku_code("erp_00001");
		detail1.setErp_sku_code("erp_code_0001");
		detail1.setSku_name_cn("erp测试商品1");
		detail1.setSku_name_en("erp test product 1");
		detail1.setBelong_account("10000001");
		detail1.setSku_str("颜色:红色,尺码:43");
		detail1.setSync_time(new Date());
		detail1.setSale_price(new BigDecimal("150.05"));
		detail1.setPurchase_place("香港");
		detail1.setProduction_place("法国");
		detail1.setBrand_name_cn("迪奥");
		detail1.setBelong_account("dior");
		detail1.setSpec1_name("spec_1_name");
		detail1.setSpec1_value("spec_value_1");
		detail1.setSpec2_name("spec_2_name");
		detail1.setSpec2_value("spec_value_2");
		detail1.setSpec3_name("spec_3_name");
		detail1.setSpec3_value("spec_value_3");
		detail1.setSpec4_name("spec_4_name");
		detail1.setSpec4_value("spec_value_4");
		detail1.setSpec5_name("spec_5_name");
		detail1.setSpec5_value("spec_value_5");
		detail1.setCategory_code("0001");
		detail1.setWarehouse_code("WH01");
		detail1.setUnit_name("瓶");
		detail1.setArchive(0);
		
		detailDataList.add(detail1);
		ErpSkuSyncRequestData.Data detail2 = new ErpSkuSyncRequestData.Data();
		detail2.setErp_sku_code("erp_00002");
		detail2.setErp_sku_code("erp_code_0002");
		detail2.setSku_name_cn("erp测试商品2");
		detail2.setSku_name_en("erp test product 2");
		detail2.setBelong_account("20000002");
		detail2.setSku_str("颜色:红色,尺码:43");
		detail2.setSync_time(new Date());
		detail2.setSale_price(new BigDecimal("250.05"));
		detail2.setPurchase_place("香港");
		detail2.setProduction_place("美国");
		detail2.setBrand_name_cn("测试品牌");
		detail2.setBelong_account("testBrand");
		detail2.setSpec1_name("spec_1_name");
		detail2.setSpec1_value("spec_value_1");
		detail2.setSpec2_name("spec_2_name");
		detail2.setSpec2_value("spec_value_2");
		detail2.setSpec3_name("spec_3_name");
		detail2.setSpec3_value("spec_value_3");
		detail2.setSpec4_name("spec_4_name");
		detail2.setSpec4_value("spec_value_4");
		detail2.setSpec5_name("spec_5_name");
		detail2.setSpec5_value("spec_value_5");
		detail2.setCategory_code("0002");
		detail2.setWarehouse_code("WH02");
		detail2.setUnit_name("件");
		detail2.setArchive(0);
		detailDataList.add(detail2);
		
		body.setDataList(detailDataList);
		
		data.setBody(body);
		
		
		
	}
}
