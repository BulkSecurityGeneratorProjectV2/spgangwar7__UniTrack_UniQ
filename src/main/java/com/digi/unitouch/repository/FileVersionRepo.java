package com.digi.unitouch.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.digi.unitouch.model.FileVersion;

public interface FileVersionRepo extends JpaRepository<FileVersion, Integer> {

	List<FileVersion> findByArticleIdAndJournalIdAndTaskId(Integer articleId, Integer journalId, Integer taskId);

	List<FileVersion> findByArticleIdAndJournalId(Integer article_id, Integer journalId);

	@Query(value = "SELECT MAX(fileVersion) FROM FileVersion WHERE articleId=:article_id AND journalId=:journalId")
	public int maxVersionArticleIdAndJournalId(Integer article_id, Integer journalId);

}
