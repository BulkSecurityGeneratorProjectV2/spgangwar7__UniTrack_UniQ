package com.digi.unitouch;

import java.util.TimeZone;

import javax.annotation.PostConstruct;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.scheduling.annotation.EnableScheduling;


@SpringBootApplication
//@EnableAdminServer
@EnableScheduling
@ComponentScan(basePackages = { "com.digi.unitouch" })

public class UnitouchApplication extends SpringBootServletInitializer {
	private static final Logger LOG = LogManager.getLogger(UnitouchApplication.class);

	@PostConstruct
	void started() {
		TimeZone.setDefault(TimeZone.getTimeZone("IST"));
	}

	public static void main(String[] args) {
		SpringApplication.run(UnitouchApplication.class, args);
		LOG.info("=============unitouch application started=============");
	}
}
