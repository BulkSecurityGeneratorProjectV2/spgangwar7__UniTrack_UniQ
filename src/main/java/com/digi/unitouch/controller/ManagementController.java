package com.digi.unitouch.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.digi.unitouch.util.LoggerClass;

@Controller
public class ManagementController extends LoggerClass
{
	
	@RequestMapping(value = { "/deptprod" })
	public ModelAndView dashboard(ModelMap model) {
				
		
		return new ModelAndView("/deptproductivity");
	}

}
