package com.digi.unitouch.service;

import java.util.List;

import com.digi.unitouch.model.ErrorProcess;

public interface ErrorProcessService {

	public List<ErrorProcess> getAllErrorList();

	public void errorSave(ErrorProcess errorProcess);

	public List<ErrorProcess> ErrorbyTaskId(Integer taskid);
}
