package com.digi.unitouch.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Table
@Entity(name="user_department")
public class UserDepartment {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "ud_id")
	private Integer id;
	
	@Column(name = "user_id")
	private int userID;
	
	@Column(name = "dept_id")
	private Integer deptID;

	public Integer getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getUserID() {
		return userID;
	}

	public void setUserID(int userID) {
		this.userID = userID;
	}

	public int getDeptID() {
		return deptID;
	}

	public void setDeptID(int deptID) {
		this.deptID = deptID;
	}

	@Override
	public String toString() {
		return "UserDepartment [id=" + id + ", userID=" + userID + ", deptID=" + deptID + "]";
	}
	
}
