package com.digi.unitouch.vo;

public class TasksSpecificJournal {

	private Long taskCount;
	private Integer journalId;
	private String journalName;
	private Integer id;
	private String taskName;
	private String task_status;
	public TasksSpecificJournal() {}
	
	public TasksSpecificJournal(Long taskCount, Integer journalId, String journalName, Integer id, String taskName,
			String task_status) {
		super();
		this.taskCount = taskCount;
		this.journalId = journalId;
		this.journalName = journalName;
		this.id = id;
		this.taskName = taskName;
		this.task_status = task_status;
	}

	public Long getTaskCount() {
		return taskCount;
	}

	public void setTaskCount(Long taskCount) {
		this.taskCount = taskCount;
	}

	public Integer getJournalId() {
		return journalId;
	}

	public void setJournalId(Integer journalId) {
		this.journalId = journalId;
	}

	public String getJournalName() {
		return journalName;
	}

	public void setJournalName(String journalName) {
		this.journalName = journalName;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getTaskName() {
		return taskName;
	}

	public void setTaskName(String taskName) {
		this.taskName = taskName;
	}

	public String getTask_status() {
		return task_status;
	}

	public void setTask_status(String task_status) {
		this.task_status = task_status;
	}

	@Override
	public String toString() {
		return "TasksSpecificJournal [taskCount=" + taskCount + ", journalId=" + journalId + ", journalName="
				+ journalName + ", id=" + id + ", taskName=" + taskName + ", task_status=" + task_status + "]";
	}

	
}
