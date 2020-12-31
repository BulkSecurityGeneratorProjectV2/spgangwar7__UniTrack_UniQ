package com.digi.unitouch.vo;

public class ArticleDetailvoByDept {

	private Integer article_id;
	
	private String article_title;
	
	private String article_doi;
	
	private String aid;
	
	private String article_type_cd;

	private String journalName;
	
	private String publisherName;
	 
	private Integer deptId;

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

	
	public Integer getDeptId() {
		return deptId;
	}

	public void setDeptId(Integer deptId) {
		this.deptId = deptId;
	}

	

	@Override
	public String toString() {
		return "ArticleDetailvoByDept [article_id=" + article_id + ", article_title=" + article_title + ", article_doi="
				+ article_doi + ", aid=" + aid + ", article_type_cd=" + article_type_cd + ", journalName=" + journalName
				+ ", publisherName=" + publisherName + ", deptId=" + deptId + "]";
	}

	public ArticleDetailvoByDept(Integer article_id, String article_title, String article_doi, String aid,
			String article_type_cd, String journalName, String publisherName, Integer deptId) {
		super();
		this.article_id = article_id;
		this.article_title = article_title;
		this.article_doi = article_doi;
		this.aid = aid;
		this.article_type_cd = article_type_cd;
		this.journalName = journalName;
		this.publisherName = publisherName;
		this.deptId = deptId;
	}

	
	}
