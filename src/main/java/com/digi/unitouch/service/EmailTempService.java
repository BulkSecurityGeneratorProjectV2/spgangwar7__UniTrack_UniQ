package com.digi.unitouch.service;

import java.util.List;

import com.digi.unitouch.model.EmailTemp;
import com.digi.unitouch.model.PlaceHolder;

public interface EmailTempService {

	public int saveEmailTemp(EmailTemp emailTemp);

	public String getEmailTemplate();

	String getEmailTemplateID(Integer tempId);

	List<PlaceHolder> getPlaceHolder();

	public EmailTemp getEmailByID(EmailTemp emailTemp);

//	public void deleteEmail(EmailTemp emailTemp);

	public Integer saveNewEmail(EmailTemp emailTemp);

	public List<EmailTemp> getEmailList();

}
