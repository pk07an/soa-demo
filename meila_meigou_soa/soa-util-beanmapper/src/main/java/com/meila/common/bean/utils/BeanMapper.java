/*******************************************************************************
 * Copyright (c) 2005, 2014 springside.github.io
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 *******************************************************************************/
package com.meila.common.bean.utils;

import java.beans.PropertyDescriptor;
import java.lang.reflect.Field;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import org.apache.commons.lang3.StringUtils;
import org.dozer.DozerBeanMapper;
import org.dozer.loader.api.BeanMappingBuilder;
import org.dozer.loader.api.FieldsMappingOptions;
import org.dozer.loader.api.TypeMappingBuilder;
import org.dozer.loader.api.TypeMappingOptions;
import org.dozer.util.ReflectionUtils;

import com.meila.common.bean.utils.annotaion.MappingField;

/**
 ************************************************************
 * @类名 : BeanMapper.java
 *
 * @DESCRIPTION : 实体类映射工具类，功能较为强大
 * @AUTHOR : hawk
 * @DATE : 2016年1月14日
 ************************************************************
 */
public class BeanMapper {

    private BeanMapper() {

    }

    /**
     * 为支持动态配置, 故而每一对class创建一个mapper实例使用
     */
    private static Map<String, DozerBeanMapper> dozerMap = new ConcurrentHashMap<String, DozerBeanMapper>();

    private static ThreadLocal<Map<String, String>> threadLocal2 = new ThreadLocal<Map<String, String>>();

    private static ThreadLocal<DozerBeanMapper> DozerBeanMapperThreadLocal = new ThreadLocal<DozerBeanMapper>();

    private static ThreadLocal<List<MapClass>> MapClassThreadLocal = new ThreadLocal<List<MapClass>>();

    /**
     * 基于Dozer转换对象的类型.
     */
    public static <T> T map(final Object srcObj, final Class<T> dstClass) {
        // 传入空则返回空
        if (null == srcObj) {
            return null;
        }

        final Class<? extends Object> srcClass = srcObj.getClass();

        generateMappingInfo(srcClass, dstClass);

        String mapId = generateKey(srcClass, dstClass);
        return dozerMap.get(mapId).map(srcObj, dstClass);
    }

    @SuppressWarnings("rawtypes")
    private static <T> String generateKey(final Class srcClass, final Class dstClass) {
        return srcClass.getName() + ":" + dstClass.getName();
    }

    /**
     * 基于Dozer转换Collection中对象的类型.
     */
    public static <T> List<T> map(Collection<?> srcObjList, Class<T> dstClass) {
        List<T> dstObjList = new ArrayList<T>();
        if (null == srcObjList) {
            return dstObjList;
        }
        for (Object srcObj : srcObjList) {
            T dstObj = map(srcObj, dstClass);
            dstObjList.add(dstObj);
        }
        return dstObjList;
    }

    /**
     * 基于Dozer将对象A的值拷贝到对象B中.
     */
    public static void copy(Object srcObj, Object dstObj) {
        generateMappingInfo(srcObj.getClass(), dstObj.getClass());
        String key = srcObj.getClass().getName() + ":" + dstObj.getClass().getName();
        dozerMap.get(key).map(srcObj, dstObj);
    }

    private static <T> void generateMappingInfo(final Class<? extends Object> srcClass, final Class<T> dstClass) {
        String key = generateKey(srcClass, dstClass);
        if (!dozerMap.containsKey(key)) {
            threadLocal2.set(new HashMap<String, String>());
            addMappingInfo(srcClass, dstClass);

            DozerBeanMapperThreadLocal.get().addMapping(new BeanMappingBuilder() {
                @Override
                protected void configure() {
                    List<MapClass> list = MapClassThreadLocal.get();

                    for (MapClass temp1 : list) {
                        TypeMappingBuilder mapping = mapping(temp1.getSrcClass(), temp1.getDstClass(), TypeMappingOptions.stopOnErrors(false),
                            TypeMappingOptions.dateFormat("yyyy-MM-dd HH:mm:ss"));
                        for (MapField temp : temp1.getMappedFieldList()) {
                            mapping.fields(temp.getSrcName(), temp.getDstName(), FieldsMappingOptions.oneWay());
                        }
                    }

                }
            });

            DozerBeanMapperThreadLocal.remove();
            MapClassThreadLocal.remove();
            threadLocal2.remove();

        }
    }

