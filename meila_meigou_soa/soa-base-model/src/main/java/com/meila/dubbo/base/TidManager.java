package com.meila.dubbo.base;

import java.util.UUID;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.MDC;

/**
 ************************************************************
 * @类名 : TidManager.java
 *
 * @DESCRIPTION : tid管理工具类
 * @AUTHOR : hawk
 * @DATE : 2016年1月15日
 ************************************************************
 */
public class TidManager {
    private static final ThreadLocal<String> TIDTREAD_LOCAL = new ThreadLocal<String>();
    private static final ThreadLocal<Long> threadExecuteTimestamp = new ThreadLocal<Long>();
    private static final ThreadLocal<String> FROM_LOCAL = new ThreadLocal<String>();

    private static final String MDC_TID = "TID";
    private static final String MDC_FROM = "SOURCEFROM";

    /**
     * 设置TID
     * 
     * @param str
     */
    public static void setTid(String str) {
        TIDTREAD_LOCAL.set(str);
        MDC.put(MDC_TID, str);
    }

    /**
     * 获取TID
     * 
     * @return
     */
    public static String getTid() {
        String tid = TIDTREAD_LOCAL.get();
        // 当tid为空时，则生成一个tid
        if (StringUtils.isEmpty(tid)) {
            tid = UUID.randomUUID().toString().replace("-", "");
            setTid(tid);
        }
        return tid;
    }

    public static void setSourceFrom(String sourceFrom) {
        FROM_LOCAL.set(sourceFrom);
        MDC.put(MDC_FROM, sourceFrom);
    }

    public static String getSourceFrom() {
        return FROM_LOCAL.get();
    }

    public static void setTime(Long timestamp) {
        threadExecuteTimestamp.set(timestamp);
    }

    public static Long getTime() {
        return threadExecuteTimestamp.get();
    }

    public static void clear() {
        TIDTREAD_LOCAL.remove();
        threadExecuteTimestamp.remove();
        FROM_LOCAL.remove();
        MDC.remove(MDC_TID);
        MDC.remove(MDC_FROM);
    }
}
