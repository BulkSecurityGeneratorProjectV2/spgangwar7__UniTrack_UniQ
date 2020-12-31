package com.digi.unitouch.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.digi.unitouch.model.AuthorArticleDetails;
import com.digi.unitouch.repository.AuthorArticleRepo;
import com.digi.unitouch.service.AuthorArticleService;

@Service

public class AuthorArticleServiceImpl implements AuthorArticleService {

	@Autowired
	AuthorArticleRepo authorRepo;

	@Override
	public String save(AuthorArticleDetails author) {
		authorRepo.save(author);
		return "author Save Successfully";
	}

	@Override
	public List<AuthorArticleDetails> fileByArticleId(Integer articleId) {
		return authorRepo.getByArticleId(articleId);
	}

	@Override
	public AuthorArticleDetails getByArticleIdAndAuthorEmail(Integer articleId, String email) {
		// TODO Auto-generated method stub
		return authorRepo.getByArticleIdAndAuthorEmail(articleId, email);
	}

}
