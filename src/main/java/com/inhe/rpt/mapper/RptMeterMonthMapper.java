package com.inhe.rpt.mapper;

import com.inhe.rpt.model.RptMeterMonth;
import com.inhe.rpt.model.RptMeterMonthKey;

public interface RptMeterMonthMapper {
    int deleteByPrimaryKey(RptMeterMonthKey key);

    int insert(RptMeterMonth record);

    int insertSelective(RptMeterMonth record);

    RptMeterMonth selectByPrimaryKey(RptMeterMonthKey key);

    int updateByPrimaryKeySelective(RptMeterMonth record);

    int updateByPrimaryKeyWithBLOBs(RptMeterMonth record);

    int updateByPrimaryKey(RptMeterMonth record);
}