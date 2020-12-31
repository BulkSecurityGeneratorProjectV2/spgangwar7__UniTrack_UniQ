package com.digi.unitouch.serviceImpl;

import java.util.Arrays;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.digi.unitouch.model.IssueSequence;
import com.digi.unitouch.model.IssueSequencePublicationHistory;
import com.digi.unitouch.repository.IssueArticleRepo;
import com.digi.unitouch.repository.IssueSequencePublicationHistoryRepo;
import com.digi.unitouch.repository.IssueSequenceRepo;
import com.digi.unitouch.service.IssueSequenceService;

@Service
@Transactional
public class IssueSequenceServiceImpl implements IssueSequenceService {

	@Autowired
	IssueSequenceRepo issueSequenceRepo;
	@Autowired
	IssueArticleRepo issueArticleRepo;

	@Autowired
	IssueSequencePublicationHistoryRepo issueSequencePublicationHistoryRepo;

	@Override
	public void SaveAll(List<IssueSequence> issueSequence) {
		issueSequenceRepo.saveAll(issueSequence);
	}

	@Override
	public Integer Save(IssueSequence issueSequence) {
		System.out.println(issueSequence);
		issueSequenceRepo.saveAndFlush(issueSequence);
		return issueSequence.getIspId();
	}

	@Override
	public List<IssueSequence> getAllElements(Integer issueId) {

		return issueSequenceRepo.findByIssueId(issueId);
	}

	@Override
	public List<IssueSequence> getIssue(Integer issue_id, Integer journalId) {
		return issueSequenceRepo.fildbyIssueIDAndJId(issue_id, journalId);
	}

	@Override
	public boolean saveIssueSequencePublicationHistory(List<IssueSequencePublicationHistory> issueHistory) {
		try {
			issueSequencePublicationHistoryRepo.saveAll(issueHistory);
			return true;
		} catch (Exception e) {
			return false;
		}
	}
	@Override
	public IssueSequencePublicationHistory getOne(Integer pkid) {
		return issueSequencePublicationHistoryRepo.getOne(pkid);
	}

	@Override
	@Transactional
	public boolean deleteFromIssuePublication(Integer issueID) {
		try {
			issueSequenceRepo.deleteByIssueID(issueID);
			issueArticleRepo.deleteByIssueID(issueID);
			return true;
		} catch (Exception e) {
			return false;
		}
	}
@Override
	public List<IssueSequence> getAllList(){
		return issueSequenceRepo.findAll();
	}

	@Override
	public IssueSequence getLastPageNumberIssue(Integer issue_id, Integer journalId) {
		List<IssueSequence> isseuSeq = issueSequenceRepo.fildbyIssueIDAndJId(issue_id, journalId);
		System.out.println(isseuSeq.toString());
		System.out.println("max-->" + isseuSeq.size());
		if(isseuSeq.size()==1) {
			IssueSequence issueSequence = isseuSeq.get(0);
			return issueSequence;
		}else {
		for(int i=isseuSeq.size()-1;i>=1;i--) {
			if(isseuSeq.get(i).getArticleDoi().equalsIgnoreCase("Remove")) {
				continue;
			}else {
				IssueSequence issueSequence = isseuSeq.get(i);
				return issueSequence;
			}
		}
		}
		return null;
	}

	@Override
	public IssueSequence getLastSeqNoIssue(Integer issue_id, Integer journalId) {
		List<IssueSequence> isseuSeq = issueSequenceRepo.fildbyIssueIDAndJId(issue_id, journalId);
		System.out.println(isseuSeq.toString());
		System.out.println("max-->" + isseuSeq.size());
		IssueSequence issueSequence = isseuSeq.get(isseuSeq.size()-1);
		return issueSequence;
	}
}
