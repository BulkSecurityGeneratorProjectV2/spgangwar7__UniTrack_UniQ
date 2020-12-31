package com.digi.unitouch;

import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.digi.unitouch.util.CustomSiteMeshFilter;
@Configuration
public class ServletInitializer extends SpringBootServletInitializer {

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(UnitouchApplication.class);
	}
	
	@Bean
	public FilterRegistrationBean siteMeshFilter(){
		FilterRegistrationBean fitler = new FilterRegistrationBean();
		CustomSiteMeshFilter siteMeshFilter = new CustomSiteMeshFilter();
		fitler.setFilter(siteMeshFilter);
		return fitler;
	}
}
