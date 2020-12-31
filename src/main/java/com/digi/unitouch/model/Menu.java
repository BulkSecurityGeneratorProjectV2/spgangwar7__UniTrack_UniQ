package com.digi.unitouch.model;

import java.util.Set;

/**
 * @author Aditya
 *
 */

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;


@Entity
@Table(name = "sys_menu")
public class Menu {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "menu_id")
	private Integer id;

	@Column(name = "name")
	private String name;

	@Column(name = "status")
	private String status;

	@Column(name = "seq")
	private Integer seq;
	
	@OneToMany(mappedBy = "menu")
	private Set<SubMenu> subMenuList;
	
	/*
	 * @OneToOne(cascade = CascadeType.ALL)
	 * 
	 * @JoinTable(name = "department_roles", joinColumns = {
	 * 
	 * @JoinColumn(name = "role_id", referencedColumnName = "id") },
	 * inverseJoinColumns = {
	 * 
	 * @JoinColumn(name = "menu_id", referencedColumnName = "id") }) private SubMenu
	 * submenu;
	 */
	
	
	public Integer getId() {
		return id;
	}


	public void setId(Integer id) {
		this.id = id;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getStatus() {
		return status;
	}


	public void setStatus(String status) {
		this.status = status;
	}
	
	
	
	




	public Set<SubMenu> getSubMenuList() {
		return subMenuList;
	}


	public void setSubMenuList(Set<SubMenu> subMenuList) {
		this.subMenuList = subMenuList;
	}


	public void setSeq(Integer seq) {
		this.seq = seq;
	}


	public int getSeq() {
		return seq;
	}


	public void setSeq(int seq) {
		this.seq = seq;
	}


	@Override
	public String toString() {
		return "Menu [id=" + id + ", name=" + name + ", status=" + status + ", seq=" + seq + ", subMenuList="
				+ subMenuList + "]";
	}

	
	
	

	

}