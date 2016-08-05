package com.meila.test.bean.util.model.junit.model;

import java.math.BigDecimal;
import java.util.Date;

public class ModelD {
    private String fStr1;

    private String fStr2;

    private Long flong1;

    private Long flong2;

    private Integer fint1;

    private Integer fint2;

    private BigDecimal fbigDecimal1;

    private BigDecimal fbigDecimal2;

    private int fpint1;

    private int fpint2;

    private long fplong1;

    private long fplong2;

    private Date fdate1;

    private Date fdate2;

    public String getfStr1() {
        return fStr1;
    }

    public void setfStr1(String fStr1) {
        this.fStr1 = fStr1;
    }

    public String getfStr2() {
        return fStr2;
    }

    public void setfStr2(String fStr2) {
        this.fStr2 = fStr2;
    }

    public Long getFlong1() {
        return flong1;
    }

    public void setFlong1(Long flong1) {
        this.flong1 = flong1;
    }

    public Long getFlong2() {
        return flong2;
    }

    public void setFlong2(Long flong2) {
        this.flong2 = flong2;
    }

    public Integer getFint1() {
        return fint1;
    }

    public void setFint1(Integer fint1) {
        this.fint1 = fint1;
    }

    public Integer getFint2() {
        return fint2;
    }

    public void setFint2(Integer fint2) {
        this.fint2 = fint2;
    }

    public BigDecimal getFbigDecimal1() {
        return fbigDecimal1;
    }

    public void setFbigDecimal1(BigDecimal fbigDecimal1) {
        this.fbigDecimal1 = fbigDecimal1;
    }

    public BigDecimal getFbigDecimal2() {
        return fbigDecimal2;
    }

    public void setFbigDecimal2(BigDecimal fbigDecimal2) {
        this.fbigDecimal2 = fbigDecimal2;
    }

    public int getFpint1() {
        return fpint1;
    }

    public void setFpint1(int fpint1) {
        this.fpint1 = fpint1;
    }

    public int getFpint2() {
        return fpint2;
    }

    public void setFpint2(int fpint2) {
        this.fpint2 = fpint2;
    }

    public long getFplong1() {
        return fplong1;
    }

    public void setFplong1(long fplong1) {
        this.fplong1 = fplong1;
    }

    public long getFplong2() {
        return fplong2;
    }

    public void setFplong2(long fplong2) {
        this.fplong2 = fplong2;
    }

    public Date getFdate1() {
        return fdate1;
    }

    public void setFdate1(Date fdate1) {
        this.fdate1 = fdate1;
    }

    public Date getFdate2() {
        return fdate2;
    }

    public void setFdate2(Date fdate2) {
        this.fdate2 = fdate2;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((fStr1 == null) ? 0 : fStr1.hashCode());
        result = prime * result + ((fStr2 == null) ? 0 : fStr2.hashCode());
        result = prime * result + ((fbigDecimal1 == null) ? 0 : fbigDecimal1.hashCode());
        result = prime * result + ((fbigDecimal2 == null) ? 0 : fbigDecimal2.hashCode());
        result = prime * result + ((fdate1 == null) ? 0 : fdate1.hashCode());
        result = prime * result + ((fdate2 == null) ? 0 : fdate2.hashCode());
        result = prime * result + ((fint1 == null) ? 0 : fint1.hashCode());
        result = prime * result + ((fint2 == null) ? 0 : fint2.hashCode());
        result = prime * result + ((flong1 == null) ? 0 : flong1.hashCode());
        result = prime * result + ((flong2 == null) ? 0 : flong2.hashCode());
        result = prime * result + fpint1;
        result = prime * result + fpint2;
        result = prime * result + (int) (fplong1 ^ (fplong1 >>> 32));
        result = prime * result + (int) (fplong2 ^ (fplong2 >>> 32));
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        ModelD other = (ModelD) obj;
        if (fStr1 == null) {
            if (other.fStr1 != null)
                return false;
        } else if (!fStr1.equals(other.fStr1))
            return false;
        if (fStr2 == null) {
            if (other.fStr2 != null)
                return false;
        } else if (!fStr2.equals(other.fStr2))
            return false;
        if (fbigDecimal1 == null) {
            if (other.fbigDecimal1 != null)
                return false;
        } else if (!fbigDecimal1.equals(other.fbigDecimal1))
            return false;
        if (fbigDecimal2 == null) {
            if (other.fbigDecimal2 != null)
                return false;
        } else if (!fbigDecimal2.equals(other.fbigDecimal2))
            return false;
        if (fdate1 == null) {
            if (other.fdate1 != null)
                return false;
        } else if (!fdate1.equals(other.fdate1))
            return false;
        if (fdate2 == null) {
            if (other.fdate2 != null)
                return false;
        } else if (!fdate2.equals(other.fdate2))
            return false;
        if (fint1 == null) {
            if (other.fint1 != null)
                return false;
        } else if (!fint1.equals(other.fint1))
            return false;
        if (fint2 == null) {
            if (other.fint2 != null)
                return false;
        } else if (!fint2.equals(other.fint2))
            return false;
        if (flong1 == null) {
            if (other.flong1 != null)
                return false;
        } else if (!flong1.equals(other.flong1))
            return false;
        if (flong2 == null) {
            if (other.flong2 != null)
                return false;
        } else if (!flong2.equals(other.flong2))
            return false;
        if (fpint1 != other.fpint1)
            return false;
        if (fpint2 != other.fpint2)
            return false;
        if (fplong1 != other.fplong1)
            return false;
        if (fplong2 != other.fplong2)
            return false;
        return true;
    }
}
