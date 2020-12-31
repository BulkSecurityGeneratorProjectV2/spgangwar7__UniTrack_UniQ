package com.digi.unitouch.vo;

import java.util.Date;

public class IssueTaskManagementVo
{
	private Integer issue_id;
	
	private Integer journalId;
	
	private String issue_title;
	
	private String taskStatus;
	
	private Date schStartTime;
	
	private Date taskEstTimeFrom;
	
	private Integer issueTaskId;
	
	private String journalAbbrName;
	
	private String taskName;
	
	private String assignReason;
	
	private String comments;
	

	public IssueTaskManagementVo() {
		super();
	}

	public IssueTaskManagementVo(Integer issue_id, Integer journalId, String issue_title, String taskStatus,
			Date schStartTime, Date taskEstTimeFrom, Integer issueTaskId, String journalAbbrName, String taskName) {
		super();
		this.issue_id = issue_id;
		this.journalId = journalId;
		this.issue_title = issue_title;
		this.taskStatus = taskStatus;
		this.schStartTime = schStartTime;
		this.taskEstTimeFrom = taskEstTimeFrom;
		this.issueTaskId = issueTaskId;
		this.journalAbbrName = journalAbbrName;
		this.taskName = taskName;
	}

	public IssueTaskManagementVo(Integer issue_id, Integer journalId,String issue_title, String taskStatus,
			Date schStartTime,Date schEndTime,Integer issueTaskId,String journalAbbrName, String taskName,
			String assignReason,String comments) {
		this.issue_id = issue_id;
		this.journalId = journalId;
		this.issue_title = issue_title;
		this.taskStatus = taskStatus;
		this.schStartTime = schStartTime;
		this.taskEstTimeFrom = schEndTime;
		this.issueTaskId = issueTaskId;
		this.journalAbbrName = journalAbbrName;
		this.taskName = taskName;
		this.assignReason= assignReason;
		this.comments= assignReason;
		
	}
	public Integer getIssue_id() {
		return issue_id;
	}

	public void setIssue_id(Integer issue_id) {
		this.issue_id = issue_id;
	}

	public Integer getJournalId() {
		return journalId;
	}

	public void setJournalId(Integer journalId) {
		this.journalId = journalId;
	}

	public String getIssue_title() {
		return issue_title;
	}

	public void setIssue_title(String issue_title) {
		this.issue_title = issue_title;
	}

	public String getTaskStatus() {
		return taskStatus;
	}

	public void setTaskStatus(String taskStatus) {
		this.taskStatus = taskStatus;
	}

	public Date getSchStartTime() {
		return schStartTime;
	}

	public void setSchStartTime(Date schStartTime) {
		this.schStartTime = schStartTime;
	}

	public Date getTaskEstTimeFrom() {
		return taskEstTimeFrom;
	}

	public void setTaskEstTimeFrom(Date taskEstTimeFrom) {
		this.taskEstTimeFrom = taskEstTimeFrom;
	}

	public Integer getIssueTaskId() {
		return issueTaskId;
	}

	public void setIssueTaskId(Integer issueTaskId) {
		this.issueTaskId = issueTaskId;
	}

	public String getJournalAbbrName() {
		return journalAbbrName;
	}

	public void setJournalAbbrName(String journalAbbrName) {
		this.journalAbbrName = journalAbbrName;
	}

	public String getTaskName() {
		return taskName;
	}

	public void setTaskName(String taskName) {
		this.taskName = taskName;
	}

	
	public String getAssignReason() {
		return assignReason;
	}

	public void setAssignReason(String assignReason) {
		this.assignReason = assignReason;
	}

	public String getComments() {
		return comments;
	}

	public void setComments(String comments) {
		this.comments = comments;
	}

	@Override
	public String toString() {
		return "IssueTaskManagementVo [issue_id=" + issue_id + ", journalId=" + journalId + ", issue_title="
				+ issue_title + ", taskStatus=" + taskStatus + ", schStartTime=" + schStartTime + ", taskEstTimeFrom="
				+ taskEstTimeFrom + ", issueTaskId=" + issueTaskId + ", journalAbbrName=" + journalAbbrName
				+ ", taskName=" + taskName + ", assignReason=" + assignReason + ", comments=" + comments + "]";
	}



	
	
	
}

	
