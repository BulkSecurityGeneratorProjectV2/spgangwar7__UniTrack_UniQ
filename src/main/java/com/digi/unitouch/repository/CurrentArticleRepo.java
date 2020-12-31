
  package com.digi.unitouch.repository;
  

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.digi.unitouch.model.CurrentArticleStatus;
  
  public interface CurrentArticleRepo extends JpaRepository<CurrentArticleStatus, Integer> {
	 
	  @Query(value="SELECT * FROM current_article_status cas WHERE cas.task_id=:taskID AND cas.article_id=:aid", nativeQuery = true) 
	  CurrentArticleStatus findCurrentArticleStatusBy(int taskID, int aid);
	  
	  

	  @Query(value="SELECT * FROM current_article_status cas WHERE cas.article_id=:aid", nativeQuery = true)
	CurrentArticleStatus findArticleStatusBy(int aid);


	  
	
  }
 