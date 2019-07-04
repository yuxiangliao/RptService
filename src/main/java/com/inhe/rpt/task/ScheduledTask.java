package com.inhe.rpt.task;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class ScheduledTask {

	private int fixedDelayCount = 1;
	//@Scheduled(fixedDelay = 5000)        //fixedDelay = 5000表示当前方法执行完毕5000ms后，Spring scheduling会再次调用该方法
    @Scheduled(cron = "${jobs.cron}")
	public void findTask() {
		
		String mString = String.format("===fixedDelay: 第{%d}次执行方法", fixedDelayCount++);
        System.out.println((new SimpleDateFormat("yyyy-MM-dd hh:mm:ss")).format(new Date())+mString);
    }

}
