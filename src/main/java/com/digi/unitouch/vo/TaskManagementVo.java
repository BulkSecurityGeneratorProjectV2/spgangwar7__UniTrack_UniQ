package com.digi.unitouch.vo;

import java.util.Date;

public class TaskManagementVo
{
	private Integer article_id;
	
	private Integer journalId;
	
	private String article_title;
	
	private String task_status;
	
	private Date sch_start_time;
	
	private Date sch_end_time;
	
	private Integer article_task_id;
	
	private String journalAbbrName;
	private String journalName;
	private String accepted_date;
	private String aid;
	
	private String taskName;
	
	private String assign_reason;
	
	private String comments;
	
	private String priority;
	
	private String article_doi;
	
	private String article_type_cd;
	
	private Integer publisher_id;
	
	private String publisherName;
	
	public TaskManagementVo() {}
	
	public Integer getArticle_id() {
		return article_id;
	}

	public void setArticle_id(Integer article_id) {
		this.article_id = article_id;
	}

	public Integer getJournalId() {
		return journalId;
	}

	public void setJournalId(Integer journalId) {
		this.journalId = journalId;
	}

	public String getArticle_title() {
		return article_title;
	}

	public void setArticle_title(String article_title) {
		this.article_title = article_title;
	}

	public String getTask_status() {
		return task_status;
	}

	public void setTask_status(String task_status) {
		this.task_status = task_status;
	}

	public Date getSch_start_time() {
		return sch_start_time;
	}

	public void setSch_start_time(Date sch_start_time) {
		this.sch_start_time = sch_start_time;
	}

	public Date getSch_end_time() {
		return sch_end_time;
	}

	public void setSch_end_time(Date sch_end_time) {
		this.sch_end_time = sch_end_time;
	}

	public Integer getArticle_task_id() {
		return article_task_id;
	}

	public void setArticle_task_id(Integer article_task_id) {
		this.article_task_id = article_task_id;
	}

	public String getJournalAbbrName() {
		return journalAbbrName;
	}

	public void setJournalAbbrName(String journalAbbrName) {
		this.journalAbbrName = journalAbbrName;
	}

	public String getAid() {
		return aid;
	}

	public void setAid(String aid) {
		this.aid = aid;
	}
	
	

	public String getTaskName() {
		return taskName;
	}

	public void setTaskName(String taskName) {
		this.taskName = taskName;
	}

	public String getAssign_reason() {
		return assign_reason;
	}

	public void setAssign_reason(String assign_reason) {
		this.assign_reason = assign_reason;
	}

	public String getComments() {
		return comments;
	}

	public void setComments(String comments) {
		this.comments = comments;
	}
	

	public String getPriority() {
		return priority;
	}

	public void setPriority(String priority) {
		this.priority = priority;
	}

	public String getArticle_doi() {
		return article_doi;
	}

	public void setArticle_doi(String article_doi) {
		this.article_doi = article_doi;
	}

	public String getArticle_type_cd() {
		return article_type_cd;
	}

	public void setArticle_type_cd(String article_type_cd) {
		this.article_type_cd = article_type_cd;
	}

	public Integer getPublisher_id() {
		return publisher_id;
	}

	public void setPublisher_id(Integer publisher_id) {
		this.publisher_id = publisher_id;
	}

	public String getPublisherName() {
		return publisherName;
	}

	public void setPublisherName(String publisherName) {
		this.publisherName = publisherName;
	}

	public String getJournalName() {
		return journalName;
	}

	public void setJournalName(String journalName) {
		this.journalName = journalName;
	}

	public String getAccepted_date() {
		return accepted_date;
	}

	public void setAccepted_date(String accepted_date) {
		this.accepted_date = accepted_date;
	}

	public TaskManagementVo(Integer article_id, Integer journalId, String article_title, String task_status,
			Date sch_start_time, Date sch_end_time, Integer article_task_id, String journalAbbrName, String aid,
			String taskName,String assign_reason,String comments ) {
		super();
		this.article_id = article_id;
		this.journalId = journalId;
		this.article_title = article_title;
		this.task_status = task_status;
		this.sch_start_time = sch_start_time;
		this.sch_end_time = sch_end_time;
		this.article_task_id = article_task_id;
		this.journalAbbrName = journalAbbrName;
		this.aid = aid;
		this.taskName = taskName;
		this.assign_reason=assign_reason;
		this.comments=comments;
		
	}
	
