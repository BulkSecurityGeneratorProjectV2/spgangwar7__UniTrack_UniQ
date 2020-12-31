package com.digi.unitouch.vo;

public class userDepartmentVo {
	
	private Integer id;
	private String userEmail;
	private String name;
	private Integer deptId;
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
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Integer getDeptId() {
		return deptId;
	}
	public void setDeptId(Integer deptId) {
		this.deptId = deptId;
	}
	public userDepartmentVo(Integer id, String userEmail, String name, Integer deptId) {
		super();
		this.id = id;
		this.userEmail = userEmail;
		this.name = name;
		this.deptId = deptId;
	}
	@Override
	public String toString() {
		return "userDepartmentVo [id=" + id + ", userEmail=" + userEmail + ", name=" + name + ", deptId=" + deptId
				+ "]";
	}
	
	
	
}
