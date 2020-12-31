package com.digi.unitouch.vo;

public class WorkflowMax {
	private Integer sequence;

	private Integer workflowId;
	
	private Integer taskId;



	public WorkflowMax(Integer sequence, Integer workflowId, Integer taskId) {
		super();
		this.sequence = sequence;
		this.workflowId = workflowId;
		this.taskId = taskId;
	}

	public WorkflowMax() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Integer getSequence() {
		return sequence;
	}

	public void setSequence(Integer sequence) {
		this.sequence = sequence;
	}

	public Integer getWorkflowId() {
		return workflowId;
	}

	public void setWorkflowId(Integer workflowId) {
		this.workflowId = workflowId;
	}

	
	public Integer getTaskId() {
		return taskId;
	}

	public void setTaskId(Integer taskId) {
		this.taskId = taskId;
	}

	@Override
	public String toString() {
		return "WorkflowMax [sequence=" + sequence + ", workflowId=" + workflowId + ", taskId=" + taskId + "]";
	}

}
