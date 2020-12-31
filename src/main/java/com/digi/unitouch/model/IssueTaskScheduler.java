package com.digi.unitouch.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "issue_scheduled_tasks")
public class IssueTaskScheduler {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "issue_task_id")
	private Integer issueTaskId;//

	@OneToOne(optional = false)
	@JoinColumn(name = "issue_id", insertable = false, updatable = false)
	private IssueDetail issueDetail;

	@Column(name = "issue_id")
	private Integer issueId;

	@Column(name = "workflow_id")
	private Integer workflowId;

	@Column(name = "task_id") //
	private Integer taskId;


	@DateTimeFormat(pattern = "dd-MM-yyyy")
	@Column(name = "task_assigned_date")
	private Date taskAssignedDate;

	@DateTimeFormat(pattern = "dd-MM-yyyy")
	@Column(name = "task_due_date")
	private Date taskDueDate;

	@Column(name = "user_id")
	private Integer userId;

	@DateTimeFormat(pattern = "dd-MM-yyyy")
	@Column(name = "sch_start_time")
	private Date schStartTime;

	@DateTimeFormat(pattern = "dd-MM-yyyy")
	@Column(name = "sch_end_time")
	private Date schEndTime;//
	
	@DateTimeFormat(pattern = "dd-MM-yyyy")
	@Column(name = "task_est_time_from")
	private Date taskEstTimeFrom;
	
	@DateTimeFormat(pattern = "dd-MM-yyyy")
	@Column(name = "task_est_time_end")
	private Date taskEstTimeEnd;

	@Column(name = "task_status")
	private String taskStatus;

	@DateTimeFormat(pattern = "dd-MM-yyyy")
	@Column(name = "created_date")
	private Date createdDate;

	@Column(name = "created_by")
	private Integer createdBy;

	@DateTimeFormat(pattern = "dd-MM-yyyy")
	@Column(name = "updated_date")
	private Date updatedDate;

	@Column(name = "updated_by")
	private Integer updatedBy;

	@Column(name = "task_time_actual")
	private Integer taskTimeActual;

	@Column(name = "run_id")
	private Integer runId;

	@Column(name = "assign_back_count")
	private Integer assignBackCount;

	@Column(name = "assign_reason")
	private String assignReason;

	@Column(name = "rating_star")
	private Integer ratingStar;

	@Column(name = "comments")
	private String comments;

	public Integer getIssueTaskId() {
		return issueTaskId;
	}

	public void setIssueTaskId(Integer issueTaskId) {
		this.issueTaskId = issueTaskId;
	}

	public IssueDetail getIssueDetail() {
		return issueDetail;
	}

	public void setIssueDetail(IssueDetail issueDetail) {
		this.issueDetail = issueDetail;
	}

	public Integer getIssueId() {
		return issueId;
	}

	public void setIssueId(Integer issueId) {
		this.issueId = issueId;
	}

	public Integer getWorkflowId() {
		return workflowId;
	}

	public void setWorkflowId(Integer workflowId) {
		this.workflowId = workflowId;
	}

	public Integer getTaskId() {
		return taskId;
	}

	public void setTaskId(Integer taskId) {
		this.taskId = taskId;
	}

	public Date getTaskAssignedDate() {
		return taskAssignedDate;
	}

	public void setTaskAssignedDate(Date taskAssignedDate) {
		this.taskAssignedDate = taskAssignedDate;
	}

	public Date getTaskDueDate() {
		return taskDueDate;
	}

	public void setTaskDueDate(Date taskDueDate) {
		this.taskDueDate = taskDueDate;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public Date getSchStartTime() {
		return schStartTime;
	}

	public void setSchStartTime(Date schStartTime) {
		this.schStartTime = schStartTime;
	}

	public Date getSchEndTime() {
		return schEndTime;
	}

	public void setSchEndTime(Date schEndTime) {
		this.schEndTime = schEndTime;
	}

	public Date getTaskEstTimeFrom() {
		return taskEstTimeFrom;
	}

	public void setTaskEstTimeFrom(Date taskEstTimeFrom) {
		this.taskEstTimeFrom = taskEstTimeFrom;
	}

	public Date getTaskEstTimeEnd() {
		return taskEstTimeEnd;
	}

	public void setTaskEstTimeEnd(Date taskEstTimeEnd) {
		this.taskEstTimeEnd = taskEstTimeEnd;
	}

	public String getTaskStatus() {
		return taskStatus;
	}

	public void setTaskStatus(String taskStatus) {
		this.taskStatus = taskStatus;
	}

	public Date getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	public Integer getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(Integer createdBy) {
		this.createdBy = createdBy;
	}

	public Date getUpdatedDate() {
		return updatedDate;
	}

	public void setUpdatedDate(Date updatedDate) {
		this.updatedDate = updatedDate;
	}

	public Integer getUpdatedBy() {
		return updatedBy;
	}

	public void setUpdatedBy(Integer updatedBy) {
		this.updatedBy = updatedBy;
	}

	public Integer getTaskTimeActual() {
		return taskTimeActual;
	}

	public void setTaskTimeActual(Integer taskTimeActual) {
		this.taskTimeActual = taskTimeActual;
	}

	public Integer getRunId() {
		return runId;
	}

	public void setRunId(Integer runId) {
		this.runId = runId;
	}

	public Integer getAssignBackCount() {
		return assignBackCount;
	}

	public void setAssignBackCount(Integer assignBackCount) {
		this.assignBackCount = assignBackCount;
	}

	public String getAssignReason() {
		return assignReason;
	}

	public void setAssignReason(String assignReason) {
		this.assignReason = assignReason;
	}

	public Integer getRatingStar() {
		return ratingStar;
	}

	public void setRatingStar(Integer ratingStar) {
		this.ratingStar = ratingStar;
	}

	public String getComments() {
		return comments;
	}

	public void setComments(String comments) {
		this.comments = comments;
	}

	@Override
	public String toString() {
		return "IssueTaskScheduler [issueTaskId=" + issueTaskId + ", issueDetail=" + issueDetail + ", issueId="
				+ issueId + ", workflowId=" + workflowId + ", taskId=" + taskId + ", taskAssignedDate="
				+ taskAssignedDate + ", taskDueDate=" + taskDueDate + ", userId=" + userId + ", schStartTime="
				+ schStartTime + ", schEndTime=" + schEndTime + ", taskEstTimeFrom=" + taskEstTimeFrom
				+ ", taskEstTimeEnd=" + taskEstTimeEnd + ", taskStatus=" + taskStatus + ", createdDate=" + createdDate
				+ ", createdBy=" + createdBy + ", updatedDate=" + updatedDate + ", updatedBy=" + updatedBy
				+ ", taskTimeActual=" + taskTimeActual + ", runId=" + runId + ", assignBackCount=" + assignBackCount
				+ ", assignReason=" + assignReason + ", ratingStar=" + ratingStar + ", comments=" + comments + "]";
	}

	//

	/*
	 * @Column(name = "task_time_est") private Integer task_time_est;
	 */
	
	

}