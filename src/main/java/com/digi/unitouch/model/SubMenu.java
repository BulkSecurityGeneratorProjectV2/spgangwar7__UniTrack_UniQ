package com.digi.unitouch.model;

/**
 * @author Aditya
 *
 */

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "sys_function")
public class SubMenu {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "function_id")
	private Integer id;

	@Column(name = "name")
	private String sname;

	@Column(name = "uri")
	private String uri;

	@Column(name = "code")
	private String code;

	@Column(name = "status")
	private String status;

	@Column(name = "seq")
	private Integer seq;

	@ManyToOne
	@JoinColumn(name="menu_id", insertable = false, updatable = false)
	private Menu menu;
	
	@Column(name = "menu_id")
	private Integer menuId;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}


	public String getUri() {
		return uri;
	}

	public void setUri(String uri) {
		this.uri = uri;
	}

	public String getCode() {
		return code;
	}

	
	public String getSname() {
		return sname;
	}

	public void setSname(String sname) {
		this.sname = sname;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Integer getSeq() {
		return seq;
	}

	public void setSeq(Integer seq) {
		this.seq = seq;
	}

	public Menu getMenu() {
		return menu;
	}

	public void setMenu(Menu menu) {
		this.menu = menu;
	}

	public Integer getMenuId() {
		return menuId;
	}

	public void setMenuId(Integer menuId) {
		this.menuId = menuId;
	}

	@Override
	public String toString() {
		return "SubMenu [id=" + id + ", sname=" + sname + ", uri=" + uri + ", code=" + code + ", status=" + status
				+ ", seq=" + seq + ", menuId=" + menuId + "]";
	}
	
	

	

}