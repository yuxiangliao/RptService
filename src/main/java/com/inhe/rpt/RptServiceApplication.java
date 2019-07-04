package com.inhe.rpt;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
@MapperScan("com.inhe.rpt.mapper")
public class RptServiceApplication {
	
	public static void main(String[] args) {
		SpringApplication.run(RptServiceApplication.class, args);
	}

}
