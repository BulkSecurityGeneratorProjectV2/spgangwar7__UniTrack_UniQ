package com.digi.unitouch.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.digi.unitouch.model.TaskScheduler;
import com.digi.unitouch.vo.PlannerVo;
import com.digi.unitouch.vo.ProductivityTaskVo;

public interface SchedularRepo extends JpaRepository<TaskScheduler, Integer> {
	
      @Modifying
	  @Query(value = "UPDATE com.digi.unitouch.model.TaskScheduler ast SET ast.user_id = (SELECT u.id FROM com.digi.unitouch.model.Users u WHERE u.username=:name) where ast.article_task_id=:id")  
	  void save(int id,String name);
	
 	 @Query(value="SELECT new com.digi.unitouch.vo.TaskManagementVo(ad.article_id,jj.journalId,ad.article_title,ast.task_status,"
 	 		+ "ast.sch_start_time,ast.sch_end_time,ast.article_task_id,jj.journalAbbrName,ad.aid,td.taskName)"
 	 		+ " FROM com.digi.unitouch.model.ArticleDetail ad JOIN com.digi.unitouch.model.TaskScheduler ast "
 	 		+ "ON ast.article_id=ad.article_id JOIN com.digi.unitouch.model.Journal jj "
 	 		+ "ON jj.journalId = ad.journalId JOIN com.digi.unitouch.model.WorkflowTaskSeq wtd "
 	 		+ "ON wtd.workflowId=jj.articleWorkflowId JOIN com.digi.unitouch.model.UserRole dpr "
 	 		+ "ON dpr.roleId=wtd.RoleId  JOIN com.digi.unitouch.model.Users us ON us.id=dpr.userId\r\n"  
 			 + "JOIN com.digi.unitouch.model.TaskDetails td ON td.id = ast.task_id "
 			+" WHERE ast.user_id IS Not null AND us.username=:name")		 
 	List<TaskScheduler> getMyTaskListByUserID(String name);

//	 @Query(value="SELECT new com.digi.unitouch.vo.TaskManagementVo(ad.article_id,jj.journalId,ad.article_title,ast.task_status,"
//	 		+ "ast.sch_start_time,ast.sch_end_time,ast.article_task_id,jj.journalAbbrName,ad.aid,td.taskName)"
//	 		+ " FROM com.digi.unitouch.model.ArticleDetail ad JOIN com.digi.unitouch.model.TaskScheduler ast "
//	 		+ "ON ast.article_id=ad.article_id JOIN com.digi.unitouch.model.Journal jj "
//	 		+ "ON jj.journalId = ad.journalId JOIN com.digi.unitouch.model.WorkflowTaskSeq wtd "
//	 		+ "ON wtd.workflowId=jj.articleWorkflowId "
//	 		+ "JOIN com.digi.unitouch.model.DepartmentRole dpr "
//	 		+ "ON dpr.roleID=wtd.RoleId JOIN com.digi.unitouch.model.UserDepartment ud "
//	 		+ "ON ud.deptID=dpr.deptID JOIN com.digi.unitouch.model.Users us ON us.id=ud.userID\r\n"  
//			 + "JOIN com.digi.unitouch.model.TaskDetails td ON td.id = ast.task_id "
//			+" WHERE ast.user_id IS Not null AND us.username=:name")		 
//	List<TaskScheduler> getMyTaskListByUserID(String name);

	 @Query(value = " SELECT * FROM article_scheduled_tasks ast WHERE ast.sch_end_time < NOW() AND ast.user_id=:integer and ast.task_status IN ('In Progress','Paused','Yet-to-Start')" , nativeQuery = true)
	 List<TaskScheduler> getOverDueTaskList(Integer integer);
	 
	 @Query(value="SELECT * FROM article_scheduled_tasks ast WHERE ast.article_task_id=:id", nativeQuery = true) 
	 TaskScheduler findtaskDetailById(int id);

	@Query("SELECT new com.digi.unitouch.vo.ProductivityTaskVo (DATE(atd.completed_date_time) ,COUNT(*) AS COUNT)  FROM  ArticleTaskDetail atd "
			+ "JOIN com.digi.unitouch.model.Users u ON u.userID = atd.user_id WHERE atd.task_status='Completed' and atd.user_id= :userID   GROUP BY DATE(atd.completed_date_time)")
	List<ProductivityTaskVo> getproductivityTaskCount(Integer userID);

