package com.digi.unitouch.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.digi.unitouch.model.Menu;
import com.digi.unitouch.model.Role;
import com.digi.unitouch.model.RoleFunction;
import com.digi.unitouch.model.SubMenu;
import com.digi.unitouch.model.UserRole;
import com.digi.unitouch.service.MenuService;
import com.digi.unitouch.service.RoleService;
import com.digi.unitouch.util.LoggerClass;
import com.digi.unitouch.vo.ResponseVo;

@Controller
public class RoleController extends LoggerClass {

	@Autowired
	RoleService roleService;
	@Autowired
	MenuService menuService;
	/*
	 * @Autowired RoleFunctionRepo roleFunctionRepo;
	 */

	@GetMapping("roleDetails")
	public ModelAndView roleDetails(ModelMap model, @ModelAttribute("message") String message,
			@ModelAttribute("css") String css) {
		List<Role> roleList = roleService.getRoleList();
		model.addAttribute("roleList", roleList);
		model.addAttribute("css", css);
		model.addAttribute("message", message);
		return new ModelAndView("role");
	}

	@GetMapping("createNewRole")
	public ModelAndView createNewRole(ModelMap model) {
		List<Menu> menuList = menuService.getAllMenuList();
		model.put("menuList", menuList);
		return new ModelAndView("createRole");
	}

	@PostMapping("saveNewRole")
	public String saveNewRole(Role role, HttpServletRequest request, ModelMap model, RedirectAttributes ra) {
		System.out.println(role.toString());
		String msg = "Role is created successfully";
		String css = "success";
		String name = SecurityContextHolder.getContext().getAuthentication().getName();
		role.setCreatedBy(name);
		try {
			Integer roleid = roleService.saveNewRole(role);
			if (role.getFunction().length == 0) {
				return "role";
			} else {
				for (Integer funId : role.getFunction()) {
					RoleFunction rf = new RoleFunction();
					rf.setRoleId(roleid);
					rf.setFunctionId(funId);
					menuService.saveRoleFunction(rf);
				}
			}

		} catch (DataIntegrityViolationException e) {
			LOGGER.debug("Role is already exist");
			model.addAttribute("css", "danger");
			model.addAttribute("message", "Role is already exist");
			List<Role> roleList = roleService.getRoleList();
			model.addAttribute("roleList", roleList);
			return "role";
		}
//		model.addAttribute("css", "success");
//		model.addAttribute("message", "Role is created successfully");
		ra.addAttribute("message", msg);
		ra.addAttribute("css", css);
		return "redirect:roleDetails";

	}

	@PostMapping("deleteRole")
	public String deleteRole(Role role, HttpServletRequest request, ModelMap model) {
		try {
			roleService.deleteRole(role);
			model.addAttribute("css", "success");
			model.addAttribute("message", "Role deleted successfully");
		} catch (DataIntegrityViolationException e) {
			model.addAttribute("css", "danger");
			model.addAttribute("message", "Groups are associated with this role can't be deleted");
		}
		List<Role> roleList = roleService.getRoleList();
		model.addAttribute("roleList", roleList);

		return "role";
	}

	@PostMapping("editRoleDetails")
	public ModelAndView editRoleDetails(Role role, ModelMap model, HttpServletRequest request) {
		List<Role> roleList = roleService.getRolesByID(role);
		model.addAttribute("roleList", roleList.get(0));

		List<Integer> roleFunctionlist = new ArrayList<Integer>();
		System.out.println("roleList --->" + roleList);
		List<Menu> menuList = menuService.getAllMenuList();
		List<RoleFunction> roleFunction = menuService.getFunctionList(role.getRoleID());

		for (RoleFunction roleFunction2 : roleFunction) {
			roleFunctionlist.add(roleFunction2.getFunctionId());
		}
		System.out.println("roleFunctionlist----->" + roleFunctionlist);
		for (Menu menu : menuList) {
			for (SubMenu sub : menu.getSubMenuList()) {
				for (int i = 0; i < roleFunctionlist.size(); i++) {
					if (roleFunctionlist.get(i) == sub.getId()) {
						sub.setStatus("N");
					}
				}
			}
		}
		model.put("roleWiseMenu", roleFunction);
		System.out.println(menuList);
		model.put("menuList", menuList);
		return new ModelAndView("editRoleDetails");
	}

	@PostMapping("updateRoleDetails")
	public String updateRoleDetails(Role role, HttpServletRequest request, ModelMap model,
			final RedirectAttributes redirectAttributes) {
		String name = SecurityContextHolder.getContext().getAuthentication().getName();
		role.setModifiedBy(name);
		System.out.println("role :"+role.toString());
		try {
			 roleService.saveNewRole(role);
			boolean flage =menuService.deleteRoleFunction(role.getRoleID());
			if(flage) {
			if (role.getFunction().length == 0) {
			} else {
				for (Integer funId : role.getFunction()) {
					RoleFunction rf = new RoleFunction();
					rf.setRoleId(role.getRoleID());
					rf.setFunctionId(funId);
					menuService.saveRoleFunction(rf);
				}
			}
		}else {
			model.addAttribute("css", "danger");
			model.addAttribute("message", "Somthing went wrong ");
		} }
		catch (DataIntegrityViolationException e) {
			LOGGER.debug("Role is already exist");
			// redirectAttributes.addFlashAttribute("css", "danger");
			List<Role> roleList = roleService.getRoleList();
			model.addAttribute("roleList", roleList);
			model.addAttribute("css", "danger");
			model.addAttribute("message", "Role is already exist");
			return "role";
		}
		List<Role> roleList = roleService.getRoleList();
		model.addAttribute("roleList", roleList);
		model.addAttribute("css", "success");
		model.addAttribute("message", role.getRoleName()+"\r\n role is updated successfully");
		return "role";
	}

	
	@PostMapping("getuserListByroleID")
	public @ResponseBody ResponseVo getuserListByDptID(@RequestBody UserRole userrole) {
		ResponseVo responseVo = new ResponseVo();
		responseVo.setResponseText(roleService.getuserListByroleID(userrole));
		return responseVo;

	}
}
