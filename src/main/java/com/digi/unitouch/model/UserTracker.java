package com.digi.unitouch.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "user_tracker")
public class UserTracker {


	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "ut_id")
	private Integer utId;
	
	@Column(name = "user_name")
	private String user_name;
	
	@Column(name = "email_id")
	private String email_id;
	
	
	@Column(name = "login_ip")
	private String login_ip;
	
	
	@Column(name = "login_at")
	private String login_at;
	
	@Column(name="user_appliation")
	private String userApplication;
	


	public Integer getUtId() {
		return utId;
	}


	public void setUtId(Integer utId) {
		this.utId = utId;
	}


	public String getUser_name() {
		return user_name;
	}


	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}


	public String getEmail_id() {
		return email_id;
	}


	public void setEmail_id(String email_id) {
		this.email_id = email_id;
	}


	public String getLogin_ip() {
		return login_ip;
	}


	public void setLogin_ip(String login_ip) {
		this.login_ip = login_ip;
	}


	public String getLogin_at() {
		return login_at;
	}


	public void setLogin_at(String login_at) {
		this.login_at = login_at;
	}


	
	public String getUserApplication() {
		return userApplication;
	}


	public void setUserApplication(String userApplication) {
		this.userApplication = userApplication;
	}


	@Override
	public String toString() {
		return "UserTracker [utId=" + utId + ", user_name=" + user_name + ", email_id=" + email_id + ", login_ip="
				+ login_ip + ", login_at=" + login_at + ", userApplication=" + userApplication + "]";
	}


}
