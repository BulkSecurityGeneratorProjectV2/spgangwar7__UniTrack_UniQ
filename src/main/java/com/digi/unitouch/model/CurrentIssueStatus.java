package com.digi.unitouch.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "current_issue_status")
public class CurrentIssueStatus {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "cis_id")
	private Integer cis_id;

	@Column(name = "issue_id")
	private Integer issueId;

	@Column(name = "task_id")
	private Integer taskId;

	public Integer getCis_id() {
		return cis_id;
	}

	public void setCis_id(Integer cis_id) {
		this.cis_id = cis_id;
	}

	public Integer getIssueId() {
		return issueId;
	}

	public void setIssueId(Integer issueId) {
		this.issueId = issueId;
	}

	public Integer getTaskId() {
		return taskId;
	}

	public void setTaskId(Integer taskId) {
		this.taskId = taskId;
	}

	@Override
	public String toString() {
		return "CurrentIssueStatus [cis_id=" + cis_id + ", issueId=" + issueId + ", taskId=" + taskId + "]";
	}

}
