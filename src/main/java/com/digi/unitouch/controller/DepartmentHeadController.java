package com.digi.unitouch.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.digi.unitouch.model.Department;
import com.digi.unitouch.model.DepartmentHead;
import com.digi.unitouch.model.UserDepartment;
import com.digi.unitouch.repository.UserDepartmentRepo;
import com.digi.unitouch.service.DepartmentService;
import com.digi.unitouch.service.UserService;
import com.digi.unitouch.util.LoggerClass;
import com.digi.unitouch.vo.ResponseVo;
import com.digi.unitouch.vo.UserVo;

@Controller
public class DepartmentHeadController extends LoggerClass {

	@Autowired
	DepartmentService deptService;

	@Autowired
	UserService userService;

	@Autowired
	UserDepartmentRepo userDeptRepo;

	@GetMapping("getDepartmentHead")
	public ModelAndView getDepartmentHead(ModelMap model) {
		List<DepartmentHead> userHeadList = deptService.getDepartmentHeadList();
		System.out.println("userHeadList--------->"+userHeadList);
		model.addAttribute("usrHeadGrpList", userHeadList);
		return new ModelAndView("departmentHead");
	}

	@GetMapping("createDeptHead")
	public ModelAndView createNewDeptHead(ModelMap model) {
		List<Department> deptDetails = deptService.getDepartmentsList();
		model.addAttribute("deptDetails", deptDetails);
		return new ModelAndView("createDeptHead");
	}

	@PostMapping("getuserListByDptID")
	public @ResponseBody ResponseVo getuserListByDptID(@RequestBody UserDepartment userdepartment) {
		ResponseVo responseVo = new ResponseVo();
		responseVo.setResponseText(deptService.getuserListByDepartmentsID(userdepartment));
		return responseVo;

	}

	@PostMapping("saveDepartmentHead")
	public @ResponseBody ResponseVo saveDepartmentHead(@RequestBody DepartmentHead departmentHead) {
		ResponseVo responseVo = new ResponseVo();
		String message = deptService.saveDepartmentHead(departmentHead);
		responseVo.setResponseText(message);
		return responseVo;
	}

	@PostMapping("editDepartmentHead")
	public ModelAndView editDepartmentHead(UserDepartment userDept, ModelMap model) {

		List<UserVo> userList = deptService.getUserNameByDeptID(userDept);
		model.addAttribute("deptID", userList.get(0).getDeptID());
		model.addAttribute("deptName", userList.get(0).getDeptName());
		model.addAttribute("usrHeadGrpList", userList);
		return new ModelAndView("editDeptHead");
	}

	@PostMapping("updateDepartmentHead")
	public String updateDepartmentHead(DepartmentHead departmentHead, HttpServletRequest request, ModelMap model) {
		deptService.updateDepartmentHead(departmentHead);
		List<DepartmentHead> userHeadList = deptService.getDepartmentHeadList();
		model.addAttribute("usrHeadGrpList", userHeadList);
		return "redirect:getDepartmentHead";
	}

	@PostMapping("deleteDepartmentHead")
	public String deleteDepartmentHead(DepartmentHead deptHead) {
		deptService.deleteDepartmentHead(deptHead);
		return "redirect:getDepartmentHead";
	}

}
