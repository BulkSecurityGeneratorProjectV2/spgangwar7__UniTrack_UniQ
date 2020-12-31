package com.digi.unitouch.em.Meta;

import java.util.List;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamAsAttribute;
import com.thoughtworks.xstream.annotations.XStreamImplicit;

public class Contrib {

	@XStreamAlias("contrib-type")
	@XStreamAsAttribute
	private String contribType;
	
	@XStreamAlias("corresp")
	@XStreamAsAttribute
	private String corresp;
	
	@XStreamAlias("role")
//	@XStreamImplicit
//	@XStreamConverter(RoleConverter.class)
	private Role role;
	
	@XStreamAlias("role")
	@XStreamAsAttribute
	private String editorRole;
	
	
//	@XStreamAlias("name")
//	@XStreamAsAttribute
//	private String name;
//	
	@XStreamAlias("name")
	private Name name;
	
	@XStreamAlias("degrees")
	@XStreamAsAttribute
	private String degrees;
	
	@XStreamAlias("email")
	@XStreamAsAttribute
	private String email;
	
	@XStreamAlias("xref")
//	@XStreamImplicit
//	@XStreamConverter(XrefConverter.class)
	private Xref xref;

	//update 10-12-2020 to list
	@XStreamAlias("contrib-id")
	@XStreamAsAttribute
	@XStreamImplicit
	private List<String> contribId;


	public String getContribType() {
		return contribType;
	}


	public void setContribType(String contribType) {
		this.contribType = contribType;
	}


	public String getCorresp() {
		return corresp;
	}


	public void setCorresp(String corresp) {
		this.corresp = corresp;
	}


	public Role getRole() {
		return role;
	}


	public void setRole(Role role) {
		this.role = role;
	}


	public String getEditorRole() {
		return editorRole;
	}


	public void setEditorRole(String editorRole) {
		this.editorRole = editorRole;
	}


	public Name getName() {
		return name;
	}


	public void setName(Name name) {
		this.name = name;
	}


	public String getDegrees() {
		return degrees;
	}


	public void setDegrees(String degrees) {
		this.degrees = degrees;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public Xref getXref() {
		return xref;
	}


	public void setXref(Xref xref) {
		this.xref = xref;
	}

	public List<String> getContribId() {
		return contribId;
	}


	public void setContribId(List<String> contribId) {
		this.contribId = contribId;
	}


	@Override
	public String toString() {
		return "Contrib [contribType=" + contribType + ", corresp=" + corresp + ", role=" + role + ", editorRole="
				+ editorRole + ", name=" + name + ", degrees=" + degrees + ", email=" + email + ", xref=" + xref
				+ ", contribId=" + contribId + "]";
	}




	
	
	
}
