package com.meila.soa.commons.model;

import org.dozer.Mapping;

public class ClassA {
    private String str1;
    private String str2;
    private String str3;
    private String str4;

    @Mapping("str5bak")
    private String str5bak;

    public String getStr5bak() {
        return str5bak;
    }

    public void setStr5bak(String str5bak) {
        this.str5bak = str5bak;
    }

    public String getStr1() {
        return str1;
    }

    public void setStr1(String str1) {
        this.str1 = str1;
    }

    public String getStr2() {
        return str2;
    }

    public void setStr2(String str2) {
        this.str2 = str2;
    }

    public String getStr3() {
        return str3;
    }

    public void setStr3(String str3) {
        this.str3 = str3;
    }

    public String getStr4() {
        return str4;
    }

    public void setStr4(String str4) {
        this.str4 = str4;
    }

}