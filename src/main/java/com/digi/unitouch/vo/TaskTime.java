package com.digi.unitouch.vo;

import java.util.Date;

public class TaskTime {
	private String TaskName;
	private String startTime;
	private String endTime;

	
	public String getTaskName() {
		return TaskName;
	}

	public void setTaskName(String taskName) {
		TaskName = taskName;
	}

	
	public String getStartTime() {
		return startTime;
	}

	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}

	public String getEndTime() {
		return endTime;
	}

	public void setEndTime(String endTime) {
		this.endTime = endTime;
	}

	@Override
	public String toString() {
		return "TaskTime [TaskName=" + TaskName + ", startTime=" + startTime + ", endTime=" + endTime + "]";
	}

}

