package com.digi.unitouch.vo;

public class UpdateUserVo {

	private String updateUserEmail;
	private String updateUserFname;
	private String updateLastName;
	
	public String getUpdateUserEmail() {
		return updateUserEmail;
	}

	public void setUpdateUserEmail(String updateUserEmail) {
		this.updateUserEmail = updateUserEmail;
	}

	public String getUpdateUserFname() {
		return updateUserFname;
	}

	public void setUpdateUserFname(String updateUserFname) {
		this.updateUserFname = updateUserFname;
	}

	public String getUpdateLastName() {
		return updateLastName;
	}

	public void setUpdateLastName(String updateLastName) {
		this.updateLastName = updateLastName;
	}

	@Override
	public String toString() {
		return "UpdateUserVo [updateUserEmail=" + updateUserEmail + ", updateUserFname=" + updateUserFname
				+ ", updateLastName=" + updateLastName + "]";
	}
	
}
