/**
 * 
 */
package erp;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import junit.framework.TestCase;

import org.apache.cxf.endpoint.Client;
import org.apache.cxf.jaxws.endpoint.dynamic.JaxWsDynamicClientFactory;
import org.junit.Test;

import com.meila.soa.proxy.model.erp.BaseErpRequest;
import com.meila.soa.proxy.model.erp.ErpPurchaseNoteSyncRequestData;
import com.meila.soa.proxy.model.erp.ErpPurchaseStoreResultReqData;
import com.meila.soa.proxy.model.erp.ErpPurchaseStoreResultRespData;
import com.meila.soa.proxy.model.erp.ErpRequestHead;
import com.meila.soa.proxy.utils.AesUtils;
import com.meila.soa.proxy.utils.XMLUtils;

/**
 ************************************************************
 * @类名 : ErpPurchaseNoteTestCase.java
 *
 * @DESCRIPTION :
 * @AUTHOR : meila-x
 * @DATE : 2016年1月19日
 ************************************************************
 */
public class ErpPurchaseNoteTestCase extends TestCase {

	@Test
	public void testPropertiesCopy() {
		ErpPurchaseNoteSyncRequestData data = generateData();
		String reqXml = "";
		try {
			reqXml = XMLUtils.convertToXml(data);

		} catch (Exception e) {
			System.out.println("生成xml失败");
		}
		try {
			JaxWsDynamicClientFactory factory = JaxWsDynamicClientFactory
					.newInstance();
			Client client = factory
					.createClient("http://localhost:8080/proxy/ws/erpws/erpRequestService?wsdl");
			Object[] objs = client.invoke("erpRequestDeal", AesUtils
					.aesEncryptAndBase64(reqXml, "1234567812345678", "utf-8"));

			if (objs[0] != null) {
				String response = objs[0].toString();
				String deString = AesUtils.aesBase64Decrypt(response,
						"1234567812345678", "utf-8");
				System.out.println("应答数据:" + deString);
			}
		} catch (Exception e) {
			System.out.println("调用webservice失败:" + e);
		}

	}

	@Test
	public void testPurchaseNoteInstoreSync() {
		BaseErpRequest request = generateBaseErpRequest();
		String reqXml = "";
		try {
			reqXml = XMLUtils.convertToXml(request);
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("生成xml失败");
		}
		String response = sendToWebService(reqXml);
		System.out.println(response);
	}

	//采购单入库结果回传
	@Test
	public void testPurchaseNoteStorageResult(){
		ErpPurchaseStoreResultReqData req = generateErpPurchaseStoreResultReqData();
		String reqXml = "";
		try {
			reqXml = XMLUtils.convertToXml(req);
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("生成xml失败");
		}
		String response = sendToWebService(reqXml);
		System.out.println(response);
	}
	/**
	 * 
	 *
	 * 功能描述：创建erp采购单结果回传的请求对象
	 * 
	 * @return ErpPurchaseStoreResultReqData
	 *
	 */
	private ErpPurchaseStoreResultReqData generateErpPurchaseStoreResultReqData() {
		ErpPurchaseStoreResultReqData reqData = new ErpPurchaseStoreResultReqData();
		ErpRequestHead head = new ErpRequestHead();
		head.setBatch_no("2016012000002");
		head.setOp_type("PO_INSTORE_RETURN");
		head.setSend_time(new Date());
		reqData.setHead(head);

		ErpPurchaseStoreResultReqData.PurchaseStoreResultBody body = new ErpPurchaseStoreResultReqData.PurchaseStoreResultBody();
		List<ErpPurchaseStoreResultReqData.PurchaseStoreResultData>datas = new ArrayList<>();
		
		ErpPurchaseStoreResultReqData.PurchaseStoreResultData data1 = new ErpPurchaseStoreResultReqData.PurchaseStoreResultData();
		data1.setPurchase_code("POORD000001");
		data1.setSupplier_name("供应商1");
		datas.add(data1);
		
		ErpPurchaseStoreResultReqData.PurchaseStoreResultData data2 = new ErpPurchaseStoreResultReqData.PurchaseStoreResultData();
		data2.setPurchase_code("POORD000002");
		data2.setSupplier_name("供应商2");
		datas.add(data2);
		
		ErpPurchaseStoreResultReqData.PurchaseStoreResultData data3 = new ErpPurchaseStoreResultReqData.PurchaseStoreResultData();
		data3.setPurchase_code("POORD000003");
		data3.setSupplier_name("供应商3");
		datas.add(data3);
		
		ErpPurchaseStoreResultReqData.PurchaseStoreResultData data4 = new ErpPurchaseStoreResultReqData.PurchaseStoreResultData();
		data4.setPurchase_code("POORD000006");
		data4.setSupplier_name("供应商4");
		datas.add(data4);
		
		body.setDataList(datas);
		reqData.setBody(body);
		return reqData;
	}

