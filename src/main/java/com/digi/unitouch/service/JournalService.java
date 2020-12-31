package com.digi.unitouch.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.digi.unitouch.model.Journal;
import com.digi.unitouch.vo.TasksSpecificJournal;

public interface JournalService {
	
	//public void createJournal(Journal journal);

	public List<Journal> getallList();

	public Journal getjournalbyId(Integer journalId);

	public Journal getJournalNameby(int jrID);

	public Integer savejournal(Journal journal);

	public Journal getJournalbyabbrname(String journalAbbrName);

	public List<Journal> getjournalList();
	
	public List<TasksSpecificJournal> getTaskStatusByJournal();

	List<Journal> getjournalListForIssue();

	public Journal getJournalbyTitle(String journalAcronym, String journalTitle);

	public Journal getJournalname(String journalTitle);
	
	public Journal getjournalForIssue(int jrid);


}
