package com.digi.unitouch.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "article_tasks_details")
public class ArticleTaskDetail {

	public ArticleTaskDetail() {
	}

	public ArticleTaskDetail(Integer article_task_dtl_id, Integer article_task_id, Integer article_id,
			Date start_date_time, Date completed_date_time, Integer user_id, String task_status) {
		super();
		this.article_task_dtl_id = article_task_dtl_id;
		this.article_task_id = article_task_id;
		this.article_id = article_id;
		this.start_date_time = start_date_time;
		this.completed_date_time = completed_date_time;
		this.user_id = user_id;
		this.task_status = task_status;
	}

	@GeneratedValue(strategy = GenerationType.AUTO)
	@Id
	@Column(name = "article_task_dtl_id")
	private Integer article_task_dtl_id;

	@Column(name = "article_task_id")
	private Integer article_task_id;

	@Column(name = "article_id")
	private Integer article_id;

	@Column(name = "start_date_time")
	private Date start_date_time;

	@Column(name = "completed_date_time")
	private Date completed_date_time;

	@Column(name = "user_id")
	private Integer user_id;

	@Column(name = "task_status")
	private String task_status;

	public Integer getArticle_task_dtl_id() {
		return article_task_dtl_id;
	}

	public void setArticle_task_dtl_id(Integer article_task_dtl_id) {
		this.article_task_dtl_id = article_task_dtl_id;
	}

	public Integer getArticle_task_id() {
		return article_task_id;
	}

	public void setArticle_task_id(Integer article_task_id) {
		this.article_task_id = article_task_id;
	}

	public Integer getArticle_id() {
		return article_id;
	}

	public void setArticle_id(Integer article_id) {
		this.article_id = article_id;
	}

	public Date getStart_date_time() {
		return start_date_time;
	}

	public void setStart_date_time(Date start_date_time) {
		this.start_date_time = start_date_time;
	}

	public Date getCompleted_date_time() {
		return completed_date_time;
	}

	public void setCompleted_date_time(Date completed_date_time) {
		this.completed_date_time = completed_date_time;
	}

	public Integer getUser_id() {
		return user_id;
	}

	public void setUser_id(Integer user_id) {
		this.user_id = user_id;
	}

	public String getTask_status() {
		return task_status;
	}

	public void setTask_status(String task_status) {
		this.task_status = task_status;
	}

	@Override
	public String toString() {
		return "ArticleTaskDetail [article_task_dtl_id=" + article_task_dtl_id + ", article_task_id=" + article_task_id
				+ ", article_id=" + article_id + ", start_date_time=" + start_date_time + ", completed_date_time="
				+ completed_date_time + ", user_id=" + user_id + ", task_status=" + task_status + "]";
	}

}
