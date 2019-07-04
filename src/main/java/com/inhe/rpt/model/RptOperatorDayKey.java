package com.inhe.rpt.model;

public class RptOperatorDayKey {
    private String operatorCode;

    private String dataPeriod;

    public String getOperatorCode() {
        return operatorCode;
    }

    public void setOperatorCode(String operatorCode) {
        this.operatorCode = operatorCode == null ? null : operatorCode.trim();
    }

    public String getDataPeriod() {
        return dataPeriod;
    }

    public void setDataPeriod(String dataPeriod) {
        this.dataPeriod = dataPeriod == null ? null : dataPeriod.trim();
    }
}