package com.inhe.rpt.task;

import com.inhe.rpt.processor.RptProcessor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

@Service
@Scope("prototype")
public class ParseTask implements Runnable{

	private final RptProcessor processor;

	private static final Logger LOGGER = LoggerFactory.getLogger(RptTask.class);

	private String id;

	private int nums = 1;

	@Autowired
	public ParseTask(RptProcessor processor) {
		this.processor = processor;
	}

	@Override
	public void run() {
		LOGGER.info(this.id + " parse data start...,Counts : "+nums);
		nums++;
		//this.processor.setThreadCount(this.threadCount);
		//this.processor.handleTask();
	
	}
	
	public void setThreadCount(Integer threadCount) {
		this.processor.setThreadCount(threadCount);
	}

	public void setId(String id) {
		this.id = id;
	}
}
