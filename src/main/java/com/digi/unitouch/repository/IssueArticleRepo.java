package com.digi.unitouch.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.digi.unitouch.model.IssueArticle;

public interface IssueArticleRepo extends JpaRepository<IssueArticle, Integer> {

	@Query(value = "SELECT ia From IssueArticle ia where ia.issueId=?1")
	List<IssueArticle> getArticleByIssueId(Integer issueID);
	
	@Query(value = "SELECT ia From IssueArticle ia where ia.articleId=?1")
	List<IssueArticle> getIssueByarticleID(Integer articleID);
	
	@Modifying(clearAutomatically = true)
	@Query(value="delete from IssueArticle ia WHERE ia.issueId=?1")
	void deleteByIssueID(int issueId);

}
