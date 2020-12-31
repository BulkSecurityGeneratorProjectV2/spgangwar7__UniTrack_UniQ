package com.digi.unitouch.serviceImpl;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.digi.unitouch.model.CurrentIssueStatus;
import com.digi.unitouch.repository.CurrentIssueRepo;
import com.digi.unitouch.service.CurrentIssueService;

@Service
@Transactional
public class CurrentIssueServiceImpl implements CurrentIssueService {

	@Autowired
	CurrentIssueRepo currentIssueRepo;

	@Override
	public Integer saveCurrentIssueS(CurrentIssueStatus currentIssueStatus) {
		currentIssueRepo.save(currentIssueStatus);
		return currentIssueStatus.getCis_id();
	}

	@Override
	public CurrentIssueStatus findCurrentIssueStatusBy(int taskID, int issueId) {
		return currentIssueRepo.findCurrentIssueStatusBy(taskID, issueId);
	}

	@Override
	public CurrentIssueStatus findIssuetatusById(int issueId) {
		return currentIssueRepo.findIssuetatusById(issueId);

	}
}