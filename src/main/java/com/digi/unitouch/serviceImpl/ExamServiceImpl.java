package com.digi.unitouch.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.digi.unitouch.model.ExamDetails;
import com.digi.unitouch.repository.ExamDetailsRepo;
import com.digi.unitouch.service.ExamService;
@Service
public class ExamServiceImpl implements ExamService {

	@Autowired
	ExamDetailsRepo examDetailsRepo;

	@Override
	public ExamDetails saveExam(ExamDetails examDetails) {
		ExamDetails ExamDetail = examDetailsRepo.save(examDetails);
		return ExamDetail;
	}

	@Override
	public List<ExamDetails> getAllExamList() {
		return examDetailsRepo.findAll();
	}

}
