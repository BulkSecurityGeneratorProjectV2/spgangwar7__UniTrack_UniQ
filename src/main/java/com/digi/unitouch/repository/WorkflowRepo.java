
  package com.digi.unitouch.repository;
  
  import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.digi.unitouch.model.Workflow;
  
  public interface WorkflowRepo extends JpaRepository<Workflow, Integer> {		
	 
	  @Query(value ="SELECT * FROM workflow wrs WHERE wrs.workflow_id=:id", nativeQuery = true) 
	  public Workflow findworkflow(int id);
	  
	  @Modifying
	  @Query(value ="update workflow w set w.status='N' WHERE w.workflow_id=:id", nativeQuery = true) 
	  public void updateWorkflowStatus(int id);
	  
	  @Query(value ="SELECT * FROM workflow wrs WHERE wrs.workflow_type!=:workflowType", nativeQuery = true) 
	  public List<Workflow> findByWorkflowtype(String workflowType);
	  
	  @Query(value ="SELECT * FROM workflow wrs WHERE wrs.workflow_type=:workflowType", nativeQuery = true) 
	  public List<Workflow> findByWorkflowIssuetype(String workflowType);
	  
	  @Query(value ="SELECT * FROM workflow wrs WHERE wrs.name=:name", nativeQuery = true) 
	  public Workflow findworkflowbyname(String name);

	  @Query("SELECT wrs FROM Workflow wrs ORDER BY wrs.createdAT DESC") 
	  public List<Workflow> findlistOrderby();
  
  }
 