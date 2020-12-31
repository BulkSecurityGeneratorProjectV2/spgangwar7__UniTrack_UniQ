package com.digi.unitouch.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="current_article_status")
public class CurrentArticleStatus {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "cas_id")
	private Integer cas_id;
	
	@Column(name = "article_id")
	private Integer article_id;
	
	@Column(name = "task_id")
	private Integer task_id;
	
	@OneToOne(optional = false)
	@JoinColumn(name = "task_id",insertable = false,updatable = false)
	private TaskDetails task;

	public Integer getCas_id() {
		return cas_id;
	}



	public void setCas_id(Integer cas_id) {
		this.cas_id = cas_id;
	}



	public Integer getArticle_id() {
		return article_id;
	}



	public void setArticle_id(Integer article_id) {
		this.article_id = article_id;
	}



	public Integer getTask_id() {
		return task_id;
	}



	public void setTask_id(Integer task_id) {
		this.task_id = task_id;
	}



	public TaskDetails getTask() {
		return task;
	}



	public void setTask(TaskDetails task) {
		this.task = task;
	}



	@Override
	public String toString() {
		return "CurrentArticleStatus [cas_id=" + cas_id + ", article_id=" + article_id + ", task_id=" + task_id
				+ ", task=" + task + "]";
	}





}
