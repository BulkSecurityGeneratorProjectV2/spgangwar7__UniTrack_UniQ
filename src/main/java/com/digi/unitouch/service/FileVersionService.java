package com.digi.unitouch.service;

import java.util.List;

import com.digi.unitouch.model.ArticleFileVersionReplace;
import com.digi.unitouch.model.FileVersion;
import com.digi.unitouch.model.IssueFileVersion;

public interface FileVersionService {

	public void saveFileVersion(FileVersion fileVesion);
	
	public List<FileVersion> findbyAidJidTid(Integer articleId,Integer journalId,Integer taskId);

	public List<FileVersion> findbyAidJid(Integer article_id, Integer journalId);
	
	public List<FileVersion> findbymaxFileVersion(Integer article_id, Integer journalId);

	public boolean saveIssueFileVersion(IssueFileVersion fileVersion);
	
	public List<IssueFileVersion> findbyissueIdJid(Integer issue_id, Integer journalId);

	public FileVersion getOne(int fileID);
	
	//bkp file replace
	public void saveArticleFileVersionReplaceRepo(ArticleFileVersionReplace articleFileVersionReplace);

	Integer saveIssueFileVersionID(IssueFileVersion fileVersion);
	
	List<IssueFileVersion> findByIssueIdAndJournalIdAndFileName(Integer issue_id, Integer journalId,String fileName);

	int maxVersionArticleIdAndJournalId(Integer article_id, Integer journalId);
	
	int maxVersionIssueIdAndJournalId(Integer issueId, Integer journalId);
	
	
}
