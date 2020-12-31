package com.digi.unitouch.model;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;


@Entity
@Table(name="issue_details")
public class IssueDetail {

	@GeneratedValue(strategy = GenerationType.AUTO)
	@Id
	@Column(name = "issue_id")
	private Integer issue_id;
	
	@Column(name = "issue_title")
	private String issue_title;
	
	@Column(name = "issue_seq_no")
	private Integer issueSeqNo;
	
	@OneToOne(optional = false)
	@JoinColumn(name = "journal_id",insertable = false,updatable = false)
	private Journal journals;
	
	@Column(name = "journal_id")
	private Integer journalId;
	
	@OneToOne(optional = false)
	@JoinColumn(name = "publisher_id",insertable = false,updatable = false)
	private Publisher publisher;
	
	@OneToMany(fetch = FetchType.EAGER)
	@JoinColumn(name="issue_id")
	private List<IssueArticle> isssueArticle;
	
	@Column(name = "publisher_id")
	private Integer publisher_id;
	
	@Column(name = "issue_workflow")
	private String issue_workflow;
	
	@Column(name = "last_volume_number")
	private String last_volume_number;
	
	@Column(name = "last_issue_number")
	private String last_issue_number;
	
	@Column(name = "volume_year")
	private String volume_year;
	
	@Column(name = "number_of_volume_per_year")
	private String number_of_volume_per_year;
	
	@Column(name = "number_of_issue_per_year")
	private String number_of_issue_per_year;
	
	@Column(name = "annual_page_budget")
	private String annual_page_budget;
	
	@Column(name = "annual_article_budget")
	private String annual_article_budget;
	
	@Column(name = "production_time_target")
	private String production_time_target;
	
	@Column(name = "create_date")
	private Date create_date;

	@Column(name="issue_status")
	private String issueStatus;
	
	@Column(name="is_supplementary")
	private String isSupplementary;
	
	@Column(name="is_scheduled")
	private String isScheduled;

	public Integer getIssue_id() {
		return issue_id;
	}

	public void setIssue_id(Integer issue_id) {
		this.issue_id = issue_id;
	}

	public String getIssue_title() {
		return issue_title;
	}

	public Integer getIssueSeqNo() {
		return issueSeqNo;
	}

	public void setIssueSeqNo(Integer issueSeqNo) {
		this.issueSeqNo = issueSeqNo;
	}

	public void setIssue_title(String issue_title) {
		this.issue_title = issue_title;
	}

	public Journal getJournals() {
		return journals;
	}

	public void setJournals(Journal journals) {
		this.journals = journals;
	}

	public Integer getJournalId() {
		return journalId;
	}

	public void setJournalId(Integer journalId) {
		this.journalId = journalId;
	}

	public Publisher getPublisher() {
		return publisher;
	}

	public void setPublisher(Publisher publisher) {
		this.publisher = publisher;
	}

	public Integer getPublisher_id() {
		return publisher_id;
	}

	public void setPublisher_id(Integer publisher_id) {
		this.publisher_id = publisher_id;
	}

	public String getIssue_workflow() {
		return issue_workflow;
	}

	public void setIssue_workflow(String issue_workflow) {
		this.issue_workflow = issue_workflow;
	}

	public String getLast_volume_number() {
		return last_volume_number;
	}

	public void setLast_volume_number(String last_volume_number) {
		this.last_volume_number = last_volume_number;
	}

	public String getLast_issue_number() {
		return last_issue_number;
	}

	public void setLast_issue_number(String last_issue_number) {
		this.last_issue_number = last_issue_number;
	}

	public String getVolume_year() {
		return volume_year;
	}

	public void setVolume_year(String volume_year) {
		this.volume_year = volume_year;
	}

	public String getNumber_of_volume_per_year() {
		return number_of_volume_per_year;
	}

	public void setNumber_of_volume_per_year(String number_of_volume_per_year) {
		this.number_of_volume_per_year = number_of_volume_per_year;
	}

	public String getNumber_of_issue_per_year() {
		return number_of_issue_per_year;
	}

	public void setNumber_of_issue_per_year(String number_of_issue_per_year) {
		this.number_of_issue_per_year = number_of_issue_per_year;
	}

	public String getAnnual_page_budget() {
		return annual_page_budget;
	}

	public void setAnnual_page_budget(String annual_page_budget) {
		this.annual_page_budget = annual_page_budget;
	}

	public String getAnnual_article_budget() {
		return annual_article_budget;
	}

	public void setAnnual_article_budget(String annual_article_budget) {
		this.annual_article_budget = annual_article_budget;
	}

	public String getProduction_time_target() {
		return production_time_target;
	}

	public void setProduction_time_target(String production_time_target) {
		this.production_time_target = production_time_target;
	}

	public Date getCreate_date() {
		return create_date;
	}

	public void setCreate_date(Date create_date) {
		this.create_date = create_date;
	}

	
	public List<IssueArticle> getIsssueArticle() {
		return isssueArticle;
	}

	public void setIsssueArticle(List<IssueArticle> isssueArticle) {
		this.isssueArticle = isssueArticle;
	}

	public String getIssue_status() {
		return issueStatus;
	}

	public void setIssue_status(String issue_status) {
		this.issueStatus = issue_status;
	}

	
	public String getIssueStatus() {
		return issueStatus;
	}

	public void setIssueStatus(String issueStatus) {
		this.issueStatus = issueStatus;
	}

	public String getIsSupplementary() {
		return isSupplementary;
	}

	public void setIsSupplementary(String isSupplementary) {
		this.isSupplementary = isSupplementary;
	}
	

	public String getIsScheduled() {
		return isScheduled;
	}

	public void setIsScheduled(String isScheduled) {
		this.isScheduled = isScheduled;
	}

	@Override
	public String toString() {
		return "IssueDetail [issue_id=" + issue_id + ", issue_title=" + issue_title + ", issueSeqNo=" + issueSeqNo
				+ ", journals=" + journals + ", journalId=" + journalId + ", publisher=" + publisher
				+ ", isssueArticle=" + isssueArticle + ", publisher_id=" + publisher_id + ", issue_workflow="
				+ issue_workflow + ", last_volume_number=" + last_volume_number + ", last_issue_number="
				+ last_issue_number + ", volume_year=" + volume_year + ", number_of_volume_per_year="
				+ number_of_volume_per_year + ", number_of_issue_per_year=" + number_of_issue_per_year
				+ ", annual_page_budget=" + annual_page_budget + ", annual_article_budget=" + annual_article_budget
				+ ", production_time_target=" + production_time_target + ", create_date=" + create_date
				+ ", issueStatus=" + issueStatus + ", isSupplementary=" + isSupplementary + ", isScheduled="
				+ isScheduled + "]";
	}


}
