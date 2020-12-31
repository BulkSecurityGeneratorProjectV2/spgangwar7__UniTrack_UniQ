package com.digi.unitouch.serviceImpl;

import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.digi.unitouch.model.EmailJournalWorkflow;
import com.digi.unitouch.repository.EmailJournalWorkflowRepo;
import com.digi.unitouch.service.EmailJournalWorkflowService;

@Service
@Transactional
public class EmailJournalWorkflowImpl implements EmailJournalWorkflowService {

	@Autowired
	EmailJournalWorkflowRepo emailJournalWorkflowRepo;

	@Override
	public EmailJournalWorkflow getOne(Integer ejwId) {
		return emailJournalWorkflowRepo.getOne(ejwId);
	}
	@Override
	@Transactional
	public Integer saveEmailJournalWorkflow(EmailJournalWorkflow emailJournalWorkflow) {
		emailJournalWorkflowRepo.save(emailJournalWorkflow);
		return emailJournalWorkflow.getEjwId();
	}

	@Override
	public Optional<EmailJournalWorkflow> findById(Integer ejwId) {
		return emailJournalWorkflowRepo.findById(ejwId);
	}

	@Override
	public EmailJournalWorkflow findByejwt(Integer jId, Integer wId, Integer tId) {

		return emailJournalWorkflowRepo.findByejwt(jId, wId, tId);
	}
	
//	@Override
//	public EmailJournalWorkflow findByTaskId(Integer taskID){
//		return null;
//	}

	
}
