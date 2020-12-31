package com.digi.unitouch.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.digi.unitouch.model.EmailTrigger;

public interface EmailTriggerRepo extends JpaRepository<EmailTrigger, Integer> {
	
	@Query("SELECT ajwt FROM EmailTrigger ajwt WHERE ajwt.articleId=?1 and ajwt.taskId=?2 ")
	EmailTrigger findByAJWT(int aid, int taskID);
	
	@Modifying(clearAutomatically = true)
	@Query("update EmailTrigger ajwt set ajwt.isActive=1 where ajwt.articleId=:articleId and ajwt.taskId=:taskId")
	void updateisactive(Integer articleId, Integer taskId);
	
	@Query("SELECT ajwt FROM EmailTrigger ajwt WHERE ajwt.articleId=?1 and ajwt.taskId=?2 AND  ajwt.isActive = 0 ")
	EmailTrigger getArticleIdAndTaskId(Integer articleId, Integer taskId);

	@Query("SELECT ajwt FROM EmailTrigger ajwt")
	List<EmailTrigger> getallDetails();
	
	@Query("SELECT ajwt FROM EmailTrigger ajwt WHERE ajwt.isActive = 0")
	List<EmailTrigger> getallDetailsMail();

	@Query("SELECT ajwt FROM EmailTrigger ajwt WHERE ajwt.articleId=?1 and ajwt.taskId=?2 ")
	List<EmailTrigger> getListArticleIdAndTaskId(Integer i, Integer s);

}
