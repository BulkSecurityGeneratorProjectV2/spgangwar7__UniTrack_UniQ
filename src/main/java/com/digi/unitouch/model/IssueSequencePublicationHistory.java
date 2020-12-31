package com.digi.unitouch.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "issue_sequence_publication_history")
public class IssueSequencePublicationHistory {

	@Id
	//@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	private Integer ispId;

	@Column(name = "cover_article_id")
	private String coverArticleId;

	@Column(name = "issue_id")
	private Integer issueId;

	@Column(name = "sequence")
	private Integer sequenceNo;

	@Column(name = "journal_id")
	private Integer jId;
	
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

	@Override
	public String toString() {
		return "issueSequencePublicationHistory [ispId=" + ispId + ", coverArticleId=" + coverArticleId + ", issueId="
				+ issueId + ", sequenceNo=" + sequenceNo + ", jId=" + jId + ", articleDoi=" + articleDoi + ", readOnly="
				+ readOnly + ", fileFlag=" + fileFlag + ", filePath=" + filePath + ", pages=" + pages + ", to_page="
				+ to_page + ", page_from=" + page_from + ", articletitle=" + articletitle + ", workflowid=" + workflowid
				+ ", createdBy=" + createdBy + ", createdAt=" + createdAt + ", updatedBy=" + updatedBy + ", updatedAt="
				+ updatedAt + "]";
	}

	
}
