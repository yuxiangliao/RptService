package com.inhe.rpt.mapper;

import com.inhe.rpt.model.RptBranchDay;
import com.inhe.rpt.model.RptBranchDayKey;

public interface RptBranchDayMapper {
    int deleteByPrimaryKey(RptBranchDayKey key);

    int insert(RptBranchDay record);

    int insertSelective(RptBranchDay record);

    RptBranchDay selectByPrimaryKey(RptBranchDayKey key);

    int updateByPrimaryKeySelective(RptBranchDay record);

    int updateByPrimaryKeyWithBLOBs(RptBranchDay record);

    int updateByPrimaryKey(RptBranchDay record);
}