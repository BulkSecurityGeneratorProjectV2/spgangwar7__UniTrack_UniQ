package com.digi.unitouch.controller;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.digi.unitouch.model.Role;
import com.digi.unitouch.model.Users;
import com.digi.unitouch.service.DepartmentService;
import com.digi.unitouch.service.RoleService;
import com.digi.unitouch.service.UserRoleService;
import com.digi.unitouch.service.UserService;
import com.digi.unitouch.util.LoggerClass;
import com.digi.unitouch.vo.EditJournalWorkflowVO;
import com.digi.unitouch.vo.ResponseVo;
import com.digi.unitouch.vo.UpdateUserVo;
import com.digi.unitouch.vo.UserRoleVo;

@Controller
public class UserController extends LoggerClass {

	@Autowired
	UserService userService;

	@Autowired
	DepartmentService deptService;

	@Autowired
	UserRoleService userRoleService;
	
	@Autowired
	RoleService roleService;

	@GetMapping("userDetails")
	public ModelAndView getUsers(ModelMap model, @ModelAttribute("message") String message,
			@ModelAttribute("css") String css) {
		List<Users> userDetails = userService.getUsers();
		LOGGER.debug("/userDetails------------size> : " + userDetails.size());
		model.addAttribute("userDetails", userDetails);
		model.addAttribute("css", css);
		model.addAttribute("message", message);
		return new ModelAndView("user");
	}

	@GetMapping("createUser")
	public ModelAndView createUser(ModelMap model) {
		List<Role> roleList = roleService.getRoleList();
		model.addAttribute("roleList", roleList);
		return new ModelAndView("createUser");
	}

	@PostMapping("saveUsers")
	public String saveUsers(Users user, HttpServletRequest request, ModelMap model, RedirectAttributes ra) {
		LOGGER.debug("user :: " + user.toString());
		String msg = "";
		String css = "";
		try {
			msg = userService.saveUser(user);
			if (msg.equalsIgnoreCase("User's email already exist. It must be unique")) {
				css = "danger";
			} else {
				css = "success";
			}
		} catch (DataIntegrityViolationException e) {
			model.addAttribute("css", "danger");
			model.addAttribute("message", "User's email already exist. It must be unique");
			List<Users> userDetails = userService.getUsers();
			model.addAttribute("userDetails", userDetails);
			ra.addAttribute("message", "User profile updated successfully");
			ra.addAttribute("css", "success");
			return "user";
		}
		ra.addAttribute("message", msg);
		ra.addAttribute("css", css);
		return "redirect:userDetails";
	}

	@PostMapping("editUser")
	public ModelAndView editUserDetials(Users user, ModelMap model, HttpServletRequest request) {
		List<Users> userDetails = userService.getUsersByID(user);
		model.addAttribute("userDetails", userDetails.get(0));
		model.addAttribute("roleN", userDetails.get(0).getRole());
		List<Role> roleList = roleService.getRoleList();
		model.addAttribute("roleList", roleList);
		return new ModelAndView("editUserDetails");
	}

	@PostMapping("updateUserDetails")
	public String updateUserDetails(Users user, ModelMap model, RedirectAttributes ra) {
		String msg = "";
		String css = "";
		try {
			msg = userService.updateUser(user);
			if (msg.equalsIgnoreCase("User's email already exist. It must be unique")) {
				css = "danger";
			} else {
				css = "success";
			}
		} catch (DataIntegrityViolationException e) {
			model.addAttribute("css", "danger");
			model.addAttribute("message", "User's email already exist. It must be unique");
			List<Users> userDetails = userService.getUsers();
			model.addAttribute("userDetails", userDetails);
			return "user";
		}
		ra.addAttribute("message", msg);
		ra.addAttribute("css", css);
		return "redirect:userDetails";
	}

	@PostMapping("deleteUser")
	public String deleteUser(Users user, ModelMap model) {

		try {
			userService.deleteUser(user);
			model.addAttribute("css", "success");
			model.addAttribute("message", "User deleted successfully");
		} catch (Exception e) {
			model.addAttribute("css", "danger");
			model.addAttribute("message", "Oops!! something Went wrong..please try after sometime");

		}
		List<Users> userDetails = userService.getUsers();
		model.addAttribute("userDetails", userDetails);
		return "user";
	}

	@PostMapping("departmentlistbyrole")
	public @ResponseBody ResponseVo departmentListByRole(@RequestBody Role role) {
		ResponseVo responseVo = new ResponseVo();
		responseVo.setResponseText(deptService.getDepartmentByRoleID(role.getRoleID()));
		return responseVo;

	}

	@PostMapping("updateUser")
	public String updateUser(UpdateUserVo updateUser, ModelMap model, RedirectAttributes ra) {
		try {
			System.out.println(updateUser.toString());
			Users gUser = userService.findUserIdByUserName(updateUser.getUpdateUserEmail());
			gUser.setFirstName(updateUser.getUpdateUserFname());
			gUser.setLastName(updateUser.getUpdateLastName());
			userService.updateUserProfile(gUser);
			ra.addAttribute("message", "User profile updated successfully");
			ra.addAttribute("css", "success");
		} catch (DataIntegrityViolationException e) {

			return "redirect:dashboard";
		}
		return "redirect:dashboard";
	}
	
	@PostMapping("userlistbyrole")
	public @ResponseBody ResponseVo userlistbyrole(@RequestBody EditJournalWorkflowVO role) {
		ResponseVo responseVo = new ResponseVo();
		System.out.println(role.toString());
		StringBuilder str= new StringBuilder();
		List<UserRoleVo> finalList= new ArrayList<UserRoleVo>();
		List<UserRoleVo> userRole=userRoleService.usersbyRoleId(role.getRoleId());
		Iterator<UserRoleVo> iteratorUser = userRole.iterator();
		str.append("<select class=\"custom-select\" name=user_id>");
		while (iteratorUser.hasNext()) {
			UserRoleVo userRoleVo = iteratorUser.next();
			finalList.add(userRoleVo);
			
			str.append("<option value="+userRoleVo.getUserid()+" >"+userRoleVo.getFastName()+" "+userRoleVo.getLastName()+"</option>");
			
		}
		str.append("<input type=hidden name=id value="+role.getMjwId()+">");
		str.append("<input type=hidden name=task_id value="+role.getTaskId()+">");
		str.append("</select>");
		responseVo.setResponseText(str+"");
		return responseVo;

	}
}
