package com.digi.unitouch.controller;

import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.digi.unitouch.model.ExamDetails;
import com.digi.unitouch.model.Users;
import com.digi.unitouch.service.ExamService;
import com.digi.unitouch.service.UserService;

@Controller
public class ExamController {
	@Autowired
	UserService userService;

	@Autowired
	ExamService examService;

	@GetMapping("createExam")
	public ModelAndView createDetail(ModelMap model) {
		String name = SecurityContextHolder.getContext().getAuthentication().getName();
		return new ModelAndView("createExam");
	}

	@PostMapping("saveExam")
	public String saveDetail(ModelMap model, ExamDetails examDetails,RedirectAttributes ra) {
		String name = SecurityContextHolder.getContext().getAuthentication().getName();
		Users users = userService.findUserIdByUserName(name);
		examDetails.setCreate_by(users.getUserID());
		examDetails.setCreateTime(new Date());
		examService.saveExam(examDetails);
		ra.addAttribute("message", "Exam created successfully");
		ra.addAttribute("css", "success");
		return "redirect:getExamList";
	}
	
	@GetMapping("getExamList")
	public String getExamList(ModelMap model,RedirectAttributes ra, HttpServletRequest request, @ModelAttribute("message") String message,
			@ModelAttribute("css") String css) {
		List<ExamDetails> examList=examService.getAllExamList();
		model.put("examList", examList);
		model.addAttribute("css", css);
		model.addAttribute("message", message);
		return "examList";
	}
}