    private synchronized static <T> void addMappingInfo(final Class<? extends Object> srcClass, final Class<T> dstClass) {
        // 两次检查, 防止多次调用
        String key = srcClass.getName() + ":" + dstClass.getName();
        if (dozerMap.containsKey(key)) {
            return;
        }

        if (threadLocal2.get().containsKey(key)) {
            return;
        }
        threadLocal2.get().put(key, key);

        if (null == DozerBeanMapperThreadLocal.get()) {
            DozerBeanMapper dozerBeanMapper = new DozerBeanMapper();
            dozerMap.put(key, dozerBeanMapper);
            DozerBeanMapperThreadLocal.set(dozerBeanMapper);
        }

        if (null == MapClassThreadLocal.get()) {
            MapClassThreadLocal.set(new ArrayList<MapClass>());
        }

        // 如果两个class一样, 则不配置映射规则
        if (srcClass.equals(dstClass)) {
            return;
        }

        // 如果是基础类型,则不配置
        if (srcClass.isPrimitive() || dstClass.isPrimitive()) {
            return;
        }
        // 如果是枚举类,则不配置
        if (srcClass.isEnum() || dstClass.isEnum()) {
            return;
        }

        // 如果是字符串,则不配置
        if (String.class.isAssignableFrom(srcClass) || String.class.isAssignableFrom(dstClass)) {
            return;
        }
        // 如果是数字,则不配置
        if (Number.class.isAssignableFrom(srcClass) || Number.class.isAssignableFrom(dstClass)) {
            return;
        }
        // 如果是字符,则不配置
        if (Character.class.isAssignableFrom(srcClass) || Character.class.isAssignableFrom(dstClass)) {
            return;
        }
        // 如何使布尔值, 则不配置
        if (Boolean.class.isAssignableFrom(srcClass) || Boolean.class.isAssignableFrom(dstClass)) {
            return;
        }
        // 如果是日期,则不配置
        if (Date.class.isAssignableFrom(srcClass) || Date.class.isAssignableFrom(dstClass)) {
            return;
        }

        List<Field> srcFields = getFields(srcClass);
        if (null == srcFields || srcFields.size() == 0) {
            return;
        }
        Map<String, Field> srcFieldsMap = new HashMap<String, Field>();
        for (Field temp : srcFields) {
            srcFieldsMap.put(temp.getName(), temp);
        }

        List<Field> dstFields = getFields(dstClass);
        if (null == dstFields || dstFields.size() == 0) {
            return;
        }

        Map<String, Field> dstFieldsMap = new HashMap<String, Field>();
        for (Field temp : dstFields) {
            dstFieldsMap.put(temp.getName(), temp);
        }

        final List<MapField> mapFieldList = new ArrayList<MapField>();

        for (Field tempSrcField : srcFields) {
            String srcFieldName = null;
            String dstFieldName = null;
            final MappingField srcAnnotation = tempSrcField.getAnnotation(MappingField.class);

            for (Field tempDstField : dstFields) {
                MappingField dstAnnotation = tempDstField.getAnnotation(MappingField.class);
                if (!StringUtils.isEmpty(srcFieldName)) {
                    break;
                }
                if (null != dstAnnotation) {
                    final String[] annoValueArr = dstAnnotation.value();
                    for (String annoValue : annoValueArr) {
                        if (tempSrcField.getName().equals(annoValue)) {
                            srcFieldName = tempSrcField.getName();
                            dstFieldName = tempDstField.getName();
                            break;
                        }
                    }
                }
            }

            if (null != srcAnnotation) {
                final String[] annoValueArr = srcAnnotation.value();
                for (String annoValue : annoValueArr) {
                    if (dstFieldsMap.containsKey(annoValue)) {
                        srcFieldName = tempSrcField.getName();
                        dstFieldName = annoValue;
                        break;
                    }
                }
            }

            if (!StringUtils.isEmpty(srcFieldName)) {
                MapField temp = new MapField();
                temp.setSrcName(srcFieldName);
                temp.setDstName(dstFieldName);
                mapFieldList.add(temp);
            }

            if (StringUtils.isEmpty(srcFieldName)) {
                if (dstFieldsMap.containsKey(tempSrcField.getName())) {
                    srcFieldName = tempSrcField.getName();
                    dstFieldName = tempSrcField.getName();
                }
            }

            if (!StringUtils.isEmpty(srcFieldName)) {
                Field destField = dstFieldsMap.get(dstFieldName);
                mapField(tempSrcField, destField);
            }
        }

        MapClass mppedClass = new MapClass();

        mppedClass.setSrcClass(srcClass);
        mppedClass.setDstClass(dstClass);
        mppedClass.setMappedFieldList(mapFieldList);

        MapClassThreadLocal.get().add(mppedClass);

    }

