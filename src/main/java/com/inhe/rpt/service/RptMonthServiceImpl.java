package com.inhe.rpt.service;

import com.inhe.rpt.mapper.RptMonthMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;

@Service
public class RptMonthServiceImpl implements RptMonthService {

    private final RptMonthMapper mapper;

    @Autowired
    public RptMonthServiceImpl(RptMonthMapper mapper){
        this.mapper = mapper;
    }

    @Override
    public int insertRptMeterMonth(String dFrom, String dTo) {
        return mapper.insertRptMeterMonth(dFrom,dTo);
    }

    @Override
    public int insertRptBranchMonth(String dFrom, String dTo) {
        return mapper.insertRptBranchMonth(dFrom,dTo);
    }

    @Override
    public int insertRptOperatorMonth(String dFrom, String dTo) {
        return mapper.insertRptOperatorMonth(dFrom,dTo);
    }

    @Override
    public int deleteMonthData(String tableName, String dataPeriod) {
        return mapper.deleteMonthData(tableName,dataPeriod);
    }

    @Override
    public ArrayList<String> getLastMonth(String tableName, String dFrom, String dTo) {
        return mapper.getLastMonth(tableName,dFrom,dTo);
    }
}
