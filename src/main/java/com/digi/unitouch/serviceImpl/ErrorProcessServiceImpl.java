package com.digi.unitouch.serviceImpl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.digi.unitouch.model.ErrorProcess;
import com.digi.unitouch.repository.ErrorProcessRepo;
import com.digi.unitouch.service.ErrorProcessService;

@Service
@Transactional
public class ErrorProcessServiceImpl implements ErrorProcessService {

	@Autowired
	ErrorProcessRepo errorProcessrepo;

	@Override
	public List<ErrorProcess> getAllErrorList() {
		return errorProcessrepo.findAll();
	}

	@Override
	public List<ErrorProcess> ErrorbyTaskId(Integer taskid) {

		return errorProcessrepo.findByTaskId(taskid);
	}

	@Override
	public void errorSave(ErrorProcess errorProcess) {
		errorProcessrepo.save(errorProcess);
	}

}
