package com.digi.unitouch.emailScheduler;

import java.util.Date;

public class EmailTriggerVo {
	
	private Integer articleId;
	private String articleTitle;
	private String articleName;
	private String title;
	private String Issuetld;
	private Integer taskId;
	private String taskName;
	private String ManuscriptId;
	private String JournalName;
	private String FirstName;
	private String LastName;
	private String Name;
	private String dueDate;
	private String Default_editor;
	private String url;
	private String etTo;
	private String etBcc;
	private String etCc;
	private String etSubject;
	private String etBody;
	private String status;
	private String createdBy;
	private Date createdAt;
	private String authorityName;
	
	
	public String getName() {
		return Name;
	}
	public void setName(String name) {
		Name = name;
	}
	public String getDefault_editor() {
		return Default_editor;
	}
	public void setDefault_editor(String default_editor) {
		Default_editor = default_editor;
	}
	public String getArticleName() {
		return articleName;
	}
	public void setArticleName(String articleName) {
		this.articleName = articleName;
	}
	public String getArticleTitle() {
		return articleTitle;
	}
	public void setArticleTitle(String articleTitle) {
		this.articleTitle = articleTitle;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getIssuetld() {
		return Issuetld;
	}
	public void setIssuetld(String issuetld) {
		Issuetld = issuetld;
	}
	
	public String getDueDate() {
		return dueDate;
	}
	public void setDueDate(String dueDate) {
		this.dueDate = dueDate;
	}
	public Integer getArticleId() {
		return articleId;
	}
	public void setArticleId(Integer articleId) {
		this.articleId = articleId;
	}
	public Integer getTaskId() {
		return taskId;
	}
	public void setTaskId(Integer taskId) {
		this.taskId = taskId;
	}
	public String getTaskName() {
		return taskName;
	}
	public void setTaskName(String taskName) {
		this.taskName = taskName;
	}
	public String getManuscriptId() {
		return ManuscriptId;
	}
	public void setManuscriptId(String manuscriptId) {
		ManuscriptId = manuscriptId;
	}
	public String getJournalName() {
		return JournalName;
	}
	public void setJournalName(String journalName) {
		JournalName = journalName;
	}
	public String getFirstName() {
		return FirstName;
	}
	public void setFirstName(String firstName) {
		FirstName = firstName;
	}
	public String getLastName() {
		return LastName;
	}
	public void setLastName(String lastName) {
		LastName = lastName;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public String getEtTo() {
		return etTo;
	}
	public void setEtTo(String etTo) {
		this.etTo = etTo;
	}
	public String getEtBcc() {
		return etBcc;
	}
	public void setEtBcc(String etBcc) {
		this.etBcc = etBcc;
	}
	public String getEtCc() {
		return etCc;
	}
	public void setEtCc(String etCc) {
		this.etCc = etCc;
	}
	public String getEtSubject() {
		return etSubject;
	}
	public void setEtSubject(String etSubject) {
		this.etSubject = etSubject;
	}
	public String getEtBody() {
		return etBody;
	}
	public void setEtBody(String etBody) {
		this.etBody = etBody;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getCreatedBy() {
		return createdBy;
	}
	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}
	public Date getCreatedAt() {
		return createdAt;
	}
	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}
	
	public String getAuthorityName() {
		return authorityName;
	}
	public void setAuthorityName(String authorityName) {
		this.authorityName = authorityName;
	}
	@Override
	public String toString() {
		return "EmailTriggerVo [articleId=" + articleId + ", articleTitle=" + articleTitle + ", articleName="
				+ articleName + ", title=" + title + ", Issuetld=" + Issuetld + ", taskId=" + taskId + ", taskName="
				+ taskName + ", ManuscriptId=" + ManuscriptId + ", JournalName=" + JournalName + ", FirstName="
				+ FirstName + ", LastName=" + LastName + ", Name=" + Name + ", dueDate=" + dueDate + ", Default_editor="
				+ Default_editor + ", url=" + url + ", etTo=" + etTo + ", etBcc=" + etBcc + ", etCc=" + etCc
				+ ", etSubject=" + etSubject + ", etBody=" + etBody + ", status=" + status + ", createdBy=" + createdBy
				+ ", createdAt=" + createdAt + ", authorityName=" + authorityName + "]";
	}
	
}
