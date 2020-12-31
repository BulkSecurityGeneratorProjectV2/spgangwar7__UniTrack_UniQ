package com.digi.unitouch.vo;

public class WorkflowtaskVO {
	
	private Integer taskId;
	private String taskName;
	
	
	public Integer getTaskId() {
		return taskId;
	}
	public void setTaskId(Integer taskId) {
		this.taskId = taskId;
	}
	public String getTaskName() {
		return taskName;
	}
	public void setTaskName(String taskName) {
		this.taskName = taskName;
	}
	@Override
	public String toString() {
		return "WorkflowtaskVO [taskId=" + taskId + ", taskName=" + taskName + "]";
	}
	public WorkflowtaskVO(Integer taskId, String taskName) {
		super();
		this.taskId = taskId;
		this.taskName = taskName;
	}


}
