package com.inhe.rpt.model;

public class RptMeterDayKey {
    private String deviceCode;

    private String dataPeriod;

    public String getDeviceCode() {
        return deviceCode;
    }

    public void setDeviceCode(String deviceCode) {
        this.deviceCode = deviceCode == null ? null : deviceCode.trim();
    }

    public String getDataPeriod() {
        return dataPeriod;
    }

    public void setDataPeriod(String dataPeriod) {
        this.dataPeriod = dataPeriod == null ? null : dataPeriod.trim();
    }
}