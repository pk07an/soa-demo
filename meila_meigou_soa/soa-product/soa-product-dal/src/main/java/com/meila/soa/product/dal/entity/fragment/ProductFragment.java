package com.meila.soa.product.dal.entity.fragment;

import com.meila.common.bean.utils.annotaion.MappingField;

public class ProductFragment {

    @MappingField({ "productFragmentId" })
    private Long id;

    private Long productId;

    private Long fragmentId;

    private Integer idx;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    public Long getFragmentId() {
        return fragmentId;
    }

    public void setFragmentId(Long fragmentId) {
        this.fragmentId = fragmentId;
    }

    public Integer getIdx() {
        return idx;
    }

    public void setIdx(Integer idx) {
        this.idx = idx;
    }
}
