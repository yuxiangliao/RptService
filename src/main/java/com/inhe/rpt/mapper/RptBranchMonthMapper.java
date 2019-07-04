package com.inhe.rpt.mapper;

import com.inhe.rpt.model.RptBranchMonth;
import com.inhe.rpt.model.RptBranchMonthKey;

public interface RptBranchMonthMapper {
    int deleteByPrimaryKey(RptBranchMonthKey key);

    int insert(RptBranchMonth record);

    int insertSelective(RptBranchMonth record);

    RptBranchMonth selectByPrimaryKey(RptBranchMonthKey key);

    int updateByPrimaryKeySelective(RptBranchMonth record);

    int updateByPrimaryKeyWithBLOBs(RptBranchMonth record);

    int updateByPrimaryKey(RptBranchMonth record);
}