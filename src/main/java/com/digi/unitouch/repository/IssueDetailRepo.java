package com.digi.unitouch.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.digi.unitouch.model.IssueDetail;
import com.digi.unitouch.vo.ArticleSearchDetailvo;
import com.digi.unitouch.vo.IssueSearchDetailvo;
import com.digi.unitouch.vo.IssueTaskManagementVo;
import com.digi.unitouch.vo.TaskManagementVo;

public interface IssueDetailRepo extends JpaRepository<IssueDetail, Integer> {
	@Query("Select iss from IssueDetail iss where iss.journalId =?1")
	List<IssueDetail> getIsuuelistbyJournalId(Integer journalId);
	
	@Query("Select iss from IssueDetail iss where iss.journalId =?1 and iss.issueStatus IS 'Y'")
	List<IssueDetail> getIsuueStatusListbyJournalId(Integer journalId);
	
//	@Query("Select iss from IssueDetail iss where iss.journalId =?1")
//	List<IssueDetail> getIsuuelistbyJournalId(Integer issueWorkflowId);

	@Query("Select iss from IssueDetail iss where iss.issueStatus IS 'Y' ")
	List<IssueDetail> getIsuuelist();
	
	@Query("Select iss from IssueDetail iss where iss.issue_id =?1")
	IssueDetail getIsuuelistbyid(Integer issue_id);
	
	@Query("Select iss from IssueDetail iss where iss.issue_title =?1 and iss.journalId=?2")
	IssueDetail getByIssueTitle(String issueTitle,Integer journalId);
	
	@Query("Select iss from IssueDetail iss where iss.journalId =?1 and iss.issueSeqNo=?2 ")
	IssueDetail getIsuuelistbyJournalIdWithSeq(Integer journalId, Integer seqNo);

	@Query(value = " SELECT new com.digi.unitouch.vo.IssueTaskManagementVo(issd.issue_id,jj.journalId,issd.issue_title,ist.taskStatus,ist.schStartTime,"
			+ "ist.taskEstTimeFrom,ist.issueTaskId,jj.journalAbbrName,td.taskName)"
			+ " FROM com.digi.unitouch.model.IssueDetail issd "
			+ "JOIN com.digi.unitouch.model.Journal jj ON jj.journalId = issd.journalId "
			+ "JOIN com.digi.unitouch.model.IssueTaskScheduler ist ON ist.issueId=issd.issue_id "
			+ "JOIN com.digi.unitouch.model.TaskDetails td ON td.id = ist.taskId "
			+ "WHERE issd.journalId=:journalId AND ist.taskId=:taskId AND ist.workflowId=:workflowId and ist.userId IS null and ist.taskStatus ='InPool' GROUP BY issd.issue_id")

	List<IssueTaskManagementVo> getIssueTaskManagementGroupList(Integer workflowId, Integer journalId, Integer taskId);

	 
		@Query(value = " SELECT new com.digi.unitouch.vo.IssueTaskManagementVo(issd.issue_id,jj.journalId,issd.issue_title,ist.taskStatus,ist.schStartTime,"
				+ "ist.taskEstTimeFrom,ist.issueTaskId,jj.journalAbbrName,td.taskName)"
				+ " FROM com.digi.unitouch.model.IssueDetail issd "
				+ "JOIN com.digi.unitouch.model.Journal jj ON jj.journalId = issd.journalId "
				+ "JOIN com.digi.unitouch.model.IssueTaskScheduler ist ON ist.issueId=issd.issue_id "
				+ " JOIN com.digi.unitouch.model.CurrentIssueStatus cis ON cis.issueId=ist.issueId AND ist.taskId=cis.taskId "
				+ "JOIN com.digi.unitouch.model.WorkflowTaskSeq wtd ON wtd.workflowId=jj.issueWorkflowId "
				+ "JOIN com.digi.unitouch.model.UserRole dpr ON dpr.roleId=wtd.RoleId "
				+ "JOIN com.digi.unitouch.model.Users us ON us.id=dpr.userId " 
				+ "JOIN com.digi.unitouch.model.TaskDetails td ON td.id = ist.taskId "
				+ "WHERE ist.userId=?1 AND ist.taskStatus !='Completed' AND us.userID=?1  group by issd.issue_id,jj.journalId,issd.issue_title,ist.taskStatus ")
		List<IssueTaskManagementVo> getmyTaskManagementList(Integer userID);

		
//		  @Query(value = " SELECT new com.digi.unitouch.vo.TaskManagementVo(ad.article_id,jj.journalId,"
//		  		+ "ad.article_title,ast.task_status,ast.sch_start_time,ast.sch_end_time,"
//		  		+ "ast.article_task_id,jj.journalAbbrName,ad.aid,td.taskName,ast.assign_reason,"
//		  		+ "ast.comments)FROM com.digi.unitouch.model.ArticleDetail ad \r\n" + 
//			  	" JOIN com.digi.unitouch.model.TaskScheduler ast ON (ast.article_id=ad.article_id) \r\n" + 
//			   "JOIN com.digi.unitouch.model.TaskDetails td ON td.id = ast.task_id "+
//	     	" JOIN com.digi.unitouch.model.Journal jj ON jj.journalId = ad.journalId WHERE  ast.article_task_id=:id")
//		  TaskManagementVo findGroupTaskByArticleId(int id);

		  
		  @Query(value = " SELECT new com.digi.unitouch.vo.IssueTaskManagementVo(issd.issue_id,jj.journalId,issd.issue_title,ist.taskStatus,ist.schStartTime,ist.schEndTime,ist.issueTaskId,jj.journalAbbrName,td.taskName,ist.assignReason,ist.comments)"
		  		+ "FROM com.digi.unitouch.model.IssueDetail issd \r\n" + 
			  		" JOIN com.digi.unitouch.model.IssueTaskScheduler ist ON (ist.issueId=issd.issue_id) \r\n" + 
			  		 "JOIN com.digi.unitouch.model.TaskDetails td ON td.id = ist.taskId "+
			  		" JOIN com.digi.unitouch.model.Journal jj ON jj.journalId = issd.journalId WHERE  ist.issueTaskId=:id")
		  IssueTaskManagementVo findGroupTaskByArticleId(int id);

	  
		  @Query(value=" SELECT new com.digi.unitouch.vo.IssueSearchDetailvo( ad.issue_id,ad.issue_title,ast.taskStatus,ast.schStartTime,ast.schEndTime,ast.taskEstTimeFrom,ast.taskEstTimeEnd,us.firstName,us.lastName,ts.taskName,mjw.dept_id,ast.issueTaskId) FROM IssueDetail ad "
					+ " JOIN com.digi.unitouch.model.Journal j ON j.journalId = ad.journalId "
				  	+ "JOIN com.digi.unitouch.model.IssueTaskScheduler ast ON ast.issueId =ad.issue_id "
			  		+ "JOIN com.digi.unitouch.model.TaskDetails ts ON ts.id=ast.taskId "
			  		+ "right JOIN com.digi.unitouch.model.ManageJournalWorkflow  mjw ON mjw.workflow_id=ast.workflowId and mjw.task_id=ast.taskId and mjw.journal_id=j.journalId"
			  		+ " LEFT JOIN com.digi.unitouch.model.Users us ON us.userID=ast.userId where ad.issue_id=:issueID ")
		List<IssueSearchDetailvo> getIssueSearchDetailList(int issueID);

	@Query("Select iss from IssueDetail iss")
	List<IssueTaskManagementVo> getTotalIssue();
	
}
