package com.inhe.rpt.mapper;

import org.apache.ibatis.annotations.Param;

import java.util.ArrayList;

public interface RptMonthMapper {
    int insertRptMeterMonth(@Param("dFrom") String dFrom, @Param("dTo")String dTo);

    int insertRptBranchMonth(@Param("dFrom")String dFrom, @Param("dTo")String dTo);

    int insertRptOperatorMonth(@Param("dFrom")String dFrom, @Param("dTo")String dTo);

    int deleteMonthData(@Param("tableName")String tableName,@Param("dataPeriod")String dataPeriod);

    ArrayList<String> getLastMonth(@Param("tableName")String tableName, @Param("dFrom")String dFrom, @Param("dTo")String dTo);
}
