package com.digi.unitouch.service;

import java.util.List;

import com.digi.unitouch.model.IssueArticle;

public interface IssueArticleService {

	public void SaveIssueArticle(IssueArticle issueArticle);

	public List<IssueArticle> getArticleFromIssue(Integer issueID);
	
	List<IssueArticle> getIssueByarticleID(Integer articleID);
}
