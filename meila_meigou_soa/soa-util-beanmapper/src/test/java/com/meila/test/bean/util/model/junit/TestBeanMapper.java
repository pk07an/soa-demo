package com.meila.test.bean.util.model.junit;

import java.math.BigDecimal;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import com.meila.common.bean.utils.BeanMapper;
import com.meila.test.bean.util.model.DescModel;
import com.meila.test.bean.util.model.junit.model.ModelA;
import com.meila.test.bean.util.model.junit.model.ModelB;
import com.meila.test.bean.util.model.junit.model.ModelC;

/**
 * Unit test for simple App.
 */
public class TestBeanMapper {
    private DescModel map;

    @Test
    public void test() {
        ModelA modelA1 = new ModelA();

        modelA1.setFbigDecimal1(new BigDecimal(1000));
        modelA1.setFbigDecimal2(new BigDecimal(2000));
        modelA1.setFpint1(10);
        modelA1.setFpint2(2000);
        modelA1.setFdate1(new Date(System.currentTimeMillis()));
        modelA1.setFdate2(new Date(System.currentTimeMillis()));
        modelA1.setFlong1(10L);
        modelA1.setFlong2(11L);
        List<Long> flongList1 = new ArrayList();
        flongList1.add(1L);
        flongList1.add(2L);
        flongList1.add(3L);
        modelA1.setFlongList1(flongList1);
        modelA1.setFlongList2(flongList1);

        ModelB modelB1 = BeanMapper.map(modelA1, ModelB.class);
        ModelB modelB2 = new ModelB();
        BeanMapper.copy(modelA1, modelB2);
        Assert.assertEquals(modelB1.equals(modelB2), true);

        ModelA modelA2 = BeanMapper.map(modelB2, ModelA.class);
        Assert.assertEquals(modelA1.equals(modelA2), true);
    }

    @Test
    public void test1() {
        ModelA modelA1 = new ModelA();

        modelA1.setFbigDecimal1(new BigDecimal(1000));
        modelA1.setFbigDecimal2(new BigDecimal(2000));
        modelA1.setFpint1(10);
        modelA1.setFpint2(2000);
        modelA1.setFdate1(new Date(System.currentTimeMillis()));
        modelA1.setFdate2(new Date(System.currentTimeMillis()));
        modelA1.setFlong1(10L);
        modelA1.setFlong2(11L);
        List<Long> flongList1 = new ArrayList();
        flongList1.add(1L);
        flongList1.add(2L);
        flongList1.add(3L);
        modelA1.setFlongList1(flongList1);
        modelA1.setFlongList2(flongList1);

        ModelC modelB1 = BeanMapper.map(modelA1, ModelC.class);
        ModelC modelB2 = new ModelC();
        BeanMapper.copy(modelA1, modelB2);
        Assert.assertEquals(modelB1.equals(modelB2), true);

        ModelA modelA2 = BeanMapper.map(modelB2, ModelA.class);
        Assert.assertEquals(modelA1.equals(modelA2), true);
    }
    
    
    @Test
    public void test2() {
        ModelA modelA1 = new ModelA();

        modelA1.setFbigDecimal1(new BigDecimal(1000));
        modelA1.setFbigDecimal2(new BigDecimal(2000));
        modelA1.setFpint1(10);
        modelA1.setFpint2(2000);
        modelA1.setFdate1(new Date(System.currentTimeMillis()));
        modelA1.setFdate2(new Date(System.currentTimeMillis()));
        modelA1.setFlong1(10L);
        modelA1.setFlong2(11L);
        List<Long> flongList1 = new ArrayList();
        flongList1.add(1L);
        flongList1.add(2L);
        flongList1.add(3L);
        modelA1.setFlongList1(flongList1);
        modelA1.setFlongList2(flongList1);

        ModelC modelB1 = BeanMapper.map(modelA1, ModelC.class);
        ModelC modelB2 = new ModelC();
        BeanMapper.copy(modelA1, modelB2);
        Assert.assertEquals(modelB1.equals(modelB2), true);

        ModelA modelA2 = BeanMapper.map(modelB2, ModelA.class);
        Assert.assertEquals(modelA1.equals(modelA2), true);
    }
}
