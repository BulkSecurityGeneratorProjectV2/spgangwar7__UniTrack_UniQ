package com.digi.unitouch.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.digi.unitouch.model.IssueSequence;

public interface IssueSequenceRepo extends JpaRepository<IssueSequence, Integer> {

	List<IssueSequence> findByIssueId(Integer issueId);

	@Query(value="SELECT isq from IssueSequence isq WHERE isq.issueId=?1 and isq.jId=?2")
	List<IssueSequence> fildbyIssueIDAndJId(Integer issue_id, Integer journalId);
	
	@Query(value="SELECT isq from IssueSequence isq WHERE isq.issueId=?1")
	List<IssueSequence> fildbyIssueIDAndJId(Integer issue_id);

	
	@Modifying(clearAutomatically = true)
	@Query(value="delete from IssueSequence ia WHERE ia.issueId=?1")
	void deleteByIssueID(int issueId);
	

}
