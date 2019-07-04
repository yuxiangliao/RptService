package com.inhe.rpt.service;

import com.inhe.rpt.mapper.SysReportMapper;
import com.inhe.rpt.model.SysReport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;

@Service
public class SysRptServiceImpl implements SysRptService {
    private SysReportMapper mapper;

    @Autowired
    public void setMapper(SysReportMapper mapper) {
        this.mapper = mapper;
    }

    public int updateByPrimaryKeySelective(SysReport sysReport){
        return  mapper.updateByPrimaryKeySelective(sysReport);
    }

    @Override
    public int updateByPrimaryKeyWithBLOBs(SysReport record) {
        return 0;
    }

    @Override
    public int updateByPrimaryKey(SysReport record) {
        return 0;
    }

    public List<SysReport> findTask(){
        return mapper.findTask();
    }

    @Override
    public HashMap<String, Object> findTest(HashMap<String, String> params) {
        return mapper.findTest(params);
    }
}
