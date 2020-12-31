package com.digi.unitouch.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name = "email_journal_workflow")
public class EmailJournalWorkflow {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "ejw_id")
	private Integer ejwId;

	@Column(name = "jr_id")
	private Integer jrid;

	@Column(name = "wk_id")
	private Integer wkid;

	@Column(name = "email_id")
	private Integer emailId;
	
	@OneToOne
	@JoinColumn(name = "email_id",insertable = false,updatable = false)
	private EmailTemp emailTemp;

	@Column(name = "task_id")
	private Integer taskId;

	@OneToOne(optional = false)
	@JoinColumn(name = "task_id",insertable = false,updatable = false)
	private TaskDetails task;
	
	@Column(name = "role_id")
	private Integer roleId;

	@OneToOne(optional = false)
	@JoinColumn(name = "role_id",insertable = false,updatable = false)
	private Role role;
	
	@Column(name = "email_to")
	private Integer to;

	@Column(name = "email_cc")
	private Integer cc;

	@Column(name = "email_bcc")
	private Integer bcc;
	
	
	
	@Column(name = "next_userid")
	private Integer nextUserid;

	@Column(name = "pre_userid")
	private Integer preUserid;

	@Column(name = "next_taskid")
	private Integer nextTaskid;
	
	@Column(name = "pre_taskid")
	private Integer preTaskid;

	public Integer getEjwId() {
		return ejwId;
	}


	public void setEjwId(Integer ejwId) {
		this.ejwId = ejwId;
	}


	public Integer getJrid() {
		return jrid;
	}


	public void setJrid(Integer jrid) {
		this.jrid = jrid;
	}


	public Integer getWkid() {
		return wkid;
	}


	public void setWkid(Integer wkid) {
		this.wkid = wkid;
	}


	public Integer getEmailId() {
		return emailId;
	}


	public void setEmailId(Integer emailId) {
		this.emailId = emailId;
	}


	public Integer getTaskId() {
		return taskId;
	}


	public void setTaskId(Integer taskId) {
		this.taskId = taskId;
	}


	public Integer getTo() {
		return to;
	}
	public void setTo(Integer to) {
		this.to = to;
	}

	public Integer getCc() {
		return cc;
	}

	public void setCc(Integer cc) {
		this.cc = cc;
	}
	public Integer getBcc() {
		return bcc;
	}

	public void setBcc(Integer bcc) {
		this.bcc = bcc;
	}


	public Integer getRoleId() {
		return roleId;
	}


	public void setRoleId(Integer roleId) {
		this.roleId = roleId;
	}


	public EmailTemp getEmailTemp() {
		return emailTemp;
	}


	public void setEmailTemp(EmailTemp emailTemp) {
		this.emailTemp = emailTemp;
	}


	public TaskDetails getTask() {
		return task;
	}


	public void setTask(TaskDetails task) {
		this.task = task;
	}


	public Role getRole() {
		return role;
	}


	public void setRole(Role role) {
		this.role = role;
	}


	public Integer getNextUserid() {
		return nextUserid;
	}


	public void setNextUserid(Integer nextUserid) {
		this.nextUserid = nextUserid;
	}


	public Integer getPreUserid() {
		return preUserid;
	}


	public void setPreUserid(Integer preUserid) {
		this.preUserid = preUserid;
	}


	public Integer getNextTaskid() {
		return nextTaskid;
	}


	public void setNextTaskid(Integer nextTaskid) {
		this.nextTaskid = nextTaskid;
	}


	public Integer getPreTaskid() {
		return preTaskid;
	}


	public void setPreTaskid(Integer preTaskid) {
		this.preTaskid = preTaskid;
	}


	@Override
	public String toString() {
		return "EmailJournalWorkflow [ejwId=" + ejwId + ", jrid=" + jrid + ", wkid=" + wkid + ", emailId=" + emailId
				+ ", emailTemp=" + emailTemp + ", taskId=" + taskId + ", task=" + task + ", roleId=" + roleId
				+ ", role=" + role + ", to=" + to + ", cc=" + cc + ", bcc=" + bcc + "]";
	}


}
