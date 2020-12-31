package com.digi.unitouch.vo;

public class EditJournalWorkflowVO {
	
	private Integer mjwId;
	private Integer roleId;
	private Integer taskId;
	public Integer getMjwId() {
		return mjwId;
	}
	public void setMjwId(Integer mjwId) {
		this.mjwId = mjwId;
	}
	public Integer getRoleId() {
		return roleId;
	}
	public void setRoleId(Integer roleId) {
		this.roleId = roleId;
	}
	public Integer getTaskId() {
		return taskId;
	}
	public void setTaskId(Integer taskId) {
		this.taskId = taskId;
	}
	@Override
	public String toString() {
		return "EditJournalWorkflowVO [mjwId=" + mjwId + ", roleId=" + roleId + ", taskId=" + taskId + "]";
	}
	
	

}
