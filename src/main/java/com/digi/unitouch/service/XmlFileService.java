package com.digi.unitouch.service;

import java.util.List;
import java.util.Optional;

import com.digi.unitouch.model.XmlFilePath;

public interface XmlFileService {

	public List<XmlFilePath> getAllList();
	
	public Optional<XmlFilePath> findById(Integer xmlId);
	
	public List<XmlFilePath> findByAidAndTaskId(Integer aid, Integer taskID);
	
	public void saveXmlPath(XmlFilePath xmlFilePath);
}
