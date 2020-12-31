package com.digi.unitouch.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.digi.unitouch.model.IssueComment;

public interface IssueCommentsRepo extends JpaRepository<IssueComment, Integer> {

	@Query("SELECT isc FROM IssueComment isc WHERE isc.jid=:journalId AND isc.issueId=:issueId ORDER BY isc.commentDate")
	List<IssueComment> getIssueCommentsList(Integer journalId, Integer issueId);

}
