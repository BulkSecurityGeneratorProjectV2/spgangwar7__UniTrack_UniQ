package com.digi.unitouch.serviceImpl;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.digi.unitouch.model.IssueTaskDetail;
import com.digi.unitouch.repository.IssueTaskDetailRepo;
import com.digi.unitouch.service.IssueTaskDetailService;

@Service
@Transactional
public class IssueTaskDetailServiceImpl implements IssueTaskDetailService{

	@Autowired
	IssueTaskDetailRepo issueTaskDetailRepo;
	@Override
	public IssueTaskDetail getIssueTaskScheById(Integer taskID) {
		
		return issueTaskDetailRepo.findtaskDetailById(taskID);
	}
	@Override
	public void saveIssueTaskDetail(IssueTaskDetail issueTaskDetail) {
		issueTaskDetailRepo.save(issueTaskDetail);
		
	}
	@Override
	public IssueTaskDetail getIssueTaskScheById(int taskId, int issueId) {
		// TODO Auto-generated method stub
		return issueTaskDetailRepo.getIssueTaskScheById(taskId,issueId);
	}

}
