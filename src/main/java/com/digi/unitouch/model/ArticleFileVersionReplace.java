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
@Table(name = "article_file_version_replace")
public class ArticleFileVersionReplace {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "afvr_id")
	private Integer id;

	@Column(name = "articel_id")
	private Integer articleId;
	


	@Column(name = "journal_id")
	private Integer journalId;

	
	
	@Column(name = "task_id")
	private Integer taskId;

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

	@Override
	public String toString() {
		return "ArticleFileVersionReplace [id=" + id + ", articleId=" + articleId + ", journalId=" + journalId
				+ ", taskId=" + taskId + ", fileName=" + fileName + ", fileType=" + fileType + ", size=" + size
				+ ", fileVersion=" + fileVersion + ", filePath=" + filePath + ", createdAt=" + createdAt
				+ ", created_by=" + created_by + ", updaetdAt=" + updaetdAt + ", updatedBy=" + updatedBy + "]";
	}


}