	@Query("SELECT new com.digi.unitouch.vo.ProductivityTaskVo (DATE(atd.completed_date_time) ,COUNT(*) AS COUNT)  FROM  ArticleTaskDetail atd "
			+ "JOIN com.digi.unitouch.model.Users u ON u.userID = atd.user_id WHERE atd.task_status='Completed'  GROUP BY DATE(atd.completed_date_time)")
	List<ProductivityTaskVo> getproductivityTaskCount();
	
	@Query(value = " SELECT * FROM article_scheduled_tasks ast WHERE ast.sch_end_time < NOW() GROUP BY ast.article_id" , nativeQuery = true)
	List<TaskScheduler> getOverDueTaskListDetails();
 
	@Modifying(clearAutomatically = true)
	@Query("update TaskScheduler td set td.runId=:runID where td.task_id =:taskId and td.article_id=:articleId")
	void updatetaskRun(Integer taskId, Integer runID, Integer articleId);
	
	@Query("select u from TaskScheduler u where u.article_id=:articleId and u.task_id=:taskId")
	public TaskScheduler getrunId(Integer articleId,Integer taskId);


	@Query("select u from TaskScheduler u where u.article_id=:Aid")
	List<TaskScheduler> findalltaskDetailById(int Aid);
	
	@Modifying(clearAutomatically = true)
	@Query("update TaskScheduler ts set ts.task_status=:status  where ts.article_id=:articleId ")
	void withdrawArtical(Integer articleId,String status);
	
	@Modifying(clearAutomatically = true)
	@Query("update TaskScheduler ts set ts.task_status=:task_status  where ts.article_id=:article_id and ts.task_id=:taskID")
	List<TaskScheduler> updateStageByArticleId(Integer article_id,Integer taskID, String task_status);
	
	@Modifying(clearAutomatically = true)
	@Query(value = " update article_scheduled_tasks ast set ast.user_id= null , ast.task_status= 'Yet-to-Start' , ast.task_est_time_from= null , ast.task_est_time_end= null" , nativeQuery = true)
	void resetarticleScheduledTasks();

	@Query(value="SELECT * FROM article_scheduled_tasks ast WHERE ast.user_id!='' AND ast.task_status='In Progress'", nativeQuery = true) 
	List<TaskScheduler> gettaskSchedulerpendingall();

	@Query(value="SELECT * FROM article_scheduled_tasks ast WHERE ast.user_id!='' AND ast.task_status='In Progress' and date(ast.sch_end_time)=DATE(NOW())", nativeQuery = true) 
	List<TaskScheduler> gettaskSchedulerpendingToday();

	@Query(value="SELECT * from article_scheduled_tasks ast WHERE ast.task_status!='Completed' GROUP BY ast.article_id", nativeQuery = true) 
	List<TaskScheduler> gettotalarticleavailable();

	@Query(value="SELECT * FROM article_scheduled_tasks ast WHERE ast.task_status!='Completed' and date(NOW()) = date(ast.sch_end_time) GROUP BY ast.article_id;", nativeQuery = true) 
	List<TaskScheduler> gettotalarticleavailableToday();

	@Query(value="SELECT * FROM article_scheduled_tasks ast WHERE ast.task_status!='Completed' and date(ast.sch_end_time)=DATE_SUB(DATE(NOW()), INTERVAL 1 DAY) GROUP BY ast.article_id", nativeQuery = true) 
	List<TaskScheduler> gettotalarticleavailablepast24();

	@Query(value="SELECT * FROM article_scheduled_tasks ast WHERE ast.task_status!='Completed' and date(ast.sch_end_time)<DATE(date_sub(NOW(),interval 2 DAY)) GROUP BY ast.article_id;", nativeQuery = true) 
	List<TaskScheduler> gettotalarticleavailablepast48();

	
	@Query(value="SELECT * FROM article_scheduled_tasks ast WHERE ast.task_status!='Completed' and date(NOW()) > date(ast.sch_end_time) AND  date(ast.sch_end_time)>DATE(date_sub(NOW(),INTERVAL 3 DAY))  GROUP BY ast.article_id;", nativeQuery = true) 
	List<TaskScheduler> gettotalarticleavailablepastdate();


