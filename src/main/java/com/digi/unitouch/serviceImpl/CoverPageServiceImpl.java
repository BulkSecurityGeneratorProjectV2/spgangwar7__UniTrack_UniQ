package com.digi.unitouch.serviceImpl;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.digi.unitouch.model.CoverPage;
import com.digi.unitouch.repository.CoverPageRepo;
import com.digi.unitouch.service.CoverPageService;

@Service
@Transactional
public class CoverPageServiceImpl implements CoverPageService {

	@Autowired
	CoverPageRepo coverRepo;
	@Override
	public Integer saveCoverPage(CoverPage coverPage) {
		coverRepo.saveAndFlush(coverPage);
		return coverPage.getCov_id();
	}
	@Override
	public CoverPage findBycovID(Integer covID) {
		// TODO Auto-generated method stub
		return coverRepo.getOne(covID);
	}

}
