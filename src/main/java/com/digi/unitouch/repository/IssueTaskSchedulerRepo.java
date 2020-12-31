package com.digi.unitouch.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.digi.unitouch.model.IssueTaskScheduler;

public interface IssueTaskSchedulerRepo extends JpaRepository<IssueTaskScheduler, Integer> {

	
	@Query("select u from IssueTaskScheduler u where u.issueId=?1 and u.taskId=?2")
	public IssueTaskScheduler getIssueSchedulerDetail(Integer issueID,Integer taskId);
	
	@Query("select u from IssueTaskScheduler u where u.issueId=?1")
	public List<IssueTaskScheduler> getIssueSchedulerDetailByIssueID(Integer issueID);
	
	@Modifying(clearAutomatically = true)
	@Query("update IssueTaskScheduler ts set ts.taskEstTimeFrom=null,ts.taskEstTimeEnd=null, ts.userId=null, ts.taskStatus=:taskStatus  where ts.issueId=:aid and ts.taskId=:taskid and ts.workflowId=:workFlowID")
	void changeTaskStatusUserDel(int aid, int taskid, int workFlowID, String taskStatus);

	@Modifying(clearAutomatically = true)
	@Query("update IssueTaskScheduler ts set ts.taskEstTimeFrom=null,ts.taskEstTimeEnd=null, ts.taskStatus=:taskStatus  where ts.issueId=:aid and ts.taskId=:taskid and ts.workflowId=:workFlowID")
	void changeTaskStatus(int aid, int taskid, int workFlowID, String taskStatus);

	@Query("select u from IssueTaskScheduler u where u.taskId=?2 and u.workflowId=?1 and u.taskStatus IN ('In Progress','Completed','Completed_by_Proxy','Paused') ")
	public List<IssueTaskScheduler> getIsssueBywkIDTaskID(Integer workflowId, Integer taskId);
	
}
