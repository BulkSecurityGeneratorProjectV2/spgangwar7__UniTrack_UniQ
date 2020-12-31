package com.digi.unitouch.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="error_process")
public class ErrorProcess {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="err_id")
	private Integer id;
	
	@Column(name="error_name")
	private String errorName;
	
	@Column(name="task_id")
	private Integer taskid;
	
	@Column(name="error_code")
	private String errorCode;
	
	@Column(name="error_time")
	private Date errorTime;


	@OneToOne(optional = false)
	@JoinColumn(name = "task_id",insertable = false,updatable = false)
	private TaskDetails task;
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getErrorName() {
		return errorName;
	}

	public void setErrorName(String errorName) {
		this.errorName = errorName;
	}

	public Integer getTaskid() {
		return taskid;
	}

	public void setTaskid(Integer taskid) {
		this.taskid = taskid;
	}

	public String getErrorCode() {
		return errorCode;
	}

	public void setErrorCode(String errorCode) {
		this.errorCode = errorCode;
	}

	public Date getErrorTime() {
		return errorTime;
	}

	public void setErrorTime(Date errorTime) {
		this.errorTime = errorTime;
	}

	public TaskDetails getTask() {
		return task;
	}

	public void setTask(TaskDetails task) {
		this.task = task;
	}

	@Override
	public String toString() {
		return "ErrorProcess [id=" + id + ", errorName=" + errorName + ", taskid=" + taskid + ", errorCode=" + errorCode
				+ ", errorTime=" + errorTime + ", task=" + task + "]";
	}
	

}
