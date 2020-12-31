package com.digi.unitouch.vo;

import java.util.List;
import java.util.Map;
import java.util.Set;

public class ArticleTaskDetailsVO {

	private String journalName;

	private String journalAbbrName;

	private String userName;

	private String firstname;

	private String lastname;

	private String useremail;

	private Integer noOfPages=0;

	private String Issue;

	private String CurrentPhaseDate;

	private String DuePhaseDate;

	private Integer task_id;

	private String taskName;

	private String startDate;

	private String completedDate;

	private String paggingstartDate;

	private String paggingcompletedDate;

	private String pestartDate;

	private String pecompletedDate;

	private String authorstartDate;

	private String authorcompletedDate;

	private String vcstartDate;

	private String vccompletedDate;

	private String pe_check_ap_doneStartDate;

	private String pe_check_ap_doneCompleteDate;

	private String editorProofingStartDate;

	private String editorProofingCompleteDate;

	private String vendorXmlConversionStart;

	private String vendorXmlConversionComplete;

	private String PEXmlcheckStart;

	private String PEXmlcheckStartComplete;

	private String pe_check_ap_correctiondoneStartDate;

	private String pe_check_ap_correctiondoneCompleteDate;

	private String vendor_EP_StartDate;

	private String vendor_EP_CompleteDate;

	private String PE_check_EP_DoneStart;

	private String PE_check_EP_DoneComplete;

	private String Vendor_EP_CorrectionStart;

	private String Vendor_EP_CorrectionComplete;

	private Integer article_id;

	private String article_title;

	private String article_doi;

	private String withdrawStatus;

	private String accepted_date;

	private String aid;

	private String article_type_cd;

	private Integer age;

	private String reportsDate;
	
	private List<String> taskArray;
	
	private Map<String, TaskTime> taskMap;

	@Override
	public String toString() {
		return "ArticleTaskDetailsVO [journalName=" + journalName + ", journalAbbrName=" + journalAbbrName
				+ ", userName=" + userName + ", firstname=" + firstname + ", lastname=" + lastname + ", useremail="
				+ useremail + ", noOfPages=" + noOfPages + ", Issue=" + Issue + ", CurrentPhaseDate=" + CurrentPhaseDate
				+ ", DuePhaseDate=" + DuePhaseDate + ", task_id=" + task_id + ", taskName=" + taskName + ", startDate="
				+ startDate + ", completedDate=" + completedDate + ", paggingstartDate=" + paggingstartDate
				+ ", paggingcompletedDate=" + paggingcompletedDate + ", pestartDate=" + pestartDate
				+ ", pecompletedDate=" + pecompletedDate + ", authorstartDate=" + authorstartDate
				+ ", authorcompletedDate=" + authorcompletedDate + ", vcstartDate=" + vcstartDate + ", vccompletedDate="
				+ vccompletedDate + ", pe_check_ap_doneStartDate=" + pe_check_ap_doneStartDate
				+ ", pe_check_ap_doneCompleteDate=" + pe_check_ap_doneCompleteDate + ", editorProofingStartDate="
				+ editorProofingStartDate + ", editorProofingCompleteDate=" + editorProofingCompleteDate
				+ ", vendorXmlConversionStart=" + vendorXmlConversionStart + ", vendorXmlConversionComplete="
				+ vendorXmlConversionComplete + ", PEXmlcheckStart=" + PEXmlcheckStart + ", PEXmlcheckStartComplete="
				+ PEXmlcheckStartComplete + ", pe_check_ap_correctiondoneStartDate="
				+ pe_check_ap_correctiondoneStartDate + ", pe_check_ap_correctiondoneCompleteDate="
				+ pe_check_ap_correctiondoneCompleteDate + ", vendor_EP_StartDate=" + vendor_EP_StartDate
				+ ", vendor_EP_CompleteDate=" + vendor_EP_CompleteDate + ", PE_check_EP_DoneStart="
				+ PE_check_EP_DoneStart + ", PE_check_EP_DoneComplete=" + PE_check_EP_DoneComplete
				+ ", Vendor_EP_CorrectionStart=" + Vendor_EP_CorrectionStart + ", Vendor_EP_CorrectionComplete="
				+ Vendor_EP_CorrectionComplete + ", article_id=" + article_id + ", article_title=" + article_title
				+ ", article_doi=" + article_doi + ", withdrawStatus=" + withdrawStatus + ", accepted_date="
				+ accepted_date + ", aid=" + aid + ", article_type_cd=" + article_type_cd + ", age=" + age
				+ ", reportsDate=" + reportsDate + "]";
	}

	public String getPE_check_EP_DoneStart() {
		return PE_check_EP_DoneStart;
	}

	public void setPE_check_EP_DoneStart(String pE_check_EP_DoneStart) {
		PE_check_EP_DoneStart = pE_check_EP_DoneStart;
	}

