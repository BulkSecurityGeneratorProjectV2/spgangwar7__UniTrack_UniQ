package com.digi.unitouch.vo;

import java.util.Arrays;

public class ArticleDetailvo {

	private Integer article_id;
	
	private String article_title;
	
	private String article_doi;
	
	private String aid;
	
	private String article_type_cd;

	private String journalName;
	
	private String publisherName;
	
	private String task_status;
	
	private String issueTitle;

	private Integer taskid;

	private String taskName;

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



	public String getIssueTitle() {
		return issueTitle;
	}

	public void setIssueTitle(String issueTitle) {
		this.issueTitle = issueTitle;
	}

	public Integer getTaskid() {
		return taskid;
	}

	public void setTaskid(Integer taskid) {
		this.taskid = taskid;
	}

	public String getTaskName() {
		return taskName;
	}

	public void setTaskName(String taskName) {
		this.taskName = taskName;
	}

	@Override
	public String toString() {
		return "ArticleDetailvo [article_id=" + article_id + ", article_title=" + article_title + ", article_doi="
				+ article_doi + ", aid=" + aid + ", article_type_cd=" + article_type_cd + ", journalName=" + journalName
				+ ", publisherName=" + publisherName + ", task_status=" + task_status + ", issueTitle=" + issueTitle
				+ "]";
	}

	public ArticleDetailvo(Integer article_id, String article_title, String article_doi, String aid,
			String article_type_cd, String journalName, String publisherName,String task_status) {
		super();
		this.article_id = article_id;
		this.article_title = article_title;
		this.article_doi = article_doi;
		this.aid = aid;
		this.article_type_cd = article_type_cd;
		this.journalName = journalName;
		this.publisherName = publisherName;
		this.task_status=task_status;
	}

	
	public ArticleDetailvo(Integer article_id, String article_title, String article_doi, String aid,
			String article_type_cd, String journalName, String publisherName,String task_status,Integer taskid,String taskName) {
		super();
		this.article_id = article_id;
		this.article_title = article_title;
		this.article_doi = article_doi;
		this.aid = aid;
		this.article_type_cd = article_type_cd;
		this.journalName = journalName;
		this.publisherName = publisherName;
		this.task_status=task_status;
		this.taskid=taskid;
		this.taskName=taskName;
	}
	
	}
