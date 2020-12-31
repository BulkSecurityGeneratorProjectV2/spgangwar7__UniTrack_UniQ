package com.digi.unitouch.service;

import java.util.Optional;

import com.digi.unitouch.model.EmailJournalWorkflow;

public interface EmailJournalWorkflowService {

	public Integer saveEmailJournalWorkflow(EmailJournalWorkflow emailJournalWorkflow);
	
	public  Optional<EmailJournalWorkflow> findById(Integer ejwId);
	
	public  EmailJournalWorkflow findByejwt(Integer jId,Integer wId,Integer tId);
	
//	public EmailJournalWorkflow findByTaskId(Integer taskID);

	EmailJournalWorkflow getOne(Integer ejwId);

	
}
