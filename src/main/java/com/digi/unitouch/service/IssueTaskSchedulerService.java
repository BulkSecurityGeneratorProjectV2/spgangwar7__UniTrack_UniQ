package com.digi.unitouch.service;

import java.util.List;

import com.digi.unitouch.model.IssueTaskScheduler;

public interface IssueTaskSchedulerService {

	void saveTaskSchedulars(IssueTaskScheduler tschedule);

	IssueTaskScheduler getIssueTaskScheById(Integer issueTaskId);

	IssueTaskScheduler getIssueSchedulerDetail(int issueID, int nextTaskID);

	void changeIssueTaskStatusUserDel(int issueId, int taskid, int workFlowID, String taskStatus);
	
	public void changeIssueTaskStatus(int issueId, int taskid, int workFlowID, String taskStatus);

	List<IssueTaskScheduler> getIssueCompleteDetail();

	public List<IssueTaskScheduler> getIssueSchedulerDetailByIssueID(Integer issueID);

	

}
