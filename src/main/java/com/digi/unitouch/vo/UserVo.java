package com.digi.unitouch.vo;

public class UserVo{
	
	private Integer id;
	private String userEmail;
	private String userFname;
	private String userLname;
	private String password;
	private String active;
	private Integer deptID;
	private String deptName;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getUserEmail() {
		return userEmail;
	}
	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}
	public String getUserFname() {
		return userFname;
	}
	public void setUserFname(String userFname) {
		this.userFname = userFname;
	}
	public String getUserLname() {
		return userLname;
	}
	public void setUserLname(String userLname) {
		this.userLname = userLname;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getActive() {
		return active;
	}
	public void setActive(String active) {
		this.active = active;
	}
	public Integer getDeptID() {
		return deptID;
	}
	public void setDeptID(Integer deptID) {
		this.deptID = deptID;
	}
	public String getDeptName() {
		return deptName;
	}
	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}
	@Override
	public String toString() {
		return "UserVo [id=" + id + ", userEmail=" + userEmail + ", userFname=" + userFname + ", userLname=" + userLname
				+ ", password=" + password + ", active=" + active + ", deptID=" + deptID + ", deptName=" + deptName
				+ "]";
	}
	
}
