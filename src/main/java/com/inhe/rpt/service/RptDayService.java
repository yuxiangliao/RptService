package com.inhe.rpt.service;

import java.util.ArrayList;
import java.util.Date;

public interface RptDayService {

     int insertRptMeterDay(Date dFrom, Date dTo);

     int insertRptBranchDay(Date dFrom, Date dTo);

     int insertRptOperatorDay(Date dFrom, Date dTo);

     int deleteDayData(String tableName,String dataPeriod);

     ArrayList<String> getLastDay(String tableName,String dFrom, String dTo);
}
