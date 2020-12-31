package com.digi.unitouch.vo;

public class UserRoleVo {
	
	private Integer roleid;
	private String fastName;
	private String lastName;
	private int userid;
	private int taskID;
	public UserRoleVo() {}
	
	public UserRoleVo(Integer roleid, String fastName, String lastName, int userid, int taskID) {
		super();
		this.roleid = roleid;
		this.fastName = fastName;
		this.lastName = lastName;
		this.userid = userid;
		this.taskID = taskID;
	}

	public Integer getRoleid() {
		return roleid;
	}

	public void setRoleid(Integer roleid) {
		this.roleid = roleid;
	}

	public String getFastName() {
		return fastName;
	}

	public void setFastName(String fastName) {
		this.fastName = fastName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public int getUserid() {
		return userid;
	}

	public void setUserid(int userid) {
		this.userid = userid;
	}

	public int getTaskID() {
		return taskID;
	}

	public void setTaskID(int taskID) {
		this.taskID = taskID;
	}

	@Override
	public String toString() {
		return "UserRoleVo [roleid=" + roleid + ", fastName=" + fastName + ", lastName=" + lastName + ", userid="
				+ userid + ", taskID=" + taskID + "]";
	}


	
}
