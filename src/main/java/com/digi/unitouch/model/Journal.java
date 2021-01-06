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
@Table(name = "journals")
public class Journal {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "journal_id")
	private Integer journalId;

	@Column(name = "journal_acronym")
	private String journalAcronym;

	@Column(name = "journal_abbr_name")
	private String journalAbbrName;

	@Column(name = "journal_name")
	private String journalName;

	@Column(name = "publisher_id")
	private Integer publisherId;

	@Column(name = "from_email")
	private String fromEmail;

	@Column(name = "from_password")
	private String fromPassword;
	
	@Column(name = "language")
	private String language;

	@Column(name = "journal_issn")
	private String journalIssn;

	@Column(name="online_issn")
	private String onlineIssn;
	
	@Column(name = "print_issn")
//	@Pattern(regexp="^[a-zA-Z0-9]{3}",message="length must be 3")  
	private String printIssn;

	@Column(name="house_style")
	private String houseStyle;
	
	@Column(name="page_layout")
	private String pageLayout;
	
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

	@Column(name = "partner_contact")
	private String partnerContact;
	
	@Column(name = "copyright_stmt")
	private String copyrightStmt;

	@Column(name = "permissions")
	private String permissions;
	
	@Column(name="publication_type")
	private String publicationType;

	@Column(name = "nbr_of_volume_per_year")
	private Integer nbrOfVolumePerYear;

	@Column(name = "nbr_of_issue_per_year")
	private Integer nbrOfIssuePerYear;

	@Column(name = "last_issue_nbr")
	private Integer lastIssueNbr;

	@Column(name = "annual_page_budget")
	private Integer annualPageBudget;

	@Column(name = "annual_article_budget")
	private Integer annualArticleBudget;

	@Column(name = "author_proofing")
	private String authorProofing;
	
	

	@Column(name = "article_workflow_id")
	private Integer articleWorkflowId;

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
	
	@Column(name = "last_task_id")
	private String lastTaskId;
	
	@Column(name="journal_type")
	private String journalType;
	
	@Column(name="exam_id")
	private Integer examID;

	public Integer getJournalId() {
		return journalId;
	}

	public void setJournalId(Integer journalId) {
		this.journalId = journalId;
	}

	
	public String getPageLayout() {
		return pageLayout;
	}

	public void setPageLayout(String pageLayout) {
		this.pageLayout = pageLayout;
	}

	public String getJournalAcronym() {
		return journalAcronym;
	}

	public void setJournalAcronym(String journalAcronym) {
		this.journalAcronym = journalAcronym;
	}

	public String getJournalAbbrName() {
		return journalAbbrName;
	}

	public void setJournalAbbrName(String journalAbbrName) {
		this.journalAbbrName = journalAbbrName;
	}

	public String getJournalName() {
		return journalName;
	}

	public void setJournalName(String journalName) {
		this.journalName = journalName;
	}

	public Integer getPublisherId() {
		return publisherId;
	}

	public void setPublisherId(Integer publisherId) {
		this.publisherId = publisherId;
	}

	public String getHouseStyle() {
		return houseStyle;
	}

	public void setHouseStyle(String houseStyle) {
		this.houseStyle = houseStyle;
	}

	public String getLanguage() {
		return language;
	}

	public void setLanguage(String language) {
		this.language = language;
	}

	public String getJournalIssn() {
		return journalIssn;
	}

	public void setJournalIssn(String journalIssn) {
		this.journalIssn = journalIssn;
	}

	
	public String getOnlineIssn() {
		return onlineIssn;
	}

	public void setOnlineIssn(String onlineIssn) {
		this.onlineIssn = onlineIssn;
	}

	public String getPrintIssn() {
		return printIssn;
	}

	public void setPrintIssn(String printIssn) {
		this.printIssn = printIssn;
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

	public String getPublicationType() {
		return publicationType;
	}

	public void setPublicationType(String publicationType) {
		this.publicationType = publicationType;
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

	public Integer getAnnualArticleBudget() {
		return annualArticleBudget;
	}

	public void setAnnualArticleBudget(Integer annualArticleBudget) {
		this.annualArticleBudget = annualArticleBudget;
	}

	public String getAuthorProofing() {
		return authorProofing;
	}

	public void setAuthorProofing(String authorProofing) {
		this.authorProofing = authorProofing;
	}

	public Integer getArticleWorkflowId() {
		return articleWorkflowId;
	}

	public void setArticleWorkflowId(Integer articleWorkflowId) {
		this.articleWorkflowId = articleWorkflowId;
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
	
	

	public String getLastTaskId() {
		return lastTaskId;
	}

	public void setLastTaskId(String lastTaskId) {
		this.lastTaskId = lastTaskId;
	}
	

	public String getPartnerContact() {
		return partnerContact;
	}

	public void setPartnerContact(String partnerContact) {
		this.partnerContact = partnerContact;
	}
	

	public String getFromEmail() {
		return fromEmail;
	}

	public void setFromEmail(String fromEmail) {
		this.fromEmail = fromEmail;
	}

	public String getFromPassword() {
		return fromPassword;
	}

	public void setFromPassword(String fromPassword) {
		this.fromPassword = fromPassword;
	}

	public String getJournalType() {
		return journalType;
	}

	public void setJournalType(String journalType) {
		this.journalType = journalType;
	}

	public Integer getExamID() {
		return examID;
	}

	public void setExamID(Integer examID) {
		this.examID = examID;
	}

	@Override
	public String toString() {
		return "Journal [journalId=" + journalId + ", journalAcronym=" + journalAcronym + ", journalAbbrName="
				+ journalAbbrName + ", journalName=" + journalName + ", publisherId=" + publisherId + ", fromEmail="
				+ fromEmail + ", fromPassword=" + fromPassword + ", language=" + language + ", journalIssn="
				+ journalIssn + ", onlineIssn=" + onlineIssn + ", printIssn=" + printIssn + ", houseStyle=" + houseStyle
				+ ", pageLayout=" + pageLayout + ", doiPrefix=" + doiPrefix + ", openAccessStatus=" + openAccessStatus
				+ ", type=" + type + ", subjectId=" + subjectId + ", editorId=" + editorId + ", status=" + status
				+ ", partnerContact=" + partnerContact + ", copyrightStmt=" + copyrightStmt + ", permissions="
				+ permissions + ", publicationType=" + publicationType + ", nbrOfVolumePerYear=" + nbrOfVolumePerYear
				+ ", nbrOfIssuePerYear=" + nbrOfIssuePerYear + ", lastIssueNbr=" + lastIssueNbr + ", annualPageBudget="
				+ annualPageBudget + ", annualArticleBudget=" + annualArticleBudget + ", authorProofing="
				+ authorProofing + ", articleWorkflowId=" + articleWorkflowId + ", issueWorkflowId=" + issueWorkflowId
				+ ", createdAt=" + createdAt + ", createdBy=" + createdBy + ", modifiedAt=" + modifiedAt
				+ ", modifiedBy=" + modifiedBy + ", lastTaskId=" + lastTaskId + ", journalType=" + journalType
				+ ", examID=" + examID + "]";
	}
	
}
