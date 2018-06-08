package com.wang7x.demo.config;

import com.wang7x.demo.service.DemoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.math.BigDecimal;

@Component
public class InitData {
    @Autowired
    DemoService demoService;

    @PostConstruct
    private void init() {
        demoService.delete("normal");
        demoService.init("normal", BigDecimal.valueOf(10000));
    }
}