	public TaskManagementVo(Integer article_id, Integer journalId, String article_title, String task_status,
			Date sch_start_time, Date sch_end_time, Integer article_task_id, String journalAbbrName, String aid,
			String taskName) {
		super();
		this.article_id = article_id;
		this.journalId = journalId;
		this.article_title = article_title;
		this.task_status = task_status;
		this.sch_start_time = sch_start_time;
		this.sch_end_time = sch_end_time;
		this.article_task_id = article_task_id;
		this.journalAbbrName = journalAbbrName;
		this.aid = aid;
		this.taskName = taskName;
	
		
	}
//	(ad.article_id,jj.journalId,ad.article_title,ast.task_status,ast.sch_start_time,ast.sch_end_time,ast.article_task_id,
	//jj.journalAbbrName,ad.aid,td.taskName,ad.priority)

	public TaskManagementVo(Integer article_id, Integer journalId, String article_title, String task_status,
			Date sch_start_time, Date sch_end_time, Integer article_task_id, String journalAbbrName,String aid,
			String taskName,String priority) {
		super();
		this.article_id = article_id;
		this.journalId = journalId;
		this.article_title = article_title;
		this.task_status = task_status;
		this.sch_start_time = sch_start_time;
		this.sch_end_time = sch_end_time;
		this.article_task_id = article_task_id;
		this.journalAbbrName = journalAbbrName;
//		this.journalName=journalName;
		this.aid = aid;
		this.taskName = taskName;
		this.priority=priority;
	//	this.accepted_date=accepted_date;
		
	}
	public TaskManagementVo(Integer article_id, Integer journalId, String article_title, String task_status,
			Date sch_start_time, Date sch_end_time, Integer article_task_id, String journalAbbrName,String aid,
			String taskName,String priority,String accepted_date,String article_type_cd) {
		super();
		this.article_id = article_id;
		this.journalId = journalId;
		this.article_title = article_title;
		this.task_status = task_status;
		this.sch_start_time = sch_start_time;
		this.sch_end_time = sch_end_time;
		this.article_task_id = article_task_id;
		this.journalAbbrName = journalAbbrName;
//		this.journalName=journalName;
		this.aid = aid;
		this.taskName = taskName;
		this.priority=priority;
		this.accepted_date=accepted_date;
		this.article_type_cd=article_type_cd;
	}
	//new added 28-05
	public TaskManagementVo(Integer article_id, Integer journalId, String article_title, String task_status,
			Date sch_start_time, Date sch_end_time, Integer article_task_id, String journalAbbrName ,String aid,
			String taskName,String priority,String article_doi, String article_type_cd,Integer publisher_id, String publisherName) {
		super();
		this.article_id = article_id;
		this.journalId = journalId;
		this.article_title = article_title;
		this.task_status = task_status;
		this.sch_start_time = sch_start_time;
		this.sch_end_time = sch_end_time;
		this.article_task_id = article_task_id;
		this.journalAbbrName = journalAbbrName;

		this.aid = aid;
		this.taskName = taskName;
		this.priority = priority;
		this.article_doi= article_doi;
		this.article_type_cd= article_type_cd;
		this.publisher_id = publisher_id;
		this.publisherName = publisherName;

	}
	@Override
	public String toString() {
		return "TaskManagementVo [article_id=" + article_id + ", journalId=" + journalId + ", article_title="
				+ article_title + ", task_status=" + task_status + ", sch_start_time=" + sch_start_time
				+ ", sch_end_time=" + sch_end_time + ", article_task_id=" + article_task_id + ", journalAbbrName="
				+ journalAbbrName + ", journalName=" + journalName + ", accepted_date=" + accepted_date + ", aid=" + aid
				+ ", taskName=" + taskName + ", assign_reason=" + assign_reason + ", comments=" + comments
				+ ", priority=" + priority + ", article_doi=" + article_doi + ", article_type_cd=" + article_type_cd
				+ ", publisher_id=" + publisher_id + ", publisherName=" + publisherName + "]";
	}

	
}

	
