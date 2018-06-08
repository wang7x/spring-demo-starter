package com.wang7x.demo.service;

import com.wang7x.demo.BaseTest;
import com.wang7x.demo.exception.ShortAllowanceException;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.math.BigDecimal;


public class DemoServiceTest extends BaseTest {
    @Autowired
    private DemoService demoService;

    @Test
    public void testInit() {
        demoService.delete("testInit1");
        demoService.init("testInit1", BigDecimal.valueOf(7000));
        demoService.delete("testInit1");
        demoService.init("testInit2", BigDecimal.valueOf(1));
        demoService.init("testInit3", BigDecimal.valueOf(0));
        demoService.init("testInit4", BigDecimal.valueOf(0));
        demoService.init("testInit5", BigDecimal.valueOf(127));
    }

    @Test(expected = ShortAllowanceException.class)
    public void testGrap1() {
        demoService.init("testGrap1", BigDecimal.valueOf(100));
        demoService.grap("testGrap1", BigDecimal.valueOf(101));
    }

    @Test
    public void testGrap2() {
        demoService.init("testGrap2", BigDecimal.valueOf(100));
        demoService.grap("testGrap2", BigDecimal.valueOf(99));
    }

    @Test
    public void testGrap3() {
        demoService.init("testGrap3", BigDecimal.valueOf(100));
        demoService.grap("testGrap3", BigDecimal.valueOf(100));
    }
}