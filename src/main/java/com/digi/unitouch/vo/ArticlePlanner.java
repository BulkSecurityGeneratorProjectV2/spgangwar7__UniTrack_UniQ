package com.digi.unitouch.vo;

import java.util.Date;



public class ArticlePlanner {


	
	private String publ_name;
	
	private String dname;
	
    private String wname;
    
    private String journal_name;
    
    private String aid;
    
    private String article_title;
    
    private String task_status;
    
    private Date sch_start_time;
    
    private Date sch_end_time;

	public String getPubl_name() {
		return publ_name;
	}

	public void setPubl_name(String publ_name) {
		this.publ_name = publ_name;
	}

	public String getDname() {
		return dname;
	}

	public void setDname(String dname) {
		this.dname = dname;
	}

	public String getWname() {
		return wname;
	}

	public void setWname(String wname) {
		this.wname = wname;
	}

	public String getJournal_name() {
		return journal_name;
	}

	public void setJournal_name(String journal_name) {
		this.journal_name = journal_name;
	}

	public String getAid() {
		return aid;
	}

	public void setAid(String aid) {
		this.aid = aid;
	}

	public String getArticle_title() {
		return article_title;
	}

	public void setArticle_title(String article_title) {
		this.article_title = article_title;
	}

	public String getTask_status() {
		return task_status;
	}

	public void setTask_status(String task_status) {
		this.task_status = task_status;
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

	public ArticlePlanner(String publ_name, String dname, String wname, String journal_name, String aid,
			String article_title, String task_status, Date sch_start_time, Date sch_end_time) {
		super();
		this.publ_name = publ_name;
		this.dname = dname;
		this.wname = wname;
		this.journal_name = journal_name;
		this.aid = aid;
		this.article_title = article_title;
		this.task_status = task_status;
		this.sch_start_time = sch_start_time;
		this.sch_end_time = sch_end_time;
	}

	@Override
	public String toString() {
		return "ArticlePlanner [publ_name=" + publ_name + ", dname=" + dname + ", wname=" + wname + ", journal_name="
				+ journal_name + ", aid=" + aid + ", article_title=" + article_title + ", task_status=" + task_status
				+ ", sch_start_time=" + sch_start_time + ", sch_end_time=" + sch_end_time + "]";
	}

	
	
	
	
	}
