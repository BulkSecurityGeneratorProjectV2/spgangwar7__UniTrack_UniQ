package com.digi.unitouch.vo;

import java.util.Date;



public class ArticleDetailHavingOverloadvo {

	private Integer article_id;
	
	private String article_title;
	
	private String article_doi;
	
	private String aid;
	
	private String article_type_cd;

	private String journalName;
	
	private String publisherName;
	
	private String task_status;
	
	private String task_name;
	
	private Date sch_end_time;

	public Integer getArticle_id() {
		return article_id;
	}

	public void setArticle_id(Integer article_id) {
		this.article_id = article_id;
	}

	public String getArticle_title() {
		return article_title;
	}

	public void setArticle_title(String article_title) {
		this.article_title = article_title;
	}

	public String getArticle_doi() {
		return article_doi;
	}

	public void setArticle_doi(String article_doi) {
		this.article_doi = article_doi;
	}

	public String getAid() {
		return aid;
	}

	public void setAid(String aid) {
		this.aid = aid;
	}

	public String getArticle_type_cd() {
		return article_type_cd;
	}

	public void setArticle_type_cd(String article_type_cd) {
		this.article_type_cd = article_type_cd;
	}

	public String getJournalName() {
		return journalName;
	}

	public void setJournalName(String journalName) {
		this.journalName = journalName;
	}

	public String getPublisherName() {
		return publisherName;
	}

	public void setPublisherName(String publisherName) {
		this.publisherName = publisherName;
	}

	public String getTask_status() {
		return task_status;
	}

	public void setTask_status(String task_status) {
		this.task_status = task_status;
	}

	public Date getSch_end_time() {
		return sch_end_time;
	}

	public void setSch_end_time(Date sch_end_time) {
		this.sch_end_time = sch_end_time;
	}

	/**
	 * @return the task_name
	 */
	public String getTask_name() {
		return task_name;
	}

	/**
	 * @param task_name the task_name to set
	 */
	public void setTask_name(String task_name) {
		this.task_name = task_name;
	}

	@Override
	public String toString() {
		return "ArticleDetailHavingOverloadvo [article_id=" + article_id + ", article_title=" + article_title
				+ ", article_doi=" + article_doi + ", aid=" + aid + ", article_type_cd=" + article_type_cd
				+ ", journalName=" + journalName + ", publisherName=" + publisherName + ", task_status=" + task_status
				+ ", sch_end_time=" + sch_end_time + "]";
	}

	public ArticleDetailHavingOverloadvo(Integer article_id, String article_title, String article_doi, String aid,
			String article_type_cd, String journalName, String publisherName, String task_status, Date sch_end_time) {
		super();
		this.article_id = article_id;
		this.article_title = article_title;
		this.article_doi = article_doi;
		this.aid = aid;
		this.article_type_cd = article_type_cd;
		this.journalName = journalName;
		this.publisherName = publisherName;
		this.task_status = task_status;
		this.sch_end_time = sch_end_time;
		
	}
	
	public ArticleDetailHavingOverloadvo(Integer article_id, String article_title, String article_doi, String aid,
			String article_type_cd, String journalName, String publisherName, String task_status, Date sch_end_time, String task_name) {
		super();
		this.article_id = article_id;
		this.article_title = article_title;
		this.article_doi = article_doi;
		this.aid = aid;
		this.article_type_cd = article_type_cd;
		this.journalName = journalName;
		this.publisherName = publisherName;
		this.task_status = task_status;
		this.sch_end_time = sch_end_time;
		this.task_name=task_name;
		
	}

	}
