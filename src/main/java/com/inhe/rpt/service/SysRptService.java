package com.inhe.rpt.service;

import com.inhe.rpt.model.SysReport;

import java.util.HashMap;
import java.util.List;

public interface SysRptService {

    int updateByPrimaryKeySelective(SysReport record);
    int updateByPrimaryKeyWithBLOBs(SysReport record);

    int updateByPrimaryKey(SysReport record);

    List<SysReport> findTask();

    HashMap<String,Object> findTest(HashMap<String,String> params);
}
