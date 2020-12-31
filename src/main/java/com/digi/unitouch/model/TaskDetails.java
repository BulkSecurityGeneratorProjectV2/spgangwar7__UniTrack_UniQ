package com.digi.unitouch.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "tasks")
public class TaskDetails {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "task_id")
	private Integer id;

	@Column(name = "task_name")
	private String taskName;
	
	@Column(name = "created_by")
	private String createdBy;

	@DateTimeFormat(pattern = "dd-MM-yyyy")
	@Column(name = "created_at")
	private Date createdAt;
	
	
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getTaskName() {
		return taskName.replace(" ", "_");
	}

	public void setTaskName(String taskName) {
		this.taskName = taskName.replace(" ", "_");
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

	@Override
	public String toString() {
		return "TaskDetails [id=" + id + ", taskName=" + taskName + ", createdBy="
				+ createdBy + ", createdAt=" + createdAt + "]";
	}

}