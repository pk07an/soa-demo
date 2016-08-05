package com.meila.soa.proxy.utils;

import java.util.Locale;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.MessageSourceResolvable;

/**
 *@Description:Spring上下文的工具类
 *@Author:marshall
 *@Since:2015年11月4日
 *@Version:1.1.0
 */
public class ApplicationContextUtil implements ApplicationContextAware {
    private static ApplicationContext applicationContext;

    public void setApplicationContext(ApplicationContext applicationContext) {
        ApplicationContextUtil.applicationContext = applicationContext;
    }

    public static String getMessage(String code, Object[] args, String defaultMessage, Locale locale) {
        return applicationContext.getMessage(code, args, defaultMessage, locale);
    }

    public static Object getBeanByName(String name) {
        return applicationContext.getBean(name);
    }
    /**
	 * 从静态变量ApplicationContext中取得Bean, 自动转型为所赋值对象的类型.
	 */
	@SuppressWarnings("unchecked")
	public static <T> T getBean(String name) {
		return (T) applicationContext.getBean(name);
	}

    public static String getMessage(String code, Object[] args, Locale locale) {
    	if(null != code){
    		code="000002";
    	}
        return applicationContext.getMessage(code, args, locale);
    }

    public static String getMessage(MessageSourceResolvable resolvable, Locale locale) {
        return applicationContext.getMessage(resolvable, locale);
    }
}
