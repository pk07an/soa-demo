package com.meila.common.tuples;

import java.io.Serializable;

/**
 * 
 ************************************************************
 * @类名 : Triplet.java
 *
 * @DESCRIPTION :三元组，返回多个参数的情况下使用
 * @AUTHOR : hawk
 * @DATE : 2016年1月14日
 * @param <A>
 * @param <B>
 * @param <C>
 ************************************************************
 */
public class Triplet<A, B, C> implements Serializable {
    private static final long serialVersionUID = -1693395431539793647L;
    public A first;
    public B second;
    public C third;

    public Triplet(A first, B second, C third) {
        super();
        this.first = first;
        this.second = second;
        this.third = third;
    }
}
