package com.digi.unitouch.serviceImpl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.digi.unitouch.model.IssueComment;
import com.digi.unitouch.model.IssueDetail;
import com.digi.unitouch.model.IssueSequence;
import com.digi.unitouch.repository.IssueCommentsRepo;
import com.digi.unitouch.repository.IssueDetailRepo;
import com.digi.unitouch.repository.TaskManagementRepo;
import com.digi.unitouch.service.IssueDetailService;
import com.digi.unitouch.vo.IssueSearchDetailvo;
import com.digi.unitouch.vo.IssueTaskManagementVo;
import com.digi.unitouch.vo.TaskManagementVo;

@Service
@Transactional
public  class IssueDetailServiceImpl implements IssueDetailService {

	@Autowired
	IssueDetailRepo issueDetailRepo;
	@Autowired
	IssueCommentsRepo issueCommentsRepo;
	@Autowired
	TaskManagementRepo taskManagementRepo;

	@Override
	public Integer saveIssue(IssueDetail issueDetail) {
		issueDetailRepo.saveAndFlush(issueDetail);
		return issueDetail.getIssue_id();
	}

	@Override
	public List<IssueDetail> getIsuuelistbyJournalId(Integer journalId) {

		return issueDetailRepo.getIsuuelistbyJournalId(journalId);
	}
	@Override
	public List<IssueDetail> getIsuueStatusListbyJournalId(Integer journalId) {

		return issueDetailRepo.getIsuueStatusListbyJournalId(journalId);
	}
	
	@Override
	public IssueDetail getMaxIssSeqJournalId(Integer journalId) {

		List<IssueDetail> issue=issueDetailRepo.getIsuuelistbyJournalId(journalId);
		
		if (issue.size() != 0) {
			IssueDetail issueSeq = issue.get(issue.size() - 1);
			return issueSeq;
		}
		return null;
	}

	@Override
	public IssueDetail getIsuuelistbyid(Integer issue_id) {
		System.out.println("issue :"+issueDetailRepo.getIsuuelistbyid(issue_id));
		return issueDetailRepo.getIsuuelistbyid(issue_id);
	}

	@Override
	public IssueDetail findByIssueTitle(String issueTitle,Integer journalId) {
		return issueDetailRepo.getByIssueTitle(issueTitle,journalId);
	}
	
	@Override
	public List<IssueDetail> getAllList() {
		return issueDetailRepo.findAll();
	}
	@Override
	public List<IssueDetail> getIsuuelist() {
		return issueDetailRepo.getIsuuelist();
	}
	
	@Override
	public List<IssueTaskManagementVo> getIssueTaskManagementGroupList(Integer workflowId, Integer journalId,
			Integer taskId) {
		
		return issueDetailRepo.getIssueTaskManagementGroupList(workflowId, journalId, taskId);
	}

	@Override
	public List<IssueTaskManagementVo> getIssueTaskManagementList(Integer userID) {
		return issueDetailRepo.getmyTaskManagementList(userID);
	}

	@Override
	public IssueTaskManagementVo findGroupTaskByArticleId(int id) {
		return issueDetailRepo.findGroupTaskByArticleId(id);
	}

	@Override
	public List<IssueSearchDetailvo> getIssueSearchDetailList(int issueID) {
	
		return issueDetailRepo.getIssueSearchDetailList(issueID);
	}

	@Override
	public void IssueCommentSave(IssueComment comments) {
		issueCommentsRepo.save(comments);
		
	}

	@Override
	public List<IssueComment> getIssueCommentsList(Integer journalId, Integer issueId) {
		return issueCommentsRepo.getIssueCommentsList(journalId,issueId);
	}

	@Override
	public IssueDetail getIsuuelistbyJournalIdWithSeq(Integer journalId, Integer seqNo) {
		// TODO Auto-generated method stub
		return issueDetailRepo.getIsuuelistbyJournalIdWithSeq(journalId,seqNo);
	}


	public List<IssueTaskManagementVo> getIssueallTaskManagementList() {
		return issueDetailRepo.getTotalIssue();
	}

}
