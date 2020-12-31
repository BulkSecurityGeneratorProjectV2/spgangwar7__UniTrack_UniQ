package com.digi.unitouch.controller;

import java.text.SimpleDateFormat;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.digi.unitouch.model.HolidayCalander;
import com.digi.unitouch.model.HolidayGroup;
import com.digi.unitouch.service.HolidayService;
import com.digi.unitouch.util.LoggerClass;
import com.digi.unitouch.vo.HolidayVo;
import com.digi.unitouch.vo.ResponseVo;

@Controller
public class HolidayController extends LoggerClass{
	
	@Autowired
	HolidayService holidayService;
	
	@GetMapping("holidayGroup")
	public ModelAndView holidayGroup(ModelMap model) {
		List<HolidayGroup> holidayGroup = holidayService.holiDayGroupList();
		model.addAttribute("holidayGroup", holidayGroup);
		return new ModelAndView("holidaygroup");
	}
	
	@GetMapping("createHoliDayGrp")
	public ModelAndView createHoliDayGroup(ModelMap model) {
	    return new ModelAndView("createHoliDayGrp");
	}
	
	@PostMapping("editHolidayGroup")
	public String editHolidayGroup(HolidayGroup holidayGroup ,ModelMap model) {
		List<HolidayGroup> holidayGrp =	holidayService.getHolidayGroupByID(holidayGroup);
		model.addAttribute("holidayGropDetails", holidayGrp.get(0));
		return "editHolidayGroupDetails";
	}
	
	@PostMapping("updateHoliDayGroup")
	public String updateHolidayGroup(HolidayGroup holidayGroup ,ModelMap model) {
		holidayService.editHolidayGroup(holidayGroup);
		List<HolidayGroup> HolidayGroup= holidayService.holiDayGroupList();
		model.addAttribute("HolidayGroup", HolidayGroup);
		return "redirect:holidayGroup";
	}
	
	@PostMapping("deleteHolidayGroup")
	public String deleteHolidayGroup(HolidayGroup holidayGroup ,ModelMap model) {
		holidayService.deleteHolidayGroup(holidayGroup);
		return "redirect:holidayGroup";
	
	}
	
	@GetMapping("holidayDetails")
	public ModelAndView holidayDetails(ModelMap model) {
		List<HolidayVo> holidayList = holidayService.getHolidayList();
		model.addAttribute("holidayList", holidayList);
		return new ModelAndView("holiday");
	}
	
	@GetMapping("createNewHoliday")
	public ModelAndView createNewHoliday(ModelMap model) {
		List<HolidayGroup> holidayGroupList = holidayService.holiDayGroupList();
		model.addAttribute("holidayGroup", holidayGroupList);
	    return new ModelAndView("createHoliday");
	}
	
	@PostMapping("saveNewHoliday")
	public String saveNewHoliday(HolidayCalander holiday,ModelMap model) {
		holidayService.saveNewHoliday(holiday);
		return "redirect:holidayDetails";
	}
	
	@PostMapping("deleteHoliday")
	public String deleteHolidayDetails(HolidayCalander holiday ,ModelMap model) {
		holidayService.deleteHolidayDetails(holiday);
		return "redirect:holidayDetails";
	}
	
	@PostMapping("editHolidayDetails")
	public String editHolidayDetails(HolidayCalander holiday ,ModelMap model) {
		SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
		List<HolidayCalander> holidayList = holidayService.getHolidayListByID(holiday);
		model.addAttribute("holidayList", holidayList.get(0));
		model.addAttribute("startDate",sdf.format(holidayList.get(0).getHolidayStartDate()));
		model.addAttribute("endDate",sdf.format(holidayList.get(0).getHolidayEndDate()));
		List<HolidayGroup> holidayGroupList = holidayService.holiDayGroupList();
		model.addAttribute("holidayGroup", holidayGroupList);
		return "editHolidayDetails";
	}
	
	@PostMapping("updateHolidayDetails")
	public String updateHolidayDetails(HolidayCalander holiday,ModelMap model) {
		holidayService.saveNewHoliday(holiday);
		List<HolidayGroup> holidayGroupList = holidayService.holiDayGroupList();
		model.addAttribute("holidayGroup", holidayGroupList);
		return "redirect:holidayDetails";
	}
	
	@PostMapping("createHolidayComboBox")
	public @ResponseBody ResponseVo createHolidayComboBox(@RequestBody HolidayCalander holiday,ModelMap model) {
		ResponseVo responseVo = new ResponseVo();
		responseVo.setResponseText(holidayService.createHolidayComboBox());
		return responseVo;
	}
	
	
}
