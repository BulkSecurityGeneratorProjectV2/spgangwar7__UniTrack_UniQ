package com.digi.unitouch.vo;

public class TaskSequencesVO {
	
	private Integer taskID;
	private Integer seqNo;
	
	public Integer getTaskID() {
		return taskID;
	}
	public void setTaskID(Integer taskID) {
		this.taskID = taskID;
	}
	public Integer getSeqNo() {
		return seqNo;
	}
	public void setSeqNo(Integer seqNo) {
		this.seqNo = seqNo;
	}
	
	@Override
	public String toString() {
		return "TaskSequencesVO [taskID=" + taskID + ", seqNo=" + seqNo + "]";
	}
}