	@Query(value="SELECT * FROM article_scheduled_tasks ast WHERE ast.`task_status`!='Completed' and DATE(ast.task_est_time_end) IS null  GROUP BY ast.article_id", nativeQuery = true) 
	List<TaskScheduler> gettotalarticleOnDeptTodayVirtual();

	@Query("SELECT new com.digi.unitouch.vo.PlannerVo(COUNT(ast.article_id) AS article_count,DATE(ast.sch_end_time)) from com.digi.unitouch.model.TaskScheduler ast WHERE ast.task_status!='Completed' GROUP BY DATE(ast.sch_end_time) ORDER BY DATE(ast.sch_end_time)")
	List<PlannerVo> gettotalarticleavailableGraph();

	@Query(value="SELECT * FROM article_scheduled_tasks ast JOIN user_roles ud ON ud.user_id=ast.user_id WHERE ast.user_id!='' AND ast.task_status='In Progress'  AND ud.role_id=''", nativeQuery = true) 
	List<TaskScheduler> gettaskSchedulerpendingallBYdeptandUser(int deptId, int userId);
	
//	@Query(value="SELECT * FROM article_scheduled_tasks ast JOIN user_department ud ON ud.user_id=ast.user_id WHERE ast.user_id!='' AND ast.task_status='In Progress'  AND ud.dept_id=''", nativeQuery = true) 
//	List<TaskScheduler> gettaskSchedulerpendingallBYdeptandUser(int deptId, int userId);

	@Query(value="SELECT * FROM article_scheduled_tasks ast JOIN user_roles ud ON ud.user_id=ast.user_id WHERE ast.user_id=:userId AND ast.task_status='In Progress' AND ud.role_id=:deptId and date(ast.sch_end_time)=DATE(NOW())", nativeQuery = true) 
	List<TaskScheduler> gettaskSchedulerpendingTodayBYdeptandUser(int deptId, int userId);
	
//	@Query(value="SELECT * FROM article_scheduled_tasks ast JOIN user_department ud ON ud.user_id=ast.user_id WHERE ast.user_id=:userId AND ast.task_status='In Progress' AND ud.dept_id=:deptId and date(ast.sch_end_time)=DATE(NOW())", nativeQuery = true) 
//	List<TaskScheduler> gettaskSchedulerpendingTodayBYdeptandUser(int deptId, int userId);

	
	@Query(value="SELECT * FROM article_scheduled_tasks ast JOIN user_roles ud ON ud.user_id=ast.user_id WHERE ast.task_status!='Completed' and date(NOW()) = date(ast.sch_end_time)  AND ud.role_id=:dept and ast.user_id =:uid GROUP  BY ast.article_id;", nativeQuery = true)
	List<TaskScheduler> gettotalarticleavailableTodayBydeptandUser(int dept, int uid);
	
//	@Query(value="SELECT * FROM article_scheduled_tasks ast JOIN user_department ud ON ud.user_id=ast.user_id WHERE ast.task_status!='Completed' and date(NOW()) = date(ast.sch_end_time)  AND ud.dept_id=:dept and ast.user_id =:uid GROUP  BY ast.article_id;", nativeQuery = true)
//	List<TaskScheduler> gettotalarticleavailableTodayBydeptandUser(int dept, int uid);
	
	
	@Query(value="SELECT * FROM article_scheduled_tasks ast JOIN user_roles ud ON ud.user_id=ast.user_id WHERE ast.task_status!='Completed' and date(ast.sch_end_time)=DATE_SUB(DATE(NOW()), INTERVAL 1 DAY) AND ud.role_id=:dept and ast.user_id =:uid GROUP BY ast.article_id", nativeQuery = true)
	List<TaskScheduler> gettotalarticleavailablepast24BYdeptandUser(int dept, int uid);
	
//	@Query(value="SELECT * FROM article_scheduled_tasks ast JOIN user_department ud ON ud.user_id=ast.user_id WHERE ast.task_status!='Completed' and date(ast.sch_end_time)=DATE_SUB(DATE(NOW()), INTERVAL 1 DAY) AND ud.dept_id=:dept and ast.user_id =:uid GROUP BY ast.article_id", nativeQuery = true)
//	List<TaskScheduler> gettotalarticleavailablepast24BYdeptandUser(int dept, int uid);

