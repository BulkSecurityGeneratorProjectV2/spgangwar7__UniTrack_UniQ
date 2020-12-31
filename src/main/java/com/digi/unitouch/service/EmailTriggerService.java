package com.digi.unitouch.service;

import java.util.List;

import com.digi.unitouch.model.EmailTrigger;
import com.digi.unitouch.model.IssueEmailTrigger;

public interface EmailTriggerService {

	public void save(EmailTrigger emailTrigger);
	
	public  EmailTrigger findByAJWT(int aid, int taskID);

	public void allGetData(List<EmailTrigger> emailTrigger);

	public void saveIssueEmailTrigger(IssueEmailTrigger issueemailTrigger);
}
