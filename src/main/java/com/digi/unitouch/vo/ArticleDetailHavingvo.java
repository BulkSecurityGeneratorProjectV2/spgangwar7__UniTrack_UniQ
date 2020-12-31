package com.digi.unitouch.vo;

public class ArticleDetailHavingvo {

	private Integer article_id;
	
	private String article_title;
	
	private String article_doi;
	
	private String aid;
	
	private String article_type_cd;

	private String journal_name;
	
	private String publ_name;
	
	private String task_status;

	/**
	 * @return the article_id
	 */
	public Integer getArticle_id() {
		return article_id;
	}

	/**
	 * @param article_id the article_id to set
	 */
	public void setArticle_id(Integer article_id) {
		this.article_id = article_id;
	}

	/**
	 * @return the article_title
	 */
	public String getArticle_title() {
		return article_title;
	}

	/**
	 * @param article_title the article_title to set
	 */
	public void setArticle_title(String article_title) {
		this.article_title = article_title;
	}

	/**
	 * @return the article_doi
	 */
	public String getArticle_doi() {
		return article_doi;
	}

	/**
	 * @param article_doi the article_doi to set
	 */
	public void setArticle_doi(String article_doi) {
		this.article_doi = article_doi;
	}

	/**
	 * @return the aid
	 */
	public String getAid() {
		return aid;
	}

	/**
	 * @param aid the aid to set
	 */
	public void setAid(String aid) {
		this.aid = aid;
	}

	/**
	 * @return the article_type_cd
	 */
	public String getArticle_type_cd() {
		return article_type_cd;
	}

	/**
	 * @param article_type_cd the article_type_cd to set
	 */
	public void setArticle_type_cd(String article_type_cd) {
		this.article_type_cd = article_type_cd;
	}

	/**
	 * @return the journal_name
	 */
	public String getJournal_name() {
		return journal_name;
	}

	/**
	 * @param journal_name the journal_name to set
	 */
	public void setJournal_name(String journal_name) {
		this.journal_name = journal_name;
	}

	/**
	 * @return the publ_name
	 */
	public String getPubl_name() {
		return publ_name;
	}

	/**
	 * @param publ_name the publ_name to set
	 */
	public void setPubl_name(String publ_name) {
		this.publ_name = publ_name;
	}

	/**
	 * @return the task_status
	 */
	public String getTask_status() {
		return task_status;
	}

	/**
	 * @param task_status the task_status to set
	 */
	public void setTask_status(String task_status) {
		this.task_status = task_status;
	}

	public ArticleDetailHavingvo(Integer article_id, String article_title, String article_doi, String aid,
			String article_type_cd, String journal_name, String publ_name, String task_status) {
		super();
		this.article_id = article_id;
		this.article_title = article_title;
		this.article_doi = article_doi;
		this.aid = aid;
		this.article_type_cd = article_type_cd;
		this.journal_name = journal_name;
		this.publ_name = publ_name;
		this.task_status = task_status;
	}



	
	}
