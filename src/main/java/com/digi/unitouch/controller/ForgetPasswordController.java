package com.digi.unitouch.controller;

import java.util.List;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.digi.unitouch.model.Users;
import com.digi.unitouch.repository.UserRepo;
import com.digi.unitouch.service.ForgotPassword;
import com.digi.unitouch.service.UserService;
import com.digi.unitouch.util.LoggerClass;
import com.digi.unitouch.vo.ForgotPasswordVo;

@Controller
public class ForgetPasswordController extends LoggerClass {

	@Autowired
	UserService userService;
//	@Autowired
//	MailService mailService;
	@Autowired
	PasswordEncoder passwordEncoder;
	@Autowired
	Environment env;
	@Autowired
	UserRepo userRepo;
	@Autowired
	ForgotPassword forgotPassword;

	@PostMapping("/forgotPassword")
	public ModelAndView forgotUserPassword(ModelMap model, HttpServletRequest request, Users users) {
		Users existingUser = userRepo.findByUsername(users.getUsername());

		if (existingUser != null) {
			String token = UUID.randomUUID().toString();
			LOGGER.debug(token + "token");
			forgotPassword.sendMailForPassword(users.getUsername(), token);
			model.put("message", "For the reset password link has been sent to  your Email!");
			model.put("css", "success");
			return new ModelAndView("/login");
			//return "redirect:login";
		} else {
			model.put("message", "This email address does not exist!");
			LOGGER.debug("Null :" + users.toString());
			model.put("css", "danger");
			return new ModelAndView("/login");
		}
	}

	private String ForgotPasswaordMailTemplate(String token) {
		StringBuilder builder = new StringBuilder();
		String resetUrl = env.getProperty("resetUrl");
		String resetPasswordURL = resetUrl + "?token=" + token + "";
		builder.append("Dear User\n");
		builder.append("To reset your password, click the link below:\n"
				+ "<input type='button' class='btn btn-danger' value='" + resetPasswordURL + "'>" + resetPasswordURL
				+ "");
		builder.append("\n");
		builder.append("THANK YOU !!");
		return builder.toString();
	}

	@GetMapping("forgotPasswordToken")
	public String forgetpasswordToken(ModelMap model, @RequestParam String token) {
		LOGGER.debug("forgotPasswordToken" + token);
		model.put("token", token);
		return "forgetPasssword";

	}

	@PostMapping("validate")
	public String validateToken( Users user, ModelMap model, HttpServletRequest request,
			@RequestParam("token") String token, BindingResult result) {
		// String token1=user.getToken();
		LOGGER.debug(token);
		List<Users> usersDetailsList = forgotPassword.findUserDetailsByToken(token);
		LOGGER.debug(usersDetailsList.toString() + "\n usersDetailsList ");
		if (usersDetailsList.size() > 0) {
			if (token.equalsIgnoreCase(usersDetailsList.get(0).getToken())) {
				model.put("validation", "valid");
				model.put("token", token);
				model.put("email", usersDetailsList.get(0).getUsername());
				model.put("firstName", usersDetailsList.get(0).getFirstName());
				model.put("lastName", usersDetailsList.get(0).getLastName());
				forgotPassword.saveUpdatedPassword(token, user.getPassword(), usersDetailsList.get(0).getUsername());
			}
		} else {
			model.put("validation", "invalid");
			model.put("message", "URL has been expired.");
		}
		return "redirect:login";
	}

	@PostMapping("resetPassword")
	public String resetPassword(ModelMap model, HttpServletRequest request, Users user) {
		forgotPassword.saveUpdatedPassword(user.getToken(), user.getPassword(), user.getUsername());
		model.put("message", "password has been updated successfully.");
		return "redirect:login";
	}

	@PostMapping("reset")
	public String reset(ModelMap model, HttpServletRequest request, HttpSession session, ForgotPasswordVo forget,RedirectAttributes ra) {
		Users user = userRepo.findByUsername(SecurityContextHolder.getContext().getAuthentication().getName());
		forget.setUsername(user.getUsername());
		if(forgotPassword.checkIfValidOldPassword(user,forget.getPassword())) {
			forgotPassword.resetPassword(user.getUsername(), forget.getNewpassword());
			ra.addAttribute("message", "Password is updated successfully");
			ra.addAttribute("css", "success");
		} else {
			ra.addAttribute("message", "Enter the valid password");
			ra.addAttribute("css", "danger");
		}
	
		return "redirect:dashboard";
	}
}
