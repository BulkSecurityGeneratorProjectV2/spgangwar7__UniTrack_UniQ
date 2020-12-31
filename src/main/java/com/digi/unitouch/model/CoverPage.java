package com.digi.unitouch.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "cover_page")
public class CoverPage {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "cov_id")
	private Integer cov_id;

	@Column(name = "issue_id")
	private String issue_id;

	@Column(name = "cover_titel")
	private String cover_titel;

	@Column(name = "cover_no_of_page")
	private String cover_no_of_page;

	@Column(name = "wkid")
	private String wkid;

	@Column(name = "jid")
	private String jid;

	@Column(name = "cover_path")
	private String cover_path;

	@Column(name = "cover_seq")
	private String coverSeq;
  
	@Column(name = "page_id")
	private String page_id;
	
	
	@Column(name = "created_at")
	private Date created_at;

	public Integer getCov_id() {
		return cov_id;
	}

	public void setCov_id(Integer cov_id) {
		this.cov_id = cov_id;
	}

	public String getIssue_id() {
		return issue_id;
	}

	public void setIssue_id(String issue_id) {
		this.issue_id = issue_id;
	}

	public String getCover_titel() {
		return cover_titel;
	}

	public void setCover_titel(String cover_titel) {
		this.cover_titel = cover_titel;
	}

	public String getCover_no_of_page() {
		return cover_no_of_page;
	}

	public void setCover_no_of_page(String cover_no_of_page) {
		this.cover_no_of_page = cover_no_of_page;
	}

	public String getWkid() {
		return wkid;
	}

	public void setWkid(String wkid) {
		this.wkid = wkid;
	}

	public String getJid() {
		return jid;
	}

	public void setJid(String jid) {
		this.jid = jid;
	}

	public String getCover_path() {
		return cover_path;
	}

	public void setCover_path(String cover_path) {
		this.cover_path = cover_path;
	}

	public String getCoverSeq() {
		return coverSeq;
	}

	public void setCoverSeq(String coverSeq) {
		this.coverSeq = coverSeq;
	}

	public Date getCreated_at() {
		return created_at;
	}

	public void setCreated_at(Date created_at) {
		this.created_at = created_at;
	}

	public String getPage_id() {
		return page_id;
	}

	public void setPage_id(String page_id) {
		this.page_id = page_id;
	}

	@Override
	public String toString() {
		return "CoverPage [cov_id=" + cov_id + ", issue_id=" + issue_id + ", cover_titel=" + cover_titel
				+ ", cover_no_of_page=" + cover_no_of_page + ", wkid=" + wkid + ", jid=" + jid + ", cover_path="
				+ cover_path + ", coverSeq=" + coverSeq + ", page_id=" + page_id + ", created_at=" + created_at + "]";
	}

}
