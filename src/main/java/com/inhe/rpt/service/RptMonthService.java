package com.inhe.rpt.service;

import java.util.ArrayList;

public interface RptMonthService {
    int insertRptMeterMonth(String dFrom, String dTo);

    int insertRptBranchMonth(String dFrom, String dTo);

    int insertRptOperatorMonth(String dFrom, String dTo);

    int deleteMonthData(String tableName,String dataPeriod);

    ArrayList<String> getLastMonth(String tableName, String dFrom, String dTo);
}
