package com.meila.common.bloomFilter.filter;

import com.meila.common.security.Hashs;

public class SDBMFilter extends AbstractFilter {

    public SDBMFilter(long maxValue, int machineNum) {
        super(maxValue, machineNum);
    }

    public SDBMFilter(long maxValue) {
        super(maxValue);
    }

    @Override
    public long hash(String str) {
        return Hashs.sdbmHash(str) % size;
    }

}
