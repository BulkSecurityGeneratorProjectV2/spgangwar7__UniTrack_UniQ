package com.digi.unitouch.vo;

import java.util.Date;



public class ChapterWiseRecordVo {
	private Integer articleId;
	private Date schStartTime;
	public Integer getArticleId() {
		return articleId;
	}
	public void setArticleId(Integer articleId) {
		this.articleId = articleId;
	}
	public Date getSchStartTime() {
		return schStartTime;
	}
	public void setSchStartTime(Date schStartTime) {
		this.schStartTime = schStartTime;
	}
	@Override
	public String toString() {
		return "ChapterWiseRecordVo [articleId=" + articleId + ", schStartTime=" + schStartTime + "]";
	}
	public ChapterWiseRecordVo(Integer articleId, Date schStartTime) {
		super();
		this.articleId = articleId;
		this.schStartTime = schStartTime;
	}
	
	
	
	

	
	
	
	
	
		
	
	}
