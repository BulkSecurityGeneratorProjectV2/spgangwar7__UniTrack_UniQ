package com.digi.unitouch.model;

import java.text.ParseException;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;

import com.digi.unitouch.util.DateApi;

@Entity
@Table(name = "article_scheduled_tasks")
public class TaskScheduler {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "article_task_id")
	private Integer article_task_id;//

	@OneToOne(optional = false)
	@JoinColumn(name = "article_id", insertable = false, updatable = false)
	private ArticleDetail articleDetail;

	@Column(name = "article_id")
	private Integer article_id;

	@Column(name = "workflow_id")
	private Integer workflow_id;

	@Column(name = "task_id") //
	private Integer task_id;

	@ManyToOne
	@JoinColumn(name = "task_id",insertable = false,updatable = false)
	private TaskDetails task;

	@DateTimeFormat(pattern = "dd-MM-yyyy")
	@Column(name = "task_assigned_date")
	private Date task_assigned_date;

	@DateTimeFormat(pattern = "dd-MM-yyyy")
	@Column(name = "task_due_date")
	private Date task_due_date;

	@Column(name = "user_id")
	private Integer user_id;

	@DateTimeFormat(pattern = "dd-MM-yyyy")
	@Column(name = "sch_start_time")
	private Date sch_start_time;

	@DateTimeFormat(pattern = "dd-MM-yyyy")
	@Column(name = "sch_end_time")
	private Date sch_end_time;//
	
	@DateTimeFormat(pattern = "dd-MM-yyyy")
	@Column(name = "task_est_time_from")
	private Date task_est_time_from;
	
	@DateTimeFormat(pattern = "dd-MM-yyyy")
	@Column(name = "task_est_time_end")
	private Date task_est_time_end;

	@Column(name = "task_status")
	private String task_status;

	@DateTimeFormat(pattern = "dd-MM-yyyy")
	@Column(name = "created_date")
	private Date created_date;

	@Column(name = "created_by")
	private Integer created_by;

	@DateTimeFormat(pattern = "dd-MM-yyyy")
	@Column(name = "updated_date")
	private Date updated_date;

	@Column(name = "updated_by")
	private Integer updated_by;

	@Column(name = "task_time_actual")
	private Integer task_time_actual;

	@Column(name = "run_id")
	private Integer runId;

	@Column(name = "assign_back_count")
	private Integer assign_back_count;

	@Column(name = "assign_reason")
	private String assign_reason;

	@Column(name = "rating_star")
	private Integer ratingStar;

	@Column(name = "comments")
	private String comments;

	//

	/*
	 * @Column(name = "task_time_est") private Integer task_time_est;
	 */
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

	public Integer getWorkflow_id() {
		return workflow_id;
	}

	public void setWorkflow_id(Integer workflow_id) {
		this.workflow_id = workflow_id;
	}

	public Integer getTask_id() {
		return task_id;
	}

	public void setTask_id(Integer task_id) {
		this.task_id = task_id;
	}

	public Date getTask_assigned_date() {
		return task_assigned_date;
	}

	public void setTask_assigned_date(Date task_assigned_date) {
		this.task_assigned_date = task_assigned_date;
	}

	public Date getTask_due_date() {
		return task_due_date;
	}

	public void setTask_due_date(Date task_due_date) {
		this.task_due_date = task_due_date;
	}

	public Integer getUser_id() {
		return user_id;
	}

	public void setUser_id(Integer user_id) {
		this.user_id = user_id;
	}

	public Date getSch_start_time() {
		return sch_start_time;
	}

	public Date setSch_start_time(Date sch_start_time) {
		return this.sch_start_time = sch_start_time;
	}

	public Date getSch_end_time() {
		return sch_end_time;
	}

	public void setSch_end_time(Date sch_end_time) {
		this.sch_end_time = sch_end_time;
	}

	public Integer getTask_time_actual() {
		return task_time_actual;
	}

	public void setTask_time_actual(Integer task_time_actual) {
		this.task_time_actual = task_time_actual;
	}

	/*
	 * public Integer getTask_time_est() { return task_time_est; }
	 * 
	 * public void setTask_time_est(Integer task_time_est) { this.task_time_est =
	 * task_time_est; }
	 */

	public String getTask_est_time_from() throws ParseException {
		return  DateApi.LocalDateTimeApi(task_est_time_from);}
	

	public void setTask_est_time_from(Date task_est_time_from) {
		this.task_est_time_from = task_est_time_from;
	}

	public String getTask_est_time_end() throws ParseException {
		return DateApi.LocalDateTimeApi(task_est_time_end);
	}

	public void setTask_est_time_end(Date task_est_time_end) {
		this.task_est_time_end = task_est_time_end;
	}

	public String getTask_status() {
		return task_status;
	}

	public void setTask_status(String task_status) {
		this.task_status = task_status;
	}

	public Date getCreated_date() {
		return created_date;
	}

	public void setCreated_date(Date created_date) {
		this.created_date = created_date;
	}

	public Integer getCreated_by() {
		return created_by;
	}

	public void setCreated_by(Integer created_by) {
		this.created_by = created_by;
	}

	public Date getUpdated_date() {
		return updated_date;
	}

	public void setUpdated_date(Date updated_date) {
		this.updated_date = updated_date;
	}

	public Integer getUpdated_by() {
		return updated_by;
	}

	public void setUpdated_by(Integer updated_by) {
		this.updated_by = updated_by;
	}

	public Integer getRunId() {
		return runId;
	}

	public void setRunId(Integer runId) {
		this.runId = runId;
	}

	public ArticleDetail getArticleDetail() {
		return articleDetail;
	}

	public void setArticleDetail(ArticleDetail articleDetail) {
		this.articleDetail = articleDetail;
	}

	public Integer getAssign_back_count() {
		return assign_back_count;
	}

	public void setAssign_back_count(Integer assign_back_count) {
		this.assign_back_count = assign_back_count;
	}

	public String getAssign_reason() {
		return assign_reason;
	}

	public void setAssign_reason(String assign_reason) {
		this.assign_reason = assign_reason;
	}

	public Integer getRatingStar() {
		return ratingStar;
	}

	public void setRatingStar(Integer ratingStar) {
		this.ratingStar = ratingStar;
	}
	

	public TaskDetails getTask() {
		return task;
	}

	public void setTask(TaskDetails task) {
		this.task = task;
	}

	public String getComments() {
		return comments;
	}

	public void setComments(String comments) {
		this.comments = comments;
	}

	@Override
	public String toString() {
		return "TaskScheduler [article_task_id=" + article_task_id + ", articleDetail=" + articleDetail
				+ ", article_id=" + article_id + ", workflow_id=" + workflow_id + ", task_id=" + task_id + ", task="
				+ task + ", task_assigned_date=" + task_assigned_date + ", task_due_date=" + task_due_date
				+ ", user_id=" + user_id + ", sch_start_time=" + sch_start_time + ", sch_end_time=" + sch_end_time
				+ ", task_est_time_from=" + task_est_time_from + ", task_est_time_end=" + task_est_time_end
				+ ", task_status=" + task_status + ", created_date=" + created_date + ", created_by=" + created_by
				+ ", updated_date=" + updated_date + ", updated_by=" + updated_by + ", task_time_actual="
				+ task_time_actual + ", runId=" + runId + ", assign_back_count=" + assign_back_count
				+ ", assign_reason=" + assign_reason + ", ratingStar=" + ratingStar + ", comments=" + comments + "]";
	}


}