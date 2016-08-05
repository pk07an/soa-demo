/**
 * 
 */
package com.meila.soa.proxy.service.aspect;

import java.util.UUID;

import org.aopalliance.intercept.Joinpoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.meila.dubbo.base.TidManager;

/**
 ************************************************************
 * @类名 : ProxyRequestAspect.java
 *
 * @DESCRIPTION : 代理层
 * @AUTHOR :  meila-x
 * @DATE :  2016年2月26日
 ************************************************************
 */
@Aspect
@Component
public class ProxyRequestAspect {
	private final Logger logger = LoggerFactory.getLogger(getClass());
	
	@Pointcut(value="execution(* com.meila.soa.proxy.service.impl.erp.ErpRequestImpl.erpRequestDeal(..))")
	public void pointCut(){
		
	}
	@Before("pointCut()")
	public void before(Joinpoint joinPoint){
		TidManager.setTid(UUID.randomUUID().toString().replaceAll("-", ""));
		logger.info("代理层erp请求开始....tid={}",TidManager.getTid());
	}
	
	@AfterReturning(value="pointCut()",returning="retval")
	public void afterReturning(Joinpoint jointPoint,Object retval){
		logger.info("代理层执行完毕.");
		TidManager.clear();
	}
	@AfterThrowing(value="pointCut()",throwing="ex")
	public void afterThrowing(Joinpoint joinPoint,Throwable ex){
		logger.info("代理层执行出现异常:",ex);
		TidManager.clear();
	}
}
