
  package com.digi.unitouch.repository;
  
  import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import
  org.springframework.data.jpa.repository.Modifying;
import
  org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import
  com.digi.unitouch.model.WorkflowTaskSeq;
import com.digi.unitouch.vo.WorkflowMax;
import com.digi.unitouch.vo.WorkflowtaskVO;
  
  public interface WorkflowTaskRepo extends JpaRepository<WorkflowTaskSeq,
  Integer>{
  
  @Modifying(clearAutomatically = true)
  
  @Query("update WorkflowTaskSeq wrs set wrs.tat =:tat,wrs.readOnly=:read,wrs.emailFlag=:emailFlag,wrs.RoleId=:roleID where wrs.taskId =:taskId and wrs.workflowId=:workFlowId"
  ) void updateTaskWorkflowRole(Integer workFlowId,Integer taskId,Integer
  tat,String read,String emailFlag,Integer roleID);
  
  @Modifying
  
  @Query(value =
  "INSERT INTO workflow_task_details (workflow_id, step_no, task_id, read_only, email_flag, tat,infloder,outfolder) VALUES (:workflowId, :stepNo, :taskId, :readOnly, :emailFlag,:tat,:inFolder,:outFolder)"
  ,nativeQuery=true) void createTaskWorkflowRole(Integer workflowId,Integer
  stepNo,String emailFlag,String readOnly,Integer tat,Integer taskId,String
  inFolder, String outFolder);
  
  @Query(value
  ="SELECT * FROM workflow_task_details wrs WHERE wrs.workflow_id=:id",
  nativeQuery = true) public List<WorkflowTaskSeq> getTaskByWorkflow(Integer
  id);
	/*
	 * @Modifying(clearAutomatically = true)
	 * 
	 * @Query("update Users ud set ud.password =:password , ud.email=:email , ud.active=:active , ud.firstName=:firstName , ud.lastName=:lastName where ud.id =:id"
	 * ) void updateUserDetails(Integer id,String password,String email,String
	 * active,String firstName,String lastName); void
	 * updateworkflowTaskSeq(WorkflowTaskSeq workflowTaskSeq);
	 */
  
  
  @Query(value ="SELECT wrs FROM WorkflowTaskSeq wrs WHERE wrs.taskId=:id and wrs.workflowId=:wiD") 
  		public WorkflowTaskSeq findTaskSeq(Integer id, int wiD);
  
	/*
	 * @Query(value
	 * ="SELECT * FROM workflow_task_details wrs WHERE wrs.workflow_id=:id",
	 * nativeQuery = true) public WorkflowTaskSeq findById(Integer id);
	 */
  @Query("SELECT u FROM WorkflowTaskSeq u WHERE u.workflowId=:id")
	List<WorkflowTaskSeq> findWorkflowById(int id);
  
  @Query("SELECT u FROM WorkflowTaskSeq u WHERE u.workflowId=:wkfid AND u.RoleId IS NOT NULL")
	List<WorkflowTaskSeq> workflowTaskSeqlistWithRole(int wkfid);


@Modifying(clearAutomatically = true)
@Query("update WorkflowTaskSeq wrs set wrs.tat =:tat,wrs.readOnly=:readOnly,wrs.emailFlag=:emailFlag,wrs.RoleId=:RoleId where wrs.taskId =:taskId and wrs.workflowId=:id")
void updateworkflowTask(Integer id,Integer taskId,Integer tat,String readOnly,String emailFlag,Integer RoleId);

@Query("SELECT u FROM WorkflowTaskSeq u WHERE u.id=:id")
public WorkflowTaskSeq findworkflowTaskSeqbyId(Integer id);

@Query("SELECT u FROM Journal u WHERE u.journalId=:journalId")
public void getworkflowId(Integer journalId);

@Transactional
@Modifying
@Query("delete from com.digi.unitouch.model.WorkflowTaskSeq u WHERE u.workflowId= :id ")
public void deletebyworkflowId(int id);

@Query("SELECT wtd from WorkflowTaskSeq wtd WHERE wtd.workflowId=:wfid AND wtd.sequence='0'")
WorkflowTaskSeq getTaskId(int wfid);

@Query(value ="SELECT * FROM workflow_task_details wtd WHERE wtd.sequence=:nextTaskSequence and wtd.workflow_id=:workFlowID", nativeQuery = true) 
WorkflowTaskSeq getNextTaskIdBy(int nextTaskSequence, int workFlowID);

	  

@Query(value="Select wrkt From WorkflowTaskSeq wrkt WHERE workflowId =:workFlowID AND sequence=:currentTaskSequence")
List<WorkflowTaskSeq> getTaskNameByWrkAndTaskId(int workFlowID, int currentTaskSequence);

@Query(value=" SELECT new com.digi.unitouch.vo.WorkflowtaskVO(wtd.taskId,t.taskName )FROM com.digi.unitouch.model.WorkflowTaskSeq wtd "
		+" JOIN com.digi.unitouch.model.TaskDetails t ON t.id = wtd.taskId WHERE wtd.workflowId=:id")
             List<WorkflowtaskVO> WorkflowtaskVOlist(int id);

@Query("SELECT wtd from WorkflowTaskSeq wtd WHERE wtd.workflowId=:workflowsid AND wtd.sequence=:seqNo")
WorkflowTaskSeq getTaskIdandWorkflowid(Integer workflowsid ,Integer seqNo);

//@Query("SELECT  new com.digi.unitouch.vo.WorkflowMax(wts.sequence as sequence,wts.workflowId as workflowId,wts.taskId as taskId) FROM com.digi.unitouch.model.WorkflowTaskSeq wts "
//		+"JOIN Workflow w ON w.id=wts.workflowId"
//		+ "WHERE WorkflowTaskSeq.sequence IN (SELECT MAX(wtdd.sequence) FROM com.digi.unitouch.model.WorkflowTaskSeq wtdd WHERE wtdd.workflowId=w.id)"
//		+ "AND wts.workflowId=w.id"
//		+"GROUP BY wts.workflowId")
@Query(value="SELECT *\r\n" + 
		"FROM workflow_task_details wds \r\n" + 
		"JOIN workflow w ON w.workflow_id=wds.workflow_id\r\n" + 
		"WHERE wds.sequence IN  \r\n" + 
		"(SELECT  MAX(wtdd.sequence)  FROM workflow_task_details wtdd WHERE wtdd.workflow_id=w.workflow_id)\r\n" + 
		"AND wds.workflow_id=w.workflow_id\r\n" + 
		"GROUP BY wds.workflow_id  ", nativeQuery=true)
List<WorkflowTaskSeq> findMaxSeqNumberInWorkflowTaskSeq();

@Query(value="SELECT *\r\n" + 
		"FROM workflow_task_details wds \r\n" + 
		"JOIN workflow w ON w.workflow_id=wds.workflow_id\r\n" + 
		"WHERE wds.sequence IN  \r\n" + 
		"(SELECT  MAX(wtdd.sequence)-1  FROM workflow_task_details wtdd WHERE wtdd.workflow_id=w.workflow_id)\r\n" + 
		"AND wds.workflow_id=w.workflow_id\r\n" + 
		"GROUP BY wds.workflow_id  ", nativeQuery=true)
List<WorkflowTaskSeq> findLastMaxSeqNumberInWorkflowTaskSeq();


}

 