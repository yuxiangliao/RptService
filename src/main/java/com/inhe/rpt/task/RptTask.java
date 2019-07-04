package com.inhe.rpt.task;

import com.inhe.rpt.common.DateUtil;
import com.inhe.rpt.config.ApplicationContextUtil;
import com.inhe.rpt.exception.DateConvertException;
import com.inhe.rpt.model.SysReport;
import com.inhe.rpt.processor.BaseProcessor;
import com.inhe.rpt.processor.DailyProcessor;
import com.inhe.rpt.processor.MonthlyProcessor;
import com.inhe.rpt.service.SysRptService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
@Scope("prototype")
public class RptTask implements Runnable{
	private static final Logger LOGGER = LoggerFactory.getLogger(RptTask.class);
	private String taskResult = "";

	private SysReport sysReport;

    private SysRptService sysRptService;

    private BaseProcessor baseProcessor;

    private Date dFrom;

    private Date dTo;

	@Autowired
	public void setSysRptService(SysRptService sysRptService) {
		this.sysRptService = sysRptService;
	}

	public void setSysReport(SysReport sysReport) {
		this.sysReport = sysReport;
	}

	@Override
	public void run() {
		/**
		 * 具体任务操作
		 */
		try {
			initData();
			handleData();
			taskResult = "S";
		} catch (Exception e) {
			taskResult = "F";
			LOGGER.error("task running fail :",e);
		}finally{
			try {				
				finishTask();
				LOGGER.info("task finsih");
			} catch (DateConvertException e) {
				e.printStackTrace();
			}
		}
	}
	/**
	 * 任务完成,更新plan时间,更新task时间
	 * @throws DateConvertException
	 */
	private void finishTask() throws DateConvertException{
		if(this.sysReport != null){
			sysReport.setExecing("N");
			sysReport.setStartupTime(DateUtil.getNextTime(sysReport.getStartupTime(),sysReport.getCycleType(),sysReport.getCycle()));
			sysRptService.updateByPrimaryKeySelective(sysReport);

		}
	}

	private void initData() throws DateConvertException {
		//String taskCode = "";
		//更新任务状态
		if(this.sysReport != null){
			this.sysReport.setExecing("Y");
			this.sysRptService.updateByPrimaryKeySelective(sysReport);
			String currDay ="";

			if("00000001".equals(this.sysReport.getCode())){
				//month report
				currDay = DateUtil.dateToString(this.sysReport.getStartupTime(),"yyyy-MM-01");
				this.dTo = DateUtil.stringToDate(currDay,DateUtil.DATE_WITH_LINE);
				baseProcessor = ApplicationContextUtil.getBean(MonthlyProcessor.class);
				this.dFrom = DateUtil.rollByMonth(this.dTo,-1);
			}else if("00000003".equals(this.sysReport.getCode())) {
				//day report
				currDay = DateUtil.dateToString(this.sysReport.getStartupTime(),DateUtil.DATE_WITH_LINE);
				this.dTo = DateUtil.stringToDate(currDay,DateUtil.DATE_WITH_LINE);
				baseProcessor = ApplicationContextUtil.getBean(DailyProcessor.class);
				this.dFrom = DateUtil.rollByDay(this.dTo,-1);
			}
		}
	}

	private void handleData() throws Exception{
			baseProcessor.setdFrom(this.dFrom);
			baseProcessor.processTask();
	}

}
