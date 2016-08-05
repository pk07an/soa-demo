package com.meila.common.bean;

import java.io.Serializable;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

/**
 * 
 ************************************************************
 * @类名 : BasicSeriModel.java
 *
 * @DESCRIPTION : 基础实体类，继承该类的实体类不用重写toString方法
 * @AUTHOR : hawk
 * @DATE : 2016年1月14日
 ************************************************************
 */
public class BasicSeriModel implements Serializable {
    private static final long serialVersionUID = 1L;

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this, ToStringStyle.DEFAULT_STYLE);
    }
}
