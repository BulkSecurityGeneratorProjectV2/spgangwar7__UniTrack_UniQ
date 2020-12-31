package com.digi.unitouch.service;

import java.util.List;
import java.util.Set;

import com.digi.unitouch.model.Department;
import com.digi.unitouch.model.ManageJournalWorkflow;

public interface ManageJournalworkflowService {
	
	public boolean savemanageworkflow(ManageJournalWorkflow manageJournalWorkflow);

	public ManageJournalWorkflow getdepartmentIdby(int workflowid, int journalId, int roleId);

	public void deleteManageJournalworkflow(int journalId, int workflowid);

	public List<ManageJournalWorkflow> getmanagedetailsbyId(int journalId);

	public ManageJournalWorkflow getdepartmentIdallby(int workflowid, int journalId, int roleId, int taskID);
	
	public ManageJournalWorkflow getUsersallby(int workflowid, int journalId, int taskID);
	
//	public ManageJournalWorkflow getdepartmentIdallby(int workflowid, int journalId, int roleId, int taskID,String ftpFile);

	public List<ManageJournalWorkflow> getlistbyId(int journalId, int wfId);

	public void deleteManageJournalwork(int parseInt);

	public ManageJournalWorkflow findBymjWkID(Integer id);
	
	public List<ManageJournalWorkflow> getManageJournalByroleId(int role);

	List<ManageJournalWorkflow> getmanagedetailsbyUserId(int userid);
	
//	public Set<Department> getGroupList(int journalId, int wfId);

	//public List<ManageJournalWorkflow> getManageJournalByDptId(Integer dptId);



}
