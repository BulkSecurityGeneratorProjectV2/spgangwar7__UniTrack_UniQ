package com.digi.unitouch.service;

import java.util.List;

import com.digi.unitouch.model.IssueComment;
import com.digi.unitouch.model.IssueDetail;
import com.digi.unitouch.vo.IssueSearchDetailvo;
import com.digi.unitouch.vo.IssueTaskManagementVo;

public interface IssueDetailService {

	Integer saveIssue(IssueDetail issueDetail);

	IssueDetail findByIssueTitle(String issueTitle, Integer journalId);

	List<IssueDetail> getIsuuelistbyJournalId(Integer journalId);

	IssueDetail getIsuuelistbyid(Integer issue_id);

	List<IssueDetail> getAllList();

	List<IssueTaskManagementVo> getIssueTaskManagementGroupList(Integer workflowId, Integer journalId, Integer taskId);

	List<IssueTaskManagementVo> getIssueTaskManagementList(Integer userID);

	IssueTaskManagementVo findGroupTaskByArticleId(int id);

	public List<IssueSearchDetailvo> getIssueSearchDetailList(int issueID);

	void IssueCommentSave(IssueComment comments);

	List<IssueComment> getIssueCommentsList(Integer journalId, Integer issueId);

	IssueDetail getIsuuelistbyJournalIdWithSeq(Integer journalId, Integer seqNo);

	IssueDetail getMaxIssSeqJournalId(Integer journalId);

	List<IssueTaskManagementVo> getIssueallTaskManagementList();

	List<IssueDetail> getIsuuelist();

	List<IssueDetail> getIsuueStatusListbyJournalId(Integer journalId);

}
