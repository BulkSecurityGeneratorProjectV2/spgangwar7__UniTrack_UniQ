package com.digi.unitouch.model;

import java.io.Serializable;
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
/*
 * @Data
 * 
 * @Builder
 */
@Table(name = "issue_comments")
/*
 * @AllArgsConstructor
 * 
 * @Getter @lombok.Setter @NoArgsConstructor // <--- THIS is it
 */ public class IssueComment implements Serializable {

	/**
	 * @Auhor 80055
	 */
	private static final long serialVersionUID = 1L;

	@GeneratedValue(strategy = GenerationType.AUTO)
	@Id
	@Column(name = "ic_id")
	private Integer icId;

	@Column(name = "jid")
	private Integer jid;

	@Column(name = "issue_id")
	private Integer issueId;

	@Column(name = "task_id")
	private Integer taskid;

	@OneToOne(optional = false)

	@JoinColumn(name = "task_id", insertable = false, updatable = false)
	private TaskDetails task;

	@Column(name = "role_id")
	private Integer roleid;

	@OneToOne(optional = false)

	@JoinColumn(name = "role_id", insertable = false, updatable = false)
	private Role role;

	@Column(name = "issue_comments")
	private String issueComments;

	@Column(name = "user_name")
	private String userName;

	@Column(name = "comment_date")
	private Date commentDate;

	public Integer getIcId() {
		return icId;
	}

	public void setIcId(Integer icId) {
		this.icId = icId;
	}

	public Integer getJid() {
		return jid;
	}

	public void setJid(Integer jid) {
		this.jid = jid;
	}

	public Integer getIssueId() {
		return issueId;
	}

	public void setIssueId(Integer issueId) {
		this.issueId = issueId;
	}

	public Integer getTaskid() {
		return taskid;
	}

	public void setTaskid(Integer taskid) {
		this.taskid = taskid;
	}

	public Integer getRoleid() {
		return roleid;
	}

	public void setRoleid(Integer roleid) {
		this.roleid = roleid;
	}

	public String getIssueComments() {
		return issueComments;
	}

	public void setIssueComments(String issueComments) {
		this.issueComments = issueComments;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public Date getCommentDate() {
		return commentDate;
	}

	public void setCommentDate(Date commentDate) {
		this.commentDate = commentDate;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
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
		return "IssueComment [icId=" + icId + ", jid=" + jid + ", issueId=" + issueId + ", taskid=" + taskid + ", task="
				+ task + ", roleid=" + roleid + ", role=" + role + ", issueComments=" + issueComments + ", userName="
				+ userName + ", commentDate=" + commentDate + "]";
	}

}
