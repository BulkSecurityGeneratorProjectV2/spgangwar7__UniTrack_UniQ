package com.digi.unitouch.vo;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.http.client.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.annotation.Transient;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.digi.unitouch.model.Department;
import com.digi.unitouch.service.DepartmentService;


public class IssueSearchDetailvo {

  
	private Integer article_id;
	//private String aid;
	private String article_title;
	private String task_status;
	private Date sch_start_time;
	private Date sch_end_time;
	private Date start_date_time;
	private Date completed_date_time;
	private String firstName;
	private String lastName;
	private String taskName;
	private Integer dept_id;
	private Integer article_task_id;

	private String deptName;

	private long diffdate;
	

	
	public Integer getArticle_id() {
		return article_id;
	}
	public void setArticle_id(Integer article_id) {
		this.article_id = article_id;
	}
	
	public String getArticle_title() {
		return article_title;
	}
	public void setArticle_title(String article_title) {
		this.article_title = article_title;
	}
	public String getTask_status() {
		return task_status;
	}
	public void setTask_status(String task_status) {
		this.task_status = task_status;
	}
	public Date getSch_start_time() {
		return sch_start_time;
		//return DateUtils.formatDate(sch_start_time, "dd-MM-yyyy hh:mm a");
	}
	public void setSch_start_time(Date sch_start_time) {
		this.sch_start_time = sch_start_time;
	}
	public Date getSch_end_time() {
		//return DateUtils.formatDate(sch_end_time, "dd-MM-yyyy hh:mm a");
		return sch_end_time;
	}
	public void setSch_end_time(Date sch_end_time) {
		this.sch_end_time = sch_end_time;
	}
//	public String getStart_date_time() {
//		return DateUtils.formatDate(start_date_time, "dd-MM-yyyy hh:mm a");
//	}
	public Date getStart_date_time() {
		return start_date_time;
	}
	public void setStart_date_time(Date start_date_time) {
		this.start_date_time = start_date_time;
	}
//	public String getCompleted_date_time() {
//		return DateUtils.formatDate(completed_date_time, "dd-MM-yyyy hh:mm a");
//	}
	public Date getCompleted_date_time() {
		return completed_date_time;
	}
	public void setCompleted_date_time(Date completed_date_time) {
		this.completed_date_time = completed_date_time;
	}
	
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getTaskName() {
		return taskName.replace("_", " ");
	}
	public void setTaskName(String taskName) {
		this.taskName = taskName;
	}
	

	public Integer getDept_id() {
		return dept_id;
	}
	public void setDept_id(Integer dept_id) {
		this.dept_id = dept_id;
	}
	public long getDiffdate() {
		SimpleDateFormat format = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss");

		Date d1 = sch_end_time;
		Date d2 = completed_date_time;

			try {
				long diff = d2.getTime() - d1.getTime();
				return diff /(24 * 60 * 60 * 1000);
			}catch (Exception e) {
				return diffdate;
			}
			
		
	}
	public void setDiffdate(long diffdate) {
		this.diffdate = diffdate;
	}
	
	public String getDeptName() {
		return deptName;
	}
	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}
	
	public Integer getArticle_task_id() {
		return article_task_id;
	}
	public void setArticle_task_id(Integer article_task_id) {
		this.article_task_id = article_task_id;
	}
	
	public IssueSearchDetailvo(Integer article_id,  String article_title, String task_status,
			Date sch_start_time, Date sch_end_time, Date start_date_time, Date completed_date_time, String firstName,
			String lastName, String taskName,Integer dept_id) {
		super();
		this.article_id = article_id;
		//this.aid = aid;
		this.article_title = article_title;
		this.task_status = task_status;
		this.sch_start_time = sch_start_time;
		this.sch_end_time = sch_end_time;
		this.start_date_time = start_date_time;
		this.completed_date_time = completed_date_time;
		this.firstName = firstName;
		this.lastName = lastName;
		this.taskName = taskName;
		this.dept_id = dept_id;
	}
	public IssueSearchDetailvo(Integer article_id,  String article_title, String task_status,
			Date sch_start_time, Date sch_end_time, Date start_date_time, Date completed_date_time, String firstName,
			String lastName, String taskName, Integer dept_id, Integer article_task_id) {
		super();
		this.article_id = article_id;
		//this.aid = aid;
		this.article_title = article_title;
		this.task_status = task_status;
		this.sch_start_time = sch_start_time;
		this.sch_end_time = sch_end_time;
		this.start_date_time = start_date_time;
		this.completed_date_time = completed_date_time;
		this.firstName = firstName;
		this.lastName = lastName;
		this.taskName = taskName;
		this.dept_id = dept_id;
		this.article_task_id = article_task_id;
	}
	@Override
	public String toString() {
		return "IssueSearchDetailvo [article_id=" + article_id + ", article_title=" + article_title + ", task_status="
				+ task_status + ", sch_start_time=" + sch_start_time + ", sch_end_time=" + sch_end_time
				+ ", start_date_time=" + start_date_time + ", completed_date_time=" + completed_date_time
				+ ", firstName=" + firstName + ", lastName=" + lastName + ", taskName=" + taskName + ", dept_id="
				+ dept_id + ", article_task_id=" + article_task_id + ", deptName=" + deptName + ", diffdate=" + diffdate
				+ "]";
	}


	}
