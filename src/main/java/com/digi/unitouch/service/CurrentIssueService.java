package com.digi.unitouch.service;

import com.digi.unitouch.model.CurrentIssueStatus;

public interface CurrentIssueService {
	public CurrentIssueStatus findCurrentIssueStatusBy(int taskID, int issueId);

	Integer saveCurrentIssueS(CurrentIssueStatus currentIssueStatus);

	CurrentIssueStatus findIssuetatusById(int issueId);

}
