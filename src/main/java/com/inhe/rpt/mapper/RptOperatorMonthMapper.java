package com.inhe.rpt.mapper;

import com.inhe.rpt.model.RptOperatorMonth;
import com.inhe.rpt.model.RptOperatorMonthKey;

public interface RptOperatorMonthMapper {
    int deleteByPrimaryKey(RptOperatorMonthKey key);

    int insert(RptOperatorMonth record);

    int insertSelective(RptOperatorMonth record);

    RptOperatorMonth selectByPrimaryKey(RptOperatorMonthKey key);

    int updateByPrimaryKeySelective(RptOperatorMonth record);

    int updateByPrimaryKeyWithBLOBs(RptOperatorMonth record);

    int updateByPrimaryKey(RptOperatorMonth record);
}