
  package com.digi.unitouch.repository;
  

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import com.digi.unitouch.model.ManageJournalWorkflow;
  
  public interface ManageJournalworkflowRepo extends JpaRepository<ManageJournalWorkflow, Integer> {

	  @Query(value = " SELECT dr from  ManageJournalWorkflow dr WHERE  dr.journal_id=:journalId and dr.workflow_id=:workflowid and dr.role_id=:roleId")
	ManageJournalWorkflow getdepartmentIdby(int workflowid, int journalId, int roleId);

	  @Transactional
	  @Modifying
	  @Query(value = " delete  from  com.digi.unitouch.model.ManageJournalWorkflow dr WHERE  dr.journal_id=:journalId and dr.workflow_id=:workflowid")
	 void deleteManageJournalworkflow(@Param("journalId") int journalId, @Param("workflowid") int workflowid);
	  
	  @Query(value = "SELECT dr from  ManageJournalWorkflow dr WHERE  dr.journal_id=:journalId" )
	List<ManageJournalWorkflow> getmanagedetailsbyId(int journalId);

	  @Query(value = " SELECT dr from  ManageJournalWorkflow dr WHERE  dr.journal_id=:journalId and dr.workflow_id=:workflowid and dr.role_id=:roleId and dr.task_id=:taskID")
	  ManageJournalWorkflow getdepartmentIdallby(int workflowid, int journalId, int roleId, int taskID);

	  @Query(value = " SELECT dr from  ManageJournalWorkflow dr WHERE  dr.journal_id=:journalId and dr.workflow_id=:workflowid and dr.task_id=:taskID")
		ManageJournalWorkflow getUsersallby(int workflowid, int journalId, int taskID);
	  
//	  @Query(value = " SELECT dr from  ManageJournalWorkflow dr WHERE  dr.journal_id=:journalId and dr.workflow_id=:workflowid and dr.role_id=:roleId and dr.task_id=:taskID and dr.fileFtp=:ftpFile")
//	  ManageJournalWorkflow getdepartmentIdallby(int workflowid, int journalId, int roleId, int taskID,String ftpFile);

	  @Query(value = "SELECT dr from  ManageJournalWorkflow dr WHERE  dr.journal_id=:journalId and dr.workflow_id=:wfId" )
	List<ManageJournalWorkflow> getlistbyId(int journalId, int wfId);

	  @Transactional
	  @Modifying
	  @Query(value = " delete  from  com.digi.unitouch.model.ManageJournalWorkflow dr WHERE  dr.journal_id=:journalId")
	void deleteManageJournalwork(int journalId);
	 
//	  @Query(value = "SELECT dr from  ManageJournalWorkflow dr WHERE  dr.dept_id=:dptId" )
//		List<ManageJournalWorkflow> getmanagedetailsbyDptId(int dptId);
//	  

	@Query(value = "SELECT mjw from  ManageJournalWorkflow mjw WHERE  mjw.user_id=:userid GROUP BY mjw.journal_id")
	List<ManageJournalWorkflow> getmanagedetailsbyUserId(int userid);
	  
	  @Query(value = "SELECT dr from  ManageJournalWorkflow dr WHERE  dr.role_id=:role" )
		List<ManageJournalWorkflow> getmanagedetailsbyroleId(int role);


	
  }
 