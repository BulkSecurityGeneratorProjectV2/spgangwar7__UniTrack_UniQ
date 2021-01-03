package com.digi.unitouch.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "workflow_task_details")
public class WorkflowTaskSeq {

	@GeneratedValue(strategy = GenerationType.AUTO)
	@Id
	@Column(name = "id")
	private Integer id;

	@OneToOne(optional = false)
	@JoinColumn(name = "workflow_id",insertable = false,updatable = false)
	private Workflow workflow;
	
	@Column(name = "workflow_id")
	private Integer workflowId;

	@Column(name = "sequence")
	private Integer sequence;

	@ManyToOne
	@JoinColumn(name = "task_id",insertable = false,updatable = false)
	private TaskDetails task;
	
	@Column(name = "task_id")
	private Integer taskId;

	@ManyToOne
	@JoinColumn(name = "role_id",insertable = false,updatable = false)
	private Role role;
	
	@Column(name = "role_id")
	private Integer RoleId;

	@Column(name = "read_only")
	private String readOnly;

	@Column(name = "assign_back")
	private String assign_back ;
	
	@Column(name = "email_flag")
	private String emailFlag;
	
	@Column(name = "email_id")
	private String emailId;
	
	@Column(name = "skip")
	private String skip ;
	
	@Column(name = "file_type")
	private String fileType;
	
	@Column(name = "approval")
	private String approval;

	@Column(name = "edite_issue_journal")
	private String editeIssueJournal;

	
	@Column(name = "tat")
	private Integer tat;
	

	@Column(name = "noms")
	private Integer noms;

	@Column(name = "infloder")
	private String inFloder;

	@Column(name = "outfolder")
	private String outFolder;

	@Column(name = "created_by")
	private String createdBy;

	@Column(name = "created_at")
	private Date createdAt;

	public WorkflowTaskSeq() {}
	
	public WorkflowTaskSeq(Integer seq,Integer wr) {
		super();
		this.sequence = seq;
		this.workflowId = wr;
	
	}

	public TaskDetails getTask() {
		return task;
	}

	public void setTask(TaskDetails task) {
		this.task = task;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Workflow getWorkflow() {
		return workflow;
	}

	public void setWorkflow(Workflow workflow) {
		this.workflow = workflow;
	}

	public Integer getWorkflowId() {
		return workflowId;
	}

	public void setWorkflowId(Integer workflowId) {
		this.workflowId = workflowId;
	}

	public Integer getSequence() {
		return sequence;
	}

	public void setSequence(Integer sequence) {
		this.sequence = sequence;
	}

	public Integer getTaskId() {
		return taskId;
	}

	public void setTaskId(Integer taskId) {
		this.taskId = taskId;
	}

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

	public Integer getRoleId() {
		return RoleId;
	}

	public void setRoleId(Integer roleId) {
		RoleId = roleId;
	}

	public String getReadOnly() {
		return readOnly;
	}

	public void setReadOnly(String readOnly) {
		this.readOnly = readOnly;
	}

	public String getEmailFlag() {
		return emailFlag;
	}

	public void setEmailFlag(String emailFlag) {
		this.emailFlag = emailFlag;
	}

	public String getAssign_back() {
		return assign_back;
	}

	public void setAssign_back(String assign_back) {
		this.assign_back = assign_back;
	}

	public Integer getTat() {
		return tat;
	}

	public void setTat(Integer tat) {
		this.tat = tat;
	}

	public String getInFloder() {
		return inFloder;
	}

	public void setInFloder(String inFloder) {
		this.inFloder = inFloder;
	}

	public String getOutFolder() {
		return outFolder;
	}

	public void setOutFolder(String outFolder) {
		this.outFolder = outFolder;
	}

	public String getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	public Date getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	public String getApproval() {
		return approval;
	}

	public void setApproval(String approval) {
		this.approval = approval;
	}

	public String getSkip() {
		return skip;
	}

	public void setSkip(String skip) {
		this.skip = skip;
	}

	public String getFileType() {
		return fileType;
	}

	public void setFileType(String fileType) {
		this.fileType = fileType;
	}

	public String getEditeIssueJournal() {
		return editeIssueJournal;
	}

	public void setEditeIssueJournal(String editeIssueJournal) {
		this.editeIssueJournal = editeIssueJournal;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	
	public Integer getNoms() {
		return noms;
	}

	public void setNoms(Integer noms) {
		this.noms = noms;
	}

	@Override
	public String toString() {
		return "WorkflowTaskSeq [id=" + id + ", workflow=" + workflow + ", workflowId=" + workflowId + ", sequence="
				+ sequence + ", task=" + task + ", taskId=" + taskId + ", role=" + role + ", RoleId=" + RoleId
				+ ", readOnly=" + readOnly + ", assign_back=" + assign_back + ", emailFlag=" + emailFlag + ", emailId="
				+ emailId + ", skip=" + skip + ", fileType=" + fileType + ", approval=" + approval
				+ ", editeIssueJournal=" + editeIssueJournal + ", tat=" + tat + ", inFloder=" + inFloder
				+ ", outFolder=" + outFolder + ", createdBy=" + createdBy + ", createdAt=" + createdAt + "]";
	}


}