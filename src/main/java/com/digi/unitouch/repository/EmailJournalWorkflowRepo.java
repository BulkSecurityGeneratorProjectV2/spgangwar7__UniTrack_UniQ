package com.digi.unitouch.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.digi.unitouch.model.EmailJournalWorkflow;

public interface EmailJournalWorkflowRepo extends JpaRepository<EmailJournalWorkflow, Integer>{


	@Query(value="SELECT ejw FROM  EmailJournalWorkflow ejw WHERE ejw.jrid=:jId and ejw.wkid=:wId and ejw.taskId=:tId ")
	public EmailJournalWorkflow findByejwt( Integer jId, Integer wId, Integer tId);

	public EmailJournalWorkflow findByTaskId(Integer taskId);
}
