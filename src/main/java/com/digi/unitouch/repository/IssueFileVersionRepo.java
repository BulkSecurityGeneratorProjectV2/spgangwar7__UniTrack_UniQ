package com.digi.unitouch.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.digi.unitouch.model.IssueFileVersion;


public interface IssueFileVersionRepo extends JpaRepository<IssueFileVersion, Integer> {

	List<IssueFileVersion> findByIssueIdAndJournalId(Integer issue_id, Integer journalId);
	
	@Query(value="SELECT * FROM issue_file_version WHERE issue_id=:issue_id AND journal_id=:journalId AND file_Name=:file_Name",nativeQuery=true)
	List<IssueFileVersion> getbyFilename(Integer issue_id, Integer journalId,String file_Name);

	@Query(value = "SELECT MAX(fileVersion) FROM IssueFileVersion WHERE issueId=:issueId AND journalId=:journalId")
	int maxVersionIssueIdAndJournalId(Integer issueId, Integer journalId);

}
