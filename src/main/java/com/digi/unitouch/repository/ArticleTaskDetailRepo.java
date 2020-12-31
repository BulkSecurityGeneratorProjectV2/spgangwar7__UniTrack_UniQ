
  package com.digi.unitouch.repository;
  

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.digi.unitouch.model.ArticleTaskDetail;
import com.digi.unitouch.model.TaskDetails;
  
  public interface ArticleTaskDetailRepo extends JpaRepository<ArticleTaskDetail, Integer> {
	
	/*
	 * @Query("SELECT atd FROM ArticleTaskDetail atd WHERE atd.user_id=:uid")
	 * List<TaskDetails> getAlltaskList(int uid);
	 */
  //  @Query(value = "SELECT * FROM article_tasks_details ast WHERE ast.user_id='4'", nativeQuery = true) 
  //  List<TaskDetails> getAlltaskList(int uid);
    

	  @Query(value="SELECT * FROM article_tasks_details atd WHERE atd.article_task_id=:artiTaskId", nativeQuery = true)
	  ArticleTaskDetail findtaskDetailById(int artiTaskId);

	  
	  //under working for 30 day productivity
	@Query(value = "SELECT COUNT(atd.`completed_date_time`) as article_task_dtl_id  , atd.`article_id` as article_id ,atd.`article_task_id` as article_task_id ,atd.`task_status` as task_status ,"
			+ " atd.completed_date_time  as completed_date_time FROM article_tasks_details  atd \r\n"
			+ "WHERE atd.`user_id`=:userID AND `task_status`='Completed' AND atd.completed_date_time BETWEEN (CURRENT_DATE() - INTERVAL 1 MONTH) \r\n"
			+ "AND CURRENT_DATE() GROUP BY DATE(atd.`completed_date_time`) ;", nativeQuery = true)
	List<ArticleTaskDetail> findUserWiseProductivity(Integer userID);

	@Query(value="SELECT * FROM article_tasks_details atd WHERE atd.article_task_id=:taskID and atd.article_id=:aid", nativeQuery = true)
	ArticleTaskDetail findtaskDetailById(int taskID, Integer aid);


	@Query("SELECT atd FROM ArticleTaskDetail atd WHERE atd.task_status LIKE %:status%")
	List<ArticleTaskDetail> getTotalcountByStatus(String status);	
  }
 