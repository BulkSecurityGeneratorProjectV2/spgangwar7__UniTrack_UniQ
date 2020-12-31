package com.digi.unitouch.vo;

public class DepartmentsTask {

	private Long count;
	private Integer article_id;
	private String article_title;
	private Integer dept_id;
	private String journalName;
	private Integer journalId;
	private String taskName;
	private Integer task_id;
	private String task_status;

	public DepartmentsTask() {
	}

	public DepartmentsTask(Long count, Integer article_id, String article_title, Integer user_id,
			String journalName, Integer journalId, String taskName, Integer task_id, String task_status) {
		super();
		this.count = count;
		this.article_id = article_id;
		this.article_title = article_title;
		this.dept_id = user_id;
		this.journalName = journalName;
		this.journalId = journalId;
		this.taskName = taskName;
		this.task_id = task_id;
		this.task_status = task_status;
	}
	
//	public DepartmentsTask(Long count, Integer article_id, String article_title, Integer dept_id,
//			String journalName, Integer journalId, String taskName, Integer task_id, String task_status) {
//		super();
//		this.count = count;
//		this.article_id = article_id;
//		this.article_title = article_title;
//		this.dept_id = dept_id;
//		this.journalName = journalName;
//		this.journalId = journalId;
//		this.taskName = taskName;
//		this.task_id = task_id;
//		this.task_status = task_status;
//	}


	public Long getCount() {
		return count;
	}

	public void setCount(Long count) {
		this.count = count;
	}

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

	public Integer getDept_id() {
		return dept_id;
	}

	public void setDept_id(Integer dept_id) {
		this.dept_id = dept_id;
	}

	public String getJournalName() {
		return journalName;
	}

	public void setJournalName(String journalName) {
		this.journalName = journalName;
	}

	public Integer getJournalId() {
		return journalId;
	}

	public void setJournalId(Integer journalId) {
		this.journalId = journalId;
	}

	public String getTaskName() {
		return taskName.replace("_", " ");
	}

	public void setTaskName(String taskName) {
		this.taskName = taskName;
	}

	public Integer getTask_id() {
		return task_id;
	}

	public void setTask_id(Integer task_id) {
		this.task_id = task_id;
	}

	public String getTask_status() {
		return task_status;
	}

	public void setTask_status(String task_status) {
		this.task_status = task_status;
	}

	@Override
	public String toString() {
		return "DepartmentsTask [taskCount=" + count + ", article_id=" + article_id + ", article_title="
				+ article_title + ", dept_id=" + dept_id + ", journalName=" + journalName + ", journalId=" + journalId
				+ ", taskName=" + taskName + ", id=" + task_id + ", task_status=" + task_status + "]";
	}

}