	public String getPE_check_EP_DoneComplete() {
		return PE_check_EP_DoneComplete;
	}

	public void setPE_check_EP_DoneComplete(String pE_check_EP_DoneComplete) {
		PE_check_EP_DoneComplete = pE_check_EP_DoneComplete;
	}

	public String getVendor_EP_CorrectionStart() {
		return Vendor_EP_CorrectionStart;
	}

	public void setVendor_EP_CorrectionStart(String vendor_EP_CorrectionStart) {
		Vendor_EP_CorrectionStart = vendor_EP_CorrectionStart;
	}

	public String getVendor_EP_CorrectionComplete() {
		return Vendor_EP_CorrectionComplete;
	}

	public void setVendor_EP_CorrectionComplete(String vendor_EP_CorrectionComplete) {
		Vendor_EP_CorrectionComplete = vendor_EP_CorrectionComplete;
	}

	public String getPEXmlcheckStart() {
		return PEXmlcheckStart;
	}

	public void setPEXmlcheckStart(String pEXmlcheckStart) {
		PEXmlcheckStart = pEXmlcheckStart;
	}

	public String getPEXmlcheckStartComplete() {
		return PEXmlcheckStartComplete;
	}

	public void setPEXmlcheckStartComplete(String pEXmlcheckStartComplete) {
		PEXmlcheckStartComplete = pEXmlcheckStartComplete;
	}

	public String getPe_check_ap_correctiondoneStartDate() {
		return pe_check_ap_correctiondoneStartDate;
	}

	public void setPe_check_ap_correctiondoneStartDate(String pe_check_ap_correctiondoneStartDate) {
		this.pe_check_ap_correctiondoneStartDate = pe_check_ap_correctiondoneStartDate;
	}

	public String getPe_check_ap_correctiondoneCompleteDate() {
		return pe_check_ap_correctiondoneCompleteDate;
	}

	public void setPe_check_ap_correctiondoneCompleteDate(String pe_check_ap_correctiondoneCompleteDate) {
		this.pe_check_ap_correctiondoneCompleteDate = pe_check_ap_correctiondoneCompleteDate;
	}

	public String getVendor_EP_StartDate() {
		return vendor_EP_StartDate;
	}

	public void setVendor_EP_StartDate(String vendor_EP_StartDate) {
		this.vendor_EP_StartDate = vendor_EP_StartDate;
	}

	public String getVendor_EP_CompleteDate() {
		return vendor_EP_CompleteDate;
	}

	public void setVendor_EP_CompleteDate(String vendor_EP_CompleteDate) {
		this.vendor_EP_CompleteDate = vendor_EP_CompleteDate;
	}

	public String getPe_check_ap_doneStartDate() {
		return pe_check_ap_doneStartDate;
	}

	public void setPe_check_ap_doneStartDate(String pe_check_ap_doneStartDate) {
		this.pe_check_ap_doneStartDate = pe_check_ap_doneStartDate;
	}

	public String getPe_check_ap_doneCompleteDate() {
		return pe_check_ap_doneCompleteDate;
	}

	public void setPe_check_ap_doneCompleteDate(String pe_check_ap_doneCompleteDate) {
		this.pe_check_ap_doneCompleteDate = pe_check_ap_doneCompleteDate;
	}

	public String getEditorProofingStartDate() {
		return editorProofingStartDate;
	}

	public void setEditorProofingStartDate(String editorProofingStartDate) {
		this.editorProofingStartDate = editorProofingStartDate;
	}

	public String getEditorProofingCompleteDate() {
		return editorProofingCompleteDate;
	}

	public void setEditorProofingCompleteDate(String editorProofingCompleteDate) {
		this.editorProofingCompleteDate = editorProofingCompleteDate;
	}

	public String getVendorXmlConversionStart() {
		return vendorXmlConversionStart;
	}

	public void setVendorXmlConversionStart(String vendorXmlConversionStart) {
		this.vendorXmlConversionStart = vendorXmlConversionStart;
	}

	public String getVendorXmlConversionComplete() {
		return vendorXmlConversionComplete;
	}

