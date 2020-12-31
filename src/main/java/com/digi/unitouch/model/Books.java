package com.digi.unitouch.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

@Entity
@Table(name = "books")
public class Books {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "book_id")
	private Integer bookId;

	@Column(name = "book_acronym")
	private String bookAcronym;

	@Column(name = "book_abbr_name")
	private String bookAbbrName;

	@Column(name = "book_name")
	private String bookName;

	@Column(name = "publisher_id")
	private Integer publisherId;

	@Column(name = "language")
	private String language;

	@Column(name = "book_issb")
	private String bookIssb;

	@Column(name = "print_issb")
	private String printIssb;

	@Column(name = "doi_prefix")
	private String doiPrefix;

	@Column(name = "open_access_status")
	private String openAccessStatus;

	@Column(name = "type")
	private String type;

	@Column(name = "subject_id")
	private Integer subjectId;

	@Column(name = "editor_id")
	private Integer editorId;

	@Column(name = "status")
	private String status;

	@Column(name = "copyright_stmt")
	private String copyrightStmt;

	@Column(name = "permissions")
	private String permissions;

	@Column(name = "nbr_of_volume_per_year")
	private Integer nbrOfVolumePerYear;

	@Column(name = "nbr_of_issue_per_year")
	private Integer nbrOfIssuePerYear;

	@Column(name = "last_issue_nbr")
	private Integer lastIssueNbr;

	@Column(name = "annual_page_budget")
	private Integer annualPageBudget;

	@Column(name = "annual_book_budget")
	private Integer annualbookBudget;

	@Column(name = "author_proofing")
	private String authorProofing;

	@Column(name = "book_workflow_id")
	private Integer bookWorkflowId;

	@Column(name = "issue_workflow_id")
	private Integer issueWorkflowId;

	@CreationTimestamp
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "created_at")
	private Date createdAt;

	@Column(name = "created_by")
	private String createdBy;

	@UpdateTimestamp
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "modified_at")
	private Date modifiedAt;

	@Column(name = "modifiedBy")
	private String modifiedBy;

	public Integer getBookId() {
		return bookId;
	}

	public void setBookId(Integer bookId) {
		this.bookId = bookId;
	}

	public String getBookAcronym() {
		return bookAcronym;
	}

	public void setBookAcronym(String bookAcronym) {
		this.bookAcronym = bookAcronym;
	}

	public String getBookAbbrName() {
		return bookAbbrName;
	}

	public void setBookAbbrName(String bookAbbrName) {
		this.bookAbbrName = bookAbbrName;
	}

	public String getBookName() {
		return bookName;
	}

	public void setBookName(String bookName) {
		this.bookName = bookName;
	}

	public Integer getPublisherId() {
		return publisherId;
	}

	public void setPublisherId(Integer publisherId) {
		this.publisherId = publisherId;
	}

	public String getLanguage() {
		return language;
	}

	public void setLanguage(String language) {
		this.language = language;
	}

	public String getBookIssb() {
		return bookIssb;
	}

	public void setBookIssb(String bookIssb) {
		this.bookIssb = bookIssb;
	}

	public String getPrintIssb() {
		return printIssb;
	}

	public void setPrintIssb(String printIssb) {
		this.printIssb = printIssb;
	}

	public String getDoiPrefix() {
		return doiPrefix;
	}

	public void setDoiPrefix(String doiPrefix) {
		this.doiPrefix = doiPrefix;
	}

	public String getOpenAccessStatus() {
		return openAccessStatus;
	}

	public void setOpenAccessStatus(String openAccessStatus) {
		this.openAccessStatus = openAccessStatus;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public Integer getSubjectId() {
		return subjectId;
	}

	public void setSubjectId(Integer subjectId) {
		this.subjectId = subjectId;
	}

	public Integer getEditorId() {
		return editorId;
	}

	public void setEditorId(Integer editorId) {
		this.editorId = editorId;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getCopyrightStmt() {
		return copyrightStmt;
	}

	public void setCopyrightStmt(String copyrightStmt) {
		this.copyrightStmt = copyrightStmt;
	}

	public String getPermissions() {
		return permissions;
	}

	public void setPermissions(String permissions) {
		this.permissions = permissions;
	}

	public Integer getNbrOfVolumePerYear() {
		return nbrOfVolumePerYear;
	}

	public void setNbrOfVolumePerYear(Integer nbrOfVolumePerYear) {
		this.nbrOfVolumePerYear = nbrOfVolumePerYear;
	}

	public Integer getNbrOfIssuePerYear() {
		return nbrOfIssuePerYear;
	}

	public void setNbrOfIssuePerYear(Integer nbrOfIssuePerYear) {
		this.nbrOfIssuePerYear = nbrOfIssuePerYear;
	}

	public Integer getLastIssueNbr() {
		return lastIssueNbr;
	}

	public void setLastIssueNbr(Integer lastIssueNbr) {
		this.lastIssueNbr = lastIssueNbr;
	}

	public Integer getAnnualPageBudget() {
		return annualPageBudget;
	}

	public void setAnnualPageBudget(Integer annualPageBudget) {
		this.annualPageBudget = annualPageBudget;
	}

	public Integer getAnnualbookBudget() {
		return annualbookBudget;
	}

	public void setAnnualbookBudget(Integer annualbookBudget) {
		this.annualbookBudget = annualbookBudget;
	}

	public String getAuthorProofing() {
		return authorProofing;
	}

	public void setAuthorProofing(String authorProofing) {
		this.authorProofing = authorProofing;
	}

	public Integer getBookWorkflowId() {
		return bookWorkflowId;
	}

	public void setBookWorkflowId(Integer bookWorkflowId) {
		this.bookWorkflowId = bookWorkflowId;
	}

	public Integer getIssueWorkflowId() {
		return issueWorkflowId;
	}

	public void setIssueWorkflowId(Integer issueWorkflowId) {
		this.issueWorkflowId = issueWorkflowId;
	}

	public Date getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	public String getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	public Date getModifiedAt() {
		return modifiedAt;
	}

	public void setModifiedAt(Date modifiedAt) {
		this.modifiedAt = modifiedAt;
	}

	public String getModifiedBy() {
		return modifiedBy;
	}

	public void setModifiedBy(String modifiedBy) {
		this.modifiedBy = modifiedBy;
	}

	@Override
	public String toString() {
		return "Books [bookId=" + bookId + ", bookAcronym=" + bookAcronym + ", bookAbbrName=" + bookAbbrName
				+ ", bookName=" + bookName + ", publisherId=" + publisherId + ", language=" + language + ", bookIssb="
				+ bookIssb + ", printIssb=" + printIssb + ", doiPrefix=" + doiPrefix + ", openAccessStatus="
				+ openAccessStatus + ", type=" + type + ", subjectId=" + subjectId + ", editorId=" + editorId
				+ ", status=" + status + ", copyrightStmt=" + copyrightStmt + ", permissions=" + permissions
				+ ", nbrOfVolumePerYear=" + nbrOfVolumePerYear + ", nbrOfIssuePerYear=" + nbrOfIssuePerYear
				+ ", lastIssueNbr=" + lastIssueNbr + ", annualPageBudget=" + annualPageBudget + ", annualbookBudget="
				+ annualbookBudget + ", authorProofing=" + authorProofing + ", bookWorkflowId=" + bookWorkflowId
				+ ", issueWorkflowId=" + issueWorkflowId + ", createdAt=" + createdAt + ", createdBy=" + createdBy
				+ ", modifiedAt=" + modifiedAt + ", modifiedBy=" + modifiedBy + "]";
	}

}
