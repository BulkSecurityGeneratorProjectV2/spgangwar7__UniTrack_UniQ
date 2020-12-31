package com.digi.unitouch.controller;

import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.ModelAndView;

import com.digi.unitouch.util.LoggerClass;

@Controller
public class MyErrorController extends LoggerClass implements ErrorController {

	// ...

	@RequestMapping("/error")
	 @ResponseStatus(value=HttpStatus.INTERNAL_SERVER_ERROR)
	public ModelAndView handleError() {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("error");
		return modelAndView;
	}
	
	@Override
	public String getErrorPath() {
		return "/error";
	}
}
