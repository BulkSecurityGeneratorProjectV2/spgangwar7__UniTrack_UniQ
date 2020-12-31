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
@Table(name = "issue_file_version")
public class IssueFileVersion {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "issue_file_id")
	private Integer id;

	@Column(name = "issue_id")
	private Integer issueId;

	@Column(name = "journal_id")
	private Integer journalId;

	@OneToOne
	@JoinColumn(name = "task_id",insertable = false,updatable = false)
	private TaskDetails taskDetails;
	
	@Column(name = "task_id")
	private Integer taskId;

	@Column(name="cover_name")
	private String cover_name;
	
	@Column(name = "file_Name")
	private String fileName;

	@Column(name = "file_type")
	private String fileType;

	@Column(name = "file_size")
	private String size;

	@Column(name = "file_version")
	private Integer fileVersion;

	@Column(name = "file_path")
	private String filePath;

	@Column(name = "created_at")
	private Date createdAt;

	@Column(name = "created_by")
	private Integer created_by;

	@OneToOne
	@JoinColumn(name = "created_by",insertable = false,updatable = false)
	private Users userDetails;
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getIssueId() {
		return issueId;
	}

	public void setIssueId(Integer issueId) {
		this.issueId = issueId;
	}

	public Integer getJournalId() {
		return journalId;
	}

	public void setJournalId(Integer journalId) {
		this.journalId = journalId;
	}

	public TaskDetails getTaskDetails() {
		return taskDetails;
	}

	public void setTaskDetails(TaskDetails taskDetails) {
		this.taskDetails = taskDetails;
	}

	public Integer getTaskId() {
		return taskId;
	}

	public void setTaskId(Integer taskId) {
		this.taskId = taskId;
	}

	public String getCover_name() {
		return cover_name;
	}

	public void setCover_name(String cover_name) {
		this.cover_name = cover_name;
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public String getFileType() {
		return fileType;
	}

	public void setFileType(String fileType) {
		this.fileType = fileType;
	}

	public String getSize() {
		return size;
	}

	public void setSize(String size) {
		this.size = size;
	}

	public Integer getFileVersion() {
		return fileVersion;
	}

	public void setFileVersion(Integer fileVersion) {
		this.fileVersion = fileVersion;
	}

	public String getFilePath() {
		return filePath;
	}

	public void setFilePath(String filePath) {
		this.filePath = filePath;
	}

	public Date getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	public Integer getCreated_by() {
		return created_by;
	}

	public void setCreated_by(Integer created_by) {
		this.created_by = created_by;
	}
	

	public Users getUserDetails() {
		return userDetails;
	}

	public void setUserDetails(Users userDetails) {
		this.userDetails = userDetails;
	}

	@Override
	public String toString() {
		return "IssueFileVersion [id=" + id + ", issueId=" + issueId + ", journalId=" + journalId + ", taskDetails="
				+ taskDetails + ", taskId=" + taskId + ", cover_name=" + cover_name + ", fileName=" + fileName
				+ ", fileType=" + fileType + ", size=" + size + ", fileVersion=" + fileVersion + ", filePath="
				+ filePath + ", createdAt=" + createdAt + ", created_by=" + created_by + ", userDetails=" + userDetails
				+ "]";
	}


}
