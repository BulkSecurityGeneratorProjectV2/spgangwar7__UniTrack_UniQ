package com.digi.unitouch.vo;

import java.util.Date;



public class LoadReportForcast {


	
	private String article_title;
	
	private String article_doi;
	
    private Date sch_start_time;
    
    private Date sch_end_time;
    
    private String article_type_cd;
    
    private String journal_volume_number;

	public String getArticle_title() {
		return article_title;
	}

	public void setArticle_title(String article_title) {
		this.article_title = article_title;
	}

	public String getArticle_doi() {
		return article_doi;
	}

	public void setArticle_doi(String article_doi) {
		this.article_doi = article_doi;
	}

	public Date getSch_start_time() {
		return sch_start_time;
	}

	public void setSch_start_time(Date sch_start_time) {
		this.sch_start_time = sch_start_time;
	}

	public Date getSch_end_time() {
		return sch_end_time;
	}

	public void setSch_end_time(Date sch_end_time) {
		this.sch_end_time = sch_end_time;
	}

	public String getArticle_type_cd() {
		return article_type_cd;
	}

	public void setArticle_type_cd(String article_type_cd) {
		this.article_type_cd = article_type_cd;
	}

	public String getJournal_volume_number() {
		return journal_volume_number;
	}

	public void setJournal_volume_number(String journal_volume_number) {
		this.journal_volume_number = journal_volume_number;
	}

	public LoadReportForcast(String article_title, String article_doi, Date sch_start_time, Date sch_end_time,
			String article_type_cd, String journal_volume_number) {
		super();
		this.article_title = article_title;
		this.article_doi = article_doi;
		this.sch_start_time = sch_start_time;
		this.sch_end_time = sch_end_time;
		this.article_type_cd = article_type_cd;
		this.journal_volume_number = journal_volume_number;
	}

	@Override
	public String toString() {
		return "LoadReportForcast [article_title=" + article_title + ", article_doi=" + article_doi
				+ ", sch_start_time=" + sch_start_time + ", sch_end_time=" + sch_end_time + ", article_type_cd="
				+ article_type_cd + ", journal_volume_number=" + journal_volume_number + "]";
	}
    
    
	
	
	


	
	
	}
