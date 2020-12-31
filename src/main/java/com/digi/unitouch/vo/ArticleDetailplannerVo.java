package com.digi.unitouch.vo;

public class ArticleDetailplannerVo {

	private Integer article_id;
	
	private String article_title;
	
	private String article_doi;
	
	private String aid;
	
	private String article_type_cd;

	private String journalName;
	
	private String publisherName;
	
	private Integer workflow_id;
	
	private Integer task_id;
	
	private String DeptName;
	
	private String task_status;

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

	public Integer getWorkflow_id() {
		return workflow_id;
	}

	public void setWorkflow_id(Integer workflow_id) {
		this.workflow_id = workflow_id;
	}

	public Integer getTask_id() {
		return task_id;
	}

	public void setTask_id(Integer task_id) {
		this.task_id = task_id;
	}

	public String getDeptName() {
		return DeptName;
	}

	public void setDeptName(String deptName) {
		DeptName = deptName;
	}

	public String getTask_status() {
		return task_status;
	}

	public void setTask_status(String task_status) {
		this.task_status = task_status;
	}

	public ArticleDetailplannerVo(Integer article_id, String article_title, String article_doi, String aid,
			String article_type_cd, String journalName, String publisherName, Integer workflow_id, Integer task_id,
			String deptName, String task_status) {
		super();
		this.article_id = article_id;
		this.article_title = article_title;
		this.article_doi = article_doi;
		this.aid = aid;
		this.article_type_cd = article_type_cd;
		this.journalName = journalName;
		this.publisherName = publisherName;
		this.workflow_id = workflow_id;
		this.task_id = task_id;
		this.DeptName = deptName;
		this.task_status = task_status;
	}




	
	}
