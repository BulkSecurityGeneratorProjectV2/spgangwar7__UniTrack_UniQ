package com.digi.unitouch.vo;

import java.util.Date;



public class DeliveryDetailsGraphVo {


	
	private Integer JournalId;
	
	private Integer ArticleId;
	
	private String taskStatus;
	
	private Date schStartTime;
	
	private String journalName;

	public Integer getJournalId() {
		return JournalId;
	}

	public void setJournalId(Integer journalId) {
		JournalId = journalId;
	}

	public Integer getArticleId() {
		return ArticleId;
	}

	public void setArticleId(Integer articleId) {
		ArticleId = articleId;
	}

	public String getTaskStatus() {
		return taskStatus;
	}

	public void setTaskStatus(String taskStatus) {
		this.taskStatus = taskStatus;
	}

	public Date getSchStartTime() {
		return schStartTime;
	}

	public void setSchStartTime(Date schStartTime) {
		this.schStartTime = schStartTime;
	}

	public String getJournalName() {
		return journalName;
	}

	public void setJournalName(String journalName) {
		this.journalName = journalName;
	}

	public DeliveryDetailsGraphVo(Integer journalId, Integer articleId, String taskStatus, Date schStartTime,
			String journalName) {
		super();
		JournalId = journalId;
		ArticleId = articleId;
		this.taskStatus = taskStatus;
		this.schStartTime = schStartTime;
		this.journalName = journalName;
	}

	@Override
	public String toString() {
		return "DeliveryDetailsGraphVo [JournalId=" + JournalId + ", ArticleId=" + ArticleId + ", taskStatus="
				+ taskStatus + ", schStartTime=" + schStartTime + ", journalName=" + journalName + "]";
	}
	
	
		
	
	}
