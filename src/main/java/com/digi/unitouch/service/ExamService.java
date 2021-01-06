package com.digi.unitouch.service;

import java.util.List;

import com.digi.unitouch.model.ExamDetails;

public interface ExamService {

	
	public ExamDetails saveExam(ExamDetails examDetails);

	public List<ExamDetails> getAllExamList();
}
