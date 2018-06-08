package com.wang7x.demo.service;

import java.math.BigDecimal;

public interface DemoService {
    void grap(String recordId, BigDecimal amount);

    void init(String recordId, BigDecimal initAllowance);

    void delete(String recordId);
}
