
  package com.digi.unitouch.repository;
  

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.digi.unitouch.model.ArticleDetail;
import com.digi.unitouch.vo.ArticleDetailHavingOverloadvo;
import com.digi.unitouch.vo.ArticleDetailplannerVo;
import com.digi.unitouch.vo.ArticleDetailsVO;
import com.digi.unitouch.vo.ArticleDetailvo;
import com.digi.unitouch.vo.ArticlePlanner;
import com.digi.unitouch.vo.ArticleSearchDetailvo;
import com.digi.unitouch.vo.ArticleTaskDetailsVO;
import com.digi.unitouch.vo.AvilabelLode;
import com.digi.unitouch.vo.LoadReportForcast;
import com.digi.unitouch.vo.TaskManagementVocArt;
import com.digi.unitouch.vo.TotelLode;
  
  public interface ArticleRepo extends JpaRepository<ArticleDetail, Integer> {
	  
	@Query(value = "SELECT ad FROM ArticleDetail ad WHERE ad.withdrawStatus = 'N'")
	List<ArticleDetail> findArticleDetail();
	  
	@Query(value = "SELECT ad FROM ArticleDetail ad WHERE ad.withdrawStatus = 'N'")
	List<ArticleDetail> findArticleDetailStatus();
	  
	  @Query(value="SELECT * FROM article_details ad WHERE ad.article_id=:id", nativeQuery = true) 
	 ArticleDetail findArticleDetailBy(int id);
	 
	  
	  @Query(value=" SELECT new com.digi.unitouch.vo.ArticleDetailsVO(ad.article_id,ad.article_title,ad.article_doi,ad.aid,ad.article_type_cd, j.journalName,cs.task_id,ad.withdrawStatus,td.taskName,ad.accepted_date) FROM ArticleDetail ad "
			  + "JOIN Journal j ON j.journalId=ad.journalId " 
			  + "JOIN com.digi.unitouch.model.CurrentArticleStatus cs ON cs.article_id = ad.article_id "
			  + "JOIN com.digi.unitouch.model.TaskDetails td ON td.id = cs.task_id AND ad.withdrawStatus='N' AND ad.withdrawStatus IN('N','EDITOR_REJECTED')  GROUP BY ad.article_id")
	 List<ArticleDetailsVO> getarticleDetail(); 
	
	  @Query(value=" SELECT new com.digi.unitouch.vo.ArticleDetailsVO(ad.article_id,ad.article_title,ad.article_doi,ad.aid,ad.article_type_cd, j.journalName,cs.task_id,ad.withdrawStatus,td.taskName,ad.accepted_date) FROM ArticleDetail ad "
			  + "JOIN Journal j ON j.journalId=ad.journalId " 
			  + "JOIN com.digi.unitouch.model.CurrentArticleStatus cs ON cs.article_id = ad.article_id "
			  + "JOIN com.digi.unitouch.model.TaskDetails td ON td.id = cs.task_id AND ad.withdrawStatus='N' AND ad.journalId=:journalID AND ad.withdrawStatus IN('N','EDITOR_REJECTED')  GROUP BY ad.article_id")
	 List<ArticleDetailsVO> getarticleDetailByjournalID(Integer journalID); 
	  
	 // @Query(value="SELECT * FROM article_details ad WHERE ad.aid=:aid") 
	  	ArticleDetail findByAid(String aid);
		  
	  	 @Query(value=" SELECT new com.digi.unitouch.vo.ArticleDetailsVO(ad.article_id,ad.article_title,ad.article_doi,ad.aid,ad.article_type_cd, j.journalName,cs.task_id,ad.withdrawStatus,td.taskName,ad.accepted_date,ad.article_pages,ad.article_comment) FROM ArticleDetail ad "
				  + "JOIN Journal j ON j.journalId=ad.journalId " 
				  + "JOIN com.digi.unitouch.model.CurrentArticleStatus cs ON cs.article_id = ad.article_id "
				  + "JOIN com.digi.unitouch.model.TaskDetails td ON td.id = cs.task_id AND ad.withdrawStatus='N' AND ad.withdrawStatus IN('N','EDITOR_REJECTED') AND ad.article_pages is not NULL AND ad.aid=:aid")
	  	ArticleDetailsVO findByAidWithStatus(String aid);   
	  
	
//	  @Query(value=" SELECT DISTINCT new com.digi.unitouch.vo.ArticleDetailvo( ad.article_id,ad.article_title,ad.article_doi,ad.aid,ad.article_type_cd, j.journalName, pb.publisherName) FROM ArticleDetail ad "
//	  		+ "JOIN Publisher pb ON pb.publisher_id=ad.publisher_id "
//	  		+ "JOIN AuthorArticleDetails auth ON auth.article_id=ad.article_id "
//	  		+ "JOIN Journal j ON j.journalId=ad.journalId WHERE ad.article_title LIKE %?1% AND  ad.article_doi LIKE  %?2% AND ad.article_type_cd LIKE %?3% AND pb.publisherName LIKE %?4% AND j.journalAbbrName LIKE %?5% AND ad.aid LIKE %?6% AND ad.keywords LIKE %?7% AND auth.lName LIKE %?8% AND auth.eMail LIKE %?9%")
//	  List<ArticleDetailvo> getArticleDetailList(String article_title,String article_doi,String article_type_cd, String publisherName ,String journalAbbrName,String aid,String keywords,String lName,String authorEmail,String articleStatus);
	
	  	
//	  @Query(value=" SELECT DISTINCT new com.digi.unitouch.vo.ArticleDetailvo( ad.article_id,ad.article_title,ad.article_doi,ad.aid,ad.article_type_cd, j.journalName, pb.publisherName,ast.task_status) FROM ArticleDetail ad "
//			  + " JOIN com.digi.unitouch.model.Journal j ON j.journalId = ad.journalId "
//			 	+ "JOIN com.digi.unitouch.model.TaskScheduler ast ON ast.article_id =ad.article_id "
//			  + "JOIN Publisher pb ON pb.publisher_id=ad.publisher_id "
//		  		+ "JOIN AuthorArticleDetails auth ON auth.article_id=ad.article_id "
//		  		+ " WHERE  ad.article_title LIKE %?1% AND  ad.article_doi LIKE  %?2% AND ad.article_type_cd LIKE %?3% AND pb.publisherName LIKE %?4% AND j.journalAbbrName"
//		  		+ " LIKE %?5% AND ad.aid LIKE %?6% AND ad.keywords LIKE %?7% AND auth.lName LIKE %?8% AND auth.eMail LIKE %?9% AND ast.task_status LIKE %?10% GROUP BY ad.aid,ad.article_doi "  )
//		  List<ArticleDetailvo> getArticleDetailList(String article_title,String article_doi,String article_type_cd, String publisherName ,String journalAbbrName,String aid,String keywords,String lName,String authorEmail,String articleStatus);

	  
	  
	  
	  @Query(value=" SELECT DISTINCT new com.digi.unitouch.vo.ArticleDetailvo( ad.article_id,ad.article_title,ad.article_doi,ad.aid,ad.article_type_cd, j.journalName, pb.publisherName,ast.task_status,cs.task_id,td.taskName) FROM ArticleDetail ad "
			  + " JOIN com.digi.unitouch.model.Journal j ON j.journalId = ad.journalId "
			  + "JOIN com.digi.unitouch.model.TaskScheduler ast ON ast.article_id =ad.article_id "
			  + "JOIN com.digi.unitouch.model.CurrentArticleStatus cs ON cs.article_id = ad.article_id "
			  + "JOIN Publisher pb ON pb.publisher_id=ad.publisher_id "
		  	  + "JOIN AuthorArticleDetails auth ON auth.article_id=ad.article_id "
		  	  + "JOIN com.digi.unitouch.model.TaskDetails td ON td.id = cs.task_id "
		  	  + " WHERE  ad.article_title LIKE %?1% AND  ad.article_doi LIKE  %?2% AND ad.article_type_cd LIKE %?3% AND pb.publisherName LIKE %?4% AND j.journalAbbrName"
		  	  + " LIKE %?5% AND ad.aid LIKE %?6% AND ad.keywords LIKE %?7% AND auth.lName LIKE %?8% AND auth.eMail LIKE %?9% AND ast.task_status LIKE %?10% GROUP BY ad.aid,ad.article_doi "  )
		  List<ArticleDetailvo> getArticleDetailList(String article_title,String article_doi,String article_type_cd, String publisherName ,String journalAbbrName,String aid,String keywords,String lName,String authorEmail,String articleStatus);
	  	  
	  
	  @Query(value=" SELECT new com.digi.unitouch.vo.ArticleSearchDetailvo( ad.article_id, ad.aid,ad.article_title,ast.task_status,ast.sch_start_time,ast.sch_end_time,ast.task_est_time_from,ast.task_est_time_end,us.firstName,us.lastName,ts.taskName,mjw.dept_id,ast.article_task_id) FROM ArticleDetail ad "
				+ " JOIN com.digi.unitouch.model.Journal j ON j.journalId = ad.journalId "
			  	+ "JOIN com.digi.unitouch.model.TaskScheduler ast ON ast.article_id =ad.article_id "
		  		+ "JOIN com.digi.unitouch.model.TaskDetails ts ON ts.id=ast.task_id "
		  		+ "right JOIN com.digi.unitouch.model.ManageJournalWorkflow  mjw ON mjw.workflow_id=ast.workflow_id and mjw.task_id=ast.task_id and mjw.journal_id=j.journalId"
		  		+ " LEFT JOIN com.digi.unitouch.model.Users us ON us.userID=ast.user_id where ad.article_id=:articleId ")
	List<ArticleSearchDetailvo> getArticleSearchDetailList(int articleId);


	  @Query(value="SELECT new com.digi.unitouch.vo.TaskManagementVocArt(ad.article_id,j.journalId,pu.publisherName,ta.taskName,ast.task_status, "
	  		    + "de.groupName,ad.article_title,ast.sch_start_time,ast.sch_end_time,j.journalName,ad.article_doi,ad.article_type_cd,u.firstName,u.lastName,atd.start_date_time,atd.completed_date_time)"
				+ "FROM com.digi.unitouch.model.Department de left JOIN  com.digi.unitouch.model.ManageJournalWorkflow mjw ON mjw.dept_id = de.deptID "
				+ "left JOIN com.digi.unitouch.model.ArticleDetail ad ON ad.journalId =mjw.journal_id "
				+ "left JOIN com.digi.unitouch.model.TaskScheduler ast ON ast.article_id = ad.article_id "
				+ "left JOIN com.digi.unitouch.model.Journal j ON j.journalId = ad.journalId "
				+ "left JOIN com.digi.unitouch.model.Publisher pu ON pu.publisher_id =ad.publisher_id "
				+ "left JOIN com.digi.unitouch.model.TaskDetails ta ON ta.id =ast.user_id "
				+ "left JOIN com.digi.unitouch.model.Users u ON u.userID = ast.user_id "
				+ "left JOIN com.digi.unitouch.model.ArticleTaskDetail atd ON atd.article_id= ad.article_id where ad.article_id=:articleId")
	List<TaskManagementVocArt> getArticleDetailListByArtId(int articleId);


	  @Query(value=" SELECT new com.digi.unitouch.vo.ArticleDetailHavingOverloadvo( ad.article_id,ad.article_title,ad.article_doi,ad.aid,ad.article_type_cd,"
	  		+ " j.journalName, pb.publisherName, ast.task_status,ast.sch_end_time,td.taskName) FROM ArticleDetail ad "
		  		+ "JOIN Publisher pb ON pb.publisher_id=ad.publisher_id "
		  		+ "JOIN com.digi.unitouch.model.TaskScheduler ast ON ast.article_id = ad.article_id join TaskDetails td on td.id=ast.task_id  "
		  		+ "JOIN Journal j ON j.journalId=ad.journalId  and ast.task_status='In Progress' GROUP BY ast.article_id  ORDER by ast.article_id desc")
	List<ArticleDetailHavingOverloadvo> getarticleInProgressDetail();


//	  @Query(value="SELECT NEW com.digi.unitouch.vo.ArticleDetailHavingvo( ad.article_id,ad.article_title,ad.article_doi," + 
//	  		"ad.aid,ad.article_type_cd, j.journalName, pb.publisherName ,ast.task_status) FROM WorkflowTaskSeq wtd " + 
//	  		"JOIN (SELECT max(wt.sequence) seq,wt.workflowId wr  FROM WorkflowTaskSeq wt GROUP BY wt.workflowId) maxseq ON " + 
//	  		"wtd.sequence=maxseq.seq AND wtd.workflowId=maxseq.wr  " + 
//	  		"JOIN com.digi.unitouch.model.TaskScheduler ast ON ast.task_id=wtd.task_id AND ast.workflow_id=wtd.workflow_id " + 
//	  		"AND ast.task_status='Completed' JOIN ArticleDetail ad ON ast.article_id = ad.article_id " + 
//	  		"JOIN Publisher pb ON pb.publisher_id=ad.publisher_id JOIN Journal j ON j.journalId=ad.journalId")
//	 List<ArticleDetailHavingvo> getarticleCompleteDetail();


//	  @Query(value=" SELECT new com.digi.unitouch.vo.ArticleDetailHavingOverloadvo(ad.article_id,ad.article_title,ad.article_doi,ad.aid,ad.article_type_cd, j.journalName, pb.publisherName, ast.task_status,ast.sch_end_time) FROM ArticleDetail ad "
//		  		+ "JOIN Publisher pb ON pb.publisher_id=ad.publisher_id "
//		  		+ "JOIN com.digi.unitouch.model.TaskScheduler ast ON ast.article_id = ad.article_id "
//		  		+ "JOIN Journal j ON j.journalId=ad.journalId  GROUP BY ast.article_id HAVING (ast.task_status='In Progress' OR ast.task_status='Yet-to-Start' ) AND ast.sch_end_time < NOW() order by ast.task_status desc ")
//	 List<ArticleDetailHavingOverloadvo> getarticleOverDueDetail();

//current 25-9	  @Query(value=" SELECT new com.digi.unitouch.vo.ArticleDetailHavingOverloadvo(ad.article_id,ad.article_title,ad.article_doi,ad.aid,ad.article_type_cd, j.journalName, pb.publisherName, ast.task_status,ast.sch_end_time,td.taskName) FROM ArticleDetail ad "
//		  		+ "JOIN Publisher pb ON pb.publisher_id=ad.publisher_id "
//		  	  + "JOIN com.digi.unitouch.model.CurrentArticleStatus cs ON cs.article_id = ad.article_id "
//			  + "JOIN com.digi.unitouch.model.TaskDetails td ON td.id = cs.task_id "
//		  		+ "JOIN com.digi.unitouch.model.TaskScheduler ast ON ast.article_id = ad.article_id "
//		  		+ "JOIN Journal j ON j.journalId=ad.journalId  GROUP BY ast.article_id HAVING (ast.task_status='In Progress' OR ast.task_status='Yet-to-Start' ) AND ast.sch_end_time < NOW() order by ast.task_status desc ")
	@Query(value = " SELECT new com.digi.unitouch.vo.ArticleDetailHavingOverloadvo(ad.article_id,"
			+ "ad.article_title,ad.article_doi,ad.aid,ad.article_type_cd, j.journalName, pb.publisherName,"
			+ " ast.task_status,ast.sch_end_time,td.taskName) FROM ArticleDetail ad "
			+ "JOIN Publisher pb ON pb.publisher_id=ad.publisher_id "
			+ "JOIN com.digi.unitouch.model.CurrentArticleStatus cs ON cs.article_id = ad.article_id "
			+ "JOIN com.digi.unitouch.model.TaskDetails td ON td.id = cs.task_id "
			+ "JOIN com.digi.unitouch.model.TaskScheduler ast ON ast.article_id = cs.article_id and ast.task_id = cs.task_id "
			+ "JOIN Journal j ON j.journalId=ad.journalId  GROUP BY ast.article_id"
			+ " HAVING  ast.sch_end_time < NOW() "
			+ "order by ast.task_status desc ")
	  List<ArticleDetailHavingOverloadvo> getarticleOverDueDetail();


	  @Query(value=" SELECT new com.digi.unitouch.vo.LoadReportForcast(ad.article_title,ad.article_doi,ast.sch_start_time,ast.sch_end_time,ad.article_type_cd,ad.journal_volume_number) FROM ArticleDetail ad "
		  		+"JOIN com.digi.unitouch.model.TaskScheduler ast ON ast.article_id = ad.article_id WHERE ast.task_status !='Completed' GROUP BY ad.article_id")

	 List<LoadReportForcast> getloadforcastreport();


	  @Query(value=" SELECT new com.digi.unitouch.vo.ArticlePlanner(p.publisherName,d.groupName,w.name,ja.journalName,ad.aid,ad.article_title,ast.task_status,ast.sch_start_time,ast.sch_end_time) FROM ArticleDetail ad "
		  		+"JOIN com.digi.unitouch.model.TaskScheduler ast ON ast.article_id = ad.article_id JOIN com.digi.unitouch.model.Journal ja ON ja.journalId = ad.journalId JOIN com.digi.unitouch.model.ManageJournalWorkflow mjw ON mjw.task_id=ast.task_id JOIN com.digi.unitouch.model.Department d ON d.deptID=mjw.dept_id JOIN com.digi.unitouch.model.Publisher p ON p.publisher_id = ad.publisher_id JOIN com.digi.unitouch.model.Workflow w ON w.id=ja.articleWorkflowId")
	 List<ArticlePlanner> getarticlePlannerDetails();


	  @Query(value="SELECT new com.digi.unitouch.vo.AvilabelLode( u.sch_start_time AS date,COUNT(u.article_task_id)*5 as TotalLoad_actual) FROM com.digi.unitouch.model.TaskScheduler u  JOIN com.digi.unitouch.model.ManageJournalWorkflow mjw ON mjw.task_id = u.task_id WHERE   u.task_status!='Completed'  GROUP BY u.task_id ")
	  List<AvilabelLode> getTotalLode();

 
	  @Query(value="SELECT new com.digi.unitouch.vo.TotelLode(de.roleName ,COUNT(u.userID)*5 as TotalLoad) FROM com.digi.unitouch.model.Users u JOIN com.digi.unitouch.model.UserRole ud ON ud.userId=u.userID join com.digi.unitouch.model.Role de on de.roleID=ud.roleId GROUP  BY ud.roleId")
      List<TotelLode> getavilabelLode();


	  @Query(value="SELECT new com.digi.unitouch.vo.TotelLode(de.groupName ,COUNT(u.userID)*5 as TotalLoad) FROM com.digi.unitouch.model.Users u JOIN com.digi.unitouch.model.UserDepartment ud ON ud.userID=u.userID join com.digi.unitouch.model.Department de on de.deptID=ud.deptID  WHERE de.deptID=2 GROUP  BY ud.deptID")
	    
	   List<TotelLode> getavilabelLodebyDeptId(int deptId);


	   @Query(value="SELECT new com.digi.unitouch.vo.AvilabelLode( u.sch_start_time AS date,COUNT(u.article_task_id)*5 as TotalLoad_actual) FROM com.digi.unitouch.model.TaskScheduler u  JOIN com.digi.unitouch.model.ManageJournalWorkflow mjw ON mjw.task_id = u.task_id WHERE   u.task_status!='Completed' and mjw.dept_id=2   GROUP BY u.task_id ")
	   List<AvilabelLode> getTotalLodebyDeptId(int deptId);


	  @Query(value=" SELECT new com.digi.unitouch.vo.ArticleDetailplannerVo( art.article_id,art.article_title,art.article_doi,art.aid,art.article_type_cd, jj.journalName, pu.publisherName,ast.workflow_id,ast.task_id,dp.groupName ,ast.task_status) FROM ArticleDetail art ,"
		  		+ "com.digi.unitouch.model.TaskScheduler ast,com.digi.unitouch.model.Publisher pu,com.digi.unitouch.model.ManageJournalWorkflow mj ,com.digi.unitouch.model.Journal jj ,com.digi.unitouch.model.Department dp WHERE "
		  		+ "art.article_id=ast.article_id AND ast.workflow_id=mj.workflow_id AND ast.task_id=mj.task_id AND "
		  		+ "pu.publisher_id=art.publisher_id AND jj.journalId=art.journalId AND dp.deptID=mj.dept_id AND "
		  		+ "ast.task_status!='Completed'  and DATE(ast.task_est_time_end) IS null GROUP BY ast.article_id") 
	  List<ArticleDetailplannerVo> getarticlegroupbyToday();


	  @Query(value=" SELECT new com.digi.unitouch.vo.ArticleDetailplannerVo( art.article_id,art.article_title,art.article_doi,art.aid,art.article_type_cd, jj.journalName, pu.publisherName,ast.workflow_id,ast.task_id,dp.groupName ,ast.task_status) FROM ArticleDetail art ,"
		  		+ "com.digi.unitouch.model.TaskScheduler ast,com.digi.unitouch.model.Publisher pu,com.digi.unitouch.model.ManageJournalWorkflow mj ,com.digi.unitouch.model.Journal jj ,com.digi.unitouch.model.Department dp WHERE "
		  		+ "art.article_id=ast.article_id AND ast.workflow_id=mj.workflow_id AND ast.task_id=mj.task_id AND "
		  		+ "pu.publisher_id=art.publisher_id AND jj.journalId=art.journalId AND dp.deptID=mj.dept_id AND "
		  		+ "ast.task_status!='Completed' and DATE(ast.sch_end_time) =DATE(NOW()) and DATE(ast.task_est_time_end) IS null GROUP BY ast.article_id") 
	List<ArticleDetailplannerVo> getarticlegroupby();



	  @Query(value=" SELECT new com.digi.unitouch.vo.ArticleDetailplannerVo( art.article_id,art.article_title,art.article_doi,art.aid,art.article_type_cd, jj.journalName, pu.publisherName,ast.workflow_id,ast.task_id,dp.groupName ,ast.task_status) FROM ArticleDetail art ,"
		  		+ "com.digi.unitouch.model.TaskScheduler ast,com.digi.unitouch.model.Publisher pu,com.digi.unitouch.model.ManageJournalWorkflow mj ,com.digi.unitouch.model.Journal jj ,com.digi.unitouch.model.Department dp WHERE "
		  		+ "art.article_id=ast.article_id AND ast.workflow_id=mj.workflow_id AND ast.task_id=mj.task_id AND "
		  		+ "pu.publisher_id=art.publisher_id AND jj.journalId=art.journalId AND dp.deptID=mj.dept_id AND "
		  		+ "ast.task_status!='Completed'  GROUP BY dp.deptID  ORDER BY art.article_id")
	List<ArticleDetailplannerVo> gettotalarticleOnDeptVirtual();



	 @Query(value=" SELECT new com.digi.unitouch.vo.ArticleDetailplannerVo( art.article_id,art.article_title,art.article_doi,art.aid,art.article_type_cd, jj.journalName, pu.publisherName,ast.workflow_id,ast.task_id,dp.groupName ,ast.task_status) FROM ArticleDetail art ,"
		  		+ "com.digi.unitouch.model.TaskScheduler ast,com.digi.unitouch.model.Publisher pu,com.digi.unitouch.model.ManageJournalWorkflow mj ,com.digi.unitouch.model.Journal jj ,com.digi.unitouch.model.Department dp WHERE "
		  		+ "art.article_id=ast.article_id AND ast.workflow_id=mj.workflow_id AND ast.task_id=mj.task_id AND "
		  		+ "pu.publisher_id=art.publisher_id AND jj.journalId=art.journalId AND dp.deptID=mj.dept_id AND "
		  		+ "ast.task_status!='Completed' and DATE(ast.sch_end_time) =DATE(NOW()) GROUP BY dp.deptID  ORDER BY art.article_id")
	List<ArticleDetailplannerVo> gettotalarticleOnDeptTodayVirtual();

	 @Query(value="SELECT * From article_details ad where ad.article_pages is not NULL AND ad.article_status='Complete' " ,nativeQuery = true)
	List<ArticleDetail> getunassignedArticleList();

	 @Query(value="SELECT ad From ArticleDetail ad where ad.journalId=:journalId and ad.article_pages is not NULL  AND ad.withdrawStatus = 'N'" )
	 CopyOnWriteArrayList<ArticleDetail> getunassignedArticlebyJrId(Integer journalId);
	 
	 @Query(value="SELECT ad From ArticleDetail ad where ad.journalId=:journalId and ad.withdrawStatus = 'N'" )
	 CopyOnWriteArrayList<ArticleDetail> getassignedArticlebyJrId(Integer journalId);
	 
	  @Query(value=" SELECT new com.digi.unitouch.vo.ArticleDetailsVO(ad.article_id,ad.article_title,ad.article_doi,ad.aid,ad.article_type_cd, j.journalName,cs.task_id,ad.withdrawStatus,td.taskName,ad.accepted_date,ad.article_pages,ad.article_comment) FROM ArticleDetail ad "
			  + "JOIN Journal j ON j.journalId=ad.journalId " 
			  + "JOIN com.digi.unitouch.model.CurrentArticleStatus cs ON cs.article_id = ad.article_id "
			  + "JOIN com.digi.unitouch.model.TaskDetails td ON td.id = cs.task_id AND ad.withdrawStatus='N' AND ad.withdrawStatus IN('N','EDITOR_REJECTED') AND ad.article_pages is not NULL AND ad.journalId=:journalId GROUP BY ad.article_id")
	  CopyOnWriteArrayList<ArticleDetailsVO> getunassignedArticleListbyJrId(Integer journalId);
	 
	 @Query(value="SELECT ad From ArticleDetail ad where ad.journalId=:journalId and ad.article_pages is not NULL AND ad.withdrawStatus = 'N'" )
	 CopyOnWriteArrayList<ArticleDetail> getArticleListbyJrIdGetPage(Integer journalId);
	 
	 @Query(value="SELECT ad From ArticleDetail ad where ad.journalId=:journalID and ad.article_id=:articalId and ad.article_pages is not NULL  AND ad.withdrawStatus = 'N'" )
	List<ArticleDetail> getArticleListbyJrIdGetPage(Integer journalID, Integer articalId);

	 @Query(value = "SELECT ad FROM ArticleDetail ad WHERE ad.withdrawStatus = 'Y'")
		List<ArticleDetail> getwithdrawRejected();

	//master reports query
	 @Query(value=" SELECT new com.digi.unitouch.vo.ArticleTaskDetailsVO(ad.article_id,ad.article_title,ad.article_doi,ad.aid,ad.article_type_cd, j.journalName,cs.task_id,ad.withdrawStatus,td.taskName,ad.accepted_date,atd.fName,atd.lName,j.journalAbbrName,atd.eMail,ad.article_pages) FROM ArticleDetail ad "
			  + "JOIN Journal j ON j.journalId=ad.journalId " 
			  + "JOIN com.digi.unitouch.model.CurrentArticleStatus cs ON cs.article_id = ad.article_id "
			  + "JOIN com.digi.unitouch.model.AuthorArticleDetails atd ON atd.article_id = ad.article_id "
		//	  + "JOIN com.digi.unitouch.model.Users u ON u.userID = atd.user_id "
			  + "JOIN com.digi.unitouch.model.TaskDetails td ON td.id = cs.task_id AND ad.withdrawStatus IN('N','EDITOR_REJECTED')  GROUP BY ad.article_id")
	 CopyOnWriteArrayList<ArticleTaskDetailsVO> getarticleMasterDetail();

	
	  
  }
 