	private BaseErpRequest generateBaseErpRequest() {
		BaseErpRequest request = new BaseErpRequest();
		ErpRequestHead head = new ErpRequestHead();
		head.setOp_type("PO_INSTORE");
		head.setBatch_no("20160120000001");
		head.setSend_time(new Date());
		request.setHead(head);
		return request;
	}

	/**
	 * 
	 *
	 * 功能描述：构造请求数据
	 * 
	 * @return ErpPurchaseNoteSyncRequestData
	 *
	 */
	public ErpPurchaseNoteSyncRequestData generateData() {
		ErpPurchaseNoteSyncRequestData requestData = new ErpPurchaseNoteSyncRequestData();
		ErpPurchaseNoteSyncRequestData.PurchaseBody body = new ErpPurchaseNoteSyncRequestData.PurchaseBody();
		ErpRequestHead head = new ErpRequestHead();

		head.setBatch_no("2016011800001");
		head.setOp_type("PO_SYNC");
		head.setSend_time(new Date());
		requestData.setHead(head);

		List<ErpPurchaseNoteSyncRequestData.PurchaseDataItem> dataList = new ArrayList<>();

		ErpPurchaseNoteSyncRequestData.PurchaseDataItem data1 = new ErpPurchaseNoteSyncRequestData.PurchaseDataItem();
		List<ErpPurchaseNoteSyncRequestData.SkuItem> itemList1 = new ArrayList<>();
		data1.setSupplier_name("采购单同步测试供应商1");
		data1.setPurchase_code("po_0000001");
		data1.setDefault_warehouse("WH01");
		data1.setWarehouse_address("广东深圳西丽");
		data1.setApply_time(new Date());

		ErpPurchaseNoteSyncRequestData.SkuItem item1 = new ErpPurchaseNoteSyncRequestData.SkuItem();
		item1.setErp_sku_id("erp_000001");
		item1.setSku_str("颜色:红色,尺码:43");
		item1.setErp_sku_code("erp_code_00001");
		item1.setErp_sku_name("采购单测试sku1");
		item1.setPurchase_amount(10);
		item1.setExpecte_time(new Date());
		itemList1.add(item1);

		ErpPurchaseNoteSyncRequestData.SkuItem item2 = new ErpPurchaseNoteSyncRequestData.SkuItem();
		item2.setErp_sku_id("erp_000002");
		item2.setSku_str("颜色:红色,尺码:43");
		item2.setErp_sku_code("erp_code_00002");
		item2.setErp_sku_name("采购单测试sku2");
		item2.setPurchase_amount(12);
		item2.setExpecte_time(new Date());
		itemList1.add(item2);

		data1.setItemList(itemList1);
		dataList.add(data1);

		ErpPurchaseNoteSyncRequestData.PurchaseDataItem data2 = new ErpPurchaseNoteSyncRequestData.PurchaseDataItem();
		List<ErpPurchaseNoteSyncRequestData.SkuItem> itemList2 = new ArrayList<>();
		data2.setSupplier_name("采购单同步测试供应商2");
		data2.setPurchase_code("po_0000002");
		data2.setDefault_warehouse("WH01");
		data2.setWarehouse_address("广东深圳西丽");
		data2.setApply_time(new Date());

		ErpPurchaseNoteSyncRequestData.SkuItem item21 = new ErpPurchaseNoteSyncRequestData.SkuItem();
		item21.setErp_sku_id("erp_000001");
		item21.setSku_str("颜色:红色,尺码:43");
		item21.setErp_sku_code("erp_code_00001");
		item21.setErp_sku_name("采购单测试sku1");
		item21.setPurchase_amount(20);
		item21.setExpecte_time(new Date());
		itemList2.add(item21);

		ErpPurchaseNoteSyncRequestData.SkuItem item22 = new ErpPurchaseNoteSyncRequestData.SkuItem();
		item22.setErp_sku_id("erp_000002");
		item22.setSku_str("颜色:红色,尺码:43");
		item22.setErp_sku_code("erp_code_00002");
		item22.setErp_sku_name("采购单测试sku2");
		item22.setPurchase_amount(22);
		item22.setExpecte_time(new Date());
		itemList2.add(item22);

		data2.setItemList(itemList2);
		dataList.add(data2);

		body.setDataList(dataList);
		requestData.setBody(body);
		return requestData;
	}

	public String sendToWebService(String xmlData) {
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
}
