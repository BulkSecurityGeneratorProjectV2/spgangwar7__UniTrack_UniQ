package com.digi.unitouch.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.digi.unitouch.model.Journal;
import com.digi.unitouch.vo.DepartmentsTask;
import com.digi.unitouch.vo.TasksSpecificJournal;

public interface JournalRepo extends JpaRepository<Journal, Integer> {
	
	@Query(value="SELECT * FROM journals u WHERE u.journal_id=:journalId", nativeQuery = true) 
	Journal getjournalbyId(Integer journalId);

	@Query(value="SELECT * FROM journals j WHERE j.journal_id=:jrID", nativeQuery = true)
	Journal getJournalNameby(int jrID);

	@Query(value="SELECT * FROM journals u WHERE u.journal_abbr_name=:journalAbbrName", nativeQuery = true) 
	Journal getJournalbyabbrname(String journalAbbrName);
	
	@Query(value="SELECT u FROM Journal u WHERE u.journalAbbrName=?1 or u.journalName=?2") 
	Journal getJournalbyTitle(String jAbbr,String jName);

	@Query(value="SELECT u FROM Journal u WHERE u.articleWorkflowId!='0' order by u.journalName") 
	List<Journal> getjournalList();
	
	@Query(value="SELECT u FROM Journal u WHERE u.issueWorkflowId!='0' order by u.journalName") 
	List<Journal> getjournalListForIssue();
	
	@Query(value="SELECT u FROM Journal u WHERE u.issueWorkflowId!='0' and u.status is 'Active' and u.journalId=:jrID order by u.journalName") 
	public Journal getjournalForIssue(int jrID);
		
	@Query(value="SELECT u FROM Journal u where u.status is 'Active' order by u.journalName") 
	List<Journal> getAlljournalList();
	
	@Query(value = "SELECT new com.digi.unitouch.vo.TasksSpecificJournal(COUNT(ast.task_status) AS taskCount ,"
			+ "j.journalId, j.journalName ,t.id, t.taskName, ast.task_status)"
			+ " FROM ArticleDetail  ad "
			+ "JOIN com.digi.unitouch.model.Journal j ON j.journalId=ad.journalId "
			+ " JOIN com.digi.unitouch.model.TaskScheduler ast ON ast.article_id=ad.article_id  " 
			+ "JOIN com.digi.unitouch.model.TaskDetails t ON t.id=ast.task_id"
			+ " GROUP BY j.journalName,j.journalId,t.taskName,t.id")
	List<TasksSpecificJournal> getTaskStatusByJournal();

	@Query(value="SELECT u FROM Journal u WHERE  u.journalName=?1") 
	Journal getJournalName(String journalTitle);
	
	
}
