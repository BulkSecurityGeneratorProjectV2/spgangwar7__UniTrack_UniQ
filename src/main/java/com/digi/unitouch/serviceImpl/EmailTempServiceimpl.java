package com.digi.unitouch.serviceImpl;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.digi.unitouch.model.EmailTemp;
import com.digi.unitouch.model.PlaceHolder;
import com.digi.unitouch.repository.EmailTempRepo;
import com.digi.unitouch.repository.PlaceHolderRepo;
import com.digi.unitouch.service.EmailTempService;

@Service
@Transactional
public class EmailTempServiceimpl implements EmailTempService {

	@Autowired
	EmailTempRepo emailTempRepo;
	
	@Autowired
	PlaceHolderRepo placeHolderRepo;

	@Override
	public int saveEmailTemp(EmailTemp emailTemp) {
		emailTempRepo.save(emailTemp);
		return emailTemp.getId();
	}

	@Override
	public String getEmailTemplate() {
		StringBuilder builder = new StringBuilder();
		List<EmailTemp> emailtemp = emailTempRepo.findAll();
		builder.append("<label for=\"ExpertiseLevel\">Email Template <sup class=\"text-red\">&lowast;</sup> </label>");
		builder.append("<select  class=\"form-control  \" id=\"emailTempId\" onchange=\"getTemplate()\">");
		builder.append("<option selected=\"selected\">Select Email Template</option>");
		for (EmailTemp emailTemp : emailtemp) {
				builder.append("<option value=\"" + emailTemp.getId() + "\">" + emailTemp.getEmailTempName() + "</option>");
		}
		builder.append("</select>");
		return builder.toString();

	}

	@Override
	public String getEmailTemplateID(Integer tempId) {
		Optional<EmailTemp> emailtemp = emailTempRepo.findById(tempId);
	//	System.out.println(emailtemp.get().getEditorData());
		StringBuilder builder= new StringBuilder();
		builder.append("<div>");
		builder.append("<input id='tempId' type='hidden' value="+emailtemp.get().getId()+"><label  for=\"ExpertiseLevel\"> Email Template :"+emailtemp.get().getEmailTempName()+ "</label>&nbsp;&nbsp;&nbsp;");
		builder.append("<label for=\"ExpertiseLevel\"> Subject :"+emailtemp.get().getToSubject()+ "</label>");
		builder.append("<p>"+emailtemp.get().getEditorData()+"</p>");
		builder.append("</div>");
		return builder.toString();
	}
	
	@Override
	public List<PlaceHolder> getPlaceHolder(){
		return placeHolderRepo.findAll();
	}
	
	@Override
	public EmailTemp getEmailByID(EmailTemp emailTemp) {
		return emailTempRepo.getEmailByID(emailTemp.getId());
	}

//	@Override
//	public void deleteEmail(EmailTemp emailTemp) {
//		System.out.println("Delete call ");
//		//emailTempRepo.delete(emailTemp);
//	}

	@Override
	public Integer saveNewEmail(EmailTemp emailTemp) {
		emailTempRepo.saveAndFlush(emailTemp);
		return emailTemp.getId();
	}
	@Override
	public List<EmailTemp> getEmailList() {
		return emailTempRepo.findAll();
	}

}
