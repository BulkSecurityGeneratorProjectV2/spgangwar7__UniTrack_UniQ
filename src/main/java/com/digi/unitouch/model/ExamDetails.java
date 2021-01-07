package com.digi.unitouch.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "exam_details")
public class ExamDetails {

	@GeneratedValue(strategy = GenerationType.AUTO)
	@Id
	@Column(name = "exam_id")
	private Integer examID;
	
	@Column(name = "exam_name")
	private String examName;

	@Column(name = "exam_description")
	private String examDescription;

	@Column(name = "create_time")
	private Date createTime;

	@Column(name = "update_time")
	private Date updateTime;

	@Column(name = "journal_id")
	private Integer journalId;

//	@OneToOne(optional = false)
//	@JoinColumn(name = "journal_id", insertable = false, updatable = false)
//	private Journal journals;

	@Column(name = "create_by")
	private Integer create_by;
	
	public Integer getExamID() {
		return examID;
	}

	public void setExamID(Integer examID) {
		this.examID = examID;
	}

	public String getExamName() {
		return examName;
	}

	public void setExamName(String examName) {
		this.examName = examName;
	}

	public String getExamDescription() {
		return examDescription;
	}

	public void setExamDescription(String examDescription) {
		this.examDescription = examDescription;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public Date getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}

	public Integer getJournalId() {
		return journalId;
	}

	public void setJournalId(Integer journalId) {
		this.journalId = journalId;
	}

//	public Journal getJournals() {
//		return journals;
//	}
//
//	public void setJournals(Journal journals) {
//		this.journals = journals;
//	}

	public Integer getCreate_by() {
		return create_by;
	}

	public void setCreate_by(Integer create_by) {
		this.create_by = create_by;
	}

	@Override
	public String toString() {
		return "ExamDetails [examID=" + examID + ", examName=" + examName + ", examDescription=" + examDescription
				+ ", createTime=" + createTime + ", updateTime=" + updateTime + ", journalId=" + journalId
				+ ", create_by=" + create_by + "]";
	}

	


}
