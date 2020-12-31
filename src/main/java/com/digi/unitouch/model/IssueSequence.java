package com.digi.unitouch.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name = "issue_sequence_publication")
public class IssueSequence {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	private Integer ispId;

	@Column(name = "cover_article_id")
	private String coverArticleId;

	@Column(name = "issue_id")
	private Integer issueId;

	@ManyToOne
	@JoinColumn(name = "issue_id", insertable = false, updatable = false)
	private IssueDetail issue;

	@Column(name = "sequence")
	private Integer sequenceNo;

	@Column(name = "colorimage")
	private String colorimage;
	
	@Column(name = "bwimage")
	private String bwimage;
	
	@Column(name = "journal_id")
	private Integer jId;

	@ManyToOne
	@JoinColumn(name = "journal_id", insertable = false, updatable = false)
	private Journal journals;

	@Column(name = "article_doi")
	private String articleDoi;

	@Column(name = "read_only")
	private String readOnly;

	@Column(name = "file_flag")
	private String fileFlag;

	@Column(name = "file_path")
	private String filePath;

	@Column(name = "page_number")
	private String pages;

	@Column(name = "to_page")
	private Integer to_page;

	@Column(name = "page_from")
	private Integer page_from;

	@Column(name = "article_title")
	private String articletitle;

	@ManyToOne
	@JoinColumn(name = "workflow_id", insertable = false, updatable = false)
	private Workflow workflows;

	@Column(name = "workflow_id")
	private Integer workflowid;

	@Column(name = "created_by")
	private String createdBy;

	@Column(name = "created_at")
	private Date createdAt;

	@Column(name = "updated_by")
	private String updatedBy;

	@Column(name = "updated_at")
	private String updatedAt;

	@Column(name = "issue_file_id")
	private Integer issueFileId;
	
	@OneToOne
	@JoinColumn(name = "issue_file_id", insertable = false, updatable = false)
	private IssueFileVersion issueFile;
	
	
	@Column(name = "article_type_cd")
	private String article_type_cd;
	
	@Transient
	private String articlComment;
	
	@Transient
	private String taskName;

	public Integer getIspId() {
		return ispId;
	}

	public void setIspId(Integer ispId) {
		this.ispId = ispId;
	}

	public String getCoverArticleId() {
		return coverArticleId;
	}

	public void setCoverArticleId(String coverArticleId) {
		this.coverArticleId = coverArticleId;
	}

	public Integer getIssueId() {
		return issueId;
	}

	public void setIssueId(Integer issueId) {
		this.issueId = issueId;
	}

	public IssueDetail getIssue() {
		return issue;
	}

	public void setIssue(IssueDetail issue) {
		this.issue = issue;
	}

	public Integer getSequenceNo() {
		return sequenceNo;
	}

	public void setSequenceNo(Integer sequenceNo) {
		this.sequenceNo = sequenceNo;
	}

	public Integer getjId() {
		return jId;
	}

	public void setjId(Integer jId) {
		this.jId = jId;
	}

	public String getArticleDoi() {
		return articleDoi;
	}

	public void setArticleDoi(String articleDoi) {
		this.articleDoi = articleDoi;
	}

	public String getReadOnly() {
		return readOnly;
	}

	public void setReadOnly(String readOnly) {
		this.readOnly = readOnly;
	}

	public String getFileFlag() {
		return fileFlag;
	}

	public void setFileFlag(String fileFlag) {
		this.fileFlag = fileFlag;
	}

	public String getFilePath() {
		return filePath;
	}

	public void setFilePath(String filePath) {
		this.filePath = filePath;
	}

	public String getPages() {
		return pages;
	}

	public void setPages(String pages) {
		this.pages = pages;
	}

	public String getArticletitle() {
		return articletitle;
	}

	public void setArticletitle(String articletitle) {
		this.articletitle = articletitle;
	}

	public Integer getWorkflowid() {
		return workflowid;
	}

	public void setWorkflowid(Integer workflowid) {
		this.workflowid = workflowid;
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

	public String getUpdatedBy() {
		return updatedBy;
	}

	public void setUpdatedBy(String updatedBy) {
		this.updatedBy = updatedBy;
	}

	public String getUpdatedAt() {
		return updatedAt;
	}

	public void setUpdatedAt(String updatedAt) {
		this.updatedAt = updatedAt;
	}

	public Journal getJournals() {
		return journals;
	}

	public void setJournals(Journal journals) {
		this.journals = journals;
	}

	public Workflow getWorkflows() {
		return workflows;
	}

	public void setWorkflows(Workflow workflows) {
		this.workflows = workflows;
	}

	public Integer getTo_page() {
		return to_page;
	}

	public void setTo_page(Integer to_page) {
		this.to_page = to_page;
	}

	public Integer getPage_from() {
		return page_from;
	}

	public void setPage_from(Integer page_from) {
		this.page_from = page_from;
	}

	public Integer getIssueFileId() {
		return issueFileId;
	}

	public void setIssueFileId(Integer issueFileId) {
		this.issueFileId = issueFileId;
	}

	public IssueFileVersion getIssueFile() {
		return issueFile;
	}

	public void setIssueFile(IssueFileVersion issueFile) {
		this.issueFile = issueFile;
	}
	

	public String getColorimage() {
		return colorimage;
	}

	public void setColorimage(String colorimage) {
		this.colorimage = colorimage;
	}

	public String getBwimage() {
		return bwimage;
	}

	public void setBwimage(String bwimage) {
		this.bwimage = bwimage;
	}

	public String getArticlComment() {
		return articlComment;
	}

	public void setArticlComment(String articlComment) {
		this.articlComment = articlComment;
	}
	
	

	public String getArticle_type_cd() {
		return article_type_cd;
	}

	public void setArticle_type_cd(String article_type_cd) {
		this.article_type_cd = article_type_cd;
	}

	public String getTaskName() {
		return taskName;
	}

	public void setTaskName(String taskName) {
		this.taskName = taskName;
	}

	@Override
	public String toString() {
		return "IssueSequence [ispId=" + ispId + ", coverArticleId=" + coverArticleId + ", issueId=" + issueId
				+ ", issue=" + issue + ", sequenceNo=" + sequenceNo + ", colorimage=" + colorimage + ", bwimage="
				+ bwimage + ", jId=" + jId + ", journals=" + journals + ", articleDoi=" + articleDoi + ", readOnly="
				+ readOnly + ", fileFlag=" + fileFlag + ", filePath=" + filePath + ", pages=" + pages + ", to_page="
				+ to_page + ", page_from=" + page_from + ", articletitle=" + articletitle + ", workflows=" + workflows
				+ ", workflowid=" + workflowid + ", createdBy=" + createdBy + ", createdAt=" + createdAt
				+ ", updatedBy=" + updatedBy + ", updatedAt=" + updatedAt + ", issueFileId=" + issueFileId
				+ ", issueFile=" + issueFile + ", article_type_cd=" + article_type_cd + ", articlComment="
				+ articlComment + "]";
	}


}
