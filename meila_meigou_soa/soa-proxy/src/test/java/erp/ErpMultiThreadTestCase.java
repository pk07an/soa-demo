/**
 * 
 */
package erp;

import org.junit.Test;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import com.meila.soa.proxy.model.erp.ErpCategorySyncRequestData;
import com.meila.soa.proxy.utils.XMLUtils;

import junit.framework.TestCase;

/**
 ************************************************************
 * @类名 : ErpMultiThreadTestCase.java
 *
 * @DESCRIPTION : 多线程发布商品到oms
 * @AUTHOR :  abner
 * @DATE :  2016年1月29日
 ************************************************************
 */
public class ErpMultiThreadTestCase extends TestCase {

	@Test
	public void testProductSync(){
		ThreadPoolTaskExecutor threadPoolTaskExecutor = new ThreadPoolTaskExecutor();
		threadPoolTaskExecutor.setCorePoolSize(10);
		threadPoolTaskExecutor.setMaxPoolSize(100);
		threadPoolTaskExecutor.setQueueCapacity(100);
		threadPoolTaskExecutor.setKeepAliveSeconds(300);
		threadPoolTaskExecutor.initialize();
		//threadPoolTaskExecutor.setRejectedExecutionHandler(CallerRunsPolicy);
		final ErpCategorySyncRequestData data = SynProductTestCase.generateErpCategorySyncRequestData();
		for(int i=0 ; i <= 50 ;i++){
			System.out.println("第"+i+"次运行");
			threadPoolTaskExecutor.execute(new Runnable() {
				
				@Override
				public void run() {
					String xmlStr = "";
					try {
						xmlStr = XMLUtils.convertToXml(data);

					} catch (Exception e) {
						e.printStackTrace();
						System.out.println("生成xml失败");
					}

					String response = DubboUtils.sendToWebService(xmlStr);
					System.out.println(response);
				}
			});
		}
		
		try {
			Thread.sleep(100000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("运行完成!");
	}
}
