/**
 * 
 */
package erp;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.Test;

import com.meila.soa.proxy.model.erp.BaseErpRequest;
import com.meila.soa.proxy.model.erp.ErpOrderPackageDeliveryResultReqData;
import com.meila.soa.proxy.model.erp.ErpRequestHead;
import com.meila.soa.proxy.utils.XMLUtils;

import junit.framework.TestCase;

/**
 ************************************************************
 * @类名 : ErpOrderPackageTestCase.java
 *
 * @DESCRIPTION : erp销售出库单测试用例
 * @AUTHOR :  abner
 * @DATE :  2016年1月25日
 ************************************************************
 */
public class ErpOrderPackageTestCase extends TestCase {
	
	/**
	 * 
	 *
	 * 功能描述：销售单同步
	 *  void
	 *
	 */
	public void testOrderPackageSync(){
		BaseErpRequest erpReq = generateBaseErpRequest();
		String reqXml = "";
		try {
			reqXml = XMLUtils.convertToXml(erpReq);
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("生成xml失败");
		}
		String response = DubboUtils.sendToWebService(reqXml);
		System.out.println(response);
	}
	
	@Test
	public void testOrderpackageSyncResult(){
		ErpOrderPackageDeliveryResultReqData erpReq = generateErpOrderPackageDeliveryResultReqData();
		String reqXml = "";
		try {
			reqXml = XMLUtils.convertToXml(erpReq);
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("生成xml失败");
		}
		String response = DubboUtils.sendToWebService(reqXml);
		System.out.println(response);
	}
	
	private BaseErpRequest generateBaseErpRequest() {
		BaseErpRequest request = new BaseErpRequest();
		ErpRequestHead head = new ErpRequestHead();
		head.setOp_type("ORDER_SYNC");
		head.setBatch_no("20160120000001");
		head.setSend_time(new Date());
		request.setHead(head);
		return request;
	}
	
	//构造销售出库单结果回传对象
	private ErpOrderPackageDeliveryResultReqData generateErpOrderPackageDeliveryResultReqData(){
		ErpOrderPackageDeliveryResultReqData reqData = new ErpOrderPackageDeliveryResultReqData();
		ErpRequestHead head = new ErpRequestHead();
		head.setOp_type("ORDER_SYNC_RETURN");
		head.setBatch_no("20160125000001");
		head.setSend_time(new Date());
		reqData.setHead(head);
		ErpOrderPackageDeliveryResultReqData.OrderpackageDeliveryReqBody body = 
					new ErpOrderPackageDeliveryResultReqData.OrderpackageDeliveryReqBody();
		
		List<ErpOrderPackageDeliveryResultReqData.OrderPackageDeliveryReqData> dataList=
					new ArrayList<>();
		
		ErpOrderPackageDeliveryResultReqData.OrderPackageDeliveryReqData data1 = 
					new ErpOrderPackageDeliveryResultReqData.OrderPackageDeliveryReqData();
		data1.setOrder_no("gogoOrderNo0");
		data1.setPackage_code("gogoCode0");
		dataList.add(data1);
		
		ErpOrderPackageDeliveryResultReqData.OrderPackageDeliveryReqData data2 = 
				new ErpOrderPackageDeliveryResultReqData.OrderPackageDeliveryReqData();
		data1.setOrder_no("gogoOrderNo1");
		data1.setPackage_code("gogoCode1");
		dataList.add(data2);
		
		ErpOrderPackageDeliveryResultReqData.OrderPackageDeliveryReqData data3 = 
				new ErpOrderPackageDeliveryResultReqData.OrderPackageDeliveryReqData();
		data1.setOrder_no("gogoOrderNo2");
		data1.setPackage_code("gogoCode2");
		dataList.add(data3);
		
		ErpOrderPackageDeliveryResultReqData.OrderPackageDeliveryReqData data4 = 
				new ErpOrderPackageDeliveryResultReqData.OrderPackageDeliveryReqData();
		data1.setOrder_no("gogoOrderNo3");
		data1.setPackage_code("gogoCode3");
		dataList.add(data4);
		
		ErpOrderPackageDeliveryResultReqData.OrderPackageDeliveryReqData data5 = 
				new ErpOrderPackageDeliveryResultReqData.OrderPackageDeliveryReqData();
		data1.setOrder_no("gogoOrderNo4");
		data1.setPackage_code("gogoCode4");
		dataList.add(data5);
		
		body.setDataList(dataList);
		reqData.setBody(body);
	
		return reqData;
	}
}
