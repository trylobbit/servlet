package com.satyla.hello;

import java.math.BigDecimal;


public class Rates {
    private BigDecimal ask;
    private String effectiveDate;

    public Rates() {
    }

    public Rates(BigDecimal ask, String effectiveDate) {
        this.ask = ask;
        this.effectiveDate = effectiveDate;
    }

    public BigDecimal getAsk() {
        return ask;
    }

    public void setAsk(BigDecimal ask) {
        this.ask = ask;
    }

    String getEffectiveDate() {
        return effectiveDate;
    }

    public void setEffectiveDate(String effectiveDate) {
        this.effectiveDate = effectiveDate;
    }

    @Override
    public String toString() {
        return "Rates{" +
                "ask=" + ask +
                ", effectiveDate='" + effectiveDate + '\'' +
                '}';
    }
}
