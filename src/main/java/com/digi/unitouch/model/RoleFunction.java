package com.digi.unitouch.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Table
@Entity(name="sys_role_function")
public class RoleFunction {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "rf_id")
	private int id;
	
	@Column(name = "role_id")
	private int roleId;
	
	@Column(name = "function_id")
	private int functionId;
	
	/*
	 * @OneToOne
	 * 
	 * @JoinColumn(name = "function_id",insertable = false,updatable = false)
	 * private SubMenu functId;
	 */

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getRoleId() {
		return roleId;
	}

	public void setRoleId(int roleId) {
		this.roleId = roleId;
	}

	public int getFunctionId() {
		return functionId;
	}

	public void setFunctionId(int functionId) {
		this.functionId = functionId;
	}

	@Override
	public String toString() {
		return "RoleFunction [id=" + id + ", roleId=" + roleId + ", functionId=" + functionId + "]";
	}



	
	
}
