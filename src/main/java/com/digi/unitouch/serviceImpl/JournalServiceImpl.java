package com.digi.unitouch.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.digi.unitouch.model.Journal;
import com.digi.unitouch.repository.JournalRepo;
import com.digi.unitouch.service.JournalService;
import com.digi.unitouch.vo.TasksSpecificJournal;
@Service
public class JournalServiceImpl implements JournalService {

	@Autowired
	JournalRepo journalRepo;

	@Override
	public List<Journal> getallList() {
		return journalRepo.getAlljournalList();
	}

	@Override
	public Journal getjournalbyId(Integer journalId) {
		return journalRepo.getjournalbyId(journalId);
	}

	@Override
	public Journal getJournalNameby(int jrID) {
		return journalRepo.getJournalNameby(jrID);
	}

	@Override
	public Integer savejournal(Journal journal) {
		journalRepo.saveAndFlush(journal);
		return journal.getJournalId();		
	}

	@Override
	public Journal getJournalbyabbrname(String journalAbbrName) {
		return journalRepo.getJournalbyabbrname(journalAbbrName);
	}

	@Override
	public List<Journal> getjournalList() {
		return journalRepo.getjournalList();
	}
	
	@Override
	public List<Journal> getjournalListForIssue() {
		return journalRepo.getjournalListForIssue();
	}

	@Override
	public List<TasksSpecificJournal> getTaskStatusByJournal() {
		
		return journalRepo.getTaskStatusByJournal();
	}

	@Override
	public Journal getJournalbyTitle(String journalAcronym, String journalTitle) {
		// TODO Auto-generated method stub
		return journalRepo.getJournalbyTitle(journalAcronym,journalTitle);
	}
	@Override
	public Journal getJournalname(String journalTitle) {
		return journalRepo.getJournalName(journalTitle);
	}

	@Override
	public Journal getjournalForIssue(int jrid) {

		return journalRepo.getjournalForIssue(jrid);
	}

}
