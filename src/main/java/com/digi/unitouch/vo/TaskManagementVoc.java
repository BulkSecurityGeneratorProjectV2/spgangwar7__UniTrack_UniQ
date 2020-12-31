package com.digi.unitouch.vo;

import java.util.Date;

public class TaskManagementVoc
{
	private Long count;
	
	private Integer article_id;
	
	private Integer journalId;
	
	private String publ_name;
	
	private String task_name;
	
	private String task_status;
	
	private String suplliername;
	
	private String article_title;
	
	private Date sch_start_time;
	
	private Date sch_end_time;
	
	private String journal_name;
	
	private String article_doi;
	
	private String article_type_cd;
	
	private String first_name;
	
	private String last_name;
	
	private Date start_date_time;
	
	private Date completed_date_time;

	
	
	public TaskManagementVoc(Long count, Integer article_id, Integer journalId, String publ_name, String task_name,
			String task_status, String suplliername, String article_title, Date sch_start_time, Date sch_end_time,
			String journal_name, String article_doi, String article_type_cd, String first_name, String last_name,
			Date start_date_time, Date completed_date_time) {
		//super();
		this.count = count;
		this.article_id = article_id;
		this.journalId = journalId;
		this.publ_name = publ_name;
		this.task_name = task_name;
		this.task_status = task_status;
		this.suplliername = suplliername;
		this.article_title = article_title;
		this.sch_start_time = sch_start_time;
		this.sch_end_time = sch_end_time;
		this.journal_name = journal_name;
		this.article_doi = article_doi;
		this.article_type_cd = article_type_cd;
		this.first_name = first_name;
		this.last_name = last_name;
		this.start_date_time = start_date_time;
		this.completed_date_time = completed_date_time;
	}



	public Long getCount() {
		return count;
	}

	public void setCount(Long count) {
		this.count = count;
	}

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

	public String getPubl_name() {
		return publ_name;
	}

	public void setPubl_name(String publ_name) {
		this.publ_name = publ_name;
	}

	public String getTask_name() {
		return task_name;
	}

	public void setTask_name(String task_name) {
		this.task_name = task_name;
	}

	public String getTask_status() {
		return task_status;
	}

	public void setTask_status(String task_status) {
		this.task_status = task_status;
	}

	public String getSuplliername() {
		return suplliername;
	}

	public void setSuplliername(String suplliername) {
		this.suplliername = suplliername;
	}

	public String getArticle_title() {
		return article_title;
	}

	public void setArticle_title(String article_title) {
		this.article_title = article_title;
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

	public String getJournal_name() {
		return journal_name;
	}

	public void setJournal_name(String journal_name) {
		this.journal_name = journal_name;
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

	public String getFirst_name() {
		return first_name;
	}

	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}

	public String getLast_name() {
		return last_name;
	}

	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}

	public Date getStart_date_time() {
		return start_date_time;
	}

	public void setStart_date_time(Date start_date_time) {
		this.start_date_time = start_date_time;
	}

	public Date getCompleted_date_time() {
		return completed_date_time;
	}

	public void setCompleted_date_time(Date completed_date_time) {
		this.completed_date_time = completed_date_time;
	}




	@Override
	public String toString() {
		return "TaskManagementVoc [count=" + count + ", article_id=" + article_id + ", journalId=" + journalId
				+ ", publ_name=" + publ_name + ", task_name=" + task_name + ", task_status=" + task_status
				+ ", suplliername=" + suplliername + ", article_title=" + article_title + ", sch_start_time="
				+ sch_start_time + ", sch_end_time=" + sch_end_time + ", journal_name=" + journal_name
				+ ", article_doi=" + article_doi + ", article_type_cd=" + article_type_cd + ", first_name=" + first_name
				+ ", last_name=" + last_name + ", start_date_time=" + start_date_time + ", completed_date_time="
				+ completed_date_time + "]";
	}


	
	
		

	
}

	
