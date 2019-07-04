package com.inhe.rpt.service;

import com.inhe.rpt.mapper.RptDayMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;

@Service
public class RptDayServiceImpl implements RptDayService {

    private RptDayMapper mapper;

    @Autowired
    public void setMapper(RptDayMapper mapper) {
        this.mapper = mapper;
    }

    @Override
    public int deleteDayData(String tableName,String dataPeriod) {
        return mapper.deleteDayData(tableName,dataPeriod);
    }

    @Override
    public ArrayList<String> getLastDay(String tableName,String dFrom, String dTo) {
        return mapper.getLastDay(tableName,dFrom,dTo);
    }

    @Override
    public int insertRptMeterDay(Date dFrom, Date dTo) {
        return mapper.insertRptMeterDay(dFrom,dTo);
    }

    @Override
    public int insertRptBranchDay(Date dFrom, Date dTo) {
        return mapper.insertRptBranchDay(dFrom,dTo);
    }

    @Override
    public int insertRptOperatorDay(Date dFrom, Date dTo) {
        return mapper.insertRptOperatorDay(dFrom,dTo);
    }
}
