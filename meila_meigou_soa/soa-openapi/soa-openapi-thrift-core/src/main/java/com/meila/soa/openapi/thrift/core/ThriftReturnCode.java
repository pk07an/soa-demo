/**
 * 
 */
package com.meila.soa.openapi.thrift.core;

import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;

/**
 ************************************************************
 * @类名 : ThriftReturnCode.java
 *
 * @DESCRIPTION :
 * @AUTHOR : flong
 * @DATE : 2016年2月1日
 ************************************************************
 */
public class ThriftReturnCode {
    /**
     * 成功
     */
    public static final int SUCCESS = 0;

    /**
     * 参数格式错误
     */
    public static final int INVALID_PARAMS = 1;

    /**
     * 系统异常
     */
    public static final int FAILED = 9;

    public static String getConstraintViolationException(Throwable throwable) {
        StringBuffer sb = new StringBuffer();
        ConstraintViolationException constraintViolations = (ConstraintViolationException) throwable; // 里面嵌了一个ConstraintViolationException
        Set<ConstraintViolation<?>> violations = constraintViolations.getConstraintViolations();
        for (ConstraintViolation<?> temp : violations) {
            sb.append(temp.getInvalidValue());
            sb.append(":");
            sb.append(temp.getMessage());
            sb.append(",");
        }
        return sb.toString();
    }
}
