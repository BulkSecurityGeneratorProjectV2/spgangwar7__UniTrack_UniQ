package com.digi.unitouch.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "department_head")
public class DepartmentHead {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "dh_id")
	private Integer deptHeadID;
	
	@Column(name = "dept_id",unique = true)
	private Integer deptID;
	
	@ManyToOne
	@JoinColumn(name="dept_id",insertable = false,updatable = false)
	private Department department;
	

	@Column(name = "usr_id",unique = true)
	private Integer userId;
	
	@OneToOne(optional = false)
	@JoinColumn(name="usr_id",insertable = false,updatable = false)
	private Users user;

	public Integer getDeptHeadID() {
		return deptHeadID;
	}

	public void setDeptHeadID(Integer deptHeadID) {
		this.deptHeadID = deptHeadID;
	}

	public Integer getDeptID() {
		return deptID;
	}

	public void setDeptID(Integer deptID) {
		this.deptID = deptID;
	}
	
	

	public Department getDepartment() {
		return department;
	}

	public void setDepartment(Department department) {
		this.department = department;
	}

	/*
	 * public List<Department> getDepartment() { return department; }
	 * 
	 * public void setDepartment(List<Department> department) { this.department =
	 * department; }
	 */

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public Users getUser() {
		return user;
	}

	public void setUser(Users user) {
		this.user = user;
	}

	@Override
	public String toString() {
		return "DepartmentHead [deptHeadID=" + deptHeadID + ", deptID=" + deptID + ", department=" + department
				+ ", userId=" + userId + ", user=" + user + "]";
	}

	

	

}
