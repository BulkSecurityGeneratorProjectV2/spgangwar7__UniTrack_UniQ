package com.digi.unitouch.serviceImpl;

import java.util.Arrays;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.digi.unitouch.model.ArticleFileVersionReplace;
import com.digi.unitouch.model.FileVersion;
import com.digi.unitouch.model.IssueFileVersion;
import com.digi.unitouch.repository.ArticleFileVersionReplaceRepo;
import com.digi.unitouch.repository.FileVersionRepo;
import com.digi.unitouch.repository.IssueFileVersionRepo;
import com.digi.unitouch.service.FileVersionService;

@Service
@Transactional
public class FileVersionServiceImpl implements FileVersionService {
	@Autowired
	FileVersionRepo fileRepo;
	@Autowired
	IssueFileVersionRepo issueFileVersionRepo;
	@Autowired
	ArticleFileVersionReplaceRepo articleFileVersionReplaceRepo;

	@Override
	public void saveFileVersion(FileVersion fileVesion) {
		fileRepo.save(fileVesion);

	}
	@Override
	public FileVersion getOne(int fileID) {
		// TODO Auto-generated method stub
		return fileRepo.getOne(fileID);
	}
	@Override
	public List<FileVersion> findbyAidJidTid(Integer articleId, Integer journalId, Integer taskId) {
		List<FileVersion> fileV = fileRepo.findByArticleIdAndJournalIdAndTaskId(articleId, journalId, taskId);
		int[] version = new int[fileV.size()];
		int i = 0;
		// int max = version[0];
		for (FileVersion fileVersion : fileV) {
			version[i] = fileVersion.getFileVersion();
			i++;
		}
		if (version.length == 0) {
			return fileV;
		} else {
			int maxVersion = Arrays.stream(version).max().getAsInt();
			for (FileVersion maxFileVersion : fileV) {
				if (maxFileVersion.getFileVersion() == maxVersion) {
					System.out.println("maxmaxVersion :: " + maxFileVersion);
				}

			}
//		for (int v = 0; v < version.length; v++) {
//			if (version[v] > max) {
//				max = version[v];
//			}
//		}
			System.out.println("  :: " + maxVersion);
			return fileV;
		}
	}

	@Override
	public List<FileVersion> findbyAidJid(Integer article_id, Integer journalId) {
		
		List<FileVersion> fileV = fileRepo.findByArticleIdAndJournalId(article_id, journalId);
		
		return fileV;
		
	}
	
	@Override
	public int maxVersionArticleIdAndJournalId(Integer article_id, Integer journalId) {
		int maxnum = 1;
		try {
			maxnum = fileRepo.maxVersionArticleIdAndJournalId(article_id, journalId);
			return maxnum;
		} catch (Exception e) {
			return maxnum;
		}
	}

	@Override
	public int maxVersionIssueIdAndJournalId(Integer issueId, Integer journalId) {
		int maxnum = 1;
		try {
			maxnum = issueFileVersionRepo.maxVersionIssueIdAndJournalId(issueId, journalId);
			return maxnum;
		} catch (Exception e) {
			return maxnum;
		}
	}

	
	@Override
	public List<FileVersion> findbymaxFileVersion(Integer article_id, Integer journalId) {
		List<FileVersion> fileV = fileRepo.findByArticleIdAndJournalId(article_id, journalId);
		int[] version = new int[fileV.size()];
		int i = 0;
		// int max = version[0];
		for (FileVersion fileVersion : fileV) {
			version[i] = fileVersion.getFileVersion();
			i++;
		}
		if (version.length == 0) {
			return fileV;
		} else {
			int maxVersion = Arrays.stream(version).max().getAsInt();
			for (FileVersion maxFileVersion : fileV) {
				if (maxFileVersion.getFileVersion() == maxVersion) {
					System.out.println("maxmaxVersion :: " + maxFileVersion);
				}

			}
			System.out.println("  :: " + maxVersion);
			return fileV;
		}
	
	}

	@Override
	public boolean saveIssueFileVersion(IssueFileVersion fileVersion) {
	
			issueFileVersionRepo.saveAndFlush(fileVersion);
			return true;
	
	}

	@Override
	public Integer saveIssueFileVersionID(IssueFileVersion fileVersion) {
	
			issueFileVersionRepo.saveAndFlush(fileVersion);
			return fileVersion.getId();
	
	}
	@Override
	public List<IssueFileVersion> findbyissueIdJid(Integer issue_id, Integer journalId) {
	List<IssueFileVersion> fileV = issueFileVersionRepo.findByIssueIdAndJournalId(issue_id, journalId);
		
		return fileV;
	}
	@Override
	public void saveArticleFileVersionReplaceRepo(ArticleFileVersionReplace articleFileVersionReplace) {
		// TODO Auto-generated method stub
		articleFileVersionReplaceRepo.save(articleFileVersionReplace);
	}
	@Override
	public List<IssueFileVersion> findByIssueIdAndJournalIdAndFileName(Integer issue_id, Integer journalId,
			String fileName) {
		// TODO Auto-generated method stub
		return issueFileVersionRepo.getbyFilename(issue_id, journalId, fileName);
	}



}
