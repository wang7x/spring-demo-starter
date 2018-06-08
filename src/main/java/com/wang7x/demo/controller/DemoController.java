package com.wang7x.demo.controller;

import com.wang7x.demo.exception.ShortAllowanceException;
import com.wang7x.demo.service.DemoService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;

@RestController
@RequestMapping("/demo")
public class DemoController {
    private static final Logger LOGGER = LogManager.getLogger();

    @Autowired
    private DemoService demoService;


    @RequestMapping("/{recordId}/{amount}")
    public void access(@PathVariable String recordId,
                       @PathVariable BigDecimal amount) {
        LOGGER.info("input, recordId:{}, amount:{}", recordId, amount);
        demoService.grap(recordId, amount);
        LOGGER.info("success");
    }

    @ExceptionHandler({ShortAllowanceException.class, IllegalStateException.class})
    public void onException(Exception e) {
        LOGGER.warn(e.getMessage(), e);
    }
}
