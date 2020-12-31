package com.digi.unitouch.vo;

import java.util.Date;



public class PlannerVo {

	private Long article_count;
	
	private Date date;

	public Long getArticle_count() {
		return article_count;
	}

	public void setArticle_count(Long article_count) {
		this.article_count = article_count;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public PlannerVo(Long article_count, Date date) {
		super();
		this.article_count = article_count;
		this.date = date;
	}
	
	
	
	
	
	}
