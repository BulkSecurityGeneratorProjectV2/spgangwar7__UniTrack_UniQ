package com.digi.unitouch.service;

import java.util.List;

import com.digi.unitouch.model.AuthorArticleDetails;

public interface AuthorArticleService {

	public String save(AuthorArticleDetails author);
	
	public List<AuthorArticleDetails> fileByArticleId(Integer articleId)	;
	
	public AuthorArticleDetails getByArticleIdAndAuthorEmail(Integer articleId, String email);
}
