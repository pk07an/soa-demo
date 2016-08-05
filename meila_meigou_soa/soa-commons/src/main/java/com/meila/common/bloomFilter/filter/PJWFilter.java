package com.meila.common.bloomFilter.filter;

import com.meila.common.security.Hashs;

public class PJWFilter extends AbstractFilter {

    public PJWFilter(long maxValue, int machineNum) {
        super(maxValue, machineNum);
    }

    public PJWFilter(long maxValue) {
        super(maxValue);
    }

    @Override
    public long hash(String str) {
        return Hashs.pjwHash(str) % size;
    }

}
