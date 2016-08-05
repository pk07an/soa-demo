/**
 * 
 */
package erp;

import org.apache.cxf.endpoint.Client;
import org.apache.cxf.jaxws.endpoint.dynamic.JaxWsDynamicClientFactory;

import com.meila.soa.proxy.utils.AesUtils;

/**
 ************************************************************
 * @类名 : DubboUtils.java
 *
 * @DESCRIPTION : 
 * @AUTHOR :  meila-x
 * @DATE :  2016年1月25日
 ************************************************************
 */
public class DubboUtils {
	public static String sendToWebService(String xmlData) {
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
