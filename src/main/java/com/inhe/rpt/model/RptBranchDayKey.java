package com.inhe.rpt.model;

public class RptBranchDayKey {
    private String branchCode;

    private String dataPeriod;

    public String getBranchCode() {
        return branchCode;
    }

    public void setBranchCode(String branchCode) {
        this.branchCode = branchCode == null ? null : branchCode.trim();
    }

    public String getDataPeriod() {
        return dataPeriod;
    }

    public void setDataPeriod(String dataPeriod) {
        this.dataPeriod = dataPeriod == null ? null : dataPeriod.trim();
    }
}