package com.meila.soa.product.api.model.dto.fragment;

import com.meila.common.bean.utils.annotaion.MappingField;
import com.meila.dubbo.base.model.BasicSeriModel;

public class DubboProductFragment extends BasicSeriModel {
    /**
     * 
     */
    private static final long serialVersionUID = 1L;

    @MappingField("id")
    private Long productFragmentId;

    private Long productId;

    private Long fragmentId;

    private Integer idx;

    public Long getProductFragmentId() {
        return productFragmentId;
    }

    public void setProductFragmentId(Long productFragmentId) {
        this.productFragmentId = productFragmentId;
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
