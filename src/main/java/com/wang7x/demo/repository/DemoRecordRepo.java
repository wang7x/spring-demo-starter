package com.wang7x.demo.repository;

import com.wang7x.demo.model.DemoRecord;
import org.springframework.stereotype.Repository;

@Repository
public interface DemoRecordRepo {

    DemoRecord findByRecordId(String recordId);

    DemoRecord findByRecordIdWithLock(String recordId);

    void add(DemoRecord record);

    void update(DemoRecord record);

    void deleteByRecordId(String recordId);
}
