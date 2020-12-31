package com.digi.unitouch.vo;

public class RoleVo {
	
	private Integer id;
	private String roleName;
	private String status;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getRoleName() {
		return roleName;
	}
	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	@Override
	public String toString() {
		return "RoleVo [id=" + id + ", roleName=" + roleName + ", status=" + status + "]";
	}
}
