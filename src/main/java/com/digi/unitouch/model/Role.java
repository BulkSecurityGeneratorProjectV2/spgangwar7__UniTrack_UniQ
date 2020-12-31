package com.digi.unitouch.model;

import java.io.Serializable;
import java.util.Arrays;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.apache.http.client.utils.DateUtils;
//import org.apache.http.client.utils.DateUtils;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@SuppressWarnings("serial")
@Entity
@Table(name = "roles")
public class Role implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "role_id")
	private Integer roleID;

	@Column(name = "name")
	private String roleName;

	@Column(name = "status")
	private String status;
	
	@Transient
	private Integer function[];

	/*
	 * @OneToMany
	 * 
	 * @JoinColumn(name="role_id") private Department department;
	 */
	
	@CreationTimestamp
	@Column(name = "created_at", insertable = true, updatable = false)
	private Date createdAt;

	@Column(name = "created_by")
	private String createdBy;

	@UpdateTimestamp
	@Column(name = "modified_at", insertable = false, updatable = true)
	private Date modifiedAt;

	@Column(name = "modified_by")
	private String modifiedBy;
	
	@Column(name = "colour")
	private String colour;

//	@JsonIgnore 
//	  @ManyToMany(cascade = { CascadeType.ALL })
//	@JoinTable(name = "user_roles", joinColumns = @JoinColumn(name = "user_id"),inverseJoinColumns = @JoinColumn(name = "role_id"))
//	private List<Users> user;
//
//
//	@ManyToMany(mappedBy = "roles")
//    private Set<Users> user = new HashSet<>();  
//
//	public Set<Users> getUser() {
//		return user;
//	}
//
//	public void setUser(Set<Users> user) {
//		this.user = user;
//	}

	public Integer getRoleID() {
		return roleID;
	}

	public void setRoleID(Integer roleID) {
		this.roleID = roleID;
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

	public String getCreatedAt() {
		
		return DateUtils.formatDate(createdAt, "dd-MM-yyyy hh:mm a");
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	public String getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	public String getModifiedAt() {
		return DateUtils.formatDate(modifiedAt, "dd-MM-yyyy hh:mm a");
	}

	public void setModifiedAt(Date modifiedAt) {
		this.modifiedAt = modifiedAt;
	}

	public String getModifiedBy() {
		return modifiedBy;
	}

	public void setModifiedBy(String modifiedBy) {
		this.modifiedBy = modifiedBy;
	}

	public Integer[] getFunction() {
		return function;
	}

	public void setFunction(Integer[] function) {
		this.function = function;
	}

	
	public String getColour() {
		return colour;
	}

	public void setColour(String colour) {
		this.colour = colour;
	}

	@Override
	public String toString() {
		return "Role [roleID=" + roleID + ", roleName=" + roleName + ", status=" + status + ", function="
				+ Arrays.toString(function) + ", createdAt=" + createdAt + ", createdBy=" + createdBy + ", modifiedAt="
				+ modifiedAt + ", modifiedBy=" + modifiedBy + ", colour=" + colour + ",]";
	}



}
