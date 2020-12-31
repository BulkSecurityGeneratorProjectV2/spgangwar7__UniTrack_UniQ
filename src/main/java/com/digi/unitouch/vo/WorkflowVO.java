package com.digi.unitouch.vo;

import java.util.List;

public class WorkflowVO extends CreateAndUpdateVO{
	
	private Integer workflowID;
	private String workflowName;
	private String type;
	private Integer roleID;
	private String readOnly;
	private String emailFlag;
	private Integer tat;
	private String inFloder;
	private String outFolder;
	private Integer active;
	private Integer taskID;
	private String taskName;
	private List<TaskSequencesVO> taskSeqVO;
	private String readQueries;
	
	public Integer getWorkflowID() {
		return workflowID;
	}
	public void setWorkflowID(Integer workflowID) {
		this.workflowID = workflowID;
	}
	public String getWorkflowName() {
		return workflowName;
	}
	public void setWorkflowName(String workflowName) {
		this.workflowName = workflowName;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public Integer getRoleID() {
		return roleID;
	}
	public void setRoleID(Integer roleID) {
		this.roleID = roleID;
	}
	public String getReadOnly() {
		return readOnly;
	}
	public void setReadOnly(String readOnly) {
		this.readOnly = readOnly;
	}
	public String getEmailFlag() {
		return emailFlag;
	}
	public void setEmailFlag(String emailFlag) {
		this.emailFlag = emailFlag;
	}
	public Integer getTat() {
		return tat;
	}
	public void setTat(Integer tat) {
		this.tat = tat;
	}
	public String getInFloder() {
		return inFloder;
	}
	public void setInFloder(String inFloder) {
		this.inFloder = inFloder;
	}
	public String getOutFolder() {
		return outFolder;
	}
	public void setOutFolder(String outFolder) {
		this.outFolder = outFolder;
	}
	public Integer getActive() {
		return active;
	}
	public void setActive(Integer active) {
		this.active = active;
	}
	public Integer getTaskID() {
		return taskID;
	}
	public void setTaskID(Integer taskID) {
		this.taskID = taskID;
	}
	public String getTaskName() {
		return taskName;
	}
	public void setTaskName(String taskName) {
		this.taskName = taskName;
	}
	public List<TaskSequencesVO> getTaskSeqVO() {
		return taskSeqVO;
	}
	public void setTaskSeqVO(List<TaskSequencesVO> taskSeqVO) {
		this.taskSeqVO = taskSeqVO;
	}
	public String getReadQueries() {
		return readQueries;
	}
	public void setReadQueries(String readQueries) {
		this.readQueries = readQueries;
	}
	@Override
	public String toString() {
		return "WorkflowVO [workflowID=" + workflowID + ", workflowName=" + workflowName + ", type=" + type
				+ ", roleID=" + roleID + ", readOnly=" + readOnly + ", emailFlag=" + emailFlag + ", tat=" + tat
				+ ", inFloder=" + inFloder + ", outFolder=" + outFolder + ", active=" + active + ", taskID=" + taskID
				+ ", taskName=" + taskName + ", taskSeqVO=" + taskSeqVO + ", readQueries=" + readQueries + "]";
	}
}
