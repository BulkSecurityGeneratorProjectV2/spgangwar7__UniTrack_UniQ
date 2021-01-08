package com.digi.unitouch.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.digi.unitouch.model.FileVersion;

public interface FileVersionRepo extends JpaRepository<FileVersion, Integer> {

	List<FileVersion> findByArticleIdAndJournalIdAndTaskId(Integer articleId, Integer journalId, Integer taskId);

	List<FileVersion> findByArticleIdAndJournalId(Integer article_id, Integer journalId);

	@Query(value = "SELECT MAX(fileVersion) FROM FileVersion WHERE articleId=:article_id AND journalId=:journalId")
	public Integer maxVersionArticleIdAndJournalId(Integer article_id, Integer journalId);
	
	@Query(value = "SELECT sum(queInFile) FROM FileVersion")
	public Integer maxArticleIdAndJournalId();

	@Query(value = "SELECT fv FROM FileVersion fv where fv.created_by=:userId")
	List<FileVersion> getbyuserid(Integer userId);
	
	@Query(value = "SELECT sum(queInFile) FROM FileVersion fv where fv.created_by=:userId")
	public Integer getSumbyUserid(Integer userId);

}
