package com.digi.unitouch.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "manage_journal_workflow")
public class ManageJournalWorkflow {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	private Integer id;
	
	@Column(name = "journal_id")
	private Integer journal_id;
	
	@Column(name = "role_id")
	private Integer role_id;
	
	@OneToOne
	@JoinColumn(name = "role_id",insertable = false,updatable = false)
	private Role role;
	
	@Column(name = "workflow_id") 
	private Integer workflow_id;
	
//	@OneToOne
//	@JoinColumn(name = "dept_id",insertable = false,updatable = false)
//	private Department department;
//	
	@Column(name = "dept_id")
	private Integer dept_id;
	
	@OneToOne
	@JoinColumn(name = "usr_id",insertable = false,updatable = false)
	private Users users;
	
	@Column(name = "usr_id")
	private Integer user_id;
	
	@Column(name = "task_id")
	private Integer task_id;
	
	@OneToOne(optional = false)
	@JoinColumn(name = "task_id",insertable = false,updatable = false)
	private TaskDetails task;
	
	@Column(name="ftp_file_input")
	private String fileFtpInput;
	

	@Column(name="ftp_file_output")
	private String fileFtpOutput;
	
	@Column(name="ftp_input_username")
	private String ftpinputusername;
	
	@Column(name="ftp_input_username_Ip")
	private String ftpinputusernameIp;
	
	@Column(name="ftp_input_password")
	private String ftpinputpassword;
	
	@Column(name="ftp_output_username_Ip")
	private String ftpoutputusernameIp;
	
	@Column(name="ftp_output_username")
	private String ftpoutputusername;
	
	@Column(name="ftp_output_password")
	private String ftpoutputpassword;

	
	public Users getUsers() {
		return users;
	}

	public void setUsers(Users users) {
		this.users = users;
	}

	public Integer getUser_id() {
		return user_id;
	}

	public void setUser_id(Integer user_id) {
		this.user_id = user_id;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getJournal_id() {
		return journal_id;
	}

	public void setJournal_id(Integer journal_id) {
		this.journal_id = journal_id;
	}

	public Integer getRole_id() {
		return role_id;
	}

	public void setRole_id(Integer role_id) {
		this.role_id = role_id;
	}

	public Integer getWorkflow_id() {
		return workflow_id;
	}

	public void setWorkflow_id(Integer workflow_id) {
		this.workflow_id = workflow_id;
	}

	public Integer getDept_id() {
		return dept_id;
	}

	public void setDept_id(Integer dept_id) {
		this.dept_id = dept_id;
	}

	
	public Integer getTask_id() {
		return task_id;
	}

	public void setTask_id(Integer task_id) {
		this.task_id = task_id;
	}

//	public Department getDepartment() {
//		return department;
//	}
//
//	public void setDepartment(Department department) {
//		this.department = department;
//	}


	public String getFileFtpInput() {
		return fileFtpInput;
	}

	public void setFileFtpInput(String fileFtpInput) {
		this.fileFtpInput = fileFtpInput;
	}

	public String getFileFtpOutput() {
		return fileFtpOutput;
	}

	public void setFileFtpOutput(String fileFtpOutput) {
		this.fileFtpOutput = fileFtpOutput;
	}

	public String getFtpinputusername() {
		return ftpinputusername;
	}

	public void setFtpinputusername(String ftpinputusername) {
		this.ftpinputusername = ftpinputusername;
	}

	public String getFtpinputusernameIp() {
		return ftpinputusernameIp;
	}

	public void setFtpinputusernameIp(String ftpinputusernameIp) {
		this.ftpinputusernameIp = ftpinputusernameIp;
	}

	public String getFtpinputpassword() {
		return ftpinputpassword;
	}

	public void setFtpinputpassword(String ftpinputpassword) {
		this.ftpinputpassword = ftpinputpassword;
	}

	public String getFtpoutputusernameIp() {
		return ftpoutputusernameIp;
	}

	public void setFtpoutputusernameIp(String ftpoutputusernameIp) {
		this.ftpoutputusernameIp = ftpoutputusernameIp;
	}

	public String getFtpoutputusername() {
		return ftpoutputusername;
	}

	public void setFtpoutputusername(String ftpoutputusername) {
		this.ftpoutputusername = ftpoutputusername;
	}

	public String getFtpoutputpassword() {
		return ftpoutputpassword;
	}

	public void setFtpoutputpassword(String ftpoutputpassword) {
		this.ftpoutputpassword = ftpoutputpassword;
	}

	public TaskDetails getTask() {
		return task;
	}

	public void setTask(TaskDetails task) {
		this.task = task;
	}

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

	@Override
	public String toString() {
		return "ManageJournalWorkflow [id=" + id + ", journal_id=" + journal_id + ", role_id=" + role_id
				+ ", workflow_id=" + workflow_id + ", dept_id=" + dept_id + ", users=" + users + ", user_id=" + user_id
				+ ", task_id=" + task_id + ", task=" + task + ", fileFtpInput=" + fileFtpInput + ", fileFtpOutput="
				+ fileFtpOutput + ", ftpinputusername=" + ftpinputusername + ", ftpinputusernameIp="
				+ ftpinputusernameIp + ", ftpinputpassword=" + ftpinputpassword + ", ftpoutputusernameIp="
				+ ftpoutputusernameIp + ", ftpoutputusername=" + ftpoutputusername + ", ftpoutputpassword="
				+ ftpoutputpassword + "]";
	}
	
}