	@Query(value="SELECT * FROM article_scheduled_tasks ast JOIN user_roles ud ON ud.user_id=ast.user_id WHERE ast.task_status!='Completed' and ast.task_status='In Progress' and date(ast.sch_end_time)< DATE(date_sub(NOW(),INTERVAL 2 DAY))  AND ud.role_id=:dept and ast.user_id =:uid GROUP BY ast.article_id", nativeQuery = true)
	List<TaskScheduler> gettotalarticleavailablepast48BYdeptandUser(int dept, int uid);
	
//	@Query(value="SELECT * FROM article_scheduled_tasks ast JOIN user_roles ud ON ud.user_id=ast.user_id WHERE ast.task_status!='Completed' and date(ast.sch_end_time)<DATE(date_sub(NOW(),interval 2 DAY))  AND ud.role_id=:dept and ast.user_id =:uid GROUP BY ast.article_id;", nativeQuery = true)
//	List<TaskScheduler> gettotalarticleavailablepast48BYdeptandUser(int dept, int uid);
	
//	@Query(value="SELECT * FROM article_scheduled_tasks ast JOIN user_department ud ON ud.user_id=ast.user_id WHERE ast.task_status!='Completed' and date(ast.sch_end_time)<DATE(date_sub(NOW(),interval 2 DAY))  AND ud.dept_id=:dept and ast.user_id =:uid GROUP BY ast.article_id;", nativeQuery = true)
//	List<TaskScheduler> gettotalarticleavailablepast48BYdeptandUser(int dept, int uid);

	
//	@Query(value="SELECT * FROM article_scheduled_tasks ast JOIN user_department ud ON ud.user_id=ast.user_id WHERE ast.task_status!='Completed' and date(NOW()) > date(ast.sch_end_time) AND  date(ast.sch_end_time)>DATE(date_sub(NOW(),INTERVAL 3 DAY))  AND ud.dept_id=:dept and ast.user_id =:uid GROUP BY ast.article_id;", nativeQuery = true)
	@Query(value="SELECT * FROM article_scheduled_tasks ast JOIN user_roles ud ON ud.user_id=ast.user_id WHERE ast.task_status!='Completed' and date(ast.sch_end_time) > DATE(date_sub(NOW(),interval 3 DAY)) AND ud.role_id=:dept and ast.user_id =:uid GROUP BY ast.article_id", nativeQuery = true)
	List<TaskScheduler> gettotalarticleavailablepastdateBYdeptandUser(int dept, int uid);

	
//	@Query(value="SELECT * FROM article_scheduled_tasks ast JOIN user_roles ud ON ud.user_id=ast.user_id WHERE ast.task_status!='Completed' and date(NOW()) > date(ast.sch_end_time) AND  date(ast.sch_end_time)>DATE(date_sub(NOW(),INTERVAL 3 DAY))  AND ud.role_id=:dept and ast.user_id =:uid GROUP BY ast.article_id;", nativeQuery = true)
//	List<TaskScheduler> gettotalarticleavailablepastdateBYdeptandUser(int dept, int uid);
	
	
	@Query(value = "SELECT * FROM article_scheduled_tasks ast JOIN user_roles ud ON ud.user_id=ast.user_id WHERE  ast.task_status='In Progress'  AND ud.role_id=:role", nativeQuery = true)
	List<TaskScheduler> gettaskSchedulerpendingallBYdept(int role);

	@Query(value = "SELECT * FROM article_scheduled_tasks ast JOIN user_roles ud ON ud.user_id=ast.user_id WHERE ast.task_status='In Progress' AND ud.role_id=:role and date(ast.sch_end_time)=DATE(NOW())", nativeQuery = true)
	List<TaskScheduler> gettaskSchedulerpendingTodayBYdept(int role);

	@Query(value = "SELECT * FROM article_scheduled_tasks ast JOIN user_roles ud ON ud.user_id=ast.user_id WHERE ast.task_status!='Completed' AND DATE(NOW()) = DATE(ast.sch_end_time)  AND ud.role_id=:role  GROUP  BY ast.article_id;", nativeQuery = true)
	List<TaskScheduler> gettotalarticleavailableTodayBydept(int role);

