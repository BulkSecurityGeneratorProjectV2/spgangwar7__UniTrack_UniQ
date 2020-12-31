package com.digi.unitouch.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "issue_tasks_details")
public class IssueTaskDetail {

	public IssueTaskDetail() {
	}

	public IssueTaskDetail(Integer issue_task_dtl_id, Integer issue_task_id, Integer issue_id, Date start_date_time,
			Date completed_date_time, Integer user_id, String task_status) {
		super();
		this.issueTaskDtlId = issue_task_dtl_id;
		this.issueTaskId = issue_task_id;
		this.issueId = issue_id;
		this.startDateTime = start_date_time;
		this.completedDateTime = completed_date_time;
		this.userId = user_id;
		this.taskStatus = task_status;

	}

	@GeneratedValue(strategy = GenerationType.AUTO)
	@Id
	@Column(name = "issue_task_dtl_id")
	private Integer issueTaskDtlId;

	@Column(name = "issue_task_id")
	private Integer issueTaskId;

	@Column(name = "issue_id")
	private Integer issueId;

	@Column(name = "start_date_time")
	private Date startDateTime;

	@Column(name = "completed_date_time")
	private Date completedDateTime;

	@Column(name = "user_id")
	private Integer userId;

	@Column(name = "task_status")
	private String taskStatus;

	public Integer getIssueTaskDtlId() {
		return issueTaskDtlId;
	}

	public void setIssueTaskDtlId(Integer issueTaskDtlId) {
		this.issueTaskDtlId = issueTaskDtlId;
	}

	public Integer getIssueTaskId() {
		return issueTaskId;
	}

	public void setIssueTaskId(Integer issueTaskId) {
		this.issueTaskId = issueTaskId;
	}

	public Integer getIssueId() {
		return issueId;
	}

	public void setIssueId(Integer issueId) {
		this.issueId = issueId;
	}

	public Date getStartDateTime() {
		return startDateTime;
	}

	public void setStartDateTime(Date startDateTime) {
		this.startDateTime = startDateTime;
	}

	public Date getCompletedDateTime() {
		return completedDateTime;
	}

	public void setCompletedDateTime(Date completedDateTime) {
		this.completedDateTime = completedDateTime;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public String getTaskStatus() {
		return taskStatus;
	}

	public void setTaskStatus(String taskStatus) {
		this.taskStatus = taskStatus;
	}

}
