package com.digi.unitouch.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.digi.unitouch.model.EmailTemp;
import com.digi.unitouch.model.PlaceHolder;
import com.digi.unitouch.service.EmailTempService;
import com.digi.unitouch.util.LoggerClass;
import com.digi.unitouch.vo.EmailTempVo;
import com.digi.unitouch.vo.ResponseVo;

@Controller
public class MailTemlpateController extends LoggerClass {

	

	@Autowired
	EmailTempService emailTempService;

	@GetMapping("/getmailtemlate")
	public ModelAndView getMailTem(ModelMap model, @ModelAttribute("message") String message,
			@ModelAttribute("css") String css) {
		model.addAttribute("css", css);
		model.addAttribute("message", message);
		LOGGER.debug("data emaiil----------->getmailtemlate");
		List<PlaceHolder> placeHolder = emailTempService.getPlaceHolder();
		model.put("placeHolder", placeHolder);
		return new ModelAndView("/email/emailtemplate");

	}

	@PostMapping("createEmail")
	public String createEmailTemp(@Valid @ModelAttribute("emailTemp") EmailTempVo emailTempVo,
			BindingResult result, ModelMap model,RedirectAttributes ra) {
		// LOGGER.debug(emailTempVo.toString());
		EmailTemp emailTemp= new EmailTemp();

		emailTemp.setEmailTempName(emailTempVo.getTemplateName());
		emailTemp.setToSubject(emailTempVo.getToSubject());
		emailTemp.setEditorData(emailTempVo.getEditorData());
		emailTemp.setFinishSubject(emailTempVo.getFinishSubject());
		emailTemp.setFinishBody(emailTempVo.getFinishBody());
		emailTemp.setReplySubject(emailTempVo.getReplySubject());
		emailTemp.setReplyBody(emailTempVo.getReplyBody());
		LOGGER.debug("getmailtemlate------------------>"+emailTemp.getEmailTempName());
		int emailId = emailTempService.saveEmailTemp(emailTemp);
		ra.addAttribute("css", "success");
		ra.addAttribute("message", /* emailTempVo.getTemplateName()+" "+ */"Email template is created successfully");
		List<PlaceHolder> placeHolder = emailTempService.getPlaceHolder();
		model.put("placeHolder", placeHolder);
		LOGGER.info("emailTemp  createEmail --->" + emailTempVo.getTemplateName());
		return "redirect:getEmailsDetails";
		//return new ModelAndView("/email/emailtemplate");
	}

	@GetMapping("getEmailTemplate")
	public @ResponseBody ResponseVo getEmailTemplate() {
		ResponseVo responseVo = new ResponseVo();
		responseVo.setResponseText(emailTempService.getEmailTemplate());
		LOGGER.debug("getEmailTemplate------call");
		return responseVo;

	}

	@PostMapping("getEmailTemplateById")
	public @ResponseBody ResponseVo getuserListByDptID(@RequestBody EmailTempVo emailTempVo) {
		ResponseVo responseVo = new ResponseVo();
		responseVo.setResponseText(emailTempService.getEmailTemplateID(emailTempVo.getTempId()));
		LOGGER.info("EmailTemplateById  getEmailTemplateById --->" + responseVo.toString());
		return responseVo;

	}

	@GetMapping("getEmailsDetails")
	public ModelAndView emailsDetails(ModelMap model,@ModelAttribute("message") String message,
			@ModelAttribute("css") String css) {
		List<EmailTemp> emailList = emailTempService.getEmailList();
		model.addAttribute("emailList", emailList);
		LOGGER.info("getEmailsDetails---> getEmailsDetails");
		model.addAttribute("css", css);
		model.addAttribute("message", message);
		return new ModelAndView("email/email");
	}

//	@PostMapping("deleteEmail")
//	public String deleteEmail(EmailTemp emailTemp, HttpServletRequest request, ModelMap model) {
//		LOGGER.info("deleteEmail--->" + emailTemp.toString());
//		LOGGER.info("request--->" + request.toString());
//		//emailTempService.deleteEmail(emailTemp);
//		System.out.println("Delete call ");
//		model.addAttribute("css", "success");
//
//		List<EmailTemp> emailList = emailTempService.getEmailList();
//		model.addAttribute("emailList", emailList);
//
//		return "email/email";
//	}

	@PostMapping("editEmailTemplate")
	public ModelAndView editEmailTemplate(EmailTemp emailTemp, ModelMap model, HttpServletRequest request) {
		EmailTemp emailList = emailTempService.getEmailByID(emailTemp);
		model.addAttribute("emailList", emailList);

		List<PlaceHolder> placeHolder = emailTempService.getPlaceHolder();
		model.put("placeHolder", placeHolder);
		LOGGER.info("editMail Request---> editEmailTemplate----temp name--->" +emailList.getEmailTempName());
		return new ModelAndView("/email/editEmailTemplate");
	}

	@PostMapping("updateEmailDetails")
	public String updateEmailDetails(EmailTempVo emailTempVo, HttpServletRequest request, ModelMap model,
			final RedirectAttributes redirectAttributes) {
//		System.out.println(emailTempVo.toString());
		EmailTemp emailTemp = new EmailTemp();
		emailTemp.setId(emailTempVo.getTempId());
		emailTemp.setEmailTempName(emailTempVo.getTemplateName());
		emailTemp.setToSubject(emailTempVo.getToSubject());
		emailTemp.setEditorData(emailTempVo.getEditorData());
		emailTemp.setFinishSubject(emailTempVo.getFinishSubject());
		emailTemp.setFinishBody(emailTempVo.getFinishBody());
		emailTemp.setReplySubject(emailTempVo.getReplySubject());
		emailTemp.setReplyBody(emailTempVo.getReplyBody());
		emailTempService.saveNewEmail(emailTemp);

		List<EmailTemp> emailList = emailTempService.getEmailList();
		model.addAttribute("emailList", emailList);
		LOGGER.info("emailTempVo Call <------------> updateEmailDetails<---------->" + emailTempVo.getTemplateName());
		model.addAttribute("message", " Email is updated successfully");
		model.addAttribute("css", "success");
		return "email/email";
	}
}