	@Query(value = "SELECT * FROM article_scheduled_tasks ast JOIN user_roles ud ON ud.user_id=ast.user_id WHERE ast.task_status!='Completed' and date(ast.sch_end_time)=DATE_SUB(DATE(NOW()), INTERVAL 1 DAY) AND ud.role_id=:role  GROUP BY ast.article_id", nativeQuery = true)
	List<TaskScheduler> gettotalarticleavailablepast24BYdept(int role);

	@Query(value = "SELECT * FROM article_scheduled_tasks ast JOIN user_roles ud ON ud.user_id=ast.user_id WHERE ast.task_status!='Completed' and date(ast.sch_end_time)<DATE(date_sub(NOW(),interval 2 DAY))  AND ud.role_id=:role GROUP BY ast.article_id;", nativeQuery = true)
	List<TaskScheduler> gettotalarticleavailablepast48BYdept(int role);

	@Query(value = "SELECT * FROM article_scheduled_tasks ast JOIN user_roles ud ON ud.user_id=ast.user_id WHERE ast.task_status!='Completed' and date(NOW()) > date(ast.sch_end_time) AND  date(ast.sch_end_time)>DATE(date_sub(NOW(),INTERVAL 3 DAY))  AND ud.role_id=:role GROUP BY ast.article_id", nativeQuery = true)
	List<TaskScheduler> gettotalarticleavailablepastdateBYdept(int role);
	
	@Query("SELECT new com.digi.unitouch.vo.PlannerVo(COUNT(ast.article_id) AS article_count,DATE(ast.sch_end_time)) from com.digi.unitouch.model.TaskScheduler ast JOIN com.digi.unitouch.model.UserRole ud on ud.userId=ast.user_id  WHERE ast.task_status!='Completed' and ud.roleId=:role  GROUP BY DATE(ast.sch_end_time) ORDER BY DATE(ast.sch_end_time)")
	List<PlannerVo> gettotalarticleavailableGraphBYdeptartment(int role);
	
	
	
//	
//	@Query(value = "SELECT * FROM article_scheduled_tasks ast JOIN user_department ud ON ud.user_id=ast.user_id WHERE  ast.task_status='In Progress'  AND ud.dept_id=:dept", nativeQuery = true)
//	List<TaskScheduler> gettaskSchedulerpendingallBYdept(int dept);
//
//	@Query(value = "SELECT * FROM article_scheduled_tasks ast JOIN user_department ud ON ud.user_id=ast.user_id WHERE ast.task_status='In Progress' AND ud.dept_id=:dept and date(ast.sch_end_time)=DATE(NOW())", nativeQuery = true)
//	List<TaskScheduler> gettaskSchedulerpendingTodayBYdept(int dept);
//
//	@Query(value = "SELECT * FROM article_scheduled_tasks ast JOIN user_department ud ON ud.user_id=ast.user_id WHERE ast.task_status!='Completed' AND DATE(NOW()) = DATE(ast.sch_end_time)  AND ud.dept_id=:dept  GROUP  BY ast.article_id;", nativeQuery = true)
//	List<TaskScheduler> gettotalarticleavailableTodayBydept(int dept);
//
//	@Query(value = "SELECT * FROM article_scheduled_tasks ast JOIN user_department ud ON ud.user_id=ast.user_id WHERE ast.task_status!='Completed' and date(ast.sch_end_time)=DATE_SUB(DATE(NOW()), INTERVAL 1 DAY) AND ud.dept_id=:dept  GROUP BY ast.article_id", nativeQuery = true)
//	List<TaskScheduler> gettotalarticleavailablepast24BYdept(int dept);
//
//	@Query(value = "SELECT * FROM article_scheduled_tasks ast JOIN user_department ud ON ud.user_id=ast.user_id WHERE ast.task_status!='Completed' and date(ast.sch_end_time)<DATE(date_sub(NOW(),interval 2 DAY))  AND ud.dept_id=:dept GROUP BY ast.article_id;", nativeQuery = true)
//	List<TaskScheduler> gettotalarticleavailablepast48BYdept(int dept);
//
//	@Query(value = "SELECT * FROM article_scheduled_tasks ast JOIN user_department ud ON ud.user_id=ast.user_id WHERE ast.task_status!='Completed' and date(NOW()) > date(ast.sch_end_time) AND  date(ast.sch_end_time)>DATE(date_sub(NOW(),INTERVAL 3 DAY))  AND ud.dept_id=:dept GROUP BY ast.article_id", nativeQuery = true)
//	List<TaskScheduler> gettotalarticleavailablepastdateBYdept(int dept);