    private static List<Field> getFields(final Class srcClass) {
        PropertyDescriptor[] propertyDescriptors = ReflectionUtils.getPropertyDescriptors(srcClass);
        int size = propertyDescriptors.length;
        List<Field> fieldList = new ArrayList<Field>();

        for (PropertyDescriptor temp : propertyDescriptors) {
            Field field = getField(srcClass, temp);
            if (null != field) {
                fieldList.add(field);
            }

        }

        return fieldList;

    }

    private static Field getField(final Class srcClass, PropertyDescriptor temp) {
        Field field = null;
        try {
            field = srcClass.getDeclaredField(temp.getName());
        } catch (NoSuchFieldException | SecurityException e) {
            Class superclass = srcClass.getSuperclass();
            if (null != superclass) {
                field = getField(superclass, temp);
            }
        }
        return field;
    }

    @SuppressWarnings("rawtypes")
    public static class MapClass {
        private Class srcClass;

        private Class dstClass;

        private List<MapField> mappedFieldList;

        public Class getSrcClass() {
            return srcClass;
        }

        public void setSrcClass(Class srcClass) {
            this.srcClass = srcClass;
        }

        public Class getDstClass() {
            return dstClass;
        }

        public void setDstClass(Class dstClass) {
            this.dstClass = dstClass;
        }

        public List<MapField> getMappedFieldList() {
            return mappedFieldList;
        }

        public void setMappedFieldList(List<MapField> mappedFieldList) {
            this.mappedFieldList = mappedFieldList;
        }
    }

    public static class MapField {
        private String srcName;

        private String dstName;

        /**
         * @return the srcName
         */
        public String getSrcName() {
            return srcName;
        }

        /**
         * @param srcName the srcName to set
         */
        public void setSrcName(String srcName) {
            this.srcName = srcName;
        }

        /**
         * @return the dstName
         */
        public String getDstName() {
            return dstName;
        }

        /**
         * @param dstName the dstName to set
         */
        public void setDstName(String dstName) {
            this.dstName = dstName;
        }

    }

    private static void mapField(Field srcField, Field dstField) {
        Type srcGenericType = srcField.getGenericType();
        Type dstGenericType = dstField.getGenericType();
        Class<?> srcCompentClass = srcField.getType();
        Class<?> dstComponentClass = dstField.getType();

        if (ParameterizedType.class.isAssignableFrom(srcGenericType.getClass()) || ParameterizedType.class.isAssignableFrom(dstGenericType.getClass())
                || srcCompentClass.isArray() || dstComponentClass.isArray()) {
            if (ParameterizedType.class.isAssignableFrom(srcGenericType.getClass())
                    && ParameterizedType.class.isAssignableFrom(dstGenericType.getClass())) {
                apping((ParameterizedType) srcGenericType, (ParameterizedType) dstGenericType);
            } else if (ParameterizedType.class.isAssignableFrom(srcGenericType.getClass()) && dstComponentClass.isArray()) {
                mapping((ParameterizedType) srcGenericType, dstComponentClass);

            } else if (srcCompentClass.isArray() && ParameterizedType.class.isAssignableFrom(dstGenericType.getClass())) {
                mapping(srcCompentClass, (ParameterizedType) dstGenericType);

            } else if (srcCompentClass.isArray() && dstComponentClass.isArray()) {
                mapping(srcCompentClass, dstComponentClass);
            }

        } else {
            addMappingInfo(srcField.getType(), dstField.getType());
        }
    }

