package com.digi.unitouch.vo;

public class ArticleDetailsVO {
	
    private Integer article_id;
	
	private String article_title;
	
	private String article_doi;
	
	private String aid;
	
	private String article_type_cd;

	private String journalName;
	
	//private String task_status;
	
	private Integer task_id;
	
	private String taskName;

	private String articleComment;

	
	private String withdrawStatus;
	
	private String accepted_date;
	
	private Integer article_pages;

	private Integer age;
	
	private String reportsDate;

	public String getTaskName() {
		return taskName;
	}

	public void setTaskName(String taskName) {
		this.taskName = taskName;
	}

	public Integer getTask_id() {
		return task_id;
	}

	public void setTask_id(Integer task_id) {
		this.task_id = task_id;
	}

	public String getAccepted_date() {
		return accepted_date;
	}

	public void setAccepted_date(String accepted_date) {
		this.accepted_date = accepted_date;
	}

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


	public String getWithdrawStatus() {
		return withdrawStatus;
	}

	public void setWithdrawStatus(String withdrawStatus) {
		this.withdrawStatus = withdrawStatus;
	}
	

	public Integer getArticle_pages() {
		return article_pages;
	}

	public void setArticle_pages(Integer article_pages) {
		this.article_pages = article_pages;
	}

	
	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public String getReportsDate() {
		return reportsDate;
	}

	public void setReportsDate(String reportsDate) {
		this.reportsDate = reportsDate;
	}

	public String getArticleComment() {
		return articleComment;
	}

	public void setArticleComment(String articleComment) {
		this.articleComment = articleComment;
	}

	public ArticleDetailsVO(Integer article_id, String article_title, String article_doi, String aid,
			String article_type_cd, String journalName, Integer task_id, String withdrawStatus,
			String taskName, String accepted_date) {
		super();
		this.article_id = article_id;
		this.article_title = article_title;
		this.article_doi = article_doi;
		this.aid = aid;
		this.article_type_cd = article_type_cd;
		this.journalName = journalName;
		this.task_id = task_id;
		this.withdrawStatus = withdrawStatus;
		this.taskName = taskName;
		this.accepted_date = accepted_date;
		
	}

	
	public ArticleDetailsVO(Integer article_id, String article_title, String article_doi, String aid,
			String article_type_cd, String journalName, Integer task_id, String withdrawStatus,
			String taskName, String accepted_date,Integer article_pages) {
		super();
		this.article_id = article_id;
		this.article_title = article_title;
		this.article_doi = article_doi;
		this.aid = aid;
		this.article_type_cd = article_type_cd;
		this.journalName = journalName;
		this.task_id = task_id;
		this.withdrawStatus = withdrawStatus;
		this.taskName = taskName;
		this.accepted_date = accepted_date;
		this.article_pages=article_pages;
	}
	
	
	public ArticleDetailsVO(Integer article_id, String article_title, String article_doi, String aid,
			String article_type_cd, String journalName, Integer task_id, String withdrawStatus,
			String taskName, String accepted_date,Integer article_pages,String article_comment) {
		super();
		this.article_id = article_id;
		this.article_title = article_title;
		this.article_doi = article_doi;
		this.aid = aid;
		this.article_type_cd = article_type_cd;
		this.journalName = journalName;
		this.task_id = task_id;
		this.withdrawStatus = withdrawStatus;
		this.taskName = taskName;
		this.accepted_date = accepted_date;
		this.article_pages=article_pages;
		this.articleComment=article_comment;
	}

	public ArticleDetailsVO() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "ArticleDetailsVO [article_id=" + article_id + ", article_title=" + article_title + ", article_doi="
				+ article_doi + ", aid=" + aid + ", article_type_cd=" + article_type_cd + ", journalName=" + journalName
				+ ", task_id=" + task_id + ", taskName=" + taskName + ", withdrawStatus=" + withdrawStatus
				+ ", accepted_date=" + accepted_date + ", article_pages=" + article_pages + "]";
	}

}
