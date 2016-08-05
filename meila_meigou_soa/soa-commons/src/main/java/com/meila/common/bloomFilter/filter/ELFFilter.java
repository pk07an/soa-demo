package com.meila.common.bloomFilter.filter;

import com.meila.common.security.Hashs;

public class ELFFilter extends AbstractFilter {

    public ELFFilter(long maxValue, int MACHINENUM) {
        super(maxValue, MACHINENUM);
    }

    public ELFFilter(long maxValue) {
        super(maxValue);
    }

    @Override
    public long hash(String str) {
        return Hashs.elfHash(str) % size;
    }

}
