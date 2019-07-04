package com.inhe.rpt.config;

import com.inhe.rpt.controllers.RptController;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

@Component
public class ApplicationStartup implements ApplicationRunner {

	@Resource
	private RptController rptController;
	
	@Value("${jade.cycle}")
	private String cycle;

	@Value("${jade.cycleType}")
	private String cycleType;
	
	@Value("${jade.nums}")
	private int nums;

	
	@Value("${jade.startup}")
	private String startup;

	@Override
	public void run(ApplicationArguments args) throws Exception {
		if ("Y".equals(startup)) {
			rptController.startTask(cycleType,cycle,nums);
		}
	}
}
