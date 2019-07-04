package com.inhe.rpt.mapper;

import com.inhe.rpt.model.RptMeterDay;
import com.inhe.rpt.model.RptMeterDayKey;

public interface RptMeterDayMapper {
    int deleteByPrimaryKey(RptMeterDayKey key);

    int insert(RptMeterDay record);

    int insertSelective(RptMeterDay record);

    RptMeterDay selectByPrimaryKey(RptMeterDayKey key);

    int updateByPrimaryKeySelective(RptMeterDay record);

    int updateByPrimaryKeyWithBLOBs(RptMeterDay record);

    int updateByPrimaryKey(RptMeterDay record);
}