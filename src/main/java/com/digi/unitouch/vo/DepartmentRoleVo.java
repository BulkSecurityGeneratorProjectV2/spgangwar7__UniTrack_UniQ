package com.digi.unitouch.vo;

public class DepartmentRoleVo {
	
	private Integer roleid;
	private String name;
	private int deptID;
	private int taskID;
	

	public Integer getRoleid() {
		return roleid;
	}
	public void setRoleid(Integer roleid) {
		this.roleid = roleid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getDeptID() {
		return deptID;
	}
	public void setDeptID(int deptID) {
		this.deptID = deptID;
	}
	public int getTaskID() {
		return taskID;
	}
	public void setTaskID(int taskID) {
		this.taskID = taskID;
	}
	@Override
	public String toString() {
		return "DepartmentRoleVo [roleid=" + roleid + ", name=" + name + ", deptID=" + deptID + ", taskID=" + taskID
				+ "]";
	}
	public DepartmentRoleVo(Integer roleid, String name, int deptID, int taskID) {
		super();
		this.roleid = roleid;
		this.name = name;
		this.deptID = deptID;
		this.taskID = taskID;
	}
	
}