    private static void apping(ParameterizedType srcType, ParameterizedType dstType) {
        Type srcTypeNext = srcType.getActualTypeArguments()[srcType.getActualTypeArguments().length - 1];
        Type dstTypeNext = dstType.getActualTypeArguments()[srcType.getActualTypeArguments().length - 1];

        Class<? extends Object> srcClass = null;
        Class<? extends Object> dstClass = null;
        if (!ParameterizedType.class.isAssignableFrom(srcTypeNext.getClass())) {
            srcClass = (Class<? extends Object>) srcTypeNext;
        }
        if (!ParameterizedType.class.isAssignableFrom(dstTypeNext.getClass())) {
            dstClass = (Class<? extends Object>) dstTypeNext;
        }
        if (null != srcClass && null != dstClass && srcClass.isArray() && dstClass.isArray()) {
            mapping(srcClass, dstClass);
            return;
        } else if (ParameterizedType.class.isAssignableFrom(srcTypeNext.getClass())
                && ParameterizedType.class.isAssignableFrom(dstTypeNext.getClass())) {
            apping((ParameterizedType) srcTypeNext, (ParameterizedType) dstTypeNext);
            return;
        } else if (ParameterizedType.class.isAssignableFrom(srcTypeNext.getClass())) {
            mapping((ParameterizedType) srcTypeNext, dstClass);
            return;
        } else if (ParameterizedType.class.isAssignableFrom(dstTypeNext.getClass())) {
            mapping(srcClass, (ParameterizedType) dstTypeNext);
            return;
        }

        addMappingInfo(srcClass, dstClass);
    }

    private static void mapping(ParameterizedType srcType, Class<?> dstClass) {

        if (null == dstClass || !dstClass.isArray()) {
            return;
        }

        Type[] srcActualTypeArguments = srcType.getActualTypeArguments();
        Type srcType1 = srcActualTypeArguments[srcActualTypeArguments.length - 1];
        Class<? extends Object> srcClass = null;
        if (!ParameterizedType.class.isAssignableFrom(srcType1.getClass())) {
            srcClass = (Class<? extends Object>) srcType1;
            mapping(srcClass, dstClass.getComponentType());
        } else if (ParameterizedType.class.isAssignableFrom(srcType1.getClass())) {
            mapping((ParameterizedType) srcType1, dstClass.getComponentType());
        }
    }

    /**
     * 
     * 功能描述：数组中包含集合暂时不处理
     * 
     * @param srcClass
     * @param dstClass void
     *
     */
    private static void mapping(Class<?> srcClass, Class<?> dstClass) {
        if (null == srcClass || null == dstClass || !srcClass.isArray() || !dstClass.isArray()) {
            return;
        }
        Class<?> srcClassNext = srcClass.getComponentType();
        Class<?> dstClassNext = dstClass.getComponentType();

        if (!srcClassNext.isArray() && !srcClassNext.isArray() && !ParameterizedType.class.isAssignableFrom(srcClassNext)
                && !ParameterizedType.class.isAssignableFrom(dstClassNext)) {
            addMappingInfo(srcClassNext, dstClassNext);
            return;
        }
    }

    private static void mapping(Class<?> srcClass, ParameterizedType dstType) {
        if (null == srcClass || !srcClass.isArray()) {
            return;
        }

        Type[] dstActualTypeArguments = dstType.getActualTypeArguments();
        Type dstType1 = dstActualTypeArguments[dstActualTypeArguments.length - 1];
        Class<? extends Object> dstClass = null;
        if (!ParameterizedType.class.isAssignableFrom(dstType1.getClass())) {
            dstClass = (Class<? extends Object>) dstType1;
            mapping(srcClass.getComponentType(), dstClass);
        } else if (ParameterizedType.class.isAssignableFrom(dstType1.getClass())) {
            mapping(srcClass.getComponentType(), (ParameterizedType) dstType1);
        }
    }

}
