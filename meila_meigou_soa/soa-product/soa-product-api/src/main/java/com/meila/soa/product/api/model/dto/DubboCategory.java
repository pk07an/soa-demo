package com.meila.soa.product.api.model.dto;

import org.hibernate.validator.constraints.NotEmpty;

import com.meila.dubbo.base.model.BasicSeriModel;

public class DubboCategory extends BasicSeriModel {
    private static final long serialVersionUID = 1L;

    @NotEmpty
    private String categoryCode;

    @NotEmpty
    private String categoryName;

    private String parentCode;

    public String getCategoryCode() {
        return categoryCode;
    }

    public void setCategoryCode(String categoryCode) {
        this.categoryCode = categoryCode;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public String getParentCode() {
        return parentCode;
    }

    public void setParentCode(String parentCode) {
        this.parentCode = parentCode;
    }
}
