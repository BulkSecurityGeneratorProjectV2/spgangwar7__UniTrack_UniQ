package com.digi.unitouch.serviceImpl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.digi.unitouch.model.IssueArticle;
import com.digi.unitouch.repository.IssueArticleRepo;
import com.digi.unitouch.service.IssueArticleService;
@Service
@Transactional
public class IssueArticleServiceImpl implements IssueArticleService{

	@Autowired
	IssueArticleRepo issueArticleRepo;
	@Override
	public void SaveIssueArticle(IssueArticle issueArticle) {
		issueArticleRepo.saveAndFlush(issueArticle);
	}
	@Override
	public List<IssueArticle> getArticleFromIssue(Integer issueID) {
		return issueArticleRepo.getArticleByIssueId(issueID);
	}
	@Override
	public List<IssueArticle> getIssueByarticleID(Integer articleID) {
		return issueArticleRepo.getIssueByarticleID(articleID);
	}

}
