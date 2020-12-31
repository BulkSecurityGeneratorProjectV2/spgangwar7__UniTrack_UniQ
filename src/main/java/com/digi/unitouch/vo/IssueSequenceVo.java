package com.digi.unitouch.vo;

import java.util.Date;

import javax.persistence.Column;

public class IssueSequenceVo {

	
	private Integer ispId;
	private String coverArticleId;
	private String issueName;
    private Integer sequenceNo;
	private Integer jId;
	private String journalName;
	private String articleDoi;
	private String readOnly;
	private String fileFlag;
	private String filePath;
    private String pages;
	private Integer to_page;
	private Integer page_from;
	private String colorimage;
	private String articleType;

	private String bwimage;
	private String journalVN;
	private String issueVN;
	private String articletitle;
	private String workflowName;
	private Integer workflowid;
	private String createdBy;
	private Date createdAt;
	private String updatedBy;
    private String updatedAt;
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
	
	public String getIssueName() {
		return issueName;
	}
	public void setIssueName(String issueName) {
		this.issueName = issueName;
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
	public String getJournalName() {
		return journalName;
	}
	public void setJournalName(String journalName) {
		this.journalName = journalName;
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
	public void setPages(String pages) {
		this.pages = pages;
	}
	public String getPages() {
		return pages;
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
	public String getArticletitle() {
		return articletitle;
	}
	public void setArticletitle(String articletitle) {
		this.articletitle = articletitle;
	}
	public String getWorkflowName() {
		return workflowName;
	}
	public void setWorkflowName(String workflowName) {
		this.workflowName = workflowName;
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
	public String getArticleType() {
		return articleType;
	}
	public void setArticleType(String articleType) {
		this.articleType = articleType;
	}
	
	public String getJournalVN() {
		return journalVN;
	}
	public void setJournalVN(String journalVN) {
		this.journalVN = journalVN;
	}
	public String getIssueVN() {
		return issueVN;
	}
	public void setIssueVN(String issueVN) {
		this.issueVN = issueVN;
	}
	@Override
	public String toString() {
		return "IssueSequenceVo [ispId=" + ispId + ", coverArticleId=" + coverArticleId + ", issueName=" + issueName
				+ ", sequenceNo=" + sequenceNo + ", jId=" + jId + ", journalName=" + journalName + ", articleDoi="
				+ articleDoi + ", readOnly=" + readOnly + ", fileFlag=" + fileFlag + ", filePath=" + filePath
				+ ", pages=" + pages + ", to_page=" + to_page + ", page_from=" + page_from + ", colorimage="
				+ colorimage + ", articleType=" + articleType + ", bwimage=" + bwimage + ", journalVN=" + journalVN
				+ ", issueVN=" + issueVN + ", articletitle=" + articletitle + ", workflowName=" + workflowName
				+ ", workflowid=" + workflowid + ", createdBy=" + createdBy + ", createdAt=" + createdAt
				+ ", updatedBy=" + updatedBy + ", updatedAt=" + updatedAt + "]";
	}
	
	

}
