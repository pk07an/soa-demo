package com.meila.soa.aspect;

import java.util.Arrays;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.alibaba.fastjson.JSON;
import com.meila.common.utils.StringUtils;
import com.meila.dubbo.base.TidManager;
import com.meila.dubbo.base.model.DubboBasicRequest;

/**
 ************************************************************
 * @类名 : DubboAspect.java
 *
 * @DESCRIPTION :对dubbo服务添加切面进行日志管理与logid管理
 * @AUTHOR : hawk
 * @DATE : 2016年2月2日
 ************************************************************
 */
@Aspect
@Component
public class DubboAspect {
    private static Logger logger = LoggerFactory.getLogger(DubboAspect.class);

    @Value("${dubbo.application.name}")
    private String appName;

    private final int maxReturnSize = 200;

    public DubboAspect() {
        logger.debug("dubbo aspect init");
    }

    @Pointcut("execution(* com.meila.soa.*.api.*.*(..))")
    public void methodCachePointcut() {
    }

    /**
     * 进行日志记录
     * 
     * @param joinPoint
     * @param requestMapping
     * @return
     * @throws Throwable
     */
    @Around("methodCachePointcut()")
    public Object around(ProceedingJoinPoint joinPoint) throws Throwable {
        TidManager.setTime(System.currentTimeMillis());
        // 当没有配置appName时，自动获取serviceName
        if (StringUtils.isEmpty(appName)) {
            String serviceName = joinPoint.getSignature().getDeclaringTypeName();
            if (serviceName.indexOf("$") != -1) {
                serviceName = serviceName.substring(0, serviceName.indexOf("$"));
            }
            int dotIdx = serviceName.lastIndexOf(".");
            if (dotIdx != -1) {
                serviceName = serviceName.substring(dotIdx + 1);
            }
            appName = serviceName;
        }
        long period = 0;
        String methodName = null;
        Object[] method_param = null;
        try {
            long startTime = System.currentTimeMillis();
            // 获取函数名称
            methodName = joinPoint.getSignature().getDeclaringTypeName() + "." + joinPoint.getSignature().getName();
            // 获取函数参数
            method_param = joinPoint.getArgs();
            // 设置tid
            if (method_param.length > 0 && method_param[0] instanceof DubboBasicRequest) {
                TidManager.setTid(((DubboBasicRequest) method_param[0]).getTid());
            }
            logger.info("app={}|logid={}|action=request|method={}|args={}", appName, TidManager.getTid(), methodName, Arrays.toString(method_param));

            Object object;
            // 调用方法
            object = joinPoint.proceed();

            long endTime = System.currentTimeMillis();
            period = endTime - startTime;
            String returnString = JSON.toJSONString(object);
            if (returnString.length() > maxReturnSize) {
                returnString = returnString.substring(0, maxReturnSize);
            }
            logger.info("app={}|logid={}|action=responseok|timestamp={}|method={}|args={}|result={}", appName, TidManager.getTid(), period,
                methodName, Arrays.toString(method_param), returnString);

            return object;
        } catch (Exception e) {
            logger.info("app={}|logid={}|action=responsefail|timestamp={}|method={}|args={}|result={}", appName, TidManager.getTid(), period,
                methodName, Arrays.toString(method_param), e.getMessage());
            throw e;
        } finally {
            TidManager.clear();
        }
    }
}
