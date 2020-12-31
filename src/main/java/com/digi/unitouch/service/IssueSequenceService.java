package com.digi.unitouch.service;

import java.util.List;

import com.digi.unitouch.model.IssueSequence;
import com.digi.unitouch.model.IssueSequencePublicationHistory;

public interface IssueSequenceService {

	public Integer  Save(IssueSequence issueSequence);

	void SaveAll(List<IssueSequence> issueSequence);

	List<IssueSequence> getAllElements(Integer issueId);

	public List<IssueSequence> getIssue(Integer issue_id, Integer journalId);
	
	public IssueSequence getLastPageNumberIssue(Integer issue_id, Integer journalId);
	
	public IssueSequence getLastSeqNoIssue(Integer issue_id, Integer journalId);

	boolean saveIssueSequencePublicationHistory(List<IssueSequencePublicationHistory> issueHistory);

	public boolean deleteFromIssuePublication(Integer issueID);
	public List<IssueSequence> getAllList();

	IssueSequencePublicationHistory getOne(Integer pkid);

}
