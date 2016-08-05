package com.meila.common.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 ************************************************************
 * @类名 : CheckPermission.java
 *
 * @DESCRIPTION :注解，用来标示是否需要校验权限
 * @AUTHOR : hawk
 * @DATE : 2016年1月20日
 ************************************************************
 */
@Target({ ElementType.METHOD })
@Retention(RetentionPolicy.RUNTIME)
public @interface CheckPermission {
    String[]value();
}
