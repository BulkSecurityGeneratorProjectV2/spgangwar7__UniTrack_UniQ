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
@Table(name = "email_scheduler")
public class EmailScheduler {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "et_id")
	private Integer id;

	@Column(name = "article_id")
	private Integer articleId;

	@OneToOne(optional = false)
	@JoinColumn(name = "article_id", insertable = false, updatable = false)
	private ArticleDetail article;

	@Column(name = "task_id")
	private Integer taskId;

	@OneToOne(optional = false)
	@JoinColumn(name = "task_id", insertable = false, updatable = false)
	private TaskDetails task;

	@Column(name = "et_to")
	private String etTo;

	@Column(name = "et_bcc")
	private String etBcc;

	@Column(name = "et_cc")
	private String etCc;

	@Column(name = "et_subject")
	private String etSubject;

	@Column(name = "et_body")
	private String etBody;

	@Column(name = "status")
	private String status;

	@Column(name = "created_by")
	private String createdBy;

	@Column(name = "created_at")
	private Date createdAt;

	@Column(name = "attempt_one")
	private Date attemptOne;

	@Column(name = "attempt_two")
	private Date attemptTwo;

	@Column(name = "attempt_three")
	private Date attemptThree;
	
	@Column(name = "finish_subject")
	private String finishSubject;
	
	@Column(name = "finish_body")
	private String finishBody;
	
	@Column(name = "reply_subject")
	private String replySubject;
	
	@Column(name = "next_user")
	private String nextUser;

	@Column(name = "pre_user")
	private String preUser;

	@Column(name = "reply_body")
	private String replyBody;
	
	@Column(name = "next_userid")
	private String nextUserid;

	@Column(name = "pre_userid")
	private String preUserid;

	@Column(name = "next_taskid")
	private String nextTaskid;
	
	@Column(name = "pre_taskid")
	private String preTaskid;
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getArticleId() {
		return articleId;
	}

	public void setArticleId(Integer articleId) {
		this.articleId = articleId;
	}

	public ArticleDetail getArticle() {
		return article;
	}

	public void setArticle(ArticleDetail article) {
		this.article = article;
	}

	public Integer getTaskId() {
		return taskId;
	}

	public void setTaskId(Integer taskId) {
		this.taskId = taskId;
	}

	public TaskDetails getTask() {
		return task;
	}

	public void setTask(TaskDetails task) {
		this.task = task;
	}

	public String getEtTo() {
		return etTo;
	}

	public void setEtTo(String etTo) {
		this.etTo = etTo;
	}

	public String getEtBcc() {
		return etBcc;
	}

	public void setEtBcc(String etBcc) {
		this.etBcc = etBcc;
	}

	public String getEtCc() {
		return etCc;
	}

	public void setEtCc(String etCc) {
		this.etCc = etCc;
	}

	public String getEtSubject() {
		return etSubject;
	}

	public void setEtSubject(String etSubject) {
		this.etSubject = etSubject;
	}

	public String getEtBody() {
		return etBody;
	}

	public void setEtBody(String etBody) {
		this.etBody = etBody;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
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

	public Date getAttemptOne() {
		return attemptOne;
	}

	public void setAttemptOne(Date attemptOne) {
		this.attemptOne = attemptOne;
	}

	public Date getAttemptTwo() {
		return attemptTwo;
	}

	public void setAttemptTwo(Date attemptTwo) {
		this.attemptTwo = attemptTwo;
	}

	public Date getAttemptThree() {
		return attemptThree;
	}

	public void setAttemptThree(Date attemptThree) {
		this.attemptThree = attemptThree;
	}

	public String getFinishSubject() {
		return finishSubject;
	}

	public void setFinishSubject(String finishSubject) {
		this.finishSubject = finishSubject;
	}

	public String getFinishBody() {
		return finishBody;
	}

	public void setFinishBody(String finishBody) {
		this.finishBody = finishBody;
	}

	public String getReplySubject() {
		return replySubject;
	}

	public void setReplySubject(String replySubject) {
		this.replySubject = replySubject;
	}

	public String getNextUser() {
		return nextUser;
	}

	public void setNextUser(String nextUser) {
		this.nextUser = nextUser;
	}

	public String getReplyBody() {
		return replyBody;
	}

	public void setReplyBody(String replyBody) {
		this.replyBody = replyBody;
	}

	public String getPreUser() {
		return preUser;
	}

	public void setPreUser(String preUser) {
		this.preUser = preUser;
	}

	
	public String getNextUserid() {
		return nextUserid;
	}

	public void setNextUserid(String nextUserid) {
		this.nextUserid = nextUserid;
	}

	public String getPreUserid() {
		return preUserid;
	}

	public void setPreUserid(String preUserid) {
		this.preUserid = preUserid;
	}

	public String getNextTaskid() {
		return nextTaskid;
	}

	public void setNextTaskid(String nextTaskid) {
		this.nextTaskid = nextTaskid;
	}

	public String getPreTaskid() {
		return preTaskid;
	}

	public void setPreTaskid(String preTaskid) {
		this.preTaskid = preTaskid;
	}

	@Override
	public String toString() {
		return "EmailScheduler [id=" + id + ", articleId=" + articleId + ", article=" + article + ", taskId=" + taskId
				+ ", task=" + task + ", etTo=" + etTo + ", etBcc=" + etBcc + ", etCc=" + etCc + ", etSubject="
				+ etSubject + ", etBody=" + etBody + ", status=" + status + ", createdBy=" + createdBy + ", createdAt="
				+ createdAt + ", attemptOne=" + attemptOne + ", attemptTwo=" + attemptTwo + ", attemptThree="
				+ attemptThree + ", finishSubject=" + finishSubject + ", finishBody=" + finishBody + ", replySubject="
				+ replySubject + ", nextUser=" + nextUser + ", preUser=" + preUser + ", replyBody=" + replyBody
				+ ", nextUserid=" + nextUserid + ", preUserid=" + preUserid + ", nextTaskid=" + nextTaskid
				+ ", preTaskid=" + preTaskid + "]";
	}


}
