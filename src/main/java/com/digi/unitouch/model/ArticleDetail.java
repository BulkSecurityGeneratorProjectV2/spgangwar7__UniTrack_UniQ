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
import javax.persistence.Transient;


@Entity
@Table(name="article_details")
public class ArticleDetail {

	@GeneratedValue(strategy = GenerationType.AUTO)
	@Id
	@Column(name = "article_id")
	private Integer article_id;
	
	@Column(name = "article_title")
	private String article_title;
	
	@OneToOne(optional = false)
	@JoinColumn(name = "journal_id",insertable = false,updatable = false)
	private Journal journals;
	
	@Column(name = "journal_id")
	private Integer journalId;
	
	@OneToOne(optional = false)
	@JoinColumn(name = "publisher_id",insertable = false,updatable = false)
	private Publisher publisher;
	
	@Column(name = "publisher_id")
	private Integer publisher_id;
	
	@Column(name = "journal_issue_number")
	private String journal_issue_number;
	
	@Column(name = "journal_volume_number")
	private String journal_volume_number;
	
	@Column(name = "article_doi")
	private String article_doi;
	
//	@OneToOne(optional = false)
//	@JoinColumn(name="article_id",insertable = false,updatable = false)
//	private CurrentArticleStatus currnetStatuseArticle;
	
	@Column(name = "aid")
	private String aid;
	
	@Column(name = "article_type_cd")
	private String article_type_cd;
	
	@Column(name = "article_pages")
	private Integer article_pages;

	@Column(name = "color_count")
	private Integer colorImgCount;
	
	@Column(name = "word_count")
	private Integer wordCount;
	
	@Column(name = "article_status")
	private String article_status;
	
	
	@Column(name = "accepted_date")
	private String accepted_date;
	
	
	@Column(name = "article_comment")
	private String article_comment;
	
	@Column(name="priority")
	private String priority;
	
	@Column(name="submission_date")
	private String submissionDate;
	
	@Column(name="Comment_for_production")
	private String CommentoForProduction;
	
	@Column(name="withdraw_status")
	private String withdrawStatus;
	
	@Column(name="rejected_date")
	private Date rejectedDate;
	
	@Column(name = "keywords")
	private String keywords;
	
	@Column(name = "review_date")
	private String review;
	
	
	@Column(name = "subject_noms")
	private String subjectnoms;
	
	@Transient
	private String issueTitle;
	/**
	 * @return the accepted_date
	 */
	public String getAccepted_date() {
		return accepted_date;
	}

	/**
	 * @param accepted_date the accepted_date to set
	 */
	public void setAccepted_date(String accepted_date) {
		this.accepted_date = accepted_date;
	}

	/**
	 * @return the keywords
	 */
	public String getKeywords() {
		return keywords;
	}

	/**
	 * @param keywords the keywords to set
	 */
	public void setKeywords(String keywords) {
		this.keywords = keywords;
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

	public Integer getJournalId() {
		return journalId;
	}

	
	public Journal getJournals() {
		return journals;
	}

	public void setJournals(Journal journals) {
		this.journals = journals;
	}

	public void setJournalId(Integer journalId) {
		this.journalId = journalId;
	}

	public Integer getPublisher_id() {
		return publisher_id;
	}

	public void setPublisher_id(Integer publisher_id) {
		this.publisher_id = publisher_id;
	}

	public String getJournal_issue_number() {
		return journal_issue_number;
	}

	public void setJournal_issue_number(String journal_issue_number) {
		this.journal_issue_number = journal_issue_number;
	}

	public String getJournal_volume_number() {
		return journal_volume_number;
	}

	public void setJournal_volume_number(String journal_volume_number) {
		this.journal_volume_number = journal_volume_number;
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
	public Publisher getPublisher() {
		return publisher;
	}

	public void setPublisher(Publisher publisher) {
		this.publisher = publisher;
	}

	public Integer getArticle_pages() {
		return article_pages;
	}

	public void setArticle_pages(Integer article_pages) {
		this.article_pages = article_pages;
	}

	public String getArticle_status() {
		return article_status;
	}

	public void setArticle_status(String article_status) {
		this.article_status = article_status;
	}


//
//	public CurrentArticleStatus getCurrnetStatuseArticle() {
//		return currnetStatuseArticle;
//	}
//
//	public void setCurrnetStatuseArticle(CurrentArticleStatus currnetStatuseArticle) {
//		this.currnetStatuseArticle = currnetStatuseArticle;
//	}

	public String getArticle_comment() {
		return article_comment;
	}

	public void setArticle_comment(String article_comment) {
		this.article_comment = article_comment;
	}

	public String getPriority() {
		return priority;
	}

	public void setPriority(String priority) {
		this.priority = priority;
	}

	public String getSubmissionDate() {
		return submissionDate;
	}

	public void setSubmissionDate(String submissionDate) {
		this.submissionDate = submissionDate;
	}

	public String getCommentoForProduction() {
		return CommentoForProduction;
	}

	public void setCommentoForProduction(String commentoForProduction) {
		CommentoForProduction = commentoForProduction;
	}

	
	public String getWithdrawStatus() {
		return withdrawStatus;
	}

	public void setWithdrawStatus(String withdrawStatus) {
		this.withdrawStatus = withdrawStatus;
	}

	public Date getRejectedDate() {
		return rejectedDate;
	}

	public void setRejectedDate(Date rejectedDate) {
		this.rejectedDate = rejectedDate;
	}

	public String getIssueTitle() {
		return issueTitle;
	}

	public void setIssueTitle(String issueTitle) {
		this.issueTitle = issueTitle;
	}

	public Integer getColorImgCount() {
		return colorImgCount;
	}

	public void setColorImgCount(Integer colorImgCount) {
		this.colorImgCount = colorImgCount;
	}

	public Integer getWordCount() {
		return wordCount;
	}

	public void setWordCount(Integer wordCount) {
		this.wordCount = wordCount;
	}

	public String getReview() {
		return review;
	}

	public void setReview(String review) {
		this.review = review;
	}
	
	

	public String getSubjectnoms() {
		return subjectnoms;
	}

	public void setSubjectnoms(String subjectnoms) {
		this.subjectnoms = subjectnoms;
	}

	@Override
	public String toString() {
		return "ArticleDetail [article_id=" + article_id + ", article_title=" + article_title + ", journals=" + journals
				+ ", journalId=" + journalId + ", publisher=" + publisher + ", publisher_id=" + publisher_id
				+ ", journal_issue_number=" + journal_issue_number + ", journal_volume_number=" + journal_volume_number
				+ ", article_doi=" + article_doi + ", aid=" + aid + ", article_type_cd=" + article_type_cd
				+ ", article_pages=" + article_pages + ", colorImgCount=" + colorImgCount + ", wordCount=" + wordCount
				+ ", article_status=" + article_status + ", accepted_date=" + accepted_date + ", article_comment="
				+ article_comment + ", priority=" + priority + ", submissionDate=" + submissionDate
				+ ", CommentoForProduction=" + CommentoForProduction + ", withdrawStatus=" + withdrawStatus
				+ ", rejectedDate=" + rejectedDate + ", keywords=" + keywords + ", review=" + review + ", subjectnoms="
				+ subjectnoms + ", issueTitle=" + issueTitle + "]";
	}


}
