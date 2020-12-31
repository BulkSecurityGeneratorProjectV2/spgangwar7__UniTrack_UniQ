package com.digi.unitouch.service;

import com.digi.unitouch.model.IssueTaskDetail;

public interface IssueTaskDetailService {

	IssueTaskDetail getIssueTaskScheById(Integer taskID);

	void saveIssueTaskDetail(IssueTaskDetail issueTaskDetail);

	IssueTaskDetail getIssueTaskScheById(int Taskid, int issueId);

	

}

