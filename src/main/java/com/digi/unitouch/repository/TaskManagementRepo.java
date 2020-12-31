package com.digi.unitouch.repository;
  

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.digi.unitouch.model.ArticleDetail;
import com.digi.unitouch.vo.DepartmentsTask;
import com.digi.unitouch.vo.TaskManagementVo;
import com.digi.unitouch.vo.TaskManagementVoc;
import com.digi.unitouch.vo.userDepartmentVo;
  
  public interface TaskManagementRepo extends JpaRepository<ArticleDetail, Integer> {
	  
//	  @Query(value="SELECT new com.digi.unitouch.vo.TaskManagementVo(ad.article_id,jj.journalId,ad.article_title,ast.task_status,ast.sch_start_time,ast.sch_end_time,ast.article_task_id,jj.journalAbbrName,ad.aid,td.taskName) "
//		  		+ "FROM com.digi.unitouch.model.ArticleDetail ad JOIN com.digi.unitouch.model.TaskScheduler ast ON ast.article_id=ad.article_id "
//		  		+ "JOIN com.digi.unitouch.model.Journal jj ON jj.journalId = ad.journalId "
//		  		+ " JOIN com.digi.unitouch.model.CurrentArticleStatus cas ON cas.article_id=ast.article_id AND ast.task_id=cas.task_id "
//		  		+ "JOIN com.digi.unitouch.model.WorkflowTaskSeq wtd ON wtd.workflowId=jj.articleWorkflowId and cas.task_id=wtd.taskId "
//		  		+ "JOIN com.digi.unitouch.model.DepartmentRole dpr ON dpr.roleID=wtd.RoleId "
//		  		+ "JOIN com.digi.unitouch.model.UserDepartment ud ON ud.deptID=dpr.deptID "
//		  		+ "JOIN com.digi.unitouch.model.Users us ON us.id=ud.userID " 
//		  		
//		  		+ "JOIN com.digi.unitouch.model.TaskDetails td ON td.id = ast.task_id "
//		  		+ " WHERE ast.user_id IS null and ast.task_status !='Completed' and us.userID=:name")
//	  List<TaskManagementVo> getTaskManagementGroupList(Integer name);

	  @Query(value=" SELECT new com.digi.unitouch.vo.TaskManagementVo(ad.article_id,jj.journalId,ad.article_title,ast.task_status,ast.sch_start_time,ast.sch_end_time,ast.article_task_id,jj.journalAbbrName,ad.aid,td.taskName)"
	  		+ " FROM com.digi.unitouch.model.ArticleDetail ad "
	  		+ "JOIN com.digi.unitouch.model.Journal jj ON jj.journalId = ad.journalId "
	  		+ "JOIN com.digi.unitouch.model.TaskScheduler ast ON ast.article_id=ad.article_id "
	  		+ "JOIN com.digi.unitouch.model.TaskDetails td ON td.id = ast.task_id "
			+"WHERE ad.journalId=:journalId AND ast.task_id=:taskId AND ast.workflow_id=:workflowId and ast.user_id IS null and ast.task_status ='InPool' GROUP BY ad.article_id")
	  
	  List<TaskManagementVo> getTaskManagementGroupList(Integer workflowId, Integer journalId, Integer taskId );
	  
	  
	  @Query(value = " SELECT new com.digi.unitouch.vo.TaskManagementVo(ad.article_id,jj.journalId,ad.article_title,ast.task_status,ast.sch_start_time,ast.sch_end_time,ast.article_task_id,jj.journalAbbrName,ad.aid,td.taskName,ast.assign_reason,ast.comments)FROM com.digi.unitouch.model.ArticleDetail ad \r\n" + 
		  		" JOIN com.digi.unitouch.model.TaskScheduler ast ON (ast.article_id=ad.article_id) \r\n" + 
		  		 "JOIN com.digi.unitouch.model.TaskDetails td ON td.id = ast.task_id "+
		  		" JOIN com.digi.unitouch.model.Journal jj ON jj.journalId = ad.journalId WHERE  ast.article_task_id=:id")
	  TaskManagementVo findGroupTaskByArticleId(int id);

	  
//	  @Query(value="SELECT new com.digi.unitouch.vo.TaskManagementVo(ad.article_id,jj.journalId,ad.article_title,ast.task_status,ast.sch_start_time,ast.sch_end_time,ast.article_task_id,jj.journalAbbrName,ad.aid,td.taskName) "
//	  		+ "FROM com.digi.unitouch.model.ArticleDetail ad JOIN com.digi.unitouch.model.TaskScheduler ast ON ast.article_id=ad.article_id "
//	  		+ "JOIN com.digi.unitouch.model.Journal jj ON jj.journalId = ad.journalId "
//	  		+ " JOIN com.digi.unitouch.model.CurrentArticleStatus cas ON cas.article_id=ast.article_id AND ast.task_id=cas.task_id "
//	  		+ "JOIN com.digi.unitouch.model.WorkflowTaskSeq wtd ON wtd.workflowId=jj.articleWorkflowId "
//	  		+ "JOIN com.digi.unitouch.model.DepartmentRole dpr ON dpr.roleID=wtd.RoleId "
//	  		+ "JOIN com.digi.unitouch.model.UserDepartment ud ON ud.deptID=dpr.deptID "
//	  		+ "JOIN com.digi.unitouch.model.Users us ON us.id=ud.userID " 
//	  		+ "JOIN com.digi.unitouch.model.TaskDetails td ON td.id = ast.task_id "
//	  		+ " WHERE ast.user_id=?1 and ast.task_status !='Completed' AND us.userID=?1 group by ad.article_id,jj.journalId,ad.article_title,ast.task_status ")
//	List<TaskManagementVo> getmyTaskManagementList(Integer userID);
	  
	  @Query(value="SELECT new com.digi.unitouch.vo.TaskManagementVo(ad.article_id,jj.journalId,ad.article_title,ast.task_status,ast.sch_start_time,ast.sch_end_time,ast.article_task_id,jj.journalAbbrName,ad.aid,td.taskName,ad.priority,ad.accepted_date,ad.article_type_cd) "
		  		+ "FROM com.digi.unitouch.model.ArticleDetail ad JOIN com.digi.unitouch.model.TaskScheduler ast ON ast.article_id=ad.article_id "
		  		+ "JOIN com.digi.unitouch.model.Journal jj ON jj.journalId = ad.journalId "
		  		+ " JOIN com.digi.unitouch.model.CurrentArticleStatus cas ON cas.article_id=ast.article_id AND ast.task_id=cas.task_id "
		  		+ "JOIN com.digi.unitouch.model.WorkflowTaskSeq wtd ON wtd.workflowId=jj.articleWorkflowId "
		  		+ "JOIN com.digi.unitouch.model.UserRole ur ON ur.roleId=wtd.RoleId "
		  		+ "JOIN com.digi.unitouch.model.Users us ON us.id=ur.userId " 
		  		+ "JOIN com.digi.unitouch.model.TaskDetails td ON td.id = ast.task_id "
		  		+ " WHERE ast.user_id=?1 and ast.task_status in ('In Progress','Yet-to-Start','Paused') AND us.userID=?1 group by ad.article_id,jj.journalId,ad.article_title,ast.task_status ")
		List<TaskManagementVo> getmyTaskManagementList(Integer userID);
	  
	  
	  @Query(value="SELECT new com.digi.unitouch.vo.TaskManagementVo(ad.article_id,jj.journalId,ad.article_title,ast.task_status,ast.sch_start_time,ast.sch_end_time,ast.article_task_id,jj.journalAbbrName,ad.aid,td.taskName,ad.priority) "
		  		+ "FROM com.digi.unitouch.model.ArticleDetail ad JOIN com.digi.unitouch.model.TaskScheduler ast ON ast.article_id=ad.article_id "
		  		+ "JOIN com.digi.unitouch.model.Journal jj ON jj.journalId = ad.journalId "
		  		+ " JOIN com.digi.unitouch.model.CurrentArticleStatus cas ON cas.article_id=ast.article_id AND ast.task_id=cas.task_id "
		  		+ "JOIN com.digi.unitouch.model.WorkflowTaskSeq wtd ON wtd.workflowId=jj.articleWorkflowId "
		  		+ "JOIN com.digi.unitouch.model.UserRole ur ON ur.roleId=wtd.RoleId "
		  		+ "JOIN com.digi.unitouch.model.Users us ON us.id=ur.userId " 
		  		+ "JOIN com.digi.unitouch.model.TaskDetails td ON td.id = ast.task_id "
		  		+ " WHERE ast.user_id=?1 and ast.task_status in ('In Progress','Yet-to-Start','Paused') AND us.userID=?1 AND ad.article_id=?2 group by ad.article_id,jj.journalId,ad.article_title,ast.task_status ")
		TaskManagementVo getspecificTask(Integer userID,Integer articleId);

//	  @Query(value="SELECT new com.digi.unitouch.vo.TaskManagementVo(ad.article_id,jj.journalId,ad.article_title,ast.task_status,ast.sch_start_time,ast.sch_end_time,ast.article_task_id,jj.journalAbbrName,ad.aid,td.taskName) "
//		  		+ "FROM com.digi.unitouch.model.ArticleDetail ad JOIN com.digi.unitouch.model.TaskScheduler ast ON ast.article_id=ad.article_id "
//		  		+ "JOIN com.digi.unitouch.model.Journal jj ON jj.journalId = ad.journalId "
//		  		+ " JOIN com.digi.unitouch.model.CurrentArticleStatus cas ON cas.article_id=ast.article_id AND ast.task_id=cas.task_id "
//		  		+ "JOIN com.digi.unitouch.model.WorkflowTaskSeq wtd ON wtd.workflowId=jj.articleWorkflowId "
//		  		+ "JOIN com.digi.unitouch.model.DepartmentRole dpr ON dpr.roleID=wtd.RoleId "
//		  		+ "JOIN com.digi.unitouch.model.UserDepartment ud ON ud.deptID=dpr.deptID "
//		  		+ "JOIN com.digi.unitouch.model.TaskDetails td ON td.id = ast.task_id "
//		  		+ "JOIN com.digi.unitouch.model.Users us ON us.id=ud.userID")
//	List<TaskManagementVo> getmyTaskManagementList();
	  
	  @Query(value="SELECT new com.digi.unitouch.vo.TaskManagementVo(ad.article_id,jj.journalId,ad.article_title,ast.task_status,ast.sch_start_time,ast.sch_end_time,ast.article_task_id,jj.journalAbbrName,ad.aid,td.taskName) "
		  		+ "FROM com.digi.unitouch.model.ArticleDetail ad JOIN com.digi.unitouch.model.TaskScheduler ast ON ast.article_id=ad.article_id "
		  		+ "JOIN com.digi.unitouch.model.Journal jj ON jj.journalId = ad.journalId "
		  		+ " JOIN com.digi.unitouch.model.CurrentArticleStatus cas ON cas.article_id=ast.article_id AND ast.task_id=cas.task_id "
		  		+ "JOIN com.digi.unitouch.model.WorkflowTaskSeq wtd ON wtd.workflowId=jj.articleWorkflowId "
		  		+ "JOIN com.digi.unitouch.model.UserRole ur ON ur.roleId=wtd.RoleId "
		  		+ "JOIN com.digi.unitouch.model.TaskDetails td ON td.id = ast.task_id "
		  		+ "JOIN com.digi.unitouch.model.Users us ON us.id=ur.userId")
	List<TaskManagementVo> getmyTaskManagementList();
	  

		  @Query(value="SELECT new com.digi.unitouch.vo.TaskManagementVoc(COUNT(ad.article_title) AS count, ad.article_id,j.journalId,pu.publisherName,ta.taskName,ast.task_status, "
			  		    + "de.groupName,ad.article_title,ast.sch_start_time,ast.sch_end_time,j.journalName,ad.article_doi,ad.article_type_cd,u.firstName,u.lastName,atd.start_date_time,atd.completed_date_time)"
						+ "FROM com.digi.unitouch.model.Department de "
						+ "left JOIN  com.digi.unitouch.model.ManageJournalWorkflow mjw ON mjw.dept_id = de.deptID "
						+ "left JOIN com.digi.unitouch.model.ArticleDetail ad ON ad.journalId =mjw.journal_id "
						+ "left JOIN com.digi.unitouch.model.TaskScheduler ast ON ast.article_id = ad.article_id "
						+ "left JOIN com.digi.unitouch.model.Journal j ON j.journalId = ad.journalId "
						+ "left JOIN com.digi.unitouch.model.Publisher pu ON pu.publisher_id =ad.publisher_id "
						+ "left JOIN com.digi.unitouch.model.TaskDetails ta ON ta.id =ast.user_id "
						+ "left JOIN com.digi.unitouch.model.Users u ON u.userID = ast.user_id "
						+ "left JOIN com.digi.unitouch.model.ArticleTaskDetail atd ON atd.article_id= ad.article_id") 
	  List<TaskManagementVoc> getmyTaskManagementLists();

		  @Query(value = " SELECT new com.digi.unitouch.vo.userDepartmentVo(u.userID,u.username,u.firstName,ud.deptID)FROM com.digi.unitouch.model.UserDepartment ud \r\n" + 
			  		" JOIN com.digi.unitouch.model.Users u ON u.userID = ud.userID WHERE  ud.deptID=:dptId")
		List<userDepartmentVo> getuserlistbydeptId(int dptId);
	  
	/*
	 * @Query(
	 * value="SELECT new com.digi.unitouch.vo.TaskManagementVoc(COUNT(ad.article_title) AS count, ad.article_id,j.journalId,pu.publisherName,ta.taskName,ast.task_status, "
	 * +
	 * "de.groupName,ad.article_title,ast.sch_start_time,ast.sch_end_time,j.journalName,ad.article_doi,ad.article_type_cd,u.firstName,u.lastName,atd.start_date_time,atd.completed_date_time)"
	 * +
	 * "FROM com.digi.unitouch.model.Department de JOIN  com.digi.unitouch.model.ManageJournalWorkFlow mjw ON mjw.deptId = de.deptID "
	 * +
	 * "JOIN com.digi.unitouch.model.ArticleDetail ad ON ad.journalId =mjw.journalId "
	 * +
	 * "JOIN com.digi.unitouch.model.TaskScheduler ast ON ast.article_id = ad.article_id "
	 * + "JOIN com.digi.unitouch.model.Journal j ON j.journalId = ad.journalId " +
	 * "JOIN com.digi.unitouch.model.Publisher pu ON pu.publisher_id =ad.publisher_id "
	 * + "JOIN com.digi.unitouch.model.TaskDetails ON ta.id =ast.user_id " +
	 * "JOIN com.digi.unitouch.model.Users u ON u.userID = ast.user_id " +
	 * "JOIN com.digi.unitouch.model.ArticleTaskDetail atd ON atd.article_id= ad.article_id"
	 * )
	 * 
	 * List<TaskManagementVoc> getmyTaskManagementLists();
	 */
		
		@Query("SELECT new com.digi.unitouch.vo.DepartmentsTask(COUNT(ast.task_status) AS count,"
		+ "ad.article_id,ad.article_title,mjw.user_id,j.journalName,j.journalId,ta.taskName,"
		+ "ast.task_id,ast.task_status)FROM ArticleDetail ad"
				+ " JOIN com.digi.unitouch.model.Journal j ON j.journalId = ad.journalId "
				+ " JOIN  com.digi.unitouch.model.ManageJournalWorkflow mjw ON mjw.journal_id = j.journalId "
				+ " JOIN com.digi.unitouch.model.TaskDetails ta ON ta.id =mjw.task_id "	
				+ " JOIN com.digi.unitouch.model.TaskScheduler ast ON ast.article_id = ad.article_id and ta.id =ast.task_id "
				+ "WHERE mjw.user_id=?1 and ast.task_status in ('In Progress','Yet-to-Start','Paused') GROUP BY mjw.user_id,j.journalId,ta.id,ast.task_status") 
		List<DepartmentsTask> getAllTaskAllJournalBydpt(Integer user_id);
		
		@Query("SELECT new com.digi.unitouch.vo.DepartmentsTask(COUNT(ast.task_status) AS count,"
				+ "ad.article_id,ad.article_title,mjw.user_id,j.journalName,j.journalId,ta.taskName,"
				+ "ast.task_id,ast.task_status)FROM ArticleDetail ad"
						+ " JOIN com.digi.unitouch.model.Journal j ON j.journalId = ad.journalId "
						+ " JOIN  com.digi.unitouch.model.ManageJournalWorkflow mjw ON mjw.journal_id = j.journalId "
						+ " JOIN com.digi.unitouch.model.TaskDetails ta ON ta.id =mjw.task_id "	
						+ " JOIN com.digi.unitouch.model.TaskScheduler ast ON ast.article_id = ad.article_id and ta.id =ast.task_id "
						+ "WHERE mjw.user_id=?1  GROUP BY mjw.user_id,j.journalId,ta.id,ast.task_status") 
				List<DepartmentsTask> getAllTaskAllJournalByUserID(Integer user_id);
		
		
		@Query("SELECT new com.digi.unitouch.vo.DepartmentsTask(COUNT(ast.task_status) AS count,"
		+ "ad.article_id,ad.article_title,mjw.dept_id,j.journalName,j.journalId,ta.taskName,"
		+ "ast.task_id,ast.task_status)FROM ArticleDetail ad"
				+ " JOIN com.digi.unitouch.model.Journal j ON j.journalId = ad.journalId "
				+ " JOIN  com.digi.unitouch.model.ManageJournalWorkflow mjw ON mjw.journal_id = j.journalId "
				+ " JOIN com.digi.unitouch.model.TaskDetails ta ON ta.id =mjw.task_id "	
				+ " JOIN com.digi.unitouch.model.TaskScheduler ast ON ast.article_id = ad.article_id and ta.id =ast.task_id "
				+ "WHERE mjw.user_id=?1 and j.journalId=?2 and ast.task_status in ('Yet-to-Start','In Progress','Completed','Completed_by_Proxy','Paused') GROUP BY mjw.dept_id,ta.id,ast.task_status") 
		List<DepartmentsTask> getAllTaskAllJournalBydptJrid(Integer user_id, Integer jrid);
		
		
//		@Query("SELECT ad.article_id,ad.journal_id,ad.article_title,ast.task_status,"+
//				 "ast.sch_start_time,ast.sch_end_time,ast.article_task_id,ad.aid,"
//				 + "tt.task_name FROM article_details ad" + 
//				"JOIN article_scheduled_tasks ast ON ast.article_id =ad.article_id "+ 
//				"JOIN journals jj ON jj.journal_id= ad.journal_id "+ 
//				"JOIN current_article_status cas ON cas.article_id=ad.article_id AND cas.task_id=ast.task_id "+ 
//				"JOIN workflow_task_details wtd ON wtd.workflow_id=jj.article_workflow_id "+ 
//				"JOIN tasks tt ON tt.task_id=ast.task_id "+ 
//				"WHERE ad.journal_id=5047 and ast.user_id=3745 and ast.task_status !='Completed' "+ 
//				"GROUP BY ad.article_id,ad.article_title,ast.task_status")
//		
		
		  
//		  @Query(value="SELECT new com.digi.unitouch.vo.TaskManagementVo(ad.article_id,jj.journalId,ad.article_title,ast.task_status,ast.sch_start_time,ast.sch_end_time,ast.article_task_id,jj.journalAbbrName,ad.aid,td.taskName) "
//		  		+ "FROM com.digi.unitouch.model.ArticleDetail ad "
//		  		+ "JOIN com.digi.unitouch.model.TaskScheduler ast ON ast.article_id=ad.article_id "
//		  		+ "JOIN com.digi.unitouch.model.Journal jj ON jj.journalId = ad.journalId "
//		  		+ " JOIN com.digi.unitouch.model.CurrentArticleStatus cas ON cas.article_id=ast.article_id AND ast.task_id=cas.task_id "
//		  		+ "JOIN com.digi.unitouch.model.WorkflowTaskSeq wtd ON wtd.workflowId=jj.articleWorkflowId "
//		  		+ "JOIN com.digi.unitouch.model.TaskDetails td ON td.id = ast.task_id "
//		  		+ " WHERE ad.journalId=5047 and ast.user_id=:userID and ast.task_status !='Completed' "
//		  		+ "GROUP BY ad.article_id,ad.article_title,ast.task_status ")
//		
//		List<DepartmentsTask> getMytaskCountList(Integer userID, Integer journal_jid);
		
			
		  @Query(value="SELECT new com.digi.unitouch.vo.TaskManagementVo(ad.article_id,ad.journalId,ad.article_title,ast.task_status,ast.sch_start_time,ast.sch_end_time,ast.article_task_id,jj.journalAbbrName,ad.aid,td.taskName) "
			  		+ "FROM com.digi.unitouch.model.ArticleDetail ad JOIN com.digi.unitouch.model.TaskScheduler ast ON ast.article_id=ad.article_id "
			  		+ "JOIN com.digi.unitouch.model.Journal jj ON jj.journalId = ad.journalId "
			  		+ " JOIN com.digi.unitouch.model.CurrentArticleStatus cas ON cas.article_id=ast.article_id AND ast.task_id=cas.task_id "
			  		+ "JOIN com.digi.unitouch.model.WorkflowTaskSeq wtd ON wtd.workflowId=jj.articleWorkflowId "
			  		+ "JOIN com.digi.unitouch.model.UserRole ur ON ur.roleId=wtd.RoleId "
			  		
			  		+ "JOIN com.digi.unitouch.model.Users us ON us.id=ur.userId " 
			  		+ "JOIN com.digi.unitouch.model.TaskDetails td ON td.id = ast.task_id "
			  		+ " WHERE  ast.user_id=?1 and ad.journalId=?2 and ast.task_status in ('In Progress','Yet-to-Start','Paused') AND us.userID=?1 group by ad.article_id,ad.article_title,ast.task_status ")
			List<TaskManagementVo> getmyTaskManagementList(Integer userID, Integer jid); 
		
//		  @Query(value="SELECT new com.digi.unitouch.vo.TaskManagementVo(ad.article_id,ad.journalId,ad.article_title,ast.task_status,ast.sch_start_time,ast.sch_end_time,ast.article_task_id,jj.journalAbbrName,ad.aid,td.taskName) "
//		  		+ "FROM com.digi.unitouch.model.ArticleDetail ad JOIN com.digi.unitouch.model.TaskScheduler ast ON ast.article_id=ad.article_id "
//		  		+ "JOIN com.digi.unitouch.model.Journal jj ON jj.journalId = ad.journalId "
//		  		+ " JOIN com.digi.unitouch.model.CurrentArticleStatus cas ON cas.article_id=ast.article_id AND ast.task_id=cas.task_id "
//		  		+ "JOIN com.digi.unitouch.model.WorkflowTaskSeq wtd ON wtd.workflowId=jj.articleWorkflowId "
//		  		+ "JOIN com.digi.unitouch.model.DepartmentRole dpr ON dpr.roleID=wtd.RoleId "
//		  		+ "JOIN com.digi.unitouch.model.UserDepartment ud ON ud.deptID=dpr.deptID "
//		  		+ "JOIN com.digi.unitouch.model.Users us ON us.id=ud.userID " 
//		  		+ "JOIN com.digi.unitouch.model.TaskDetails td ON td.id = ast.task_id "
//		  		+ " WHERE  ast.user_id=?1 and ad.journalId=?2 and ast.task_status !='Completed' AND us.userID=?1 group by ad.article_id,ad.article_title,ast.task_status ")
//		List<TaskManagementVo> getmyTaskManagementList(Integer userID, Integer jid);
//
		  
		  @Query(value="SELECT new com.digi.unitouch.vo.TaskManagementVo(ad.article_id,jj.journalId,ad.article_title,ast.task_status,ast.sch_start_time,ast.sch_end_time,ast.article_task_id,jj.journalAbbrName,ad.aid,td.taskName,ad.priority,ad.article_doi,ad.article_type_cd,ad.publisher_id,p.publisherName) "
			  		+ "FROM com.digi.unitouch.model.ArticleDetail ad JOIN com.digi.unitouch.model.TaskScheduler ast ON ast.article_id=ad.article_id "
			  		+ "JOIN com.digi.unitouch.model.Journal jj ON jj.journalId = ad.journalId "
			  		+ " JOIN com.digi.unitouch.model.CurrentArticleStatus cas ON cas.article_id=ast.article_id AND ast.task_id=cas.task_id "
			  		+ "JOIN com.digi.unitouch.model.WorkflowTaskSeq wtd ON wtd.workflowId=jj.articleWorkflowId "
			  		+ "JOIN com.digi.unitouch.model.UserRole ur ON ur.roleId=wtd.RoleId "
			  		+ "JOIN com.digi.unitouch.model.Users us ON us.id=ur.userId " 
			  		+ "JOIN com.digi.unitouch.model.TaskDetails td ON td.id = ast.task_id "
			  		+ "JOIN com.digi.unitouch.model.Publisher p ON p.publisher_id = ad.publisher_id"
			  		+ " WHERE ast.user_id=?1 and ast.task_status !='Completed' AND us.userID=?1 group by ad.article_id,jj.journalId,ad.article_title,ast.task_status ")
			List<TaskManagementVo> getmyTaskManagementListforPlanner(Integer userID);
		  
		  
		  @Query(value="SELECT new com.digi.unitouch.vo.TaskManagementVo(ad.article_id,jj.journalId,ad.article_title,ast.task_status,ast.sch_start_time,ast.sch_end_time,ast.article_task_id,jj.journalAbbrName,ad.aid,td.taskName,ad.priority) "
			  		+ "FROM com.digi.unitouch.model.ArticleDetail ad JOIN com.digi.unitouch.model.TaskScheduler ast ON ast.article_id=ad.article_id "
			  		+ "JOIN com.digi.unitouch.model.Journal jj ON jj.journalId = ad.journalId "
			  		+ " JOIN com.digi.unitouch.model.CurrentArticleStatus cas ON cas.article_id=ast.article_id AND ast.task_id=cas.task_id "
			  		+ "JOIN com.digi.unitouch.model.WorkflowTaskSeq wtd ON wtd.workflowId=jj.articleWorkflowId "
			  		+ "JOIN com.digi.unitouch.model.UserRole ur ON ur.roleId=wtd.RoleId "
			  		+ "JOIN com.digi.unitouch.model.Users us ON us.id=ur.userId " 
			  		+ "JOIN com.digi.unitouch.model.TaskDetails td ON td.id = ast.task_id "
			  		+ "JOIN com.digi.unitouch.model.TaskScheduler ts ON ts.user_id = ur.userId "
			  		+ " WHERE ast.user_id=?1 and ast.task_status in ('In Progress','Yet-to-Start','Paused') and ts.sch_end_time < NOW() AND us.userID=?1 group by ad.article_id,jj.journalId,ad.article_title,ast.task_status ")
			List<TaskManagementVo> getmyTaskManagementTotalList(Integer userID);
  }
 