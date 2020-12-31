package com.digi.unitouch.service;

import java.util.List;

import com.digi.unitouch.model.IssueEmailTrigger;

public interface IssueEmailTriggerService {

	public void save(IssueEmailTrigger emailTrigger);
	
	public  IssueEmailTrigger findByAJWT(int issueID, int taskID);

	public void allGetData(List<IssueEmailTrigger> emailTrigger);

	public void saveIssueEmailTrigger(IssueEmailTrigger issueemailTrigger);
}
