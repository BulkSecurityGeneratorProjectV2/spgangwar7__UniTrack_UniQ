package com.digi.unitouch.vo;

public class JournalVoDetail {


	
	private Integer JournalId;
	
	private String depname;
	
	private Integer deptId;
	
	private String journalAcronym;
	
	private String journalAbbrName;

	private String journalIssn;
	
	private String copyrightStmt;
	
	private Integer nbr_of_volume_per_year;
	private String created_by;
	
	private String journalName;
	private Integer lastIssueNbr;
	private Integer articleWorkflowId;

	public Integer getJournalId() {
		return JournalId;
	}
	public void setJournalId(Integer journalId) {
		JournalId = journalId;
	}
	public String getDepname() {
		return depname;
	}
	public void setDepname(String depname) {
		this.depname = depname;
	}
	public Integer getDeptId() {
		return deptId;
	}
	public void setDeptId(Integer deptId) {
		this.deptId = deptId;
	}
	public String getJournalAcronym() {
		return journalAcronym;
	}
	public void setJournalAcronym(String journalAcronym) {
		this.journalAcronym = journalAcronym;
	}
	public String getJournalAbbrName() {
		return journalAbbrName;
	}
	public void setJournalAbbrName(String journalAbbrName) {
		this.journalAbbrName = journalAbbrName;
	}
	public String getJournalIssn() {
		return journalIssn;
	}
	public void setJournalIssn(String journalIssn) {
		this.journalIssn = journalIssn;
	}
	public String getCopyrightStmt() {
		return copyrightStmt;
	}
	public void setCopyrightStmt(String copyrightStmt) {
		this.copyrightStmt = copyrightStmt;
	}
	public Integer getNbr_of_volume_per_year() {
		return nbr_of_volume_per_year;
	}
	public void setNbr_of_volume_per_year(Integer nbr_of_volume_per_year) {
		this.nbr_of_volume_per_year = nbr_of_volume_per_year;
	}
	public String getCreated_by() {
		return created_by;
	}
	public void setCreated_by(String created_by) {
		this.created_by = created_by;
	}
	
	public String getJournalName() {
		return journalName;
	}
	public void setJournalName(String journalName) {
		this.journalName = journalName;
	}
	public Integer getLastIssueNbr() {
		return lastIssueNbr;
	}
	public void setLastIssueNbr(Integer lastIssueNbr) {
		this.lastIssueNbr = lastIssueNbr;
	}
	public Integer getArticleWorkflowId() {
		return articleWorkflowId;
	}
	public void setArticleWorkflowId(Integer articleWorkflowId) {
		this.articleWorkflowId = articleWorkflowId;
	}
	public JournalVoDetail(Integer journalId, String depname, Integer deptId, String journalAcronym,
			String journalAbbrName, String journalIssn, String copyrightStmt, Integer nbr_of_volume_per_year,
			String created_by, String journalName, Integer lastIssueNbr, Integer articleWorkflowId) {
		super();
		JournalId = journalId;
		this.depname = depname;
		this.deptId = deptId;
		this.journalAcronym = journalAcronym;
		this.journalAbbrName = journalAbbrName;
		this.journalIssn = journalIssn;
		this.copyrightStmt = copyrightStmt;
		this.nbr_of_volume_per_year = nbr_of_volume_per_year;
		this.created_by = created_by;
		this.journalName = journalName;
		this.lastIssueNbr = lastIssueNbr;
		this.articleWorkflowId = articleWorkflowId;
	}
	
		
	}
