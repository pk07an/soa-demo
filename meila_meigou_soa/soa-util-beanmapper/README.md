[TOC]

##属性映射工具类BeanMapper

**底层基于dozer(后期为提升性能,可能会修改为基于orika)**

**dozer是一种JavaBean的映射工具，类似于apache的BeanUtils。但是dozer更强大，它可以灵活的处理复杂类型之间的映射。不但可以进行简单的属性映射、复杂的类型映射、双向映射、递归映射等**

##使用方法

**引入依赖**
```
<dependency>
	<groupId>com.meila</groupId>
	<artifactId>meila-util-beanmapper</artifactId>
	<version>0.0.1-SNAPSHOT</version>
</dependency>
```

**调用方法**
BeanMapper.map(sourceObject, destClass);

sourceObject可以是集合, 也可以是对象  destClass为目标class


##注意
由于使用dozer自身的@Mapping注解进行属性标示的话, 在source中使用注解, 但是目标class中没有注解对应字段, 将导致映射报错, 所以我自定义了一个注解来进行不同名称的属性标示com.meila.bean.util.annotaion.MappingField

自定义注解功能更加强大, 可以进行多名称的标示, 实例如下.

**ModelA**
```java
public class ModelA {
    @MappingField({ "str2", "str3" })
    private String str1;

    public String getStr1() {
        return str1;
    }

    public void setStr1(String str1) {
        this.str1 = str1;
    }
}
```
**ModelB**
```java
public class ModelB {
    private String str2;

    public String getStr2() {
        return str2;
    }

    public void setStr2(String str2) {
        this.str2 = str2;
    }
}
```

**ModelC**
```java
public class ModelC {
    private String str3;

    public String getStr3() {
        return str3;
    }

    public void setStr3(String str3) {
        this.str3 = str3;
    }
}
```
**ModelD**
```java
public class ModelD {
    private String str1;

    public String getStr1() {
        return str1;
    }

    public void setStr1(String str1) {
        this.str1 = str1;
    }
}
```


在以上配置情况下, ModelA的str1字段可以映射成ModelB的str2和ModelC的str3, 如果映射成ModelD, 则映射成str1, 都不会报错



