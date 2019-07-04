package com.inhe.rpt.mapper;

import com.inhe.rpt.model.RptOperatorDay;
import com.inhe.rpt.model.RptOperatorDayKey;

public interface RptOperatorDayMapper {
    int deleteByPrimaryKey(RptOperatorDayKey key);

    int insert(RptOperatorDay record);

    int insertSelective(RptOperatorDay record);

    RptOperatorDay selectByPrimaryKey(RptOperatorDayKey key);

    int updateByPrimaryKeySelective(RptOperatorDay record);

    int updateByPrimaryKeyWithBLOBs(RptOperatorDay record);

    int updateByPrimaryKey(RptOperatorDay record);
}