	public void setVendorXmlConversionComplete(String vendorXmlConversionComplete) {
		this.vendorXmlConversionComplete = vendorXmlConversionComplete;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public String getReportsDate() {
		return reportsDate;
	}

	public void setReportsDate(String reportsDate) {
		this.reportsDate = reportsDate;
	}

	public String getJournalName() {
		return journalName;
	}

	public void setJournalName(String journalName) {
		this.journalName = journalName;
	}

	public String getJournalAbbrName() {
		return journalAbbrName;
	}

	public void setJournalAbbrName(String journalAbbrName) {
		this.journalAbbrName = journalAbbrName;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getUseremail() {
		return useremail;
	}

	public void setUseremail(String useremail) {
		this.useremail = useremail;
	}

	public Integer getNoOfPages() {
		return noOfPages;
	}

	public void setNoOfPages(Integer noOfPages) {
		this.noOfPages = noOfPages;
	}

	public String getIssue() {
		return Issue;
	}

	public void setIssue(String issue) {
		Issue = issue;
	}

	public String getCurrentPhaseDate() {
		return CurrentPhaseDate;
	}

	public void setCurrentPhaseDate(String currentPhaseDate) {
		CurrentPhaseDate = currentPhaseDate;
	}

	public String getDuePhaseDate() {
		return DuePhaseDate;
	}

	public void setDuePhaseDate(String duePhaseDate) {
		DuePhaseDate = duePhaseDate;
	}

	public Integer getTask_id() {
		return task_id;
	}

	public void setTask_id(Integer task_id) {
		this.task_id = task_id;
	}

	public String getTaskName() {
		return taskName;
	}

	public void setTaskName(String taskName) {
		this.taskName = taskName;
	}

	public String getStartDate() {
		return startDate;
	}

	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}

	public String getCompletedDate() {
		return completedDate;
	}

	public void setCompletedDate(String completedDate) {
		this.completedDate = completedDate;
	}

	public String getPaggingstartDate() {
		return paggingstartDate;
	}

	public void setPaggingstartDate(String paggingstartDate) {
		this.paggingstartDate = paggingstartDate;
	}

	public String getPaggingcompletedDate() {
		return paggingcompletedDate;
	}

	public void setPaggingcompletedDate(String paggingcompletedDate) {
		this.paggingcompletedDate = paggingcompletedDate;
	}

	public String getPestartDate() {
		return pestartDate;
	}

	public void setPestartDate(String pestartDate) {
		this.pestartDate = pestartDate;
	}

	public String getPecompletedDate() {
		return pecompletedDate;
	}

	public void setPecompletedDate(String pecompletedDate) {
		this.pecompletedDate = pecompletedDate;
	}

	public String getAuthorstartDate() {
		return authorstartDate;
	}

	public void setAuthorstartDate(String authorstartDate) {
		this.authorstartDate = authorstartDate;
	}

	public String getAuthorcompletedDate() {
		return authorcompletedDate;
	}

	public void setAuthorcompletedDate(String authorcompletedDate) {
		this.authorcompletedDate = authorcompletedDate;
	}

	public String getVcstartDate() {
		return vcstartDate;
	}

	public void setVcstartDate(String vcstartDate) {
		this.vcstartDate = vcstartDate;
	}

	public String getVccompletedDate() {
		return vccompletedDate;
	}

	public void setVccompletedDate(String vccompletedDate) {
		this.vccompletedDate = vccompletedDate;
	}

	public Integer getArticle_id() {
		return article_id;
	}

	public void setArticle_id(Integer article_id) {
		this.article_id = article_id;
	}

	public String getArticle_title() {
		return article_title;
	}

	public void setArticle_title(String article_title) {
		this.article_title = article_title;
	}

	public String getArticle_doi() {
		return article_doi;
	}

	public void setArticle_doi(String article_doi) {
		this.article_doi = article_doi;
	}

	public String getWithdrawStatus() {
		return withdrawStatus;
	}

	public void setWithdrawStatus(String withdrawStatus) {
		this.withdrawStatus = withdrawStatus;
	}

	public String getAccepted_date() {
		return accepted_date;
	}

	public void setAccepted_date(String accepted_date) {
		this.accepted_date = accepted_date;
	}

	public String getAid() {
		return aid;
	}

	public void setAid(String aid) {
		this.aid = aid;
	}

	public String getArticle_type_cd() {
		return article_type_cd;
	}

	public void setArticle_type_cd(String article_type_cd) {
		this.article_type_cd = article_type_cd;
	}

	public List<String> getTaskArray() {
		return taskArray;
	}

	public void setTaskArray(List<String> taskArray) {
		this.taskArray = taskArray;
	}

	public Map<String, TaskTime> getTaskMap() {
		return taskMap;
	}

	public void setTaskMap(Map<String, TaskTime> taskMap) {
		this.taskMap = taskMap;
	}

	public ArticleTaskDetailsVO() {
		super();
	}

	public ArticleTaskDetailsVO(Integer article_id, String article_title, String article_doi, String aid,
			String article_type_cd, String journalName, Integer task_id, String withdrawStatus, String taskName,
			String accepted_date, String firstname, String lastname, String journalAbbrName, String useremail,
			Integer noOfPages) {
		super();
		this.article_id = article_id;
		this.article_title = article_title;
		this.article_doi = article_doi;
		this.aid = aid;
		this.article_type_cd = article_type_cd;
		this.journalName = journalName;
		this.task_id = task_id;
		this.withdrawStatus = withdrawStatus;
		this.taskName = taskName;
		this.accepted_date = accepted_date;
		this.firstname = firstname;
		this.lastname = lastname;
		this.journalAbbrName = journalAbbrName;
		this.useremail = useremail;
		this.noOfPages = noOfPages;

	}


}
