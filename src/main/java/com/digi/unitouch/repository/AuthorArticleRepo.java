package com.digi.unitouch.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.digi.unitouch.model.AuthorArticleDetails;
@Repository
public interface AuthorArticleRepo extends JpaRepository<AuthorArticleDetails, Integer> {

	
	@Query("Select aad from AuthorArticleDetails aad where aad.article_id=:articleId")
	List<AuthorArticleDetails> getByArticleId(Integer articleId);
	
	@Query("Select aad from AuthorArticleDetails aad where aad.article_id=:articleId and aad.eMail=:email")
	AuthorArticleDetails getByArticleIdAndAuthorEmail(Integer articleId, String email);

}
