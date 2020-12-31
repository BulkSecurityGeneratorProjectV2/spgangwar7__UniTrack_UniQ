package com.digi.unitouch.vo;

public class ForgotPasswordVo {
	private String username;
	private String newpassword;
	private String password;
	private String rePassword;

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getNewpassword() {
		return newpassword;
	}

	public void setNewpassword(String newpassword) {
		this.newpassword = newpassword;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}


	public String getRePassword() {
		return rePassword;
	}

	public void setRePassword(String rePassword) {
		this.rePassword = rePassword;
	}

	@Override
	public String toString() {
		return "ForgotPasswordVo [username=" + username + ", newpassword=" + newpassword + ", password=" + password
				+ ", rePassword=" + rePassword + "]";
	}


}
