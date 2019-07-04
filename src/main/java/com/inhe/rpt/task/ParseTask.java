package com.inhe.rpt.task;

import com.inhe.rpt.processor.RptProcessor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ParseTask implements Runnable{

	private final RptProcessor processor;

	@Autowired
	public ParseTask(RptProcessor processor) {
		this.processor = processor;
	}

	@Override
	public void run() {
		System.out.println("parse data start...");
		//this.processor.setThreadCount(this.threadCount);
		this.processor.handleTask();
	
	}
	
	public void setThreadCount(Integer threadCount) {
		this.processor.setThreadCount(threadCount);
	}
	
}
