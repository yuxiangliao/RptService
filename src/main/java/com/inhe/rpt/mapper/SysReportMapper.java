package com.inhe.rpt.mapper;

import com.inhe.rpt.model.SysReport;
import org.apache.ibatis.annotations.Param;

import java.util.HashMap;
import java.util.List;

public interface SysReportMapper {

    SysReport selectByPrimaryKey(String code);

    int updateByPrimaryKeySelective(SysReport record);

    int updateByPrimaryKeyWithBLOBs(SysReport record);

    int updateByPrimaryKey(SysReport record);

    HashMap<String,Object> findTest(@Param("params") HashMap<String,String> params);

    List<SysReport> findTask();
}