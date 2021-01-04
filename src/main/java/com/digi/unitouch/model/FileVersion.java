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

import org.springframework.stereotype.Component;

@Entity
@Table(name = "file_version")
@Component
public class FileVersion {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "file_id")
	private Integer id;

	@Column(name = "articel_id")
	private Integer articleId;
	
	@OneToOne
	@JoinColumn(name = "articel_id",insertable = false,updatable = false)
	private ArticleDetail articleDeatils;

	@Column(name = "journal_id")
	private Integer journalId;

	@OneToOne
	@JoinColumn(name = "task_id",insertable = false,updatable = false)
	private TaskDetails taskDetails;
	
	@Column(name = "task_id")
	private Integer taskId;

	@Column(name = "file_Name")
	private String fileName;

	@Column(name = "file_type")
	private String fileType;

	@Column(name = "file_size")
	private String size;
	
	@Column(name = "que_in_file")
	private String queInFile;

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
	
	@Column(name = "updated_at")
	private Date updaetdAt;
	
	@Column(name = "updated_by")
	private Integer updatedBy;
	

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getArticleId() {
		return articleId;
	}

	public void setArticleId(Integer articleId) {
		this.articleId = articleId;
	}

	public Integer getJournalId() {
		return journalId;
	}

	public void setJournalId(Integer journalId) {
		this.journalId = journalId;
	}

	public Integer getTaskId() {
		return taskId;
	}

	public void setTaskId(Integer taskId) {
		this.taskId = taskId;
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

	public TaskDetails getTaskDetails() {
		return taskDetails;
	}

	public void setTaskDetails(TaskDetails taskDetails) {
		this.taskDetails = taskDetails;
	}

	public Users getUserDetails() {
		return userDetails;
	}

	public void setUserDetails(Users userDetails) {
		this.userDetails = userDetails;
	}

	public ArticleDetail getArticleDeatils() {
		return articleDeatils;
	}

	public void setArticleDeatils(ArticleDetail articleDeatils) {
		this.articleDeatils = articleDeatils;
	}

	public Date getUpdaetdAt() {
		return updaetdAt;
	}

	public void setUpdaetdAt(Date updaetdAt) {
		this.updaetdAt = updaetdAt;
	}

	public Integer getUpdatedBy() {
		return updatedBy;
	}

	public void setUpdatedBy(Integer updatedBy) {
		this.updatedBy = updatedBy;
	}

	public String getQueInFile() {
		return queInFile;
	}

	public void setQueInFile(String queInFile) {
		this.queInFile = queInFile;
	}

	@Override
	public String toString() {
		return "FileVersion [id=" + id + ", articleId=" + articleId + ", articleDeatils=" + articleDeatils
				+ ", journalId=" + journalId + ", taskDetails=" + taskDetails + ", taskId=" + taskId + ", fileName="
				+ fileName + ", fileType=" + fileType + ", size=" + size + ", queInFile=" + queInFile + ", fileVersion="
				+ fileVersion + ", filePath=" + filePath + ", createdAt=" + createdAt + ", created_by=" + created_by
				+ ", userDetails=" + userDetails + ", updaetdAt=" + updaetdAt + ", updatedBy=" + updatedBy + "]";
	}



}
