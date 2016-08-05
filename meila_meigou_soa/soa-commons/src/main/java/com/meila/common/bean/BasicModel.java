/**   
* @Title: BaseModel.java 
* @Package com.pubpi.common.model 
* @Description: TODO(desc the file) 
* @author skyhawk wthuan@foxmail.com
* @date 2015年11月2日 下午4:00:21 
* @version V0.1
*/
package com.meila.common.bean;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

/**
 * 
 ************************************************************
 * @类名 : BasicModel.java
 *
 * @DESCRIPTION : 基础实体类，继承该类的实体类不用重写toString方法
 * @AUTHOR : hawk
 * @DATE : 2016年1月14日
 ************************************************************
 */
public class BasicModel {

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this, ToStringStyle.DEFAULT_STYLE);
    }
}
