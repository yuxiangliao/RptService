package com.inhe.rpt.controllers;

import com.alibaba.fastjson.JSON;
import com.inhe.rpt.common.CodeUtil;
import com.inhe.rpt.config.ApplicationContextUtil;
import com.inhe.rpt.model.SysReport;
import com.inhe.rpt.service.SysRptService;
import com.inhe.rpt.task.ParseTask;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.concurrent.ThreadPoolTaskScheduler;
import org.springframework.scheduling.support.CronTrigger;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.concurrent.ScheduledFuture;


@RestController
public class RptController {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(RptController.class);

    private ThreadPoolTaskScheduler threadPoolTaskScheduler;
    /**
     * 在ScheduledFuture中有一个cancel可以停止定时任务。
     */
    private ScheduledFuture<?> future;
	private ParseTask parsetask;

	@Autowired
	private SysRptService sysRptService;

	private HashMap<String,Object> mapfuture;

	@Autowired
	public void setParsetask(ParseTask parsetask) {
		this.parsetask = parsetask;
	}

	@Autowired
	public void setThreadPoolTaskScheduler(ThreadPoolTaskScheduler threadPoolTaskScheduler) {
		this.threadPoolTaskScheduler = threadPoolTaskScheduler;
	}

	@RequestMapping(value="report/start1",method = { RequestMethod.GET })
	public String startTask(@RequestParam(defaultValue="3") String cycleType,@RequestParam(defaultValue="1") String cycle,@RequestParam(defaultValue="10") int nums){
		if(future != null && !future.isCancelled()){
			return "Task already start...";
		}
		//设置线程池大小
		parsetask.setThreadCount(nums);
		String rule = CodeUtil.getTaskRule(cycle,cycleType);
		future = threadPoolTaskScheduler.schedule(parsetask, new CronTrigger(rule));
		LOGGER.info("start Cron()"); 
		return "Task start,Cron="+rule+" ThreadCounts:"+nums;
	}

	@RequestMapping(value="report/start2")
	public String startTask2(int nums){
		//if(future != null && !future.isCancelled()){
		//	return "Task already start...";
		//}
		//设置线程池大小
		//parsetask.setThreadCount(nums);
		if(mapfuture == null)
			mapfuture = new HashMap<String, Object>();

		String rule = "";

		threadPoolTaskScheduler.setPoolSize(nums);
        List<SysReport> list = sysRptService.findTask();
		for(SysReport sysReport :list) {
			if(mapfuture.containsKey(sysReport.getCode()))
				continue;
			parsetask = ApplicationContextUtil.getBean(ParseTask.class);
			parsetask.setId(sysReport.getCode());
			rule = CodeUtil.getTaskRule(sysReport.getCycle()+"",sysReport.getCycleType());
			future = threadPoolTaskScheduler.schedule(parsetask, new CronTrigger(rule));
			if(future != null){
				mapfuture.put(sysReport.getCode(),future);
			}
			future = null;
		}

		LOGGER.info("start Cron()");
		return "Task started, ThreadCounts:"+nums;
	}
	
	@RequestMapping("report/stop")
	public String stopTask(){
		if (future != null) {
	           future.cancel(true);
	       }
		LOGGER.info("stop Cron()");
		return "Task stop";
	}


	@RequestMapping("/hello")
	public String sayHello(){
		try
		{
			LOGGER.info("TEST......");
			LOGGER.error("error......");
			String account = "{\"type\":\"credit\",\"code\":\"test11_001\",\"bank\":\"123456\",\"account\":\"123456\"}";
			if(JSON.parseObject(account).getString("account")==null){
				return "empty";
			}
			else{
				return JSON.parseObject(account).getString("account");
			}
		}
		catch (Exception e){
			LOGGER.error(e.getMessage());

		}
		return "ok";
	}

	@RequestMapping(value = "/findTest",method = RequestMethod.GET)
	public HashMap<String,Object> findTest(){
		HashMap<String,String> params = new HashMap<String, String>();
		params.put("1","01");
		params.put("2","02");
		params.put("3","03");
		params.put("4","04");
		params.put("5","05");
		HashMap<String,Object> result = sysRptService.findTest(params);
		return result;
	}



}
