package com.meila.common.bloomFilter.filter;

import com.meila.common.security.Hashs;

public class RSFilter extends AbstractFilter {

    public RSFilter(long maxValue, int machineNum) {
        super(maxValue, machineNum);
    }

    public RSFilter(long maxValue) {
        super(maxValue);
    }

    @Override
    public long hash(String str) {
        return Hashs.rsHash(str) % size;
    }

}
