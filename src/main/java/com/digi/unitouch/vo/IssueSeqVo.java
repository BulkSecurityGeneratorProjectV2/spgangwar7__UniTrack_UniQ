package com.digi.unitouch.vo;

import java.util.Arrays;

import org.springframework.web.multipart.MultipartFile;

public class IssueSeqVo {

	private String artID;
	private String articleId;
	private String articletitle;
	private Integer pages;
	private String articleDOI;
	private String atStatusCoverid;
	private Integer workflowid;
	private Integer jId;
	private Integer issueId;
	private MultipartFile attachmentCover[];
	
	
	
	public MultipartFile[] getAttachmentCover() {
		return attachmentCover;
	}

	public void setAttachmentCover(MultipartFile[] attachmentCover) {
		this.attachmentCover = attachmentCover;
	}

	public String getArtID() {
		return artID;
	}

	public void setArtID(String artID) {
		this.artID = artID;
	}

	public String getArticleId() {
		return articleId;
	}

	public void setArticleId(String articleId) {
		this.articleId = articleId;
	}

	public String getArticletitle() {
		return articletitle;
	}

	public void setArticletitle(String articletitle) {
		this.articletitle = articletitle;
	}

	public Integer getPages() {
		return pages;
	}

	public void setPages(Integer pages) {
		this.pages = pages;
	}

	public String getArticleDOI() {
		return articleDOI;
	}

	public void setArticleDOI(String articleDOI) {
		this.articleDOI = articleDOI;
	}

	
	public String getAtStatusCoverid() {
		return atStatusCoverid;
	}

	public void setAtStatusCoverid(String atStatusCoverid) {
		this.atStatusCoverid = atStatusCoverid;
	}

	public Integer getWorkflowid() {
		return workflowid;
	}

	public void setWorkflowid(Integer workflowid) {
		this.workflowid = workflowid;
	}

	public Integer getjId() {
		return jId;
	}

	public void setjId(Integer jId) {
		this.jId = jId;
	}

	public Integer getIssueId() {
		return issueId;
	}

	public void setIssueId(Integer issueId) {
		this.issueId = issueId;
	}

	@Override
	public String toString() {
		return "IssueSeqVo [artID=" + artID + ", articleId=" + articleId + ", articletitle=" + articletitle + ", pages="
				+ pages + ", articleDOI=" + articleDOI + ", atStatusCoverid=" + atStatusCoverid + ", workflowid="
				+ workflowid + ", jId=" + jId + ", issueId=" + issueId + ", attachmentCover="
				+ Arrays.toString(attachmentCover) + "]";
	}





}
