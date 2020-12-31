package com.digi.unitouch.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Table;

@Entity
@Table(name="file_attachments")
public class FileAttachments {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="id")
	private Integer id;
	
	@Column(name="jid")
	private Integer jid;
	
	@Column(name="article_id")
	private Integer aid;
	
	@Column(name="file_name")
	private String fileName;
	
	@Column(name="file_path")
	private String filePath;
	
	@Column(name="comment")
	private String comment;
	
	@Column(name="created_by")
	private Integer created_by;
	
	/*
	 * @JoinColumn(name="created_by") private Users user;
	 */
	
	@Column(name="created_at")
	private Date created_at;

	
	
	public Integer getId() {
		return id;
	}


	public void setId(Integer id) {
		this.id = id;
	}


	public Integer getJid() {
		return jid;
	}


	public void setJid(Integer jid) {
		this.jid = jid;
	}


	public Integer getAid() {
		return aid;
	}


	public void setAid(Integer aid) {
		this.aid = aid;
	}


	public String getFileName() {
		return fileName;
	}


	public void setFileName(String fileName) {
		this.fileName = fileName;
	}


	public String getFilePath() {
		return filePath;
	}


	public void setFilePath(String filePath) {
		this.filePath = filePath;
	}


	public String getComment() {
		return comment;
	}


	public void setComment(String comment) {
		this.comment = comment;
	}


	public Integer getCreated_by() {
		return created_by;
	}


	public void setCreated_by(Integer created_by) {
		this.created_by = created_by;
	}


	public Date getCreated_at() {
		return created_at;
	}


	public void setCreated_at(Date created_at) {
		this.created_at = created_at;
	}


//	public Users getUser() {
//		return user;
//	}
//
//
//	public void setUser(Users user) {
//		this.user = user;
//	}


	@Override
	public String toString() {
		return "FileAttachments [id=" + id + ", jid=" + jid + ", aid=" + aid + ", fileName=" + fileName + ", filePath="
				+ filePath + ", comment=" + comment + ", created_by=" + created_by + ", created_at=" + created_at + "]";
	}
		
}
