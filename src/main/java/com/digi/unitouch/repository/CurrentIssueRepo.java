
package com.digi.unitouch.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.digi.unitouch.model.CurrentIssueStatus;

public interface CurrentIssueRepo extends JpaRepository<CurrentIssueStatus, Integer> {

	@Query(value = "SELECT cis FROM CurrentIssueStatus cis WHERE cis.taskId=:taskID AND cis.issueId=:issueID")
	CurrentIssueStatus findCurrentIssueStatusBy(int taskID, int issueID);

	@Query(value = "SELECT cis FROM CurrentIssueStatus cis WHERE cis.issueId=:issueID")
	CurrentIssueStatus findIssuetatusById(int issueID);

}
