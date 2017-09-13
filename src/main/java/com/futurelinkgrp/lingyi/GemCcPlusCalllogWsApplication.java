package com.futurelinkgrp.lingyi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;

@SpringBootApplication
public class GemCcPlusCalllogWsApplication extends SpringBootServletInitializer{

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application){
		return application.sources(GemCcPlusCalllogWsApplication.class);
	}

	public static void main(String[] args) {
		SpringApplication.run(GemCcPlusCalllogWsApplication.class, args);
	}
}
