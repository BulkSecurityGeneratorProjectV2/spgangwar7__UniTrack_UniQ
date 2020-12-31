package com.digi.unitouch.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.digi.unitouch.model.Department;
import com.digi.unitouch.model.HolidayGroup;
import com.digi.unitouch.model.Role;
import com.digi.unitouch.service.ArticleService;
import com.digi.unitouch.service.DepartmentService;
import com.digi.unitouch.service.HolidayService;
import com.digi.unitouch.service.RoleService;
import com.digi.unitouch.service.TaskManagementService;
import com.digi.unitouch.service.UserService;
import com.digi.unitouch.util.LoggerClass;
import com.digi.unitouch.vo.TaskManagementVoc;
import com.digi.unitouch.vo.TaskManagementVocArt;

@Controller
public class DepartmentController extends LoggerClass {
	
	@Autowired
	DepartmentService deptService;
	
	@Autowired
	RoleService roleService;
	

	@Autowired
	UserService userService;
	
	@Autowired
	TaskManagementService taskManagementService;
	
	@Autowired
	ArticleService articleService;
	
	@Autowired
	HolidayService holidayService;
	
	@GetMapping("deptDetails")
	public ModelAndView department(ModelMap model) {
		List<Department> deptDetails = deptService.getDepartmentsList();
		LOGGER.debug("deptDetails :"+deptDetails);
		model.addAttribute("deptDetails", deptDetails);
		return new ModelAndView("department");
		
	}
	
	@GetMapping("createDept")
	public ModelAndView createUser(ModelMap model) {
		List<Role> roleList = roleService.getRoleList();
		List<HolidayGroup> holidayGroup = holidayService.holiDayGroupList();
		model.addAttribute("holidayGroup", holidayGroup);
		model.addAttribute("roleList", roleList);
	    return new ModelAndView("createDept");
	}
	
	@PostMapping("saveDept")
	public String saveUsers(Department dept,ModelMap model) {
		
		try {
			List<Department> departments =deptService.saveDeptDetails(dept);
			System.out.println(departments.toString());
			
			model.addAttribute("deptDetails", departments);
			
		} catch (DataIntegrityViolationException e) {
			model.addAttribute("css","danger");
			model.addAttribute("message", "Role Assignment is already exist");
			List<Department> deptDetails = deptService.getDepartmentsList();
			model.addAttribute("deptDetails", deptDetails);
			return "department";
		}
		model.addAttribute("css","success");
		model.addAttribute("message", "Role Assignment is created successfully");
		//List<Department> deptDetails = deptService.getDepartmentsList();
		//model.addAttribute("deptDetails", departments);
		return "department";
	}
	
	@PostMapping("editDeptDetails")
	public ModelAndView editUserDetials(Department dept,ModelMap model) {
		List<Department> deptDetails = deptService.getDepartmentsByID(dept);
		model.addAttribute("deptDetails", deptDetails.get(0));
		List<HolidayGroup> holidayGroup = holidayService.holiDayGroupList();
		model.addAttribute("holidayGroup", holidayGroup);
		List<Role> roleList = roleService.getRoleList();
		model.addAttribute("roleList", roleList);
		return new ModelAndView("editDeptDetails");
	}
	
	@PostMapping("updateEditDeptDetails")
	public String updateEditDeptDetails(Department dept,ModelMap model) {
		try {
			deptService.saveDeptDetails(dept);
		} catch (DataIntegrityViolationException e) {
				model.addAttribute("css", "danger");
				model.addAttribute("message", "Role Assignment is already exist");
				List<Department> deptDetails = deptService.getDepartmentsList();
				model.addAttribute("deptDetails", deptDetails);
				return "department";
		}
		model.addAttribute("css", "success");
		model.addAttribute("message", "Role Assignment is updated successfully");
		List<Department> deptDetails = deptService.getDepartmentsList();
		model.addAttribute("deptDetails", deptDetails);
		return "department";
		
	}
	@PostMapping("deleteDept")
	public String deleteUser(Department dept,ModelMap model) {
		
		try {
			deptService.deleteDept(dept);
			model.addAttribute("css", "success");
			model.addAttribute("message", "Role Assignment deleted successfully");
			}
			catch(DataIntegrityViolationException  e) {
				model.addAttribute("css", "danger");
				model.addAttribute("message", "Role Assignment are associated with the User can't be deleted");
			}
		List<Department> deptDetails = deptService.getDepartmentsList();
		model.addAttribute("deptDetails", deptDetails);
		return "department";
		
	}

	
	@GetMapping("supplierdetails")
	public ModelAndView supplierdetails(ModelMap model) throws ParseException {
		//String name = SecurityContextHolder.getContext().getAuthentication().getName();
		//Users users = userService.findUserIdByUserName(name);
		//List<Department> deptDetails = deptService.getDepartmentsList();
		LOGGER.debug("task query");
		List<TaskManagementVoc> taskManagementVo = taskManagementService.getmyTaskManagementLists();
		
		LOGGER.debug("List are  :-"+taskManagementVo);
		int count=0;
		int num = 0;
		
		for (TaskManagementVoc taskManagementVoc : taskManagementVo) {
			
			SimpleDateFormat dtf = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
			Date date = new Date();
			
			
			Date d = dtf.parse(dtf.format(date));
		  
			long currentTime = d.getTime();
			
			LOGGER.debug(dtf.format(date) +" Cr "+currentTime);
			String startDate = dtf.format(taskManagementVoc.getSch_start_time());
			
			Date d1 = dtf.parse(startDate);
			
		    long startDbtime = d1.getTime();
			
			
			LOGGER.debug(startDate + " DB "+startDbtime );
			if (currentTime > startDbtime) {
				count++;
			}
			if (currentTime < startDbtime) {
				num++;
			}
			
			// taskManagementVoc.getSch_start_time();
			
		    }
		    model.put("starttimecount", count);
		    model.put("overdue", num);
		
		    LOGGER.debug(taskManagementVo.toString());
		
	
		   model.put("deptDetails", taskManagementVo);
     	   //model.addAttribute("deptDetails", deptDetails);
		   return new ModelAndView("suplierdetails");
		 
	}
	
		@PostMapping("viewartDetails")
		public String viewArtrec(ModelMap model,HttpServletRequest request) {
			
			String artId =  request.getParameter("articleId");
			LOGGER.debug(artId);
			int articleId = Integer.parseInt(artId);
		
//			String name = SecurityContextHolder.getContext().getAuthentication().getName();
//			String article_title=request.getParameter("article_title");
//			String article_doi=request.getParameter("article_doi");
//			String article_type_cd=request.getParameter("article_type_cd");
//			String publisherName=request.getParameter("publisherName");
//			 model.put("article_title", article_title);
//			 model.put("article_doi", article_doi);
//			 model.put("article_type_cd", article_type_cd);
//			 model.put("publisherName", publisherName);
//			 List<ArticleDetailvo> ArticleDetail = articleService.getArticleDetailList(article_title,article_doi,article_type_cd,publisherName);
			 List <TaskManagementVocArt> ArticleDetailsList = articleService.getArticleDetailListByArtId(articleId);
			 LOGGER.debug("List Are"+ArticleDetailsList);
			 model.put("ArticleDetailsList", ArticleDetailsList);
		
			// LOGGER.debug(ArticleDetail.size());
			return "artList";
		
		}

}
