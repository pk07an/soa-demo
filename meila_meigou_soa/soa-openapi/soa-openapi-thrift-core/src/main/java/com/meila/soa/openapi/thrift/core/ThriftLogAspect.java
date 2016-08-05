/**
 * 
 */
package com.meila.soa.openapi.thrift.core;

import java.util.Arrays;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.alibaba.fastjson.JSON;
import com.google.common.base.Strings;
import com.meila.dubbo.base.TidManager;

/**
 ************************************************************
 * @类名 : ThriftLogAspect.java
 *
 * @DESCRIPTION :日志搜集，现在的格式主要是考虑lagstash接入
 * @AUTHOR : flong
 * @DATE : 2016年1月28日
 ************************************************************
 */
@Component
@Aspect
public class ThriftLogAspect {
    private final Logger logger = LoggerFactory.getLogger(getClass());

    @Value("${thrift.application.name}")
    private String appName;

    private final int maxReturnSize = 200;

    // @Pointcut("execution(* com.meila.soa.openapi.thrift..*.*(..))")
    @Pointcut("execution(* com.meila.soa.openapi.thrift.*.impl.*ServiceImpl.*(..))")
    public void serviceImplPoint() {
    }

    @Before("serviceImplPoint()")
    public void logBefore(JoinPoint joinPoint) throws Throwable {
        // set tid
        TidManager.getTid();
        TidManager.setSourceFrom(appName);
        // 当没有配置appName时，自动获取serviceName
        if (Strings.isNullOrEmpty(appName)) {
            appName = getServiceName(joinPoint);
        }
        // get method
        String methodName = joinPoint.getSignature().getDeclaringTypeName() + "." + joinPoint.getSignature().getName();
        // get args
        Object[] args = joinPoint.getArgs();
        TidManager.setTime(System.currentTimeMillis());
        logger.info("app={}|action=request|method={}|args={}", appName, methodName, Arrays.toString(args));
    }

    @AfterReturning(value = "serviceImplPoint()", returning = "returnValue")
    public void logAfterReturning(JoinPoint joinPoint, Object returnValue) throws Throwable {
        // 当没有配置appName时，自动获取serviceName
        if (Strings.isNullOrEmpty(appName)) {
            appName = getServiceName(joinPoint);
        }
        // get method
        String methodName = joinPoint.getSignature().getDeclaringTypeName() + "." + joinPoint.getSignature().getName();
        // get args
        Object[] args = joinPoint.getArgs();
        // String returnString = ToStringBuilder.reflectionToString(returnValue, ToStringStyle.DEFAULT_STYLE);
        String returnString = JSON.toJSONString(returnValue);
        // 为防止日志输出过大，对报文进行截取
        if (returnString.length() > maxReturnSize) {
            returnString = returnString.substring(0, maxReturnSize);
        }
        long endTime = System.currentTimeMillis();
        long period = endTime - TidManager.getTime();
        logger.info("app={}|action=responseok|timestamp={}|method={}|args={}|result={}", appName, period, methodName, Arrays.toString(args),
            returnString);
        TidManager.clear();
    }

    @AfterThrowing(value = "serviceImplPoint()", throwing = "e")
    public void logAfterThrowing(JoinPoint joinPoint, Exception e) throws Throwable {
        // 当没有配置appName时，自动获取serviceName
        if (Strings.isNullOrEmpty(appName)) {
            appName = getServiceName(joinPoint);
        }
        // get method
        String methodName = joinPoint.getSignature().getDeclaringTypeName() + "." + joinPoint.getSignature().getName();
        // get args
        Object[] args = joinPoint.getArgs();
        long endTime = System.currentTimeMillis();
        long period = endTime - TidManager.getTime();
        logger.info("app={}|action=responsefail|timestamp={}|method={}|args={}|result={}", appName, period, methodName, Arrays.toString(args),
            e.getMessage());
        TidManager.clear();
    }

    private String getServiceName(JoinPoint joinPoint) {
        String serviceName = joinPoint.getSignature().getDeclaringTypeName();
        if (serviceName.indexOf("$") != -1) {
            serviceName = serviceName.substring(0, serviceName.indexOf("$"));
        }
        int dotIdx = serviceName.lastIndexOf(".");
        if (dotIdx != -1) {
            serviceName = serviceName.substring(dotIdx + 1);
        }
        return serviceName;
    }
}
