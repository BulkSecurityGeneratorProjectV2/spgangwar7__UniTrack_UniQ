package com.digi.unitouch.repository;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.digi.unitouch.model.TaskDetails;

public interface TaskRepo extends JpaRepository<TaskDetails, Integer> {
	/*
	 * SELECT * FROM article_tasks_details ast WHERE ast.user_id='4'
	 * 
	 * @Query("SELECT u FROM Users u WHERE u.userID=:userID") List<TaskDetails>
	 * getAlltaskList(Users users);
	 */
	
	 @Query(value="SELECT * FROM tasks t WHERE t.task_id=:taskID", nativeQuery = true) 
		TaskDetails getTaskNameBy(int taskID);

	 @Query(value="SELECT t FROM TaskDetails t WHERE t.taskName=:taskname") 
		TaskDetails getTaskNameByName(String taskname);
	 
	 @Query(value="SELECT * FROM workflow_task_details wtd JOIN tasks ts ON ts.task_id=wtd.task_id WHERE wtd.workflow_id=:workFlowID AND wtd.sequence<:currentTaskSequence", nativeQuery=true)
	 List<TaskDetails> getPreviousTaskListBy(int workFlowID, int currentTaskSequence);

	 @Query(value="SELECT * FROM workflow_task_details wtd JOIN tasks ts ON ts.task_id=wtd.task_id WHERE wtd.workflow_id=:workFlowID AND wtd.sequence>:currentTaskSequence", nativeQuery=true)
	List<TaskDetails> getnextTaskListBy(int workFlowID, int currentTaskSequence);

	@Query(value = "SELECT task FROM TaskDetails task ")
	public CopyOnWriteArrayList<TaskDetails> getAlltaskListDraft();
}
