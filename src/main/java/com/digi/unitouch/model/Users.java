package com.digi.unitouch.model;

import java.io.Serializable;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "users")
public class Users implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "usr_id")
	private Integer userID;

	@Column(name = "user_email")
	private String username;
	
	@Column(name = "first_name")
	private String firstName;

	@Column(name = "last_name")
	private String lastName;

	@Column(name = "password")
	private String password;
	
	@Column(name = "token")
	private String token;

	@Column(name = "active")
	private String active;

	@Column(name = "created_by")
	private String createdBy;

	@CreationTimestamp
	@DateTimeFormat(pattern = "dd-MM-yyyy")
	@Column(name = "created_at", insertable = true, updatable = false)
	private Date createdAt;

	@Column(name = "modifiedBy")
	private String modifiedBy;

	@UpdateTimestamp
	@Temporal(TemporalType.TIMESTAMP)
	@DateTimeFormat(pattern = "dd-MM-yyyy")
	@Column(name = "modified_at", insertable = false, updatable = true)
	private Date modifiedAt;
	
//	@OneToOne(cascade = CascadeType.ALL)
//	@JoinTable(name = "user_department", joinColumns = @JoinColumn(name = "user_id"),inverseJoinColumns = @JoinColumn(name = "dept_id"))  
//	private Department group;
//	
	@OneToMany(fetch = FetchType.EAGER)
	@JoinTable(name = "user_department", joinColumns = @JoinColumn(name = "user_id"),inverseJoinColumns = @JoinColumn(name = "dept_id"))
	private List<Department> group1;
	
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinTable(name = "user_roles", joinColumns = @JoinColumn(name = "user_id"),inverseJoinColumns = @JoinColumn(name = "role_id"))
	private Role role;

	@Transient
	private Integer deptID;
	
	@Transient
	private Integer roleID;
	
	
	@Transient
	private int[] depID;
	

	public Integer getUserID() {
		return userID;
	}

	public void setUserID(Integer userID) {
		this.userID = userID;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public String getActive() {
		return active;
	}

	public void setActive(String active) {
		this.active = active;
	}

	public String getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
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

//	public Department getGroup() {
//		return group;
//	}
//
//	public void setGroup(Department group) {
//		this.group = group;
//	}

	
	public Integer getDeptID() {
		return deptID;
	}

	public List<Department> getGroup1() {
		return group1;
	}

	public void setGroup1(List<Department> group1) {
		this.group1 = group1;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public void setDeptID(Integer deptID) {
		this.deptID = deptID;
	}


	public int[] getDepID() {
		return depID;
	}

	public void setDepID(int[] depID) {
		this.depID = depID;
	}

	
	public Integer getRoleID() {
		return roleID;
	}

	public void setRoleID(Integer roleID) {
		this.roleID = roleID;
	}



	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}



	@Override
	public String toString() {
		return "Users [userID=" + userID + ", username=" + username + ", firstName=" + firstName + ", lastName="
				+ lastName + ", password=" + password + ", token=" + token + ", active=" + active + ", createdBy="
				+ createdBy + ", createdAt=" + createdAt + ", modifiedBy=" + modifiedBy + ", modifiedAt=" + modifiedAt
				+ ", group1=" + group1 + ", deptID=" + deptID + ", roleID=" + roleID + ", depID="
				+ Arrays.toString(depID) + ", role=" + role + "]";
	}

	
}
