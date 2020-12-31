package com.digi.unitouch.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.digi.unitouch.model.ArticleComment;

public interface ArticleCommentRepo extends JpaRepository<ArticleComment, Integer>{

	@Query("SELECT ac FROM ArticleComment ac WHERE ac.jid=:jid AND ac.aid=:aid ORDER BY ac.commentDate DESC")
	List<ArticleComment> getArticleComemntsList(Integer jid, Integer aid);

	@Query("SELECT ac FROM ArticleComment ac WHERE ac.jid=:jid AND ac.aid=:aid AND ac.taskid=:taskid ORDER BY ac.commentDate DESC")
	List<ArticleComment> getTaskArticleCommentsList(Integer jid, Integer aid, Integer taskid);

}