	@Query("SELECT new com.digi.unitouch.vo.PlannerVo(COUNT(ast.article_id) AS article_count,DATE(ast.sch_end_time)) from com.digi.unitouch.model.TaskScheduler ast JOIN com.digi.unitouch.model.UserDepartment ud on ud.userID=ast.user_id WHERE ast.task_status!='Completed' and ud.deptID=:dept AND ud.userID=:uid GROUP BY DATE(ast.sch_end_time) ORDER BY DATE(ast.sch_end_time)")
	List<PlannerVo> gettotalarticleavailableGraphBYdeptandUser(int dept, int uid);

	
//	@Query("SELECT new com.digi.unitouch.vo.PlannerVo(COUNT(ast.article_id) AS article_count,DATE(ast.sch_end_time)) from com.digi.unitouch.model.TaskScheduler ast JOIN com.digi.unitouch.model.UserDepartment ud on ud.userID=ast.user_id  WHERE ast.task_status!='Completed' and ud.deptID=:dept  GROUP BY DATE(ast.sch_end_time) ORDER BY DATE(ast.sch_end_time)")
//	List<PlannerVo> gettotalarticleavailableGraphBYdeptartment(int dept);

	@Query(value = "SELECT LAST_INSERT_ID(j.last_task_id) from journals j", nativeQuery = true)
	TaskScheduler gettaskIdbyJournal();


	 @Query(value="SELECT * FROM article_scheduled_tasks ast WHERE ast.task_id=:taskId and ast.article_id=:articleId", nativeQuery = true) 
	TaskScheduler findtaskDetailBytaskIdarticleid(int taskId, int articleId);

	@Modifying(clearAutomatically = true)
	@Query("update TaskScheduler ts set ts.task_est_time_from=null,ts.task_est_time_end=null, ts.task_status=:taskStatus  where ts.article_id=:aid and ts.task_id=:taskid and ts.workflow_id=:workFlowID")
	void changeTaskStatus(int aid, int taskid, int workFlowID, String taskStatus);
	
	@Modifying(clearAutomatically = true)
	@Query("update TaskScheduler ts set ts.task_est_time_from=null,ts.task_est_time_end=null, ts.user_id=null, ts.task_status=:taskStatus  where ts.article_id=:aid and ts.task_id=:taskid and ts.workflow_id=:workFlowID")
	void changeTaskStatusUserDel(int aid, int taskid, int workFlowID, String taskStatus);


	@Query("select u from TaskScheduler u where u.article_id=:articleId and u.task_id=:taskId and u.workflow_id=:workFlowID")
	TaskScheduler getTaskScheduler(int articleId, int taskId, int workFlowID);

	@Query(value = "SELECT t FROM TaskScheduler t WHERE t.task_status LIKE %:status%")
	List<TaskScheduler> getTotalcountByRejected(String status);

	@Query("select u from TaskScheduler u where u.article_id=?1")
	List<TaskScheduler> getAricleIDORTaskID(Integer article_id);

	@Query("select u from TaskScheduler u where u.task_id=?2 and u.workflow_id=?1 and u.task_status IN ('In Progress','Completed','Completed_by_Proxy','Paused') ")
	List<TaskScheduler> getArticleBywkIDTaskID(Integer workflowId, Integer taskId);
	
//	@Query("select u from TaskScheduler u where u.task_id=?2 and u.workflow_id=?1 and u.task_status IN ('Yet-to-Start','In Progress','Completed','Completed_by_Proxy','Paused') ")
//	List<TaskScheduler> getArticleBywkIDTaskIDFinalTask(Integer workflowId, Integer taskId);
	
	@Query("select u from TaskScheduler u where u.task_id=?2 and u.workflow_id=?1 and u.task_status IN ('In Progress','Completed_by_Proxy','Paused') ")
	List<TaskScheduler> getArticleLastStepBywkIDTaskID(Integer workflowId, Integer taskId);
}
