package erp;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import junit.framework.TestCase;

import org.apache.cxf.endpoint.Client;
import org.apache.cxf.jaxws.endpoint.dynamic.JaxWsDynamicClientFactory;
import org.junit.Test;

import com.meila.soa.proxy.model.erp.ErpCategorySyncRequestData;
import com.meila.soa.proxy.model.erp.ErpInventorySyncReqData;
import com.meila.soa.proxy.model.erp.ErpRequestHead;
import com.meila.soa.proxy.model.erp.ErpSkuSyncRequestData;
import com.meila.soa.proxy.utils.AesUtils;
import com.meila.soa.proxy.utils.XMLUtils;

public class SynProductTestCase extends TestCase {

	@Test
	public void testErpCategorySync() {
		ErpCategorySyncRequestData requestData = generateErpCategorySyncRequestData();
		String xmlStr = "";
		try {
			xmlStr = XMLUtils.convertToXml(requestData);

		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("生成xml失败");
		}

		String response = sendToWebService(xmlStr);
		System.out.println(response);
	}

	@Test
	public void testErpInventorySync(){
		ErpInventorySyncReqData requestData = generateErpInventorySyncReqData();
		String xmlStr = "";
		try {
			xmlStr = XMLUtils.convertToXml(requestData);

		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("生成xml失败");
		}

		String response = sendToWebService(xmlStr);
		System.out.println(response);
	}
	public static ErpCategorySyncRequestData generateErpCategorySyncRequestData() {
		ErpCategorySyncRequestData data = new ErpCategorySyncRequestData();
		ErpRequestHead head = new ErpRequestHead();
		head.setBatch_no("20160121000001");
		head.setOp_type("CATEGORY_SYNC");
		head.setSend_time(new Date());
		data.setHead(head);
		ErpCategorySyncRequestData.CategorySyncReqBody body = new ErpCategorySyncRequestData.CategorySyncReqBody();
		List<ErpCategorySyncRequestData.CategorySyncReqData> dataList = new ArrayList<>();

		ErpCategorySyncRequestData.CategorySyncReqData data1 = new ErpCategorySyncRequestData.CategorySyncReqData();
		data1.setCategory_code("1.001.001");
		data1.setCategory_name("面膜");
		data1.setParent_code("1.001");
		dataList.add(data1);

		ErpCategorySyncRequestData.CategorySyncReqData data2 = new ErpCategorySyncRequestData.CategorySyncReqData();
		data2.setCategory_code("1.001.002");
		data2.setCategory_name("护手霜");
		data2.setParent_code("1.001");
		dataList.add(data2);

		ErpCategorySyncRequestData.CategorySyncReqData data3 = new ErpCategorySyncRequestData.CategorySyncReqData();
		data3.setCategory_code("1.001.003");
		data3.setCategory_name("保湿霜");
		data3.setParent_code("1.001");
		dataList.add(data3);

		body.setDataList(dataList);
		data.setBody(body);
		return data;
	}

	private ErpInventorySyncReqData generateErpInventorySyncReqData() {
		ErpInventorySyncReqData reqData = new ErpInventorySyncReqData();

		ErpRequestHead head = new ErpRequestHead();
		head.setBatch_no("20160121000001");
		head.setOp_type("INVENTORY_SYNC");
		head.setSend_time(new Date());
		reqData.setHead(head);

		ErpInventorySyncReqData.InventorySyncReqBody body = new ErpInventorySyncReqData.InventorySyncReqBody();
		List<ErpInventorySyncReqData.InventorySyncReqData> dataList = new ArrayList<>();
		
		ErpInventorySyncReqData.InventorySyncReqData data1 = new ErpInventorySyncReqData.InventorySyncReqData();
		data1.setErp_batch_no("20160121001");
		data1.setErp_sku_id("erp_0001");
		data1.setReal_amount(10);
		data1.setWarehouse("WH01");	
		dataList.add(data1);
		
		ErpInventorySyncReqData.InventorySyncReqData data2 = new ErpInventorySyncReqData.InventorySyncReqData();
		data2.setErp_batch_no("20160121001");
		data2.setErp_sku_id("erp_0002");
		data2.setReal_amount(20);
		data2.setWarehouse("WH01");
		dataList.add(data2);
		
		body.setDataList(dataList);
		reqData.setBody(body);
		return reqData;
	}

	private String sendToWebService(String xmlData) {
		try {
			JaxWsDynamicClientFactory factory = JaxWsDynamicClientFactory
					.newInstance();
			Client client = factory
					.createClient("http://localhost:8080/proxy/ws/erpws/erpRequestService?wsdl");
			Object[] objs = client.invoke("erpRequestDeal", AesUtils
					.aesEncryptAndBase64(xmlData, "1234567812345678", "utf-8"));

			if (objs[0] != null) {
				String response = objs[0].toString();
				String deString = AesUtils.aesBase64Decrypt(response,
						"1234567812345678", "utf-8");
				return deString;
			}
		} catch (Exception e) {
			System.out.println("调用webservice失败:" + e);
		}
		return null;
	}

	private static String generateSkuSyncRequstString() {
		ErpSkuSyncRequestData data = new ErpSkuSyncRequestData();
		ErpRequestHead head = new ErpRequestHead();
		ErpSkuSyncRequestData.Body body = new ErpSkuSyncRequestData.Body();
		List<ErpSkuSyncRequestData.Data> detailDataList = new ArrayList<>();

		head.setBatch_no("2016011800001");
		head.setOp_type("SKU_SYNC");
		head.setSend_time(new Date());
		data.setHead(head);

		ErpSkuSyncRequestData.Data detail1 = new ErpSkuSyncRequestData.Data();
		detail1.setErp_sku_id("erp_00001");
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
		detail1.setBrand_name_en("dior");
		detail1.setBelong_account("10000000");
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
		detail2.setErp_sku_id("erp_00002");
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
		detail2.setBrand_name_en("testBrand");
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

		try {
			return XMLUtils.convertToXml(data);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return "";
		}
	}
}
