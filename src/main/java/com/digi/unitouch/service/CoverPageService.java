package com.digi.unitouch.service;

import com.digi.unitouch.model.CoverPage;

public interface CoverPageService {

	Integer saveCoverPage(CoverPage coverPage);
	
	CoverPage findBycovID(Integer covID);
	
}
