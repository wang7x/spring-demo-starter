package com.wang7x.demo.model;

import com.google.common.base.Strings;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Objects;

import static com.google.common.base.Preconditions.checkArgument;

public class DemoRecord implements Serializable {
    private static final long serialVersionUID = -8917323156235262607L;

    private String recordId;
    private BigDecimal allowance;
    private BigDecimal cumulativeAmount;

    public static DemoRecord newRecord(String recordId,
                                       BigDecimal allowance) {
        checkArgument(!Strings.isNullOrEmpty(recordId));
        checkArgument(allowance != null && allowance.compareTo(BigDecimal.ZERO) >= 0);

        DemoRecord record = new DemoRecord();
        record.setRecordId(recordId);
        record.setAllowance(allowance);
        record.setCumulativeAmount(BigDecimal.ZERO);

        return record;
    }

    public void grap(BigDecimal amount) {
        checkArgument(amount != null && getAllowance().compareTo(amount) >= 0);
        setAllowance(getAllowance().subtract(amount));
        setCumulativeAmount(getCumulativeAmount().add(amount));
    }

    @Override
    public String toString() {
        return "DemoRecord{" +
                "recordId='" + recordId + '\'' +
                ", allowance=" + allowance +
                ", cumulativeAmount=" + cumulativeAmount +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DemoRecord that = (DemoRecord) o;
        return Objects.equals(getRecordId(), that.getRecordId());
    }

    @Override
    public int hashCode() {

        return Objects.hash(getRecordId());
    }

    public String getRecordId() {
        return recordId;
    }

    public void setRecordId(String recordId) {
        this.recordId = recordId;
    }

    public BigDecimal getAllowance() {
        return allowance;
    }

    public void setAllowance(BigDecimal allowance) {
        this.allowance = allowance;
    }

    public BigDecimal getCumulativeAmount() {
        return cumulativeAmount;
    }

    public void setCumulativeAmount(BigDecimal cumulativeAmount) {
        this.cumulativeAmount = cumulativeAmount;
    }

}
