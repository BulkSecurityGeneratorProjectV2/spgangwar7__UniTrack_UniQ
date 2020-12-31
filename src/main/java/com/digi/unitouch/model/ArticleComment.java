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
@Table(name = "article_comment")
public class ArticleComment {

	@GeneratedValue(strategy = GenerationType.AUTO)
	@Id
	@Column(name = "ac_id")
	private Integer ac_id;

	@Column(name = "jid")
	private Integer jid;

	@Column(name = "aid")
	private Integer aid;

	@Column(name = "task_id")
	private Integer taskid;

	@OneToOne(optional = false)
	@JoinColumn(name = "task_id",insertable = false,updatable = false)
	private TaskDetails task;

	@Column(name = "role_id")
	private Integer roleid;
	
	@OneToOne(optional = false)
	@JoinColumn(name = "role_id",insertable = false,updatable = false)
	private Role role;


	@Column(name = "comment")
	private String comment;
	
	@Column(name = "user_name")
	private String userName;

	@Column(name = "comment_date")
	private Date commentDate;

	public Integer getAc_id() {
		return ac_id;
	}

	public void setAc_id(Integer ac_id) {
		this.ac_id = ac_id;
	}

	public Integer getJid() {
		return jid;
	}

	public void setJid(Integer jid) {
		this.jid = jid;
	}

	public Integer getAid() {
		return aid;
	}

	public void setAid(Integer aid) {
		this.aid = aid;
	}

	public Integer getTaskid() {
		return taskid;
	}

	public void setTaskid(Integer taskid) {
		this.taskid = taskid;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public Date getCommentDate() {
		return commentDate;
	}

	public void setCommentDate(Date commentDate) {
		this.commentDate = commentDate;
	}

	public Integer getRoleid() {
		return roleid;
	}

	public void setRoleid(Integer roleid) {
		this.roleid = roleid;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
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

	@Override
	public String toString() {
		return "ArticleComment [ac_id=" + ac_id + ", jid=" + jid + ", aid=" + aid + ", taskid=" + taskid + ", task="
				+ task + ", roleid=" + roleid + ", comment=" + comment + ", userName=" + userName + ", commentDate="
				+ commentDate + "]";
	}



}
