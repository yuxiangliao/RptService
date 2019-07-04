package com.inhe.rpt.mapper;

import org.apache.ibatis.annotations.Param;

import java.util.ArrayList;
import java.util.Date;

public interface RptDayMapper {

    int insertRptMeterDay(@Param("dFrom")Date dFrom, @Param("dTo")Date dTo);

    int insertRptBranchDay(@Param("dFrom")Date dFrom, @Param("dTo")Date dTo);

    int insertRptOperatorDay(@Param("dFrom")Date dFrom, @Param("dTo")Date dTo);

    int deleteDayData(@Param("tableName")String tableName,@Param("dataPeriod")String dataPeriod);

    ArrayList<String> getLastDay(@Param("tableName")String tableName,@Param("dFrom")String dFrom, @Param("dTo")String dTo);
}
