package com.wang7x.demo.service;

import com.google.common.base.Strings;
import com.wang7x.demo.exception.ShortAllowanceException;
import com.wang7x.demo.model.DemoRecord;
import com.wang7x.demo.repository.DemoRecordRepo;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;

import static com.google.common.base.Preconditions.checkArgument;
import static com.google.common.base.Preconditions.checkNotNull;

@Service
public class DemoServiceImpl implements DemoService {
    private static final Logger LOGGER = LogManager.getLogger();
    @Autowired
    private DemoRecordRepo demoRecordRepo;

    @Transactional
    @Override
    public void grap(String recordId, BigDecimal amount) {
        LOGGER.info("grap input, recordId:{}, amount:{}", recordId, amount);
        checkArgument(!Strings.isNullOrEmpty(recordId));
        checkArgument(amount != null && amount.compareTo(BigDecimal.ZERO) > 0);

        DemoRecord record = demoRecordRepo.findByRecordIdWithLock(recordId);
        checkNotNull(record);
        LOGGER.info("record:{}", record);

        if (amount.compareTo(record.getAllowance()) > 0) {
            throw new ShortAllowanceException();
        }

        record.grap(amount);
        demoRecordRepo.update(record);
        LOGGER.info("grap success, {}", record);
    }

    @Transactional
    @Override
    public void init(String recordId, BigDecimal initAllowance) {
        LOGGER.info("init, recordId:{}, initAllowance:{}", recordId, initAllowance);
        checkArgument(!Strings.isNullOrEmpty(recordId));
        checkArgument(initAllowance != null && initAllowance.compareTo(BigDecimal.ZERO) >= 0);


        DemoRecord record = DemoRecord.newRecord(
                recordId, initAllowance);


        demoRecordRepo.add(record);

        LOGGER.info("create record success, record:{}", record);
    }

    @Transactional
    @Override
    public void delete(String recordId) {
        checkArgument(!Strings.isNullOrEmpty(recordId));

        demoRecordRepo.deleteByRecordId(recordId);
    }
}
