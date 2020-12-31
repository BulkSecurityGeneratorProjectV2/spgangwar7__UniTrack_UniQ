package com.digi.unitouch.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.digi.unitouch.model.EmailTrigger;
import com.digi.unitouch.model.IssueEmailTrigger;

public interface IssueEmailTriggerRepo extends JpaRepository<IssueEmailTrigger, Integer> {
	
	@Query("SELECT ajwt FROM IssueEmailTrigger ajwt WHERE ajwt.issueId=?1 and ajwt.taskId=?2 ")
	IssueEmailTrigger findByAJWT(int aid, int taskID);
	
	@Modifying(clearAutomatically = true)
	@Query("update IssueEmailTrigger ajwt set ajwt.isActive=1 where ajwt.issueId=:articleId and ajwt.taskId=:taskId")
	void updateisactive(Integer articleId, Integer taskId);
	
	@Query("SELECT ajwt FROM IssueEmailTrigger ajwt WHERE ajwt.issueId=?1 and ajwt.taskId=?2 and ajwt.isActive = 0")
	IssueEmailTrigger getArticleIdAndTaskId(Integer articleId, Integer taskId);

	@Query("SELECT ajwt FROM IssueEmailTrigger ajwt")
	List<IssueEmailTrigger> getallDetails();
	
	@Query("SELECT ajwt FROM IssueEmailTrigger ajwt WHERE ajwt.isActive = 0")
	List<IssueEmailTrigger> getallDetailsMail();

	@Query("SELECT ajwt FROM IssueEmailTrigger ajwt WHERE ajwt.issueId=?1 and ajwt.taskId=?2 ")
	List<IssueEmailTrigger> getListArticleIdAndTaskId(Integer i, Integer s);

}
