package com.digi.unitouch.util;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ModelAttribute;

import com.digi.unitouch.model.LoggedUser;
import com.digi.unitouch.service.MenuService;
import com.digi.unitouch.vo.MenuVo;

@ControllerAdvice
public class GlobalControllerAdvice extends LoggerClass {

	@Autowired
	MenuService menuservice;
	
  @ModelAttribute
  public void defalutCall(Model model) {
	  
	 try {
		if (!SecurityContextHolder.getContext().getAuthentication().getPrincipal().toString().equalsIgnoreCase("anonymousUser"))
		 {
			LoggedUser user = (LoggedUser) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
			model.addAttribute("name", user.getFirstName()+" "+user.getLastName());
			model.addAttribute("userinfo",user);
			List<MenuVo> menu = menuservice.getAllMenuforRole(SecurityContextHolder.getContext().getAuthentication().getAuthorities().toString().replaceAll("\\[", "").replaceAll("\\]",""));
			model.addAttribute("menu", menu);
		 }
	} catch (Exception e) {
		LOGGER.error(e.getLocalizedMessage());
	}
  }
}