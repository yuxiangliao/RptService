package com.inhe.rpt.processor;

import com.inhe.rpt.config.ApplicationContextUtil;
import com.inhe.rpt.model.SysReport;
import com.inhe.rpt.service.SysRptService;
import com.inhe.rpt.task.RptTask;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Service
public class RptProcessor {
    private static final Logger LOGGER = LoggerFactory.getLogger(RptProcessor.class);

    private ExecutorService executorService;

    private Integer threadCount=10;

    private SysRptService sysRptService;

    @Autowired
    public void setSysRptService(SysRptService sysRptService) {
        this.sysRptService = sysRptService;
    }

    public RptProcessor(){
        //faJadeTask = new FaJadeTaskServiceImpl();
    }

    public void handleTask(){
        LOGGER.info("handle task start");
        if (executorService == null) {
            executorService = Executors.newFixedThreadPool(threadCount);
        }
        List<SysReport> rList = findTask();
        for(int i=0;i<rList.size();i++){
            SysReport task1 = rList.get(i);
            RptTask task = ApplicationContextUtil.getBean(RptTask.class);
            task.setSysReport(task1);
            executorService.execute(task);
        }

    }
    /**
     * 查找待任务
     */
    private List<SysReport> findTask(){
        return sysRptService.findTask();
    }

    public void setThreadCount(Integer threadCount) {
        this.threadCount = threadCount;
    }
}

