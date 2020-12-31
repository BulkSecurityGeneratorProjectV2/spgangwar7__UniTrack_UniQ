package com.digi.unitouch.model;

import java.util.Date;

/**
 * @author Himanshu
 *
 */

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.format.annotation.DateTimeFormat;


@Entity
@Table(name = "department")
public class Department {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "dept_id")
	private Integer deptID;

	@Column(name = "name")
	private String groupName;


	@Column(name = "status")
	private String status;

	@Column(name = "created_by")
	private String createdBy;

	@OneToOne(fetch = FetchType.EAGER)
	@JoinTable(name = "department_roles", joinColumns = {
	@JoinColumn(name = "dept_id", referencedColumnName = "dept_id") }, inverseJoinColumns = {
	@JoinColumn(name = "role_id", referencedColumnName = "role_id") })
	private Role role;

	@CreationTimestamp
	@DateTimeFormat(pattern = "dd-MM-yyyy")
	@Column(name = "created_at", insertable = true, updatable = false)
	private Date createdAt;

	@Column(name = "modifiedBy")
	private String modifiedBy;

	@UpdateTimestamp
	@DateTimeFormat(pattern = "dd-MM-yyyy")
	@Column(name = "modified_at", insertable = false, updatable = true)
	private Date modifiedAt;
	
    @Transient
	private int holidayGrpId;
	
	
	@Transient
	private Integer roleID;

	public Integer getDeptID() {
		return deptID;
	}

	public void setDeptID(Integer deptID) {
		this.deptID = deptID;
	}

	public String getGroupName() {
		return groupName;
	}

	public void setGroupName(String groupName) {
		this.groupName = groupName;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

	public Date getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	public String getModifiedBy() {
		return modifiedBy;
	}

	public void setModifiedBy(String modifiedBy) {
		this.modifiedBy = modifiedBy;
	}

	public Date getModifiedAt() {
		return modifiedAt;
	}

	public void setModifiedAt(Date modifiedAt) {
		this.modifiedAt = modifiedAt;
	}

	public Integer getRoleID() {
		return roleID;
	}

	public void setRoleID(Integer roleID) {
		this.roleID = roleID;
	}
	
	public int getHolidayGrpId() {
		return holidayGrpId;
	}

	public void setHolidayGrpId(int holidayGrpId) {
		this.holidayGrpId = holidayGrpId;
	}

	@Override
	public String toString() {
		return "Department [deptID=" + deptID + ", groupName=" + groupName + ", status=" + status + ", createdBy="
				+ createdBy + ", role=" + role + ", createdAt=" + createdAt + ", modifiedBy=" + modifiedBy
				+ ", modifiedAt=" + modifiedAt + ", holidayGrpId=" + holidayGrpId + ", roleID=" + roleID + "]";
	}


}