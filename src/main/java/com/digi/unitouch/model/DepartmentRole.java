package com.digi.unitouch.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="department_roles")
public class DepartmentRole {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "dr_id")
	private int id;
	
	@Column(name = "dept_id")
	private int deptID;
	
	@Column(name = "role_id")
	private int roleID;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getDeptID() {
		return deptID;
	}

	public void setDeptID(int deptID) {
		this.deptID = deptID;
	}

	public int getRoleID() {
		return roleID;
	}

	public void setRoleID(int roleID) {
		this.roleID = roleID;
	}

	@Override
	public String toString() {
		return "DepartmentRole [id=" + id + ", deptID=" + deptID + ", roleID=" + roleID + "]";
	}

}
